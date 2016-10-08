package com.xiaoenai.app.classes.forum.b;

import com.xiaoenai.app.model.g;
import java.util.List;

public class d
{
  private static d b;
  private a a = new a();
  
  public static d a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new d();
      }
      return b;
    }
    finally {}
  }
  
  public List<g> a(int paramInt1, int paramInt2)
  {
    return this.a.a(paramInt1, paramInt2);
  }
  
  public void a(List<g> paramList)
  {
    this.a.a(paramList);
  }
  
  public void b()
  {
    this.a.b();
  }
  
  public int c()
  {
    return this.a.c();
  }
  
  public void d()
  {
    this.a = null;
    b = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */