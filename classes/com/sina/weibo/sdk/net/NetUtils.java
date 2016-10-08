package com.sina.weibo.sdk.net;

import android.content.Context;

public class NetUtils
{
  public static String internalDownloadFile(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return HttpManager.downloadFile(paramContext, paramString1, paramString2, paramString3);
  }
  
  public static String internalGetRedirectUri(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters)
  {
    return HttpManager.openRedirectUrl4LocationUri(paramContext, paramString1, paramString2, paramWeiboParameters);
  }
  
  public static String internalHttpRequest(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters)
  {
    return HttpManager.openUrl(paramContext, paramString1, paramString2, paramWeiboParameters);
  }
  
  public static void internalHttpRequest(Context paramContext, String paramString1, WeiboParameters paramWeiboParameters, String paramString2, RequestListener paramRequestListener)
  {
    new AsyncWeiboRunner.RequestRunner(paramContext, paramString1, paramWeiboParameters, paramString2, paramRequestListener).execute(new Void[1]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\net\NetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */