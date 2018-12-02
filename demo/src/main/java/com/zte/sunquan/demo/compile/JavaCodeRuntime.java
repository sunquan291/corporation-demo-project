package com.zte.sunquan.demo.compile;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by 10184538 on 2017/7/20.
 */
public class JavaCodeRuntime {
    private static final String JAVA_SUFFIX = ".java";
    private static final String CLASS_SUFFIX = ".class";

    private static final Pattern ClassNamePattern = Pattern.compile("public\\s+class\\s+(\\w+)");
    private static final Pattern PkgPattern = Pattern.compile("package\\s+([\\w\\.]+);");

    private static final String JAR_FORMATTER = "jar cvf {1}\\{0}.jar -C {1} .";

    public static List<JavaFile> compile(String dir) throws IOException {
        List<JavaFile> result = Lists.newLinkedList();
        String classpath = System.getProperty("java.class.path");
        List<String> optionList = new ArrayList<>();
        optionList.addAll(Arrays.asList("-classpath", classpath + ";E:\\zzz"));
        File file = new File(dir);
        List<JavaFile> files;
        if (!file.exists())
            return result;
        if (file.isFile() && file.getName().endsWith(JAVA_SUFFIX))
            files = Lists.newArrayList(trans2JavaFile(file.getCanonicalPath()));
        else if (file.isDirectory())
            files = filterFile(dir);
        else
            return result;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable fileObjects = manager.getJavaFileObjectsFromStrings(files.stream().map(f -> f.getPath())
                .collect(Collectors.toList()));
        JavaCompiler.CompilationTask task = compiler.getTask(null, null,
                null, optionList, null,
                fileObjects);
        boolean failOnError = !task.call();
        manager.close();
        if (!failOnError) {

            return files;
        } else
            throw new IOException("Compilation errors");
    }

    public static File packageJar(String path) {
        Runtime run = Runtime.getRuntime();
        Process process = null;
        try {
            process = run.exec(MessageFormat.format(JAR_FORMATTER, "adapter-oscp-bean", path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(path + File.separator + "adapter-oscp-bean.jar");
    }

    private static JavaFile trans2JavaFile(String path) throws IOException {
        File file = new File(path);
        Preconditions.checkArgument(file.isFile());
        Preconditions.checkArgument(file.getName().endsWith(JAVA_SUFFIX));

        JavaFile outFile = new JavaFile(file.getCanonicalPath());

        StringBuilder javaSrc = new StringBuilder();
        Files.readAllLines(Paths.get(file.getCanonicalPath())).forEach(javaSrc::append);
        Matcher matcher = ClassNamePattern.matcher(javaSrc.toString());
        if (matcher.find()) {
            String javaName = matcher.group(1);
            if (!file.getName().equals(javaName + JAVA_SUFFIX))
                throw new RuntimeException("not valid java class file.");
            outFile.setName(javaName);
        }
        matcher = PkgPattern.matcher(javaSrc.toString());
        if (matcher.find()) {
            outFile.setPkg(matcher.group(1));
        }
        return outFile;
    }

    public static void cmd(String cmd) {
        Runtime run = Runtime.getRuntime();
        Process process = null;
        try {
            process = run.exec("jar cvf E:\\counter.jar -C E:\\zzz ."); // 执行cmd命令
//            process.waitFor();
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
//        System.out.println("Notepad returned " + process.exitValue());
    }


    @Test
    public void testTrans2JavaFile() throws IOException, ClassNotFoundException {
//        JavaFile javaFile = trans2JavaFile("E:\\zzz\\Pair.java");
//        System.out.println(javaFile);
        String classPath = System.getProperty("java.class.path");
        System.setProperty("java.class.path", classPath + ";E:\\zzz");
        System.out.println(System.getProperty("java.class.path"));
        List<JavaFile> files = compile("E:\\zzz");
//        for (JavaFile file : files) {
//            System.out.println(file.getFullName());
//            Class cls = JavaCodeRuntime.class.getClassLoader().loadClass(file.getFullName());
//            System.out.println(cls.getConstructors()[0]);
//        }
//        Class cls=JavaCodeRuntime.class.getClassLoader().loadClass("com.zte.sunquan.demo.PairX");
//        System.out.println(cls.getConstructors()[0]);

//        File file = new File("E:/zzz");//类路径(包文件上一层)
//        URL url = file.toURI().toURL();
//        ClassLoader loader = new URLClassLoader(new URL[]{url});
//        Class<?> cls = loader.loadClass("com.PairX");
//        System.out.println(cls.getConstructors()[0]);

        cmd("");
    }


//    public static Map<String, byte[]> compile(String javaName, String javaSrc) {
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        StandardJavaFileManager stdManager = compiler.getStandardFileManager(null, null, null);
//        try (MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager)) {
//            JavaFileObject javaFileObject = manager.makeStringSource(javaName, javaSrc);
//            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, Arrays.asList(javaFileObject));
//            if (task.call())
//                return manager.getClassBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    private static List<JavaFile> filterFile(String dir) throws IOException {
        Preconditions.checkArgument(new File(dir).isDirectory());
        List<JavaFile> store = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        File file;
        File[] files;
        stack.push(dir);
        while (!stack.isEmpty()) {
            String path = stack.pop();
            file = new File(path);
            files = file.listFiles();
            if (files == null || files.length == 0)
                continue;
            for (File f : files) {
                if (f.isDirectory()) {
                    stack.push(f.toString());
                } else {
                    String yangFile = f.getCanonicalPath();
                    if (yangFile.endsWith(JAVA_SUFFIX)) {
                        store.add(trans2JavaFile(yangFile));
                    }
                }
            }
        }
        return store;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        List<JavaFile> compile = JavaCodeRuntime.compile("E:\\zzz");
//        ClassLoader classLoader = JavaCodeRuntime.class.getClassLoader();
//        for (JavaFile s : compile) {
//            System.out.println(s);
//        }
        packageJar("E:\\zzz");
    }
}
