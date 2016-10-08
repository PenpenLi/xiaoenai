package com.xiaoenai.app.utils.d;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public static File a(Context paramContext)
  {
    return paramContext.getApplicationContext().getDir("user-common", 0);
  }
  
  public static File a(Context paramContext, int paramInt)
  {
    return paramContext.getApplicationContext().getDir("user-" + paramInt, 0);
  }
  
  public static File a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = b(paramContext, paramInt);
    if (paramContext != null) {
      return new File(paramContext, paramString);
    }
    return null;
  }
  
  public static File a(Context paramContext, String paramString)
  {
    if (b(paramContext) != null) {
      return new File(b(paramContext), paramString);
    }
    return null;
  }
  
  public static JSONObject a(File paramFile)
  {
    if (!paramFile.exists()) {
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[paramFile.available()];
      paramFile.read(arrayOfByte);
      paramFile.close();
      paramFile = new JSONObject(g.a(arrayOfByte, "UTF-8"));
      return paramFile;
    }
    catch (JSONException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (IOException paramFile)
    {
      for (;;) {}
    }
  }
  
  public static void a(JSONObject paramJSONObject, File paramFile)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str = paramFile.getAbsolutePath();
    paramFile = str + ".tmp";
    Object localObject = new File(str);
    File localFile = new File(paramFile);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      localObject = new FileOutputStream(localFile);
      ((FileOutputStream)localObject).write(paramJSONObject.toString().getBytes("UTF-8"));
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      paramJSONObject = new File(str);
      new File(paramFile).renameTo(paramJSONObject);
      return;
    }
    catch (IOException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static boolean a(String paramString, File paramFile)
  {
    if (paramString == null) {
      return false;
    }
    String str = paramFile.getAbsolutePath();
    paramFile = str + ".tmp";
    Object localObject = new File(str);
    File localFile = new File(paramFile);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      localObject = new FileOutputStream(localFile);
      ((FileOutputStream)localObject).write(e.a("fBhCkgJMNWNYl0dVGuiJadSEWVU4mwW", paramString).getBytes("UTF-8"));
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      paramString = new File(str);
      new File(paramFile).renameTo(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {
      return paramContext.getAbsolutePath();
    }
    return null;
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    paramContext = a(paramContext, paramInt);
    if (paramContext != null) {
      return paramContext.getAbsolutePath();
    }
    return null;
  }
  
  public static JSONObject b(File paramFile)
  {
    if (!paramFile.exists()) {
      return new JSONObject();
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[paramFile.available()];
      paramFile.read(arrayOfByte);
      paramFile.close();
      paramFile = new JSONObject(e.b("fBhCkgJMNWNYl0dVGuiJadSEWVU4mwW", g.a(arrayOfByte, "UTF-8")));
      return paramFile;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (JSONException paramFile)
    {
      for (;;) {}
    }
  }
  
  public static boolean b(JSONObject paramJSONObject, File paramFile)
  {
    if (paramJSONObject == null) {
      return false;
    }
    return a(paramJSONObject.toString(), paramFile);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */