// Generated from E:/sunquan-project/antlr-test/src/main/resources\Jiav.g4 by ANTLR 4.6
package com.sunquan.demo.antlr2.gen;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link JiavVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class JiavBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements JiavVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpres(JiavParser.ExpresContext ctx) { return visitChildren(ctx); }
}