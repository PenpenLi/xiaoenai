package com.xiaoenai.app.utils.f.a;

import android.os.Process;
import android.text.TextUtils;
import com.xiaoenai.app.utils.f.c.a;
import com.xiaoenai.app.utils.f.c.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e
{
  protected final c a;
  
  public e(c paramc)
  {
    this.a = paramc;
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString, Object... paramVarArgs)
  {
    if ((this.a.c <= paramInt) && ((this.a.g) || (this.a.h)))
    {
      paramString = f(paramString, paramVarArgs);
      if (this.a.g) {
        a(paramInt, paramString);
      }
      if (paramBoolean) {
        b(paramInt, paramString);
      }
      if ((this.a.h) && (this.a.b != null)) {
        this.a.b.a(paramInt, paramString);
      }
    }
  }
  
  private String f(String paramString, Object... paramVarArgs)
  {
    Object localObject3 = new Throwable().getStackTrace()[this.a.e];
    String str = ((StackTraceElement)localObject3).getMethodName();
    Object localObject2 = ((StackTraceElement)localObject3).getFileName();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ((StackTraceElement)localObject3).getClassName();
    }
    int i = ((StackTraceElement)localObject3).getLineNumber();
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).contains(".java")) {
        localObject2 = ((String)localObject1).replace(".java", "");
      }
    }
    localObject1 = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    ((SimpleDateFormat)localObject1).setLenient(false);
    localObject3 = ((SimpleDateFormat)localObject1).format(Calendar.getInstance().getTime());
    int j = Process.myPid();
    int k = Process.myTid();
    localObject1 = paramString;
    if (paramVarArgs != null) {
      if (paramVarArgs.length != 0) {
        break label205;
      }
    }
    label205:
    for (localObject1 = paramString; this.a.f; localObject1 = b.a(paramString, paramVarArgs).a()) {
      return String.format(Locale.getDefault(), "%s pid＝%d tid=%d <%s: %s: %d> %s", new Object[] { localObject3, Integer.valueOf(j), Integer.valueOf(k), localObject2, str, Integer.valueOf(i), localObject1 });
    }
    return String.format(Locale.getDefault(), "%s pid＝%d tid=%d <%s: %d> %s", new Object[] { localObject3, Integer.valueOf(j), Integer.valueOf(k), localObject2, Integer.valueOf(i), localObject1 });
  }
  
  protected abstract void a(int paramInt, String paramString);
  
  public void a(String paramString)
  {
    if (this.a.c <= 3)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label26;
      }
      a(3, "Empty/Null json content");
    }
    label26:
    do
    {
      return;
      try
      {
        if (paramString.startsWith("{"))
        {
          a(3, new JSONObject(paramString).toString(4));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        if (localJSONException.getCause() != null) {
          a(6, localJSONException.getCause().getMessage() + "\n" + paramString);
        }
        localJSONException.printStackTrace();
        return;
      }
    } while (!paramString.startsWith("["));
    a(3, new JSONArray(paramString).toString(4));
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    a(false, paramString, paramVarArgs);
  }
  
  public void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    a(paramBoolean, 6, paramString, paramVarArgs);
  }
  
  public void a(boolean paramBoolean, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (this.a.c <= 6)
    {
      String str = paramString;
      if (paramThrowable != null)
      {
        str = paramString;
        if (paramString != null) {
          str = paramString + " : " + paramThrowable.toString();
        }
      }
      a(paramBoolean, 6, str, paramVarArgs);
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (this.a.a != null) {
      this.a.a.a(paramInt, paramString);
    }
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    b(false, paramString, paramVarArgs);
  }
  
  public void b(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    a(paramBoolean, 5, paramString, paramVarArgs);
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    c(false, paramString, paramVarArgs);
  }
  
  public void c(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    a(paramBoolean, 3, paramString, paramVarArgs);
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    d(false, paramString, paramVarArgs);
  }
  
  public void d(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    a(paramBoolean, 4, paramString, paramVarArgs);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    e(false, paramString, paramVarArgs);
  }
  
  public void e(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    a(paramBoolean, 2, paramString, paramVarArgs);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */