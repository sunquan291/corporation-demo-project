package com.zte.sunquan.demo.graph.utils;

import graphql.schema.idl.RuntimeWiring;

/**
 * UserRuntimeWiring class
 *
 * @author 10184538
 * @date 2019/6/25
 */
public class UserRuntimeWiring {
    public static RuntimeWiring.Builder builder() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Vehicle", typeWiring -> typeWiring.typeResolver(GraphQLUtil.getTypeResolverOfVehicle()));
    }
}
