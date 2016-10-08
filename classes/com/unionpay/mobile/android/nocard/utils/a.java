package com.unionpay.mobile.android.nocard.utils;

import android.content.Intent;
import android.os.Bundle;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.plugin.c;
import com.unionpay.mobile.android.utils.h;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static String a(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("paydata")) {
        break label26;
      }
      localObject1 = paramBundle.getString("paydata");
    }
    label26:
    do
    {
      return (String)localObject1;
      localObject1 = localObject2;
    } while (!paramBundle.containsKey("tn"));
    return paramBundle.getString("tn");
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 27
    //   4: ldc 29
    //   6: invokestatic 34	com/unionpay/mobile/android/utils/h:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: ifnull +113 -> 124
    //   14: aload_0
    //   15: invokestatic 39	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_0
    //   19: ldc 27
    //   21: new 41	java/lang/StringBuilder
    //   24: dup
    //   25: ldc 43
    //   27: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 58	com/unionpay/mobile/android/utils/h:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: ifnull +67 -> 109
    //   45: aload_0
    //   46: invokestatic 63	com/unionpay/mobile/android/utils/a:a	(Ljava/lang/String;)[B
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +14 -> 67
    //   56: new 65	java/lang/String
    //   59: dup
    //   60: aload_0
    //   61: ldc 67
    //   63: invokespecial 70	java/lang/String:<init>	([BLjava/lang/String;)V
    //   66: astore_1
    //   67: ldc 27
    //   69: new 41	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 72
    //   75: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_1
    //   79: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 74
    //   84: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 34	com/unionpay/mobile/android/utils/h:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: ldc 27
    //   96: ldc 76
    //   98: invokestatic 34	com/unionpay/mobile/android/utils/h:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: aload_1
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -61 -> 50
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 81	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   119: aload_2
    //   120: astore_1
    //   121: goto -54 -> 67
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -107 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramString	String
    //   51	70	1	localObject1	Object
    //   1	119	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	50	104	java/io/IOException
    //   56	67	114	java/io/UnsupportedEncodingException
  }
  
  public static boolean a(Intent paramIntent, b paramb)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    if (paramIntent == null) {
      return false;
    }
    h.c("uppay", " ===>" + paramIntent.toString());
    String str1 = paramIntent.getDataString();
    paramIntent = paramIntent.getExtras();
    label142:
    int i;
    label186:
    label221:
    boolean bool1;
    if ((paramIntent != null) && (paramIntent.containsKey("reqOriginalId")))
    {
      h.c("uppay", " bundle===>" + paramIntent.toString());
      paramb.D.a = paramIntent.getInt("reqOriginalId");
      h.b("uppay", "reqID:" + paramb.D.a);
      paramb.D.e = paramIntent.getBoolean("invokedbyplugin");
      if (paramIntent == null) {
        break label412;
      }
      paramb.aC = paramIntent.getBoolean("dlgstyle", false);
      String str2 = paramIntent.getString("url_index");
      if (str2 != null)
      {
        if (Pattern.compile("[0-9]*").matcher(str2).matches()) {
          break label406;
        }
        i = 0;
        if (i != 0) {
          paramb.aE = Integer.parseInt(str2);
        }
      }
      com.unionpay.mobile.android.global.a.L = paramIntent.getInt("navbargb", -10705958);
      com.unionpay.mobile.android.global.a.M = paramIntent.getInt("divlinecolor", -13268007);
      if (paramb.aC)
      {
        com.unionpay.mobile.android.global.b.b = -1;
        com.unionpay.mobile.android.global.b.c = -2513882;
        com.unionpay.mobile.android.global.b.d = 58791;
      }
      switch (paramb.D.a)
      {
      default: 
        bool1 = bool4;
        label312:
        if ((paramb.D.a == 2) || (paramb.D.a == 3)) {
          paramb.D.d = true;
        }
        if (!paramb.c) {
          break;
        }
      }
    }
    for (paramIntent = "1.8";; paramIntent = "1.4")
    {
      paramb.a = paramIntent;
      return bool1;
      if ((str1 == null) || (str1.length() <= 0)) {
        break;
      }
      paramb.D.a = 1000;
      h.b("uppay", "nativeBrowser data:" + str1);
      break label142;
      label406:
      i = 1;
      break label186;
      label412:
      paramb.aC = false;
      com.unionpay.mobile.android.global.a.L = -10705958;
      com.unionpay.mobile.android.global.a.M = -13268007;
      break label221;
      paramb.D.c = paramIntent.getString("ex_mode");
      h.a("uppay", "mServerIdentifier = " + paramb.D.c);
      paramb.b = a(paramIntent);
      paramb.d = paramIntent.getString("appID");
      if (paramb.d == null) {
        paramb.d = "";
      }
      str1 = paramIntent.getString("frontNotifyByPlugin");
      if ((str1 == null) || (str1.length() == 0)) {}
      for (bool1 = true;; bool1 = false)
      {
        paramb.P = bool1;
        bool1 = bool3;
        if (paramb.b != null)
        {
          bool1 = bool3;
          if (paramb.b.trim().length() > 0)
          {
            h.a("uppay", "tn from bundle:" + paramb.b);
            bool1 = bool2;
            if (!"2".equalsIgnoreCase(paramb.b.substring(paramb.b.length() - 1))) {
              bool1 = true;
            }
            paramb.c = bool1;
            h.a("uppay", "dw.isNewTypeTn=" + paramb.c);
            bool1 = true;
          }
        }
        paramb.m = paramIntent.getString("ResultURL");
        h.a("uppay", "result URL:" + paramb.m);
        break;
      }
      str1 = paramIntent.getString("uppayuri");
      paramb.D.b = paramIntent.getString("resultIntentAction");
      h.a("uppay", " result Action=" + paramb.D.b);
      bool1 = a(str1, paramb);
      break label312;
      paramb.D.c = paramIntent.getString("ex_mode");
      paramb.D.g = paramIntent.getString("tencentUID");
      paramb.D.h = paramIntent.getString("tencentWID");
      paramb.b = a(paramIntent);
      bool1 = bool4;
      if (paramb.b == null) {
        break label312;
      }
      bool1 = bool4;
      if (paramb.b.trim().length() <= 0) {
        break label312;
      }
      bool1 = bool4;
      if (paramb.D.h == null) {
        break label312;
      }
      bool1 = bool4;
      if (paramb.D.h.trim().length() <= 0) {
        break label312;
      }
      bool1 = true;
      break label312;
      paramIntent = paramIntent.getString("paydata");
      h.b("PluginEx", " paydata=" + paramIntent);
      bool1 = b(a(paramIntent), paramb);
      break label312;
      bool1 = a(str1, paramb);
      break label312;
    }
  }
  
  private static boolean a(String paramString, b paramb)
  {
    Object localObject1 = null;
    if (paramString != null)
    {
      paramString = paramString.split("\\?");
      if (paramString.length < 2) {
        h.c("uppay", "uppay protocol params error!");
      }
    }
    else
    {
      return false;
    }
    paramString = paramString[1];
    h.a("uppay", "parseUPPayURIParams() +++ ");
    h.a("uppay", paramString);
    String[] arrayOfString1 = paramString.split("&");
    int j = arrayOfString1.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("=");
      Object localObject2 = localObject1;
      String str = paramString;
      if (arrayOfString2.length >= 2)
      {
        if (!arrayOfString2[0].equalsIgnoreCase("style")) {
          break label137;
        }
        str = arrayOfString2[1];
        localObject2 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        paramString = str;
        break;
        label137:
        localObject2 = localObject1;
        str = paramString;
        if (arrayOfString2[0].equalsIgnoreCase("paydata"))
        {
          localObject2 = arrayOfString2[1];
          str = paramString;
        }
      }
    }
    if ((paramString != null) && (paramString.equalsIgnoreCase("token")) && (localObject1 != null)) {
      h.a("uppay", "paydata=" + (String)localObject1);
    }
    for (boolean bool = b(a((String)localObject1), paramb);; bool = false)
    {
      h.a("uppay", "parseUPPayURIParams() ---");
      return bool;
    }
  }
  
  private static boolean b(String paramString, b paramb)
  {
    boolean bool = false;
    if ((paramString == null) || (paramString.length() == 0)) {}
    label96:
    do
    {
      return false;
      paramb.D.c = "00";
      paramString = paramString.split(",");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString = paramString[i].trim().split("=");
        if (arrayOfString.length >= 2)
        {
          if (!arrayOfString[0].trim().equalsIgnoreCase("tn")) {
            break label96;
          }
          paramb.b = arrayOfString[1].trim();
        }
        for (;;)
        {
          i += 1;
          break;
          if (arrayOfString[0].trim().equalsIgnoreCase("usetestmode"))
          {
            if (arrayOfString[1].trim().equalsIgnoreCase("true")) {
              paramb.D.c = "01";
            } else if (arrayOfString[1].trim().equalsIgnoreCase("test")) {
              paramb.D.c = "02";
            } else if (arrayOfString[1].trim().equalsIgnoreCase("inner")) {
              paramb.D.c = "98";
            }
          }
          else if (arrayOfString[0].trim().equalsIgnoreCase("ResultURL")) {
            try
            {
              paramb.m = URLDecoder.decode(arrayOfString[1].trim(), "UTF-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
        }
      }
    } while ((paramb.b == null) || (paramb.b.length() <= 0) || (paramb.m == null) || (paramb.m.length() <= 0));
    if (!"2".equalsIgnoreCase(paramb.b.substring(paramb.b.length() - 1))) {
      bool = true;
    }
    paramb.c = bool;
    h.a("uppay", "dw.isNewTypeTn=" + paramb.c);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */