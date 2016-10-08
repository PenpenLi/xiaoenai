package com.ta.utdid2.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import com.ta.utdid2.b.a.b;
import com.ta.utdid2.b.a.d;
import com.ta.utdid2.b.a.h;
import com.ta.utdid2.b.a.i;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static final String TAG = c.class.getName();
  private static Map<String, String> a = new ConcurrentHashMap();
  private static Map<String, Long> b = new ConcurrentHashMap();
  
  public static long a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      Log.e(TAG, "no context!");
      return 0L;
    }
    String str = c(paramString1, paramString2);
    if (b.containsKey(str)) {}
    for (long l = ((Long)b.get(str)).longValue();; l = 0L)
    {
      paramString2 = Long.valueOf(l);
      if (d.e) {
        Log.d(TAG, "cache AIDGenTime:" + paramString2);
      }
      paramString1 = paramString2;
      if (paramString2.longValue() == 0L)
      {
        paramString1 = Long.valueOf(paramContext.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getLong("rKrMJgyAEbVtSQGi".concat(str), 0L));
        b.put(str, paramString1);
      }
      return paramString1.longValue();
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      Log.e(TAG, "no context!");
      paramString1 = "";
    }
    String str;
    do
    {
      return paramString1;
      str = c(paramString1, paramString2);
      paramString2 = (String)a.get(str);
      if (d.e) {
        Log.d(TAG, "cache AID:" + paramString2);
      }
      paramString1 = paramString2;
    } while (!i.a(paramString2));
    paramContext = paramContext.getSharedPreferences("OfJbkLdFbPOMbGyP", 0).getString("EvQwnbilKezpOJey".concat(str), "");
    a.put(str, paramContext);
    return paramContext;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext == null)
    {
      Log.e(TAG, "no context!");
      return;
    }
    paramString1 = c(paramString1, paramString3);
    long l = System.currentTimeMillis();
    a.put(paramString1, paramString2);
    b.put(paramString1, Long.valueOf(l));
    paramContext = paramContext.getSharedPreferences("OfJbkLdFbPOMbGyP", 0);
    if (Build.VERSION.SDK_INT >= 9)
    {
      h.a(paramContext.edit().putString("EvQwnbilKezpOJey".concat(paramString1), paramString2));
      h.a(paramContext.edit().putLong("rKrMJgyAEbVtSQGi".concat(paramString1), l));
      return;
    }
    paramContext.edit().putString("EvQwnbilKezpOJey".concat(paramString1), paramString2).commit();
    paramContext.edit().putLong("rKrMJgyAEbVtSQGi".concat(paramString1), l).commit();
  }
  
  private static String c(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (paramString1 = com.ta.utdid2.b.a.c.encodeToString(paramString1.concat(paramString2).getBytes(), 2);; paramString1 = b.encodeToString(paramString1.concat(paramString2).getBytes(), 2))
    {
      if (d.e) {
        Log.d(TAG, "encodedName:" + paramString1);
      }
      return paramString1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */