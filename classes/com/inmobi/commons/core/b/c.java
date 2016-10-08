package com.inmobi.commons.core.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.a.a;
import java.util.HashMap;

public final class c
{
  private static HashMap<String, c> a = new HashMap();
  private static final Object b = new Object();
  private SharedPreferences c;
  
  private c(Context paramContext, String paramString)
  {
    this.c = paramContext.getSharedPreferences(paramString, 0);
  }
  
  public static c a(Context paramContext, String paramString)
  {
    paramString = a(paramString);
    ??? = (c)a.get(paramString);
    if (??? != null) {
      return (c)???;
    }
    synchronized (b)
    {
      c localc = (c)a.get(paramString);
      if (localc != null) {
        return localc;
      }
    }
    paramContext = new c(paramContext, paramString);
    a.put(paramString, paramContext);
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    return "com.im.keyValueStore." + paramString;
  }
  
  public static c b(String paramString)
  {
    return a(a.b(), paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.apply();
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.apply();
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.apply();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  public int b(String paramString, int paramInt)
  {
    return this.c.getInt(paramString, paramInt);
  }
  
  public long b(String paramString, long paramLong)
  {
    return this.c.getLong(paramString, paramLong);
  }
  
  public String b(String paramString1, String paramString2)
  {
    return this.c.getString(paramString1, paramString2);
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    return this.c.getBoolean(paramString, paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */