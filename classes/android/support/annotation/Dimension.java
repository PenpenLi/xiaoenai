package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface Dimension
{
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Unit {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\annotation\Dimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */