package com.alipay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.f;
import com.alipay.sdk.exception.NetErrorException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private int a = 0;
  private com.alipay.sdk.data.c b;
  
  public d() {}
  
  public d(com.alipay.sdk.data.c paramc)
  {
    this.b = paramc;
  }
  
  private String a(Context paramContext, String paramString1, String paramString2, com.alipay.sdk.data.c paramc, f paramf)
  {
    for (;;)
    {
      try
      {
        if (c.a == null)
        {
          c.a = new a(paramContext, paramString1);
          if (paramc != null)
          {
            paramContext = c.a.a(paramString2, paramc);
            paramString1 = paramContext.getStatusLine();
            paramf.c = paramString1.getStatusCode();
            paramf.d = paramString1.getReasonPhrase();
            paramString1 = this.b;
            paramString2 = paramContext.getHeaders("Msp-Param");
            if ((paramString1 != null) && (paramString2.length > 0)) {
              paramString1.b = paramString2;
            }
            paramContext = c.a(paramContext);
            return paramContext;
          }
        }
        else
        {
          if (TextUtils.equals(paramString1, c.a.a)) {
            continue;
          }
          c.a.a = paramString1;
          continue;
        }
        paramContext = c.a.a(paramString2, null);
      }
      catch (Exception paramContext)
      {
        throw new NetErrorException();
      }
      finally
      {
        c.a = null;
      }
    }
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 89	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 94	java/io/BufferedReader
    //   12: dup
    //   13: new 96	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 99	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 102	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_1
    //   25: sipush 2048
    //   28: newarray <illegal type>
    //   30: astore_2
    //   31: new 104	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 109	java/io/BufferedReader:read	([C)I
    //   44: istore 4
    //   46: iload 4
    //   48: ifle +26 -> 74
    //   51: aload_3
    //   52: aload_2
    //   53: iconst_0
    //   54: iload 4
    //   56: invokevirtual 113	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: goto -21 -> 39
    //   63: astore_1
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 118	java/io/InputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_1
    //   75: invokevirtual 119	java/io/BufferedReader:close	()V
    //   78: aload_3
    //   79: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_1
    //   83: aload_0
    //   84: invokevirtual 118	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: areturn
    //   89: astore_0
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: ifnull +7 -> 103
    //   99: aload_0
    //   100: invokevirtual 118	java/io/InputStream:close	()V
    //   103: aload_1
    //   104: athrow
    //   105: astore_0
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: goto -18 -> 95
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -55 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramString	String
    //   24	16	1	localBufferedReader	java.io.BufferedReader
    //   63	12	1	localException	Exception
    //   82	9	1	str	String
    //   92	12	1	localObject1	Object
    //   112	1	1	localObject2	Object
    //   30	23	2	arrayOfChar	char[]
    //   38	41	3	localStringBuilder	StringBuilder
    //   44	11	4	i	int
    // Exception table:
    //   from	to	target	type
    //   9	39	63	java/lang/Exception
    //   39	46	63	java/lang/Exception
    //   51	60	63	java/lang/Exception
    //   74	83	63	java/lang/Exception
    //   83	87	89	java/io/IOException
    //   0	9	92	finally
    //   68	72	105	java/io/IOException
    //   99	103	108	java/io/IOException
    //   9	39	112	finally
    //   39	46	112	finally
    //   51	60	112	finally
    //   74	83	112	finally
    //   0	9	116	java/lang/Exception
  }
  
  private JSONObject a(Context paramContext, com.alipay.sdk.data.e parame, f paramf)
  {
    int i = 0;
    Object localObject1 = new Random();
    Object localObject2 = new StringBuilder();
    if (i < 24)
    {
      switch (((Random)localObject1).nextInt(3))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject2).append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 65.0D)));
        continue;
        ((StringBuilder)localObject2).append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 97.0D)));
        continue;
        ((StringBuilder)localObject2).append(String.valueOf(new Random().nextInt(10)));
      }
    }
    localObject1 = ((StringBuilder)localObject2).toString();
    try
    {
      localObject2 = a(paramContext, parame.a.a, parame.a((String)localObject1).toString(), (com.alipay.sdk.data.c)parame.b.get(), paramf);
      paramf.e = Calendar.getInstance().getTimeInMillis();
      if (parame.c)
      {
        localObject2 = a((String)localObject2, paramf);
        if ((paramf.c == 1000) && (this.a < 3))
        {
          this.a += 1;
          return a(paramContext, parame, paramf);
        }
        this.a = 0;
        paramContext = com.alipay.sdk.encrypt.e.b((String)localObject1, ((JSONObject)localObject2).optString("res_data"));
        new StringBuilder("respData:").append(paramContext).toString();
        paramContext = new JSONObject(paramContext);
        return paramContext;
      }
    }
    catch (NetErrorException paramContext)
    {
      throw paramContext;
      paramContext = a((String)localObject2, paramf);
      new StringBuilder("respData:").append(paramContext.toString()).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new NetErrorException();
    }
  }
  
  private JSONObject a(Context paramContext, com.alipay.sdk.data.e parame, f paramf, String paramString1, String paramString2)
  {
    paramString2 = a(paramString2, paramf);
    if ((paramf.c == 1000) && (this.a < 3))
    {
      this.a += 1;
      return a(paramContext, parame, paramf);
    }
    this.a = 0;
    paramContext = com.alipay.sdk.encrypt.e.b(paramString1, paramString2.optString("res_data"));
    new StringBuilder("respData:").append(paramContext).toString();
    return new JSONObject(paramContext);
  }
  
  private static JSONObject a(f paramf, String paramString)
  {
    paramf = a(paramString, paramf);
    new StringBuilder("respData:").append(paramf.toString()).toString();
    return paramf;
  }
  
  private static JSONObject a(String paramString, f paramf)
  {
    paramString = new JSONObject(paramString).optJSONObject("data");
    if (paramString != null)
    {
      paramf.c = paramString.optInt("code", 503);
      paramf.d = paramString.optString("error_msg", "");
      paramString = paramString.optJSONObject("params");
      if (paramString != null)
      {
        if (paramf.c == 1000)
        {
          localObject = paramString.optString("public_key");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            com.alipay.sdk.sys.b.a().b.a((String)localObject);
          }
        }
        Object localObject = new com.alipay.sdk.data.a();
        ((com.alipay.sdk.data.a)localObject).c = paramString.optString("next_api_name");
        ((com.alipay.sdk.data.a)localObject).d = paramString.optString("next_api_version");
        ((com.alipay.sdk.data.a)localObject).b = paramString.optString("next_namespace");
        ((com.alipay.sdk.data.a)localObject).a = paramString.optString("next_request_url");
        paramf.l = ((com.alipay.sdk.data.a)localObject);
        return paramString;
      }
      int i = paramf.c;
    }
    for (;;)
    {
      return null;
      paramf.c = 503;
      paramf.d = "";
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("public_key");
    if (!TextUtils.isEmpty(paramJSONObject)) {
      com.alipay.sdk.sys.b.a().b.a(paramJSONObject);
    }
  }
  
  public final com.alipay.sdk.protocol.c a(Context paramContext, com.alipay.sdk.data.e parame, boolean paramBoolean)
  {
    Object localObject1 = new f();
    Object localObject2 = a(paramContext, parame, (f)localObject1);
    if (((JSONObject)localObject2).optBoolean("gzip"))
    {
      paramContext = ((JSONObject)localObject2).optJSONObject("form");
      if ((paramContext != null) && (paramContext.has("quickpay"))) {
        paramContext = com.alipay.sdk.encrypt.a.a(paramContext.optString("quickpay"));
      }
    }
    try
    {
      paramContext = com.alipay.sdk.data.b.a(paramContext);
      if (TextUtils.equals(com.alipay.sdk.encrypt.c.a(paramContext), ((JSONObject)localObject2).optString("md5"))) {
        ((JSONObject)localObject2).put("form", new JSONObject(new String(paramContext, "utf-8")));
      }
      for (;;)
      {
        new StringBuilder("responsestring decoded ").append(localObject2).toString();
        paramContext = new com.alipay.sdk.protocol.c(parame, (f)localObject1);
        paramContext.a((JSONObject)localObject2);
        if (!paramBoolean) {
          break;
        }
        return paramContext;
        ((f)localObject1).k = false;
      }
      new com.alipay.sdk.protocol.e();
      parame = com.alipay.sdk.protocol.e.a(paramContext);
      if (parame == null)
      {
        localObject2 = paramContext.b;
        JSONObject localJSONObject = paramContext.c;
        parame = paramContext.a.a;
        localObject1 = paramContext.b.l;
        if (TextUtils.isEmpty(((com.alipay.sdk.data.a)localObject1).c)) {
          ((com.alipay.sdk.data.a)localObject1).c = parame.c;
        }
        if (TextUtils.isEmpty(((com.alipay.sdk.data.a)localObject1).d)) {
          ((com.alipay.sdk.data.a)localObject1).d = parame.d;
        }
        if (TextUtils.isEmpty(((com.alipay.sdk.data.a)localObject1).b)) {
          ((com.alipay.sdk.data.a)localObject1).b = parame.b;
        }
        if (TextUtils.isEmpty(((com.alipay.sdk.data.a)localObject1).a)) {
          ((com.alipay.sdk.data.a)localObject1).a = parame.a;
        }
        parame = localJSONObject.optJSONObject("reflected_data");
        if (parame != null)
        {
          new StringBuilder("session = ").append(parame.optString("session", "")).toString();
          paramContext.b.i = parame;
        }
        for (;;)
        {
          ((f)localObject2).f = localJSONObject.optString("end_code", "0");
          ((f)localObject2).j = localJSONObject.optString("user_id", "");
          parame = localJSONObject.optString("result");
          try
          {
            localObject1 = URLDecoder.decode(localJSONObject.optString("result"), "UTF-8");
            parame = (com.alipay.sdk.data.e)localObject1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;) {}
          }
          ((f)localObject2).g = parame;
          ((f)localObject2).h = localJSONObject.optString("memo", "");
          return paramContext;
          if (localJSONObject.has("session"))
          {
            parame = new JSONObject();
            try
            {
              parame.put("session", localJSONObject.optString("session"));
              localObject1 = com.alipay.sdk.tid.b.a().a;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                parame.put("tid", localObject1);
              }
              ((f)localObject2).i = parame;
            }
            catch (JSONException parame) {}
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        continue;
        paramContext = parame;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\net\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */