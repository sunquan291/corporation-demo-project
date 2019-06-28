package com.zte.sunquan.demo.graph.ql;

import static graphql.Scalars.GraphQLBoolean;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLInputObjectField.newInputObjectField;
import static graphql.schema.GraphQLInputObjectType.newInputObject;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import graphql.GraphQL;
import graphql.schema.GraphQLInputType;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import com.google.gson.Gson;
import com.zte.sunquan.demo.model.User;

/**
 * Created by zhaiqianfeng on 6/7/17.
 * 使用resolver简单演示GraphQL api
 * 定义GrapQL数据类型 -> 定义暴露给客户端的query api和mutaion api -> 创建GraphQL Schema
 * <p>
 * blog: www.zhaiqianfeng.com
 */
public class GraphQL_Simple2 {
    static Map<String, User> db = new HashMap<>();

    private static void initDataBase() {
        User user1 = new User();
        user1.setName("wangfei");
        user1.setGender("boy");
        user1.setIntro("https://blog.csdn.net/sunquan291");

        User user2 = new User();
        user2.setName("sunquan");
        user2.setGender("boy");
        user2.setIntro("https://blog.csdn.net/sunquan291");

        User user3 = new User();
        user3.setName("lisan");
        user3.setGender("girl");
        user3.setIntro("https://blog.csdn.net/sunquan291");

        db.put(user1.getName(), user1);
        db.put(user2.getName(), user2);
        db.put(user3.getName(), user3);

    }


    public static void main(String[] args) {
        initDataBase();
        //定义GraphQL类型
        GraphQLObjectType userType = newObject()
                .name("User2")
                .field(newFieldDefinition().name("name").type(GraphQLString))
                .field(newFieldDefinition().name("gender").type(GraphQLString))
                .field(newFieldDefinition().name("intro").type(GraphQLString))
                .build();
        //定义输入类型
        GraphQLInputType userInput = newInputObject()
                .name("UserInput")
                .field(newInputObjectField().name("name").type(GraphQLString))
                .field(newInputObjectField().name("gender").type(GraphQLString))
                .field(newInputObjectField().name("intro").type(GraphQLString))
                .field(newInputObjectField().name("skills").type(new GraphQLList(GraphQLString)))
                .build();


        //定义暴露给客户端的查询query api
        GraphQLObjectType queryType = newObject()
                .name("userQuery")
                //list查询
                .field(newFieldDefinition().type(new GraphQLList(userType)).name("users")
                        .dataFetcher(env -> {
                            return db.values();
                        }))
                //按name查询
                .field(newFieldDefinition()
                        .type(new GraphQLList(userType))
                        .name("user")
                        .argument(newArgument()
                                .name("name")
                                .type(GraphQLString))
                        //.type(new GraphQLNonNull(GraphQLString)))
                        .argument(newArgument()
                                .name("gender")
                                .type(GraphQLString))
                        //.type(new GraphQLNonNull(GraphQLString)))
                        .dataFetcher(environment -> {
                            String name = environment.getArgument("name");
                            String sex = environment.getArgument("gender");
                            return db.values().stream().filter(p -> {
                                boolean flag = true;
                                if (name != null) {
                                    flag = flag & p.getName().equals(name);
                                }
                                if (sex != null) {
                                    flag = flag & p.getGender().equals(sex);
                                }
                                return flag;
                            })
                                    .collect(Collectors.toList());
                        }))

                .build();

        GraphQLObjectType mutaionType = newObject()//定义暴露给客户端的查询query api
                .name("userMutation")
                .field(newFieldDefinition()
                        .type(new GraphQLList(userType))
                        .name("addUserByInput")
                        .argument(newArgument()
                                .name("userInfo")
                                .type(new GraphQLNonNull(userInput)))
                        .dataFetcher(environment -> {
                            Map<String, Object> userInfoMap = environment.getArgument("userInfo");

                            Gson gson = new Gson();
                            User user = gson.fromJson(userInfoMap.toString(), User.class);
                            db.put(user.getName(), user);
//                            User userInfo = new User();
//                            for (String key : userInfoMap.keySet()) {
//                                switch (key) {
//                                    case "name":
//                                        userInfo.setName(userInfoMap.get("name").toString());
//                                        break;
//                                    case "gender":
//                                        userInfo.setGender(userInfoMap.get("gender").toString());
//                                        break;
//                                    case "intro":
//                                        userInfo.setIntro(userInfoMap.get("intro").toString());
//                                        break;
//                                    case "skills":
//                                        ArrayList<String> skillsList = (ArrayList<String>) userInfoMap.get("skills");
//                                        String[] skills = new String[skillsList.size()];
//                                        userInfo.setSkills(skillsList.toArray(skills));
//                                        break;
//                                    default:
//                                        break;
//                                }
//                            }
//                            db.put(userInfo.getName(), userInfo);
                            return db.values();
                        }))
                .field(newFieldDefinition()
                        .type(GraphQLBoolean)
                        .name("delUserById")
                        .argument(newArgument()
                                .name("name")
                                .type(new GraphQLNonNull(GraphQLString)))
                        .dataFetcher(environment -> {
                            String name = environment.getArgument("name");
                            if (name != null) {
                                if (db.containsKey(name)) {
                                    db.remove(name);
                                    return true;
                                }
                            }
                            return false;
                        })
                )
                .build();

        //创建Schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .mutation(mutaionType)
                .build();
        //模型+接口 组装

        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        Map<String, Object> result = graphQL.execute("{users{name,gender,intro}}").getData();
        System.out.println(result);
        Map<String, Object> result2 = graphQL.execute("{user(name:\"sunquan\"){name,gender,intro}}").getData();
        System.out.println(result2);
        Map<String, Object> result3 = graphQL.execute("{user(name:\"sunquan\",gender:\"boy\"){name,gender,intro}}").getData();
        System.out.println(result3);
        Map<String, Object> result4 = graphQL.execute("{user(gender:\"boy\"){__typename,name,gender,intro}}").getData();
        System.out.println(result4);
        Map<String, Object> result5 = graphQL.execute("{user($first: Int = 1){name,gender,intro}}").getData();
        System.out.println("result5:" + result5);
        result = graphQL.execute("mutation{addUserByInput(userInfo:{name:\"test2User\",gender:\"男\",intro:\"简介\",skills:[\"java\",\"nodejs\"]}){name,gender,intro}}").getData();
        System.out.println("D:" + result);

        result = graphQL.execute("mutation{delUserById(name:\"test2User\")}").getData();
        System.out.println(result);

        System.out.println(db.values());
    }
}
