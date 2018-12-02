package com.zte.sunquan.demo;

import com.zte.sdn.oscp.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

/**
 * Created by 10184538 on 2017/7/4.
 */
public class ActiveMain {
    private static final String outputYangsTempPath = System.getProperty("java.io.tmpdir") + "yangs";
    private static final String yangSubfix = ".yang";
    private static final String jarSubfix = ".jar";

    private static List<String> yangPaths = new ArrayList<>();

    public static void main(String[] args) {
        FileUtils.mkDir(outputYangsTempPath);
        String[] out = null;
        if (args != null && args.length > 0) {
            out = args;
        } else {
            out = new String[]{System.getProperty("user.dir")};
        }
        Stream<String> stream = Arrays.stream(out);
        stream.forEach(ActiveMain::searchYangFile);
        stream.close();
        yangPaths.forEach(System.out::println);
    }

    private static void searchYangFile(String directory) {
        System.out.println("Search Yang in [" + directory + "]");
        File f = new File(directory);
        if (!f.exists())
            return;
        if (f.isDirectory()) {
            for (String name : f.list()) {
                searchYangFile(directory + File.separator + name);
            }
        } else if (f.isFile()) {
            String fileName = f.getName();
            if (fileName.endsWith(yangSubfix)) {
                File out = new File(outputYangsTempPath + File.separator + f.getName());
                if (FileUtils.copy(f, out) != null)
                    yangPaths.add(out.getAbsolutePath());
            } else if (fileName.endsWith(jarSubfix)) {
                try {
                    copyYangFromJar(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void copyYangFromJar(File file) throws IOException {
        List<JarEntry> jarEntries = JarFileUtils.getFiles(file, yangSubfix);
        JarFile jarFile = new JarFile(file);
        for (JarEntry entry : jarEntries) {
            File out = new File(outputYangsTempPath + File.separator + entry.getName());
            FileUtils.copy(jarFile.getInputStream(entry), out);
        }
        jarFile.close();
    }

    private static void copyYangFromJar(String jarFilePath) throws IOException {
        copyYangFromJar(new File(jarFilePath));
    }
}
