package cn.org.shutter.core.web.converter;

import cn.org.shutter.core.common.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import javax.annotation.Nonnull;

/**
 * 枚举转换器。
 *
 * @author xuepeng
 */
public class EnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    /**
     * 将请求参数中的枚举数据转换成枚举对象。
     *
     * @param targetType 枚举类型对象。
     * @param <T>        继承BaseEnum的枚举类型。
     * @return 转换后的枚举对象。
     */
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(@Nonnull Class<T> targetType) {
        return source -> {
            for (T t : targetType.getEnumConstants()) {
                if (t.getCode().equals(Integer.valueOf(source))) {
                    return t;
                }
            }
            return null;
        };
    }

}
