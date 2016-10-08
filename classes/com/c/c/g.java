package com.c.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.c.a.a.a;
import com.c.a.ad;
import com.c.a.ad.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class g
  extends b
{
  ArrayList<b> a = new ArrayList();
  private final com.c.c.a.a b;
  private final WeakReference<View> c;
  private long d;
  private boolean e = false;
  private long f = 0L;
  private boolean g = false;
  private Interpolator h;
  private boolean i = false;
  private a.a j = null;
  private a k = new a(null);
  private Runnable l = new h(this);
  private HashMap<com.c.a.a, c> m = new HashMap();
  
  g(View paramView)
  {
    this.c = new WeakReference(paramView);
    this.b = com.c.c.a.a.a(paramView);
  }
  
  private float a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 1: 
      return this.b.k();
    case 2: 
      return this.b.l();
    case 16: 
      return this.b.d();
    case 32: 
      return this.b.e();
    case 64: 
      return this.b.f();
    case 4: 
      return this.b.g();
    case 8: 
      return this.b.h();
    case 128: 
      return this.b.m();
    case 256: 
      return this.b.n();
    }
    return this.b.a();
  }
  
  private void a()
  {
    ad localad = ad.b(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.a.clone();
    this.a.clear();
    int i2 = localArrayList.size();
    int n = 0;
    int i1 = 0;
    while (n < i2)
    {
      i1 |= ((b)localArrayList.get(n)).a;
      n += 1;
    }
    this.m.put(localad, new c(i1, localArrayList));
    localad.a(this.k);
    localad.a(this.k);
    if (this.g) {
      localad.e(this.f);
    }
    if (this.e) {
      localad.c(this.d);
    }
    if (this.i) {
      localad.a(this.h);
    }
    localad.a();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    float f1 = a(paramInt);
    a(paramInt, f1, paramFloat - f1);
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (this.m.size() > 0)
    {
      Iterator localIterator = this.m.keySet().iterator();
      c localc;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.c.a.a)localIterator.next();
        localc = (c)this.m.get(localObject);
      } while ((!localc.a(paramInt)) || (localc.a != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((com.c.a.a)localObject).b();
      }
      localObject = new b(paramInt, paramFloat1, paramFloat2);
      this.a.add(localObject);
      localObject = (View)this.c.get();
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(this.l);
        ((View)localObject).post(this.l);
      }
      return;
      localObject = null;
    }
  }
  
  private void b(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.b.i(paramFloat);
      return;
    case 2: 
      this.b.j(paramFloat);
      return;
    case 16: 
      this.b.d(paramFloat);
      return;
    case 32: 
      this.b.e(paramFloat);
      return;
    case 64: 
      this.b.f(paramFloat);
      return;
    case 4: 
      this.b.g(paramFloat);
      return;
    case 8: 
      this.b.h(paramFloat);
      return;
    case 128: 
      this.b.k(paramFloat);
      return;
    case 256: 
      this.b.l(paramFloat);
      return;
    }
    this.b.a(paramFloat);
  }
  
  public b a(float paramFloat)
  {
    a(1, paramFloat);
    return this;
  }
  
  public b a(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.e = true;
    this.d = paramLong;
    return this;
  }
  
  public b a(a.a parama)
  {
    this.j = parama;
    return this;
  }
  
  public b b(float paramFloat)
  {
    a(512, paramFloat);
    return this;
  }
  
  private class a
    implements a.a, ad.b
  {
    private a() {}
    
    public void a(com.c.a.a parama)
    {
      if (g.b(g.this) != null) {
        g.b(g.this).a(parama);
      }
      g.c(g.this).remove(parama);
      if (g.c(g.this).isEmpty()) {
        g.a(g.this, null);
      }
    }
    
    public void a(ad paramad)
    {
      float f1 = paramad.m();
      paramad = (g.c)g.c(g.this).get(paramad);
      Object localObject;
      if ((paramad.a & 0x1FF) != 0)
      {
        localObject = (View)g.d(g.this).get();
        if (localObject != null) {
          ((View)localObject).invalidate();
        }
      }
      paramad = paramad.b;
      if (paramad != null)
      {
        int j = paramad.size();
        int i = 0;
        while (i < j)
        {
          localObject = (g.b)paramad.get(i);
          float f2 = ((g.b)localObject).b;
          float f3 = ((g.b)localObject).c;
          g.a(g.this, ((g.b)localObject).a, f2 + f3 * f1);
          i += 1;
        }
      }
      paramad = (View)g.d(g.this).get();
      if (paramad != null) {
        paramad.invalidate();
      }
    }
    
    public void b(com.c.a.a parama)
    {
      if (g.b(g.this) != null) {
        g.b(g.this).b(parama);
      }
    }
    
    public void c(com.c.a.a parama)
    {
      if (g.b(g.this) != null) {
        g.b(g.this).c(parama);
      }
    }
    
    public void d(com.c.a.a parama)
    {
      if (g.b(g.this) != null) {
        g.b(g.this).d(parama);
      }
    }
  }
  
  private static class b
  {
    int a;
    float b;
    float c;
    
    b(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.a = paramInt;
      this.b = paramFloat1;
      this.c = paramFloat2;
    }
  }
  
  private static class c
  {
    int a;
    ArrayList<g.b> b;
    
    c(int paramInt, ArrayList<g.b> paramArrayList)
    {
      this.a = paramInt;
      this.b = paramArrayList;
    }
    
    boolean a(int paramInt)
    {
      if (((this.a & paramInt) != 0) && (this.b != null))
      {
        int j = this.b.size();
        int i = 0;
        while (i < j)
        {
          if (((g.b)this.b.get(i)).a == paramInt)
          {
            this.b.remove(i);
            this.a &= (paramInt ^ 0xFFFFFFFF);
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */