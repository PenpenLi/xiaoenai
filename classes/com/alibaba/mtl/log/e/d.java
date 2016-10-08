package com.alibaba.mtl.log.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.mtl.log.model.LogField;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class d
{
  private static Map<String, String> s = null;
  
  public static String a(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class }).invoke(localClass.newInstance(), new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, String> a(Context paramContext)
  {
    String str3 = null;
    for (;;)
    {
      try
      {
        Object localObject;
        if (s != null)
        {
          s.put(LogField.CHANNEL.toString(), b.l());
          s.put(LogField.APPKEY.toString(), b.getAppkey());
          str2 = m.getImei(paramContext);
          str3 = m.getImsi(paramContext);
          if (!TextUtils.isEmpty(str2))
          {
            localObject = str3;
            if (!TextUtils.isEmpty(str3))
            {
              s.put(LogField.IMEI.toString(), str2);
              s.put(LogField.IMSI.toString(), localObject);
              a(s, paramContext);
              localObject = s;
              return (Map<String, String>)localObject;
            }
          }
        }
        else
        {
          s = new HashMap();
          localObject = str3;
          if (paramContext == null) {
            continue;
          }
          localObject = s;
          if (localObject != null) {}
          try
          {
            str2 = m.getImei(paramContext);
            String str4 = m.getImsi(paramContext);
            if (TextUtils.isEmpty(str2)) {
              break label481;
            }
            localObject = str4;
            if (TextUtils.isEmpty(str4)) {
              break label481;
            }
            s.put(LogField.IMEI.toString(), str2);
            s.put(LogField.IMSI.toString(), localObject);
            s.put(LogField.BRAND.toString(), Build.BRAND);
            s.put(LogField.DEVICE_MODEL.toString(), Build.MODEL);
            s.put(LogField.RESOLUTION.toString(), c(paramContext));
            s.put(LogField.CHANNEL.toString(), b.l());
            s.put(LogField.APPKEY.toString(), b.getAppkey());
            s.put(LogField.APPVERSION.toString(), d(paramContext));
            s.put(LogField.LANGUAGE.toString(), b(paramContext));
            s.put(LogField.OS.toString(), p());
            s.put(LogField.OSVERSION.toString(), o());
            s.put(LogField.SDKVERSION.toString(), "2.4.8_for_bc");
            s.put(LogField.SDKTYPE.toString(), "mini");
            try
            {
              s.put(LogField.UTDID.toString(), UTDevice.getUtdid(paramContext));
              a(s, paramContext);
              localObject = s;
            }
            catch (Throwable localThrowable)
            {
              Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
              localThrowable.printStackTrace();
              continue;
            }
          }
          catch (Exception paramContext)
          {
            str1 = str3;
          }
        }
        str2 = "";
      }
      finally {}
      String str1 = "";
      continue;
      label481:
      String str2 = "";
      str1 = "";
    }
  }
  
  private static void a(Map<String, String> paramMap, Context paramContext)
  {
    for (;;)
    {
      try
      {
        Object localObject = l.getNetworkState(paramContext);
        paramMap.put(LogField.ACCESS.toString(), localObject[0]);
        if (localObject[0].equals("2G/3G")) {
          paramMap.put(LogField.ACCESS_SUBTYPE.toString(), localObject[1]);
        }
        try
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if ((paramContext == null) || (paramContext.getSimState() != 5)) {
            break label156;
          }
          paramContext = paramContext.getNetworkOperatorName();
          localObject = paramContext;
          if (TextUtils.isEmpty(paramContext)) {
            localObject = "Unknown";
          }
          paramMap.put(LogField.CARRIER.toString(), localObject);
          return;
        }
        catch (Exception paramMap)
        {
          return;
        }
        paramMap.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
        continue;
      }
      catch (Exception localException)
      {
        paramMap.put(LogField.ACCESS.toString(), "Unknown");
        paramMap.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
        continue;
      }
      label156:
      paramContext = "";
    }
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = Locale.getDefault().getLanguage();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "Unknown";
  }
  
  private static String c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      int m = paramContext.widthPixels;
      int k = paramContext.heightPixels;
      int j = k;
      int i = m;
      if (m > k)
      {
        i = m ^ k;
        j = k ^ i;
        i ^= j;
      }
      paramContext = j + "*" + i;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "Unknown";
  }
  
  public static String d(Context paramContext)
  {
    String str = "Unknown";
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      paramContext = str;
      if (localPackageInfo != null)
      {
        s.put(LogField.APPVERSION.toString(), localPackageInfo.versionName);
        paramContext = localPackageInfo.versionName;
      }
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "Unknown";
  }
  
  public static boolean k()
  {
    if (((System.getProperty("java.vm.name") != null) && (System.getProperty("java.vm.name").toLowerCase().contains("lemur"))) || (System.getProperty("ro.yunos.version") != null) || (!TextUtils.isEmpty(q.get("ro.yunos.build.version")))) {
      return true;
    }
    return l();
  }
  
  private static boolean l()
  {
    return (!TextUtils.isEmpty(a("ro.yunos.product.chip"))) || (!TextUtils.isEmpty(a("ro.yunos.hardware")));
  }
  
  private static String o()
  {
    Object localObject = Build.VERSION.RELEASE;
    if (k())
    {
      System.getProperty("ro.yunos.version");
      String str = s();
      localObject = str;
      if (TextUtils.isEmpty(str)) {}
    }
    return (String)localObject;
  }
  
  private static String p()
  {
    String str2 = "a";
    String str1 = str2;
    if (k())
    {
      str1 = str2;
      if (!l()) {
        str1 = "y";
      }
    }
    return str1;
  }
  
  public static String q()
  {
    Object localObject2 = q.get("ro.aliyun.clouduuid", "false");
    Object localObject1 = localObject2;
    if ("false".equals(localObject2)) {
      localObject1 = q.get("ro.sys.aliyun.clouduuid", "false");
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = r();
    }
    return (String)localObject2;
  }
  
  private static String r()
  {
    try
    {
      String str = (String)Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static String s()
  {
    try
    {
      Object localObject = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
      if (localObject != null)
      {
        ((Field)localObject).setAccessible(true);
        localObject = (String)((Field)localObject).get(new String());
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */