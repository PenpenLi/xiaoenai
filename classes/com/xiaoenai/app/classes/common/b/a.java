package com.xiaoenai.app.classes.common.b;

import com.xiaoenai.app.d.m;
import java.util.List;

public class a
{
  private static a a;
  private static m b;
  
  private a()
  {
    b = new m();
  }
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    b.a(paramInt);
  }
  
  public void a(b paramb)
  {
    b.a(paramb);
  }
  
  public void a(String paramString)
  {
    b.a(paramString);
  }
  
  public List<b> b()
  {
    return b.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */