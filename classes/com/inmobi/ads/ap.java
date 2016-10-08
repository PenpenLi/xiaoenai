package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

abstract class ap
{
  static final a a = new ap.1();
  private static final String b = ap.class.getSimpleName();
  @NonNull
  private final ArrayList<View> c;
  private long d = 0L;
  private boolean e = true;
  @NonNull
  private final Map<View, d> f;
  @NonNull
  private final a g;
  @Nullable
  private c h;
  @NonNull
  private final b i;
  @NonNull
  private final Handler j;
  private boolean k;
  
  ap()
  {
    this(a);
  }
  
  ap(a parama)
  {
    this(new WeakHashMap(10), parama, new Handler(Looper.getMainLooper()));
  }
  
  private ap(@NonNull Map<View, d> paramMap, @NonNull a parama, @NonNull Handler paramHandler)
  {
    this.f = paramMap;
    this.g = parama;
    this.j = paramHandler;
    this.i = new b();
    this.c = new ArrayList(50);
  }
  
  private void a(long paramLong)
  {
    Iterator localIterator = this.f.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((d)localEntry.getValue()).b < paramLong) {
        this.c.add(localEntry.getKey());
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      a((View)localIterator.next());
    }
    this.c.clear();
  }
  
  protected abstract int a();
  
  protected void a(@NonNull View paramView)
  {
    if ((d)this.f.remove(paramView) != null)
    {
      this.d -= 1L;
      if (this.f.size() == 0) {
        c();
      }
    }
  }
  
  protected void a(@NonNull View paramView1, @NonNull View paramView2, @Nullable Object paramObject, int paramInt)
  {
    d locald2 = (d)this.f.get(paramView2);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = new d();
      this.f.put(paramView2, locald1);
      this.d += 1L;
    }
    locald1.a = paramInt;
    locald1.b = this.d;
    locald1.c = paramView1;
    locald1.d = paramObject;
    if (this.d % 50L == 0L) {
      a(this.d - 50L);
    }
    if (1 == this.f.size()) {
      d();
    }
  }
  
  protected void a(@NonNull View paramView, @Nullable Object paramObject, int paramInt)
  {
    a(paramView, paramView, paramObject, paramInt);
  }
  
  void a(@Nullable c paramc)
  {
    this.h = paramc;
  }
  
  protected abstract void b();
  
  public void c()
  {
    this.j.removeCallbacksAndMessages(null);
    this.k = false;
    this.e = true;
  }
  
  public void d()
  {
    this.e = false;
    h();
  }
  
  protected void e()
  {
    g();
    this.h = null;
    this.e = true;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  protected void g()
  {
    this.f.clear();
    this.j.removeMessages(0);
    this.k = false;
  }
  
  protected void h()
  {
    if ((this.k) || (this.e)) {
      return;
    }
    this.k = true;
    this.j.postDelayed(this.i, a());
  }
  
  static abstract interface a
  {
    public abstract boolean a(@Nullable View paramView1, @Nullable View paramView2, int paramInt, Object paramObject);
  }
  
  class b
    implements Runnable
  {
    @NonNull
    private final ArrayList<View> b = new ArrayList();
    @NonNull
    private final ArrayList<View> c = new ArrayList();
    
    b() {}
    
    public void run()
    {
      ap.a(ap.this, false);
      Iterator localIterator = ap.a(ap.this).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        View localView1 = (View)((Map.Entry)localObject).getKey();
        int i = ((ap.d)((Map.Entry)localObject).getValue()).a;
        View localView2 = ((ap.d)((Map.Entry)localObject).getValue()).c;
        localObject = ((ap.d)((Map.Entry)localObject).getValue()).d;
        if (ap.b(ap.this).a(localView2, localView1, i, localObject)) {
          this.b.add(localView1);
        } else {
          this.c.add(localView1);
        }
      }
      if (ap.c(ap.this) != null) {
        ap.c(ap.this).a(this.b, this.c);
      }
      this.b.clear();
      this.c.clear();
      ap.this.b();
    }
  }
  
  static abstract interface c
  {
    public abstract void a(List<View> paramList1, List<View> paramList2);
  }
  
  static class d
  {
    int a;
    long b;
    View c;
    Object d;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */