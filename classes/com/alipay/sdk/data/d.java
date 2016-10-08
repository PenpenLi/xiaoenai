package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.cons.a;
import com.alipay.sdk.sys.c;
import com.alipay.sdk.util.g;
import com.alipay.sdk.util.k;
import com.ta.utdid2.device.UTDevice;
import java.util.HashMap;
import java.util.Random;

public final class d
{
  private static final String d = "virtualImeiAndImsi";
  private static final String e = "virtual_imei";
  private static final String f = "virtual_imsi";
  private static d g;
  String a;
  String b = "sdk-and-lite";
  String c;
  
  public static d a()
  {
    try
    {
      if (g == null) {
        g = new d();
      }
      d locald = g;
      return locald;
    }
    finally {}
  }
  
  private static String a(Context paramContext)
  {
    return Float.toString(new TextView(paramContext).getTextSize());
  }
  
  static String a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    String str = "";
    try
    {
      paramContext = SecurityClientMobile.GetApdid(paramContext, paramHashMap);
      new StringBuilder("apdid:").append(paramContext).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  private String a(com.alipay.sdk.tid.b paramb)
  {
    Context localContext = com.alipay.sdk.sys.b.a().a;
    Object localObject4 = com.alipay.sdk.util.b.a(localContext);
    if (TextUtils.isEmpty(this.a))
    {
      localObject1 = k.a();
      localObject2 = k.b();
      localObject3 = k.d(localContext);
      str1 = a.b;
      str1 = str1.substring(0, str1.indexOf("://"));
      str2 = k.e(localContext);
      str3 = Float.toString(new TextView(localContext).getTextSize());
      this.a = ("Msp/15.0.0" + " (" + (String)localObject1 + ";" + (String)localObject2 + ";" + (String)localObject3 + ";" + str1 + ";" + str2 + ";" + str3);
    }
    String str1 = com.alipay.sdk.util.b.b(localContext).a();
    String str2 = ((com.alipay.sdk.util.b)localObject4).a();
    String str3 = ((com.alipay.sdk.util.b)localObject4).b();
    Object localObject5 = com.alipay.sdk.sys.b.a().a;
    Object localObject3 = ((Context)localObject5).getSharedPreferences("virtualImeiAndImsi", 0);
    Object localObject1 = ((SharedPreferences)localObject3).getString("virtual_imsi", null);
    Object localObject2 = localObject1;
    Object localObject6;
    label336:
    boolean bool;
    String str4;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
        break label731;
      }
      localObject1 = UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = b();
        ((SharedPreferences)localObject3).edit().putString("virtual_imsi", (String)localObject1).commit();
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject6 = com.alipay.sdk.sys.b.a().a;
      localObject5 = ((Context)localObject6).getSharedPreferences("virtualImeiAndImsi", 0);
      localObject3 = ((SharedPreferences)localObject5).getString("virtual_imei", null);
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
          break label743;
        }
        localObject1 = b();
        ((SharedPreferences)localObject5).edit().putString("virtual_imei", (String)localObject1).commit();
      }
      if (paramb != null) {
        this.c = paramb.b;
      }
      localObject5 = Build.MANUFACTURER.replace(";", " ");
      localObject6 = Build.MODEL.replace(";", " ");
      bool = com.alipay.sdk.sys.b.b();
      str4 = ((com.alipay.sdk.util.b)localObject4).c();
      localObject3 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
      if (localObject3 == null) {
        break label755;
      }
      localObject3 = ((WifiInfo)localObject3).getSSID();
      label432:
      localObject4 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
      if (localObject4 == null) {
        break label762;
      }
    }
    label731:
    label743:
    label755:
    label762:
    for (localObject4 = ((WifiInfo)localObject4).getBSSID();; localObject4 = "00")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a).append(";").append(str1).append(";").append("-1;-1").append(";").append("1").append(";").append(str2).append(";").append(str3).append(";").append(this.c).append(";").append((String)localObject5).append(";").append((String)localObject6).append(";").append(bool).append(";").append(str4).append(";").append(c.a()).append(";").append(this.b).append(";").append((String)localObject2).append(";").append((String)localObject1).append(";").append((String)localObject3).append(";").append((String)localObject4);
      if (paramb != null)
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("tid", paramb.a);
        ((HashMap)localObject1).put("utdid", UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a));
        paramb = a(localContext, (HashMap)localObject1);
        if (!TextUtils.isEmpty(paramb)) {
          localStringBuilder.append(";").append(paramb);
        }
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localObject1 = ((String)localObject1).substring(3, 18);
      break;
      localObject1 = com.alipay.sdk.util.b.a((Context)localObject5).a();
      break;
      localObject1 = com.alipay.sdk.util.b.a((Context)localObject6).b();
      break label336;
      localObject3 = "-1";
      break label432;
    }
  }
  
  static String b()
  {
    String str = Long.toHexString(System.currentTimeMillis());
    Random localRandom = new Random();
    return str + (localRandom.nextInt(9000) + 1000);
  }
  
  private static String b(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext != null) {
      return paramContext.getSSID();
    }
    return "-1";
  }
  
  private String c()
  {
    return this.c;
  }
  
  private static String c(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext != null) {
      return paramContext.getBSSID();
    }
    return "00";
  }
  
  private static String d()
  {
    return "1";
  }
  
  private static String e()
  {
    Context localContext = com.alipay.sdk.sys.b.a().a;
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("virtualImeiAndImsi", 0);
    String str2 = localSharedPreferences.getString("virtual_imei", null);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
        break label72;
      }
    }
    label72:
    for (str1 = b();; str1 = com.alipay.sdk.util.b.a(localContext).b())
    {
      localSharedPreferences.edit().putString("virtual_imei", str1).commit();
      return str1;
    }
  }
  
  private static String f()
  {
    Context localContext = com.alipay.sdk.sys.b.a().a;
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("virtualImeiAndImsi", 0);
    String str2 = localSharedPreferences.getString("virtual_imsi", null);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (!TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
        break label100;
      }
      str1 = UTDevice.getUtdid(com.alipay.sdk.sys.b.a().a);
      if (!TextUtils.isEmpty(str1)) {
        break label89;
      }
      str1 = b();
    }
    for (;;)
    {
      localSharedPreferences.edit().putString("virtual_imsi", str1).commit();
      return str1;
      label89:
      str1 = str1.substring(3, 18);
      continue;
      label100:
      str1 = com.alipay.sdk.util.b.a(localContext).a();
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 81	com/alipay/sdk/sys/b:a	()Lcom/alipay/sdk/sys/b;
    //   17: getfield 84	com/alipay/sdk/sys/b:a	Landroid/content/Context;
    //   20: invokestatic 273	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   23: invokeinterface 165 1 0
    //   28: ldc_w 275
    //   31: aload_1
    //   32: invokeinterface 171 3 0
    //   37: invokeinterface 175 1 0
    //   42: pop
    //   43: aload_1
    //   44: putstatic 276	com/alipay/sdk/cons/a:c	Ljava/lang/String;
    //   47: goto -36 -> 11
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	d
    //   0	55	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	47	50	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\data\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */