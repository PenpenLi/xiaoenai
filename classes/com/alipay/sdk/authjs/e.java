package com.alipay.sdk.authjs;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

final class e
  extends TimerTask
{
  e(c paramc, a parama) {}
  
  public final void run()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("toastCallBack", "true");
      a locala = new a("callback");
      locala.i = this.a.i;
      locala.m = localJSONObject;
      this.b.a.a(locala);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\authjs\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */