package com.zte.sunquan.demo.graph.ql;

import java.util.Collections;

import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.SchemaParser;

/**
 * GraphQL_simple3 class
 *
 * @author 10184538
 * @date 2019/4/4
 */
public class GraphQL_simple3 {
    public static void main(String[] args) {
        GraphQLSchema schema = SchemaParser.newParser().file("User.graphqls")
                .resolvers(new QueryResolver())
                .dictionary(User.class)
                .build()
                .makeExecutableSchema();
        GraphQL gql = GraphQL.newGraphQL(schema)
                .queryExecutionStrategy(new AsyncExecutionStrategy())
                .build();

        Object object = gql.execute("query").getData();
        System.out.println(object);

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
