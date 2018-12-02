package com.zte.sunquan.demo.param;

import java.io.File;
import java.util.ArrayList;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.annotation.Arg;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;

/**
 * Created by 10184538 on 2018/1/10.
 */
public class ParamTest {
    public static class Params {

        @Arg(dest = "type")
        public String type;

        @Arg(dest = "num1")
        public String num;

        @Arg(dest = "auth")
        public ArrayList<String> auth;

        @Arg(dest = "schemas-dir")
        public File schemasDir;

        public String getType() {
            return type;
        }

        public String getNum() {
            return num;
        }

        public ArrayList<String> getAuth() {
            return auth;
        }

        public File getSchemasDir() {
            return schemasDir;
        }
    }

    public static void main(String[] args) throws ArgumentParserException {
        //指定命令gcs
        final ArgumentParser parser = ArgumentParsers.newArgumentParser("gcs")
                .defaultHelp(true)
                .description("alculate checksum of given String.");//描述命令功能

        parser.addArgument("-t", "--type")//参数选项,第二个参数默认对应@Arg中dest
                .type(String.class)//默认值
                .choices("SHA-256", "SHA-512", "SHA1")//可选项
                .setDefault("SHA-256")//默认值
                .help("Specify hash function to use");//选项描述
        parser.addArgument("-c", "--content")
                .type(String.class)
                .help("content which need calculate")
                .dest("num1");//指定对应的@Arg 定义属性
        parser.addArgument("-a", "--auth")
                .nargs(2)
                .help("Username and password for HTTP basic authentication in order username password.")
                .dest("auth");

        parser.addArgument("-f", "--schemas-dir")
                .type(File.class)
                .help("Directory containing yang schemas to describe simulated devices. Some schemas e.g. netconf monitoring and inet types are included by default")
                .dest("schemas-dir");

        parser.printHelp();//打印help信息

        Params params = new Params();//命令包装对象
        try {
            //命令行参数-->自动转包装对象
            parser.parseArgs(new String[]{"-t", "SHA-256",
                    "--content", "sunquan",
                    "-a", "sunquan", "password",
                    "-f", "C:/Users/Administrator/.m2/settings.xml"}, params);//字符串转命令包装对象
        } catch (final ArgumentParserException e) {
            parser.handleError(e);
        }
        System.out.println("type:\t" + params.getType());
        System.out.println("num:\t" + params.getNum());
        System.out.println("userName:\t" + params.getAuth().get(0));
        System.out.println("password:\t" + params.getAuth().get(1));
        if (params.getSchemasDir().exists())
            System.out.println("file:\t" + params.getSchemasDir().getName());

    }
}
