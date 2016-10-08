package com.qiniu.android.dns;

public final class h
{
  public final String a;
  public final int b;
  public final int c;
  public final long d;
  
  public h(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
  }
  
  public boolean a()
  {
    return this.b == 5;
  }
  
  public boolean a(long paramLong)
  {
    return this.d + this.c < paramLong;
  }
  
  public boolean b()
  {
    return a(System.currentTimeMillis() / 1000L);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof h))) {
        return false;
      }
      paramObject = (h)paramObject;
    } while ((this.a.equals(((h)paramObject).a)) && (this.b == ((h)paramObject).b) && (this.c == ((h)paramObject).c) && (this.d == ((h)paramObject).d));
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */