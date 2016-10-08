package com.alipay.sdk.protocol;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public static g a(c paramc)
  {
    com.alipay.sdk.data.e locale = paramc.a;
    com.alipay.sdk.data.f localf = paramc.b;
    Object localObject2 = paramc.c;
    Object localObject1 = null;
    if (((JSONObject)localObject2).has("form"))
    {
      localObject1 = new g(locale, localf);
      ((g)localObject1).a(paramc.c);
      paramc = (c)localObject1;
    }
    do
    {
      return paramc;
      paramc = (c)localObject1;
    } while (!((JSONObject)localObject2).has("status"));
    paramc = f.a(((JSONObject)localObject2).optString("status"));
    switch (1.a[paramc.ordinal()])
    {
    default: 
      return null;
    case 1: 
    case 2: 
    case 3: 
      paramc = new g(locale, localf);
      paramc.a((JSONObject)localObject2);
      return paramc;
    }
    localObject2 = com.alipay.sdk.sys.b.a().a;
    paramc = com.alipay.sdk.util.b.a((Context)localObject2).a();
    localObject1 = com.alipay.sdk.util.b.a((Context)localObject2).b();
    localObject2 = new com.alipay.sdk.tid.a((Context)localObject2);
    ((com.alipay.sdk.tid.a)localObject2).a(paramc, (String)localObject1);
    ((com.alipay.sdk.tid.a)localObject2).close();
    return null;
  }
  
  private static void b(c paramc)
  {
    com.alipay.sdk.data.f localf = paramc.b;
    JSONObject localJSONObject = paramc.c;
    Object localObject = paramc.a.a;
    com.alipay.sdk.data.a locala = paramc.b.l;
    if (TextUtils.isEmpty(locala.c)) {
      locala.c = ((com.alipay.sdk.data.a)localObject).c;
    }
    if (TextUtils.isEmpty(locala.d)) {
      locala.d = ((com.alipay.sdk.data.a)localObject).d;
    }
    if (TextUtils.isEmpty(locala.b)) {
      locala.b = ((com.alipay.sdk.data.a)localObject).b;
    }
    if (TextUtils.isEmpty(locala.a)) {
      locala.a = ((com.alipay.sdk.data.a)localObject).a;
    }
    localObject = localJSONObject.optJSONObject("reflected_data");
    if (localObject != null)
    {
      new StringBuilder("session = ").append(((JSONObject)localObject).optString("session", "")).toString();
      paramc.b.i = ((JSONObject)localObject);
    }
    for (;;)
    {
      localf.f = localJSONObject.optString("end_code", "0");
      localf.j = localJSONObject.optString("user_id", "");
      paramc = localJSONObject.optString("result");
      try
      {
        localObject = URLDecoder.decode(localJSONObject.optString("result"), "UTF-8");
        paramc = (c)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;) {}
      }
      localf.g = paramc;
      localf.h = localJSONObject.optString("memo", "");
      return;
      if (localJSONObject.has("session"))
      {
        paramc = new JSONObject();
        try
        {
          paramc.put("session", localJSONObject.optString("session"));
          localObject = com.alipay.sdk.tid.b.a().a;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramc.put("tid", localObject);
          }
          localf.i = paramc;
        }
        catch (JSONException paramc) {}
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\protocol\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */