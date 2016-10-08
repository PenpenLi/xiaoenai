package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import android.os.Handler;
import com.google.gson.j;
import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class s
  extends m
{
  s(o paramo, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    o.d(this.a).post(new t(this));
  }
  
  public void a(int paramInt)
  {
    o.h(this.a);
    o.a(this.a, o.f(this.a).size());
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("success")))
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.getJSONArray("notifications");
        int i = 0;
        if (i < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.optJSONObject(i);
          localObject = (DynamicNotification)new j().a(((JSONObject)localObject).toString(), DynamicNotification.class);
          if (o.e(this.a).containsKey(((DynamicNotification)localObject).getGroup())) {
            o.a(this.a, (DynamicNotification)localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            o.f(this.a).add(localObject);
            o.e(this.a).put(((DynamicNotification)localObject).getGroup(), localObject);
          }
        }
        o.g(this.a);
        o.h(this.a);
        if (o.i(this.a) != null) {
          o.i(this.a).a();
        }
        o.a(this.a, o.f(this.a).size());
        UserConfig.setLong("key_notify_last_get_time", ak.a());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */