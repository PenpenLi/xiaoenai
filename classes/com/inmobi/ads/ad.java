package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

class ad
{
  private static final String a = ad.class.getSimpleName();
  private static final InMobiStrandAdapter.NativeStrandAdListener u = new ad.1();
  @NonNull
  private final Context b;
  @NonNull
  private final af c;
  @NonNull
  private final Handler d;
  @NonNull
  private final Runnable e;
  @NonNull
  private final HashMap<q, WeakReference<View>> f;
  @NonNull
  private final WeakHashMap<View, q> g;
  @NonNull
  private final InMobiStrandPositioning.InMobiClientPositioning h;
  @NonNull
  private r i;
  private InMobiStrandAdapter.NativeStrandAdListener j;
  private final long k;
  @NonNull
  private ae l;
  @NonNull
  private ae m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private final r.a v = new ad.2(this);
  
  public ad(@NonNull Context paramContext, long paramLong, @NonNull InMobiStrandPositioning.InMobiClientPositioning paramInMobiClientPositioning)
  {
    this.b = paramContext;
    this.k = paramLong;
    this.h = paramInMobiClientPositioning;
    this.j = u;
    this.i = new r(this.b, this.k, this.h, this.v);
    this.c = new u(paramInMobiClientPositioning);
    this.f = new HashMap();
    this.g = new WeakHashMap();
    this.l = ae.c();
    this.m = ae.c();
    this.d = new Handler();
    this.e = new ad.3(this);
    this.o = 0;
    this.p = 0;
  }
  
  private void a(@Nullable View paramView)
  {
    if (paramView == null) {}
    q localq;
    do
    {
      return;
      localq = (q)this.g.get(paramView);
    } while (localq == null);
    localq.a(paramView);
    this.g.remove(paramView);
    this.f.remove(localq);
  }
  
  private void a(InMobiStrandPositioning.InMobiClientPositioning paramInMobiClientPositioning)
  {
    paramInMobiClientPositioning = ae.a(paramInMobiClientPositioning);
    if (this.r) {
      a(paramInMobiClientPositioning);
    }
    for (;;)
    {
      this.s = true;
      return;
      this.m = paramInMobiClientPositioning;
    }
  }
  
  private void a(ae paramae)
  {
    b(0, this.n);
    this.l = paramae;
    g();
    this.q = true;
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    for (;;)
    {
      if ((paramInt1 > paramInt2) || (paramInt1 == -1) || (paramInt1 >= this.n)) {
        return true;
      }
      int i1 = paramInt2;
      if (this.l.b(paramInt1))
      {
        if (!k(paramInt1)) {
          return false;
        }
        i1 = paramInt2 + 1;
      }
      paramInt1 = this.l.c(paramInt1);
      paramInt2 = i1;
    }
  }
  
  private void f()
  {
    if (this.t) {
      return;
    }
    this.t = true;
    this.d.post(this.e);
  }
  
  private void g()
  {
    if (!c(this.o, this.p)) {
      return;
    }
    c(this.p, this.p + 10);
  }
  
  private boolean k(int paramInt)
  {
    q localq = this.i.g();
    if (localq == null) {
      return false;
    }
    this.l.a(localq, paramInt);
    this.n += 1;
    this.j.onAdLoadSucceeded(paramInt);
    return true;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public View a(int paramInt, @Nullable View paramView, @NonNull ViewGroup paramViewGroup)
  {
    q localq = this.l.a(paramInt);
    if (localq == null) {
      return null;
    }
    paramViewGroup = localq.a(paramView, paramViewGroup, this.i.i());
    if (paramViewGroup == null)
    {
      a.a().a("ads", "StrandInflationFailed", new HashMap());
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error inflating view even with a valid data model!");
      return null;
    }
    paramView = (WeakReference)this.f.get(localq);
    if (paramView != null) {}
    for (paramView = (View)paramView.get();; paramView = null)
    {
      if (!paramViewGroup.equals(paramView))
      {
        a(paramView);
        a(paramViewGroup);
        this.f.put(localq, new WeakReference(paramViewGroup));
        this.g.put(paramViewGroup, localq);
      }
      return paramViewGroup;
    }
  }
  
  @Nullable
  public Object a(int paramInt)
  {
    return this.l.a(paramInt);
  }
  
  public void a()
  {
    this.q = false;
    this.s = false;
    this.r = false;
    this.c.a(this.k, new ad.4(this));
    this.i.e();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.o = paramInt1;
    this.p = Math.min(paramInt2, paramInt1 + 100);
    f();
  }
  
  public void a(@Nullable InMobiStrandAdapter.NativeStrandAdListener paramNativeStrandAdListener)
  {
    InMobiStrandAdapter.NativeStrandAdListener localNativeStrandAdListener = paramNativeStrandAdListener;
    if (paramNativeStrandAdListener == null) {
      localNativeStrandAdListener = u;
    }
    this.j = localNativeStrandAdListener;
  }
  
  public void a(String paramString)
  {
    this.i.a(paramString);
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.i.c(paramMap);
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    Object localObject = this.l.b();
    int i1 = this.l.h(paramInt1);
    paramInt2 = this.l.h(paramInt2);
    ArrayList localArrayList = new ArrayList();
    paramInt1 = localObject.length - 1;
    if (paramInt1 >= 0)
    {
      int i2 = localObject[paramInt1];
      if ((i2 < i1) || (i2 >= paramInt2)) {}
      for (;;)
      {
        paramInt1 -= 1;
        break;
        localArrayList.add(Integer.valueOf(i2));
        if (i2 < this.o) {
          this.o -= 1;
        }
        this.n -= 1;
      }
    }
    paramInt1 = this.l.a(i1, paramInt2);
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramInt2 = ((Integer)((Iterator)localObject).next()).intValue();
      this.j.onAdRemoved(paramInt2);
    }
    return paramInt1;
  }
  
  public void b()
  {
    if (this.q)
    {
      f();
      return;
    }
    if (this.s) {
      a(this.m);
    }
    this.r = true;
  }
  
  public boolean b(int paramInt)
  {
    return this.l.d(paramInt);
  }
  
  public int c()
  {
    return 1;
  }
  
  public void c(int paramInt)
  {
    this.n = this.l.j(paramInt);
    if (this.q) {
      f();
    }
  }
  
  public int d(int paramInt)
  {
    if (b(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public void d()
  {
    b(0, this.n);
    Iterator localIterator = this.f.keySet().iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq != null) {
        localq.c();
      }
    }
    this.f.clear();
    this.g.clear();
    this.i.f();
  }
  
  public int e(int paramInt)
  {
    return this.l.g(paramInt);
  }
  
  public void e()
  {
    this.d.removeMessages(0);
    Iterator localIterator = this.f.keySet().iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (localq != null) {
        localq.c();
      }
    }
    this.i.h();
    this.f.clear();
    this.g.clear();
    this.l.a();
  }
  
  public int f(int paramInt)
  {
    return this.l.h(paramInt);
  }
  
  public int g(int paramInt)
  {
    return this.l.i(paramInt);
  }
  
  public int h(int paramInt)
  {
    return this.l.j(paramInt);
  }
  
  public void i(int paramInt)
  {
    this.l.e(paramInt);
  }
  
  public void j(int paramInt)
  {
    this.l.f(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */