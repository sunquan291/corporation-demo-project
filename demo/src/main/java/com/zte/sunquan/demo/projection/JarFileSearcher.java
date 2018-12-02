package com.zte.sunquan.demo.projection;


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by 10043533 on 2016-10-14.
 */
public final class JarFileSearcher implements ApiProjectSearcher {

    @Override
    public boolean match(String searchKey) {
        if (searchKey != null && !searchKey.isEmpty()) {
            if (searchKey.endsWith(".jar") || searchKey.endsWith(".kar")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void search(String searchFrom, String searchFileName, Consumer<InputStream> consumer) {

        if (searchFrom == null || searchFrom.isEmpty() ||
                searchFileName == null || searchFileName.isEmpty() ||
                consumer == null) {
            throw new IllegalArgumentException("invalid search parameter");
        }

        if (!match(searchFrom)) {
            return;
        }

        JarFile jar = null;
        try {
            jar = new JarFile(searchFrom);
        } catch (IOException e) {
            return;
        }
        Enumeration<JarEntry> jarEntries = jar.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry entry = jarEntries.nextElement();
            if (entry.isDirectory()) {
                continue;
            }
            if (entry.getName().contains(searchFileName)) {
                try {
                    consumer.accept(jar.getInputStream(entry));
                    break;
                } catch (IOException e) {
                    continue;
                }
            }
        }
    }
}
