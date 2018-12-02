package com.zte.sunquan.demo;

import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 10184538 on 2017/5/9.
 * 反射与google的reflect包的使用
 */
public class TokenCal {


    public boolean isPublic(Class cls, String methodName) throws NoSuchMethodException {
        TypeToken token = TypeToken.of(cls);
        return token.method(cls.getMethod(methodName)).isPublic();
    }

    public Class returnType(Class cls, String methodName) throws NoSuchMethodException {
        TypeToken token = TypeToken.of(cls);
        TypeToken returnType = token.method(cls.getMethod(methodName)).getReturnType();
        return returnType.resolveType(cls.getMethod(methodName).getReturnType()).getRawType();
    }

    @Test
    public void testToken() throws NoSuchMethodException {
        TypeToken<A> token = TypeToken.of(A.class);
        TypeToken<?> returnToken = token.method(A.class.getMethod("getList")).getReturnType();
        //interface java.util.List
        System.out.println(returnToken.getRawType());
        //java.util.List<java.lang.Integer>
        System.out.println(returnToken.getType());
        //interface java.util.List
        System.out.println(A.class.getMethod("getList").getReturnType());

        TypeToken<?> typeToken = returnToken.resolveType(List.class.getTypeParameters()[0]);
        System.out.println(typeToken);

    }

    @Test
    public void testIsPublic() throws NoSuchMethodException {
        boolean flag = isPublic(List.class, "size");
        Assert.assertTrue(flag);
        Class type = returnType(List.class, "size");
        Assert.assertEquals(type, int.class);
    }


    @Test
    public void method() {
        TypeToken token = TypeToken.of(Map.class);
        System.out.println(token.getType().getTypeName());
        System.out.println(token.getRawType().getTypeName());
        for (Method method : Map.class.getMethods()) {
            Invokable m = token.method(method);
            System.out.println(m.getName() + "," + m.isOverridable());
        }
    }

    public void get() {
        Gson gson = new Gson();
        String jsonStr = "";
        List<A> students = gson.fromJson(jsonStr, new TypeToken<List<A>>() {
        }.getType());
    }

    public static <T> List<T> formJson(Gson gson, String str, Class cls) {
//        List<A> list=new ArrayList<A>();
//        TypeToken token = TypeToken.of(list.getClass());
//        return gson.fromJson(str, token.getType());
//        return gson.fromJson(str, new TypeToken<List<>>() {
//        }.getType());
        return null;

    }

    @Test
    public void testss() {
        A a = new A();
        a.setA("hello,world");
        Gson gson = new Gson();
        List<A> as = new ArrayList<>();
        as.add(a);
        String s = gson.toJson(as);
        System.out.println(s);
        String result = "[{\"a\":\"hello,world\"}]";
        Type type = new TypeToken<List<A>>() {
        }.getType();
        List<A> students = gson.fromJson(result, type);
        System.out.println(students.get(0).getA());

        List<A> as1 = fromJson(result);
        System.out.println(as1.get(0).getA());
        List<A> students2 = formJson(gson, result, A.class);
        System.out.println(students2.get(0).getA());

    }

    public List<A> fromJson(String content) {
        Type type = new TypeToken<List<A>>() {
        }.getType();
        return new Gson().fromJson(content, type);
    }

}
