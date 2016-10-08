package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Module {}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\dagger\Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */