package com.xiaoenai.app.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaoenai.app.Xiaoenai;

public class AppSettings
{
  public static final String ABNORMALIY_NEED_TIP = "abnormaliy_need_tip";
  public static final int ABNORMALIY_TIP_FREQUENCY = 3;
  public static final String APP_ID = "app_id";
  public static final String CLEAR_MAX_CONTINUE_STARTUP_TS = "clear_max_continue_startup_ts";
  public static final String CLIENT_SERVER_ADJUST = "client_server_adjust";
  public static final String CONFIG_ADHOC_CLIENT_ID = "adhoc_client_id";
  public static final String CONFIG_ADHOC_GAPTIME_GET = "config_adhoc_gaptime_get";
  public static final String CONFIG_ADHOC_GAPTIME_SEND = "config_adhoc_gaptime_send";
  public static final String CONFIG_ADHOC_HTTPS_TAGGLE = "https_toggle";
  public static final String CONFIG_ADHOC_SWITCH = "adhoc_switch";
  public static final String CONFIG_CHANGED_DATA = "config_changed_data";
  public static final String CONFIG_CHAT_PHONE_TOGGLE = "phone_toggle";
  public static final String CONFIG_CHAT_PHONE_WARNING_TIPS = "phone_warning_tips";
  public static final String CONFIG_DISCOVER_BANNER_ADS = "discover_banner_ads";
  public static final String CONFIG_DISCOVER_FORUM_INTERVAL = "discover_forum_interval";
  public static final String CONFIG_FEEDBACK_ICON = "feedback_icon";
  public static final String CONFIG_FORUM_LIST_AD_OFFSET = "forum_topic_list_ad_offset_mmu";
  public static final String CONFIG_FORUM_LIST_AD_SPACE = "forum_topic_list_ad_space_mmu";
  public static final String CONFIG_HELP_PAGE = "help_page";
  public static final String CONFIG_HOME_BANNER_ADS = "home_banner_ads";
  public static final String CONFIG_LAUNCHER_ADS = "launcher_ads";
  public static final String CONFIG_MEIQIA_FEEDBACK_ICON = "meiqia_feedback_icon";
  public static final String CONFIG_MEIQIA_NO_FREE_AGENT_MSG = "config_meiqia_no_free_agent_msg";
  public static final String CONFIG_NOTIFICATION_BANNER_ADS = "notification_banner_ads";
  public static final String CONFIG_REGIST_STAY_TIME = "config_regist_stay_time";
  public static final String DAEMON_ID = "daemon_id";
  public static final String DEVICE_INFO = "device_info";
  public static final String DISCOVERY_LIST_DATA = "discovery_list_data_v1";
  public static final String DISCOVER_APP_SHOW = "discover_app_show";
  public static final String DISCOVER_GAME_SHOW = "discover_game_show";
  public static final String DISCOVER_LOVERPET_SHOW = "discover_loverpet_show";
  public static final String DISCOVER_STREET_SHOW = "discover_street_show";
  public static final String EXIT_ABNORMALIY_COUNT = "exit_abnormaliy_count";
  public static final String IMG_TOKEN_STRING = "image_token";
  public static final String IS_LOGINED_BOOL = "is_logined";
  public static final String LAST_ADJUST_TIME = "last_adjust_time";
  public static final String LAST_CANCEL_UPDATE = "last_cancel_update";
  public static final String LAST_CHECK_UPDATE = "last_check_update";
  public static final String LAST_LOGIN_ACCOUNT_STRING = "Last_login_account";
  public static final String LAST_STARTUP_TS = "last_startup_ts";
  public static final String MAX_CONTINUE_STARTUP_TIME = "max_continue_startup_time";
  public static final String MAX_CONTINUE_STARTUP_TIMES = "max_continue_startup_times";
  public static final String MAX_STARTUP_INTERVAL = "max_startup_interval";
  public static final String MIGRATE_FAIL_TIME = "migrate_fail_time";
  private static final String PREFS_NAME = "xiaoenai";
  public static final String REGISTER_IS_REMIND = "register_is_remind";
  public static final String SETTING_ENVIRONMENT = "setting_environment";
  public static final String STAT_UPLOAD_TS = "stat_upload_interval";
  public static final String TOKEN_STRING = "token";
  public static final String USER_ID_INT = "user_id";
  public static final String WEIBO_APPKEY = "1683793224";
  
  public static Boolean getBoolean(String paramString, Boolean paramBoolean)
  {
    try
    {
      boolean bool = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).getBoolean(paramString, paramBoolean.booleanValue());
      return Boolean.valueOf(bool);
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Integer getInt(String paramString, Integer paramInteger)
  {
    try
    {
      int i = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).getInt(paramString, paramInteger.intValue());
      return Integer.valueOf(i);
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    try
    {
      paramLong = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).getLong(paramString, paramLong);
      return paramLong;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void remove(String paramString)
  {
    SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  public static void removeOldSettings()
  {
    remove("is_logined");
    remove("token");
    remove("Last_login_account");
    remove("user_id");
    remove("image_token");
    remove("discover_game_show");
    remove("discover_app_show");
    remove("discover_street_show");
    remove("discover_loverpet_show");
    remove("phone_toggle");
    remove("phone_warning_tips");
  }
  
  public static void setBoolean(String paramString, Boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).edit();
      localEditor.putBoolean(paramString, paramBoolean.booleanValue());
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setInt(String paramString, Integer paramInteger)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).edit();
      localEditor.putInt(paramString, paramInteger.intValue());
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setLong(String paramString, long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).edit();
      localEditor.putLong(paramString, paramLong);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setString(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("xiaoenai", 0).edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\AppSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */