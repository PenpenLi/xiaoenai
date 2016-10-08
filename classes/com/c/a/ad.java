package com.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ad
  extends a
{
  private static ThreadLocal<a> h = new ThreadLocal();
  private static final ThreadLocal<ArrayList<ad>> i = new ae();
  private static final ThreadLocal<ArrayList<ad>> j = new af();
  private static final ThreadLocal<ArrayList<ad>> k = new ag();
  private static final ThreadLocal<ArrayList<ad>> l = new ah();
  private static final ThreadLocal<ArrayList<ad>> m = new ai();
  private static final Interpolator n = new AccelerateDecelerateInterpolator();
  private static final ac o = new h();
  private static final ac p = new f();
  private static long z = 10L;
  private int A = 0;
  private int B = 1;
  private Interpolator C = n;
  private ArrayList<b> D = null;
  long b;
  long c = -1L;
  int d = 0;
  boolean e = false;
  ab[] f;
  HashMap<String, ab> g;
  private boolean q = false;
  private int r = 0;
  private float s = 0.0F;
  private boolean t = false;
  private long u;
  private boolean v = false;
  private boolean w = false;
  private long x = 300L;
  private long y = 0L;
  
  public static ad a(ac paramac, Object... paramVarArgs)
  {
    ad localad = new ad();
    localad.a(paramVarArgs);
    localad.a(paramac);
    return localad;
  }
  
  private void a(boolean paramBoolean)
  {
    if (Looper.myLooper() == null) {
      throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }
    this.q = paramBoolean;
    this.r = 0;
    this.d = 0;
    this.w = true;
    this.t = false;
    ((ArrayList)j.get()).add(this);
    if (this.y == 0L)
    {
      d(k());
      this.d = 0;
      this.v = true;
      if (this.a != null)
      {
        localObject = (ArrayList)this.a.clone();
        int i2 = ((ArrayList)localObject).size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((a.a)((ArrayList)localObject).get(i1)).b(this);
          i1 += 1;
        }
      }
    }
    a locala = (a)h.get();
    Object localObject = locala;
    if (locala == null)
    {
      localObject = new a(null);
      h.set(localObject);
    }
    ((a)localObject).sendEmptyMessage(0);
  }
  
  public static ad b(float... paramVarArgs)
  {
    ad localad = new ad();
    localad.a(paramVarArgs);
    return localad;
  }
  
  public static ad b(int... paramVarArgs)
  {
    ad localad = new ad();
    localad.a(paramVarArgs);
    return localad;
  }
  
  private boolean b(long paramLong)
  {
    if (!this.t)
    {
      this.t = true;
      this.u = paramLong;
    }
    long l1;
    do
    {
      return false;
      l1 = paramLong - this.u;
    } while (l1 <= this.y);
    this.b = (paramLong - (l1 - this.y));
    this.d = 1;
    return true;
  }
  
  private void i()
  {
    ((ArrayList)i.get()).remove(this);
    ((ArrayList)j.get()).remove(this);
    ((ArrayList)k.get()).remove(this);
    this.d = 0;
    if ((this.v) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a.a)localArrayList.get(i1)).a(this);
        i1 += 1;
      }
    }
    this.v = false;
    this.w = false;
  }
  
  public static void n()
  {
    ((ArrayList)i.get()).clear();
    ((ArrayList)j.get()).clear();
    ((ArrayList)k.get()).clear();
  }
  
  private void u()
  {
    h();
    ((ArrayList)i.get()).add(this);
    if ((this.y > 0L) && (this.a != null))
    {
      ArrayList localArrayList = (ArrayList)this.a.clone();
      int i2 = localArrayList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((a.a)localArrayList.get(i1)).b(this);
        i1 += 1;
      }
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  void a(float paramFloat)
  {
    paramFloat = this.C.getInterpolation(paramFloat);
    this.s = paramFloat;
    int i2 = this.f.length;
    int i1 = 0;
    while (i1 < i2)
    {
      this.f[i1].a(paramFloat);
      i1 += 1;
    }
    if (this.D != null)
    {
      i2 = this.D.size();
      i1 = 0;
      while (i1 < i2)
      {
        ((b)this.D.get(i1)).a(this);
        i1 += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void a(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null)
    {
      this.C = paramInterpolator;
      return;
    }
    this.C = new LinearInterpolator();
  }
  
  public void a(ac paramac)
  {
    if ((paramac != null) && (this.f != null) && (this.f.length > 0)) {
      this.f[0].a(paramac);
    }
  }
  
  public void a(b paramb)
  {
    if (this.D == null) {
      this.D = new ArrayList();
    }
    this.D.add(paramb);
  }
  
  public void a(float... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      a(new ab[] { ab.a("", paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].a(paramVarArgs);
    }
  }
  
  public void a(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      a(new ab[] { ab.a("", paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].a(paramVarArgs);
    }
  }
  
  public void a(ab... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    this.f = paramVarArgs;
    this.g = new HashMap(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      ab localab = paramVarArgs[i1];
      this.g.put(localab.c(), localab);
      i1 += 1;
    }
    this.e = false;
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.f == null) || (this.f.length == 0)) {
      a(new ab[] { ab.a("", (ac)null, paramVarArgs) });
    }
    for (;;)
    {
      this.e = false;
      return;
      this.f[0].a(paramVarArgs);
    }
  }
  
  public void b()
  {
    if ((this.d != 0) || (((ArrayList)j.get()).contains(this)) || (((ArrayList)k.get()).contains(this)))
    {
      if ((this.v) && (this.a != null))
      {
        Iterator localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).c(this);
        }
      }
      i();
    }
  }
  
  public ad c(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.x = paramLong;
    return this;
  }
  
  public void c()
  {
    if ((!((ArrayList)i.get()).contains(this)) && (!((ArrayList)j.get()).contains(this)))
    {
      this.t = false;
      u();
      if ((this.A <= 0) || ((this.A & 0x1) != 1)) {
        break label82;
      }
      a(0.0F);
    }
    for (;;)
    {
      i();
      return;
      if (this.e) {
        break;
      }
      h();
      break;
      label82:
      a(1.0F);
    }
  }
  
  public void d(long paramLong)
  {
    h();
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if (this.d != 1)
    {
      this.c = paramLong;
      this.d = 2;
    }
    this.b = (l1 - paramLong);
    f(l1);
  }
  
  public boolean d()
  {
    return (this.d == 1) || (this.v);
  }
  
  public void e(long paramLong)
  {
    this.y = paramLong;
  }
  
  public boolean e()
  {
    return this.w;
  }
  
  boolean f(long paramLong)
  {
    boolean bool2 = false;
    if (this.d == 0)
    {
      this.d = 1;
      if (this.c >= 0L) {
        break label58;
      }
      this.b = paramLong;
    }
    for (;;)
    {
      switch (this.d)
      {
      default: 
        return false;
        label58:
        this.b = (paramLong - this.c);
        this.c = -1L;
      }
    }
    float f1;
    if (this.x > 0L) {
      f1 = (float)(paramLong - this.b) / (float)this.x;
    }
    boolean bool1;
    for (;;)
    {
      if (f1 >= 1.0F) {
        if ((this.r < this.A) || (this.A == -1))
        {
          if (this.a != null)
          {
            int i2 = this.a.size();
            int i1 = 0;
            for (;;)
            {
              if (i1 < i2)
              {
                ((a.a)this.a.get(i1)).d(this);
                i1 += 1;
                continue;
                f1 = 1.0F;
                break;
              }
            }
          }
          if (this.B == 2)
          {
            if (this.q)
            {
              bool1 = false;
              this.q = bool1;
            }
          }
          else
          {
            this.r += (int)f1;
            f1 %= 1.0F;
            this.b += this.x;
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      float f2 = f1;
      if (this.q) {
        f2 = 1.0F - f1;
      }
      a(f2);
      return bool1;
      bool1 = true;
      break;
      f1 = Math.min(f1, 1.0F);
      bool1 = true;
      continue;
      bool1 = bool2;
    }
  }
  
  void h()
  {
    if (!this.e)
    {
      int i2 = this.f.length;
      int i1 = 0;
      while (i1 < i2)
      {
        this.f[i1].b();
        i1 += 1;
      }
      this.e = true;
    }
  }
  
  public ad j()
  {
    int i2 = 0;
    ad localad = (ad)super.g();
    int i3;
    int i1;
    if (this.D != null)
    {
      localObject = this.D;
      localad.D = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localad.D.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localad.c = -1L;
    localad.q = false;
    localad.r = 0;
    localad.e = false;
    localad.d = 0;
    localad.t = false;
    Object localObject = this.f;
    if (localObject != null)
    {
      i3 = localObject.length;
      localad.f = new ab[i3];
      localad.g = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        ab localab = localObject[i1].a();
        localad.f[i1] = localab;
        localad.g.put(localab.c(), localab);
        i1 += 1;
      }
    }
    return localad;
  }
  
  public long k()
  {
    if ((!this.e) || (this.d == 0)) {
      return 0L;
    }
    return AnimationUtils.currentAnimationTimeMillis() - this.b;
  }
  
  public Object l()
  {
    if ((this.f != null) && (this.f.length > 0)) {
      return this.f[0].d();
    }
    return null;
  }
  
  public float m()
  {
    return this.s;
  }
  
  public String toString()
  {
    String str1 = "ValueAnimator@" + Integer.toHexString(hashCode());
    String str2 = str1;
    if (this.f != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= this.f.length) {
          break;
        }
        str1 = str1 + "\n    " + this.f[i1].toString();
        i1 += 1;
      }
    }
    return str2;
  }
  
  private static class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      ArrayList localArrayList1 = (ArrayList)ad.o().get();
      ArrayList localArrayList2 = (ArrayList)ad.p().get();
      int i;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = (ArrayList)ad.q().get();
        if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0)) {
          i = 0;
        }
        break;
      }
      for (;;)
      {
        int k = i;
        Object localObject;
        int j;
        ad localad;
        if (paramMessage.size() > 0)
        {
          localObject = (ArrayList)paramMessage.clone();
          paramMessage.clear();
          k = ((ArrayList)localObject).size();
          j = 0;
          if (j < k)
          {
            localad = (ad)((ArrayList)localObject).get(j);
            if (ad.a(localad) == 0L) {
              ad.b(localad);
            }
            for (;;)
            {
              j += 1;
              break;
              localArrayList2.add(localad);
            }
            k = 1;
          }
        }
        else
        {
          long l = AnimationUtils.currentAnimationTimeMillis();
          localObject = (ArrayList)ad.r().get();
          paramMessage = (ArrayList)ad.s().get();
          j = localArrayList2.size();
          i = 0;
          while (i < j)
          {
            localad = (ad)localArrayList2.get(i);
            if (ad.a(localad, l)) {
              ((ArrayList)localObject).add(localad);
            }
            i += 1;
          }
          j = ((ArrayList)localObject).size();
          if (j > 0)
          {
            i = 0;
            while (i < j)
            {
              localad = (ad)((ArrayList)localObject).get(i);
              ad.b(localad);
              ad.a(localad, true);
              localArrayList2.remove(localad);
              i += 1;
            }
            ((ArrayList)localObject).clear();
          }
          i = localArrayList1.size();
          j = 0;
          if (j < i)
          {
            localObject = (ad)localArrayList1.get(j);
            if (((ad)localObject).f(l)) {
              paramMessage.add(localObject);
            }
            int m;
            if (localArrayList1.size() == i)
            {
              m = j + 1;
              j = i;
              i = m;
            }
            for (;;)
            {
              m = j;
              j = i;
              i = m;
              break;
              paramMessage.remove(localObject);
              m = i - 1;
              i = j;
              j = m;
            }
          }
          if (paramMessage.size() > 0)
          {
            i = 0;
            while (i < paramMessage.size())
            {
              ad.c((ad)paramMessage.get(i));
              i += 1;
            }
            paramMessage.clear();
          }
          if ((k == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))) {
            break;
          }
          sendEmptyMessageDelayed(1, Math.max(0L, ad.t() - (AnimationUtils.currentAnimationTimeMillis() - l)));
          return;
          i = 1;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ad paramad);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\a\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */