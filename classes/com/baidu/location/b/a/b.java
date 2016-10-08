package com.baidu.location.b.a;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.b.b.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public final class b
{
  private static final boolean a = false;
  private static final String jdField_do = "DeviceId";
  private static final String jdField_for = "30212102dicudiab";
  private static final String jdField_if = "baidu/.cuid";
  private static final String jdField_int = "com.baidu.deviceid";
  
  public static String a(Context paramContext)
  {
    a(paramContext, "android.permission.WRITE_SETTINGS");
    a(paramContext, "android.permission.READ_PHONE_STATE");
    a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE");
    Object localObject1 = a.a(paramContext);
    String str2 = ((a)localObject1).jdField_if;
    int i;
    String str3;
    if (!((a)localObject1).a)
    {
      i = 1;
      str3 = jdMethod_if(paramContext);
      if (i == 0) {
        break label86;
      }
      localObject1 = c.a(("com.baidu" + str3).getBytes(), true);
    }
    label86:
    Object localObject3;
    Object localObject2;
    do
    {
      return (String)localObject1;
      i = 0;
      break;
      localObject3 = null;
      localObject2 = Settings.System.getString(paramContext.getContentResolver(), "com.baidu.deviceid");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = c.a(("com.baidu" + str2 + str3).getBytes(), true);
        String str1 = Settings.System.getString(paramContext.getContentResolver(), (String)localObject2);
        localObject3 = localObject2;
        localObject1 = str1;
        if (!TextUtils.isEmpty(str1))
        {
          Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", str1);
          a(str2, str1);
          localObject1 = str1;
          localObject3 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = a(str2);
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Settings.System.putString(paramContext.getContentResolver(), (String)localObject3, (String)localObject1);
          Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", (String)localObject1);
          localObject2 = localObject1;
        }
      }
      localObject1 = localObject2;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    localObject1 = UUID.randomUUID().toString();
    localObject1 = c.a((str2 + str3 + (String)localObject1).getBytes(), true);
    Settings.System.putString(paramContext.getContentResolver(), (String)localObject3, (String)localObject1);
    Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", (String)localObject1);
    a(str2, (String)localObject1);
    return (String)localObject1;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return "";
      Object localObject = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
      try
      {
        localObject = new BufferedReader(new FileReader((File)localObject));
        StringBuilder localStringBuilder = new StringBuilder();
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          localStringBuilder.append(str);
          localStringBuilder.append("\r\n");
        }
        ((BufferedReader)localObject).close();
        localObject = new String(a.a("30212102dicudiab", "30212102dicudiab", com.baidu.location.b.b.b.a(localStringBuilder.toString().getBytes()))).split("=");
        if ((localObject != null) && (localObject.length == 2) && (paramString.equals(localObject[0])))
        {
          paramString = localObject[1];
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return "";
      }
      catch (IOException paramString)
      {
        return "";
      }
      catch (FileNotFoundException paramString) {}
    }
    return "";
  }
  
  private static void a(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw new SecurityException("Permission Denial: requires permission " + paramString);
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString2);
    paramString1 = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
    try
    {
      new File(paramString1.getParent()).mkdirs();
      paramString1 = new FileWriter(paramString1, false);
      paramString1.write(com.baidu.location.b.b.b.a(a.jdMethod_if("30212102dicudiab", "30212102dicudiab", localStringBuilder.toString().getBytes()), "utf-8"));
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (IOException paramString1) {}catch (Exception paramString1) {}
  }
  
  public static String jdMethod_do(Context paramContext)
  {
    return a.a(paramContext).jdField_if;
  }
  
  public static String jdMethod_if(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  static final class a
  {
    private static final String jdField_do = "bd_setting_i";
    public final boolean a;
    public final String jdField_if;
    
    private a(String paramString, boolean paramBoolean)
    {
      this.jdField_if = paramString;
      this.a = paramBoolean;
    }
    
    static a a(Context paramContext)
    {
      bool = true;
      localObject = "";
      for (;;)
      {
        try
        {
          String str = Settings.System.getString(paramContext.getContentResolver(), "bd_setting_i");
          localObject = str;
          if (!TextUtils.isEmpty(str)) {
            continue;
          }
          localObject = str;
          str = a(paramContext, "");
          localObject = str;
        }
        catch (Exception localException1)
        {
          int i;
          Log.e("DeviceId", "Settings.System.getString or putString failed", localException1);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = a(paramContext, "");
            i = 1;
            continue;
            bool = false;
            continue;
          }
          localObject = localException2;
          continue;
        }
        try
        {
          Settings.System.putString(paramContext.getContentResolver(), "bd_setting_i", (String)localObject);
          i = 0;
        }
        catch (Exception localException2)
        {
          continue;
          i = 1;
        }
      }
      if (i == 0) {
        return new a((String)localObject, bool);
      }
    }
    
    private static String a(Context paramContext, String paramString)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          break label38;
        }
        paramContext = paramContext.getDeviceId();
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Log.e("DeviceId", "Read IMEI failed", paramContext);
          label38:
          paramContext = null;
        }
      }
      if (TextUtils.isEmpty(paramContext)) {
        return paramString;
      }
      return paramContext;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */