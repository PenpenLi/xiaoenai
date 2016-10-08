package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.d.f.c;
import com.bumptech.glide.f.f;
import com.bumptech.glide.manager.h;
import com.bumptech.glide.manager.m;

public class b<ModelType, DataType, ResourceType>
  extends a<ModelType, DataType, ResourceType, ResourceType>
{
  private final l<ModelType, DataType> g;
  private final Class<DataType> h;
  private final Class<ResourceType> i;
  private final f.c j;
  
  b(Context paramContext, Glide paramGlide, Class<ModelType> paramClass, l<ModelType, DataType> paraml, Class<DataType> paramClass1, Class<ResourceType> paramClass2, m paramm, h paramh, f.c paramc)
  {
    super(paramContext, paramClass, a(paramGlide, paraml, paramClass1, paramClass2, com.bumptech.glide.d.d.f.e.b()), paramClass2, paramGlide, paramm, paramh);
    this.g = paraml;
    this.h = paramClass1;
    this.i = paramClass2;
    this.j = paramc;
  }
  
  private static <A, T, Z, R> f<A, T, Z, R> a(Glide paramGlide, l<A, T> paraml, Class<T> paramClass, Class<Z> paramClass1, c<Z, R> paramc)
  {
    return new com.bumptech.glide.f.e(paraml, paramc, paramGlide.buildDataProvider(paramClass, paramClass1));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */