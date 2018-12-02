package com.zte.sunquan.demo;

import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * Created by 10184538 on 2017/5/25.
 */
public class MaxQuery {
    public static <T extends Comparable> Pair<T> sort(T[] arrays) {
        Objects.requireNonNull(arrays);
        Preconditions.checkArgument(arrays.length > 0);
        T min = arrays[0];
        T max = arrays[0];
        for (T t : arrays) {
            if (t.compareTo(max) > 0)
                max = t;
            if (t.compareTo(min) < 0)
                min = t;
        }
        return new Pair<>(min, max);
    }

    public static Pair sort(int[] arrays) {
        Objects.requireNonNull(arrays);
        Preconditions.checkArgument(arrays.length > 0);
        int min = arrays[0];
        int max = arrays[0];
        for (int t : arrays) {
            if (t > max)
                max = t;
            if (t < min)
                min = t;
        }
        //会自动将int包装成Integer
        return new Pair<>(min, max);
    }

    public static Pair sort(long[] arrays) {
        Objects.requireNonNull(arrays);
        Preconditions.checkArgument(arrays.length > 0);
        long min = arrays[0];
        long max = arrays[0];
        for (long t : arrays) {
            if (t > max)
                max = t;
            if (t < min)
                min = t;
        }
        return new Pair<>(min, max);
    }

    public static Pair sort(short[] arrays) {
        Objects.requireNonNull(arrays);
        Preconditions.checkArgument(arrays.length > 0);
        short min = arrays[0];
        short max = arrays[0];
        for (short t : arrays) {
            if (t > max)
                max = t;
            if (t < min)
                min = t;
        }
        return new Pair<>(min, max);
    }

    public static Pair sort(float[] arrays) {
        Objects.requireNonNull(arrays);
        Preconditions.checkArgument(arrays.length > 0);
        float min = arrays[0];
        float max = arrays[0];
        for (float t : arrays) {
            if (t > max)
                max = t;
            if (t < min)
                min = t;
        }
        return new Pair<>(min, max);
    }

    public static Pair sort(double[] arrays) {
        Objects.requireNonNull(arrays);
        Preconditions.checkArgument(arrays.length > 0);
        double min = arrays[0];
        double max = arrays[0];
        for (double t : arrays) {
            if (t > max)
                max = t;
            if (t < min)
                min = t;
        }
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        //查询集合里的最大值与最小值
        int[] a = {12, 1, 33, 44, 2, 4, 0};
        Pair pair = MaxQuery.sort(a);
        System.out.println(pair.getMaxValue());
        System.out.println(pair.getMinValue());
        //基本类型
        double[] b = {12, 1, 33, 44, 2, 4, 0};
        pair = MaxQuery.sort(b);
        System.out.println(pair.getMaxValue());
        System.out.println(pair.getMinValue());

    }
}

