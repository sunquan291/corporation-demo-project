package com.zte.sunquan.demo;

import com.zte.sunquan.ext.SpringBootGp2Config;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: Livio
 * @Date: 2020/7/22 22:06
 */
public class SpringBootGpSelectImport implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{SpringBootGp2Config.class.getName()};
    }
}
