package com.alibaba.sdk.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager
{
  public static String API_VERSION;
  public static int APP_KEY_INDEX = 0;
  public static boolean DEBUG = false;
  public static String INIT_SERVER_HOST;
  public static final int ONLINE_INDEX;
  public static String POSTFIX_OF_SECURITY_JPG = "";
  public static String POSTFIX_OF_SECURITY_JPG_USER_SET;
  public static final int PRE_INDEX;
  public static final int SANDBOX_INDEX = Environment.SANDBOX.ordinal();
  public static String SDK_INTERNAL_VERSION;
  private static final ConfigManager SINGLETON_INSTANCE;
  public static final Version TAE_SDK_VERSION;
  public static final int TEST_INDEX;
  public static final Map<String, String> userProperties = new HashMap();
  private Environment env = Environment.ONLINE;
  
  static
  {
    PRE_INDEX = Environment.PRE.ordinal();
    ONLINE_INDEX = Environment.ONLINE.ordinal();
    TEST_INDEX = Environment.TEST.ordinal();
    TAE_SDK_VERSION = new Version(2, 1, 0);
    SDK_INTERNAL_VERSION = TAE_SDK_VERSION.toString();
    SINGLETON_INSTANCE = new ConfigManager();
    INIT_SERVER_HOST = "sdkinit.taobao.com";
  }
  
  public static int getAppKeyIndex()
  {
    return APP_KEY_INDEX;
  }
  
  public static ConfigManager getInstance()
  {
    return SINGLETON_INSTANCE;
  }
  
  public Environment getEnvironment()
  {
    return this.env;
  }
  
  public void init()
  {
    if (this.env == null) {}
    for (int i = Environment.ONLINE.ordinal();; i = this.env.ordinal())
    {
      INIT_SERVER_HOST = new String[] { "10.189.224.121", "sdkinit.taobao.com", "sdkinit.taobao.com", "sdkinit.tbsandbox.com" }[i];
      API_VERSION = new String[] { "1.0.0.daily", "1.0.0", "1.0.0", "1.0.0.daily" }[i];
      if (POSTFIX_OF_SECURITY_JPG_USER_SET != null) {
        break;
      }
      POSTFIX_OF_SECURITY_JPG = new String[] { "test", "", "", "test" }[i];
      return;
    }
    POSTFIX_OF_SECURITY_JPG = POSTFIX_OF_SECURITY_JPG_USER_SET;
  }
  
  public void setEnvironment(Environment paramEnvironment)
  {
    this.env = paramEnvironment;
  }
  
  public void setVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      TAE_SDK_VERSION.setVersion(paramString);
      SDK_INTERNAL_VERSION = "a_" + TAE_SDK_VERSION.toString();
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */