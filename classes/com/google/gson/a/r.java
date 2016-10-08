package com.google.gson.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.b;
import com.google.gson.j;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class r
  implements ah, Cloneable
{
  public static final r a = new r();
  private double b = -1.0D;
  private int c = 136;
  private boolean d = true;
  private boolean e;
  private List<com.google.gson.a> f = Collections.emptyList();
  private List<com.google.gson.a> g = Collections.emptyList();
  
  private boolean a(Since paramSince)
  {
    return (paramSince == null) || (paramSince.a() <= this.b);
  }
  
  private boolean a(Since paramSince, Until paramUntil)
  {
    return (a(paramSince)) && (a(paramUntil));
  }
  
  private boolean a(Until paramUntil)
  {
    return (paramUntil == null) || (paramUntil.a() > this.b);
  }
  
  private boolean a(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  private boolean b(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!c(paramClass));
  }
  
  private boolean c(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x8) != 0;
  }
  
  protected r a()
  {
    try
    {
      r localr = (r)super.clone();
      return localr;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public <T> af<T> a(j paramj, com.google.gson.b.a<T> parama)
  {
    Class localClass = parama.getRawType();
    boolean bool1 = a(localClass, true);
    boolean bool2 = a(localClass, false);
    if ((!bool1) && (!bool2)) {
      return null;
    }
    return new s(this, bool2, bool1, paramj, parama);
  }
  
  public boolean a(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.b != -1.0D) && (!a((Since)paramClass.getAnnotation(Since.class), (Until)paramClass.getAnnotation(Until.class)))) {
      return true;
    }
    if ((!this.d) && (b(paramClass))) {
      return true;
    }
    if (a(paramClass)) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.f;; localObject = this.g)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.google.gson.a)((Iterator)localObject).next()).a(paramClass));
      return true;
    }
    return false;
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    if ((this.c & paramField.getModifiers()) != 0) {
      return true;
    }
    if ((this.b != -1.0D) && (!a((Since)paramField.getAnnotation(Since.class), (Until)paramField.getAnnotation(Until.class)))) {
      return true;
    }
    if (paramField.isSynthetic()) {
      return true;
    }
    if (this.e)
    {
      localObject = (Expose)paramField.getAnnotation(Expose.class);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label97;
        }
        if (((Expose)localObject).a()) {
          break label106;
        }
      }
      label97:
      while (!((Expose)localObject).b()) {
        return true;
      }
    }
    label106:
    if ((!this.d) && (b(paramField.getType()))) {
      return true;
    }
    if (a(paramField.getType())) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.f; !((List)localObject).isEmpty(); localObject = this.g)
    {
      paramField = new b(paramField);
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.google.gson.a)((Iterator)localObject).next()).a(paramField));
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */