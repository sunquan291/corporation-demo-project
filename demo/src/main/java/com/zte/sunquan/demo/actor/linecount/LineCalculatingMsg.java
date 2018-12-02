package com.zte.sunquan.demo.actor.linecount;

import java.io.Serializable;

/**
 * Created by 10184538 on 2016/10/25.
 */
public class LineCalculatingMsg implements Serializable {
    private String line;
    public LineCalculatingMsg(String line){
        this.line=line;
    }

    public String getLine() {
        return line;
    }
}
