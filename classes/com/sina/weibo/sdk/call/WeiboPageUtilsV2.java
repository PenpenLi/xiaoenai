package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public final class WeiboPageUtilsV2
{
  public static void displayInWeiboMap(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    String str1 = "";
    String str3;
    String str2;
    if (paramHashMap != null)
    {
      str3 = (String)paramHashMap.get("longitude");
      str2 = (String)paramHashMap.get("latitude");
      str1 = (String)paramHashMap.get("offset");
    }
    for (;;)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramHashMap != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))) {
          localObject1 = (String)paramHashMap.get("packagename");
        }
      }
      if (paramHashMap != null) {
        openInWeiboBrowser(paramContext, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", new Object[] { str3, str2, str1 }), "default", (String)paramHashMap.get("extparam"), (String)localObject1);
      }
      return;
      str2 = "";
      str3 = "";
    }
  }
  
  public static void openInWeiboBrowser(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("url不能为空");
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!"topnav".equals(paramString2)) && (!"default".equals(paramString2)) && (!"fullscreen".equals(paramString2))) {
      throw new WeiboIllegalParameterException("sinainternalbrowser不合法");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://browser");
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString1);
    localHashMap.put("sinainternalbrowser", paramString2);
    localHashMap.put("extparam", paramString3);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString1 = new StringBuilder("sinaweibo://browser");
      if (localHashMap != null) {
        paramString1.append(CommonUtils.buildUriQuery(localHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString(), paramString4);
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString(), null);
  }
  
  public static void openQrcodeScanner(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://qrcode");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://qrcode");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void postNewWeibo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://sendweibo");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://sendweibo");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void viewNearbyPeople(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://nearbypeople");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://nearbypeople");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void viewNearbyWeibo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://nearbyweibo");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://nearbyweibo");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void viewPageDetailInfo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (paramHashMap == null) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("pageid"))) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("cardid"))) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://pagedetailinfo");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://pagedetailinfo");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void viewPageInfo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if ((paramHashMap == null) || (TextUtils.isEmpty((CharSequence)paramHashMap.get("pageid")))) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://pageinfo");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://pageinfo");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void viewPagePhotoList(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (paramHashMap == null) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("pageid"))) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("cardid"))) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    try
    {
      i = Integer.parseInt((String)paramHashMap.get("count"));
      if (i < 0) {
        throw new WeiboIllegalParameterException("count不能为负数");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = -1;
      }
      StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://pagephotolist");
      if (paramHashMap != null) {
        localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
      {
        StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://pagephotolist");
        if (paramHashMap != null) {
          localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
        }
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
        return;
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
    }
  }
  
  public static void viewPageProductList(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (paramHashMap == null) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("pageid"))) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("cardid"))) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    try
    {
      i = Integer.parseInt((String)paramHashMap.get("count"));
      if (i < 0) {
        throw new WeiboIllegalParameterException("count不能为负数");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = -1;
      }
      StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://pageproductlist");
      if (paramHashMap != null) {
        localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
      {
        StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://pageproductlist");
        if (paramHashMap != null) {
          localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
        }
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
        return;
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
    }
  }
  
  public static void viewPageUserList(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (paramHashMap == null) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("pageid"))) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("cardid"))) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    try
    {
      i = Integer.parseInt((String)paramHashMap.get("count"));
      if (i < 0) {
        throw new WeiboIllegalParameterException("count不能为负数");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = -1;
      }
      StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://pageuserlist");
      if (paramHashMap != null) {
        localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
      {
        StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://pageuserlist");
        if (paramHashMap != null) {
          localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
        }
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
        return;
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
    }
  }
  
  public static void viewPageWeiboList(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (paramHashMap == null) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("pageid"))) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("cardid"))) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    try
    {
      i = Integer.parseInt((String)paramHashMap.get("count"));
      if (i < 0) {
        throw new WeiboIllegalParameterException("count不能为负数");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = -1;
      }
      StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://pageweibolist");
      if (paramHashMap != null) {
        localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
      {
        StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://pageweibolist");
        if (paramHashMap != null) {
          localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
        }
        CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
        return;
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
    }
  }
  
  public static void viewUserInfo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if ((paramHashMap == null) || ((TextUtils.isEmpty((CharSequence)paramHashMap.get("uid"))) && (TextUtils.isEmpty((CharSequence)paramHashMap.get("nick"))))) {
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://userinfo");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://userinfo");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void viewUsertrends(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if ((paramHashMap == null) || (TextUtils.isEmpty((CharSequence)paramHashMap.get("uid")))) {
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://usertrends");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://usertrends");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
  
  public static void weiboDetail(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (paramHashMap == null) {
      throw new WeiboIllegalParameterException("mblogId(微博id)不能为空");
    }
    if (TextUtils.isEmpty((CharSequence)paramHashMap.get("mblogid"))) {
      throw new WeiboIllegalParameterException("mblogId(微博id)不能为空");
    }
    StringBuilder localStringBuilder1 = new StringBuilder("sinaweibo://detail");
    if (paramHashMap != null) {
      localStringBuilder1.append(CommonUtils.buildUriQuery(paramHashMap));
    }
    if ((paramHashMap != null) && (!TextUtils.isEmpty((CharSequence)paramHashMap.get("packagename"))))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("sinaweibo://detail");
      if (paramHashMap != null) {
        localStringBuilder2.append(CommonUtils.buildUriQuery(paramHashMap));
      }
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), (String)paramHashMap.get("packagename"));
      return;
    }
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder1.toString(), null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\call\WeiboPageUtilsV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */