package com.xiaoenai.app.utils.e.c;

import android.content.Context;
import com.xiaoenai.app.utils.e.e.a;

public final class f
{
  final Context a;
  final int b;
  final int c;
  final int d;
  final int e;
  final int f;
  final d g;
  final a h;
  
  public f(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
  }
  
  public static class a
  {
    private Context a;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private a g = null;
    private d h = null;
    
    public a(Context paramContext)
    {
      this.a = paramContext.getApplicationContext();
    }
    
    private void b()
    {
      if (this.b == 0) {
        this.b = 3;
      }
      if (this.c == 0) {
        this.c = 3;
      }
      if (this.d == 0) {
        this.d = 2048;
      }
      if (this.e == 0)
      {
        float f1 = (float)Runtime.getRuntime().maxMemory();
        this.e = ((int)(10 / 100.0F * f1));
        this.e = 4194304;
      }
      if (this.f == 0) {
        this.f = 268435456;
      }
      if (this.h == null) {
        this.h = d.a();
      }
    }
    
    public a a(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
    
    public a a(d paramd)
    {
      this.h = paramd;
      return this;
    }
    
    public a a(a parama)
    {
      this.g = parama;
      return this;
    }
    
    public f a()
    {
      b();
      return new f(this);
    }
    
    public a b(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    public a e(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\e\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */