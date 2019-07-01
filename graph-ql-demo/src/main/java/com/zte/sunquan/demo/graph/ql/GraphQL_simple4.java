package com.zte.sunquan.demo.graph.ql;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import com.google.common.collect.Maps;
import com.zte.sunquan.demo.model2.Cat;
import com.zte.sunquan.demo.model2.Fish;
import com.zte.sunquan.demo.model2.User2;

/**
 * GraphQL_SDL class
 *
 * @author 10184538
 * @date 2019/4/4
 */
public class GraphQL_simple4 {


//
//    GraphQLObjectType userType = newObject()
//            .name("user")
//            .field(newFieldDefinition().name("id").type(Scalars.GraphQLInt).build())
//            .field(newFieldDefinition().name("age").type(Scalars.GraphQLInt).build())
//            .field(newFieldDefinition().name("userName").type(GraphQLString).build())
//            .field(newFieldDefinition().name("dogs").type(new GraphQLList(dogType)).build())
//            .build();


    public static void main(String[] args) {
        User2 sunquan = new User2(1, "sunquan");
        GraphQLObjectType dogType = newObject()
                .name("dog")
                .field(newFieldDefinition().name("id").type(Scalars.GraphQLInt).build())
                .field(newFieldDefinition().name("dogName").type(GraphQLString).build())
                .build();

        GraphQLObjectType userType = newObject()
                .name("user")
                .field(newFieldDefinition().name("id").type(Scalars.GraphQLInt).build())
                .field(newFieldDefinition().name("age").type(Scalars.GraphQLInt).build())
                .field(newFieldDefinition().name("userName").type(GraphQLString).build())
                .field(newFieldDefinition().name("dogs").type(new GraphQLList(dogType)).build())
                .build();

        File schemaFile = loadSchema("myschema.graphqls");

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);

//        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring().build();
        RuntimeWiring wiring = new GraphQL_simple4().buildRuntimeWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);


        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema)
                .build();
        Map<String, Object> variable = Maps.newHashMap();
        variable.put("iidd", 1);
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable).

                query("query userQuery($iidd:Int){user(id:$iidd){id,age,dogs{id,dogName},animals{__typename ... on Cat{id}}}}").build();
//        query("query userQuery($iidd:Int){user(id:$iidd){id,age,dogs{id,dogName},animals{... on Cat{__typename ,id}}}}").build();
        Map<String, Object> result = graphQL.execute(executionInput).getData();
        System.out.println(result);

    }

    private static File loadSchema(String schemaInput) {
        System.out.println(GraphQL_simple4.class.getClassLoader().getResource("myschema.graphqls"));
        return new File(GraphQL_simple4.class.getClassLoader().getResource(schemaInput).getFile());
    }

    private RuntimeWiring buildRuntimeWiring() {
        TypeResolver t = new TypeResolver() {
            @Override
            public GraphQLObjectType getType(TypeResolutionEnvironment env) {
                Object javaObject = env.getObject();
                if (javaObject instanceof Cat) {
                    return env.getSchema().getObjectType("Cat");
                } else if (javaObject instanceof Fish) {
                    return env.getSchema().getObjectType("Fish");
                } else {
                    return env.getSchema().getObjectType("Cat");
                }
            }
        };

        //return RuntimeWiring.newRuntimeWiring().wiringFactory(new EchoingWiringFactory()).build();
        return RuntimeWiring.newRuntimeWiring()
                // this uses builder function lambda syntax
                .type("userQuery", typeWiring -> typeWiring
                        .dataFetcher("user", environment -> {
                            //上一级对象数据 environment.getSource()
                            //Map<String,Object> environment.getArguments()
                            //环境上下文，整个查询冒泡中都可以使用 environment.getContext()
                            Integer id = environment.getArgument("id");
                            System.out.println("argument:id=" + id);
                            // repository 处理
                            List<User2> list = new ArrayList<>();
                            User2 user2 = new User2(1, "sunquan");
                            user2.addAnimal(new Cat(2));
                            user2.addAnimal(new Fish(3));
                            list.add(user2);
                            return list;
                        })

                ).type("Animal", typeWiring -> typeWiring.typeResolver(t))
                .build();
    }
}

