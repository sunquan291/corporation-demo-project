package com.zte.sunquan.demo.dir;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 10184538 on 2018/5/29.
 */
public class FileHelperTest {
    private File dstDirectory = null;

    @Before
    public void init() throws IOException {
        dstDirectory = new File(FileHelperTest.class.getResource("/").getPath() + "tmp");
        if (dstDirectory.exists())
            FileUtils.deleteDirectory(dstDirectory);
        if (dstDirectory.mkdirs())
            FileUtils.copyDirectory(new File("E:\\zlt\\rt"), dstDirectory);
    }

    @Test
    public void testDirDel() throws IOException {
        FileUtils.deleteDirectory(dstDirectory);
        Assert.assertTrue(!dstDirectory.exists());
    }
}
