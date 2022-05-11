package fhw.demo.gwt.crud.provider.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;

/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-06 20:08
 */


public class WrapperUtils {
    public static <T> LambdaQueryWrapper<T> getQueryWrapper() {
        LambdaQueryWrapper<T> tLambdaQueryWrapper = new LambdaQueryWrapper<>();
        return tLambdaQueryWrapper;
    }

    public static <T> LambdaUpdateWrapper<T> getUpdateWrapper() {
        LambdaUpdateWrapper<T> tLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        return tLambdaUpdateWrapper;
    }
}
