package com.sunquan.demo.antlr;

import com.sunquan.demo.antlr.listener.JiavVisitor;
import com.sunquan.demo.antlr2.gen.JiavLexer;
import com.sunquan.demo.antlr2.gen.JiavParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * Created by 10184538 on 2017/3/23.
 */
public class MainTest {
    @Test
    public void test1() {
//        String hello = "hello sunquan";
//        ANTLRInputStream inputStream = new ANTLRInputStream(hello);
//        HelloLexer lexer = new HelloLexer(inputStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//
//        HelloParser parser = new HelloParser(tokenStream);
//        ParseTree tree = parser.r();
//
//        ParseTreeWalker walker = new ParseTreeWalker();
//
//        MyListener treeWalker = new MyListener();
//        walker.walk(treeWalker, tree);
    }

//    @Test
//    public void test2() {
//        String hello = "calc 1+3-3+(3+3)";
//        ANTLRInputStream inputStream = new ANTLRInputStream(hello);
//        CalcLexer lexer = new CalcLexer(inputStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//
//        CalcParser parser = new CalcParser(tokenStream);
//        ParseTree tree = parser.exprs();
//        MyCalcVisitor visitor = new MyCalcVisitor();
//        Double result = visitor.visit(tree);
//        System.out.println(result);
//    }

//    @Test
//    public void test3() {
//        PLUS : 'p';
//        SUB : 's' ;
//        MUL : 'm' ;
//        DIV : 'd' ;
//        String hello = "1 psw 2";
//        ANTLRInputStream inputStream = new ANTLRInputStream(hello);
//        JiaLexer lexer = new JiaLexer(inputStream);
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//
//        JiaParser parser = new JiaParser(tokenStream);
//        ParseTreeWalker walker = new ParseTreeWalker();
//        JiaListener jiaListener = new JiaListener();
//        walker.walk(jiaListener, parser.expres());
//        System.out.println(jiaListener.result());
//    }

    @Test
    public void test4() {
//        PLUS : 'p';
//        SUB : 's' ;
//        MUL : 'm' ;
//        DIV : 'd' ;
        String hello = "1 pm 3";
        ANTLRInputStream inputStream = new ANTLRInputStream(hello);
        JiavLexer lexer = new JiavLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        JiavParser parser = new JiavParser(tokenStream);
        JiavVisitor visitor = new JiavVisitor();
        Integer result = visitor.visit(parser.expres());
        System.out.println(result);
    }
}
