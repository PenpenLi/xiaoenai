package com.tencent.wxop.stat.b;

import android.util.Log;
import com.tencent.wxop.stat.c;

public final class b
{
  private String a = "default";
  private boolean ch = true;
  private int cp = 2;
  
  public b() {}
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  private String c()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {}
    for (;;)
    {
      return null;
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (!localStackTraceElement.getClassName().equals(getClass().getName()))) {
          return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
        }
        i += 1;
      }
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    if (this.cp <= 6)
    {
      Log.e(this.a, "", paramThrowable);
      c.F();
    }
  }
  
  public final void ap()
  {
    this.ch = false;
  }
  
  public final void b(Object paramObject)
  {
    String str;
    if ((this.ch) && (this.cp <= 4))
    {
      str = c();
      if (str != null) {
        break label43;
      }
    }
    label43:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.i(this.a, (String)paramObject);
      c.F();
      return;
    }
  }
  
  public final void b(Throwable paramThrowable)
  {
    if (this.ch) {
      a(paramThrowable);
    }
  }
  
  public final void c(Object paramObject)
  {
    if (this.ch) {
      warn(paramObject);
    }
  }
  
  public final void d(Object paramObject)
  {
    if (this.ch) {
      error(paramObject);
    }
  }
  
  public final void debug(Object paramObject)
  {
    String str;
    if (this.cp <= 3)
    {
      str = c();
      if (str != null) {
        break label36;
      }
    }
    label36:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.d(this.a, (String)paramObject);
      c.F();
      return;
    }
  }
  
  public final void e(Object paramObject)
  {
    if (this.ch) {
      debug(paramObject);
    }
  }
  
  public final void error(Object paramObject)
  {
    String str;
    if (this.cp <= 6)
    {
      str = c();
      if (str != null) {
        break label37;
      }
    }
    label37:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.e(this.a, (String)paramObject);
      c.F();
      return;
    }
  }
  
  public final void warn(Object paramObject)
  {
    String str;
    if (this.cp <= 5)
    {
      str = c();
      if (str != null) {
        break label36;
      }
    }
    label36:
    for (paramObject = paramObject.toString();; paramObject = str + " - " + paramObject)
    {
      Log.w(this.a, (String)paramObject);
      c.F();
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\wxop\stat\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */