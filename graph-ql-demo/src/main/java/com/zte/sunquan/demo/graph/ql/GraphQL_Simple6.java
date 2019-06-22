package com.zte.sunquan.demo.graph.ql;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zte.sunquan.demo.model.Hobby;
import com.zte.sunquan.demo.model.User;

/**
 * Created by zhaiqianfeng on 6/7/17.
 * 使用resolver简单演示GraphQL api
 * 定义GrapQL数据类型 -> 定义暴露给客户端的query api和mutaion api -> 创建GraphQL Schema
 * <p>
 * blog: www.zhaiqianfeng.com
 */
public class GraphQL_Simple6 {

    static Map<String, User> dbUser = new HashMap<>();
    static Map<String, Hobby> dbHobby = new HashMap<>();

    private static void initDataBase() {
        User user1 = new User();
        user1.setId("11");
        user1.setName("wangfei");
        user1.setSex("boy");
        user1.setIntro("博主");

        User user2 = new User();
        user2.setId("22");
        user2.setName("sunquan2");
        user2.setSex("boy");
        user2.setIntro("博主");

        User user3 = new User();
        user3.setId("33");
        user3.setName("lisan");
        user3.setSex("girl");
        user3.setIntro("博主");

        User user4 = new User();
        user4.setId("44");
        user4.setName("sunwaget");
        user4.setSex("boy");
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

        dbUser.put(user1.getId(), user1);
        dbUser.put(user2.getId(), user2);
        dbUser.put(user3.getId(), user3);
        dbUser.put(user4.getId(), user4);


        dbHobby.put(hobby1.getId(), hobby1);
        dbHobby.put(hobby2.getId(), hobby2);

    }


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
                .field(newFieldDefinition().name("sex").type(GraphQLString))
                .field(newFieldDefinition().name("intro").type(GraphQLString))
                .field(newFieldDefinition().name("skills").type(new GraphQLList(GraphQLString)))
                .field(newFieldDefinition().name("hobbys").type(new GraphQLList(hobbyType)))
                .build();

        //定义暴露给客户端的查询query api
        GraphQLObjectType queryType = newObject()
                .name("userQuery")
                .field(newFieldDefinition()
                        .type(userType)//返回值
                        .name("user")//该处user表示查询语句唯一标识
                        .argument(newArgument().name("id").type(GraphQLString))
                        .argument(newArgument().name("name").type(GraphQLString))
                        .argument(newArgument().name("sex").type(GraphQLString))
                        .argument(newArgument().name("intro").type(GraphQLString))
                        .dataFetcher(env -> {
                            String id = env.getArgument("id");
                            String name = env.getArgument("name");
                            System.out.println("id=" + id);
                            System.out.println("name=" + name);
                            if (id != null) {
                                User user = dbUser.get(id);
                                Hobby hobby=new Hobby();
                                hobby.setpId(user.getId());
                                hobby.setId("123");
                                hobby.setLove("love");
                                hobby.setName("name123");
                                user.setHobbys(Lists.newArrayList(hobby));
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
                        .argument(newArgument().name("sex").type(GraphQLString))
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
                            return dbHobby.values().stream().filter(h -> h.getpId().equals(pId))
                                    .collect(Collectors.toList());
                        }))
                .build();

        //创建Schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
        //模型+接口 组装
        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        Map<String, Object> result = graphQL.execute("{user(id:\"11\"){name,sex,intro}}").getData();
        System.out.println("A=" + result);
        result = graphQL.execute("{users(id:\"11\"){name,sex,intro}}").getData();
        System.out.println("B=" + result);
        result = graphQL.execute("{hobby(pId:\"11\"){id,pId,name,love}}").getData();
        System.out.println("C=" + result);
        result = graphQL.execute("{user(id:\"11\"){name,sex,intro},hobby(pId:\"11\"){id,pId,name,love}}").getData();
        System.out.println("D=" + result);

        Map<String, Object> variable = Maps.newHashMap();
        variable.put("userId", "11");
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query("query userQuery($userId:String){user(id:$userId){name,sex,intro},hobby(pId:$userId){id,pId,name,love}}").build();
        result = graphQL.execute(executionInput).getData();
        System.out.println("E=" + result);
        //eg.LTP三层找二层
        result = graphQL.execute("{findUserPrefix(name:\"sun\"){name,sex,intro}}").getData();
        System.out.println("F=" + result);
        result = graphQL.execute("{findUserfilter(name:\"sun\",sex:\"boy\"){name,sex,intro}}").getData();
        System.out.println("G=" + result);

        //想实现的语句查询，是hobby为user的一个属性（按需查询，不需要hobby时不查，不支持）
        String wantQuery = "query userQuery($userId:String){user(id:$userId){name,sex,intro,hobby(pId:$userId){id,pId,name,love}}}";
        executionInput = ExecutionInput.newExecutionInput().variables(variable).query(wantQuery).build();
        result = graphQL.execute(executionInput).getData();
        System.out.println("H=" + result);

         wantQuery = "query userQuery($userId:String){user(id:$userId){name,sex,intro,hobbys{id,pId,name,love}}}";
        executionInput = ExecutionInput.newExecutionInput().variables(variable).query(wantQuery).build();
        result = graphQL.execute(executionInput).getData();
        System.out.println("I=" + result);
        
    }
}
