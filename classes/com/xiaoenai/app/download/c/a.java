package com.xiaoenai.app.download.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class a
{
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.xiaoenai.app.download", 2);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    if (paramContext != null) {
      return paramContext.getString(paramString, "");
    }
    return "";
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, "url" + paramInt, "");
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    a(paramContext, "url" + paramInt, paramString);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putLong(paramString, paramLong);
      paramContext.commit();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext);
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putString(paramString1, paramString2);
      paramContext.commit();
    }
  }
  
  public static long b(Context paramContext, String paramString)
  {
    long l = 0L;
    paramContext = a(paramContext);
    if (paramContext != null) {
      l = paramContext.getLong(paramString, 0L);
    }
    return l;
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    return a(paramContext, "url" + paramInt);
  }
  
  public static List<String> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      if (!TextUtils.isEmpty(b(paramContext, i))) {
        localArrayList.add(a(paramContext, "url" + i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext, paramString, b(paramContext, paramString) + paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\download\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */