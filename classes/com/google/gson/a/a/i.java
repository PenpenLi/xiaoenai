package com.google.gson.a.a;

import com.google.gson.c.d;
import com.google.gson.s;
import com.google.gson.u;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.z;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends d
{
  private static final Writer a = new j();
  private static final z b = new z("closed");
  private final List<u> c = new ArrayList();
  private String d;
  private u e = w.a;
  
  public i()
  {
    super(a);
  }
  
  private void a(u paramu)
  {
    if (this.d != null)
    {
      if ((!paramu.j()) || (i())) {
        ((x)j()).a(this.d, paramu);
      }
      this.d = null;
      return;
    }
    if (this.c.isEmpty())
    {
      this.e = paramu;
      return;
    }
    u localu = j();
    if ((localu instanceof s))
    {
      ((s)localu).a(paramu);
      return;
    }
    throw new IllegalStateException();
  }
  
  private u j()
  {
    return (u)this.c.get(this.c.size() - 1);
  }
  
  public d a(long paramLong)
  {
    a(new z(Long.valueOf(paramLong)));
    return this;
  }
  
  public d a(Number paramNumber)
  {
    if (paramNumber == null) {
      return f();
    }
    if (!g())
    {
      double d1 = paramNumber.doubleValue();
      if ((Double.isNaN(d1)) || (Double.isInfinite(d1))) {
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + paramNumber);
      }
    }
    a(new z(paramNumber));
    return this;
  }
  
  public d a(String paramString)
  {
    if ((this.c.isEmpty()) || (this.d != null)) {
      throw new IllegalStateException();
    }
    if ((j() instanceof x))
    {
      this.d = paramString;
      return this;
    }
    throw new IllegalStateException();
  }
  
  public d a(boolean paramBoolean)
  {
    a(new z(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  public u a()
  {
    if (!this.c.isEmpty()) {
      throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }
    return this.e;
  }
  
  public d b()
  {
    s locals = new s();
    a(locals);
    this.c.add(locals);
    return this;
  }
  
  public d b(String paramString)
  {
    if (paramString == null) {
      return f();
    }
    a(new z(paramString));
    return this;
  }
  
  public d c()
  {
    if ((this.c.isEmpty()) || (this.d != null)) {
      throw new IllegalStateException();
    }
    if ((j() instanceof s))
    {
      this.c.remove(this.c.size() - 1);
      return this;
    }
    throw new IllegalStateException();
  }
  
  public void close()
  {
    if (!this.c.isEmpty()) {
      throw new IOException("Incomplete document");
    }
    this.c.add(b);
  }
  
  public d d()
  {
    x localx = new x();
    a(localx);
    this.c.add(localx);
    return this;
  }
  
  public d e()
  {
    if ((this.c.isEmpty()) || (this.d != null)) {
      throw new IllegalStateException();
    }
    if ((j() instanceof x))
    {
      this.c.remove(this.c.size() - 1);
      return this;
    }
    throw new IllegalStateException();
  }
  
  public d f()
  {
    a(w.a);
    return this;
  }
  
  public void flush() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */