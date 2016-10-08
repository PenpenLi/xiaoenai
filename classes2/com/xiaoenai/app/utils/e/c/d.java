package com.xiaoenai.app.utils.e.c;

import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import com.xiaoenai.app.utils.e.a;
import com.xiaoenai.app.utils.e.a.c;

public class d
{
  final boolean a;
  final boolean b;
  final boolean c;
  final Bitmap.Config d;
  final Object e;
  final Drawable f;
  final Drawable g;
  final Drawable h;
  final int i;
  final int j;
  final int k;
  final c l;
  final int m;
  final int n;
  final Integer o;
  final float p;
  final int q;
  final a r;
  
  public d(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
    this.k = 0;
    this.l = a.k(parama);
    this.m = a.l(parama);
    this.n = a.m(parama);
    this.o = a.n(parama);
    this.p = a.o(parama);
    this.q = a.p(parama);
    this.r = a.q(parama);
  }
  
  static d a()
  {
    return new a().a();
  }
  
  public static class a
  {
    private boolean a = false;
    private boolean b = true;
    private boolean c = true;
    private Bitmap.Config d = Bitmap.Config.RGB_565;
    private Object e = null;
    private Drawable f = null;
    private Drawable g = null;
    private Drawable h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private c l = c.c;
    private int m = 0;
    private int n = 0;
    private Integer o = null;
    private float p = 0.0F;
    private int q = 0;
    private a r = null;
    
    public a a(int paramInt)
    {
      this.m = paramInt;
      return this;
    }
    
    public a a(Bitmap.Config paramConfig)
    {
      this.d = paramConfig;
      return this;
    }
    
    public a a(Drawable paramDrawable)
    {
      this.f = paramDrawable;
      return this;
    }
    
    public a a(c paramc)
    {
      this.l = paramc;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      return this;
    }
    
    public d a()
    {
      return new d(this);
    }
    
    public a b(int paramInt)
    {
      this.i = paramInt;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.j = paramInt;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.c = paramBoolean;
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\e\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */