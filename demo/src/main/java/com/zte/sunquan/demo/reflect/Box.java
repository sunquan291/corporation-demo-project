package com.zte.sunquan.demo.reflect;

/**
 * Created by 10184538 on 2016/12/15.
 */
public class Box<T> {
    private T obj;

    public Box(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Box<String> box1 = new Box<>("hello,world");
        Box<Number> box2 = new Box<>(2);
        Box<Integer> box3 = new Box<>(3);
        Box<Float> box4 = new Box<>(4.0f);

//        getBoxObj(box1);
        getBoxObj(box2);
        getBoxObj(box3);
        getBoxObj(box4);

//        getBoxObj2(box1);
        getBoxObj2(box2);
        getBoxObj2(box3);
//        getBoxObj2(box4);
    }

    public static void getBoxObj(Box<? extends Number> box) {
        System.out.println(box.getObj());
    }
    public static void getBoxObj2(Box<? super Integer> box) {
        System.out.println(box.getObj());
    }
}
