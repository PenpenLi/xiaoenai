package com.c.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.c.a.a;
import com.c.a.a.a;
import com.c.a.ad;
import com.c.a.ad.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class c
  extends b
{
  ArrayList<b> a = new ArrayList();
  private final WeakReference<View> b;
  private long c;
  private boolean d = false;
  private long e = 0L;
  private boolean f = false;
  private Interpolator g;
  private boolean h = false;
  private a.a i = null;
  private a j = new a(null);
  private Runnable k = new d(this);
  private HashMap<a, c> l = new HashMap();
  
  c(View paramView)
  {
    this.b = new WeakReference(paramView);
  }
  
  private float a(int paramInt)
  {
    View localView = (View)this.b.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 1: 
      return localView.getTranslationX();
    case 2: 
      return localView.getTranslationY();
    case 16: 
      return localView.getRotation();
    case 32: 
      return localView.getRotationX();
    case 64: 
      return localView.getRotationY();
    case 4: 
      return localView.getScaleX();
    case 8: 
      return localView.getScaleY();
    case 128: 
      return localView.getX();
    case 256: 
      return localView.getY();
    }
    return localView.getAlpha();
  }
  
  private void a()
  {
    ad localad = ad.b(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.a.clone();
    this.a.clear();
    int i1 = localArrayList.size();
    int m = 0;
    int n = 0;
    while (m < i1)
    {
      n |= ((b)localArrayList.get(m)).a;
      m += 1;
    }
    this.l.put(localad, new c(n, localArrayList));
    localad.a(this.j);
    localad.a(this.j);
    if (this.f) {
      localad.e(this.e);
    }
    if (this.d) {
      localad.c(this.c);
    }
    if (this.h) {
      localad.a(this.g);
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
    if (this.l.size() > 0)
    {
      Iterator localIterator = this.l.keySet().iterator();
      c localc;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (a)localIterator.next();
        localc = (c)this.l.get(localObject);
      } while ((!localc.a(paramInt)) || (localc.a != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((a)localObject).b();
      }
      localObject = new b(paramInt, paramFloat1, paramFloat2);
      this.a.add(localObject);
      localObject = (View)this.b.get();
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(this.k);
        ((View)localObject).post(this.k);
      }
      return;
      localObject = null;
    }
  }
  
  private void b(int paramInt, float paramFloat)
  {
    View localView = (View)this.b.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localView.setTranslationX(paramFloat);
      return;
    case 2: 
      localView.setTranslationY(paramFloat);
      return;
    case 16: 
      localView.setRotation(paramFloat);
      return;
    case 32: 
      localView.setRotationX(paramFloat);
      return;
    case 64: 
      localView.setRotationY(paramFloat);
      return;
    case 4: 
      localView.setScaleX(paramFloat);
      return;
    case 8: 
      localView.setScaleY(paramFloat);
      return;
    case 128: 
      localView.setX(paramFloat);
      return;
    case 256: 
      localView.setY(paramFloat);
      return;
    }
    localView.setAlpha(paramFloat);
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
    this.d = true;
    this.c = paramLong;
    return this;
  }
  
  public b a(a.a parama)
  {
    this.i = parama;
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
    
    public void a(a parama)
    {
      if (c.b(c.this) != null) {
        c.b(c.this).a(parama);
      }
      c.c(c.this).remove(parama);
      if (c.c(c.this).isEmpty()) {
        c.a(c.this, null);
      }
    }
    
    public void a(ad paramad)
    {
      float f1 = paramad.m();
      paramad = (c.c)c.c(c.this).get(paramad);
      Object localObject;
      if ((paramad.a & 0x1FF) != 0)
      {
        localObject = (View)c.d(c.this).get();
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
          localObject = (c.b)paramad.get(i);
          float f2 = ((c.b)localObject).b;
          float f3 = ((c.b)localObject).c;
          c.a(c.this, ((c.b)localObject).a, f2 + f3 * f1);
          i += 1;
        }
      }
      paramad = (View)c.d(c.this).get();
      if (paramad != null) {
        paramad.invalidate();
      }
    }
    
    public void b(a parama)
    {
      if (c.b(c.this) != null) {
        c.b(c.this).b(parama);
      }
    }
    
    public void c(a parama)
    {
      if (c.b(c.this) != null) {
        c.b(c.this).c(parama);
      }
    }
    
    public void d(a parama)
    {
      if (c.b(c.this) != null) {
        c.b(c.this).d(parama);
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
    ArrayList<c.b> b;
    
    c(int paramInt, ArrayList<c.b> paramArrayList)
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
          if (((c.b)this.b.get(i)).a == paramInt)
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */