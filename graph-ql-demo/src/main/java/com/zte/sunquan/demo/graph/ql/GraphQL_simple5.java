package com.zte.sunquan.demo.graph.ql;

import java.io.File;
import java.util.Map;
import java.util.Set;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zte.sunquan.demo.model2.Dog;
import com.zte.sunquan.demo.model2.Position;
import com.zte.sunquan.demo.model2.User2;

/**
 * GraphQL_simple3 class
 *
 * @author 10184538
 * @date 2019/4/4
 */
public class GraphQL_simple5 {

    static Map<Integer, User2> db = Maps.newConcurrentMap();

    static {
        User2 user1 = new User2(1, "sunquan1");
        user1.setType(Position.HIGH);
        Dog dog1 = new Dog(1, "abc");
        user1.addDog(dog1);

        User2 user2 = new User2(2, "sunquan2");
        Dog dog2 = new Dog(3, "abc");
        user2.addDog(dog2);

        db.put(user1.getId(), user1);
        db.put(user2.getId(), user2);
    }

    private static User2 getUserById(int id) {
        return db.get(id);
    }


    public static void main(String[] args) {

        DataFetcher pnDataFetcher = new DataFetcher() {
            @Override
            public Object get(DataFetchingEnvironment environment) {
                Integer id = environment.getArgument("id");
                User2 userById = getUserById(id);
//                List<GraphQLError> errors = ((List)response.get("errors")).stream()
//                        .map(MyMapGraphQLError::new)
//                        .collect(Collectors.toList());
//                return new DataFetcherResult(response.get("data"), errors);
                return new DataFetcherResult<>(userById, null);
            }
        };

        //解析Schema文件
        String schemaFilePath = "myschema1.graphqls";
        File schemaFile = new File(GraphQL_simple5.class.getClassLoader().getResource(schemaFilePath).getFile());
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);
        //定义Wiring
        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring().type("userQuery", typeWiring -> typeWiring
                .dataFetcher("user", environment -> {
                    Integer id = environment.getArgument("id");
                    User2 userById = getUserById(id);
                    return Lists.newArrayList(userById);
                })
        )
                .build();

        //构建Schema
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);

        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema)
                .build();
        Map<String, Object> variable = Maps.newHashMap();
        variable.put("iidd", 1);
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query("query userQuery($iidd:Int){user(id:$iidd){id,age,dogs{id,dogName}}}").build();
        Map<String, Object> result = graphQL.execute(executionInput).getData();
        System.out.println(result);

        executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query("query userQuery($iidd:Int){user(id:$iidd){id,age,userName,type,dogs{id,dogName}}}").build();
        //result = graphQL.execute(executionInput).getData();

        result = graphQL.execute(executionInput).toSpecification();

        System.out.println(result);
        Gson gson = new Gson();
        String data = gson.toJson(result.get("data"));
        System.out.println(data);
        User2 end = gson.fromJson(data,User2.class);
        System.out.println("B" + end);


        executionInput = ExecutionInput.newExecutionInput().
                query("query {user(id:1){id,age,userName,type,dogs{id,dogName}}}").build();
        result = graphQL.execute(executionInput).getData();
        System.out.println("a" + result);
    }
}