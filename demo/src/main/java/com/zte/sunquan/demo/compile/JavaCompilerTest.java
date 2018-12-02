package com.zte.sunquan.demo.compile;

import com.google.common.collect.Lists;
import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 10184538 on 2017/7/4.
 */
public class JavaCompilerTest {
    private File javaFile = new File("E:/Pair.java");

    @Test
    public void test() throws IOException {
        String classpath = System.getProperty("java.class.path");
        List<String> optionList = new ArrayList<>();
        optionList.addAll(Arrays.asList("-classpath", classpath));
        List<String> files = Lists.newArrayList(javaFile.getCanonicalPath());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, files.toArray(new String[]{}));
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable fileObjects = manager.getJavaFileObjectsFromStrings(files);
        JavaCompiler.CompilationTask task = compiler.getTask(null, null,
                null, optionList, null,
                fileObjects);
        boolean failOnError = !task.call();
        manager.close();
        if (failOnError)
            throw new IOException("Compilation errors");
    }

    @Test
    public void test2() throws IOException {
        String classpath = System.getProperty("java.class.path");
        List<String> optionList = new ArrayList<>();
        optionList.addAll(Arrays.asList("-classpath", classpath));
        List<String> files = Lists.newArrayList(javaFile.getCanonicalPath());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, files.toArray(new String[]{}));
        System.out.println(result);

    }

    public static class MemoryClassLoader extends URLClassLoader {

        Map<String, byte[]> classBytes = new HashMap<String, byte[]>();

        public MemoryClassLoader(Map<String, byte[]> classBytes) {
            super(new URL[0], DynamicLoader.MemoryClassLoader.class.getClassLoader());
            this.classBytes.putAll(classBytes);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] buf = classBytes.get(name);
            if (buf == null) {
                return super.findClass(name);
            }
            classBytes.remove(name);
            return defineClass(name, buf, 0, buf.length);
        }
    }

    @Test
    public void test3() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println(System.getProperty("user.dir"));
        String str = "sunquan";
        String s = "public class Temp{";
        s += "\r\n" + "      public static String call(String ss){      ";
        s += "\r\n" + "            System.out.println(\"" + str + "\");  ";
        s += "\r\n" + "            return \"return_str\"; ";
        s += "\r\n" + "      }";
        s += "\r\n" + "}";

        File file = new File("Temp.java");

        PrintWriter writer = new PrintWriter(file);
        writer.write(s);
        writer.flush();
        writer.close();

        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        int status = javac.run(null, null, null, "-d", System.getProperty("user.dir")/*+"\\target\\classes"*/, file.getPath());
        if (status == 0) {
            System.out.println("编译成功！");
//            Files.delete(file.toPath());
        }
        File clsFile = new File(System.getProperty("user.dir") + "\\Temp.class");
        System.out.println(clsFile.exists());
        Map<String, byte[]> map = new HashMap<>();
        map.put("Temp", Files.readAllBytes(clsFile.toPath()));
//        MemoryClassLoader loader = new MemoryClassLoader(map);

        System.out.println(clsFile.toURI().toURL());
        URLClassLoader loader = new URLClassLoader(new URL[]{clsFile.toURI().toURL()});
        Class cls = loader.loadClass("Temp");
        Method method = cls.getDeclaredMethod("call", String.class);//返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法
        String result = (String) method.invoke(null, str);//静态方法第一个参数可为null,第二个参数为实际传参
        System.out.println(result);
    }
}
