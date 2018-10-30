package springboor.email.commont.dynamicQuery;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)//注解保留时间（RUNTIME运行时）
public @interface NativeQueryResultEntity {
}
