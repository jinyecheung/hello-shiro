package com.example.hello.shiro.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BeanConvertUtil {

    public static <T> T convertBean(Object source,Class<T> targetClass) {
        T target = BeanUtils.instantiateClass(targetClass);
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> List<T> convertBeanList(List<?> sourceList,Class<T> targetClass) {
        List<T> list = new ArrayList<T>();
        if(sourceList == null || sourceList.size() == 0) {
            return list;
        }
        for (Object source : sourceList) {
            T target = BeanUtils.instantiateClass(targetClass);
            BeanUtils.copyProperties(source, target);
            list.add(target);
        }
        return list;
    }

    public static <T> List<T> convertBeanList(List<?> sourceList, Class<T> targetClass, Consumer<T> consumer){
        List<T> list = new ArrayList<>();
        if(sourceList == null || sourceList.size() == 0) {
            return list;
        }
        for (Object source : sourceList) {
            T target = BeanUtils.instantiateClass(targetClass);
            BeanUtils.copyProperties(source, target);
            consumer.accept(target);
            list.add(target);
        }
        return list;
    }
}

