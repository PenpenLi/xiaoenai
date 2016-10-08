package a.a.a.d;

import a.a.a.a;
import a.a.a.d;
import a.a.a.g;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class j<T>
{
  private final a<T, ?> a;
  private final List<k> b;
  private final String c;
  
  j(a<T, ?> parama, String paramString)
  {
    this.a = parama;
    this.c = paramString;
    this.b = new ArrayList();
  }
  
  void a(k paramk)
  {
    if ((paramk instanceof k.b)) {
      a(((k.b)paramk).d);
    }
  }
  
  void a(k paramk, k... paramVarArgs)
  {
    a(paramk);
    this.b.add(paramk);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramk = paramVarArgs[i];
      a(paramk);
      this.b.add(paramk);
      i += 1;
    }
  }
  
  void a(g paramg)
  {
    int k = 0;
    if (this.a != null)
    {
      g[] arrayOfg = this.a.getProperties();
      int m = arrayOfg.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          if (paramg == arrayOfg[i]) {
            j = 1;
          }
        }
        else
        {
          if (j != 0) {
            break;
          }
          throw new d("Property '" + paramg.c + "' is not part of " + this.a);
        }
        i += 1;
      }
    }
  }
  
  void a(StringBuilder paramStringBuilder, String paramString, List<Object> paramList)
  {
    ListIterator localListIterator = this.b.listIterator();
    while (localListIterator.hasNext())
    {
      if (localListIterator.hasPrevious()) {
        paramStringBuilder.append(" AND ");
      }
      k localk = (k)localListIterator.next();
      localk.a(paramStringBuilder, paramString);
      localk.a(paramList);
    }
  }
  
  boolean a()
  {
    return this.b.isEmpty();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */