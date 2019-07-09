package com.zte.sunquan.demo.graph.ql;

import static graphql.Scalars.GraphQLBoolean;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.Map;

import graphql.ExecutionInput;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import com.google.common.collect.Maps;
import com.zte.sunquan.demo.model.User;

/**
 * //https://blog.csdn.net/z69183787/article/details/79992860
 * Created by zhaiqianfeng on 6/7/17.
 * 使用resolver简单演示GraphQL api
 * 定义GrapQL数据类型 -> 定义暴露给客户端的query api和mutaion api -> 创建GraphQL Schema
 * <p>
 * blog: www.zhaiqianfeng.com
 */
public class GraphQL_Directives_Include {

    public static void main(String[] args) {
        //服务端示例数据
        User user = new User();
        user.setName("sunquan");
        user.setGender("male");
        user.setIntro("https://blog.csdn.net/sunquan291");

        //定义GraphQL类型
        GraphQLObjectType userType = newObject()
                .name("User2")
                .field(newFieldDefinition().name("name").type(GraphQLString))
                .field(newFieldDefinition().name("gender").type(GraphQLString))
                .field(newFieldDefinition().name("intro").type(GraphQLString))
                .build();

        //定义暴露给客户端的查询query api
        GraphQLObjectType queryType = newObject()
                .name("userQuery")
                .field(newFieldDefinition().type(userType).name("user")
                        .argument(newArgument().name("show").type(GraphQLBoolean).defaultValue(false)
                        )
                        .dataFetcher(env -> {
                            return user;
                        }))
                //.staticValue(user))
                .build();

        //创建Schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
        //测试输出
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        Map<String, Object> result = graphQL.execute("{user{name @include(if: true),gender,intro}}").getData();
        System.out.println(result);
        Map<String, Object> variable = Maps.newHashMap();
        variable.put("show", Boolean.FALSE);
        ExecutionInput executionInput = ExecutionInput.newExecutionInput().variables(variable)
                .query("query userQuery($show:Boolean!){user{name @include(if: $show),gender,intro}}").build();
        result = graphQL.execute(executionInput).getData();
        System.out.println(result);
        result = graphQL.execute("{__type(name:\"User2\"){name,fields{name,type{name}}}}").getData();
        System.out.println(result);
    }
}
