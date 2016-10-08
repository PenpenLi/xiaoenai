package com.f.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import d.a.ax;
import d.a.cn;
import d.a.l;
import d.a.r;
import d.a.t;
import d.a.w;
import d.a.y;
import d.a.z.h;

public class g
  implements r
{
  private Context a = null;
  private f b;
  private d.a.k c = new d.a.k();
  private y d = new y();
  private w e = new w();
  private l f;
  private d.a.g g;
  private cn h = null;
  private boolean i = false;
  private boolean j = false;
  
  g()
  {
    this.c.a(this);
  }
  
  private void d(Context paramContext)
  {
    if (!this.i)
    {
      this.a = paramContext.getApplicationContext();
      this.f = new l(this.a);
      this.g = d.a.g.a(this.a);
      this.i = true;
      if (this.h == null) {
        this.h = cn.a(this.a);
      }
      if (!this.j) {
        m.b(new h(this));
      }
    }
  }
  
  private void e(Context paramContext)
  {
    this.e.c(paramContext);
    if (this.b != null) {
      this.b.a();
    }
  }
  
  private void f(Context paramContext)
  {
    this.e.d(paramContext);
    this.d.a(paramContext);
    if (this.b != null) {
      this.b.b();
    }
    this.g.b();
  }
  
  void a(long paramLong)
  {
    a.i = paramLong;
  }
  
  void a(Context paramContext)
  {
    if (paramContext == null)
    {
      ax.d("unexpected null context in onResume");
      return;
    }
    if (a.e) {
      this.d.a(paramContext.getClass().getName());
    }
    try
    {
      if (!this.i) {
        d(paramContext);
      }
      m.a(new j(this, paramContext));
      return;
    }
    catch (Exception paramContext)
    {
      ax.b("Exception occurred in Mobclick.onResume(). ", paramContext);
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    a.a(paramContext, paramInt);
  }
  
  void a(Context paramContext, b.a parama)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
    if (parama != null) {
      a(paramContext, parama.a());
    }
  }
  
  void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramContext == null)
    {
      ax.d("unexpected null context in reportError");
      return;
    }
    try
    {
      if (!this.i) {
        d(paramContext);
      }
      paramContext = new z.h();
      paramContext.a = System.currentTimeMillis();
      paramContext.b = 2L;
      paramContext.c = paramString;
      this.g.a(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      ax.a(paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      if (!this.i) {
        d(paramContext);
      }
      this.f.a(paramString1, paramString2, paramLong, paramInt);
      return;
    }
    catch (Exception paramContext)
    {
      ax.a(paramContext);
    }
  }
  
  void a(b.b paramb)
  {
    if (paramb.e != null) {
      this.a = paramb.e.getApplicationContext();
    }
    if (!TextUtils.isEmpty(paramb.a))
    {
      a.a(paramb.e, paramb.a);
      if (!TextUtils.isEmpty(paramb.b)) {
        a.a(paramb.b);
      }
      a.h = paramb.c;
      a(this.a, paramb.d);
      return;
    }
    ax.d("the appkey is null!");
  }
  
  public void a(Throwable paramThrowable)
  {
    try
    {
      this.d.a();
      if (this.a != null)
      {
        if ((paramThrowable != null) && (this.g != null))
        {
          z.h localh = new z.h();
          localh.a = System.currentTimeMillis();
          localh.b = 1L;
          localh.c = e.a(paramThrowable);
          this.g.a(localh);
        }
        this.h.b();
        f(this.a);
        t.a(this.a).edit().commit();
      }
      m.a();
      return;
    }
    catch (Exception paramThrowable)
    {
      ax.b("Exception in onAppCrash", paramThrowable);
    }
  }
  
  void a(boolean paramBoolean)
  {
    d.a = paramBoolean;
  }
  
  void b(Context paramContext)
  {
    if (paramContext == null)
    {
      ax.d("unexpected null context in onPause");
      return;
    }
    if (a.e) {
      this.d.b(paramContext.getClass().getName());
    }
    try
    {
      if (!this.i) {
        d(paramContext);
      }
      m.a(new k(this, paramContext));
      return;
    }
    catch (Exception paramContext)
    {
      ax.b("Exception occurred in Mobclick.onRause(). ", paramContext);
    }
  }
  
  void b(boolean paramBoolean)
  {
    ax.a = paramBoolean;
    com.f.a.a.a.b = paramBoolean;
  }
  
  void c(Context paramContext)
  {
    try
    {
      this.d.a();
      f(paramContext);
      t.a(paramContext).edit().commit();
      this.h.a();
      m.a();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  void c(boolean paramBoolean)
  {
    a.a(paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\f\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */