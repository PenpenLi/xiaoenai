package com.xiaoenai.app.net.e;

import com.google.gson.j;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.c.a.l;
import com.xiaoenai.app.net.m;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
  extends l
{
  public a(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = Xiaoenai.c + paramString;
    }
    return str;
  }
  
  public void a()
  {
    try
    {
      b("v2/red_hints", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("user_noti_id", paramInt2);
      localJSONObject.put("global_noti_id", paramInt1);
      b("v1/notifications", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("success")))
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if ((paramJSONObject != null) && (paramJSONObject.has("notifications")))
      {
        Object localObject = paramJSONObject.getJSONArray("notifications");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          localObject = (List)new j().a(((JSONArray)localObject).toString(), new b(this).getType());
          c.a().a((List)localObject);
        }
        UserConfig.setInt("global_notification_id_max", paramJSONObject.optInt("global_noti_id"));
        UserConfig.setInt("user_notification_id_max", paramJSONObject.optInt("user_noti_id"));
      }
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */