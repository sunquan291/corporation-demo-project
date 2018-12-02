package com.zte.sunquan.j8.work;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by 10184538 on 2017/4/4.
 */
public class Test1 {
    public File[] getSubDirectories(String path) {
        File f = new File(path);
        File[] files = f.listFiles((fs) -> {
            return fs.isDirectory();
        });
        return files;
    }

    public File[] getActualFile(String path, String suffix) {
        File f = new File(path);
        File[] files = f.listFiles((dir, name) -> {
            System.out.println(dir);
            System.out.println(name);
            return true;
        });
        return files;
    }

    @Test
    public void test2() {
        File f = new File(this.getClass().getResource("/").getPath());
        File[] files = getSubDirectories(f.getPath());
        Arrays.stream(files).forEach((file) -> System.out.println(file.getName()));
    }

    @Test
    public void test3() {
        File f = new File(this.getClass().getResource("/").getPath());
        File[] files = getActualFile(f.getPath(), "a");
        Arrays.stream(files).forEach((file) -> System.out.println(file.getName()));
    }

    @Test
    public void test4() {
        long num = Stream.of("hell444o", "hell2o", "hel21212lo", "hell12o", "hello1")
                .filter((s) -> s.length() > 3).count();
        System.out.println(num);
    }


    @Test
    public void test5() {
        Map<String, User> map = Maps.newHashMap();
        for (int i = 0; i < 1000000; i++) {
            map.put(i + "a", new User(i + "a", 200));
        }
        long start = System.currentTimeMillis();
        ImmutableList<User> users = ImmutableList.copyOf(map.values());
        System.out.println(users.size());
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test6() {
        Map<String, User> map = Maps.newHashMap();
        for (int i = 0; i < 1000000; i++) {
            map.put(i + "a", new User(i + "a", 200));
        }
        long start = System.currentTimeMillis();
        ImmutableList build = new ImmutableList.Builder().add(map.values()).build();
        System.out.println(build.size());
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void ad(int x){

        if(x==0)
            throw new IllegalArgumentException("dd");
    }

    public static void main(String[] args) {
        ImmutableList<String> of = ImmutableList.of("1");
        Set<String> of1 = (Set<String>) of;
        try {
            ad(0);
        }catch (Exception e){

        }
    }
}
