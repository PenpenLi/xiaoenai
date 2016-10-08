package com.alimama.mobile.sdk.config.system;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class AppUtil
{
  public static final String MOBILE_NETWORK = "cell";
  public static final String SEPARATOR = "x";
  public static final String UNKNOWN = "unknown";
  public static final String WIFI = "wifi";
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }
  
  public static Map<String, String> convertHeaders(Header[] paramArrayOfHeader)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localHashMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localHashMap;
  }
  
  public static String[] getCurrentNetowrk(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "unknown";
    arrayOfString[1] = "unknown";
    if (paramContext != null) {
      try
      {
        if (!checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
          return arrayOfString;
        }
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          return arrayOfString;
        }
        NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(1);
        if ((localNetworkInfo != null) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED))
        {
          arrayOfString[0] = "wifi";
          return arrayOfString;
        }
        paramContext = paramContext.getNetworkInfo(0);
        if ((paramContext != null) && (paramContext.getState() == NetworkInfo.State.CONNECTED))
        {
          arrayOfString[0] = "cell";
          arrayOfString[1] = paramContext.getSubtypeName();
          return arrayOfString;
        }
      }
      catch (Exception paramContext) {}
    }
    return arrayOfString;
  }
  
  public static String getNetworkOperator(Context paramContext)
  {
    return optString(((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName());
  }
  
  public static HttpResponse httpGet(String paramString)
  {
    paramString = new HttpGet(paramString);
    Object localObject = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 10000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject, 20000);
    HttpClientParams.setRedirecting((HttpParams)localObject, true);
    localObject = new DefaultHttpClient((HttpParams)localObject);
    if (localObject == null) {
      return null;
    }
    try
    {
      paramString = ((HttpClient)localObject).execute(paramString);
      if (paramString.getStatusLine().getStatusCode() == 200) {
        return paramString;
      }
      MMLog.i("resCode = " + paramString.getStatusLine().getStatusCode(), new Object[0]);
      return null;
    }
    catch (ClientProtocolException paramString)
    {
      MMLog.e(paramString, "", new Object[0]);
      return null;
    }
    catch (IOException paramString)
    {
      MMLog.e(paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static String makeUrl(String paramString, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(paramString);
    Iterator localIterator = paramMap.keySet().iterator();
    if (localIterator.hasNext()) {
      for (paramString = (String)localIterator.next();; paramString = paramMap.get(paramString).toString())
      {
        try
        {
          StringBuilder localStringBuilder2 = localStringBuilder1.append(URLEncoder.encode(paramString, "utf-8")).append("=");
          if (paramMap.get(paramString) != null) {
            continue;
          }
          paramString = "";
          localStringBuilder2.append(URLEncoder.encode(paramString, "utf-8")).append("&");
        }
        catch (UnsupportedEncodingException paramString)
        {
          MMLog.w(paramString, "", new Object[0]);
        }
        break;
      }
    }
    if (localStringBuilder1.toString().endsWith("&")) {
      localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1);
    }
    return localStringBuilder1.toString().replaceAll(" ", "");
  }
  
  public static String optString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    return paramString.replaceAll(" ", "");
  }
  
  public static String parseCharset(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("Content-Type");
    if (paramMap != null)
    {
      paramMap = paramMap.split(";");
      int i = 1;
      while (i < paramMap.length)
      {
        String[] arrayOfString = paramMap[i].trim().split("=");
        if ((arrayOfString.length == 2) && (arrayOfString[0].equals("charset"))) {
          return arrayOfString[1];
        }
        i += 1;
      }
    }
    return "UTF-8";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\AppUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */