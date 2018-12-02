package com.zte.sunquan.demo;

/**
 * Created by 10184538 on 2017/6/12.
 */
public class RangeValue {
    private Object minValue;
    private Object maxValue;

    public RangeValue(Object minValue, Object maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RangeValue{");
        sb.append("minValue=").append(minValue);
        sb.append(", maxValue=").append(maxValue);
        sb.append('}');
        return sb.toString();
    }

    public boolean isEqualValue() {
        if (minValue.toString().equals(maxValue.toString()))
            return true;
        return false;
    }

    public Object getMinValue() {
        return minValue;
    }

    public void setMinValue(Object minValue) {
        this.minValue = minValue;
    }

    public Object getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Object maxValue) {
        this.maxValue = maxValue;
    }
}
