package com.ta.utdid2.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ta.utdid2.b.a.d;
import com.ut.device.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final String TAG = b.class.getName();
  private static b jdField_a_of_type_ComTaUtdid2AB = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_ComTaUtdid2AB == null) {
        jdField_a_of_type_ComTaUtdid2AB = new b(paramContext);
      }
      paramContext = jdField_a_of_type_ComTaUtdid2AB;
      return paramContext;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        Object localObject = new JSONObject(paramString1);
        if (((JSONObject)localObject).has("data"))
        {
          paramString1 = ((JSONObject)localObject).getJSONObject("data");
          if ((paramString1.has("action")) && (paramString1.has("aid")))
          {
            localObject = paramString1.getString("action");
            if ((((String)localObject).equalsIgnoreCase("new")) || (((String)localObject).equalsIgnoreCase("changed"))) {
              return paramString1.getString("aid");
            }
          }
        }
        else if ((((JSONObject)localObject).has("isError")) && (((JSONObject)localObject).has("status")))
        {
          paramString1 = ((JSONObject)localObject).getString("isError");
          localObject = ((JSONObject)localObject).getString("status");
          if ((paramString1.equalsIgnoreCase("true")) && ((((String)localObject).equalsIgnoreCase("404")) || (((String)localObject).equalsIgnoreCase("401"))))
          {
            if (d.e) {
              Log.d(TAG, "remove the AID, status:" + (String)localObject);
            }
            return "";
          }
        }
      }
      catch (JSONException paramString1)
      {
        Log.e(TAG, paramString1.toString());
        return paramString2;
      }
      catch (Exception paramString1)
      {
        Log.e(TAG, paramString1.toString());
      }
    }
    return paramString2;
  }
  
  private static String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return "http://hydra.alibaba.com/" + paramString1 + "/get_aid/" + "?" + "auth[token]=" + paramString2 + "&type=" + "utdid" + "&id=" + paramString3 + "&aid=" + paramString4;
  }
  
  /* Error */
  public String a(String paramString1, String arg2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: aload 4
    //   5: invokestatic 156	com/ta/utdid2/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 34	com/ta/utdid2/a/b:mContext	Landroid/content/Context;
    //   13: invokestatic 161	com/ta/utdid2/b/a/f:b	(Landroid/content/Context;)Z
    //   16: ifeq +134 -> 150
    //   19: sipush 3000
    //   22: istore 5
    //   24: getstatic 98	com/ta/utdid2/b/a/d:e	Z
    //   27: ifeq +39 -> 66
    //   30: getstatic 23	com/ta/utdid2/a/b:TAG	Ljava/lang/String;
    //   33: new 100	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   40: ldc -93
    //   42: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc -91
    //   51: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload 5
    //   56: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 116	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: new 6	com/ta/utdid2/a/b$a
    //   69: dup
    //   70: aload_0
    //   71: new 170	org/apache/http/client/methods/HttpPost
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 171	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   79: invokespecial 174	com/ta/utdid2/a/b$a:<init>	(Lcom/ta/utdid2/a/b;Lorg/apache/http/client/methods/HttpPost;)V
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 177	com/ta/utdid2/a/b$a:start	()V
    //   87: aload_0
    //   88: getfield 32	com/ta/utdid2/a/b:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   91: astore_2
    //   92: aload_2
    //   93: monitorenter
    //   94: aload_0
    //   95: getfield 32	com/ta/utdid2/a/b:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   98: iload 5
    //   100: i2l
    //   101: invokevirtual 181	java/lang/Object:wait	(J)V
    //   104: aload_2
    //   105: monitorexit
    //   106: aload_1
    //   107: invokevirtual 183	com/ta/utdid2/a/b$a:b	()Ljava/lang/String;
    //   110: astore_1
    //   111: getstatic 98	com/ta/utdid2/b/a/d:e	Z
    //   114: ifeq +29 -> 143
    //   117: getstatic 23	com/ta/utdid2/a/b:TAG	Ljava/lang/String;
    //   120: new 100	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   127: ldc -71
    //   129: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 116	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   142: pop
    //   143: aload_1
    //   144: aload 4
    //   146: invokestatic 125	com/ta/utdid2/a/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   149: areturn
    //   150: sipush 1000
    //   153: istore 5
    //   155: goto -131 -> 24
    //   158: astore_3
    //   159: aload_2
    //   160: monitorexit
    //   161: aload_3
    //   162: athrow
    //   163: astore_2
    //   164: getstatic 23	com/ta/utdid2/a/b:TAG	Ljava/lang/String;
    //   167: aload_2
    //   168: invokevirtual 122	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: invokestatic 121	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: goto -69 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	b
    //   0	178	1	paramString1	String
    //   0	178	3	paramString3	String
    //   0	178	4	paramString4	String
    //   22	132	5	i	int
    // Exception table:
    //   from	to	target	type
    //   94	106	158	finally
    //   159	161	158	finally
    //   87	94	163	java/lang/Exception
    //   161	163	163	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    paramString3 = b(paramString1, paramString2, paramString3, paramString4);
    if (d.e) {
      Log.d(TAG, "url:" + paramString3 + "; len:" + paramString3.length());
    }
    new a(new HttpPost(paramString3), parama, paramString4, paramString1, paramString2).start();
  }
  
  class a
    extends Thread
  {
    a jdField_a_of_type_ComUtDeviceA;
    String jdField_a_of_type_JavaLangString = "";
    HttpPost jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost;
    String jdField_b_of_type_JavaLangString;
    String c;
    String d = "";
    
    public a(HttpPost paramHttpPost)
    {
      this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost = paramHttpPost;
    }
    
    public a(HttpPost paramHttpPost, a parama, String paramString1, String paramString2, String paramString3)
    {
      this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost = paramHttpPost;
      this.jdField_a_of_type_ComUtDeviceA = parama;
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.c = paramString2;
      this.d = paramString3;
    }
    
    public String b()
    {
      return this.jdField_a_of_type_JavaLangString;
    }
    
    public void run()
    {
      String str2 = null;
      if (this.jdField_a_of_type_ComUtDeviceA != null) {
        this.jdField_a_of_type_ComUtDeviceA.a(1000, this.jdField_b_of_type_JavaLangString);
      }
      ??? = new DefaultHttpClient();
      try
      {
        ??? = ((HttpClient)???).execute(this.jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost);
        if (??? == null) {}
      }
      catch (Exception localIOException)
      {
        try
        {
          ??? = new BufferedReader(new InputStreamReader(((HttpResponse)???).getEntity().getContent(), Charset.forName("UTF-8")));
          if (??? != null) {
            try
            {
              for (;;)
              {
                str2 = ((BufferedReader)???).readLine();
                if (str2 == null) {
                  break;
                }
                if (d.e) {
                  Log.d(b.a(), str2);
                }
                this.jdField_a_of_type_JavaLangString = str2;
              }
              if (??? == null) {}
            }
            catch (Exception localException5)
            {
              if (this.jdField_a_of_type_ComUtDeviceA != null) {
                this.jdField_a_of_type_ComUtDeviceA.a(1002, this.jdField_b_of_type_JavaLangString);
              }
              Log.e(b.a(), localException5.toString());
            }
          }
        }
        catch (Exception localIOException)
        {
          try
          {
            ((BufferedReader)???).close();
            if (d.e) {
              Log.d(b.a(), "close the bufferreader");
            }
            if (this.jdField_a_of_type_ComUtDeviceA != null) {}
          }
          catch (IOException localIOException)
          {
            synchronized (b.a(b.this))
            {
              for (;;)
              {
                b.a(b.this).notifyAll();
                return;
                localException1 = localException1;
                if (this.jdField_a_of_type_ComUtDeviceA != null) {
                  this.jdField_a_of_type_ComUtDeviceA.a(1002, this.jdField_b_of_type_JavaLangString);
                }
                Log.e(b.a(), localException1.toString());
                Exception localException2 = null;
                continue;
                Log.e(b.a(), "response is null!");
                localException2 = localException5;
                continue;
                localException3 = localException3;
                if (this.jdField_a_of_type_ComUtDeviceA != null) {
                  this.jdField_a_of_type_ComUtDeviceA.a(1002, this.jdField_b_of_type_JavaLangString);
                }
                Log.e(b.a(), localException3.toString());
                Exception localException4 = localException5;
                continue;
                Log.e(b.a(), "BufferredReader is null!");
              }
              localIOException = localIOException;
              Log.e(b.a(), localIOException.toString());
            }
          }
        }
      }
      String str1 = b.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComUtDeviceA.a(1001, str1);
      c.a(b.a(b.this), this.c, str1, this.d);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */