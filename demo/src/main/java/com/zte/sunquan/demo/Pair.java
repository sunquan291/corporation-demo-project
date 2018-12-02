package com.zte.sunquan.demo;

/**
 * Created by 10184538 on 2017/5/25.
 */
public class Pair<T extends Comparable> {
    private T minValue;
    private T maxValue;

    public Pair(T minValue, T maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public T getMinValue() {
        return minValue;
    }

    public void setMinValue(T minValue) {
        this.minValue = minValue;
    }

    public T getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(T maxValue) {
        this.maxValue = maxValue;
    }

    private void print(String p) {
        System.out.println("pair:" + p);
    }
}
