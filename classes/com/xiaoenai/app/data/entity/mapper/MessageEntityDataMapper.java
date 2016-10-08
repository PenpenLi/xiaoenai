package com.xiaoenai.app.data.entity.mapper;

import com.xiaoenai.app.domain.internal.di.PerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class MessageEntityDataMapper
{
  public com.xiaoenai.app.h.c.b.b messageTransformMessageEntity(com.xiaoenai.app.domain.c.b paramb)
  {
    com.xiaoenai.app.h.c.b.b localb = new com.xiaoenai.app.h.c.b.b();
    localb.a(paramb.a());
    localb.a(paramb.b());
    localb.b(paramb.c());
    localb.c(paramb.h());
    localb.a(paramb.d());
    localb.b(paramb.e());
    localb.a(paramb.g());
    localb.b(paramb.f());
    return localb;
  }
  
  public com.xiaoenai.app.domain.c.b transform(com.xiaoenai.app.h.c.b.b paramb)
  {
    com.xiaoenai.app.domain.c.b localb = new com.xiaoenai.app.domain.c.b();
    localb.a(paramb.a());
    localb.a(paramb.b());
    localb.b(paramb.c());
    localb.c(paramb.h());
    localb.a(paramb.d());
    localb.b(paramb.e());
    localb.a(paramb.g());
    localb.b(paramb.f());
    return localb;
  }
  
  public com.xiaoenai.app.domain.c.a transformAgent(com.xiaoenai.app.h.c.b.a parama)
  {
    if (parama == null) {
      return null;
    }
    com.xiaoenai.app.domain.c.a locala = new com.xiaoenai.app.domain.c.a();
    locala.c(parama.d());
    locala.a(parama.a());
    locala.b(parama.c());
    locala.a(parama.b());
    return locala;
  }
  
  public List<com.xiaoenai.app.domain.c.b> transformList(List<com.xiaoenai.app.h.c.b.b> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(transform((com.xiaoenai.app.h.c.b.b)paramList.next()));
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\MessageEntityDataMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */