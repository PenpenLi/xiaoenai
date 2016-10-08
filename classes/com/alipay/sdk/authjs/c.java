package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  b a;
  Context b;
  
  public c(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = paramb;
  }
  
  private static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        str1 = ((JSONObject)localObject).getString("clientId");
      }
      catch (Exception paramString)
      {
        Object localObject;
        String str1;
        String str2;
        a locala;
        paramString = null;
        continue;
        paramString = null;
        continue;
      }
      try
      {
        if (TextUtils.isEmpty(str1)) {
          return;
        }
        paramString = ((JSONObject)localObject).getJSONObject("param");
        if (!(paramString instanceof JSONObject)) {
          continue;
        }
        paramString = (JSONObject)paramString;
        str2 = ((JSONObject)localObject).getString("func");
        localObject = ((JSONObject)localObject).getString("bundleName");
        locala = new a("call");
        locala.j = ((String)localObject);
        locala.k = str2;
        locala.m = paramString;
        locala.i = str1;
        a(locala);
        return;
      }
      catch (Exception paramString)
      {
        paramString = str1;
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
      }
    }
    try
    {
      a(paramString, a.a.d);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private a.a b(a parama)
  {
    if ((parama != null) && ("toast".equals(parama.k)))
    {
      JSONObject localJSONObject = parama.m;
      String str = localJSONObject.optString("content");
      int j = localJSONObject.optInt("duration");
      int i = 1;
      if (j < 2500) {
        i = 0;
      }
      Toast.makeText(this.b, str, i).show();
      new Timer().schedule(new e(this, parama), i);
    }
    return a.a.a;
  }
  
  private void c(a parama)
  {
    JSONObject localJSONObject = parama.m;
    String str = localJSONObject.optString("content");
    int j = localJSONObject.optInt("duration");
    int i = 1;
    if (j < 2500) {
      i = 0;
    }
    Toast.makeText(this.b, str, i).show();
    new Timer().schedule(new e(this, parama), i);
  }
  
  public final void a(a parama)
  {
    if (parama == null) {
      return;
    }
    if (TextUtils.isEmpty(parama.k))
    {
      a(parama.i, a.a.c);
      return;
    }
    parama = new d(this, parama);
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(parama);
  }
  
  public final void a(String paramString, a.a parama)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("error", parama.ordinal());
    parama = new a("callback");
    parama.m = localJSONObject;
    parama.i = paramString;
    this.a.a(parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\authjs\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */