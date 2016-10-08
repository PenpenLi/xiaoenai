package com.alibaba.sdk.android.util;

import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderValueParser;

public class HttpHelper
{
  private static final String TAG = HttpHelper.class.getSimpleName();
  
  private static String decodeResponse(InputStream paramInputStream, String paramString)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return new String(localByteArrayOutputStream.toByteArray(), paramString);
    }
    catch (IOException paramInputStream)
    {
      throw new RuntimeException(paramInputStream);
    }
  }
  
  public static String encodeRequest(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (i != 0) {}
      for (;;)
      {
        try
        {
          localStringBuilder.append("&");
          localStringBuilder.append((String)localEntry.getKey()).append("=").append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
        }
        catch (UnsupportedEncodingException paramMap)
        {
          AliSDKLogger.e(TAG, paramMap.getMessage(), paramMap);
          throw new RuntimeException(paramMap);
        }
        i = 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void filterResponseCode(int paramInt)
  {
    if (paramInt != 200) {
      throw new RuntimeException("http request exception, response code: " + paramInt);
    }
  }
  
  public static InputStream get(String paramString)
  {
    try
    {
      paramString = openConnection(paramString);
      filterResponseCode(paramString.getResponseCode());
      paramString = paramString.getInputStream();
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String get(String paramString, Map<String, String> paramMap)
  {
    return IOUtils.toString(get(paramString + "?" + encodeRequest(paramMap)), "UTF-8");
  }
  
  public static String getCharset(String paramString)
  {
    String str = null;
    Object localObject = BasicHeaderValueParser.parseElements(paramString, null);
    paramString = str;
    if (localObject.length > 0)
    {
      localObject = localObject[0].getParameterByName("charset");
      paramString = str;
      if (localObject != null) {
        paramString = ((NameValuePair)localObject).getValue();
      }
    }
    str = paramString;
    if (paramString == null) {
      str = "UTF-8";
    }
    return str;
  }
  
  public static int getConnectionTimeout(int paramInt)
  {
    String str = AlibabaSDK.getGlobalProperty("httpConnectionTimeout");
    int i = paramInt;
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException) {}
    return paramInt;
  }
  
  public static int getReadTimeout(int paramInt)
  {
    String str = AlibabaSDK.getGlobalProperty("httpReadTimeout");
    int i = paramInt;
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException) {}
    return paramInt;
  }
  
  private static void log(Map<String, String> paramMap, String paramString)
  {
    if (!AliSDKLogger.isDebugEnabled()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request ").append(paramString).append('\n');
    if ((paramMap == null) || (paramMap.size() == 0)) {
      localStringBuilder.append("with no param");
    }
    for (;;)
    {
      AliSDKLogger.d(TAG, localStringBuilder.toString());
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramString = (Map.Entry)paramMap.next();
        localStringBuilder.append((String)paramString.getKey()).append('=').append((String)paramString.getValue()).append('\n');
      }
    }
  }
  
  private static HttpURLConnection openConnection(String paramString)
  {
    try
    {
      paramString = HttpDNSUtils.getHttpURLConnection(paramString, KernelContext.context);
      paramString.setConnectTimeout(getConnectionTimeout(5000));
      paramString.setReadTimeout(getReadTimeout(5000));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  /* Error */
  public static String post(Map<String, String> paramMap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: aload_1
    //   12: invokestatic 246	com/alibaba/sdk/android/util/HttpHelper:log	(Ljava/util/Map;Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokestatic 151	com/alibaba/sdk/android/util/HttpHelper:encodeRequest	(Ljava/util/Map;)Ljava/lang/String;
    //   19: ldc 98
    //   21: invokevirtual 250	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   24: astore 6
    //   26: aload_1
    //   27: invokestatic 134	com/alibaba/sdk/android/util/HttpHelper:openConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   30: astore_0
    //   31: aload_0
    //   32: astore_3
    //   33: aload_3
    //   34: astore_1
    //   35: aload 4
    //   37: astore_0
    //   38: aload 5
    //   40: astore_2
    //   41: aload_3
    //   42: iconst_1
    //   43: invokevirtual 254	java/net/HttpURLConnection:setDoInput	(Z)V
    //   46: aload_3
    //   47: astore_1
    //   48: aload 4
    //   50: astore_0
    //   51: aload 5
    //   53: astore_2
    //   54: aload_3
    //   55: iconst_1
    //   56: invokevirtual 257	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   59: aload_3
    //   60: astore_1
    //   61: aload 4
    //   63: astore_0
    //   64: aload 5
    //   66: astore_2
    //   67: aload_3
    //   68: ldc_w 259
    //   71: invokevirtual 262	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   74: aload_3
    //   75: astore_1
    //   76: aload 4
    //   78: astore_0
    //   79: aload 5
    //   81: astore_2
    //   82: aload_3
    //   83: iconst_0
    //   84: invokevirtual 265	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   87: aload_3
    //   88: astore_1
    //   89: aload 4
    //   91: astore_0
    //   92: aload 5
    //   94: astore_2
    //   95: aload_3
    //   96: ldc_w 267
    //   99: ldc_w 269
    //   102: invokevirtual 272	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_3
    //   106: astore_1
    //   107: aload 4
    //   109: astore_0
    //   110: aload 5
    //   112: astore_2
    //   113: aload_3
    //   114: invokevirtual 276	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   117: astore 4
    //   119: aload_3
    //   120: astore_1
    //   121: aload 4
    //   123: astore_0
    //   124: aload 4
    //   126: astore_2
    //   127: aload 4
    //   129: aload 6
    //   131: invokevirtual 281	java/io/OutputStream:write	([B)V
    //   134: aload_3
    //   135: astore_1
    //   136: aload 4
    //   138: astore_0
    //   139: aload 4
    //   141: astore_2
    //   142: aload 4
    //   144: invokevirtual 284	java/io/OutputStream:flush	()V
    //   147: aload_3
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: aload 4
    //   154: astore_2
    //   155: aload_3
    //   156: invokevirtual 140	java/net/HttpURLConnection:getResponseCode	()I
    //   159: invokestatic 142	com/alibaba/sdk/android/util/HttpHelper:filterResponseCode	(I)V
    //   162: aload_3
    //   163: astore_1
    //   164: aload 4
    //   166: astore_0
    //   167: aload 4
    //   169: astore_2
    //   170: aload_3
    //   171: invokevirtual 146	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   174: aload_3
    //   175: invokevirtual 287	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   178: invokestatic 289	com/alibaba/sdk/android/util/HttpHelper:getCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokestatic 291	com/alibaba/sdk/android/util/HttpHelper:decodeResponse	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   184: astore 5
    //   186: aload 4
    //   188: invokestatic 295	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 298	java/net/HttpURLConnection:disconnect	()V
    //   199: aload 5
    //   201: areturn
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_3
    //   207: astore_0
    //   208: new 39	java/lang/RuntimeException
    //   211: dup
    //   212: aload 4
    //   214: invokespecial 42	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   217: athrow
    //   218: astore_3
    //   219: aload_0
    //   220: astore_2
    //   221: aload_3
    //   222: astore_0
    //   223: aload_2
    //   224: invokestatic 295	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   227: aload_1
    //   228: ifnull +7 -> 235
    //   231: aload_1
    //   232: invokevirtual 298	java/net/HttpURLConnection:disconnect	()V
    //   235: aload_0
    //   236: athrow
    //   237: astore_0
    //   238: aload 5
    //   240: areturn
    //   241: astore_1
    //   242: goto -7 -> 235
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_1
    //   248: goto -25 -> 223
    //   251: astore 4
    //   253: aload_3
    //   254: astore_1
    //   255: aload_2
    //   256: astore_0
    //   257: goto -49 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramMap	Map<String, String>
    //   0	260	1	paramString	String
    //   4	252	2	localObject1	Object
    //   9	198	3	localMap	Map<String, String>
    //   218	36	3	localObject2	Object
    //   1	186	4	localOutputStream	java.io.OutputStream
    //   202	11	4	localThrowable1	Throwable
    //   251	1	4	localThrowable2	Throwable
    //   6	233	5	str	String
    //   24	106	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	31	202	java/lang/Throwable
    //   41	46	218	finally
    //   54	59	218	finally
    //   67	74	218	finally
    //   82	87	218	finally
    //   95	105	218	finally
    //   113	119	218	finally
    //   127	134	218	finally
    //   142	147	218	finally
    //   155	162	218	finally
    //   170	186	218	finally
    //   208	218	218	finally
    //   195	199	237	java/lang/Exception
    //   231	235	241	java/lang/Exception
    //   15	31	245	finally
    //   41	46	251	java/lang/Throwable
    //   54	59	251	java/lang/Throwable
    //   67	74	251	java/lang/Throwable
    //   82	87	251	java/lang/Throwable
    //   95	105	251	java/lang/Throwable
    //   113	119	251	java/lang/Throwable
    //   127	134	251	java/lang/Throwable
    //   142	147	251	java/lang/Throwable
    //   155	162	251	java/lang/Throwable
    //   170	186	251	java/lang/Throwable
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\HttpHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */