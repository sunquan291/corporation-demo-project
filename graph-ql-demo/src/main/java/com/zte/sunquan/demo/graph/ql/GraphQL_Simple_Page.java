package com.zte.sunquan.demo.graph.ql;

import com.google.common.collect.Maps;
import com.zte.sunquan.demo.model.User;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLError;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Created by zhaiqianfeng on 6/7/17.
 * 使用resolver简单演示GraphQL api
 * 定义GrapQL数据类型 -> 定义暴露给客户端的query api和mutaion api -> 创建GraphQL Schema
 * <p>
 * blog: www.zhaiqianfeng.com
 */
public class GraphQL_Simple_Page {
    static Map<String, User> db = new HashMap<>();

    private static void initDataBase() {
        User user1 = new User();
        user1.setName("wangfei");
        user1.setGender("male");
        user1.setIntro("https://blog.csdn.net/sunquan291");

        User user2 = new User();
        user2.setName("sunquan");
        user2.setGender("male");
        user2.setIntro("https://blog.csdn.net/sunquan291");

        User user3 = new User();
        user3.setName("lisan");
        user3.setGender("female");
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
        //定义暴露给客户端的查询API
        GraphQLObjectType queryType = newObject()
                .name("userQuery")
                //全量查询users
                .field(newFieldDefinition().type(new GraphQLList(userType)).name("users")
                        .dataFetcher(env -> {
                            return db.values();
                        }))
                //按name,gender查询指定user
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
                        .argument(newArgument()
                                .name("first")
                                .type(GraphQLInt))
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


        //创建Schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();

//        //查询所有user
//        Map<String, Object> result = graphQL.execute("{users{name,gender,intro}}").getData();
//        System.out.println("result:" + result);
//        //查询姓名为sunquan的user
//        Map<String, Object> result2 = graphQL.execute("{user(name:\"sunquan\"){name,gender,intro}}").getData();
//        System.out.println("result2:" + result2);
//        //查询姓名为sunquan,性别为男的user
//        Map<String, Object> result3 = graphQL.execute("{user(name:\"sunquan\",gender:\"male\"){name,gender,intro}}").getData();
//        System.out.println("result3:" + result3);
//        //查询所有男性用户
//        Map<String, Object> result4 = graphQL.execute("{user(gender:\"male\"){__typename,name,gender,intro}}").getData();
//        System.out.println("result4:" + result4);
        Map<String, Object> variable = Maps.newHashMap();
        variable.put("first", "11");
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable).
                query("query user($first: Int=1 ){user(first:$first){name,gender,intro}}").build();
        //查询
        ExecutionResult execute = graphQL.execute(executionInput);
        List<GraphQLError> errors =
                execute.getErrors();
        System.out.println(errors);
        Map<String, Object> result5 = graphQL.execute(executionInput).getData();
        System.out.println("result5:" + result5);
    }
}
