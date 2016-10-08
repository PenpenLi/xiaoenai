package com.google.gson.a.a;

import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.s;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.z;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class g
  extends a
{
  private static final Reader a = new h();
  private static final Object b = new Object();
  private final List<Object> c;
  
  private void a(c paramc)
  {
    if (f() != paramc) {
      throw new IllegalStateException("Expected " + paramc + " but was " + f());
    }
  }
  
  private Object r()
  {
    return this.c.get(this.c.size() - 1);
  }
  
  private Object s()
  {
    return this.c.remove(this.c.size() - 1);
  }
  
  public void a()
  {
    a(c.a);
    s locals = (s)r();
    this.c.add(locals.iterator());
  }
  
  public void b()
  {
    a(c.b);
    s();
    s();
  }
  
  public void c()
  {
    a(c.c);
    x localx = (x)r();
    this.c.add(localx.o().iterator());
  }
  
  public void close()
  {
    this.c.clear();
    this.c.add(b);
  }
  
  public void d()
  {
    a(c.d);
    s();
    s();
  }
  
  public boolean e()
  {
    c localc = f();
    return (localc != c.d) && (localc != c.b);
  }
  
  public c f()
  {
    if (this.c.isEmpty()) {
      return c.j;
    }
    Object localObject = r();
    if ((localObject instanceof Iterator))
    {
      boolean bool = this.c.get(this.c.size() - 2) instanceof x;
      localObject = (Iterator)localObject;
      if (((Iterator)localObject).hasNext())
      {
        if (bool) {
          return c.e;
        }
        this.c.add(((Iterator)localObject).next());
        return f();
      }
      if (bool) {
        return c.d;
      }
      return c.b;
    }
    if ((localObject instanceof x)) {
      return c.c;
    }
    if ((localObject instanceof s)) {
      return c.a;
    }
    if ((localObject instanceof z))
    {
      localObject = (z)localObject;
      if (((z)localObject).q()) {
        return c.f;
      }
      if (((z)localObject).o()) {
        return c.h;
      }
      if (((z)localObject).p()) {
        return c.g;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof w)) {
      return c.i;
    }
    if (localObject == b) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public String g()
  {
    a(c.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)r()).next();
    this.c.add(localEntry.getValue());
    return (String)localEntry.getKey();
  }
  
  public String h()
  {
    c localc = f();
    if ((localc != c.f) && (localc != c.g)) {
      throw new IllegalStateException("Expected " + c.f + " but was " + localc);
    }
    return ((z)s()).b();
  }
  
  public boolean i()
  {
    a(c.h);
    return ((z)s()).f();
  }
  
  public void j()
  {
    a(c.i);
    s();
  }
  
  public double k()
  {
    c localc = f();
    if ((localc != c.g) && (localc != c.f)) {
      throw new IllegalStateException("Expected " + c.g + " but was " + localc);
    }
    double d = ((z)r()).c();
    if ((!p()) && ((Double.isNaN(d)) || (Double.isInfinite(d)))) {
      throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
    }
    s();
    return d;
  }
  
  public long l()
  {
    c localc = f();
    if ((localc != c.g) && (localc != c.f)) {
      throw new IllegalStateException("Expected " + c.g + " but was " + localc);
    }
    long l = ((z)r()).d();
    s();
    return l;
  }
  
  public int m()
  {
    c localc = f();
    if ((localc != c.g) && (localc != c.f)) {
      throw new IllegalStateException("Expected " + c.g + " but was " + localc);
    }
    int i = ((z)r()).e();
    s();
    return i;
  }
  
  public void n()
  {
    if (f() == c.e)
    {
      g();
      return;
    }
    s();
  }
  
  public void o()
  {
    a(c.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)r()).next();
    this.c.add(localEntry.getValue());
    this.c.add(new z((String)localEntry.getKey()));
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */