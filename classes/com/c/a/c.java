package com.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class c
  extends a
{
  boolean b = false;
  private ArrayList<a> c = new ArrayList();
  private HashMap<a, e> d = new HashMap();
  private ArrayList<e> e = new ArrayList();
  private ArrayList<e> f = new ArrayList();
  private boolean g = true;
  private a h = null;
  private boolean i = false;
  private long j = 0L;
  private ad k = null;
  private long l = -1L;
  
  private void i()
  {
    Object localObject1;
    int n;
    int m;
    Object localObject2;
    int i1;
    int i2;
    if (this.g)
    {
      this.f.clear();
      localObject1 = new ArrayList();
      n = this.e.size();
      m = 0;
      while (m < n)
      {
        localObject2 = (e)this.e.get(m);
        if ((((e)localObject2).b == null) || (((e)localObject2).b.size() == 0)) {
          ((ArrayList)localObject1).add(localObject2);
        }
        m += 1;
      }
      localObject2 = new ArrayList();
      while (((ArrayList)localObject1).size() > 0)
      {
        i1 = ((ArrayList)localObject1).size();
        m = 0;
        while (m < i1)
        {
          e locale1 = (e)((ArrayList)localObject1).get(m);
          this.f.add(locale1);
          if (locale1.e != null)
          {
            i2 = locale1.e.size();
            n = 0;
            while (n < i2)
            {
              e locale2 = (e)locale1.e.get(n);
              locale2.d.remove(locale1);
              if (locale2.d.size() == 0) {
                ((ArrayList)localObject2).add(locale2);
              }
              n += 1;
            }
          }
          m += 1;
        }
        ((ArrayList)localObject1).clear();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        ((ArrayList)localObject2).clear();
      }
      this.g = false;
      if (this.f.size() != this.e.size()) {
        throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
      }
    }
    else
    {
      i1 = this.e.size();
      m = 0;
      while (m < i1)
      {
        localObject1 = (e)this.e.get(m);
        if ((((e)localObject1).b != null) && (((e)localObject1).b.size() > 0))
        {
          i2 = ((e)localObject1).b.size();
          n = 0;
          while (n < i2)
          {
            localObject2 = (c)((e)localObject1).b.get(n);
            if (((e)localObject1).d == null) {
              ((e)localObject1).d = new ArrayList();
            }
            if (!((e)localObject1).d.contains(((c)localObject2).a)) {
              ((e)localObject1).d.add(((c)localObject2).a);
            }
            n += 1;
          }
        }
        ((e)localObject1).f = false;
        m += 1;
      }
    }
  }
  
  public b a(a parama)
  {
    if (parama != null)
    {
      this.g = true;
      return new b(parama);
    }
    return null;
  }
  
  public void a()
  {
    int i1 = 0;
    this.b = false;
    this.i = true;
    i();
    int i2 = this.f.size();
    int m = 0;
    Object localObject2;
    Object localObject3;
    while (m < i2)
    {
      localObject1 = (e)this.f.get(m);
      localObject2 = ((e)localObject1).a.f();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = new ArrayList((Collection)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a.a)((Iterator)localObject2).next();
          if (((localObject3 instanceof d)) || ((localObject3 instanceof a))) {
            ((e)localObject1).a.b((a.a)localObject3);
          }
        }
      }
      m += 1;
    }
    Object localObject1 = new ArrayList();
    m = 0;
    int n;
    if (m < i2)
    {
      localObject2 = (e)this.f.get(m);
      if (this.h == null) {
        this.h = new a(this);
      }
      if ((((e)localObject2).b == null) || (((e)localObject2).b.size() == 0)) {
        ((ArrayList)localObject1).add(localObject2);
      }
      for (;;)
      {
        ((e)localObject2).a.a(this.h);
        m += 1;
        break;
        int i3 = ((e)localObject2).b.size();
        n = 0;
        while (n < i3)
        {
          localObject3 = (c)((e)localObject2).b.get(n);
          ((c)localObject3).a.a.a(new d(this, (e)localObject2, ((c)localObject3).b));
          n += 1;
        }
        ((e)localObject2).c = ((ArrayList)((e)localObject2).b.clone());
      }
    }
    if (this.j <= 0L)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        ((e)localObject2).a.a();
        this.c.add(((e)localObject2).a);
      }
    }
    this.k = ad.b(new float[] { 0.0F, 1.0F });
    this.k.c(this.j);
    this.k.a(new d(this, (ArrayList)localObject1));
    this.k.a();
    if (this.a != null)
    {
      localObject1 = (ArrayList)this.a.clone();
      n = ((ArrayList)localObject1).size();
      m = 0;
      while (m < n)
      {
        ((a.a)((ArrayList)localObject1).get(m)).b(this);
        m += 1;
      }
    }
    if ((this.e.size() == 0) && (this.j == 0L))
    {
      this.i = false;
      if (this.a != null)
      {
        localObject1 = (ArrayList)this.a.clone();
        n = ((ArrayList)localObject1).size();
        m = i1;
        while (m < n)
        {
          ((a.a)((ArrayList)localObject1).get(m)).a(this);
          m += 1;
        }
      }
    }
  }
  
  public void a(a... paramVarArgs)
  {
    int m = 1;
    if (paramVarArgs != null)
    {
      this.g = true;
      b localb = a(paramVarArgs[0]);
      while (m < paramVarArgs.length)
      {
        localb.a(paramVarArgs[m]);
        m += 1;
      }
    }
  }
  
  public c b(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a.a(paramLong);
    }
    this.l = paramLong;
    return this;
  }
  
  public void b()
  {
    this.b = true;
    Object localObject;
    Iterator localIterator;
    if (e())
    {
      if (this.a == null) {
        break label173;
      }
      localObject = (ArrayList)this.a.clone();
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext()) {
        ((a.a)localIterator.next()).c(this);
      }
    }
    for (;;)
    {
      if ((this.k != null) && (this.k.d())) {
        this.k.b();
      }
      while (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.a)((Iterator)localObject).next()).a(this);
        }
        if (this.f.size() > 0)
        {
          localIterator = this.f.iterator();
          while (localIterator.hasNext()) {
            ((e)localIterator.next()).a.b();
          }
        }
      }
      this.i = false;
      return;
      label173:
      localObject = null;
    }
  }
  
  public void c()
  {
    this.b = true;
    if (e())
    {
      Iterator localIterator;
      if (this.f.size() != this.e.size())
      {
        i();
        localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if (this.h == null) {
            this.h = new a(this);
          }
          locale.a.a(this.h);
        }
      }
      if (this.k != null) {
        this.k.b();
      }
      if (this.f.size() > 0)
      {
        localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((e)localIterator.next()).a.c();
        }
      }
      if (this.a != null)
      {
        localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((a.a)localIterator.next()).a(this);
        }
      }
      this.i = false;
    }
  }
  
  public boolean d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).a.d()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public c h()
  {
    c localc = (c)super.g();
    localc.g = true;
    localc.b = false;
    localc.i = false;
    localc.c = new ArrayList();
    localc.d = new HashMap();
    localc.e = new ArrayList();
    localc.f = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject3 = this.e.iterator();
    Object localObject2;
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (e)((Iterator)localObject3).next();
      localObject2 = ((e)localObject1).a();
      localHashMap.put(localObject1, localObject2);
      localc.e.add(localObject2);
      localc.d.put(((e)localObject2).a, localObject2);
      ((e)localObject2).b = null;
      ((e)localObject2).c = null;
      ((e)localObject2).e = null;
      ((e)localObject2).d = null;
      localObject4 = ((e)localObject2).a.f();
      if (localObject4 != null)
      {
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        localObject1 = null;
        while (localIterator.hasNext())
        {
          a.a locala = (a.a)localIterator.next();
          if ((locala instanceof a))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(locala);
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((ArrayList)localObject4).remove((a.a)((Iterator)localObject1).next());
          }
        }
      }
    }
    Object localObject1 = this.e.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (e)((Iterator)localObject1).next();
      localObject2 = (e)localHashMap.get(localObject3);
      if (((e)localObject3).b != null)
      {
        localObject3 = ((e)localObject3).b.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((e)localObject2).a(new c((e)localHashMap.get(((c)localObject4).a), ((c)localObject4).b));
        }
      }
    }
    return localc;
  }
  
  private class a
    implements a.a
  {
    private c b;
    
    a(c paramc)
    {
      this.b = paramc;
    }
    
    public void a(a parama)
    {
      parama.b(this);
      c.a(c.this).remove(parama);
      ((c.e)c.b(this.b).get(parama)).f = true;
      int j;
      if (!c.this.b)
      {
        parama = c.c(this.b);
        j = parama.size();
        i = 0;
        if (i >= j) {
          break label162;
        }
        if (((c.e)parama.get(i)).f) {}
      }
      label162:
      for (int i = 0;; i = 1)
      {
        if (i != 0)
        {
          if (c.this.a != null)
          {
            parama = (ArrayList)c.this.a.clone();
            j = parama.size();
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                ((a.a)parama.get(i)).a(this.b);
                i += 1;
                continue;
                i += 1;
                break;
              }
            }
          }
          c.a(this.b, false);
        }
        return;
      }
    }
    
    public void b(a parama) {}
    
    public void c(a parama)
    {
      if ((!c.this.b) && (c.a(c.this).size() == 0) && (c.this.a != null))
      {
        int j = c.this.a.size();
        int i = 0;
        while (i < j)
        {
          ((a.a)c.this.a.get(i)).c(this.b);
          i += 1;
        }
      }
    }
    
    public void d(a parama) {}
  }
  
  public class b
  {
    private c.e b;
    
    b(a parama)
    {
      this.b = ((c.e)c.b(c.this).get(parama));
      if (this.b == null)
      {
        this.b = new c.e(parama);
        c.b(c.this).put(parama, this.b);
        c.d(c.this).add(this.b);
      }
    }
    
    public b a(a parama)
    {
      c.e locale2 = (c.e)c.b(c.this).get(parama);
      c.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new c.e(parama);
        c.b(c.this).put(parama, locale1);
        c.d(c.this).add(locale1);
      }
      locale1.a(new c.c(this.b, 0));
      return this;
    }
    
    public b b(a parama)
    {
      c.e locale2 = (c.e)c.b(c.this).get(parama);
      c.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new c.e(parama);
        c.b(c.this).put(parama, locale1);
        c.d(c.this).add(locale1);
      }
      parama = new c.c(locale1, 1);
      this.b.a(parama);
      return this;
    }
  }
  
  private static class c
  {
    public c.e a;
    public int b;
    
    public c(c.e parame, int paramInt)
    {
      this.a = parame;
      this.b = paramInt;
    }
  }
  
  private static class d
    implements a.a
  {
    private c a;
    private c.e b;
    private int c;
    
    public d(c paramc, c.e parame, int paramInt)
    {
      this.a = paramc;
      this.b = parame;
      this.c = paramInt;
    }
    
    private void e(a parama)
    {
      if (this.a.b) {
        return;
      }
      int j = this.b.c.size();
      int i = 0;
      label25:
      c.c localc;
      if (i < j)
      {
        localc = (c.c)this.b.c.get(i);
        if ((localc.b == this.c) && (localc.a.a == parama)) {
          parama.b(this);
        }
      }
      for (parama = localc;; parama = null)
      {
        this.b.c.remove(parama);
        if (this.b.c.size() != 0) {
          break;
        }
        this.b.a.a();
        c.a(this.a).add(this.b.a);
        return;
        i += 1;
        break label25;
      }
    }
    
    public void a(a parama)
    {
      if (this.c == 1) {
        e(parama);
      }
    }
    
    public void b(a parama)
    {
      if (this.c == 0) {
        e(parama);
      }
    }
    
    public void c(a parama) {}
    
    public void d(a parama) {}
  }
  
  private static class e
    implements Cloneable
  {
    public a a;
    public ArrayList<c.c> b = null;
    public ArrayList<c.c> c = null;
    public ArrayList<e> d = null;
    public ArrayList<e> e = null;
    public boolean f = false;
    
    public e(a parama)
    {
      this.a = parama;
    }
    
    public e a()
    {
      try
      {
        e locale = (e)super.clone();
        locale.a = this.a.g();
        return locale;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError();
      }
    }
    
    public void a(c.c paramc)
    {
      if (this.b == null)
      {
        this.b = new ArrayList();
        this.d = new ArrayList();
      }
      this.b.add(paramc);
      if (!this.d.contains(paramc.a)) {
        this.d.add(paramc.a);
      }
      paramc = paramc.a;
      if (paramc.e == null) {
        paramc.e = new ArrayList();
      }
      paramc.e.add(this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */