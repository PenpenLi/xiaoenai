package com.xiaoenai.app.h.c.b.a;

import com.meiqia.core.c.e;
import com.xiaoenai.app.h.c.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static int a(String paramString)
  {
    int i = 1;
    if (paramString.equals("client")) {
      i = 0;
    }
    return i;
  }
  
  public static com.xiaoenai.app.h.c.b.a a(com.meiqia.core.c.a parama)
  {
    if (parama == null) {
      return null;
    }
    com.xiaoenai.app.h.c.b.a locala = new com.xiaoenai.app.h.c.b.a();
    locala.c(parama.c());
    locala.a(parama.a());
    locala.b(parama.b());
    locala.a(parama.d());
    return locala;
  }
  
  public static b a(e parame)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (parame != null) {
      if (!parame.c().equals("text"))
      {
        localObject1 = localObject2;
        if (!parame.c().equals("photo")) {}
      }
      else
      {
        localObject1 = a(parame, new b());
      }
    }
    return (b)localObject1;
  }
  
  public static b a(e parame, b paramb)
  {
    paramb.c(parame.b());
    paramb.b(parame.c());
    paramb.a(a(parame.g()));
    paramb.b(b(parame.k()));
    paramb.a(parame.h());
    paramb.b(parame.e());
    paramb.a(parame.m());
    paramb.a(parame.n());
    if ("photo".equals(parame.c())) {
      paramb.c(parame.o());
    }
    while (!"audio".equals(parame.c())) {
      return paramb;
    }
    paramb.c(parame.o());
    return paramb;
  }
  
  public static List<b> a(List<e> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        b localb = a((e)paramList.next());
        if (localb != null) {
          localArrayList.add(localb);
        }
      }
    }
    return localArrayList;
  }
  
  private static int b(String paramString)
  {
    if (paramString.equals("arrived")) {}
    do
    {
      return 0;
      if (paramString.equals("sending")) {
        return -1;
      }
    } while (!paramString.equals("failed"));
    return -2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\c\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */