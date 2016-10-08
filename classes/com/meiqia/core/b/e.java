package com.meiqia.core.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import b.ae;
import b.ag;
import b.al.a;
import b.an;
import b.g;
import b.h;
import com.meiqia.core.a;
import com.meiqia.core.c.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements Thread.UncaughtExceptionHandler
{
  public static final ae a = ae.a("application/json; charset=utf-8");
  private static final String b = e.class.getSimpleName();
  private static volatile e c;
  private Thread.UncaughtExceptionHandler d;
  private Context e;
  private ag f;
  
  private e(Context paramContext)
  {
    this.e = paramContext;
    this.f = new ag();
  }
  
  public static e a(Context paramContext)
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new e(paramContext);
      }
      return c;
    }
    finally {}
  }
  
  private void a(String paramString, h paramh)
  {
    paramString = an.a(a, paramString);
    paramString = new al.a().a("https://notify.bugsnag.com").a(paramString).b();
    this.f.a(paramString).a(paramh);
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        return;
      }
      long l = System.currentTimeMillis();
      paramThrowable = b(paramThrowable);
      if (!TextUtils.isEmpty(paramThrowable))
      {
        Object localObject = new File(d(), "log_" + l + ".txt");
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        localObject = new PrintWriter(new BufferedWriter(new FileWriter((File)localObject, true)));
        ((PrintWriter)localObject).print(paramThrowable);
        ((PrintWriter)localObject).close();
        return;
      }
    }
    catch (Exception paramThrowable)
    {
      Log.e(b, "dump crash info failed");
    }
  }
  
  private String b(Throwable paramThrowable)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject5 = new j(this.e);
    int n = 0;
    int i = 0;
    Object localObject3 = "";
    int j = 0;
    Object localObject4 = "";
    int m;
    do
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        String str = paramThrowable.getClass().getName();
        Object localObject1 = localObject4;
        int k = j;
        Object localObject2 = localObject3;
        m = n;
        if (paramThrowable.getStackTrace() != null)
        {
          localObject1 = localObject4;
          k = j;
          localObject2 = localObject3;
          m = n;
          if (paramThrowable.getStackTrace().length > 0)
          {
            localObject1 = localObject4;
            k = j;
            localObject2 = localObject3;
            m = n;
            if (paramThrowable.getStackTrace()[0] != null)
            {
              localObject1 = paramThrowable.getStackTrace()[0];
              localObject3 = ((StackTraceElement)localObject1).toString();
              localObject4 = ((StackTraceElement)localObject1).getMethodName();
              n = ((StackTraceElement)localObject1).getLineNumber();
              paramThrowable = paramThrowable.getStackTrace();
              int i1 = paramThrowable.length;
              j = 0;
              for (;;)
              {
                localObject1 = localObject4;
                k = n;
                localObject2 = localObject3;
                m = i;
                if (j >= i1) {
                  break;
                }
                localObject1 = paramThrowable[j];
                localObject2 = ((StackTraceElement)localObject1).toString();
                k = i;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  k = i;
                  if (((String)localObject2).contains("com.meiqia")) {
                    k = 1;
                  }
                }
                localJSONObject2.put(String.valueOf(((StackTraceElement)localObject1).getLineNumber()), localObject2);
                j += 1;
                i = k;
              }
              paramThrowable = new JSONObject();
              paramThrowable.put("name", "android sdk");
              paramThrowable.put("version", a.d());
              paramThrowable.put("url", "http://meiqia.com/");
              localObject3 = new JSONObject();
              ((JSONObject)localObject3).put("id", ((j)localObject5).r());
              if (!TextUtils.isEmpty(((j)localObject5).r()))
              {
                localObject4 = l.a(((j)localObject5).r(), (j)localObject5);
                if (localObject4 != null) {
                  ((JSONObject)localObject3).put("name", ((b)localObject4).d());
                }
              }
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("version", a.d());
              ((JSONObject)localObject4).put("name", l.d(this.e));
              localObject5 = new JSONObject();
              ((JSONObject)localObject5).put("osVersion", Build.VERSION.RELEASE);
              ((JSONObject)localObject5).put("hostname", Build.BRAND + " " + Build.MODEL + " " + Build.DEVICE);
              ((JSONObject)localObject5).put("manufacturer", Build.MANUFACTURER);
              ((JSONObject)localObject5).put("model", Build.MODEL);
              JSONArray localJSONArray1 = new JSONArray();
              JSONObject localJSONObject3 = new JSONObject();
              JSONArray localJSONArray2 = new JSONArray();
              JSONObject localJSONObject4 = new JSONObject();
              JSONArray localJSONArray3 = new JSONArray();
              JSONObject localJSONObject5 = new JSONObject();
              localJSONObject5.put("file", localObject2);
              localJSONObject5.put("lineNumber", k);
              localJSONObject5.put("method", localObject1);
              localJSONObject5.put("code", localJSONObject2);
              localJSONArray3.put(localJSONObject5);
              localJSONObject4.put("errorClass", str);
              localJSONObject4.put("stacktrace", localJSONArray3);
              localJSONArray2.put(localJSONObject4);
              localJSONObject3.put("payloadVersion", "2");
              localJSONObject3.put("exceptions", localJSONArray2);
              localJSONObject3.put("device", localObject5);
              localJSONObject3.put("app", localObject4);
              localJSONObject3.put("user", localObject3);
              localJSONObject3.put("groupingHash", str);
              localJSONArray1.put(localJSONObject3);
              localJSONObject1.put("apiKey", "ce86b33875bdf14452a94a745b9b042c");
              localJSONObject1.put("notifier", paramThrowable);
              localJSONObject1.put("events", localJSONArray1);
              paramThrowable = localJSONObject1.toString();
              return paramThrowable;
            }
          }
        }
      }
      catch (JSONException paramThrowable)
      {
        return "";
      }
    } while (m != 0);
    return "";
  }
  
  private File d()
  {
    File localFile = new File(this.e.getExternalCacheDir(), "meiqia_log");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return localFile;
  }
  
  public String a(File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramFile = new BufferedReader(new FileReader(paramFile));
      for (;;)
      {
        String str = paramFile.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    for (;;)
    {
      paramFile.close();
    }
  }
  
  public void a()
  {
    this.d = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void b()
  {
    if (this.d != null) {
      Thread.setDefaultUncaughtExceptionHandler(this.d);
    }
  }
  
  public void c()
  {
    if (!Environment.getExternalStorageState().equals("mounted")) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = d();
        if ((localObject == null) || (((File)localObject).listFiles() == null)) {
          continue;
        }
        localObject = ((File)localObject).listFiles();
        int i = 0;
        if (i >= localObject.length) {
          continue;
        }
        File localFile = localObject[i];
        if (i < 10) {
          a(a(localFile), new f(this, localFile));
        }
        for (;;)
        {
          i += 1;
          break;
          try
          {
            localFile.delete();
          }
          catch (Exception localException2) {}
        }
        return;
      }
      catch (Exception localException1) {}
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      a(paramThrowable);
      if (this.d != null)
      {
        this.d.uncaughtException(paramThread, paramThrowable);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */