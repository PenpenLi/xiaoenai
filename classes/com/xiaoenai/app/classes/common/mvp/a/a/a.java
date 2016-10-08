package com.xiaoenai.app.classes.common.mvp.a.a;

import com.xiaoenai.app.classes.common.mvp.view.b;
import java.util.List;

public abstract class a<T>
  implements com.xiaoenai.app.classes.common.mvp.a.a<T>
{
  protected boolean a;
  protected boolean b = false;
  protected int c;
  public int d = 20;
  protected b<T> e;
  
  public a(b<T> paramb)
  {
    this.e = paramb;
  }
  
  public void a()
  {
    com.xiaoenai.app.utils.f.a.c("reqPage", new Object[0]);
    this.c = 0;
    this.b = false;
    g();
  }
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public void a(List<T> paramList)
  {
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      com.xiaoenai.app.utils.f.a.c("offset = {} mOffset = {}", new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) });
      this.c += i;
      b localb;
      if ((this.e != null) && (!this.e.k_()))
      {
        localb = this.e;
        if (i < 20) {
          break label117;
        }
      }
      label117:
      for (boolean bool = true;; bool = false)
      {
        localb.a(bool);
        this.e.a(paramList, this.b);
        this.e.j_();
        this.a = false;
        return;
      }
    }
  }
  
  public void b()
  {
    com.xiaoenai.app.utils.f.a.c("reqPage", new Object[0]);
    if (this.c != 0)
    {
      this.b = true;
      g();
    }
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.e.h_();
    a();
  }
  
  public void e() {}
  
  public void f()
  {
    this.e = null;
  }
  
  public void g()
  {
    if (this.a) {}
    try
    {
      if (this.a) {
        return;
      }
      this.a = true;
      com.xiaoenai.app.utils.f.a.c("reqPage reqData", new Object[0]);
      a(this.c, this.b);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\mvp\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */