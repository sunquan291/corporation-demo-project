package com.zte.sunquan.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by 10184538 on 2017/7/7.
 */
public class JarFileUtils {

    private static final String jarSubfix = ".jar";

    public static List<JarEntry> getFiles(File file, String fileNameSubfix) {
        List<JarEntry> jarEntries = new ArrayList<>();
        JarFile jarFile = null;
        if (file.exists() && file.getName().endsWith(jarSubfix)) {
            try {
                jarFile = new JarFile(file);
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if (jarEntry.isDirectory())
                        continue;
                    if (jarEntry.getName().endsWith(fileNameSubfix)) {
                        jarEntries.add(jarEntry);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (jarFile != null)
                    try {
                        jarFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
        return jarEntries;
    }

    public static List<JarEntry> getFiles(String jarFilePath, String fileNameSubfix) {
        return getFiles(new File(jarFilePath), fileNameSubfix);
    }
}
