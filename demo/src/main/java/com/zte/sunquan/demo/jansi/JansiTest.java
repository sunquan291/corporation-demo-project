package com.zte.sunquan.demo.jansi;

import org.fusesource.jansi.Ansi;

import java.io.IOException;
import java.util.Properties;

import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Created by sunquan on 2017/2/25.
 */
public class JansiTest {

    public static Ansi screen = ansi().eraseScreen();

    public static void main(String[] args) throws IOException {
        System.out.println(ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset());
        Ansi render = ansi().eraseScreen().render("@|red Hello|@@|green World|@");
        System.out.println(render);

        Properties properties = new Properties();
        properties.load(JansiTest.class.getResourceAsStream("/branding1.properties"));
        System.out.println(properties.get("welcome"));

        properties.load(JansiTest.class.getResourceAsStream("/branding2.properties"));
        System.out.println(ansi().eraseScreen().render(properties.get("welcome").toString()));
    }
}
