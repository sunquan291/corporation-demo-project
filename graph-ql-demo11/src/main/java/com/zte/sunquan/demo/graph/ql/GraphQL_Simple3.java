package com.zte.sunquan.demo.graph.ql;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.SchemaParser;

//import io.reactivex.Single;
//import io.reactivex.internal.operators.single.SingleJust;

/**
 * GraphQL_Simple3 class
 *
 * @author 10184538
 * @date 2019/4/4
 */
public class GraphQL_Simple3 {
    public static void main(String[] args) {
        GraphQLSchema schema = SchemaParser.newParser().file("User.graphqls")
                //.resolvers(new QueryResolver())
                .dictionary(User.class)
                .build()
                .makeExecutableSchema();

        GraphQL gql = GraphQL.newGraphQL(schema)
                .queryExecutionStrategy(new AsyncExecutionStrategy())
                .build();

        Map<String, Object> variables = new HashMap<>();
        variables.put("limit", 10);
//        Utils.assertNoGraphQlErrors(gql, variables, new Closure<String>(null) {
//            @Override
//            public String call() {
//                return "query {\n" +
//                        "   users {\n" +
//                        "       edges {\n" +
//                        "           cursor\n" +
//                        "           node {\n" +
//                        "               id\n" +
//                        "               name\n" +
//                        "           }\n" +
//                        "       },\n" +
//                        "       pageInfo {\n" +
//                        "           hasPreviousPage,\n" +
//                        "           hasNextPage\n" +
//                        "           startCursor\n" +
//                        "           endCursor\n" +
//                        "       }\n" +
//                        "   }\n" +
//                        "}";
//            }
//        });
    }

    static class QueryResolver implements GraphQLQueryResolver {
        public Connection<User> users(int first, String after, DataFetchingEnvironment env) {
            return new SimpleListConnection<>(Collections.singletonList(new User(1L, "Luke"))).get(env);
        }
    }

    static class User {
        Long id;
        String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

}
