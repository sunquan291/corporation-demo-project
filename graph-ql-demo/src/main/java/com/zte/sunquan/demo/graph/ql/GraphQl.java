package com.zte.sunquan.demo.graph.ql;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

import graphql.schema.GraphQLObjectType;
//https://blog.csdn.net/z69183787/article/details/79992860
public class GraphQl {
    public static void main(String[] args) {
        GraphQLObjectType fooType = newObject()
                .name("Ci")
                .field(newFieldDefinition()
                        .name("product_number")
                        .type(GraphQLString))
                .build();

    }
}
