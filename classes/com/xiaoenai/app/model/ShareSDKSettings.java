package com.xiaoenai.app.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;
import com.xiaoenai.app.Xiaoenai;

public class ShareSDKSettings
{
  public static final String KEY = "81e1bdefe02";
  public static final String PREFS_PRE = "share_user_";
  public static final String SHARE_SDK_QZONE_STRING = "share_sdk_qzone";
  public static final String SHARE_SDK_SINA_WEIBO_STRING = "share_sdk_sina_weibo";
  private static boolean isInited = false;
  
  public static String getString(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Xiaoenai.j().getSharedPreferences("share_user_" + AppModel.getInstance().getUserId(), 0).getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void initShareSDK(Context paramContext)
  {
    if (!isInited) {
      try
      {
        boolean bool = isInited;
        if (!bool) {}
        try
        {
          ShareSDK.initSDK(paramContext, "81e1bdefe02");
          isInited = true;
          return;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public static void loadShareSDK(Context paramContext)
  {
    try
    {
      Object localObject = ShareSDK.getPlatform(paramContext, SinaWeibo.NAME);
      String str = UserConfig.getString("share_sdk_sina_weibo", "");
      if (!str.equals(""))
      {
        setString("share_sdk_sina_weibo", str);
        UserConfig.remove("share_sdk_sina_weibo");
      }
      str = getString("share_sdk_sina_weibo", "");
      if (!str.equals("")) {
        ((Platform)localObject).getDb().importData(str);
      }
      paramContext = ShareSDK.getPlatform(paramContext, QZone.NAME);
      localObject = UserConfig.getString("share_sdk_qzone", "");
      if (!((String)localObject).equals(""))
      {
        setString("share_sdk_qzone", (String)localObject);
        UserConfig.remove("share_sdk_qzone");
      }
      localObject = getString("share_sdk_qzone", "");
      if (!((String)localObject).equals("")) {
        paramContext.getDb().importData((String)localObject);
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void saveShareSDK(Context paramContext)
  {
    for (;;)
    {
      try
      {
        Platform localPlatform = ShareSDK.getPlatform(paramContext, SinaWeibo.NAME);
        if (localPlatform.getDb().isValid())
        {
          setString("share_sdk_sina_weibo", localPlatform.getDb().exportData());
          localPlatform.removeAccount();
          paramContext = ShareSDK.getPlatform(paramContext, QZone.NAME);
          if (paramContext.getDb().isValid())
          {
            setString("share_sdk_qzone", paramContext.getDb().exportData());
            paramContext.removeAccount();
          }
        }
        else
        {
          setString("share_sdk_sina_weibo", "");
          continue;
        }
        setString("share_sdk_qzone", "");
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
  }
  
  public static void setString(String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = Xiaoenai.j().getSharedPreferences("share_user_" + AppModel.getInstance().getUserId(), 0).edit();
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\model\ShareSDKSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */