package com.zte.sunquan.compute.vistitor;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.zte.sunquan.compute.gen.ComputeBaseVisitor;

/**
 * ExtComputeVistor class
 *
 * @author 10184538
 * @date 2019/2/23
 */
public class ExtComputeVistor extends ComputeBaseVisitor<Integer> {
    private Stack<Integer> numStack = new Stack<>();
    private Queue<String> symbolQueue = new ConcurrentLinkedQueue<>();

    @Override
    public Integer visitTerminal(TerminalNode node) {
        String text = node.getText();
        if (isCalSymbol(text)) {
            symbolQueue.add(text);
        } else {
            cal(text);
        }
        return numStack.peek();
    }

    private boolean isCalSymbol(String text) {
        return text.equals("+") || text.equals("-")
                || text.equals("*") || text.equals("/");
    }

    private void cal(String text) {
        if (text != null && !text.equals(" ")) {
            if (symbolQueue.isEmpty()) {
                numStack.push(Integer.parseInt(text));
            } else {
                while (!symbolQueue.isEmpty()) {
                    String symbol = symbolQueue.poll();
                    switch (symbol) {
                        case "+":
                            numStack.push(numStack.pop() + Integer.parseInt(text));
                            break;
                        case "-":
                            numStack.push(numStack.pop() - Integer.parseInt(text));
                            break;
                        case "*":
                            numStack.push(numStack.pop() * Integer.parseInt(text));
                            break;
                        case "/":
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
