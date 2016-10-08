package dagger.multibindings;

import dagger.MapKey;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@MapKey
@Documented
@Target({java.lang.annotation.ElementType.METHOD})
public @interface ClassKey {}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\dagger\multibindings\ClassKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */