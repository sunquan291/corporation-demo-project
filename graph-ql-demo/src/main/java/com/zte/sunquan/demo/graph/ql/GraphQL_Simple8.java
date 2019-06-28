package com.zte.sunquan.demo.graph.ql;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLLong;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLInterfaceType.newInterface;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLInterfaceType;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.GraphQLType;
import graphql.schema.TypeResolver;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zte.sunquan.demo.model.Bus;
import com.zte.sunquan.demo.model.Car;
import com.zte.sunquan.demo.model.Hobby;
import com.zte.sunquan.demo.model.User;
import com.zte.sunquan.demo.model.Vehicle;

/**
 * Created by zhaiqianfeng on 6/7/17.
 * 使用resolver简单演示GraphQL api
 * 定义GrapQL数据类型 -> 定义暴露给客户端的query api和mutaion api -> 创建GraphQL Schema
 * <p>
 * blog: www.zhaiqianfeng.com
 */
public class GraphQL_Simple8 {

    static Map<String, User> dbUser = new HashMap<>();
    static Map<String, Hobby> dbHobby = new HashMap<>();
    static Map<String, Vehicle> dbVehicle = new HashMap<>();

    private static void initDataBase() {
        User user1 = new User();
        user1.setId("11");
        user1.setName("wangfei");
        user1.setGender("boy");
        user1.setIntro("博主");

        User user2 = new User();
        user2.setId("22");
        user2.setName("sunquan2");
        user2.setGender("boy");
        user2.setIntro("博主");

        User user3 = new User();
        user3.setId("33");
        user3.setName("lisan");
        user3.setGender("girl");
        user3.setIntro("博主");

        User user4 = new User();
        user4.setId("44");
        user4.setName("sunwaget");
        user4.setGender("boy");
        user4.setIntro("博主");


        Hobby hobby1 = new Hobby();
        hobby1.setId("h11111");
        hobby1.setpId(user1.getId());
        hobby1.setName("sunquan1");
        hobby1.setLove("love1");

        Hobby hobby2 = new Hobby();
        hobby2.setId("h22222");
        hobby2.setpId(user1.getId());
        hobby2.setName("sunquan2");
        hobby2.setLove("love2");

        Hobby hobby3 = new Hobby();
        hobby3.setId("h333333");
        hobby3.setpId(user2.getId());
        hobby3.setName("sunquan3");
        hobby3.setLove("love3");


        Bus bus1 = new Bus();
        bus1.setId("123");
        bus1.setUserId(user1.getId());
        bus1.setName("bus");
        bus1.setPrice(60000);
        bus1.setSeats(50);

        Car car1 = new Car();
        car1.setId("456");
        car1.setUserId(user1.getId());
        car1.setName("car");
        car1.setPrice(20000);

        dbUser.put(user1.getId(), user1);
        dbUser.put(user2.getId(), user2);
        dbUser.put(user3.getId(), user3);
        dbUser.put(user4.getId(), user4);

        dbHobby.put(hobby1.getId(), hobby1);
        dbHobby.put(hobby2.getId(), hobby2);
        dbHobby.put(hobby3.getId(), hobby3);

        dbVehicle.put(bus1.getId(), bus1);
        dbVehicle.put(car1.getId(), car1);

    }

    //定义接口(interface)类型
    private static GraphQLInterfaceType vehicleType = newInterface()
            .name("Vehicle")
            .description("交通工具接口")
            .typeResolver(new TypeResolver() {
                @Override
                public GraphQLObjectType getType(TypeResolutionEnvironment env) {
                    if (env.getObject() instanceof Car) {
                        return carType;
                    }
                    if (env.getObject() instanceof Bus) {
                        return busType;
                    }
                    return null;
                }
            })
            .build();

    private static GraphQLObjectType carType = newObject()
            .name("Car")
            .field(newFieldDefinition().name("id").type(GraphQLString))
            .field(newFieldDefinition().name("name").type(GraphQLString))
            .field(newFieldDefinition().name("price").type(GraphQLLong))
            .withInterface(vehicleType)
            .build();
    private static GraphQLObjectType busType = newObject()
            .name("Bus")
            .field(newFieldDefinition().name("id").type(GraphQLString))
            .field(newFieldDefinition().name("name").type(GraphQLString))
            .field(newFieldDefinition().name("price").type(GraphQLLong))
            .field(newFieldDefinition().name("seats").type(GraphQLInt))
            .withInterface(vehicleType)
            .build();

    public static void main(String[] args) {
        initDataBase();
        //定义GraphQL类型

        GraphQLObjectType hobbyType = newObject()
                .name("Hobby")
                .field(newFieldDefinition().name("id").type(GraphQLString))
                .field(newFieldDefinition().name("pId").type(GraphQLString))
                .field(newFieldDefinition().name("name").type(GraphQLString))
                .field(newFieldDefinition().name("love").type(GraphQLString))
                .build();
        GraphQLObjectType userType = newObject()
                .name("User")
                .field(newFieldDefinition().name("id").type(GraphQLString))
                .field(newFieldDefinition().name("name").type(GraphQLString))
                .field(newFieldDefinition().name("gender").type(GraphQLString))
                .field(newFieldDefinition().name("intro").type(GraphQLString))
                .field(newFieldDefinition().name("skills").type(new GraphQLList(GraphQLString)))
                .field(newFieldDefinition().name("hobbys").dataFetcher(e -> {
                    User source = e.getSource();
                    return dbHobby.values().stream().filter(h -> h.getpId().equals(source.getId()))
                            .collect(Collectors.toList());
                }).type(new GraphQLList(hobbyType)))
                .field(newFieldDefinition().name("vehicles").dataFetcher(e -> {
                    User source = e.getSource();
                    return dbVehicle.values().stream().filter(h -> h.getUserId().equals(source.getId()))
                            .collect(Collectors.toList());
                }).type(new GraphQLList(vehicleType)))
                .build();


        //定义暴露给客户端的查询query api
        GraphQLObjectType queryType = newObject()
                .name("userQuery")
                .field(newFieldDefinition()
                        .type(userType)//返回值
                        .name("user")//该处user表示查询语句唯一标识
                        .argument(newArgument().name("id").type(GraphQLString))
                        .argument(newArgument().name("name").type(GraphQLString))
                        .argument(newArgument().name("gender").type(GraphQLString))
                        .argument(newArgument().name("intro").type(GraphQLString))
                        .dataFetcher(env -> {
                            String id = env.getArgument("id");
                            String name = env.getArgument("name");
                            System.out.println("id=" + id);
                            System.out.println("name=" + name);
                            if (id != null) {
                                return dbUser.get(id);
                            }
                            return null;
                        }))
                .field(newFieldDefinition()
                        .type(new GraphQLList(userType))//返回值
                        .name("findUserPrefix")//该处user表示查询语句唯一标识
                        .argument(newArgument().name("name").type(GraphQLString))
                        .dataFetcher(env -> {
                            String name = env.getArgument("name");
                            System.out.println("name=" + name);
                            if (name != null) {
                                return dbUser.values().stream().filter(p -> p.getName().startsWith(name))
                                        .collect(Collectors.toList());
                            }
                            return null;
                        }))
                .field(newFieldDefinition()
                        .type(new GraphQLList(userType))//返回值
                        .name("findUserfilter")//该处user表示查询语句唯一标识
                        .argument(newArgument().name("id").type(GraphQLString))
                        .argument(newArgument().name("name").type(GraphQLString))
                        .argument(newArgument().name("gender").type(GraphQLString))
                        .dataFetcher(env -> {
                            String name = env.getArgument("name");
                            Map<String, Object> arguments = env.getArguments();

                            for (Map.Entry<String, Object> m : arguments.entrySet()) {
                                String key = m.getKey();
                                Object value = m.getValue();
                                System.out.println("key=" + key + ",value=" + value);

                            }

//                            Predicate<Map<String, Object>> predicate = p -> {
//                                boolean flag = true;
//                                for (Map.Entry<String, Object> m : p.entrySet()) {
//                                    String key = m.getKey();
//                                    Object value = m.getValue();
//
//                                }
//                                return true;
//                            };

                            System.out.println("name=" + name);
                            if (name != null) {
                                return dbUser.values().stream().filter(p -> p.getName().startsWith(name))
                                        .collect(Collectors.toList());
                            }
                            return null;
                        }))
                .field(newFieldDefinition().name("users")//查询语句唯一标识
                        .argument(newArgument().name("id").type(GraphQLString))
                        .argument(newArgument().name("page").type(GraphQLInt).build())
                        .argument(newArgument().name("size").type(GraphQLInt).build())
                        .argument(newArgument().name("name").type(GraphQLString).build())
                        .type(new GraphQLList(userType))//返回值
                        .dataFetcher(env -> {
                            if (env.getArguments().isEmpty()) {
                                return dbUser.values();
                            }
                            String id = env.getArgument("id");
                            return Lists.newArrayList(dbUser.get(id));
                        }))
                .field(newFieldDefinition().name("hobby")
                        .type(new GraphQLList(hobbyType))//查询语句唯一标识
                        .argument(newArgument().name("pId").type(GraphQLString))
                        .argument(newArgument().name("id").type(GraphQLString))
                        .argument(newArgument().name("love").type(GraphQLString).build())
                        .argument(newArgument().name("name").type(GraphQLString).build())
                        .dataFetcher(env -> {
                            String pId = env.getArgument("pId");
                            String id = env.getArgument("id");
                            if (pId != null) {
                                return dbHobby.values().stream().filter(h -> h.getpId().equals(pId))
                                        .collect(Collectors.toList());
                            } else if (id != null) {
                                return dbHobby.values().stream().filter(h -> h.getId().equals(id))
                                        .collect(Collectors.toList());
                            }
                            return null;
                        }))
//                .field(newFieldDefinition().name("hobbys")
//                        .type(new GraphQLList(hobbyType))//查询语句唯一标识
//                        .argument(newArgument().name("pId").type(GraphQLString))
//                        .argument(newArgument().name("id").type(GraphQLString))
//                        .argument(newArgument().name("love").type(GraphQLString).build())
//                        .argument(newArgument().name("name").type(GraphQLString).build())
//                        .dataFetcher(env -> {
//                            System.out.println("aaaaaaaaaaaa");
//                            String pId = env.getArgument("pId");
//                            return dbHobby.values().stream().filter(h -> h.getpId().equals(pId))
//                                    .collect(Collectors.toList());
//                        }))

                .field(newFieldDefinition().name("vehicle")
                        //查询语句唯一标识
                        .type(new GraphQLList(vehicleType))
                        .argument(newArgument().name("userId").type(GraphQLString))
                        .dataFetcher(env -> {
                            String pId = env.getArgument("userId");
                            Optional<Vehicle> first = dbVehicle.values().stream().findFirst();
                            return Lists.newArrayList(first.get());
                        }))


                .build();


        Set<GraphQLType> types = new HashSet<>();
        types.add(carType);
        types.add(busType);


        //创建Schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build(types);//必须
        //模型+接口 组装
        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();


        String want = "query userQuery($userId:String){user(id:$userId){name,gender,intro},hobby(pId:$userId){id,pId,name,love},vehicle(userId:$userId){ ... on Car{price}}}";
        Map<String, Object> variable = Maps.newHashMap();
        variable.put("userId", "11");
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query(want).build();
        Map<String, Object> result = graphQL.execute(executionInput).getData();
        System.out.println("E=" + result);


        String wantQuery = "query userQuery($userId:String){user(id:$userId){name,gender,intro,hobbys{id,pId,name,love}}}";
        executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query(wantQuery).build();
        result = graphQL.execute(executionInput).getData();
        System.out.println("F=" + result);

        result = graphQL.execute("{vehicle{__typename, ... on Car{price} ... on Bus{price,seats}}}").getData();
        System.out.println("A=" + result);
        result = graphQL.execute("{vehicle{__typename, ... on Car{price} ... on Bus{price,seats}}}").getData();
        System.out.println("A=" + result);


        //////////////////////////////////////////
        result = graphQL.execute("{users{id,name,gender}}").getData();
        System.out.println("F1=" + result);
        result = graphQL.execute("{user(id:\"11\"){id,name,gender}}").getData();
        System.out.println("F2=" + result);
        result = graphQL.execute("{user(id:\"11\"){id,name,gender,hobbys{id,pId,name,love}}}").getData();
        System.out.println("F3=" + result);
        result = graphQL.execute("{user(id:\"11\"){id,name,gender,vehicles{__typename ... on Car{price} ... on Bus{price,seats}}}}").getData();
        System.out.println("F4=" + result);
        result = graphQL.execute("{user(id:\"11\"){id,name,gender},hobby(pId:\"22\"){id,pId,name,love}}").getData();
        System.out.println("F4=" + result);
    }
}
