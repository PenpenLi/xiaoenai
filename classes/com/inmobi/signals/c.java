package com.inmobi.signals;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final String a = c.class.getSimpleName();
  private com.inmobi.commons.core.network.c b;
  private boolean c = true;
  private List<d> d;
  private String e;
  private int f = 0;
  
  public c(com.inmobi.commons.core.network.c paramc)
  {
    this.b = paramc;
    this.d = new ArrayList();
    f();
    if (this.c) {
      a.a().a(new e("signals", "InvalidCarbGetResponse"));
    }
  }
  
  private void f()
  {
    int i = 0;
    if (!this.b.a()) {
      try
      {
        Object localObject1 = new JSONObject(this.b.b());
        if (((JSONObject)localObject1).getBoolean("success"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          this.e = ((JSONObject)localObject1).getString("req_id");
          localObject1 = ((JSONObject)localObject1).getJSONArray("p_apps");
          while (i < ((JSONArray)localObject1).length())
          {
            Object localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            Object localObject2 = ((JSONObject)localObject3).optString("bid", null);
            localObject3 = ((JSONObject)localObject3).optString("inm_id", null);
            if ((localObject2 != null) && (localObject3 != null) && (((String)localObject3).trim().length() > 0))
            {
              localObject2 = new d((String)localObject2, (String)localObject3);
              this.d.add(localObject2);
            }
            this.f = (i + 1);
            i += 1;
          }
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error response for Carb list received. Error code:" + ((JSONObject)localObject1).optInt("errorCode"));
        this.c = false;
        return;
      }
      catch (JSONException localJSONException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Bad response for Carb list received.", localJSONException);
        return;
      }
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error response for Carb list received. Error code:" + this.b.c().a());
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public List<d> b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    return this.f == 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */