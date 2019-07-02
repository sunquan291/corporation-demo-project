package com.zte.sunquan.demo.graph.ql;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.zte.sunquan.demo.graph.util.GraphResult;
import com.zte.sunquan.demo.model2.Cat;
import com.zte.sunquan.demo.model2.Dog;
import com.zte.sunquan.demo.model2.Fish;
import com.zte.sunquan.demo.model2.Position;
import com.zte.sunquan.demo.model2.User2;

/**
 * GraphQL_SDL class
 *
 * @author 10184538
 * @date 2019/4/4
 */
public class GraphQL_SDL2 {
    private static Map<Integer, User2> db;

    static {
        db = new ConcurrentHashMap<>();
        User2 user2 = new User2(1, "sunquan");
        user2.setType(Position.HIGH);
        user2.addAnimal(new Cat(2, "cat1"));
        user2.addAnimal(new Fish(3));
        db.put(1, user2);
    }

    public static void main(String[] args) {
        File schemaFile = new File(GraphQL_SDL2.class.getClassLoader().getResource("myschema.graphqls").getFile());
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema)
                .build();
        //准备入参
        Map<String, Object> variable = Maps.newHashMap();
        variable.put("iidd", 1);
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query("query userQuery($iidd:Int){user(id:$iidd){id,age,dogs{id,dogName},animals{__typename ... on Cat{id}}}}").build();
//        query("query userQuery($iidd:Int){user(id:$iidd){id,age,dogs{id,dogName},animals{... on Cat{__typename ,id}}}}").build();
        Map<String, Object> result = graphQL.execute(executionInput).getData();
//        {user=[{id=1, age=0, dogs=null, animals=[{__typename=Cat, id=2}, {__typename=Fish}]}]}
        System.out.println(result);
        db.get(1).addDog(new Dog(3, "dog1"));
//        {user=[{id=1, age=0, dogs=[{id=3, dogName=dog1}], animals=[{__typename=Cat, id=2}, {__typename=Fish}]}]}
        result = graphQL.execute(executionInput).getData();
        System.out.println(result);
        executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query("query userQuery($iidd:Int){user(id:$iidd){id,age,dogs{id,dogName},animals{... on Cat{id,name}}}}").build();
        result = graphQL.execute(executionInput).getData();
        //{user=[{id=1, age=0, dogs=[{id=3, dogName=dog1}], animals=[{id=2, name=cat1}, {}]}]}
        System.out.println(result);
        executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query("query userQuery($iidd:Int){user(id:$iidd){id,age,type,dogs{id,dogName},animals{... on Cat{__typename,id,name}}}}").build();
        result = graphQL.execute(executionInput).getData();
//        {user=[{id=1, age=0, type=HIGH, dogs=[{id=3, dogName=dog1}], animals=[{__typename=Cat, id=2, name=cat1}, {}]}]}
        System.out.println(result);

        //存在一些情况，需要对GraphQL返回的String进行JSON格式化
        Gson gson = new Gson();
        String data = gson.toJson(result);
        System.out.println(data);
        //推荐二
        String resolve = GraphResult.resolve(graphQL.execute(executionInput).toSpecification());
        System.out.println(resolve);
    }

    private static RuntimeWiring buildRuntimeWiring() {
        //union类型需要定义TypeResolver供graphQL使用
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
        return RuntimeWiring.newRuntimeWiring()
                .type("userQuery", typeWiring -> typeWiring
                        .dataFetcher("user", environment -> {
                            //上一级对象数据 environment.getSource()
                            //Map<String,Object> environment.getArguments()
                            //环境上下文，整个查询冒泡中都可以使用 environment.getContext()
                            Integer id = environment.getArgument("id");
                            return Lists.newArrayList(db.get(id));
                        })
                ).type("Animal", typeWiring -> typeWiring.typeResolver(t))
                .build();
    }
}

