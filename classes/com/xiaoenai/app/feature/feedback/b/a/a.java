package com.xiaoenai.app.feature.feedback.b.a;

import android.text.TextUtils;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import com.xiaoenai.app.feature.feedback.b.c;
import com.xiaoenai.app.feature.feedback.b.d;
import com.xiaoenai.app.feature.feedback.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public final class a
{
  public com.xiaoenai.app.domain.c.b a(c paramc)
  {
    com.xiaoenai.app.domain.c.b localb = new com.xiaoenai.app.domain.c.b();
    if (paramc.b().equals("text")) {
      localb.c(((e)paramc).i());
    }
    for (;;)
    {
      localb.a(paramc.a());
      localb.a(paramc.d());
      localb.a(paramc.f());
      localb.b(paramc.b());
      localb.b(paramc.e());
      localb.a(paramc.g());
      localb.b(paramc.c());
      return localb;
      if (paramc.b().equals("photo")) {
        if (!TextUtils.isEmpty(((d)paramc).j())) {
          localb.c(((d)paramc).j());
        } else {
          localb.c(((d)paramc).i().a());
        }
      }
    }
  }
  
  public com.xiaoenai.app.feature.feedback.b.a a(com.xiaoenai.app.domain.c.a parama)
  {
    if (parama == null) {
      return null;
    }
    com.xiaoenai.app.feature.feedback.b.a locala = new com.xiaoenai.app.feature.feedback.b.a();
    locala.c(parama.d());
    locala.a(parama.a());
    locala.b(parama.c());
    locala.a(parama.b());
    return locala;
  }
  
  public c a(com.xiaoenai.app.domain.c.b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramb != null)
    {
      if (!paramb.c().equals("text")) {
        break label28;
      }
      localObject1 = b(paramb);
    }
    label28:
    do
    {
      return (c)localObject1;
      localObject1 = localObject2;
    } while (!paramb.c().equals("photo"));
    return c(paramb);
  }
  
  public List<c> a(List<com.xiaoenai.app.domain.c.b> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((com.xiaoenai.app.domain.c.b)paramList.next()));
    }
    return localArrayList;
  }
  
  public e b(com.xiaoenai.app.domain.c.b paramb)
  {
    e locale = new e("text");
    locale.c(paramb.h());
    locale.a(paramb.a());
    locale.a(paramb.d());
    locale.b(paramb.b());
    locale.a(paramb.c());
    locale.b(paramb.e());
    locale.a(paramb.g());
    locale.b(paramb.f());
    return locale;
  }
  
  public d c(com.xiaoenai.app.domain.c.b paramb)
  {
    d locald = new d();
    com.xiaoenai.app.feature.feedback.b.b localb = new com.xiaoenai.app.feature.feedback.b.b();
    localb.a(paramb.h());
    locald.a(localb);
    locald.a(paramb.a());
    locald.a(paramb.d());
    locald.b(paramb.b());
    locald.a(paramb.c());
    locald.b(paramb.e());
    locald.a(paramb.g());
    locald.b(paramb.f());
    return locald;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */