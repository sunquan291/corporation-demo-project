package com.zte.sunquan.demo.projection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.function.Consumer;

/**
 * Created by 10043533 on 2016-10-14.
 */
public final class PathFileSearcher implements ApiProjectSearcher {
    @Override
    public boolean match(String searchKey) {

        File file = new File(searchKey);
        return file.exists() && file.isDirectory();
    }

    @Override
    public void search(String searchFrom, String searchFileName, Consumer<InputStream> consumer) {
        if (searchFrom == null || searchFrom.isEmpty() ||
                searchFileName == null || searchFileName.isEmpty() ||
                consumer == null){
            throw new IllegalArgumentException("invalid search parameter");
        }

        if (!match(searchFrom)){
            return;
        }

        // only search the top level of class path
        File file = new File(searchFrom);
        File[] subFiles = file.listFiles();
        if (subFiles != null){
            for(File subFile : subFiles){
                if (subFile.exists() && !subFile.isDirectory()){
                    if (subFile.getName().contains(searchFileName)){
                        try {
                            consumer.accept(new FileInputStream(subFile));
                            break;
                        } catch (FileNotFoundException e) {
                            continue;
                        }
                    }
                }
            }
        }
    }
}
