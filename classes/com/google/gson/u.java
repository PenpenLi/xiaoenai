package com.google.gson;

import com.google.gson.a.ab;
import com.google.gson.c.d;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class u
{
  public Number a()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String b()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double c()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public long d()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean f()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean g()
  {
    return this instanceof s;
  }
  
  public boolean h()
  {
    return this instanceof x;
  }
  
  public boolean i()
  {
    return this instanceof z;
  }
  
  public boolean j()
  {
    return this instanceof w;
  }
  
  public x k()
  {
    if (h()) {
      return (x)this;
    }
    throw new IllegalStateException("Not a JSON Object: " + this);
  }
  
  public s l()
  {
    if (g()) {
      return (s)this;
    }
    throw new IllegalStateException("This is not a JSON Array.");
  }
  
  public z m()
  {
    if (i()) {
      return (z)this;
    }
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  Boolean n()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      d locald = new d((Writer)localObject);
      locald.b(true);
      ab.a(this, locald);
      localObject = ((StringWriter)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */