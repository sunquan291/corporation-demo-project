package com.zte.sunquan.demo.graph.utils;

import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.TypeResolver;

import com.zte.sunquan.demo.graph.domain.Bus;
import com.zte.sunquan.demo.graph.domain.Car;

/**
 * Created by 00222966 on 2019/6/20.
 */
public class GraphQLUtil {

    public static TypeResolver getTypeResolverOfVehicle() {
        return new TypeResolver() {
            @Override
            public GraphQLObjectType getType(TypeResolutionEnvironment env) {
                Object javaObject = env.getObject();
                if (javaObject instanceof Car) {
                    return env.getSchema().getObjectType("Car");
                } else if (javaObject instanceof Bus) {
                    return env.getSchema().getObjectType("Bus");
                } else {
                    return null;
                }
            }
        };
    }

}
