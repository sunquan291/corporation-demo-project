package com.zte.sunquan.demo.annotation;

import java.lang.reflect.Method;

/**
 * AnnotationUtil class
 *
 * @author 10184538
 * @date 2019/6/28
 */
public class AnnotationUtil {
    /**
     * 获取当前方法中在接口中配置的apiOperation内容
     *
     * @param parameterClass 参数类型
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getApiOperation(Class... parameterClass) {
        String apiOperationName = null;
        try {
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            apiOperationName = methodName;
            String className = Thread.currentThread().getStackTrace()[2].getClassName();
            Class<?>[] interfaces = Class.forName(className).getInterfaces();
            for (Class aClass : interfaces) {
                Method method = aClass.getMethod(methodName, parameterClass);
                System.out.println(method);
//                if (method != null) {
//                    apiOperationName = method.getAnnotation(ApiOperation.class).value();
//                    break;
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiOperationName;
    }

}
