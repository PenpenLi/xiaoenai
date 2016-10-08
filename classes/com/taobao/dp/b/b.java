package com.taobao.dp.b;

import android.content.Context;
import com.taobao.dp.a.c;
import com.taobao.dp.a.d;
import com.taobao.dp.bean.ServiceData;
import com.taobao.dp.bean.TDMessage;
import com.taobao.dp.c.e;
import com.taobao.dp.c.f;
import com.taobao.wireless.security.adapter.common.SPUtility2;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static long a()
  {
    long l2 = -1L;
    String str = SPUtility2.readFromSPUnified("HARD-INFO", "updateTime", null);
    long l1 = l2;
    if (str != null)
    {
      l1 = l2;
      if (str.length() <= 0) {}
    }
    try
    {
      l1 = Long.parseLong(str);
      return l1;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public static a a(String paramString1, String paramString2, Context paramContext, com.taobao.dp.client.a parama)
  {
    if (paramContext == null) {
      return null;
    }
    return a(SPUtility2.readFromSPUnified("UUID_APP", parama.h(), null), paramString1, paramString2, paramContext);
  }
  
  private static a a(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString1 = c.b(paramString1.getBytes("UTF-8"), paramString2, paramString3, paramContext);
        if ((paramString1 != null) && (paramString1.length != 0))
        {
          paramString1 = d.b(paramString1);
          if ((paramString1 != null) && (paramString1.length != 0))
          {
            paramString2 = new JSONObject(new String(paramString1, "UTF-8"));
            paramString1 = paramString2.getString("781f5eb6");
            paramString2 = paramString2.getString("2f1a3871");
            if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {
              break label116;
            }
            paramString1 = new a(paramString1, paramString2);
          }
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
    return paramString1;
  }
  
  private static TDMessage a(TDMessage paramTDMessage)
  {
    try
    {
      String str = paramTDMessage.getUuid();
      com.taobao.dp.a.a.a();
      paramTDMessage.setUuid(com.taobao.dp.a.a.a(str));
      return paramTDMessage;
    }
    catch (Exception paramTDMessage) {}
    return null;
  }
  
  public static void a(a parama, String paramString1, String paramString2, Context paramContext, com.taobao.dp.client.a parama1)
  {
    if (paramContext != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("781f5eb6", parama.a);
        localJSONObject.put("2f1a3871", parama.b);
        parama = d.a(localJSONObject.toString().getBytes("UTF-8"));
        if (parama != null)
        {
          if (parama.length == 0) {
            return;
          }
          parama = c.a(parama, paramString1, paramString2, paramContext);
          if ((parama != null) && (parama.length != 0))
          {
            parama = new String(parama, "UTF-8");
            SPUtility2.saveToSPUnified("UUID_APP", parama1.h(), parama, true);
            return;
          }
        }
      }
      catch (Exception parama) {}
    }
  }
  
  public static b b(com.taobao.dp.client.a parama)
  {
    b localb = new b();
    try
    {
      localb.a = SPUtility2.readFromSPUnified("UUID_APP", parama.e(), "");
      localb.b = SPUtility2.readFromSPUnified("UUID_APP", parama.f(), "");
      return localb;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      SPUtility2.writeSS(this.a, paramString1, paramString2);
    }
  }
  
  private TDMessage c(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = c.a(paramString1, paramString2, paramString3, this.a);
    if ((paramString1 != null) && (!"".equals(paramString1)))
    {
      paramString1 = d(paramString1, paramString2, paramString3);
      if (paramString1 != null)
      {
        paramString3 = new TDMessage();
        paramString3.setUuid(paramString1);
        paramString3.setAppId(paramString2);
        return a(paramString3);
      }
    }
    return null;
  }
  
  private String d(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    if (paramString1 != null) {}
    try
    {
      localObject = new ServiceData();
      ((ServiceData)localObject).setApp(paramString2);
      ((ServiceData)localObject).setVersion("1.4.2");
      ((ServiceData)localObject).setService("com.taobao.tdp");
      ((ServiceData)localObject).setOs("android");
      ((ServiceData)localObject).setPayload(paramString1);
      ((ServiceData)localObject).setTimestamp(System.currentTimeMillis());
      ((ServiceData)localObject).setSignature(c.c(((ServiceData)localObject).getService() + ((ServiceData)localObject).getVersion() + ((ServiceData)localObject).getApp() + ((ServiceData)localObject).getOs() + paramString1 + ((ServiceData)localObject).getTimestamp(), paramString2, paramString3, this.a));
      localObject = e.a(f.a(localObject));
      return (String)localObject;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  /* Error */
  public final String a(com.taobao.dp.client.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/taobao/dp/b/b:a	Landroid/content/Context;
    //   4: ifnull +44 -> 48
    //   7: aload_0
    //   8: getfield 18	com/taobao/dp/b/b:a	Landroid/content/Context;
    //   11: aload_1
    //   12: invokevirtual 242	com/taobao/dp/client/a:c	()Ljava/lang/String;
    //   15: invokestatic 246	com/taobao/wireless/security/adapter/common/SPUtility2:readSS	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull +12 -> 32
    //   23: aload_2
    //   24: astore_3
    //   25: aload_2
    //   26: invokevirtual 40	java/lang/String:length	()I
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 242	com/taobao/dp/client/a:c	()Ljava/lang/String;
    //   36: invokestatic 249	com/taobao/dp/b/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: areturn
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_2
    //   45: goto -26 -> 19
    //   48: ldc -118
    //   50: areturn
    //   51: astore_1
    //   52: aload_2
    //   53: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	b
    //   0	54	1	parama	com.taobao.dp.client.a
    //   18	8	2	str1	String
    //   42	1	2	localException	Exception
    //   44	9	2	str2	String
    //   24	17	3	str3	String
    // Exception table:
    //   from	to	target	type
    //   7	19	42	java/lang/Exception
    //   32	40	51	java/lang/Exception
  }
  
  public final String a(String paramString1, String paramString2)
  {
    String str2 = SPUtility2.readFromSPUnified("HARD-INFO", "hardinfo", null);
    String str1 = str2;
    if (str2 != null)
    {
      paramString1 = c.b(str2, paramString1, paramString2, this.a);
      str1 = paramString1;
      if (paramString1 == null) {}
    }
    try
    {
      str1 = new JSONObject(paramString1).getString("hardinfo");
      paramString1 = str1;
      if (str1 == null)
      {
        paramString2 = g.a("hid.dat");
        paramString1 = str1;
        if ("".equals(paramString2)) {}
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        try
        {
          com.taobao.dp.a.a.a();
          paramString1 = com.taobao.dp.a.a.b(paramString2);
          return paramString1;
        }
        catch (Exception paramString1) {}
        paramString1 = paramString1;
        str1 = null;
      }
    }
    return null;
  }
  
  public final String a(String paramString1, String paramString2, com.taobao.dp.client.a parama)
  {
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (;;)
    {
      try
      {
        String str = SPUtility2.readFromSPUnified("UUID", parama.d(), null);
        if (str == null) {
          return null;
        }
        paramString2 = c.b(str, paramString1, paramString2, this.a);
        paramString1 = paramString2;
        if (paramString2 != null) {
          paramString1 = new JSONObject(paramString2).getString(parama.d());
        }
        return paramString1;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      paramString1 = null;
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString1 == null) || (paramString1.length() == 0) || (this.a == null)) {}
    for (;;)
    {
      return null;
      try
      {
        com.taobao.dp.a.a.a();
        Object localObject = new JSONObject(com.taobao.dp.a.a.b(paramString1));
        paramString1 = ((JSONObject)localObject).getString("app");
        String str1 = ((JSONObject)localObject).getString("signature");
        String str2 = ((JSONObject)localObject).getString("payload");
        if ((paramString2.equals(paramString1)) && (str2 != null) && (str2.length() > 0) && (str1 != null) && (str1.length() > 0))
        {
          String str3 = ((JSONObject)localObject).getString("version");
          String str4 = ((JSONObject)localObject).getString("service");
          String str5 = ((JSONObject)localObject).getString("os");
          localObject = ((JSONObject)localObject).getString("timestamp");
          if (str1.equals(c.c(str4 + str3 + paramString1 + str5 + str2 + (String)localObject, paramString2, paramString3, this.a)))
          {
            paramString1 = c.b(str2, paramString2, paramString3, this.a);
            return paramString1;
          }
        }
      }
      catch (Exception paramString1) {}
    }
    return null;
  }
  
  public final void a(String paramString, com.taobao.dp.client.a parama)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.a == null)) {}
    while ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    try
    {
      b(parama.g(), paramString);
      try
      {
        g.a(parama.g(), paramString);
        return;
      }
      catch (Exception paramString) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3, com.taobao.dp.client.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +129 -> 130
    //   4: ldc -118
    //   6: aload_1
    //   7: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +120 -> 130
    //   13: new 76	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 111	org/json/JSONObject:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: aload 4
    //   26: invokevirtual 265	com/taobao/dp/client/a:d	()Ljava/lang/String;
    //   29: aload_1
    //   30: invokevirtual 118	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: ldc_w 263
    //   37: aload 4
    //   39: invokevirtual 265	com/taobao/dp/client/a:d	()Ljava/lang/String;
    //   42: aload 5
    //   44: invokevirtual 123	org/json/JSONObject:toString	()Ljava/lang/String;
    //   47: aload_2
    //   48: aload_3
    //   49: aload_0
    //   50: getfield 18	com/taobao/dp/b/b:a	Landroid/content/Context;
    //   53: invokestatic 152	com/taobao/dp/a/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   56: iconst_1
    //   57: invokestatic 131	com/taobao/wireless/security/adapter/common/SPUtility2:saveToSPUnified	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   60: pop
    //   61: ldc 49
    //   63: monitorenter
    //   64: ldc 49
    //   66: aload 4
    //   68: invokevirtual 136	com/taobao/dp/client/a:e	()Ljava/lang/String;
    //   71: aload_2
    //   72: iconst_1
    //   73: invokestatic 131	com/taobao/wireless/security/adapter/common/SPUtility2:saveToSPUnified	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   76: pop
    //   77: ldc 49
    //   79: aload 4
    //   81: invokevirtual 142	com/taobao/dp/client/a:f	()Ljava/lang/String;
    //   84: aload_3
    //   85: iconst_1
    //   86: invokestatic 131	com/taobao/wireless/security/adapter/common/SPUtility2:saveToSPUnified	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   89: pop
    //   90: ldc 49
    //   92: monitorexit
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: invokespecial 290	com/taobao/dp/b/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/taobao/dp/bean/TDMessage;
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +28 -> 130
    //   105: aload_0
    //   106: aload 4
    //   108: invokevirtual 242	com/taobao/dp/client/a:c	()Ljava/lang/String;
    //   111: aload_1
    //   112: invokevirtual 99	com/taobao/dp/bean/TDMessage:getUuid	()Ljava/lang/String;
    //   115: invokespecial 285	com/taobao/dp/b/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 4
    //   120: invokevirtual 242	com/taobao/dp/client/a:c	()Ljava/lang/String;
    //   123: aload_1
    //   124: invokevirtual 99	com/taobao/dp/bean/TDMessage:getUuid	()Ljava/lang/String;
    //   127: invokestatic 287	com/taobao/dp/b/g:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: return
    //   131: astore_1
    //   132: ldc 49
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: return
    //   139: astore_1
    //   140: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	b
    //   0	141	1	paramString1	String
    //   0	141	2	paramString2	String
    //   0	141	3	paramString3	String
    //   0	141	4	parama	com.taobao.dp.client.a
    //   20	23	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   64	93	131	finally
    //   13	64	137	org/json/JSONException
    //   132	137	137	org/json/JSONException
    //   118	130	139	java/lang/Exception
  }
  
  public final void b(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hardinfo", paramString1);
      SPUtility2.saveToSPUnified("HARD-INFO", "hardinfo", c.a(localJSONObject.toString(), paramString2, paramString3, this.a), true);
      SPUtility2.saveToSPUnified("HARD-INFO", "updateTime", System.currentTimeMillis(), true);
      try
      {
        com.taobao.dp.a.a.a();
        g.a("hid.dat", com.taobao.dp.a.a.a(paramString1));
        return;
      }
      catch (Exception paramString1) {}
    }
    catch (JSONException paramString2)
    {
      for (;;) {}
    }
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, com.taobao.dp.client.a parama)
  {
    try
    {
      String str = SPUtility2.readSS(this.a, parama.c());
      if (str == null)
      {
        paramString1 = c(paramString1, paramString2, paramString3);
        if (paramString1 != null) {
          b(parama.c(), paramString1.getUuid());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          g.a(parama.c(), paramString1.getUuid());
          return;
        }
        catch (Exception paramString1) {}
        localException = localException;
        Object localObject = null;
      }
    }
  }
  
  public final String c(com.taobao.dp.client.a parama)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.a != null) {}
    try
    {
      localObject1 = SPUtility2.readSS(this.a, parama.g());
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        localObject3 = g.a(parama.g());
      }
      if (localObject3 != null) {
        ((String)localObject3).length();
      }
      return (String)localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static final class a
  {
    public String a;
    public String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
  
  public static final class b
  {
    public String a = "";
    public String b = "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */