package com.zte.sunquan.model;

import org.apache.karaf.shell.table.Col;
import org.apache.karaf.shell.table.ShellTable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by 10184538 on 2018/3/15.
 */
public class MainActive implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        System.out.println("MainActive start in up-model");
        printClassLoader(User.class);
//        start();
    }

    public static void main(String[] args) {

        ShellTable table = new ShellTable();
        table.size(40);//设置显示列宽（从最后一列开始计数），不设置
        table.column("name").alignLeft();//设置1列标题靠左
        table.column("age").alignCenter();//设置1列标题居中
        Col gender = new Col("gender");
        gender.alignRight();
        gender.maxSize(10);//设置该列长度，多余字符会被截断，不设置
        table.column(gender);
//        table.column("gender").alignRight();//设置1列标题靠右
        table.separator(" % ");//设置分隔符
        table.addRow().addContent("sunquan111111111111111111", "291111111111", "boy456789");
        table.addRow().addContent("sunquan", "29", "boy");
        table.addRow().addContent("sunquan", "29", "boy");
//        table.noHeaders();//不显示头，不设置
        table.print(System.out);

        table = new ShellTable();
        table.column("name").alignLeft();//设置1列标题靠左
        table.emptyTableText("null");//表示一个空表，用null替代
        table.print(System.out, true);

    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("MainActive stop in up-model");
    }

    public void printClassLoader(Class cls) {
        ClassLoader loader = cls.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }

    public static void start() {
        System.out.println("The JVM is started");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    //do something
                    System.out.println("The JVM Hook is execute");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
