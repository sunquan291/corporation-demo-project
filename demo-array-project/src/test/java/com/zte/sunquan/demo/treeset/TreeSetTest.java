package com.zte.sunquan.demo.treeset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by 10184538 on 2018/6/1.
 * 这个测试用例存在的意义，是基于OSGI中在创建服务代理时的一个报错
 * 在构建服务时，其进行了类的自定义加载
 * 其中存在接口的重新构建，需要排序并去掉重复的接口
 * 使用到了SortedSet加自定义的比较器(BUG)
 */
public class TreeSetTest {
    SortedSet<Class<?>> classes;

    @Before
    public void init() {
        classes = new TreeSet<Class<?>>(new Comparator<Class<?>>() {
            public int compare(Class<?> object1, Class<?> object2) {
//                System.out.println("object1:" + object1 + "--object2:" + object2);
                //类名相同，则相等，不重复插入
                if (object1.getName().equals(object2.getName())) {
                    return 0;
                }
                //下面的表示为子类比父类大，排在后面
                else if (object1.isAssignableFrom(object2)) {
                    // first class is parent of second, it occurs earlier in type hierarchy
                    return -1;
                } else if (object2.isAssignableFrom(object1)) {
                    // second class is subclass of first one, it occurs later in hierarchy
                    return 1;
                }
                // types have separate inheritance trees, so it doesn't mater which one is first or second,
                // however we can't mark them as equal cause one of them will be removed
                return 1;//默认object1 大于 object 2
            }
        });
    }

    @Test
    public void testInsert() {
        //D extends C,A
        classes.add(A.class);
        classes.add(B.class);
        classes.add(D.class);
        printSet(classes);
        classes.add(C.class);
        printSet(classes);
        classes.add(A.class);
        printSet(classes);//从这行的打印中，可以看到存在了两个A,SortTreeSet原语是不允许存在重复类的

        //其主要原因是由于红黑树的旋转，导致其不会与第一个在左子树中的A进行比较
    }

    @Test
    public void testInsertRight() {
        Map<String, Class> map = new HashMap<>();
        addInterface(map, B.class, D.class);
        map.values().stream().forEach(classes::add);
        printSet(classes);
        map.clear();
        classes.clear();
        addInterface(map, A.class, B.class, C.class, D.class);
        map.values().stream().forEach(classes::add);
        printSet(classes);
    }

    private void addInterface(Map<String, Class> map, Class... cls) {
        //过滤同名类
        for (Class c : cls) {
            map.putIfAbsent(c.getName(), c);
            if (c.getInterfaces() != null && c.getInterfaces().length > 0)
                addInterface(map, c.getInterfaces());
        }
    }

    private void printSet(SortedSet set) {
        System.out.println("-------------------------------------");
        set.stream().forEach(System.out::println);
    }
}
