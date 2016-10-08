package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.k;
import com.ta.utdid2.device.UTDevice;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static final String a = "Msp-Param";
  
  public static e a()
  {
    a locala = new a();
    locala.a = com.alipay.sdk.cons.a.b;
    locala.b = "com.alipay.mobilecashier";
    locala.c = "/device/findAccount";
    locala.d = "3.0.0";
    com.alipay.sdk.sys.b localb = com.alipay.sdk.sys.b.a();
    com.alipay.sdk.tid.b localb1 = com.alipay.sdk.tid.b.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(localb1.a)) {
        localJSONObject.put("tid", localb1.a);
      }
      localJSONObject.put("utdid", UTDevice.getUtdid(localb.a));
      localJSONObject.put("app_key", "2014052600006128");
      localJSONObject.put("new_client_key", localb1.b);
      localJSONObject.put("imei", com.alipay.sdk.util.b.a(localb.a).b());
      localJSONObject.put("imsi", com.alipay.sdk.util.b.a(localb.a).a());
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    return new e(locala, localJSONObject);
  }
  
  public static e a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    com.alipay.sdk.sys.b localb = com.alipay.sdk.sys.b.a();
    com.alipay.sdk.tid.b localb1 = com.alipay.sdk.tid.b.a();
    JSONObject localJSONObject = com.alipay.sdk.util.c.a(null, paramJSONObject);
    try
    {
      localJSONObject.put("tid", localb1.a);
      locald = localb.b;
      localContext = com.alipay.sdk.sys.b.a().a;
      localObject3 = com.alipay.sdk.util.b.a(localContext);
      if (TextUtils.isEmpty(locald.a))
      {
        paramJSONObject = k.a();
        localObject1 = k.b();
        localObject2 = k.d(localContext);
        str1 = com.alipay.sdk.cons.a.b;
        str1 = str1.substring(0, str1.indexOf("://"));
        str2 = k.e(localContext);
        str3 = Float.toString(new TextView(localContext).getTextSize());
        locald.a = ("Msp/15.0.0" + " (" + paramJSONObject + ";" + (String)localObject1 + ";" + (String)localObject2 + ";" + str1 + ";" + str2 + ";" + str3);
      }
      str1 = com.alipay.sdk.util.b.b(localContext).a();
      str2 = ((com.alipay.sdk.util.b)localObject3).a();
      str3 = ((com.alipay.sdk.util.b)localObject3).b();
      localObject4 = com.alipay.sdk.sys.b.a().a;
      localObject2 = ((Context)localObject4).getSharedPreferences("virtualImeiAndImsi", 0);
      paramJSONObject = ((SharedPreferences)localObject2).getString("virtual_imsi", null);
      localObject1 = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject))
      {
        if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
          break label940;
        }
        paramJSONObject = UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a);
        if (!TextUtils.isEmpty(paramJSONObject)) {
          break label929;
        }
        paramJSONObject = d.b();
        ((SharedPreferences)localObject2).edit().putString("virtual_imsi", paramJSONObject).commit();
        localObject1 = paramJSONObject;
      }
      localObject5 = com.alipay.sdk.sys.b.a().a;
      localObject4 = ((Context)localObject5).getSharedPreferences("virtualImeiAndImsi", 0);
      localObject2 = ((SharedPreferences)localObject4).getString("virtual_imei", null);
      paramJSONObject = (JSONObject)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
          break label952;
        }
        paramJSONObject = d.b();
        label375:
        ((SharedPreferences)localObject4).edit().putString("virtual_imei", paramJSONObject).commit();
      }
      if (localb1 != null) {
        locald.c = localb1.b;
      }
      localObject4 = Build.MANUFACTURER.replace(";", " ");
      localObject5 = Build.MODEL.replace(";", " ");
      bool = com.alipay.sdk.sys.b.b();
      str4 = ((com.alipay.sdk.util.b)localObject3).c();
      localObject2 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
      if (localObject2 == null) {
        break label976;
      }
      localObject2 = ((WifiInfo)localObject2).getSSID();
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        d locald;
        Context localContext;
        Object localObject3;
        Object localObject1;
        String str1;
        String str2;
        String str3;
        Object localObject4;
        Object localObject5;
        boolean bool;
        String str4;
        label929:
        label940:
        label952:
        continue;
        Object localObject2 = "-1";
      }
    }
    localObject3 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
    if (localObject3 != null) {}
    for (localObject3 = ((WifiInfo)localObject3).getBSSID();; localObject3 = "00")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(locald.a).append(";").append(str1).append(";").append("-1;-1").append(";").append("1").append(";").append(str2).append(";").append(str3).append(";").append(locald.c).append(";").append((String)localObject4).append(";").append((String)localObject5).append(";").append(bool).append(";").append(str4).append(";").append(com.alipay.sdk.sys.c.a()).append(";").append(locald.b).append(";").append((String)localObject1).append(";").append(paramJSONObject).append(";").append((String)localObject2).append(";").append((String)localObject3);
      if (localb1 != null)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("tid", localb1.a);
        paramJSONObject.put("utdid", UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a));
        paramJSONObject = d.a(localContext, paramJSONObject);
        if (!TextUtils.isEmpty(paramJSONObject)) {
          localStringBuilder.append(";").append(paramJSONObject);
        }
      }
      localStringBuilder.append(")");
      localJSONObject.put("user_agent", localStringBuilder.toString());
      localJSONObject.put("has_alipay", k.b(localb.a));
      localJSONObject.put("has_msp_app", k.a(localb.a));
      localJSONObject.put("external_info", paramString);
      localJSONObject.put("app_key", "2014052600006128");
      localJSONObject.put("utdid", UTDevice.getUtdid(localb.a));
      localJSONObject.put("new_client_key", localb1.b);
      localObject1 = new a();
      ((a)localObject1).a = com.alipay.sdk.cons.a.b;
      ((a)localObject1).b = "com.alipay.mobilecashier";
      ((a)localObject1).c = "/cashier/main";
      ((a)localObject1).d = "4.0.2";
      paramJSONObject = null;
      if (localJSONObject != null)
      {
        paramJSONObject = new e((a)localObject1, localJSONObject);
        paramJSONObject.d = true;
      }
      if (paramJSONObject != null) {
        a(paramc, paramJSONObject, paramString);
      }
      return paramJSONObject;
      paramJSONObject = paramJSONObject.substring(3, 18);
      break;
      paramJSONObject = com.alipay.sdk.util.b.a((Context)localObject4).a();
      break;
      paramJSONObject = com.alipay.sdk.util.b.a((Context)localObject5).b();
      break label375;
    }
  }
  
  private static e a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    a locala = new a();
    locala.a = com.alipay.sdk.cons.a.b;
    locala.b = "com.alipay.mobilecashier";
    locala.c = "/cashier/main";
    locala.d = "4.0.2";
    e locale = null;
    if (paramJSONObject != null)
    {
      locale = new e(locala, paramJSONObject);
      locale.d = paramBoolean;
    }
    return locale;
  }
  
  private static String a(String paramString)
  {
    if (!paramString.contains("biz_type")) {
      return null;
    }
    return d(paramString);
  }
  
  private static void a(c paramc, e parame, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label81:
    label105:
    label142:
    label200:
    label209:
    label219:
    do
    {
      String[] arrayOfString;
      do
      {
        return;
        arrayOfString = paramString.split("&");
      } while (arrayOfString.length == 0);
      int j = arrayOfString.length;
      int i = 0;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      if (i < j)
      {
        String str = arrayOfString[i];
        paramString = (String)localObject6;
        Object localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject6))
        {
          if (!str.contains("biz_type")) {
            paramString = null;
          }
        }
        else
        {
          localObject1 = localObject5;
          if (TextUtils.isEmpty((CharSequence)localObject5))
          {
            if (str.contains("biz_no")) {
              break label200;
            }
            localObject1 = null;
          }
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            if ((str.contains("trade_no")) && (!str.startsWith("out_trade_no"))) {
              break label209;
            }
            localObject2 = null;
          }
          localObject3 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            if (str.contains("app_userid")) {
              break label219;
            }
          }
        }
        for (localObject3 = null;; localObject3 = d(str))
        {
          i += 1;
          localObject4 = localObject3;
          localObject6 = paramString;
          localObject5 = localObject1;
          localObject3 = localObject2;
          break;
          paramString = d(str);
          break label81;
          localObject1 = d(str);
          break label105;
          localObject2 = d(str);
          break label142;
        }
      }
      paramString = new StringBuilder();
      if (!TextUtils.isEmpty((CharSequence)localObject6)) {
        paramString.append("biz_type=" + (String)localObject6 + ";");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        paramString.append("biz_no=" + (String)localObject5 + ";");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        paramString.append("trade_no=" + (String)localObject3 + ";");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        paramString.append("app_userid=" + (String)localObject4 + ";");
      }
    } while (paramString.length() == 0);
    Object localObject1 = paramString.toString();
    paramString = (String)localObject1;
    if (((String)localObject1).endsWith(";")) {
      paramString = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    paramc.b = new Header[] { new BasicHeader("Msp-Param", paramString) };
    parame.b = new WeakReference(paramc);
  }
  
  private static void a(c paramc, HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.getHeaders("Msp-Param");
    if ((paramc != null) && (paramHttpResponse.length > 0)) {
      paramc.b = paramHttpResponse;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      localObject1 = localObject2;
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
      localObject1 = localObject2;
      paramArrayOfByte = new byte['က'];
      localObject1 = localObject2;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        localObject1 = localObject2;
        int i = localGZIPInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (i == -1) {
          break;
        }
        localObject1 = localObject2;
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.flush();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      localObject1 = paramArrayOfByte;
      localGZIPInputStream.close();
      localObject1 = paramArrayOfByte;
      localByteArrayInputStream.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return (byte[])localObject1;
  }
  
  private static String b(String paramString)
  {
    if (!paramString.contains("biz_no")) {
      return null;
    }
    return d(paramString);
  }
  
  private static String c(String paramString)
  {
    if ((!paramString.contains("trade_no")) || (paramString.startsWith("out_trade_no"))) {
      return null;
    }
    return d(paramString);
  }
  
  private static String d(String paramString)
  {
    Object localObject = paramString.split("=");
    paramString = null;
    if (localObject.length > 1)
    {
      localObject = localObject[1];
      paramString = (String)localObject;
      if (((String)localObject).contains("\"")) {
        paramString = ((String)localObject).replaceAll("\"", "");
      }
    }
    return paramString;
  }
  
  private static String e(String paramString)
  {
    if (!paramString.contains("app_userid")) {
      return null;
    }
    return d(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\data\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */