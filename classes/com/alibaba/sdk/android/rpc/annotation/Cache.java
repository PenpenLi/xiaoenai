package com.alibaba.sdk.android.rpc.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Cache
{
  public static final int INHABITANTS_CACHE = 2;
  public static final int TRAVELERS_CACHE = 1;
  
  int value() default 1;
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\annotation\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */