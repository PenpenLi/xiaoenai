package com.xiaoenai.app.utils.f.a;

import android.text.TextUtils;
import com.xiaoenai.app.utils.f.b.a;
import com.xiaoenai.app.utils.f.b.b;

public final class c
{
  final com.xiaoenai.app.utils.f.b.c a;
  final com.xiaoenai.app.utils.f.b.c b;
  final int c;
  final String d;
  final int e;
  final boolean f;
  final boolean g;
  final boolean h;
  
  public c(a parama)
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
    private com.xiaoenai.app.utils.f.b.c a;
    private com.xiaoenai.app.utils.f.b.c b;
    private int c = -1;
    private String d;
    private int e = 6;
    private boolean f = true;
    private boolean g = false;
    private boolean h = false;
    
    private void b()
    {
      if (this.a == null) {
        this.a = new b();
      }
      if (this.b == null) {
        this.b = new b();
      }
      if (this.c < 0) {
        this.c = 8;
      }
      if (TextUtils.isEmpty(this.d)) {
        this.d = "xiaoenai";
      }
    }
    
    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a a(a parama)
    {
      this.a = parama;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }
    
    public c a()
    {
      b();
      return new c(this);
    }
    
    public a b(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */