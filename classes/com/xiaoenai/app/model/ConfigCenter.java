package com.xiaoenai.app.model;

import android.content.Context;
import android.text.TextUtils;
import com.xiaoenai.app.net.f;
import com.xiaoenai.app.utils.ai;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigCenter
{
  public static boolean getAdhocSwitch()
  {
    boolean bool = AppSettings.getBoolean("adhoc_switch", Boolean.valueOf(false)).booleanValue();
    com.xiaoenai.app.utils.f.a.c("getAdhocSwitch achoc: {}", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static int getClearTimeTs()
  {
    return AppSettings.getInt("clear_max_continue_startup_ts", Integer.valueOf(0)).intValue();
  }
  
  public static void getConfig(Context paramContext)
  {
    new f(new a(paramContext, paramContext)).b("*");
  }
  
  public static void getConfigChanged(Context paramContext)
  {
    String str = getConfigMd5();
    if (str != null) {
      if (ai.r()) {
        new f(new c(paramContext, paramContext)).c(str);
      }
    }
    while (!ai.q()) {
      return;
    }
    getConfig(paramContext);
  }
  
  public static String getConfigData()
  {
    String str1 = null;
    String str2 = AppSettings.getString("config_changed_data", null);
    if (str2 != null) {
      str1 = com.xiaoenai.app.utils.b.a.c(str2);
    }
    com.xiaoenai.app.utils.f.a.c("data: {}", new Object[] { str1 });
    return str1;
  }
  
  private static String getConfigMd5()
  {
    String str1 = null;
    String str2 = getConfigData();
    if (str2 != null) {}
    try
    {
      str1 = new JSONObject(str2).optString("md5");
      return str1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public static String getFeedbackIconUrl()
  {
    String str2 = AppSettings.getString("feedback_icon", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public static String getHelpPage()
  {
    String str2 = AppSettings.getString("help_page", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public static int getMaxContinueStartupTime()
  {
    return AppSettings.getInt("max_continue_startup_time", Integer.valueOf(0)).intValue();
  }
  
  public static int getMaxStartupInterval()
  {
    return AppSettings.getInt("max_startup_interval", Integer.valueOf(1800)).intValue();
  }
  
  public static String getMeiQiaNoAgentTips()
  {
    String str2 = AppSettings.getString("config_meiqia_no_free_agent_msg", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public static String getMeiqiaFeedbackIconUrl()
  {
    String str2 = AppSettings.getString("meiqia_feedback_icon", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public static int getRegisterStayTime()
  {
    return AppSettings.getInt("config_regist_stay_time", Integer.valueOf(300)).intValue();
  }
  
  public static int getStatTs()
  {
    return AppSettings.getInt("stat_upload_interval", Integer.valueOf(30)).intValue();
  }
  
  public static boolean isShowDiscoverBanner()
  {
    return AppSettings.getBoolean("discover_banner_ads", Boolean.valueOf(false)).booleanValue();
  }
  
  public static boolean isShowHomeBanner()
  {
    boolean bool = AppSettings.getBoolean("home_banner_ads", Boolean.valueOf(false)).booleanValue();
    com.xiaoenai.app.utils.f.a.c("isShowHomeBanner isShowAds: {}", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean isShowLauncher()
  {
    return AppSettings.getBoolean("launcher_ads", Boolean.valueOf(false)).booleanValue();
  }
  
  public static boolean isShowNotificationBanner()
  {
    return AppSettings.getBoolean("notification_banner_ads", Boolean.valueOf(false)).booleanValue();
  }
  
  private static void saveConfigData(JSONObject paramJSONObject)
  {
    AppSettings.setString("config_changed_data", paramJSONObject.toString());
    Object localObject1 = com.xiaoenai.app.utils.b.a.c(paramJSONObject.toString());
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).optString("config");
        if (localObject2 != null)
        {
          localObject2 = new JSONObject((String)localObject2);
          AppSettings.setInt("max_startup_interval", Integer.valueOf(((JSONObject)localObject2).optInt("max_startup_interval", 0)));
          AppSettings.setInt("max_continue_startup_time", Integer.valueOf(((JSONObject)localObject2).optInt("max_continue_startup_time", 0)));
          AppSettings.setInt("clear_max_continue_startup_ts", Integer.valueOf(((JSONObject)localObject2).optInt("clear_max_continue_startup_ts", 0)));
          AppSettings.setInt("stat_upload_interval", Integer.valueOf(((JSONObject)localObject2).optInt("stat_upload_interval", 0)));
          AppSettings.setInt("config_adhoc_gaptime_get", Integer.valueOf(((JSONObject)localObject2).optInt("config_adhoc_gaptime_get", 43200)));
          AppSettings.setInt("config_adhoc_gaptime_send", Integer.valueOf(((JSONObject)localObject2).optInt("config_adhoc_gaptime_send", 60)));
          if (1 != ((JSONObject)localObject2).optInt("adhoc_switch", 0)) {
            continue;
          }
          bool = true;
          AppSettings.setBoolean("adhoc_switch", Boolean.valueOf(bool));
          AppSettings.setBoolean("https_toggle", Boolean.valueOf(((JSONObject)localObject2).optBoolean("https_toggle", false)));
          if (1 != ((JSONObject)localObject2).optInt("launcher_ads", 0)) {
            continue;
          }
          bool = true;
          AppSettings.setBoolean("launcher_ads", Boolean.valueOf(bool));
          if (1 != ((JSONObject)localObject2).optInt("home_banner_ads", 0)) {
            continue;
          }
          bool = true;
          AppSettings.setBoolean("home_banner_ads", Boolean.valueOf(bool));
          if (1 != ((JSONObject)localObject2).optInt("discover_banner_ads", 0)) {
            continue;
          }
          bool = true;
          AppSettings.setBoolean("discover_banner_ads", Boolean.valueOf(bool));
          if (1 != ((JSONObject)localObject2).optInt("notification_banner_ads", 0)) {
            continue;
          }
          bool = true;
          AppSettings.setBoolean("notification_banner_ads", Boolean.valueOf(bool));
          AppSettings.setString("feedback_icon", ((JSONObject)localObject2).optString("feedback_icon", ""));
          AppSettings.setString("meiqia_feedback_icon", ((JSONObject)localObject2).optString("meiqia_feedback_icon", ""));
          AppSettings.setString("help_page", ((JSONObject)localObject2).optString("help_page", ""));
          AppSettings.setInt("config_regist_stay_time", Integer.valueOf(((JSONObject)localObject2).optInt("config_regist_stay_time", 300)));
          AppSettings.setString("config_meiqia_no_free_agent_msg", ((JSONObject)localObject2).optString("config_meiqia_no_free_agent_msg", ""));
          AppSettings.setInt("forum_topic_list_ad_offset_mmu", Integer.valueOf(((JSONObject)localObject2).optInt("forum_topic_list_ad_offset_mmu", 3)));
          AppSettings.setInt("forum_topic_list_ad_space_mmu", Integer.valueOf(((JSONObject)localObject2).optInt("forum_topic_list_ad_space_mmu", 8)));
        }
        com.xiaoenai.app.utils.f.a.c("decrypt data: {}", new Object[] { localObject1 });
      }
      catch (JSONException localJSONException)
      {
        boolean bool;
        localJSONException.printStackTrace();
        continue;
      }
      com.xiaoenai.app.utils.f.a.c("data: {}", new Object[] { paramJSONObject });
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\ConfigCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */