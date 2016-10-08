package com.xiaoenai.app.data.d;

import java.util.LinkedList;

public final class i
{
  private static i c;
  private LinkedList<String> a = new LinkedList();
  private int b = 0;
  
  private i()
  {
    this.a.add("http://upxea.qiniu.com/");
    this.a.add("http://upxea2.qiniu.com/");
    this.a.add("http://up.qiniu.com/");
  }
  
  public static i a()
  {
    try
    {
      if (c == null) {
        c = new i();
      }
      i locali = c;
      return locali;
    }
    finally {}
  }
  
  public String b()
  {
    return (String)this.a.get(this.b);
  }
  
  public void c()
  {
    this.b += 1;
    if (this.b > this.a.size()) {
      this.b = 0;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */