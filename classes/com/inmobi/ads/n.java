package com.inmobi.ads;

import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class n
{
  private static final String a = n.class.getSimpleName();
  @NonNull
  private final ap b;
  @NonNull
  private final Map<View, b> c;
  @NonNull
  private final Map<View, b> d;
  @NonNull
  private final Handler e;
  @NonNull
  private final c f;
  private final long g;
  @Nullable
  private ap.c h;
  @NonNull
  private a i;
  
  n(b.f paramf, @NonNull ap paramap, @NonNull a parama)
  {
    this(new WeakHashMap(), new WeakHashMap(), paramap, new Handler(), paramf, parama);
  }
  
  n(@NonNull Map<View, b> paramMap1, @NonNull Map<View, b> paramMap2, @NonNull ap paramap, @NonNull Handler paramHandler, @NonNull b.f paramf, @NonNull a parama)
  {
    this.c = paramMap1;
    this.d = paramMap2;
    this.b = paramap;
    this.g = paramf.d();
    this.h = new n.1(this);
    this.b.a(this.h);
    this.e = paramHandler;
    this.f = new c();
    this.i = parama;
  }
  
  private static boolean b(long paramLong, int paramInt)
  {
    return SystemClock.uptimeMillis() - paramLong >= paramInt;
  }
  
  View a(@NonNull Object paramObject)
  {
    Iterator localIterator = this.c.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!((b)localEntry.getValue()).a.equals(paramObject));
    for (paramObject = (View)localEntry.getKey();; paramObject = null)
    {
      if (paramObject != null) {
        a((View)paramObject);
      }
      return (View)paramObject;
    }
  }
  
  void a()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Impression Tracker paused");
    this.b.g();
    this.e.removeCallbacksAndMessages(null);
    this.d.clear();
  }
  
  void a(View paramView)
  {
    this.c.remove(paramView);
    this.d.remove(paramView);
    this.b.a(paramView);
  }
  
  void a(View paramView, @NonNull Object paramObject, @NonNull b.f paramf)
  {
    b localb = (b)this.c.get(paramView);
    if ((localb != null) && (localb.a.equals(paramObject))) {
      return;
    }
    a(paramView);
    paramf = new b(paramObject, paramf.a(), paramf.b());
    this.c.put(paramView, paramf);
    this.b.a(paramView, paramObject, paramf.b);
  }
  
  void b()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Impression Tracker resumed");
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.b.a((View)localEntry.getKey(), ((b)localEntry.getValue()).a, ((b)localEntry.getValue()).b);
    }
    f();
    this.b.d();
  }
  
  void c()
  {
    this.c.clear();
    this.d.clear();
    this.b.g();
    this.e.removeMessages(0);
  }
  
  boolean d()
  {
    return !this.c.isEmpty();
  }
  
  void e()
  {
    c();
    this.b.e();
    this.h = null;
  }
  
  void f()
  {
    if (this.e.hasMessages(0)) {
      return;
    }
    this.e.postDelayed(this.f, this.g);
  }
  
  static abstract interface a
  {
    public abstract void a(View paramView, Object paramObject);
  }
  
  private static class b
  {
    Object a;
    int b;
    int c;
    long d = Long.MAX_VALUE;
    
    b(Object paramObject, int paramInt1, int paramInt2)
    {
      this.a = paramObject;
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    void a()
    {
      this.d = SystemClock.uptimeMillis();
    }
  }
  
  class c
    implements Runnable
  {
    @NonNull
    private final ArrayList<View> b = new ArrayList();
    
    c() {}
    
    public void run()
    {
      Iterator localIterator = n.b(n.this).entrySet().iterator();
      View localView;
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localView = (View)((Map.Entry)localObject).getKey();
        localObject = (n.b)((Map.Entry)localObject).getValue();
        if (n.a(((n.b)localObject).d, ((n.b)localObject).c))
        {
          n.c(n.this).a(localView, ((n.b)localObject).a);
          this.b.add(localView);
        }
      }
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localView = (View)localIterator.next();
        n.this.a(localView);
      }
      this.b.clear();
      if (!n.b(n.this).isEmpty()) {
        n.this.f();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */