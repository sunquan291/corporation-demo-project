package com.zte.sunquan.demo.graph.ql;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.antlr.v4.runtime.CharStreams;
import org.springframework.core.io.ClassPathResource;

/**
 * GraphQL_Simple3 class
 *
 * @author 10184538
 * @date 2019/4/4
 */
public class GraphQL_Simple3 {


    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("QueryType",
                        typeWiring -> typeWiring
                                .dataFetcher("filterUser", new DataFetcher() {
                                    @Override
                                    public Object get(DataFetchingEnvironment environment) {
                                        return new User(1, "sunquan");
                                    }
                                })
                ).build();
    }

    public GraphQLSchema graphQLSchema() throws IOException {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        String schemaFileContent = readSchemaFileContent();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFileContent);
        RuntimeWiring wiring = buildRuntimeWiring();

        return schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
    }

    private String readSchemaFileContent() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("user.graphqls");
        try (InputStream inputStream = classPathResource.getInputStream()) {
            return CharStreams.fromReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).toString();
        }
    }

    public static void main(String[] args) throws IOException {
        GraphQL_Simple3 simple3 = new GraphQL_Simple3();
        GraphQLSchema schema = simple3.graphQLSchema();
        GraphQL graphQL = GraphQL.newGraphQL(schema)
                .queryExecutionStrategy(new AsyncExecutionStrategy())
                .build();
        Object data = graphQL.execute("{filterUser{id,name}}").getData();
        System.out.println(data);
    }
}