package com.zte.sunquan.demo.compile;

import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;

/**
 * Created by 10184538 on 2017/7/20.
 */
public class Meme extends ForwardingJavaFileManager {
    /**
     * Creates a new instance of ForwardingJavaFileManager.
     *
     * @param fileManager delegate to this file manager
     */
    protected Meme(JavaFileManager fileManager) {
        super(fileManager);
    }
}
