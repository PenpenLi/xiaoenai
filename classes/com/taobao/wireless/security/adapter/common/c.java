package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public final class c
{
  private static Context a = null;
  
  public static b a(String paramString)
  {
    Object localObject1 = null;
    if (a.a(new String[] { paramString })) {
      return new b(null, 400);
    }
    new b(null, -1);
    localHttpClient = a();
    try
    {
      Object localObject2 = localHttpClient.execute(new HttpGet(paramString));
      int i;
      if (localObject2 != null)
      {
        i = ((HttpResponse)localObject2).getStatusLine().getStatusCode();
        paramString = (String)localObject1;
        if (i == 200)
        {
          localObject2 = ((HttpResponse)localObject2).getEntity();
          paramString = (String)localObject1;
          if (localObject2 != null) {
            paramString = EntityUtils.toByteArray((HttpEntity)localObject2);
          }
        }
      }
      for (paramString = new b(paramString, i);; paramString = new b(null, 1000)) {
        try
        {
          localHttpClient.getConnectionManager().shutdown();
          return paramString;
        }
        catch (Throwable localThrowable1)
        {
          return paramString;
        }
      }
      try
      {
        localHttpClient.getConnectionManager().shutdown();
        throw paramString;
      }
      catch (Throwable localThrowable3)
      {
        for (;;) {}
      }
    }
    catch (Throwable paramString)
    {
      paramString = paramString;
      paramString = new b(null, 1002);
      try
      {
        localHttpClient.getConnectionManager().shutdown();
        return paramString;
      }
      catch (Throwable localThrowable2)
      {
        return paramString;
      }
    }
    finally {}
  }
  
  /* Error */
  private static b a(String paramString, Map paramMap, HttpEntity paramHttpEntity)
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 16	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: aastore
    //   8: invokestatic 21	com/taobao/wireless/security/adapter/common/a:a	([Ljava/lang/String;)Z
    //   11: ifeq +15 -> 26
    //   14: new 23	com/taobao/wireless/security/adapter/common/b
    //   17: dup
    //   18: aconst_null
    //   19: sipush 400
    //   22: invokespecial 27	com/taobao/wireless/security/adapter/common/b:<init>	([BI)V
    //   25: areturn
    //   26: new 23	com/taobao/wireless/security/adapter/common/b
    //   29: dup
    //   30: aconst_null
    //   31: iconst_m1
    //   32: invokespecial 27	com/taobao/wireless/security/adapter/common/b:<init>	([BI)V
    //   35: pop
    //   36: iconst_0
    //   37: iconst_0
    //   38: invokestatic 76	com/taobao/wireless/security/adapter/common/c:a	(II)Lorg/apache/http/client/HttpClient;
    //   41: astore_3
    //   42: new 78	org/apache/http/client/methods/HttpPost
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 79	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   50: astore_0
    //   51: aload_1
    //   52: ifnull +87 -> 139
    //   55: aload_1
    //   56: invokeinterface 85 1 0
    //   61: invokeinterface 91 1 0
    //   66: astore 4
    //   68: aload 4
    //   70: invokeinterface 97 1 0
    //   75: ifeq +64 -> 139
    //   78: aload 4
    //   80: invokeinterface 101 1 0
    //   85: checkcast 16	java/lang/String
    //   88: astore 5
    //   90: aload_0
    //   91: aload 5
    //   93: aload_1
    //   94: aload 5
    //   96: invokeinterface 105 2 0
    //   101: checkcast 16	java/lang/String
    //   104: invokevirtual 109	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -39 -> 68
    //   110: astore_0
    //   111: new 23	com/taobao/wireless/security/adapter/common/b
    //   114: dup
    //   115: aconst_null
    //   116: sipush 1002
    //   119: invokespecial 27	com/taobao/wireless/security/adapter/common/b:<init>	([BI)V
    //   122: astore_0
    //   123: aload_3
    //   124: invokeinterface 67 1 0
    //   129: invokeinterface 72 1 0
    //   134: aload_0
    //   135: areturn
    //   136: astore_1
    //   137: aload_0
    //   138: areturn
    //   139: aload_0
    //   140: aload_2
    //   141: invokevirtual 113	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   144: aload_3
    //   145: aload_0
    //   146: invokeinterface 41 2 0
    //   151: astore_0
    //   152: aload_0
    //   153: ifnull +67 -> 220
    //   156: aload_0
    //   157: invokeinterface 47 1 0
    //   162: invokeinterface 53 1 0
    //   167: istore 6
    //   169: iload 6
    //   171: sipush 200
    //   174: if_icmpne +79 -> 253
    //   177: aload_0
    //   178: invokeinterface 57 1 0
    //   183: astore_0
    //   184: aload_0
    //   185: ifnull +68 -> 253
    //   188: aload_0
    //   189: invokestatic 63	org/apache/http/util/EntityUtils:toByteArray	(Lorg/apache/http/HttpEntity;)[B
    //   192: astore_0
    //   193: new 23	com/taobao/wireless/security/adapter/common/b
    //   196: dup
    //   197: aload_0
    //   198: iload 6
    //   200: invokespecial 27	com/taobao/wireless/security/adapter/common/b:<init>	([BI)V
    //   203: astore_0
    //   204: aload_3
    //   205: invokeinterface 67 1 0
    //   210: invokeinterface 72 1 0
    //   215: aload_0
    //   216: areturn
    //   217: astore_1
    //   218: aload_0
    //   219: areturn
    //   220: new 23	com/taobao/wireless/security/adapter/common/b
    //   223: dup
    //   224: aconst_null
    //   225: sipush 1000
    //   228: invokespecial 27	com/taobao/wireless/security/adapter/common/b:<init>	([BI)V
    //   231: astore_0
    //   232: goto -28 -> 204
    //   235: astore_0
    //   236: aload_3
    //   237: invokeinterface 67 1 0
    //   242: invokeinterface 72 1 0
    //   247: aload_0
    //   248: athrow
    //   249: astore_1
    //   250: goto -3 -> 247
    //   253: aconst_null
    //   254: astore_0
    //   255: goto -62 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramString	String
    //   0	258	1	paramMap	Map
    //   0	258	2	paramHttpEntity	HttpEntity
    //   41	196	3	localHttpClient	HttpClient
    //   66	13	4	localIterator	java.util.Iterator
    //   88	7	5	str	String
    //   167	32	6	i	int
    // Exception table:
    //   from	to	target	type
    //   42	51	110	java/lang/Throwable
    //   55	68	110	java/lang/Throwable
    //   68	107	110	java/lang/Throwable
    //   139	152	110	java/lang/Throwable
    //   156	169	110	java/lang/Throwable
    //   177	184	110	java/lang/Throwable
    //   188	193	110	java/lang/Throwable
    //   193	204	110	java/lang/Throwable
    //   220	232	110	java/lang/Throwable
    //   123	134	136	java/lang/Throwable
    //   204	215	217	java/lang/Throwable
    //   42	51	235	finally
    //   55	68	235	finally
    //   68	107	235	finally
    //   111	123	235	finally
    //   139	152	235	finally
    //   156	169	235	finally
    //   177	184	235	finally
    //   188	193	235	finally
    //   193	204	235	finally
    //   220	232	235	finally
    //   236	247	249	java/lang/Throwable
  }
  
  public static b a(String paramString, Map paramMap, byte[] paramArrayOfByte)
  {
    b localb = new b(null, -1);
    if (paramArrayOfByte != null) {
      localb = a(paramString, paramMap, new ByteArrayEntity(paramArrayOfByte));
    }
    return localb;
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 10	com/taobao/wireless/security/adapter/common/c:a	Landroid/content/Context;
    //   3: astore_2
    //   4: aload_2
    //   5: ifnull +109 -> 114
    //   8: iconst_1
    //   9: anewarray 16	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: aload_1
    //   15: aastore
    //   16: invokestatic 127	com/taobao/wireless/security/adapter/common/a:b	([Ljava/lang/String;)Z
    //   19: ifeq +95 -> 114
    //   22: invokestatic 30	com/taobao/wireless/security/adapter/common/c:a	()Lorg/apache/http/client/HttpClient;
    //   25: astore_3
    //   26: new 32	org/apache/http/client/methods/HttpGet
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 35	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   34: astore_0
    //   35: aload_3
    //   36: aload_0
    //   37: invokeinterface 41 2 0
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +241 -> 285
    //   47: aload_0
    //   48: invokeinterface 47 1 0
    //   53: invokeinterface 53 1 0
    //   58: sipush 200
    //   61: if_icmpne +224 -> 285
    //   64: aload_0
    //   65: invokeinterface 57 1 0
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +213 -> 285
    //   75: aload_2
    //   76: invokevirtual 133	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 138	java/io/File:exists	()Z
    //   84: ifne +8 -> 92
    //   87: aload_2
    //   88: invokevirtual 141	java/io/File:mkdirs	()Z
    //   91: pop
    //   92: aload_2
    //   93: invokevirtual 138	java/io/File:exists	()Z
    //   96: istore 6
    //   98: iload 6
    //   100: ifne +16 -> 116
    //   103: aload_3
    //   104: invokeinterface 67 1 0
    //   109: invokeinterface 72 1 0
    //   114: aconst_null
    //   115: areturn
    //   116: new 135	java/io/File
    //   119: dup
    //   120: new 143	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   127: aload_2
    //   128: invokevirtual 148	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   131: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: getstatic 156	java/io/File:separator	Ljava/lang/String;
    //   137: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 138	java/io/File:exists	()Z
    //   155: ifeq +8 -> 163
    //   158: aload_1
    //   159: invokevirtual 167	java/io/File:delete	()Z
    //   162: pop
    //   163: aload_1
    //   164: invokevirtual 170	java/io/File:createNewFile	()Z
    //   167: pop
    //   168: aload_0
    //   169: invokeinterface 176 1 0
    //   174: astore_0
    //   175: new 178	java/io/FileOutputStream
    //   178: dup
    //   179: aload_1
    //   180: invokespecial 181	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   183: astore_2
    //   184: sipush 1024
    //   187: newarray <illegal type>
    //   189: astore 4
    //   191: aload_0
    //   192: aload 4
    //   194: invokevirtual 187	java/io/InputStream:read	([B)I
    //   197: istore 5
    //   199: iload 5
    //   201: iconst_m1
    //   202: if_icmpeq +50 -> 252
    //   205: aload_2
    //   206: aload 4
    //   208: iconst_0
    //   209: iload 5
    //   211: invokevirtual 193	java/io/OutputStream:write	([BII)V
    //   214: goto -23 -> 191
    //   217: astore_1
    //   218: aload_2
    //   219: astore_1
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 196	java/io/InputStream:close	()V
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 197	java/io/OutputStream:close	()V
    //   236: aload_3
    //   237: invokeinterface 67 1 0
    //   242: invokeinterface 72 1 0
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: aconst_null
    //   251: areturn
    //   252: aload_1
    //   253: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   256: astore_1
    //   257: aload_0
    //   258: ifnull +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 196	java/io/InputStream:close	()V
    //   265: aload_2
    //   266: invokevirtual 197	java/io/OutputStream:close	()V
    //   269: aload_3
    //   270: invokeinterface 67 1 0
    //   275: invokeinterface 72 1 0
    //   280: aload_1
    //   281: areturn
    //   282: astore_0
    //   283: aload_1
    //   284: areturn
    //   285: aload_3
    //   286: invokeinterface 67 1 0
    //   291: invokeinterface 72 1 0
    //   296: aconst_null
    //   297: areturn
    //   298: astore_0
    //   299: aconst_null
    //   300: areturn
    //   301: astore_1
    //   302: aconst_null
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_2
    //   306: aload_0
    //   307: ifnull +7 -> 314
    //   310: aload_0
    //   311: invokevirtual 196	java/io/InputStream:close	()V
    //   314: aload_2
    //   315: ifnull +7 -> 322
    //   318: aload_2
    //   319: invokevirtual 197	java/io/OutputStream:close	()V
    //   322: aload_3
    //   323: invokeinterface 67 1 0
    //   328: invokeinterface 72 1 0
    //   333: aload_1
    //   334: athrow
    //   335: astore_0
    //   336: goto -71 -> 265
    //   339: astore_0
    //   340: goto -71 -> 269
    //   343: astore_0
    //   344: goto -116 -> 228
    //   347: astore_0
    //   348: goto -112 -> 236
    //   351: astore_0
    //   352: goto -38 -> 314
    //   355: astore_0
    //   356: goto -34 -> 322
    //   359: astore_0
    //   360: goto -27 -> 333
    //   363: astore_1
    //   364: aconst_null
    //   365: astore_2
    //   366: goto -60 -> 306
    //   369: astore_1
    //   370: goto -64 -> 306
    //   373: astore_0
    //   374: aconst_null
    //   375: astore_1
    //   376: aconst_null
    //   377: astore_0
    //   378: goto -158 -> 220
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_1
    //   384: goto -164 -> 220
    //   387: astore_0
    //   388: aconst_null
    //   389: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramString1	String
    //   0	390	1	paramString2	String
    //   3	363	2	localObject	Object
    //   25	298	3	localHttpClient	HttpClient
    //   189	18	4	arrayOfByte	byte[]
    //   197	13	5	i	int
    //   96	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   184	191	217	java/lang/Throwable
    //   191	199	217	java/lang/Throwable
    //   205	214	217	java/lang/Throwable
    //   252	257	217	java/lang/Throwable
    //   236	247	249	java/lang/Throwable
    //   269	280	282	java/lang/Throwable
    //   285	296	298	java/lang/Throwable
    //   35	43	301	finally
    //   47	71	301	finally
    //   75	92	301	finally
    //   92	98	301	finally
    //   116	163	301	finally
    //   163	175	301	finally
    //   261	265	335	java/lang/Exception
    //   265	269	339	java/lang/Exception
    //   224	228	343	java/lang/Exception
    //   232	236	347	java/lang/Exception
    //   310	314	351	java/lang/Exception
    //   318	322	355	java/lang/Exception
    //   322	333	359	java/lang/Throwable
    //   175	184	363	finally
    //   184	191	369	finally
    //   191	199	369	finally
    //   205	214	369	finally
    //   252	257	369	finally
    //   35	43	373	java/lang/Throwable
    //   47	71	373	java/lang/Throwable
    //   75	92	373	java/lang/Throwable
    //   92	98	373	java/lang/Throwable
    //   116	163	373	java/lang/Throwable
    //   163	175	373	java/lang/Throwable
    //   175	184	381	java/lang/Throwable
    //   103	114	387	java/lang/Throwable
  }
  
  public static String a(String paramString, Map paramMap)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    Object localObject = Uri.parse(paramString);
    paramString = ((Uri)localObject).buildUpon();
    localObject = ((Uri)localObject).getPath();
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      paramString.appendPath("");
    }
    paramMap = paramMap.entrySet().toArray();
    int i = 0;
    while (i < paramMap.length)
    {
      paramString = paramString.appendQueryParameter((String)((Map.Entry)paramMap[i]).getKey(), (String)((Map.Entry)paramMap[i]).getValue());
      i += 1;
    }
    return paramString.toString();
  }
  
  private static HttpClient a()
  {
    return a(22000, 22000);
  }
  
  private static HttpClient a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new BasicHttpParams();
      HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset((HttpParams)localObject, "UTF-8");
      int i = paramInt1;
      if (paramInt1 <= 0) {
        i = 22000;
      }
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, i);
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = 22000;
      }
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, paramInt1);
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localObject = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, localSchemeRegistry), (HttpParams)localObject);
      return (HttpClient)localObject;
    }
    catch (Throwable localThrowable) {}
    return new DefaultHttpClient();
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null) {
      a = paramContext.getApplicationContext();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\common\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */