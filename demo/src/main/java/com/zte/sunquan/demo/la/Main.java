package com.zte.sunquan.demo.la;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by 10184538 on 2017/3/15.
 */
public class Main {

    public List<User> getFlow(Predicate<User> predicate) {
        List<User> result = Lists.newArrayList();
        List<User> users = Lists.newArrayList(new User("sunquan", 28),
                new User("sunquan2", 28),
                new User("sunquan1", 28),
                new User("sunquan3", 27),
                new User("sunquan", 27));
        for (User user : users) {
            if (predicate.test(user))
                result.add(user);
        }
        return ImmutableList.copyOf(result);
    }

    public List<User> getFlow(Predicate<User>... predicates) {
        List<User> result = Lists.newArrayList();
        List<User> users = Lists.newArrayList(new User("sunquan", 28),
                new User("sunquan2", 28),
                new User("sunquan1", 28),
                new User("sunquan3", 27),
                new User("sunquan", 27));
        for (User user : users) {
            boolean pass = true;
            for (Predicate<User> predicate : predicates) {
                if (!predicate.test(user)) {
                    pass = false;
                    break;
                }
            }
            if (pass)
                result.add(user);

        }
        return ImmutableList.copyOf(result);
    }

    public static void main(String[] args) {
        Main main = new Main();
        List<User> result = main.getFlow((u) -> u.getName().equals("sunquan"));
        result.forEach(System.out::println);
    }
}
