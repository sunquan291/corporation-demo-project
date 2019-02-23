package com.zte.sunquan.antlr.compute;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.zte.sunquan.compute.gen.ComputeLexer;
import com.zte.sunquan.compute.gen.ComputeParser;
import com.zte.sunquan.compute.vistitor.ExtComputeVistor;

/**
 * ComputeTest class
 *
 * @author 10184538
 * @date 2019/2/23
 */
public class ComputeTest {
    @Test
    public void testCompute1(){
        String compute="1 + 2";
        ANTLRInputStream inputStream = new ANTLRInputStream(compute);
        ComputeLexer lexer = new ComputeLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        ComputeParser parser = new ComputeParser(tokenStream);
        ExtComputeVistor visitor = new ExtComputeVistor();
        Integer result = visitor.visit(parser.express());
        System.out.println(result);
    }
}
