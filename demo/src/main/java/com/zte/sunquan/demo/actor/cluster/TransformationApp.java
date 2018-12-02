package com.zte.sunquan.demo.actor.cluster;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class TransformationApp {

    public static void main(String[] args) {
        // starting 2 frontend nodes and 3 backend nodes

        TransformationBackendMain.main(new String[]{"2551"});
        TransformationBackendMain.main(new String[]{"2552"});
        TransformationBackendMain.main(new String[0]);
        TransformationFrontendMain.main(new String[0]);
    }
}
