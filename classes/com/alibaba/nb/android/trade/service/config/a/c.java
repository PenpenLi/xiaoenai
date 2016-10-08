package com.alibaba.nb.android.trade.service.config.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alibaba.nb.android.trade.AliTradeContext;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private final String a = c.class.getSimpleName();
  private SharedPreferences b;
  
  public c()
  {
    if (AliTradeContext.context != null) {
      this.b = AliTradeContext.context.getSharedPreferences("aliTradeConfigSP", 0);
    }
  }
  
  public final d a()
  {
    if (this.b == null) {
      return null;
    }
    Object localObject = this.b.getString("aliTradeConfigSP", null);
    com.alibaba.nb.android.trade.utils.d.a.b(this.a, "SP里面的值为:" + (String)localObject);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject);
        localObject = new d();
        com.alibaba.nb.android.trade.utils.d.a.d(this.a, "拼接json出错" + localJSONException1.getMessage());
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          ((d)localObject).a(localJSONObject);
          return (d)localObject;
        }
        catch (JSONException localJSONException2)
        {
          for (;;) {}
        }
        localJSONException1 = localJSONException1;
        localObject = null;
      }
      continue;
      localObject = null;
    }
  }
  
  public final void a(a parama)
  {
    if (this.b == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.b.edit();
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = parama.a().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, new JSONObject((Map)parama.a().get(str)));
      }
      catch (JSONException localJSONException)
      {
        com.alibaba.nb.android.trade.utils.d.a.d(this.a, "拼接json出错" + localJSONException.getMessage());
      }
    }
    localEditor.putString("aliTradeConfigSP", localJSONObject.toString());
    localEditor.commit();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\config\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */