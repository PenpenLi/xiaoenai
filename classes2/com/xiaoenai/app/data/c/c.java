package com.xiaoenai.app.data.c;

import com.xiaoenai.app.domain.c.b;

public class c
  extends Exception
{
  private b a;
  private int b;
  private String c;
  
  public c() {}
  
  public c(b paramb, int paramInt, String paramString)
  {
    this.a = paramb;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public b b()
  {
    return this.a;
  }
  
  public String getMessage()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */