package com.xiaoenai.app.classes.common.c;

import android.os.Bundle;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.al;
import com.xiaoenai.app.utils.f.a;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  implements b
{
  private String a(String paramString)
  {
    String str2 = g.a(paramString);
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.contains("?")) {
        str1 = str2.substring(0, str2.indexOf("?"));
      }
    }
    a.c("============ _tmpModuleId: {}", new Object[] { str1, g.a(paramString) });
    return str1;
  }
  
  private g b(DynamicNotification paramDynamicNotification, String paramString)
  {
    Object localObject2 = paramDynamicNotification.getModule();
    if (ae.a((String)localObject2)) {
      return null;
    }
    String str = a((String)localObject2);
    for (Object localObject1 = new JSONObject();; localObject1 = localObject2)
    {
      for (;;)
      {
        try
        {
          if (!ae.a(paramDynamicNotification.getParams()))
          {
            localObject2 = new JSONObject(paramDynamicNotification.getParams());
            localObject1 = localObject2;
          }
        }
        catch (Exception paramDynamicNotification)
        {
          paramDynamicNotification.printStackTrace();
          continue;
          continue;
        }
        try
        {
          if (!ae.a(paramDynamicNotification.getUrl())) {
            ((JSONObject)localObject1).put("url", paramDynamicNotification.getUrl());
          }
          if (((JSONObject)localObject1).has("url"))
          {
            a.c("======transformerSpecial======== ", new Object[0]);
            a.c("======url undecode======== {}", new Object[] { ((JSONObject)localObject1).optString("url") });
            paramDynamicNotification = ((JSONObject)localObject1).optString("url");
            ((JSONObject)localObject1).put("url", URLDecoder.decode(paramDynamicNotification, "UTF-8"));
            a.c("======url decode======== {}", new Object[] { URLDecoder.decode(paramDynamicNotification, "UTF-8") });
          }
          ((JSONObject)localObject1).put("module_id", str);
          a.c("moduleId: {} param = {}", new Object[] { str, ((JSONObject)localObject1).toString() });
          a.c("from: {}", new Object[] { paramString });
          return new g.a().a(str).c(((JSONObject)localObject1).toString()).b(paramString).a();
        }
        catch (Exception paramDynamicNotification) {}
      }
      if ((localObject2 == null) || (!((String)localObject2).contains("?"))) {
        break label263;
      }
      localObject2 = al.c((String)localObject2);
    }
  }
  
  public g a(HomeDiscoverItem paramHomeDiscoverItem, String paramString)
  {
    g localg = a(paramHomeDiscoverItem.getClickUrl(), paramString);
    Object localObject = localg;
    if (localg != null) {
      localObject = localg;
    }
    try
    {
      if (!ae.a(localg.e()))
      {
        localObject = new JSONObject(localg.e());
        ((JSONObject)localObject).put("module", paramHomeDiscoverItem.getModule());
        a.c("param = {}", new Object[] { ((JSONObject)localObject).toString() });
        a.c("from: {}", new Object[] { paramString });
        localObject = localg.d().c(((JSONObject)localObject).toString()).a();
      }
      return (g)localObject;
    }
    catch (JSONException paramHomeDiscoverItem)
    {
      paramHomeDiscoverItem.printStackTrace();
    }
    return localg;
  }
  
  public g a(DynamicNotification paramDynamicNotification, String paramString)
  {
    return b(paramDynamicNotification, paramString);
  }
  
  public g a(String paramString1, String paramString2)
  {
    if (ae.a(paramString1)) {
      return null;
    }
    Object localObject = new JSONObject();
    String str = a(paramString1);
    try
    {
      if (paramString1.contains("?"))
      {
        localObject = al.b(paramString1);
        if ((localObject == null) || (!((Bundle)localObject).containsKey("params"))) {
          break label101;
        }
      }
      label101:
      for (localObject = new JSONObject(((Bundle)localObject).getString("params"));; localObject = al.c(paramString1))
      {
        ((JSONObject)localObject).put("module_id", str);
        return new g.a().a(str).b(paramString2).c(((JSONObject)localObject).toString()).a();
      }
      return null;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */