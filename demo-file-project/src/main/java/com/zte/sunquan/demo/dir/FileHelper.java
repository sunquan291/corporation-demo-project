package com.zte.sunquan.demo.dir;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by 10184538 on 2018/5/28.
 */
public class FileHelper {

    private static class DeleteFileVistor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Files.deleteIfExists(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.deleteIfExists(dir);
            return FileVisitResult.CONTINUE;
        }
    }

    public static void deleteFile(File file) {
        if (file != null && !file.exists())
            return;
        if (file.isFile())
            file.delete();
        else {
            for (File f : file.listFiles())
                deleteFile(f);
            file.delete();
        }
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        if (!file.exists())
            return;
        if (file.isDirectory()) {
            for (String subPath : file.list()) {
                deleteFile(path + File.separator + subPath);
            }
            file.delete();
        } else {
            file.delete();
        }
    }

    public static void delete(Path path) throws IOException {
        boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        if (!exists)
            return;
        Files.walkFileTree(path, new DeleteFileVistor());
    }

    public static void main(String[] args) throws IOException {
        String path = "E:\\Support\\gerrit.zte\\controller";
        //FileHelper.deleteFile(path);
        FileHelper.delete(Paths.get(path));
    }
}
