package rx.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import rx.l;

public final class b
  implements l
{
  private Set<l> a;
  private volatile boolean b;
  
  private static void a(Collection<l> paramCollection)
  {
    if (paramCollection == null) {
      return;
    }
    l locall = null;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = locall;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label68;
      }
      locall = (l)localIterator.next();
      try
      {
        locall.c();
      }
      catch (Throwable localThrowable)
      {
        if (paramCollection != null) {
          break label73;
        }
      }
    }
    paramCollection = new ArrayList();
    label68:
    label73:
    for (;;)
    {
      paramCollection.add(localThrowable);
      break;
      rx.a.b.a(paramCollection);
      return;
    }
  }
  
  public void a(l paraml)
  {
    if (paraml.d()) {
      return;
    }
    if (!this.b) {
      try
      {
        if (!this.b)
        {
          if (this.a == null) {
            this.a = new HashSet(4);
          }
          this.a.add(paraml);
          return;
        }
      }
      finally {}
    }
    paraml.c();
  }
  
  public void b(l paraml)
  {
    if (!this.b) {
      try
      {
        if ((this.b) || (this.a == null)) {
          return;
        }
        boolean bool = this.a.remove(paraml);
        if (bool)
        {
          paraml.c();
          return;
        }
      }
      finally {}
    }
  }
  
  public void c()
  {
    if (!this.b) {
      try
      {
        if (this.b) {
          return;
        }
        this.b = true;
        Set localSet = this.a;
        this.a = null;
        a(localSet);
        return;
      }
      finally {}
    }
  }
  
  public boolean d()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */