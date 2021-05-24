import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface VlastniAnotace {

    FormatEnum value() default FormatEnum.NONE;

    String fieldName() default "";

    String[] codes() default {};

}
