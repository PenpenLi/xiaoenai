package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

public final class x
{
  private g a;
  private z b;
  
  public x(g paramg)
  {
    this.a = paramg;
    this.b = new z(this);
  }
  
  public final g a()
  {
    return this.a;
  }
  
  public final <T> T a(Class<T> paramClass)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    y localy = new y(this.a, paramClass, this.b);
    return (T)Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, localy);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\android\phone\mrpc\core\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */