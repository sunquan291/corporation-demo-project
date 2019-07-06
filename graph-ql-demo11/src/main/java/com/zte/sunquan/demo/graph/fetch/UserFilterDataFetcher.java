package com.zte.sunquan.demo.graph.fetch;

import java.util.List;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import com.google.common.collect.Lists;
import com.zte.sunquan.demo.graph.domain.Car;
import com.zte.sunquan.demo.graph.domain.User;
import com.zte.sunquan.demo.graph.utils.GraphPageUtil;
import com.zte.sunquan.demo.graph.utils.Page;

/**
 * UserFilterDataFetcher class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class UserFilterDataFetcher implements DataFetcher<List<User>> {
    @Override
    public List<User> get(DataFetchingEnvironment environment) {
        Page page = GraphPageUtil.page(environment);
        System.out.println(page);
        User user = new User();
        user.setId("1234");
        user.setName("sunquan");
        user.setGender("male");
        Car car = new Car();
        car.setPrice(100000);
        user.setVehicle(car);
        return Lists.newArrayList(user);
    }
}
