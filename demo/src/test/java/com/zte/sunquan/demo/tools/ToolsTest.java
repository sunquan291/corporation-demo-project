package com.zte.sunquan.demo.tools;

import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by 10184538 on 2017/1/24.
 */
public class ToolsTest {
    ByteBuffer buffer = null;

    @Before
    public void init() {
        byte array[] = new byte[1024];
        buffer = ByteBuffer.wrap(array);
    }

    @Test
    public void testByteBuffertoArray() {
        for (int i = 0; i < buffer.capacity(); i++)
            buffer.put((byte) i);
        //标识索引位置
        buffer.position(3);
        buffer.limit(7);
        //分片
        ByteBuffer slice = buffer.slice();
        //打印分片数据并修改
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            System.out.println(b);
            b *= 11;
            slice.put(i, b);
        }
        System.out.println("==========");
        //打印所有
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

        byte[] bytes = Tools.byteBuffertoArray(buffer);

    }
}
