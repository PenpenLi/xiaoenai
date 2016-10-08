package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Component
{
  @Documented
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface Builder {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\dagger\Component.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */