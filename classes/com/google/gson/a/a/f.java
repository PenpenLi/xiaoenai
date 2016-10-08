package com.google.gson.a.a;

import com.google.gson.a.c;
import com.google.gson.a.z;
import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.b.a;
import com.google.gson.j;

public final class f
  implements ah
{
  private final c a;
  
  public f(c paramc)
  {
    this.a = paramc;
  }
  
  static af<?> a(c paramc, j paramj, a<?> parama, JsonAdapter paramJsonAdapter)
  {
    paramJsonAdapter = paramJsonAdapter.a();
    if (af.class.isAssignableFrom(paramJsonAdapter)) {
      return (af)paramc.a(a.get(paramJsonAdapter)).a();
    }
    if (ah.class.isAssignableFrom(paramJsonAdapter)) {
      return ((ah)paramc.a(a.get(paramJsonAdapter)).a()).a(paramj, parama);
    }
    throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
  }
  
  public <T> af<T> a(j paramj, a<T> parama)
  {
    JsonAdapter localJsonAdapter = (JsonAdapter)parama.getRawType().getAnnotation(JsonAdapter.class);
    if (localJsonAdapter == null) {
      return null;
    }
    return a(this.a, paramj, parama, localJsonAdapter);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */