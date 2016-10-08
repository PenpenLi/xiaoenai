package com.alipay.android.phone.mrpc.core;

import android.content.Context;

public final class h
  extends w
{
  private Context a;
  
  public h(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final <T> T a(Class<T> paramClass, aa paramaa)
  {
    return (T)new x(new i(this, paramaa)).a(paramClass);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\android\phone\mrpc\core\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */