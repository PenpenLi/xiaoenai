package com.mob.tools.log;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public class b
{
  private HashMap<String, a> a = new HashMap();
  private String b = "";
  private String c = "";
  
  private String a(Thread paramThread)
  {
    paramThread = paramThread.getStackTrace();
    if ((paramThread != null) && (paramThread.length > 0))
    {
      String str2 = paramThread[(paramThread.length - 1)];
      paramThread = str2.getFileName();
      if ((paramThread == null) || (paramThread.length() <= 0)) {}
      for (String str1 = str2.getClassName();; str1 = this.c + "/" + paramThread)
      {
        int i = str2.getLineNumber();
        paramThread = String.valueOf(i);
        if (i < 0)
        {
          str2 = str2.getMethodName();
          if (str2 != null)
          {
            paramThread = str2;
            if (str2.length() > 0) {}
          }
          else
          {
            paramThread = "Unknown Source";
          }
        }
        return str1 + "(" + paramThread + ")";
      }
    }
    return this.c;
  }
  
  private String a(Thread paramThread, String paramString)
  {
    return String.format("%s %s", new Object[] { paramThread.getName(), paramString });
  }
  
  public int a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = Thread.currentThread();
    paramString2 = a((Thread)localObject, paramString2);
    localObject = a((Thread)localObject);
    a locala = (a)this.a.get(paramString1);
    if (locala != null) {
      locala.log(paramString1, paramInt1, paramInt2, (String)localObject, paramString2);
    }
    return 0;
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext.getPackageName();
    if (TextUtils.isEmpty(this.b))
    {
      this.b = "";
      return;
    }
    this.c = this.b;
  }
  
  public void a(String paramString, a parama)
  {
    this.a.put(paramString, parama);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a locala = (a)this.a.get(paramString1);
    if (locala != null) {
      locala.log(paramString1, 6, 2, this.c, paramString2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\log\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */