package com.sunquan.demo.antlr.listener;

import com.sunquan.demo.antlr2.gen.JiavBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by 10184538 on 2017/5/10.
 */
public class JiavVisitor extends JiavBaseVisitor<Integer> {
    private Stack<Integer> numStack = new Stack<>();
    private Queue<String> symbolQueue = new ConcurrentLinkedQueue<>();

    @Override
    public Integer visitTerminal(TerminalNode node) {
        String text = node.getText();
        if (isCalSymbol(text))
            symbolQueue.add(text);
        else
            cal(text);
        return numStack.peek();
    }

    private boolean isCalSymbol(String text) {
        return text.equals("p") || text.equals("s") || text.equals("m") || text.equals("d");
    }

    private void cal(String text) {
        if (text != null && !text.equals(" ")) {
            if (symbolQueue.isEmpty()) {
                numStack.push(Integer.parseInt(text));
            } else {
                while (!symbolQueue.isEmpty()) {
                    String symbol = symbolQueue.poll();
                    switch (symbol) {
                        case "p":
                            numStack.push(numStack.pop() + Integer.parseInt(text));
                            break;
                        case "s":
                            numStack.push(numStack.pop() - Integer.parseInt(text));
                            break;
                        case "m":
                            numStack.push(numStack.pop() * Integer.parseInt(text));
                            break;
                        case "l":
                            numStack.push(numStack.pop() / Integer.parseInt(text));
                            break;
                        default:
                            throw new RuntimeException("not support symbol");
                    }
                }
            }
        }
    }
}
