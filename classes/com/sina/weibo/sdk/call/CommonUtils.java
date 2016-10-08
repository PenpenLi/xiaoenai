package com.sina.weibo.sdk.call;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class CommonUtils
{
  public static String buildUriQuery(HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramHashMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuilder.toString().replaceFirst("&", "?");
      }
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      if (str2 != null) {
        localStringBuilder.append("&").append(str1).append("=").append(str2);
      }
    }
  }
  
  public static void openWeiboActivity(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction(paramString1);
      localIntent.setData(Uri.parse(paramString2));
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      throw new WeiboNotInstalledException("无法找到微博官方客户端");
    }
  }
  
  public static void openWeiboActivity(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramString3 != null) {}
    try
    {
      localIntent = new Intent();
      localIntent.setAction(paramString1);
      localIntent.setData(Uri.parse(paramString2));
      localIntent.setPackage(paramString3);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Intent localIntent;
      if (paramString3 == null) {
        break label123;
      }
      try
      {
        paramString3 = new Intent();
        paramString3.setAction(paramString1);
        paramString3.setData(Uri.parse(paramString2));
        paramContext.startActivity(paramString3);
        return;
      }
      catch (ActivityNotFoundException paramContext)
      {
        throw new WeiboNotInstalledException("无法找到微博官方客户端");
      }
      throw new WeiboNotInstalledException("无法找到微博官方客户端");
    }
    localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.setData(Uri.parse(paramString2));
    paramContext.startActivity(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\call\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */