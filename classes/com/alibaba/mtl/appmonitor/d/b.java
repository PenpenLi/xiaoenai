package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import java.util.Set;

public class b
{
  private a a;
  private Set<String> c;
  private String name;
  
  public b(String paramString, Set<String> paramSet, int paramInt)
  {
    this.name = paramString;
    this.c = paramSet;
    this.a = a.a(paramInt);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      return false;
      bool = this.c.contains(paramString);
      if (this.a == a.b) {
        return bool;
      }
    } while (bool);
    return true;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  private static enum a
  {
    private a() {}
    
    public static a a(int paramInt)
    {
      if (paramInt == 0) {
        return c;
      }
      return b;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */