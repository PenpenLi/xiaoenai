package com.alipay.android.phone.mrpc.core;

public final class p
  extends u
{
  private int c;
  private String d;
  private long e;
  private long f;
  private String g;
  private HttpUrlHeader h;
  
  public p(HttpUrlHeader paramHttpUrlHeader, int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    this.h = paramHttpUrlHeader;
    this.c = paramInt;
    this.d = paramString;
    this.a = paramArrayOfByte;
  }
  
  public final HttpUrlHeader a()
  {
    return this.h;
  }
  
  public final void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
  }
  
  public final void b(long paramLong)
  {
    this.f = paramLong;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\android\phone\mrpc\core\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */