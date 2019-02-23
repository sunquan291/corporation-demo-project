// Generated from E:/zlt/corporation-demo-project/antlr-demo/src/main/resources\Compute.g4 by ANTLR 4.6
package com.zte.sunquan.compute.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ComputeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ComputeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ComputeParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpress(ComputeParser.ExpressContext ctx);
}