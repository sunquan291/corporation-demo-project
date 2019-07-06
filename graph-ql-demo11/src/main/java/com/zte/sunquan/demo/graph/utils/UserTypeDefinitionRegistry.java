package com.zte.sunquan.demo.graph.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;

/**
 * UserTypeDefinitionRegistry class
 *
 * @author 10184538
 * @date 2019/6/25
 */
@Slf4j
public class UserTypeDefinitionRegistry {

    public static TypeDefinitionRegistry load(String gql) {
        InputStream inputStream = UserTypeDefinitionRegistry.class.getClassLoader().getResourceAsStream(gql);
        SchemaParser schemaParser = new SchemaParser();
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {
            return schemaParser.parse(inputStreamReader);
        } catch (IOException e) {
            log.error("UserTypeDefinitionRegistry error.", e);
        }
        return null;
    }
}
