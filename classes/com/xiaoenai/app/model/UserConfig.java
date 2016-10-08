package com.xiaoenai.app.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.d.h;

public class UserConfig
{
  public static final String ADS_DISCOVER_URL = "ads_discover";
  public static final String ADS_INDEX_URL = "ads_index";
  public static final String ADS_NOTI_URL = "ads_noti";
  public static final String ADS_REQ_INTERVAL = "ads_req_interval";
  public static final String AUDIO_MODE = "Audio_mode";
  public static final String BIND_INFO = "bind_info" + User.getInstance().getUserId();
  public static final String CHAT_EDITTEXT_TMPMSG = "chat_edittext_tmpmsg";
  public static final String CHAT_TITLE_COLOR = "chat_title_color";
  public static final String CHAT_TITLE_COLOR_INDEX = "chat_title_color_index";
  public static final int CHAT_TITLE_DEFAULT = -1864528;
  public static final String CLOCK_ALARM_DEFAULT = "alarm_default";
  public static final String CLOCK_ALARM_PATH = "clock_alarm_path";
  public static final String CONFIG_STREET_TOPIC_PAGE_TITLE = "street_topic_page_title";
  public static final String CUR_VERSION = "cur_version";
  public static final String CUR_VERSION_CODE = "cur_version_code";
  public static final String DEV_ENV_IP = "dev_env_ip";
  public static final String EXTENTION_ANNIVERSARY_STRING = "extention_anniversary";
  public static final String EXTENTION_TODO_STRING = "extention_todo";
  public static final String FIRST_BIND_WECHAT = "v_wechat_binded";
  public static final String FIRST_ENTER_APP = "v_wechat_entered_app";
  public static final String FIRST_ENTER_PERSONAL = "v_wechat_entered_personal";
  public static final String FIRST_IN_HOME_CONNECTED = "first_in_home_connect";
  public static final String FIRST_IN_HOME_SINGLE = "first_in_home_single";
  public static final String FIRST_TIME_IN_TODO = "first_time_in_todo";
  public static final String FORUM_CURRENT_MOMENT_END_TIME = "forum_current_moment_end_time";
  public static final String FORUM_CURRENT_MOMENT_ID = "forum_current_moment_id";
  public static final String FORUM_FIRST_CLICK_WIFI_LOADED_FLAG = "forum_first_click_wifi_loaded_flag";
  public static final String FORUM_HAS_MOMENT = "forum_has_moment";
  public static final String FORUM_MOMENT_END_TIME = "forum_moment_end_time";
  public static final String FORUM_MOMENT_ID = "forum_moment_id";
  public static final String FORUM_NIGHT_THEME = "forum_night_theme";
  public static final String FORUM_PUBLISH_LIMIT = "forum_publish_limit";
  public static final String FORUM_REPLY_LIMIT = "forum_reply_limit";
  public static final String FORUM_WIFI_LOADED_FLAG = "forum_wifi_loaded_flag";
  public static final String GAME_LOVEPET_STRING = "game_lovepet";
  public static final String GAME_WISHTREE_STRING = "game_wishtree";
  public static final String HAS_NEWS_BOOL = "has_news";
  public static final String HIS_RECOVERY_END_TS = "his_recovery_end_ts";
  public static final String HIS_RECOVERY_START_TS = "his_recovery_start_ts";
  public static final String HOME_HAS_INVITE = "home_has_invite";
  public static final String HOME_INVITER = "home_inviter";
  public static final String HOME_SEARCH_LOVER_AVATAR = "home_search_lover_avatar";
  public static final String HOME_SEARCH_LOVER_EMAIL = "home_search_lover_email";
  public static final String IS_GETTING_INVITE = "is_getting_invite";
  public static final String KEY = "im_history_ts";
  public static final String LAST_SEND_ALARM_TIME = "last_send_alarm_time";
  public static final String LAST_UPLOAD_STAT_TIME = "last_upload_stat_time";
  public static final String LAST_VERIFY_EMAIL_TIME = "last_verify_email_time";
  public static final String LAUNCHER_ADS_DISPLAY_COUNT = "launcher_ads_display_count";
  public static final String LAUNCHER_ADS_DISPLAY_KEY = "launcher_ads_display_key";
  public static final String LOCK_PASSWORD_STRING_V2 = "lock_password_v2";
  public static final String LOCK_SHOW_LOCK = "lock_show_lock";
  public static final String LOVER_BLUR_AVATAR_PATH = "lover_blur_avatar_path";
  public static final String LSTTIMESTAMP = "lstTimestamp";
  public static final String MENSES_DURATION = "menses_duration";
  public static final String MENSES_HELP = "mens_help";
  public static final String MENSES_INTERVAL = "menses_interval";
  public static final String MENSES_ISSTOP = "menses_is_stop";
  public static final String MENSES_LAST_TIME = "menses_last_time";
  public static final String MENSES_LEAVE_TS = "leave_ts";
  public static final String MENSES_LOCALNOTI_TS = "mens_localnoti_ts";
  public static final String MENSES_NOTI_TS = "noti_ts";
  public static final String MENSES_RECENT = "menses_recent";
  public static final String MENSES_SEX = "mens_sex";
  public static final String NEW_FEEDBACK_REPLY_BOOL = "new_feedback_reply";
  public static final String PHONE_CODE_NUM = "phone_code_num";
  public static final String PHONE_CONNECTED_TIME = "phone_connected_time";
  public static final String PHOTOALBUM_CUR_INT = "photoalbum_cur";
  public static final String PHOTOALBUM_TOTAL_INT = "photoalbum_total";
  public static final String PREFS_PRE = "user_";
  public static final String RECEIVE_NEW_MSG_COUNT = "receive_new_msg_count";
  public static final String REDHINTS_DATA = "redhints_data";
  public static final String SETTING_SOUND_BOOL = "setting_sound";
  public static final String SETTING_VIBRATE_BOOL = "setting_vibrate";
  public static final String STREET_CART_COUNT = "street_cart_count";
  public static final String THIRD_PARTY_CLAIM_HEADER = "THIRD_PARTY_CLAIM_";
  public static final String TODO_EDITTEXT_TMPTEXT_CONTEXT = "todo_edittext_tmpmsg";
  public static final String TODO_EDITTEXT_TMPTEXT_INDEX = "todo_edittext_tmpindex";
  public static final String V5_0 = "v5.6.0";
  public static final String VIDEO_CONNECTED_TIME = "video_connected_time";
  public static final String WEIBO_ACCESS_TOKEN = "weibo_access_token";
  public static final String WEIBO_EXPIRES_IN = "weibo_expires_in";
  public static final String WEIBO_KEY_UID = "weibo_key_uid";
  
  public static Boolean getBoolean(String paramString, Boolean paramBoolean)
  {
    try
    {
      boolean bool = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).getBoolean(paramString, paramBoolean.booleanValue());
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
      int i = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).getInt(paramString, paramInteger.intValue());
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
      paramLong = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).getLong(paramString, paramLong);
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
      paramString1 = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static String getStringWithDecypt(String paramString)
  {
    try
    {
      paramString = h.b(getString(paramString, null));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String getUserBindedInfo()
  {
    return BIND_INFO + User.getInstance().getUserId();
  }
  
  public static void remove(String paramString)
  {
    SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).edit();
    localEditor.remove(paramString);
    localEditor.apply();
  }
  
  public static void setBoolean(String paramString, Boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).edit();
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
  
  public static void setInt(String paramString, int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).edit();
      localEditor.putInt(paramString, paramInt);
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
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).edit();
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
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("user_" + AppModel.getInstance().getUserId(), 0).edit();
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
  
  public static void setStringWithEncypt(String paramString1, String paramString2)
  {
    try
    {
      setString(paramString1, h.a(paramString2));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\UserConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */