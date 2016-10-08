package d.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ck
  implements Serializable
{
  private Map<List<String>, cl> a = new HashMap();
  private long b = 0L;
  
  private void a(cl paramcl1, cl paramcl2)
  {
    paramcl2.c(paramcl2.f() + paramcl1.f());
    paramcl2.b(paramcl2.e() + paramcl1.e());
    paramcl2.a(paramcl2.d() + paramcl1.d());
    int i = 0;
    while (i < paramcl1.c().size())
    {
      paramcl2.a((String)paramcl1.c().get(i));
      i += 1;
    }
  }
  
  private void b(Map<List<String>, cl> paramMap)
  {
    new ArrayList();
    new ArrayList();
    paramMap = this.a.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      List localList = (List)localEntry.getKey();
      Iterator localIterator = this.a.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (List)localEntry.getKey();
        if (!localList.equals(localObject2))
        {
          this.a.put(localObject2, ((Map.Entry)localObject1).getValue());
        }
        else
        {
          localObject2 = (cl)localEntry.getValue();
          localObject1 = (cl)((Map.Entry)localObject1).getValue();
          a((cl)localObject2, (cl)localObject1);
          this.a.remove(localList);
          this.a.put(localList, localObject1);
        }
      }
    }
  }
  
  public Map<List<String>, cl> a()
  {
    return this.a;
  }
  
  public void a(Map<List<String>, cl> paramMap)
  {
    if (this.a.size() <= 0)
    {
      this.a = paramMap;
      return;
    }
    b(paramMap);
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */