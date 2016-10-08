package com.alimama.mobile.sdk.config;

import android.location.Location;
import com.alimama.mobile.sdk.lab.AlimmFlowTest;

public class ExchangeConstants
{
  public static boolean ALLOW_SHOW_HANDLERLIST_HEADER = false;
  public static String APPKEY;
  public static boolean BROWSER_GRADUAL_BACK = false;
  public static final String CACHE_PATH = "/download/.alimunion";
  public static String CHANNEL;
  public static boolean CONTAINER_AUTOEXPANDED = false;
  public static int CONTAINER_HEIGHT = 0;
  public static int CONTAINER_LIST_COUNT = 0;
  public static int CustomBrowserLayout = 0;
  public static boolean DEBUG_MODE = false;
  public static String DEFAULT_HANDLE_APP_WALL_TITLE = "精彩推荐";
  public static boolean DETAIL_PAGE = false;
  public static boolean IGNORE_SERVER_INTERVAL = false;
  public static String LOG_TAG;
  public static String MTOP_APPKEY = "";
  public static String MTOP_APP_SECRET = "";
  public static String MTOP_APP_SIGNATURE = "";
  public static boolean ONLY_CHINESE = false;
  public static int PRELOAD_REPEAT_COUNT = 0;
  public static int REFRESH_INTERVAL = 0;
  public static boolean RICH_NOTIFICATION = false;
  public static boolean ROUND_ICON = false;
  public static String SDK_CHANNEL = "None";
  public static String WEB_CACHE_NAME;
  public static boolean WELCOME_COUNTDOWN = false;
  public static AlimmFlowTest alimmFlowTest;
  public static int banner_alpha = 0;
  public static boolean full_screen = false;
  public static boolean handler_auto_expand = false;
  public static boolean handler_left = false;
  private static Location manuallocation;
  public static String no;
  public static String protocol_version;
  public static String sdk_version = "1.1.0.20160831";
  public static boolean show_size = false;
  @Deprecated
  public static String text_color;
  public static final int type_container = 8;
  public static final int type_feed_stream = 12;
  public static final int type_hypertextlink_banner = 13;
  public static final int type_large_image = 43;
  public static final int type_list_curtain = 7;
  public static final int type_standalone_handler = 6;
  public static final int type_suppose = 16;
  public static final int type_welcome_image = 9;
  
  static
  {
    CustomBrowserLayout = 0;
    BROWSER_GRADUAL_BACK = true;
    alimmFlowTest = null;
    protocol_version = "1.1.0.20160831";
    DEBUG_MODE = false;
    PRELOAD_REPEAT_COUNT = 1;
    ALLOW_SHOW_HANDLERLIST_HEADER = true;
    APPKEY = "";
    CHANNEL = null;
    text_color = "#000000";
    banner_alpha = 255;
    CONTAINER_AUTOEXPANDED = true;
    CONTAINER_HEIGHT = 55;
    WELCOME_COUNTDOWN = true;
    CONTAINER_LIST_COUNT = 7;
    DETAIL_PAGE = true;
    full_screen = false;
    handler_auto_expand = true;
    handler_left = true;
    WEB_CACHE_NAME = "/download/.web_cache/";
    LOG_TAG = "com.taobao.munion";
    no = "否";
    ONLY_CHINESE = false;
    ROUND_ICON = true;
    REFRESH_INTERVAL = 30000;
    IGNORE_SERVER_INTERVAL = false;
    RICH_NOTIFICATION = true;
    show_size = false;
  }
  
  public static int definePageLevel(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 8: 
      return 1;
    }
    return 2;
  }
  
  public static Location getManuallocation()
  {
    return manuallocation;
  }
  
  public static void setManuallocation(Location paramLocation)
  {
    if (paramLocation.getTime() <= 0L) {
      paramLocation.setTime(System.currentTimeMillis());
    }
    paramLocation.setProvider("manual");
    manuallocation = paramLocation;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\ExchangeConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */