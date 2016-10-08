package com.bumptech.glide.d;

import com.bumptech.glide.d.b.k;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class d<T>
  implements g<T>
{
  private final Collection<? extends g<T>> a;
  private String b;
  
  @SafeVarargs
  public d(g<T>... paramVarArgs)
  {
    if (paramVarArgs.length < 1) {
      throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
    this.a = Arrays.asList(paramVarArgs);
  }
  
  public k<T> a(k<T> paramk, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    k localk;
    for (Object localObject = paramk; localIterator.hasNext(); localObject = localk)
    {
      localk = ((g)localIterator.next()).a((k)localObject, paramInt1, paramInt2);
      if ((localObject != null) && (!localObject.equals(paramk)) && (!localObject.equals(localk))) {
        ((k)localObject).d();
      }
    }
    return (k<T>)localObject;
  }
  
  public String a()
  {
    if (this.b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((g)localIterator.next()).a());
      }
      this.b = localStringBuilder.toString();
    }
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */