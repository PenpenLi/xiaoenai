package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.alipay.sdk.data.f;
import com.alipay.sdk.tid.b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static c a(c paramc)
  {
    new e();
    Object localObject1 = e.a(paramc);
    if (localObject1 == null) {}
    for (;;)
    {
      f localf = paramc.b;
      JSONObject localJSONObject = paramc.c;
      localObject1 = paramc.a.a;
      Object localObject2 = paramc.b.l;
      if (TextUtils.isEmpty(((a)localObject2).c)) {
        ((a)localObject2).c = ((a)localObject1).c;
      }
      if (TextUtils.isEmpty(((a)localObject2).d)) {
        ((a)localObject2).d = ((a)localObject1).d;
      }
      if (TextUtils.isEmpty(((a)localObject2).b)) {
        ((a)localObject2).b = ((a)localObject1).b;
      }
      if (TextUtils.isEmpty(((a)localObject2).a)) {
        ((a)localObject2).a = ((a)localObject1).a;
      }
      localObject1 = localJSONObject.optJSONObject("reflected_data");
      if (localObject1 != null)
      {
        new StringBuilder("session = ").append(((JSONObject)localObject1).optString("session", "")).toString();
        paramc.b.i = ((JSONObject)localObject1);
      }
      for (;;)
      {
        localf.f = localJSONObject.optString("end_code", "0");
        localf.j = localJSONObject.optString("user_id", "");
        localObject1 = localJSONObject.optString("result");
        try
        {
          localObject2 = URLDecoder.decode(localJSONObject.optString("result"), "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;) {}
        }
        localf.g = ((String)localObject1);
        localf.h = localJSONObject.optString("memo", "");
        return paramc;
        if (localJSONObject.has("session"))
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("session", localJSONObject.optString("session"));
            localObject2 = b.a().a;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((JSONObject)localObject1).put("tid", localObject2);
            }
            localf.i = ((JSONObject)localObject1);
          }
          catch (JSONException localJSONException) {}
        }
      }
      paramc = localJSONException;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\protocol\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */