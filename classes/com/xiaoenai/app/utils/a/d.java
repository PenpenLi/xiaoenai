package com.xiaoenai.app.utils.a;

import android.content.Context;
import android.text.TextUtils;
import com.xiaoenai.app.utils.d.k;
import com.xiaoenai.app.utils.d.k.a;
import com.xiaoenai.app.utils.d.u;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static Context a;
  
  public static long a(String paramString, long paramLong)
  {
    paramString = h(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return paramLong;
    }
    return Long.parseLong(paramString);
  }
  
  public static String a()
  {
    File localFile = new File(a.getCacheDir(), "uil-cache-file");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator;
  }
  
  public static String a(String paramString)
  {
    return h(paramString);
  }
  
  public static void a(Context paramContext)
  {
    a = paramContext.getApplicationContext();
  }
  
  public static void a(String paramString, InputStream paramInputStream, k.a parama)
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(e().c(paramString)), 32768);
    try
    {
      boolean bool = k.a(paramInputStream, localBufferedOutputStream, parama, 32768);
      k.a(localBufferedOutputStream);
      k.a(paramInputStream);
      if (!bool) {
        e(paramString);
      }
      return;
    }
    finally
    {
      k.a(localBufferedOutputStream);
      k.a(paramInputStream);
      e(paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    e().a(paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = paramString2;
    if (paramBoolean) {
      str = g(paramString2);
    }
    e().a(paramString1, str, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString2;
    if (paramBoolean) {
      str = g(paramString2);
    }
    e().a(paramString1, str);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    if (paramInt > 0) {
      a(paramString, String.valueOf(paramJSONObject), paramInt, paramBoolean);
    }
  }
  
  public static void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    a(paramString, String.valueOf(paramJSONObject), paramBoolean);
  }
  
  public static JSONObject b(String paramString)
  {
    paramString = h(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static void b()
  {
    e().a();
  }
  
  public static File c(String paramString)
  {
    return e().b(paramString);
  }
  
  public static void c()
  {
    e locale = new e();
    locale.setPriority(9);
    locale.start();
  }
  
  public static boolean d(String paramString)
  {
    return e().b(paramString) != null;
  }
  
  private static a e()
  {
    File localFile = new File(u.a(a), "uil-cache-file");
    com.xiaoenai.app.utils.f.a.c("cache path = {}", new Object[] { localFile.getAbsoluteFile() });
    return a.a(localFile, 20000000L, 2048);
  }
  
  public static boolean e(String paramString)
  {
    return e().d(paramString);
  }
  
  private static String f(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("mzd_encrypt_flag{\"data\":"))
      {
        str = paramString;
        if (!paramString.endsWith("}")) {}
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString.substring("mzd_encrypt_flag".length()));
      str = paramString;
      if (localJSONObject != null)
      {
        str = paramString;
        if (localJSONObject.has("ver")) {
          str = com.xiaoenai.app.utils.b.a.a(localJSONObject);
        }
      }
      return str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  private static String g(String paramString)
  {
    return "mzd_encrypt_flag" + com.xiaoenai.app.utils.b.a.b(paramString);
  }
  
  private static String h(String paramString)
  {
    paramString = e().a(paramString);
    String str = f(paramString);
    if (paramString != null) {
      return str;
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */