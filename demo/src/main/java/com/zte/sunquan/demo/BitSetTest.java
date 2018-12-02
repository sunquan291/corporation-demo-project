package com.zte.sunquan.demo;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

/**
 * Created by 10184538 on 2017/6/8.
 */
public class BitSetTest {
    @Test
    public void test1() {
        BitSet bitSet = new BitSet();
        Assert.assertTrue(bitSet.isEmpty());
        Assert.assertTrue(bitSet.size() == 64);
        bitSet = new BitSet(65);
        Assert.assertTrue(bitSet.isEmpty());
        Assert.assertTrue(bitSet.size() == 128);
        bitSet.set(10, 12);
        Assert.assertFalse(bitSet.isEmpty());
        System.out.println(bitSet.toString());
        String result = bitSet.toString();
        result=result.substring(1,result.length()-1).replace(" ","");
        BitSet otherSet = new BitSet();
        for (String s : result.split(",")) {
            otherSet.set(Integer.parseInt(s));
        }
        System.out.println(otherSet.toString());

        printBitSet(bitSet);
    }

    public void printBitSet(BitSet bs) {
        StringBuffer buf = new StringBuffer();
        buf.append("[\n");
        for (int i = 0; i < bs.size(); i++) {
            if (i < bs.size() - 1) {
                buf.append((bs.get(i)) + ",");
            } else {
                buf.append((bs.get(i)));
            }
            if ((i + 1) % 8 == 0 && i != 0) {
                buf.append("\n");
            }
        }
        buf.append("]");
        System.out.println(buf.toString());
    }
}
