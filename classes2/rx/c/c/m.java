package rx.c.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.a.b;
import rx.l;

public final class m
  implements l
{
  private LinkedList<l> a;
  private volatile boolean b;
  
  public m() {}
  
  public m(l paraml)
  {
    this.a = new LinkedList();
    this.a.add(paraml);
  }
  
  public m(l... paramVarArgs)
  {
    this.a = new LinkedList(Arrays.asList(paramVarArgs));
  }
  
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
      b.a(paramCollection);
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
          LinkedList localLinkedList2 = this.a;
          LinkedList localLinkedList1 = localLinkedList2;
          if (localLinkedList2 == null)
          {
            localLinkedList1 = new LinkedList();
            this.a = localLinkedList1;
          }
          localLinkedList1.add(paraml);
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
        LinkedList localLinkedList = this.a;
        if ((this.b) || (localLinkedList == null)) {
          return;
        }
        boolean bool = localLinkedList.remove(paraml);
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
        LinkedList localLinkedList = this.a;
        this.a = null;
        a(localLinkedList);
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */