package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class LogBuilder
{
  private static final String APPKEY = "WEIBO_APPKEY";
  private static final String CHANNEL = "WEIBO_CHANNEL";
  public static final String KEY_AID = "aid";
  public static final String KEY_APPKEY = "appkey";
  public static final String KEY_CHANNEL = "channel";
  private static final String KEY_DURATION = "duration";
  public static final String KEY_END_TIME = "endtime";
  private static final String KEY_EVENT_ID = "event_id";
  private static final String KEY_EXTEND = "extend";
  public static final String KEY_HASH = "key_hash";
  public static final String KEY_PACKAGE_NAME = "packagename";
  private static final String KEY_PAGE_ID = "page_id";
  public static final String KEY_PLATFORM = "platform";
  public static final String KEY_START_TIME = "starttime";
  private static final String KEY_TIME = "time";
  public static final String KEY_TYPE = "type";
  public static final String KEY_VERSION = "version";
  private static final int MAX_COUNT = 500;
  public static final long MAX_INTERVAL = 86400000L;
  
  private static JSONObject addEventData(JSONObject paramJSONObject, EventLog paramEventLog)
  {
    try
    {
      paramJSONObject.put("event_id", paramEventLog.getEvent_id());
      if (paramEventLog.getExtend() != null)
      {
        paramEventLog = paramEventLog.getExtend();
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = paramEventLog.keySet().iterator();
        int i = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {}
          String str;
          do
          {
            paramJSONObject.put("extend", localStringBuilder.toString());
            return paramJSONObject;
            str = (String)localIterator.next();
          } while (i >= 10);
          if (!TextUtils.isEmpty((CharSequence)paramEventLog.get(str)))
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("|");
            }
            localStringBuilder.append(str).append(":").append((String)paramEventLog.get(str));
            i += 1;
          }
        }
      }
      return paramJSONObject;
    }
    catch (Exception paramEventLog)
    {
      LogUtil.e("WBAgent", "add event log error." + paramEventLog);
    }
  }
  
  private static String buildUploadLogs(String paramString)
  {
    String str = LogFileUtil.getAppLogs(LogFileUtil.getAppLogPath("app_logs"));
    if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(paramString))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{applogs:[");
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    if (localStringBuilder.charAt(localStringBuilder.length() - 1) == ',') {
      localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "");
    }
    localStringBuilder.append("]}");
    return localStringBuilder.toString();
  }
  
  public static String getAppKey(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData.get("WEIBO_APPKEY");
        if (paramContext != null)
        {
          LogUtil.i("WBAgent", "APPKEY: " + String.valueOf(paramContext));
          return String.valueOf(paramContext);
        }
        LogUtil.e("WBAgent", "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtil.e("WBAgent", "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml." + paramContext);
      }
    }
    return null;
  }
  
  public static String getChannel(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData.getString("WEIBO_CHANNEL");
        if (paramContext != null)
        {
          LogUtil.i("WBAgent", "CHANNEL: " + paramContext.trim());
          return paramContext.trim();
        }
        LogUtil.e("WBAgent", "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtil.e("WBAgent", "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml." + paramContext);
      }
    }
    return null;
  }
  
  private static JSONObject getLogInfo(PageLog paramPageLog)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      switch (paramPageLog.getType())
      {
      case ACTIVITY: 
        localJSONObject.put("type", 0);
        localJSONObject.put("time", paramPageLog.getStartTime() / 1000L);
        return localJSONObject;
      }
    }
    catch (Exception paramPageLog)
    {
      LogUtil.e("WBAgent", "get page log error." + paramPageLog);
      return localJSONObject;
    }
    localJSONObject.put("type", 1);
    localJSONObject.put("time", paramPageLog.getEndTime() / 1000L);
    localJSONObject.put("duration", paramPageLog.getDuration() / 1000L);
    return localJSONObject;
    localJSONObject.put("type", 2);
    localJSONObject.put("page_id", paramPageLog.getPage_id());
    localJSONObject.put("time", paramPageLog.getStartTime() / 1000L);
    localJSONObject.put("duration", paramPageLog.getDuration() / 1000L);
    return localJSONObject;
    localJSONObject.put("type", 3);
    localJSONObject.put("page_id", paramPageLog.getPage_id());
    localJSONObject.put("time", paramPageLog.getStartTime() / 1000L);
    addEventData(localJSONObject, (EventLog)paramPageLog);
    return localJSONObject;
    localJSONObject.put("type", 4);
    localJSONObject.put("page_id", paramPageLog.getPage_id());
    localJSONObject.put("time", paramPageLog.getStartTime() / 1000L);
    localJSONObject.put("duration", paramPageLog.getDuration() / 1000L);
    return localJSONObject;
    return localJSONObject;
  }
  
  public static String getPageLogs(List<PageLog> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localStringBuilder.toString();
      }
      localStringBuilder.append(getLogInfo((PageLog)paramList.next()).toString()).append(",");
    }
  }
  
  public static List<JSONArray> getValidUploadLogs(String paramString)
  {
    Object localObject = buildUploadLogs(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = new JSONArray();
    long l = System.currentTimeMillis();
    for (;;)
    {
      int j;
      int i;
      try
      {
        JSONArray localJSONArray = new JSONObject((String)localObject).getJSONArray("applogs");
        j = 0;
        k = 0;
        if (j >= localJSONArray.length())
        {
          if (paramString.length() > 0) {
            localArrayList.add(paramString);
          }
        }
        else
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(j);
          i = k;
          localObject = paramString;
          if (!isDataValid(l, localJSONObject.getLong("time") * 1000L)) {
            break label171;
          }
          if (k < 500)
          {
            paramString.put(localJSONObject);
            i = k + 1;
            localObject = paramString;
          }
          else
          {
            localArrayList.add(paramString);
            localObject = new JSONArray();
            i = 0;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return localArrayList;
      label171:
      j += 1;
      int k = i;
      paramString = (String)localObject;
    }
  }
  
  public static String getVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      LogUtil.i("WBAgent", "versionName: " + paramContext.versionName);
      paramContext = paramContext.versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      LogUtil.e("WBAgent", "Could not read versionName from AndroidManifest.xml." + paramContext);
    }
    return null;
  }
  
  private static boolean isDataValid(long paramLong1, long paramLong2)
  {
    return paramLong1 - paramLong2 < 86400000L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\LogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */