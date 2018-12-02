package com.zte.sunquan.demo.actor.linecount;

import java.io.Serializable;

/**
 * Created by 10184538 on 2016/10/25.
 */
public class LineCalculatedMsg implements Serializable{
    private  int words;
    public LineCalculatedMsg(int words){
        this.words=words;
    }

    public int getWords() {
        return words;
    }
}
