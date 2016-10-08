package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class WeiboPageUtils
{
  public static void displayInWeiboMap(Context paramContext, Position paramPosition, String paramString)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    String str3 = "";
    String str2 = "";
    String str1 = "";
    if (paramPosition != null)
    {
      str3 = paramPosition.getStrLongitude();
      str2 = paramPosition.getStrLatitude();
      str1 = paramPosition.getStrOffset();
    }
    openInWeiboBrowser(paramContext, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", new Object[] { str3, str2, str1 }), "default", paramString);
  }
  
  public static void openInWeiboBrowser(Context paramContext, String paramString1, String paramString2, String paramString3)
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
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void openQrcodeScanner(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://qrcode");
    HashMap localHashMap = new HashMap();
    localHashMap.put("extparam", paramString);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void postNewWeibo(Context paramContext, String paramString1, String paramString2, String paramString3, Position paramPosition, String paramString4, String paramString5)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://sendweibo");
    HashMap localHashMap = new HashMap();
    try
    {
      localHashMap.put("content", URLEncoder.encode(paramString1, "UTF-8").replaceAll("\\+", "%20"));
      localHashMap.put("poiid", paramString2);
      localHashMap.put("poiname", paramString3);
      if (paramPosition != null)
      {
        localHashMap.put("longitude", paramPosition.getStrLongitude());
        localHashMap.put("latitude", paramPosition.getStrLatitude());
      }
      localHashMap.put("pageid", paramString4);
      localHashMap.put("extparam", paramString5);
      localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
      CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void viewNearPhotoList(Context paramContext, String paramString1, String paramString2, Integer paramInteger, String paramString3)
  {
    viewPagePhotoList(paramContext, "100101" + paramString1 + "_" + paramString2, "nearphoto", "周边热图", paramInteger, paramString3);
  }
  
  public static void viewNearbyPeople(Context paramContext, Position paramPosition, String paramString)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://nearbypeople");
    HashMap localHashMap = new HashMap();
    if (paramPosition != null)
    {
      localHashMap.put("longitude", paramPosition.getStrLongitude());
      localHashMap.put("latitude", paramPosition.getStrLatitude());
      localHashMap.put("offset", paramPosition.getStrOffset());
    }
    localHashMap.put("extparam", paramString);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewNearbyWeibo(Context paramContext, Position paramPosition, String paramString)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://nearbyweibo");
    HashMap localHashMap = new HashMap();
    if (paramPosition != null)
    {
      localHashMap.put("longitude", paramPosition.getStrLongitude());
      localHashMap.put("latitude", paramPosition.getStrLatitude());
      localHashMap.put("offset", paramPosition.getStrOffset());
    }
    localHashMap.put("extparam", paramString);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewPageDetailInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://pagedetailinfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageid", paramString1);
    localHashMap.put("cardid", paramString2);
    localHashMap.put("title", paramString3);
    localHashMap.put("extparam", paramString4);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewPageInfo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://pageinfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageid", paramString1);
    localHashMap.put("title", paramString2);
    localHashMap.put("extparam", paramString3);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewPagePhotoList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    if ((paramInteger != null) && (paramInteger.intValue() < 0)) {
      throw new WeiboIllegalParameterException("count不能为负数");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://pagephotolist");
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageid", paramString1);
    localHashMap.put("cardid", paramString2);
    localHashMap.put("title", paramString3);
    localHashMap.put("page", "1");
    localHashMap.put("count", String.valueOf(paramInteger));
    localHashMap.put("extparam", paramString4);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewPageProductList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    if ((paramInteger != null) && (paramInteger.intValue() < 0)) {
      throw new WeiboIllegalParameterException("count不能为负数");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://pageproductlist");
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageid", paramString1);
    localHashMap.put("cardid", paramString2);
    localHashMap.put("title", paramString3);
    localHashMap.put("page", "1");
    localHashMap.put("count", String.valueOf(paramInteger));
    localHashMap.put("extparam", paramString4);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewPageUserList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    if ((paramInteger != null) && (paramInteger.intValue() < 0)) {
      throw new WeiboIllegalParameterException("count不能为负数");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://pageuserlist");
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageid", paramString1);
    localHashMap.put("cardid", paramString2);
    localHashMap.put("title", paramString3);
    localHashMap.put("page", "1");
    localHashMap.put("count", String.valueOf(paramInteger));
    localHashMap.put("extparam", paramString4);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewPageWeiboList(Context paramContext, String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new WeiboIllegalParameterException("cardId不能为空");
    }
    if ((paramInteger != null) && (paramInteger.intValue() < 0)) {
      throw new WeiboIllegalParameterException("count不能为负数");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://pageweibolist");
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageid", paramString1);
    localHashMap.put("cardid", paramString2);
    localHashMap.put("title", paramString3);
    localHashMap.put("page", "1");
    localHashMap.put("count", String.valueOf(paramInteger));
    localHashMap.put("extparam", paramString4);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewPoiPage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    viewPageInfo(paramContext, "100101" + paramString1 + "_" + paramString2, paramString3, paramString4);
  }
  
  public static void viewPoiPhotoList(Context paramContext, String paramString1, Integer paramInteger, String paramString2)
  {
    viewPagePhotoList(paramContext, "100101" + paramString1, "nearphoto", "周边热图", paramInteger, paramString2);
  }
  
  public static void viewUserInfo(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://userinfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("nick", paramString2);
    localHashMap.put("extparam", paramString3);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void viewUsertrends(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("uid和nick必须至少有一个不为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://usertrends");
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramString1);
    localHashMap.put("extparam", paramString2);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
  
  public static void weiboDetail(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new WeiboIllegalParameterException("context不能为空");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new WeiboIllegalParameterException("pageId不能为空");
    }
    StringBuilder localStringBuilder = new StringBuilder("sinaweibo://detail");
    HashMap localHashMap = new HashMap();
    localHashMap.put("mblogid", paramString1);
    localHashMap.put("extparam", paramString2);
    localStringBuilder.append(CommonUtils.buildUriQuery(localHashMap));
    CommonUtils.openWeiboActivity(paramContext, "android.intent.action.VIEW", localStringBuilder.toString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\call\WeiboPageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */