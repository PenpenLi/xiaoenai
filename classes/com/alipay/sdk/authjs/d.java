package com.alipay.sdk.authjs;

import android.widget.Toast;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

final class d
  implements Runnable
{
  d(c paramc, a parama) {}
  
  public final void run()
  {
    Object localObject = this.b;
    a locala = this.a;
    if ((locala != null) && ("toast".equals(locala.k)))
    {
      JSONObject localJSONObject = locala.m;
      String str = localJSONObject.optString("content");
      int j = localJSONObject.optInt("duration");
      int i = 1;
      if (j < 2500) {
        i = 0;
      }
      Toast.makeText(((c)localObject).b, str, i).show();
      new Timer().schedule(new e((c)localObject, locala), i);
    }
    localObject = a.a.a;
    if (localObject != a.a.a) {}
    try
    {
      this.b.a(this.a.i, (a.a)localObject);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\authjs\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */