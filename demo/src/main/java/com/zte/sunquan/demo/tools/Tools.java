package com.zte.sunquan.demo.tools;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by 10184538 on 2017/1/24.
 */
public class Tools {
    public static byte[] byteBuffertoArray(ByteBuffer buffer) {
        int length = buffer.remaining();
        if (buffer.hasArray()) {
            int offset = buffer.arrayOffset() + buffer.position();
            return Arrays.copyOfRange(buffer.array(), offset, offset + length);
        }
        byte[] bytes = new byte[length];
        buffer.duplicate().get(bytes);
        return bytes;
    }
}
