package com.zte.sunquan.demo.compile;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicLoader {
    public static Map<String, byte[]> compile(String javaSrc) {
        Pattern pattern = Pattern.compile("public\\s+class\\s+(\\w+)");

        Matcher matcher = pattern.matcher(javaSrc);
        if (matcher.find())
            return compile(matcher.group(1) + ".java", javaSrc);
        return null;
    }

    public static Map<String, byte[]> compile(String javaName, String javaSrc) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager stdManager = compiler.getStandardFileManager(null, null, null);

        try (MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager)) {
            JavaFileObject javaFileObject = manager.makeStringSource(javaName, javaSrc);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null,
                    Arrays.asList(javaFileObject));
            if (task.call())
                return manager.getClassBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class MemoryClassLoader extends URLClassLoader {

        Map<String, byte[]> classBytes = new HashMap<String, byte[]>();

        public MemoryClassLoader(Map<String, byte[]> classBytes) {
            super(new URL[0], MemoryClassLoader.class.getClassLoader());
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

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String nr = "\r\n";//回车换行
        String javaSrc =//"package com.flyoung.hello;"+nr+
                "    public class TestClass{" + nr +
                        "     public static void main(String[] args){" + nr +
                        "     System.out.println(\"helloworld!\");" + nr +
                        "}" + nr +
                        "}";
        //注意，需要对类进行加载，则必须要获取类全路径名，即包名+类名
        Map bytecode = DynamicLoader.compile("TestClass.java", javaSrc);
        DynamicLoader.MemoryClassLoader classLoader = new MemoryClassLoader(bytecode);
        Class clazz = classLoader.loadClass("TestClass");
        System.out.println(clazz.newInstance());
    }

}