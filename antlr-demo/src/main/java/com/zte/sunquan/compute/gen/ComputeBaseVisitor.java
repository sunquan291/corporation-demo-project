// Generated from E:/zlt/corporation-demo-project/antlr-demo/src/main/resources\Compute.g4 by ANTLR 4.6
package com.zte.sunquan.compute.gen;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ComputeVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class ComputeBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ComputeVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpress(ComputeParser.ExpressContext ctx) { return visitChildren(ctx); }
}