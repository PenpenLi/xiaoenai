package com.xiaoenai.app.feature.photopicker.a;

public class c
  implements d
{
  private int a;
  private String b;
  private boolean c = false;
  private String d;
  
  public c() {}
  
  public c(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.d = paramString2;
  }
  
  public String a()
  {
    return "file://" + this.b;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */