package com.zte.sunquan.demo;

import com.zte.sdn.oscp.commons.utils.ValueUtils;
import com.zte.sdn.oscp.persistence.model.Column;
import com.zte.sdn.oscp.persistence.validator.DataValidator;
import com.zte.sdn.oscp.persistence.validator.exceptions.DataValidateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by 10184538 on 2017/6/12.
 */
public class RangeValidate extends DataValidator {
    private Class type;
    //default
    private Object maxValue = null;
    private Object minValue = null;
    private String rangeContent;

    private List<RangeValue> rangeValues = new ArrayList<>();


    public RangeValidate(String rangeContent) {
        this.rangeContent = rangeContent.replace(" ", "");
        initilize();
    }

    public RangeValidate(Class<?> classType, Column column) {
        super(classType, column);
        initilize();
    }

    public RangeValidate(String rangeContent, Class type) {
        this.rangeContent = rangeContent.replace(" ", "");
        this.type = type;
        initilize();
    }

    public RangeValidate(String rangeContent, Class type, Object minValue, Object maxValue) {
        this.rangeContent = rangeContent.replace(" ", "");
        this.type = type;
        this.maxValue = maxValue;
        this.minValue = minValue;
        initilize();
    }

    @Override
    public void validate(Object instance) throws DataValidateException {
        Object value = this.getValue(instance);
        if (!this.isValid(value)) {
            this.throwDataValidateException(DataValidateException.INVALIDATE_RANGE, value);
        }
    }


    public boolean isValid(Object value) {
        boolean validate = false;
        for (RangeValue rangeValue : this.rangeValues) {
            if (rangeValue.isEqualValue()) {
                validate = value.toString().equals(rangeValue.getMaxValue().toString());
            } else {
                validate = ValueUtils.compare(value, rangeValue.getMinValue()) >= 0 && ValueUtils.compare(value, rangeValue.getMaxValue()) <= 0;
            }
            if (validate)
                break;
        }
        return validate;
    }

    public Object getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Object maxValue) {
        this.maxValue = maxValue;
    }

    public Object getMinValue() {
        return minValue;
    }

    public void setMinValue(Object minValue) {
        this.minValue = minValue;
    }

    public String getRangeContent() {
        return rangeContent;
    }

    public void setCls(Class type) {
        this.type = type;
    }

    public void setRangeContent(String rangeContent) {
        this.rangeContent = rangeContent;
    }

    public List<RangeValue> getRangeValues() {
        return rangeValues;
    }

    public void setRangeValues(List<RangeValue> rangeValues) {
        this.rangeValues = rangeValues;
    }


    private void initilize() {
        Objects.requireNonNull(rangeContent);
        String[] split = rangeContent.split("\\|");
        for (String content : split) {
            String[] args = content.split("\\.\\.");
            if (args.length == 2) {
                Object min = ValueUtils.parseValue(type, args[0]);
                Object max = ValueUtils.parseValue(type, args[1]);
                if (args[0].equals("min"))
                    min = minValue;
                if (args[1].equals("max"))
                    max = maxValue;
                rangeValues.add(new RangeValue(min, max));
            } else if (args.length == 1) {
                Object value = ValueUtils.parseValue(type, content);
                rangeValues.add(new RangeValue(value, value));
            }
        }
    }
}
