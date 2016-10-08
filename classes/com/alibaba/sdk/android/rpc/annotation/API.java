package com.alibaba.sdk.android.rpc.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
public @interface API
{
  String protocol() default "";
  
  String value() default "";
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\annotation\API.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */