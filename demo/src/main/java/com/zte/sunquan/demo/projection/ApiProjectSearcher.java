package com.zte.sunquan.demo.projection;

import java.io.InputStream;
import java.util.function.Consumer;

/**
 * Created by 10043533 on 2016-10-14.
 */
public interface ApiProjectSearcher {

    boolean match(String searchKey);

    void search(String searchFrom, String searchFileName, Consumer<InputStream> consumer);
}
