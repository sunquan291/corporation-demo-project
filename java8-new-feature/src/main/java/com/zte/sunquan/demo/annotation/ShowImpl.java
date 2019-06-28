package com.zte.sunquan.demo.annotation;

/**
 * ShowImpl class
 *
 * @author 10184538
 * @date 2019/6/28
 */
public class ShowImpl implements BInterface {
    @Override
    public void show() {
        String apiOperation = AnnotationUtil.getApiOperation(null);
    }

    public static void main(String[] args) {
        ShowImpl impl=new ShowImpl();
        impl.show();
    }
}
