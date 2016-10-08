package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import com.google.android.gms.common.GoogleApiAvailability;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final String a = c.class.getSimpleName();
  private static final Object b = new Object();
  private static c c;
  private static a d;
  private static String e;
  
  public static c a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (b)
      {
        c localc2 = c;
        localObject1 = localc2;
        if (localc2 == null)
        {
          localObject1 = new c();
          c = (c)localObject1;
        }
        return (c)localObject1;
      }
    }
    return localc1;
  }
  
  private void q()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.inmobi.share.id");
    com.inmobi.commons.a.a.b().registerReceiver(new ImIdShareBroadCastReceiver(), localIntentFilter);
  }
  
  private void r()
  {
    b localb = new b();
    String str2 = localb.c();
    String str1 = str2;
    if (str2 == null)
    {
      str1 = UUID.randomUUID().toString();
      localb.b(str1);
    }
    e = str1;
  }
  
  String a(Context paramContext)
  {
    return new b().d();
  }
  
  String a(String paramString)
  {
    return a(paramString, "SHA-1");
  }
  
  String a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      try
      {
        if (!"".equals(paramString1.trim()))
        {
          paramString2 = MessageDigest.getInstance(paramString2);
          paramString2.update(paramString1.getBytes());
          paramString1 = paramString2.digest();
          paramString2 = new StringBuffer();
          int i = 0;
          while (i < paramString1.length)
          {
            paramString2.append(Integer.toString((paramString1[i] & 0xFF) + 256, 16).substring(1));
            i += 1;
          }
          paramString1 = paramString2.toString();
          return paramString1;
        }
      }
      catch (NoSuchAlgorithmException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
    }
    return "TEST_EMULATOR";
  }
  
  String b(Context paramContext)
  {
    paramContext = new b();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      String str = paramContext.c();
      if (str != null) {
        localJSONObject.put("p", str);
      }
      Object localObject = paramContext.f();
      paramContext = (Context)localObject;
      if (localObject != null)
      {
        paramContext = (Context)localObject;
        if (((String)localObject).contains(str)) {
          paramContext = ((String)localObject).replace(str, "");
        }
      }
      if ((paramContext != null) && (paramContext.trim().length() != 0))
      {
        localObject = paramContext;
        if (paramContext.charAt(0) == ',') {
          localObject = paramContext.substring(1);
        }
        paramContext = new JSONArray();
        paramContext.put(localObject);
        localJSONObject.put("s", paramContext);
      }
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  String b(String paramString)
  {
    return a(paramString, "MD5");
  }
  
  public void b()
  {
    e();
    d();
    r();
    q();
    n();
  }
  
  public String c()
  {
    return e;
  }
  
  public void d()
  {
    k();
  }
  
  public void e()
  {
    if (l())
    {
      localObject = j();
      if (localObject != null)
      {
        localObject = ((a)localObject).b();
        if (localObject != null) {
          Logger.a(Logger.InternalLogLevel.DEBUG, a, "Publisher device Id is " + (String)localObject);
        }
      }
      return;
    }
    Object localObject = i();
    Logger.a(Logger.InternalLogLevel.DEBUG, a, "Publisher device Id is " + a((String)localObject));
  }
  
  String f()
  {
    return "1";
  }
  
  String g()
  {
    return e.d();
  }
  
  String h()
  {
    return e.e();
  }
  
  String i()
  {
    String str2 = Settings.Secure.getString(com.inmobi.commons.a.a.b().getContentResolver(), "android_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = Settings.System.getString(com.inmobi.commons.a.a.b().getContentResolver(), "android_id");
    }
    return str1;
  }
  
  a j()
  {
    return d;
  }
  
  void k()
  {
    b localb = new b();
    d = new a();
    d.a(localb.a());
    d.a(localb.b());
    new Thread(new c.1(this, localb)).start();
  }
  
  boolean l()
  {
    boolean bool = false;
    try
    {
      int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(com.inmobi.commons.a.a.b());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Google Play Services is not installed!");
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", "RuntimeException");
      localHashMap.put("message", localRuntimeException.getMessage());
      com.inmobi.commons.core.c.a.a().a("root", "ExceptionCaught", localHashMap);
    }
    return false;
  }
  
  public boolean m()
  {
    a locala = a().j();
    if (locala != null) {
      return locala.a();
    }
    return false;
  }
  
  protected void n()
  {
    b localb = new b();
    Object localObject2 = localb.d();
    long l = localb.e();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = UUID.randomUUID().toString();
      localb.c((String)localObject1);
      localb.b(c());
      localb.d(c());
    }
    if (l == 0L) {
      localb.a(System.currentTimeMillis());
    }
    localObject2 = new Intent();
    ((Intent)localObject2).setAction("com.inmobi.share.id");
    ((Intent)localObject2).putExtra("imid", (String)localObject1);
    ((Intent)localObject2).putExtra("appendedid", localb.f());
    ((Intent)localObject2).putExtra("imidts", localb.e());
    ((Intent)localObject2).putExtra("appid", localb.c());
    com.inmobi.commons.a.a.b().sendBroadcast((Intent)localObject2);
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Generating and broadcasting IDs. ID:" + (String)localObject1 + " AID:" + localb.f());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\uid\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */