package com.zte.sunquan.search.demo.main;

import java.io.File;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;

import com.zte.sunquan.search.demo.param.Parameter;

/**
 * Main class
 *
 * @author 10184538
 * @date 2019/2/23
 */
public class Main {
    private static ArgumentParser parser;

    private static void initParam() {
        parser = ArgumentParsers.newArgumentParser("gcs")
                .defaultHelp(true)
                .description("file search and operation.");//描述命令功能
        parser.addArgument("-n", "--name")
                .type(String.class)
                .dest("name")
                .help("Specify file name");
        parser.addArgument("-o", "--operation")
                .type(String.class)
                .choices("MOVE", "COPY", "DELETE")
                .setDefault("COPY")
                .dest("operation")
                .help("Specify file operation");
        parser.addArgument("-d", "--dir")
                .type(File.class)
                .help("Specify file directory")
                .dest("dir");

    }

    static {
        initParam();
    }

    public static void main(String[] args) {
        //parser.printHelp();
        Parameter parameter = new Parameter();
        try {
            parser.parseArgs(args, parameter);
        } catch (ArgumentParserException e) {
            e.printStackTrace();
        }
        //实现
    }
}
