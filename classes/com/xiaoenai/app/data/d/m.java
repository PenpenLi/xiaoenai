package com.xiaoenai.app.data.d;

import android.content.Context;
import android.text.TextUtils;
import com.xiaoenai.app.utils.d.h;
import com.xiaoenai.app.utils.d.o;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;

public class m
  implements com.xiaoenai.app.net.http.base.c
{
  private final a a;
  private final Context b;
  private final com.xiaoenai.app.domain.e.a c;
  private final com.xiaoenai.app.data.e.c d;
  
  @Inject
  public m(Context paramContext, com.xiaoenai.app.domain.e.a parama, com.xiaoenai.app.data.e.c paramc, a parama1)
  {
    this.b = paramContext;
    this.c = parama;
    this.d = paramc;
    this.a = parama1;
  }
  
  public Map<String, String> a(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("lang", this.a.a());
    ((Map)localObject).put("xea_os", this.a.b());
    ((Map)localObject).put("xea_app_ver", this.a.c());
    ((Map)localObject).put("xea_channel", this.a.d());
    ((Map)localObject).put("xea_net", o.f(this.b));
    ((Map)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L + this.d.a("client_server_adjust", Integer.valueOf(0)).intValue()));
    if (!TextUtils.isEmpty(this.c.a().a())) {
      ((Map)localObject).put("access_token", this.c.a().a());
    }
    try
    {
      ((Map)localObject).put("sig", h.a((Map)localObject, this.c.a().b()));
      return (Map<String, String>)localObject;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
    return (Map<String, String>)localObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */