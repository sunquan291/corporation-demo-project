package com.zte.sunquan.thread.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

public class FileUtil {

    public static void handleFileLine(File file, Consumer<String> handler) throws IOException {
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                // do something with line
                handler.accept(line);
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
    }

    public static String handleFileLine(File file) throws IOException {
        StringBuffer sb = new StringBuffer();
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                // do something with line
                sb.append(line);
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
        return sb.toString();
    }

    public static String minify(String jsonString) {
        boolean in_string = false;
        boolean in_multiline_comment = false;
        boolean in_singleline_comment = false;
        char string_opener = 'x';

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < jsonString.length(); i++) {
            char c = jsonString.charAt(i);
            String cc = jsonString.substring(i, Math.min(i + 2, jsonString.length()));
            if (in_string) {
                if (c == string_opener) {
                    in_string = false;
                    out.append(c);
                } else if (c == '\\') {
                    out.append(cc);
                    ++i;
                } else
                    out.append(c);
            } else if (in_singleline_comment) {
                if (c == '\r' || c == '\n')
                    in_singleline_comment = false;
            } else if (in_multiline_comment) {
                if (cc.equals("*/")) {
                    in_multiline_comment = false;
                    ++i;
                }
            } else {
                if (cc.equals("/*")) {
                    in_multiline_comment = true;
                    ++i;
                } else if (cc.equals("//")) {
                    in_singleline_comment = true;
                    ++i;
                } else if (c == '"' || c == '\'') {
                    in_string = true;
                    string_opener = c;
                    out.append(c);
                } else if (!Character.isWhitespace(c))
                    out.append(c);
            }
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\test\\user.json");
        //FileUtil.handleFileLine(file, System.out::println);
        String content = FileUtil.handleFileLine(file);
        System.out.println(content.getBytes().length);
        String minify = FileUtil.minify(content);
        System.out.println(minify.getBytes().length);
        System.out.println(minify);
    }
}
