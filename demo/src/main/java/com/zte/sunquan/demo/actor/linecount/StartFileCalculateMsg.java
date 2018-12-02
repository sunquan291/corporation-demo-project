package com.zte.sunquan.demo.actor.linecount;

import java.io.Serializable;

/**
 * Created by 10184538 on 2016/10/25.
 */
public class StartFileCalculateMsg implements Serializable {

    private String path;
    public StartFileCalculateMsg(String filePath) {
        this.path=filePath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
