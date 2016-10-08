package com.xiaoenai.app.utils;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.UserConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class ai
{
  private static boolean a = false;
  
  public static int a()
  {
    int i = 2;
    Object localObject = ConfigCenter.getConfigData();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).optString("config");
        if (localObject != null)
        {
          localObject = new JSONObject((String)localObject);
          if (localObject != null)
          {
            i = ((JSONObject)localObject).optInt("config_non_wifi_rate");
            if (i > 0) {
              return i;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return 2;
      }
      i = 2;
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    Object localObject = ConfigCenter.getConfigData();
    int i = paramInt;
    if (localObject != null) {}
    try
    {
      localObject = new JSONObject((String)localObject).optString("config");
      i = paramInt;
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        i = paramInt;
        if (localObject != null)
        {
          int j = ((JSONObject)localObject).optInt(paramString);
          i = paramInt;
          if (j > 0) {
            i = j * 1000;
          }
        }
      }
      return i;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    Xiaoenai.j().a(new aj(paramBoolean));
  }
  
  public static boolean a(long paramLong, int paramInt)
  {
    return a(ak.a(), paramLong, paramInt);
  }
  
  public static boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    return paramLong1 - paramLong2 > paramInt;
  }
  
  public static int b()
  {
    return b("noti_redhint_interval", 120000);
  }
  
  private static int b(String paramString, int paramInt)
  {
    paramInt = a(paramString, paramInt);
    int i = a();
    if (a) {
      return paramInt;
    }
    return paramInt * i;
  }
  
  public static int c()
  {
    return b("noti_interval", 60000);
  }
  
  public static int d()
  {
    return b("discover_list_interval", 2400000);
  }
  
  public static int e()
  {
    return b("discover_forum_interval", 0);
  }
  
  public static int f()
  {
    return b("ads_interval", 900000);
  }
  
  public static int g()
  {
    return b("info_verify_interval", 300000);
  }
  
  public static int h()
  {
    return b("config_change_interval", 480000);
  }
  
  public static boolean i()
  {
    return a(UserConfig.getLong("key_red_hints_last_get_time", 0L), b());
  }
  
  public static boolean j()
  {
    return a(UserConfig.getLong("key_discover_forum_last_update_time", 0L) * 1000L, e());
  }
  
  public static boolean k()
  {
    return a(AppSettings.getLong("key_last_discover_update_time", 0L), d());
  }
  
  public static boolean l()
  {
    return a(UserConfig.getLong("key_discover_ads_last_req_time", 0L), f());
  }
  
  public static boolean m()
  {
    return a(UserConfig.getLong("key_notify_last_get_time", 0L), c());
  }
  
  public static boolean n()
  {
    return a(UserConfig.getLong("key_notification_ads_last_req_time", 0L), f());
  }
  
  public static boolean o()
  {
    return a(UserConfig.getLong("key_home_ads_last_req_time", 0L), f());
  }
  
  public static boolean p()
  {
    return a(UserConfig.getLong("key_setting_update_user_info", 0L), g());
  }
  
  public static boolean q()
  {
    return a(UserConfig.getLong("key_config_last_req_time", 0L), h());
  }
  
  public static boolean r()
  {
    return a(UserConfig.getLong("key_config_changed_last_req_time", 0L), h());
  }
  
  public static void s()
  {
    UserConfig.remove("key_red_hints_last_get_time");
    UserConfig.remove("key_notify_last_get_time");
    AppSettings.remove("key_last_discover_update_time");
    UserConfig.remove("key_street_event_last_get_time");
    UserConfig.remove("key_space_last_get_time");
    UserConfig.remove("key_discover_ads_last_req_time");
    UserConfig.remove("key_setting_update_user_info");
    UserConfig.remove("key_notification_ads_last_req_time");
    UserConfig.remove("key_home_ads_last_req_time");
    UserConfig.remove("key_config_last_req_time");
    UserConfig.remove("key_config_changed_last_req_time");
    UserConfig.remove("key_discover_forum_last_update_time");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */