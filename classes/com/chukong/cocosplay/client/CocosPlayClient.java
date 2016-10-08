package com.chukong.cocosplay.client;

import android.app.Activity;

public class CocosPlayClient
{
  public static String getGameRoot()
  {
    return "";
  }
  
  public static native String[] getSearchPaths();
  
  public static boolean init(Activity paramActivity, boolean paramBoolean)
  {
    return false;
  }
  
  public static boolean isDemo()
  {
    return false;
  }
  
  public static boolean isEnabled()
  {
    return false;
  }
  
  public static boolean isNotifyFileLoadedEnabled()
  {
    return false;
  }
  
  public static void notifyFileLoaded(String paramString) {}
  
  public static void updateAssets(String paramString) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\chukong\cocosplay\client\CocosPlayClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */