package com.alipay.sdk.protocol;

import com.alipay.sdk.data.e;
import com.alipay.sdk.data.f;

public abstract class h
  extends c
{
  public static final int d = 4;
  public static final int e = 6;
  public static final int f = 7;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = -10;
  boolean k = false;
  
  protected h(e parame, f paramf)
  {
    super(parame, paramf);
  }
  
  private void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  private boolean d()
  {
    return this.k;
  }
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract String c();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\protocol\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */