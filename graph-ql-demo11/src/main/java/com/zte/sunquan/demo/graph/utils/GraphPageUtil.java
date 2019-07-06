package com.zte.sunquan.demo.graph.utils;

import java.util.Optional;

import graphql.schema.DataFetchingEnvironment;

/**
 * GraphPageUtil class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class GraphPageUtil {
    public static Page page(DataFetchingEnvironment environment) {
        Integer offset = Optional.ofNullable((Integer) environment.getArgument("offset")).orElse(0);
        Integer limit = Optional.ofNullable((Integer) environment.getArgument("limit")).orElse(5000);
        return new Page(offset, limit);
    }
}

