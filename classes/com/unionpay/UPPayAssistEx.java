package com.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UPPayAssistEx
{
  public static final int PLUGIN_NOT_FOUND = -1;
  public static final int PLUGIN_VALID = 0;
  private static String a = "SpId";
  private static String b = "paydata";
  private static String c = "SysProvide";
  private static String d = "UseTestMode";
  private static String e = "SecurityChipType";
  private static String f = "uppayuri";
  private static String g = "resultIntentAction";
  private static String h = "reqOriginalId";
  private static String i = "com.unionpay.uppay";
  private static String j = "com.unionpay.uppay.PayActivity";
  private static String k = "ex_mode";
  private static int l = 10;
  
  private static int a(Activity paramActivity, String paramString1, String paramString2)
  {
    int m = -1;
    try
    {
      if (a(paramActivity))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt(h, 1);
        localBundle.putString(f, paramString1);
        localBundle.putString(g, paramString2);
        paramString1 = new Intent();
        paramString1.putExtras(localBundle);
        paramString1.setClassName(i, j);
        paramActivity.startActivity(paramString1);
        m = 0;
      }
      return m;
    }
    catch (PackageManager.NameNotFoundException paramActivity) {}
    return -1;
  }
  
  private static int a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (a(paramActivity))
      {
        Bundle localBundle = new Bundle();
        a(paramString3, localBundle, paramString4);
        localBundle.putString(a, paramString1);
        localBundle.putString(c, paramString2);
        localBundle.putString(b, paramString3);
        localBundle.putString(e, null);
        localBundle.putInt(h, 0);
        paramString1 = new Intent();
        paramString1.putExtras(localBundle);
        paramString1.setClassName(i, j);
        paramActivity.startActivityForResult(paramString1, l);
        return 0;
      }
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      return -1;
    }
    return -1;
  }
  
  private static void a(String paramString1, Bundle paramBundle, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() <= 0)) {
      return;
    }
    if (paramString1.trim().charAt(0) == '<')
    {
      if ((paramString2 != null) && (paramString2.trim().equalsIgnoreCase("00")))
      {
        paramBundle.putBoolean(d, false);
        return;
      }
      paramBundle.putBoolean(d, true);
      return;
    }
    paramBundle.putString(k, paramString2);
  }
  
  private static boolean a(Activity paramActivity)
  {
    String[] arrayOfString = new String[27];
    arrayOfString[0] = "30820267308201d0a00302010202044";
    arrayOfString[1] = "ecb7d98300d06092a8";
    arrayOfString[2] = "64886f70d01010505003078310b30090603550";
    arrayOfString[3] = "406130238363111300f060355040813085";
    arrayOfString[4] = "368616e676";
    arrayOfString[5] = "861693111300f060355040713085368616e67686169311730";
    arrayOfString[6] = "15060355040a130e4368696e6120556e696f6e50617931173015060355040b130e4";
    arrayOfString[7] = "368696e612055";
    arrayOfString[8] = "6e696f6e5061793111300f06035504031308556e696f6e5061";
    arrayOfString[9] = "79301e170d3131313132323130343634385a170d333631313135313034";
    arrayOfString[10] = "3634385a3078310b300906035504061302383631";
    arrayOfString[11] = "11300f060355040813085368616e67686169311130";
    arrayOfString[12] = "0f060355040713085368616e676861693117";
    arrayOfString[13] = "3015060355040a130e4368696e6120556e696";
    arrayOfString[14] = "f6e50617931173015060355040b130e4368696e6120556e696";
    arrayOfString[15] = "f6e5061793111300f06035504031308556e696f6e50617930819f300d060";
    arrayOfString[16] = "92a864886f70d010101050003818d0030818902818100c42e6236d5054ffccaa";
    arrayOfString[17] = "a430ecd929d562";
    arrayOfString[18] = "b1ff56cef0e21c87260c63ce3ca868bf5974c14";
    arrayOfString[19] = "d9255940da7b6cd07483f4b4243fd1825b2705";
    arrayOfString[20] = "08eb9b5c67474d027fa03ce35109b11604083ab6bb4df2c46240f879f";
    arrayOfString[21] = "8cc1d6ed5e1b2cc00489215aec3fc2eac008e767b0215981cb5e";
    arrayOfString[22] = "e94ddc285669ec06b8a405dd4341eac4ea7030203010001300d06092a864886f70d010105050003818";
    arrayOfString[23] = "1001a3e74c601e3beb1b7ae4f9ab2872a0aaf1dbc2cba89c7528cd";
    arrayOfString[24] = "54aa526e7a37d8ba2311a1d3d2ab79b3fbeaf3ebb9e7da9e7cdd9be1ae5a53595f47";
    arrayOfString[25] = "b1fdf62b0f540fca5458b063af9354925a6c3505a18ff164b6b195f6e517eaee1fb783";
    arrayOfString[26] = "64c2f89fdffa16729c9779f99562bc189d2ce4722ba0faedb11aa22d0d9db228fda";
    Object localObject = paramActivity.getPackageManager();
    ((PackageManager)localObject).getActivityInfo(paramActivity.getComponentName(), 128);
    ((PackageManager)localObject).getApplicationInfo("com.unionpay.uppay", 8192);
    localObject = ((PackageManager)localObject).getPackageInfo("com.unionpay.uppay", 4160);
    String str1 = localObject.signatures[0].toCharsString();
    int n = arrayOfString.length;
    paramActivity = "";
    int m = 0;
    while (m < n)
    {
      String str2 = arrayOfString[m];
      paramActivity = paramActivity + str2;
      m += 1;
    }
    return (str1 != null) && (str1.equals(paramActivity)) && (((PackageInfo)localObject).versionCode >= 31);
  }
  
  public static boolean installUPPayPlugin(Context paramContext)
  {
    Object localObject1;
    do
    {
      try
      {
        localObject1 = paramContext.getAssets().open("UPPayPluginEx.apk");
        localObject2 = paramContext.openFileOutput("UPPayPluginEx.apk", 1);
        byte[] arrayOfByte = new byte['Ѐ'];
        for (;;)
        {
          int m = ((InputStream)localObject1).read(arrayOfByte);
          if (m <= 0) {
            break;
          }
          ((FileOutputStream)localObject2).write(arrayOfByte, 0, m);
        }
        ((FileOutputStream)localObject2).close();
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      ((InputStream)localObject1).close();
      localObject2 = paramContext.getFilesDir().getAbsolutePath();
      localObject1 = (String)localObject2 + File.separator + "UPPayPluginEx.apk";
    } while (localObject2 == null);
    Object localObject2 = new Intent("android.intent.action.VIEW");
    ((Intent)localObject2).setDataAndType(Uri.parse("file:" + (String)localObject1), "application/vnd.android.package-archive");
    paramContext.startActivity((Intent)localObject2);
    return true;
  }
  
  public static int startPay(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramActivity, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void startPayByJAR(Activity paramActivity, Class paramClass, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    a(paramString3, localBundle, paramString4);
    localBundle.putString(a, paramString1);
    localBundle.putString(c, paramString2);
    localBundle.putString(b, paramString3);
    localBundle.putInt(h, 2);
    paramString1 = new Intent();
    paramString1.putExtras(localBundle);
    paramString1.setClass(paramActivity, paramClass);
    paramActivity.startActivityForResult(paramString1, l);
  }
  
  public static int startPayFromBrowser(Activity paramActivity, String paramString1, String paramString2)
  {
    return a(paramActivity, paramString1, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\UPPayAssistEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */