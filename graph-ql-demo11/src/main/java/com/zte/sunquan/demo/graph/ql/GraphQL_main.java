package com.zte.sunquan.demo.graph.ql;

import java.util.HashMap;
import java.util.Map;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.TypeDefinitionRegistry;

import com.zte.sunquan.demo.graph.fetch.UserFilterDataFetcher;
import com.zte.sunquan.demo.graph.utils.UserRuntimeWiring;
import com.zte.sunquan.demo.graph.utils.UserTypeDefinitionRegistry;

/**
 * GraphQL_main class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class GraphQL_main {
    public static void main(String[] args) {
        TypeDefinitionRegistry typeRegistry = UserTypeDefinitionRegistry.load("user.graphqls");
        RuntimeWiring wiring = UserRuntimeWiring.builder()
                .type("QueryUser", typeWiring -> typeWiring
                        .dataFetcher("filterUser", new UserFilterDataFetcher())
                )
                .build();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();

        //String gql = "query QueryUser{filterUser{id,name}}";
        //String gql = "query QueryUser{filterUser{id,name,vehicle{...on Car{price}}}}";
        String gql = "query QueryUser{filterUser(offset:1,limit:2000){id,name,vehicle{...on Car{price}}}}";
        Map<String, Object> variable = new HashMap<>();
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable)
                .query(gql)
                .build();
        Map<String, Object> result = graphQL.execute(executionInput).toSpecification();
        System.out.println(result);
    }
}
