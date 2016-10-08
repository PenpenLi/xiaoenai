package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpManager
{
  private static final String BOUNDARY;
  private static final int BUFFER_SIZE = 8192;
  private static final int CONNECTION_TIMEOUT = 25000;
  private static final String END_MP_BOUNDARY = "--" + BOUNDARY + "--";
  private static final String HTTP_METHOD_GET = "GET";
  private static final String HTTP_METHOD_POST = "POST";
  private static final String MP_BOUNDARY;
  private static final String MULTIPART_FORM_DATA = "multipart/form-data";
  private static final int SOCKET_TIMEOUT = 20000;
  private static final String TAG = "HttpManager";
  private static SSLSocketFactory sSSLSocketFactory;
  
  static
  {
    System.loadLibrary("weibosdkcore");
    BOUNDARY = getBoundry();
    MP_BOUNDARY = "--" + BOUNDARY;
  }
  
  public static void buildParams(OutputStream paramOutputStream, WeiboParameters paramWeiboParameters)
  {
    for (;;)
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      try
      {
        Object localObject1 = paramWeiboParameters.keySet();
        localObject2 = ((Set)localObject1).iterator();
        if (!((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Set)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            paramOutputStream.write(("\r\n" + END_MP_BOUNDARY).getBytes());
          }
        }
        else
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!(paramWeiboParameters.get((String)localObject3) instanceof String)) {
            continue;
          }
          localStringBuilder = new StringBuilder(100);
          localStringBuilder.setLength(0);
          localStringBuilder.append(MP_BOUNDARY).append("\r\n");
          localStringBuilder.append("content-disposition: form-data; name=\"").append((String)localObject3).append("\"\r\n\r\n");
          localStringBuilder.append(paramWeiboParameters.get((String)localObject3)).append("\r\n");
          paramOutputStream.write(localStringBuilder.toString().getBytes());
          continue;
        }
        localObject2 = (String)((Iterator)localObject1).next();
      }
      catch (IOException paramOutputStream)
      {
        throw new WeiboException(paramOutputStream);
      }
      Object localObject3 = paramWeiboParameters.get((String)localObject2);
      if ((localObject3 instanceof Bitmap))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(MP_BOUNDARY).append("\r\n");
        localStringBuilder.append("content-disposition: form-data; name=\"").append((String)localObject2).append("\"; filename=\"file\"\r\n");
        localStringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
        paramOutputStream.write(localStringBuilder.toString().getBytes());
        localObject2 = (Bitmap)localObject3;
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
        paramOutputStream.write(((ByteArrayOutputStream)localObject3).toByteArray());
        paramOutputStream.write("\r\n".getBytes());
      }
      else if ((localObject3 instanceof ByteArrayOutputStream))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(MP_BOUNDARY).append("\r\n");
        localStringBuilder.append("content-disposition: form-data; name=\"").append((String)localObject2).append("\"; filename=\"file\"\r\n");
        localStringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
        paramOutputStream.write(localStringBuilder.toString().getBytes());
        localObject2 = (ByteArrayOutputStream)localObject3;
        paramOutputStream.write(((ByteArrayOutputStream)localObject2).toByteArray());
        paramOutputStream.write("\r\n".getBytes());
        ((ByteArrayOutputStream)localObject2).close();
      }
    }
  }
  
  private static native String calcOauthSignNative(Context paramContext, String paramString1, String paramString2);
  
  /* Error */
  public static String downloadFile(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 160	java/io/File
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 164	java/io/File:exists	()Z
    //   16: ifne +8 -> 24
    //   19: aload_0
    //   20: invokevirtual 167	java/io/File:mkdirs	()Z
    //   23: pop
    //   24: new 160	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: aload_3
    //   30: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 164	java/io/File:exists	()Z
    //   40: ifeq +14 -> 54
    //   43: aload 5
    //   45: invokevirtual 173	java/io/File:getPath	()Ljava/lang/String;
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: areturn
    //   54: aload_1
    //   55: invokestatic 179	android/webkit/URLUtil:isValidUrl	(Ljava/lang/String;)Z
    //   58: ifne +9 -> 67
    //   61: ldc -75
    //   63: astore_0
    //   64: goto -15 -> 49
    //   67: invokestatic 185	com/sina/weibo/sdk/net/HttpManager:getNewHttpClient	()Lorg/apache/http/client/HttpClient;
    //   70: astore 4
    //   72: lconst_0
    //   73: lstore 7
    //   75: new 160	java/io/File
    //   78: dup
    //   79: aload_2
    //   80: new 47	java/lang/StringBuilder
    //   83: dup
    //   84: aload_3
    //   85: invokestatic 189	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: ldc -65
    //   93: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 164	java/io/File:exists	()Z
    //   107: ifeq +290 -> 397
    //   110: aload_2
    //   111: invokevirtual 198	java/io/File:length	()J
    //   114: lstore 7
    //   116: new 200	org/apache/http/client/methods/HttpGet
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 201	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   124: astore_0
    //   125: aload_0
    //   126: ldc -53
    //   128: new 47	java/lang/StringBuilder
    //   131: dup
    //   132: ldc -51
    //   134: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: lload 7
    //   139: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: ldc -46
    //   144: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 213	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 4
    //   155: aload_0
    //   156: invokeinterface 219 2 0
    //   161: astore_0
    //   162: aload_0
    //   163: invokeinterface 225 1 0
    //   168: invokeinterface 231 1 0
    //   173: istore 6
    //   175: iload 6
    //   177: sipush 206
    //   180: if_icmpne +279 -> 459
    //   183: aload_0
    //   184: ldc -23
    //   186: invokeinterface 237 2 0
    //   191: astore_1
    //   192: lload 7
    //   194: lstore 9
    //   196: aload_1
    //   197: ifnull +436 -> 633
    //   200: lload 7
    //   202: lstore 9
    //   204: aload_1
    //   205: arraylength
    //   206: ifeq +427 -> 633
    //   209: aload_1
    //   210: iconst_0
    //   211: aaload
    //   212: invokeinterface 242 1 0
    //   217: astore_1
    //   218: aload_1
    //   219: aload_1
    //   220: bipush 47
    //   222: invokevirtual 246	java/lang/String:indexOf	(I)I
    //   225: iconst_1
    //   226: iadd
    //   227: invokevirtual 250	java/lang/String:substring	(I)Ljava/lang/String;
    //   230: invokestatic 256	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   233: lstore 9
    //   235: aload_0
    //   236: invokeinterface 260 1 0
    //   241: astore_1
    //   242: aload_0
    //   243: ldc_w 262
    //   246: invokeinterface 266 2 0
    //   251: astore_0
    //   252: aload_0
    //   253: ifnull +304 -> 557
    //   256: aload_0
    //   257: invokeinterface 242 1 0
    //   262: invokevirtual 269	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   265: ldc_w 271
    //   268: invokevirtual 274	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   271: iconst_m1
    //   272: if_icmple +285 -> 557
    //   275: new 276	java/util/zip/GZIPInputStream
    //   278: dup
    //   279: aload_1
    //   280: invokeinterface 282 1 0
    //   285: invokespecial 285	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   288: astore_0
    //   289: new 287	java/io/RandomAccessFile
    //   292: dup
    //   293: aload_2
    //   294: ldc_w 289
    //   297: invokespecial 290	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   300: astore_1
    //   301: aload_1
    //   302: lload 7
    //   304: invokevirtual 294	java/io/RandomAccessFile:seek	(J)V
    //   307: sipush 1024
    //   310: newarray <illegal type>
    //   312: astore_3
    //   313: aload_0
    //   314: aload_3
    //   315: invokevirtual 300	java/io/InputStream:read	([B)I
    //   318: istore 6
    //   320: iload 6
    //   322: iconst_m1
    //   323: if_icmpne +244 -> 567
    //   326: aload_1
    //   327: invokevirtual 301	java/io/RandomAccessFile:close	()V
    //   330: aload_0
    //   331: invokevirtual 302	java/io/InputStream:close	()V
    //   334: lload 9
    //   336: lconst_0
    //   337: lcmp
    //   338: ifeq +13 -> 351
    //   341: aload_2
    //   342: invokevirtual 198	java/io/File:length	()J
    //   345: lload 9
    //   347: lcmp
    //   348: ifge +230 -> 578
    //   351: aload_2
    //   352: invokevirtual 305	java/io/File:delete	()Z
    //   355: pop
    //   356: aload 4
    //   358: ifnull +33 -> 391
    //   361: aload 4
    //   363: invokeinterface 309 1 0
    //   368: invokeinterface 314 1 0
    //   373: aload 4
    //   375: invokeinterface 309 1 0
    //   380: ldc2_w 315
    //   383: getstatic 322	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   386: invokeinterface 326 4 0
    //   391: ldc -75
    //   393: astore_0
    //   394: goto -345 -> 49
    //   397: aload_2
    //   398: invokevirtual 329	java/io/File:createNewFile	()Z
    //   401: pop
    //   402: goto -286 -> 116
    //   405: astore_0
    //   406: aload_0
    //   407: invokevirtual 332	java/io/IOException:printStackTrace	()V
    //   410: aload_2
    //   411: invokevirtual 305	java/io/File:delete	()Z
    //   414: pop
    //   415: aload 4
    //   417: ifnull -26 -> 391
    //   420: aload 4
    //   422: invokeinterface 309 1 0
    //   427: invokeinterface 314 1 0
    //   432: aload 4
    //   434: invokeinterface 309 1 0
    //   439: ldc2_w 315
    //   442: getstatic 322	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   445: invokeinterface 326 4 0
    //   450: goto -59 -> 391
    //   453: astore_0
    //   454: ldc 2
    //   456: monitorexit
    //   457: aload_0
    //   458: athrow
    //   459: iload 6
    //   461: sipush 200
    //   464: if_icmpne +41 -> 505
    //   467: lconst_0
    //   468: lstore 9
    //   470: aload_0
    //   471: ldc_w 334
    //   474: invokeinterface 266 2 0
    //   479: astore_1
    //   480: aload_1
    //   481: ifnull +152 -> 633
    //   484: aload_1
    //   485: invokeinterface 242 1 0
    //   490: invokestatic 339	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   493: invokevirtual 342	java/lang/Integer:intValue	()I
    //   496: i2l
    //   497: lstore 9
    //   499: lconst_0
    //   500: lstore 7
    //   502: goto -267 -> 235
    //   505: new 344	com/sina/weibo/sdk/exception/WeiboHttpException
    //   508: dup
    //   509: aload_0
    //   510: invokestatic 348	com/sina/weibo/sdk/net/HttpManager:readRsponse	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   513: iload 6
    //   515: invokespecial 351	com/sina/weibo/sdk/exception/WeiboHttpException:<init>	(Ljava/lang/String;I)V
    //   518: athrow
    //   519: astore_0
    //   520: aload 4
    //   522: ifnull +33 -> 555
    //   525: aload 4
    //   527: invokeinterface 309 1 0
    //   532: invokeinterface 314 1 0
    //   537: aload 4
    //   539: invokeinterface 309 1 0
    //   544: ldc2_w 315
    //   547: getstatic 322	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   550: invokeinterface 326 4 0
    //   555: aload_0
    //   556: athrow
    //   557: aload_1
    //   558: invokeinterface 282 1 0
    //   563: astore_0
    //   564: goto -275 -> 289
    //   567: aload_1
    //   568: aload_3
    //   569: iconst_0
    //   570: iload 6
    //   572: invokevirtual 354	java/io/RandomAccessFile:write	([BII)V
    //   575: goto -262 -> 313
    //   578: aload_2
    //   579: aload 5
    //   581: invokevirtual 358	java/io/File:renameTo	(Ljava/io/File;)Z
    //   584: pop
    //   585: aload 5
    //   587: invokevirtual 173	java/io/File:getPath	()Ljava/lang/String;
    //   590: astore_1
    //   591: aload_1
    //   592: astore_0
    //   593: aload 4
    //   595: ifnull -546 -> 49
    //   598: aload 4
    //   600: invokeinterface 309 1 0
    //   605: invokeinterface 314 1 0
    //   610: aload 4
    //   612: invokeinterface 309 1 0
    //   617: ldc2_w 315
    //   620: getstatic 322	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   623: invokeinterface 326 4 0
    //   628: aload_1
    //   629: astore_0
    //   630: goto -581 -> 49
    //   633: lconst_0
    //   634: lstore 11
    //   636: lload 9
    //   638: lstore 7
    //   640: lload 11
    //   642: lstore 9
    //   644: goto -409 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	paramContext	Context
    //   0	647	1	paramString1	String
    //   0	647	2	paramString2	String
    //   0	647	3	paramString3	String
    //   70	541	4	localHttpClient	HttpClient
    //   33	553	5	localFile	java.io.File
    //   173	398	6	i	int
    //   73	566	7	l1	long
    //   194	449	9	l2	long
    //   634	7	11	l3	long
    // Exception table:
    //   from	to	target	type
    //   103	116	405	java/io/IOException
    //   116	175	405	java/io/IOException
    //   183	192	405	java/io/IOException
    //   204	235	405	java/io/IOException
    //   235	252	405	java/io/IOException
    //   256	289	405	java/io/IOException
    //   289	313	405	java/io/IOException
    //   313	320	405	java/io/IOException
    //   326	334	405	java/io/IOException
    //   341	351	405	java/io/IOException
    //   351	356	405	java/io/IOException
    //   397	402	405	java/io/IOException
    //   470	480	405	java/io/IOException
    //   484	499	405	java/io/IOException
    //   505	519	405	java/io/IOException
    //   557	564	405	java/io/IOException
    //   567	575	405	java/io/IOException
    //   578	591	405	java/io/IOException
    //   3	24	453	finally
    //   24	49	453	finally
    //   54	61	453	finally
    //   67	72	453	finally
    //   75	103	453	finally
    //   361	391	453	finally
    //   420	450	453	finally
    //   525	555	453	finally
    //   555	557	453	finally
    //   598	628	453	finally
    //   103	116	519	finally
    //   116	175	519	finally
    //   183	192	519	finally
    //   204	235	519	finally
    //   235	252	519	finally
    //   256	289	519	finally
    //   289	313	519	finally
    //   313	320	519	finally
    //   326	334	519	finally
    //   341	351	519	finally
    //   351	356	519	finally
    //   397	402	519	finally
    //   406	415	519	finally
    //   470	480	519	finally
    //   484	499	519	finally
    //   505	519	519	finally
    //   557	564	519	finally
    //   567	575	519	finally
    //   578	591	519	finally
  }
  
  public static String getBoundry()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    if (i >= 12) {
      return localStringBuffer.toString();
    }
    long l = System.currentTimeMillis() + i;
    if (l % 3L == 0L) {
      localStringBuffer.append((char)(int)l % '\t');
    }
    for (;;)
    {
      i += 1;
      break;
      if (l % 3L == 1L) {
        localStringBuffer.append((char)(int)(l % 26L + 65L));
      } else {
        localStringBuffer.append((char)(int)(l % 26L + 97L));
      }
    }
  }
  
  private static Certificate getCertificate(String paramString)
  {
    Object localObject1 = CertificateFactory.getInstance("X.509");
    paramString = HttpManager.class.getResourceAsStream(paramString);
    try
    {
      localObject1 = ((CertificateFactory)localObject1).generateCertificate(paramString);
      return (Certificate)localObject1;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
  }
  
  public static HttpClient getNewHttpClient()
  {
    try
    {
      Object localObject1 = new BasicHttpParams();
      HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset((HttpParams)localObject1, "UTF-8");
      Object localObject2 = new SchemeRegistry();
      ((SchemeRegistry)localObject2).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      ((SchemeRegistry)localObject2).register(new Scheme("https", getSSLSocketFactory(), 443));
      localObject2 = new ThreadSafeClientConnManager((HttpParams)localObject1, (SchemeRegistry)localObject2);
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, 25000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject1, 20000);
      localObject1 = new DefaultHttpClient((ClientConnectionManager)localObject2, (HttpParams)localObject1);
      return (HttpClient)localObject1;
    }
    catch (Exception localException) {}
    return new DefaultHttpClient();
  }
  
  private static String getOauthSign(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append(paramString3);
    }
    return calcOauthSignNative(paramContext, localStringBuilder.toString(), paramString4);
  }
  
  private static SSLSocketFactory getSSLSocketFactory()
  {
    if (sSSLSocketFactory == null) {}
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore.load(null, null);
      Certificate localCertificate1 = getCertificate("cacert_cn.cer");
      Certificate localCertificate2 = getCertificate("cacert_com.cer");
      localKeyStore.setCertificateEntry("cnca", localCertificate1);
      localKeyStore.setCertificateEntry("comca", localCertificate2);
      sSSLSocketFactory = new SSLSocketFactoryEx(localKeyStore);
      LogUtil.d("HttpManager", "getSSLSocketFactory noraml !!!!!");
      return sSSLSocketFactory;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        sSSLSocketFactory = SSLSocketFactory.getSocketFactory();
        LogUtil.d("HttpManager", "getSSLSocketFactory error default !!!!!");
      }
    }
  }
  
  private static String getTimestamp()
  {
    return String.valueOf(System.currentTimeMillis() / 1000L);
  }
  
  /* Error */
  public static String openRedirectUrl4LocationUri(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 5
    //   11: astore 4
    //   13: new 535	com/sina/weibo/sdk/net/HttpManager$2
    //   16: dup
    //   17: invokespecial 536	com/sina/weibo/sdk/net/HttpManager$2:<init>	()V
    //   20: astore 8
    //   22: aload 5
    //   24: astore 4
    //   26: invokestatic 185	com/sina/weibo/sdk/net/HttpManager:getNewHttpClient	()Lorg/apache/http/client/HttpClient;
    //   29: checkcast 464	org/apache/http/impl/client/DefaultHttpClient
    //   32: astore 5
    //   34: aload 5
    //   36: aload 8
    //   38: invokevirtual 540	org/apache/http/impl/client/DefaultHttpClient:setRedirectHandler	(Lorg/apache/http/client/RedirectHandler;)V
    //   41: aload_0
    //   42: aload_3
    //   43: invokestatic 544	com/sina/weibo/sdk/net/HttpManager:setHttpCommonParam	(Landroid/content/Context;Lcom/sina/weibo/sdk/net/WeiboParameters;)V
    //   46: aload 5
    //   48: invokevirtual 548	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   51: ldc_w 550
    //   54: invokestatic 556	com/sina/weibo/sdk/net/NetStateManager:getAPN	()Lorg/apache/http/HttpHost;
    //   57: invokeinterface 562 3 0
    //   62: pop
    //   63: aload_2
    //   64: ldc 15
    //   66: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +71 -> 140
    //   72: new 200	org/apache/http/client/methods/HttpGet
    //   75: dup
    //   76: new 47	java/lang/StringBuilder
    //   79: dup
    //   80: aload_1
    //   81: invokestatic 189	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   84: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: ldc_w 568
    //   90: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 571	com/sina/weibo/sdk/net/WeiboParameters:encodeUrl	()Ljava/lang/String;
    //   97: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 201	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   106: astore_3
    //   107: aload_3
    //   108: ldc_w 573
    //   111: aload_0
    //   112: invokestatic 579	com/sina/weibo/sdk/utils/NetworkHelper:generateUA	(Landroid/content/Context;)Ljava/lang/String;
    //   115: invokeinterface 582 3 0
    //   120: aload 5
    //   122: aload_3
    //   123: invokevirtual 583	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   126: pop
    //   127: aload 8
    //   129: invokevirtual 588	com/sina/weibo/sdk/net/CustomRedirectHandler:getRedirectUrl	()Ljava/lang/String;
    //   132: astore_0
    //   133: aload 5
    //   135: invokestatic 592	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   138: aload_0
    //   139: areturn
    //   140: aload 7
    //   142: astore_3
    //   143: aload_2
    //   144: ldc 18
    //   146: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq -42 -> 107
    //   152: new 594	org/apache/http/client/methods/HttpPost
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 595	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   160: astore_3
    //   161: goto -54 -> 107
    //   164: astore_0
    //   165: aload 5
    //   167: astore 4
    //   169: new 125	com/sina/weibo/sdk/exception/WeiboException
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 128	com/sina/weibo/sdk/exception/WeiboException:<init>	(Ljava/lang/Throwable;)V
    //   177: athrow
    //   178: astore_0
    //   179: aload 4
    //   181: invokestatic 592	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   184: aload_0
    //   185: athrow
    //   186: astore_0
    //   187: aload 5
    //   189: astore 4
    //   191: goto -12 -> 179
    //   194: astore_0
    //   195: aload 6
    //   197: astore 4
    //   199: goto -30 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramContext	Context
    //   0	202	1	paramString1	String
    //   0	202	2	paramString2	String
    //   0	202	3	paramWeiboParameters	WeiboParameters
    //   11	187	4	localObject1	Object
    //   4	184	5	localDefaultHttpClient	DefaultHttpClient
    //   1	195	6	localObject2	Object
    //   7	134	7	localObject3	Object
    //   20	108	8	local2	HttpManager.2
    // Exception table:
    //   from	to	target	type
    //   34	107	164	java/io/IOException
    //   107	133	164	java/io/IOException
    //   143	161	164	java/io/IOException
    //   13	22	178	finally
    //   26	34	178	finally
    //   169	178	178	finally
    //   34	107	186	finally
    //   107	133	186	finally
    //   143	161	186	finally
    //   13	22	194	java/io/IOException
    //   26	34	194	java/io/IOException
  }
  
  public static String openUrl(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters)
  {
    paramContext = readRsponse(requestHttpExecute(paramContext, paramString1, paramString2, paramWeiboParameters));
    LogUtil.d("HttpManager", "Response : " + paramContext);
    return paramContext;
  }
  
  /* Error */
  public static String openUrl4RdirectURL(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: invokestatic 185	com/sina/weibo/sdk/net/HttpManager:getNewHttpClient	()Lorg/apache/http/client/HttpClient;
    //   12: checkcast 464	org/apache/http/impl/client/DefaultHttpClient
    //   15: astore 5
    //   17: aload 5
    //   19: new 605	com/sina/weibo/sdk/net/HttpManager$1
    //   22: dup
    //   23: invokespecial 606	com/sina/weibo/sdk/net/HttpManager$1:<init>	()V
    //   26: invokevirtual 540	org/apache/http/impl/client/DefaultHttpClient:setRedirectHandler	(Lorg/apache/http/client/RedirectHandler;)V
    //   29: aload_0
    //   30: aload_3
    //   31: invokestatic 544	com/sina/weibo/sdk/net/HttpManager:setHttpCommonParam	(Landroid/content/Context;Lcom/sina/weibo/sdk/net/WeiboParameters;)V
    //   34: aload 5
    //   36: invokevirtual 548	org/apache/http/impl/client/DefaultHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   39: ldc_w 550
    //   42: invokestatic 556	com/sina/weibo/sdk/net/NetStateManager:getAPN	()Lorg/apache/http/HttpHost;
    //   45: invokeinterface 562 3 0
    //   50: pop
    //   51: aload_2
    //   52: ldc 15
    //   54: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +142 -> 199
    //   60: new 47	java/lang/StringBuilder
    //   63: dup
    //   64: aload_1
    //   65: invokestatic 189	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: ldc_w 568
    //   74: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 571	com/sina/weibo/sdk/net/WeiboParameters:encodeUrl	()Ljava/lang/String;
    //   81: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_0
    //   88: ldc 27
    //   90: new 47	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 608
    //   97: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 518	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: new 200	org/apache/http/client/methods/HttpGet
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 201	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   118: astore_0
    //   119: aload 5
    //   121: aload_0
    //   122: invokevirtual 583	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   125: astore_0
    //   126: aload_0
    //   127: invokeinterface 225 1 0
    //   132: invokeinterface 231 1 0
    //   137: istore 8
    //   139: iload 8
    //   141: sipush 301
    //   144: if_icmpeq +11 -> 155
    //   147: iload 8
    //   149: sipush 302
    //   152: if_icmpne +115 -> 267
    //   155: aload_0
    //   156: ldc_w 610
    //   159: invokeinterface 266 2 0
    //   164: invokeinterface 242 1 0
    //   169: astore_0
    //   170: ldc 27
    //   172: new 47	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 612
    //   179: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_0
    //   183: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 518	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload 5
    //   194: invokestatic 592	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   197: aload_0
    //   198: areturn
    //   199: aload 7
    //   201: astore_0
    //   202: aload_2
    //   203: ldc 18
    //   205: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: ifeq -89 -> 119
    //   211: new 594	org/apache/http/client/methods/HttpPost
    //   214: dup
    //   215: aload_1
    //   216: invokespecial 595	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   219: astore_0
    //   220: ldc 27
    //   222: new 47	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 614
    //   229: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload_1
    //   233: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 518	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -123 -> 119
    //   245: astore_0
    //   246: aload 5
    //   248: astore 4
    //   250: new 125	com/sina/weibo/sdk/exception/WeiboException
    //   253: dup
    //   254: aload_0
    //   255: invokespecial 128	com/sina/weibo/sdk/exception/WeiboException:<init>	(Ljava/lang/Throwable;)V
    //   258: athrow
    //   259: astore_0
    //   260: aload 4
    //   262: invokestatic 592	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   265: aload_0
    //   266: athrow
    //   267: iload 8
    //   269: sipush 200
    //   272: if_icmpne +15 -> 287
    //   275: aload_0
    //   276: invokestatic 348	com/sina/weibo/sdk/net/HttpManager:readRsponse	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   279: astore_0
    //   280: aload 5
    //   282: invokestatic 592	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   285: aload_0
    //   286: areturn
    //   287: new 344	com/sina/weibo/sdk/exception/WeiboHttpException
    //   290: dup
    //   291: aload_0
    //   292: invokestatic 348	com/sina/weibo/sdk/net/HttpManager:readRsponse	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   295: iload 8
    //   297: invokespecial 351	com/sina/weibo/sdk/exception/WeiboHttpException:<init>	(Ljava/lang/String;I)V
    //   300: athrow
    //   301: astore_0
    //   302: aload 5
    //   304: astore 4
    //   306: goto -46 -> 260
    //   309: astore_0
    //   310: aload 6
    //   312: astore 4
    //   314: goto -64 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramContext	Context
    //   0	317	1	paramString1	String
    //   0	317	2	paramString2	String
    //   0	317	3	paramWeiboParameters	WeiboParameters
    //   4	309	4	localObject1	Object
    //   15	288	5	localDefaultHttpClient	DefaultHttpClient
    //   1	310	6	localObject2	Object
    //   7	193	7	localObject3	Object
    //   137	159	8	i	int
    // Exception table:
    //   from	to	target	type
    //   17	119	245	java/io/IOException
    //   119	139	245	java/io/IOException
    //   155	192	245	java/io/IOException
    //   202	242	245	java/io/IOException
    //   275	280	245	java/io/IOException
    //   287	301	245	java/io/IOException
    //   9	17	259	finally
    //   250	259	259	finally
    //   17	119	301	finally
    //   119	139	301	finally
    //   155	192	301	finally
    //   202	242	301	finally
    //   275	280	301	finally
    //   287	301	301	finally
    //   9	17	309	java/io/IOException
  }
  
  /* Error */
  public static String readRsponse(org.apache.http.HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_1
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: aload_0
    //   11: invokeinterface 260 1 0
    //   16: astore_1
    //   17: new 137	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 138	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore 4
    //   26: aload_1
    //   27: invokeinterface 282 1 0
    //   32: astore_2
    //   33: aload_2
    //   34: astore_3
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: ldc_w 262
    //   41: invokeinterface 266 2 0
    //   46: astore 5
    //   48: aload_2
    //   49: astore_0
    //   50: aload 5
    //   52: ifnull +42 -> 94
    //   55: aload_2
    //   56: astore_0
    //   57: aload_2
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: aload 5
    //   63: invokeinterface 242 1 0
    //   68: invokevirtual 269	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   71: ldc_w 271
    //   74: invokevirtual 274	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   77: iconst_m1
    //   78: if_icmple +16 -> 94
    //   81: aload_2
    //   82: astore_3
    //   83: aload_2
    //   84: astore_1
    //   85: new 276	java/util/zip/GZIPInputStream
    //   88: dup
    //   89: aload_2
    //   90: invokespecial 285	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore_0
    //   94: aload_0
    //   95: astore_3
    //   96: aload_0
    //   97: astore_1
    //   98: sipush 8192
    //   101: newarray <illegal type>
    //   103: astore_2
    //   104: aload_0
    //   105: astore_3
    //   106: aload_0
    //   107: astore_1
    //   108: aload_0
    //   109: aload_2
    //   110: invokevirtual 300	java/io/InputStream:read	([B)I
    //   113: istore 6
    //   115: iload 6
    //   117: iconst_m1
    //   118: if_icmpne +78 -> 196
    //   121: aload_0
    //   122: astore_3
    //   123: aload_0
    //   124: astore_1
    //   125: new 92	java/lang/String
    //   128: dup
    //   129: aload 4
    //   131: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   134: ldc_w 418
    //   137: invokespecial 617	java/lang/String:<init>	([BLjava/lang/String;)V
    //   140: astore_2
    //   141: aload_0
    //   142: astore_3
    //   143: aload_0
    //   144: astore_1
    //   145: ldc 27
    //   147: new 47	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 619
    //   154: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_2
    //   158: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 518	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 302	java/io/InputStream:close	()V
    //   175: aload_2
    //   176: astore_0
    //   177: aload 4
    //   179: ifnull -171 -> 8
    //   182: aload 4
    //   184: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   187: aload_2
    //   188: areturn
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 332	java/io/IOException:printStackTrace	()V
    //   194: aload_2
    //   195: areturn
    //   196: aload_0
    //   197: astore_3
    //   198: aload_0
    //   199: astore_1
    //   200: aload 4
    //   202: aload_2
    //   203: iconst_0
    //   204: iload 6
    //   206: invokevirtual 620	java/io/ByteArrayOutputStream:write	([BII)V
    //   209: goto -105 -> 104
    //   212: astore_0
    //   213: aload_3
    //   214: astore_1
    //   215: new 125	com/sina/weibo/sdk/exception/WeiboException
    //   218: dup
    //   219: aload_0
    //   220: invokespecial 128	com/sina/weibo/sdk/exception/WeiboException:<init>	(Ljava/lang/Throwable;)V
    //   223: athrow
    //   224: astore_0
    //   225: aload_1
    //   226: ifnull +7 -> 233
    //   229: aload_1
    //   230: invokevirtual 302	java/io/InputStream:close	()V
    //   233: aload 4
    //   235: ifnull +8 -> 243
    //   238: aload 4
    //   240: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   243: aload_0
    //   244: athrow
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 332	java/io/IOException:printStackTrace	()V
    //   250: goto -75 -> 175
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual 332	java/io/IOException:printStackTrace	()V
    //   258: goto -25 -> 233
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 332	java/io/IOException:printStackTrace	()V
    //   266: goto -23 -> 243
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_1
    //   272: goto -47 -> 225
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_1
    //   278: goto -63 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramHttpResponse	org.apache.http.HttpResponse
    //   1	229	1	localObject1	Object
    //   253	2	1	localIOException1	IOException
    //   261	2	1	localIOException2	IOException
    //   271	7	1	localObject2	Object
    //   32	171	2	localObject3	Object
    //   34	180	3	localObject4	Object
    //   24	215	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   46	16	5	localHeader	org.apache.http.Header
    //   113	92	6	i	int
    // Exception table:
    //   from	to	target	type
    //   182	187	189	java/io/IOException
    //   37	48	212	java/io/IOException
    //   61	81	212	java/io/IOException
    //   85	94	212	java/io/IOException
    //   98	104	212	java/io/IOException
    //   108	115	212	java/io/IOException
    //   125	141	212	java/io/IOException
    //   145	167	212	java/io/IOException
    //   200	209	212	java/io/IOException
    //   37	48	224	finally
    //   61	81	224	finally
    //   85	94	224	finally
    //   98	104	224	finally
    //   108	115	224	finally
    //   125	141	224	finally
    //   145	167	224	finally
    //   200	209	224	finally
    //   215	224	224	finally
    //   171	175	245	java/io/IOException
    //   229	233	253	java/io/IOException
    //   238	243	261	java/io/IOException
    //   26	33	269	finally
    //   26	33	275	java/io/IOException
  }
  
  /* Error */
  private static org.apache.http.HttpResponse requestHttpExecute(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 7
    //   15: invokestatic 185	com/sina/weibo/sdk/net/HttpManager:getNewHttpClient	()Lorg/apache/http/client/HttpClient;
    //   18: astore 6
    //   20: aload 6
    //   22: astore 4
    //   24: aload 8
    //   26: astore 5
    //   28: aload 9
    //   30: astore 6
    //   32: aload 4
    //   34: invokeinterface 621 1 0
    //   39: ldc_w 550
    //   42: invokestatic 556	com/sina/weibo/sdk/net/NetStateManager:getAPN	()Lorg/apache/http/HttpHost;
    //   45: invokeinterface 562 3 0
    //   50: pop
    //   51: aload 8
    //   53: astore 5
    //   55: aload 9
    //   57: astore 6
    //   59: aload_0
    //   60: aload_3
    //   61: invokestatic 544	com/sina/weibo/sdk/net/HttpManager:setHttpCommonParam	(Landroid/content/Context;Lcom/sina/weibo/sdk/net/WeiboParameters;)V
    //   64: aload 8
    //   66: astore 5
    //   68: aload 9
    //   70: astore 6
    //   72: aload_2
    //   73: ldc 15
    //   75: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +194 -> 272
    //   81: aload 8
    //   83: astore 5
    //   85: aload 9
    //   87: astore 6
    //   89: new 47	java/lang/StringBuilder
    //   92: dup
    //   93: aload_1
    //   94: invokestatic 189	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: ldc_w 568
    //   103: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_3
    //   107: invokevirtual 571	com/sina/weibo/sdk/net/WeiboParameters:encodeUrl	()Ljava/lang/String;
    //   110: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_1
    //   117: aload 8
    //   119: astore 5
    //   121: aload 9
    //   123: astore 6
    //   125: new 200	org/apache/http/client/methods/HttpGet
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 201	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   133: astore_0
    //   134: aload 8
    //   136: astore 5
    //   138: aload 9
    //   140: astore 6
    //   142: ldc 27
    //   144: new 47	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 623
    //   151: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload_1
    //   155: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 518	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 7
    //   166: astore_1
    //   167: aload_1
    //   168: astore 5
    //   170: aload_1
    //   171: astore 6
    //   173: aload 4
    //   175: aload_0
    //   176: invokeinterface 219 2 0
    //   181: astore_0
    //   182: aload_1
    //   183: astore 5
    //   185: aload_1
    //   186: astore 6
    //   188: aload_0
    //   189: invokeinterface 225 1 0
    //   194: invokeinterface 231 1 0
    //   199: istore 10
    //   201: iload 10
    //   203: sipush 200
    //   206: if_icmpeq +355 -> 561
    //   209: aload_1
    //   210: astore 5
    //   212: aload_1
    //   213: astore 6
    //   215: new 344	com/sina/weibo/sdk/exception/WeiboHttpException
    //   218: dup
    //   219: aload_0
    //   220: invokestatic 348	com/sina/weibo/sdk/net/HttpManager:readRsponse	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   223: iload 10
    //   225: invokespecial 351	com/sina/weibo/sdk/exception/WeiboHttpException:<init>	(Ljava/lang/String;I)V
    //   228: athrow
    //   229: astore_2
    //   230: aload 4
    //   232: astore_1
    //   233: aload 5
    //   235: astore_0
    //   236: aload_2
    //   237: invokevirtual 332	java/io/IOException:printStackTrace	()V
    //   240: new 125	com/sina/weibo/sdk/exception/WeiboException
    //   243: dup
    //   244: aload_2
    //   245: invokespecial 128	com/sina/weibo/sdk/exception/WeiboException:<init>	(Ljava/lang/Throwable;)V
    //   248: athrow
    //   249: astore_2
    //   250: aload_1
    //   251: astore 4
    //   253: aload_0
    //   254: astore_1
    //   255: aload_2
    //   256: astore_0
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   265: aload 4
    //   267: invokestatic 592	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   270: aload_0
    //   271: athrow
    //   272: aload 8
    //   274: astore 5
    //   276: aload 9
    //   278: astore 6
    //   280: aload_2
    //   281: ldc 18
    //   283: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +227 -> 513
    //   289: aload 8
    //   291: astore 5
    //   293: aload 9
    //   295: astore 6
    //   297: ldc 27
    //   299: new 47	java/lang/StringBuilder
    //   302: dup
    //   303: ldc_w 625
    //   306: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: aload_1
    //   310: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 518	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload 8
    //   321: astore 5
    //   323: aload 9
    //   325: astore 6
    //   327: new 594	org/apache/http/client/methods/HttpPost
    //   330: dup
    //   331: aload_1
    //   332: invokespecial 595	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   335: astore_1
    //   336: aload 8
    //   338: astore 5
    //   340: aload 9
    //   342: astore 6
    //   344: new 137	java/io/ByteArrayOutputStream
    //   347: dup
    //   348: invokespecial 138	java/io/ByteArrayOutputStream:<init>	()V
    //   351: astore_0
    //   352: aload_3
    //   353: invokevirtual 628	com/sina/weibo/sdk/net/WeiboParameters:hasBinaryData	()Z
    //   356: ifeq +58 -> 414
    //   359: aload_1
    //   360: ldc_w 630
    //   363: new 47	java/lang/StringBuilder
    //   366: dup
    //   367: ldc_w 632
    //   370: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   373: getstatic 45	com/sina/weibo/sdk/net/HttpManager:BOUNDARY	Ljava/lang/String;
    //   376: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokevirtual 633	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_0
    //   386: aload_3
    //   387: invokestatic 635	com/sina/weibo/sdk/net/HttpManager:buildParams	(Ljava/io/OutputStream;Lcom/sina/weibo/sdk/net/WeiboParameters;)V
    //   390: aload_1
    //   391: new 637	org/apache/http/entity/ByteArrayEntity
    //   394: dup
    //   395: aload_0
    //   396: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   399: invokespecial 639	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   402: invokevirtual 643	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   405: aload_0
    //   406: astore_2
    //   407: aload_1
    //   408: astore_0
    //   409: aload_2
    //   410: astore_1
    //   411: goto -244 -> 167
    //   414: aload_3
    //   415: ldc_w 645
    //   418: invokevirtual 110	com/sina/weibo/sdk/net/WeiboParameters:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   421: astore_2
    //   422: aload_2
    //   423: ifnull +69 -> 492
    //   426: aload_2
    //   427: instanceof 92
    //   430: ifeq +62 -> 492
    //   433: aload_3
    //   434: ldc_w 645
    //   437: invokevirtual 648	com/sina/weibo/sdk/net/WeiboParameters:remove	(Ljava/lang/String;)V
    //   440: aload_1
    //   441: ldc_w 630
    //   444: aload_2
    //   445: checkcast 92	java/lang/String
    //   448: invokevirtual 633	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload_3
    //   452: invokevirtual 571	com/sina/weibo/sdk/net/WeiboParameters:encodeUrl	()Ljava/lang/String;
    //   455: astore_2
    //   456: ldc 27
    //   458: new 47	java/lang/StringBuilder
    //   461: dup
    //   462: ldc_w 650
    //   465: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   468: aload_2
    //   469: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 518	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload_0
    //   479: aload_2
    //   480: ldc_w 418
    //   483: invokevirtual 653	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   486: invokevirtual 654	java/io/ByteArrayOutputStream:write	([B)V
    //   489: goto -99 -> 390
    //   492: aload_1
    //   493: ldc_w 630
    //   496: ldc_w 656
    //   499: invokevirtual 633	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -51 -> 451
    //   505: astore_2
    //   506: aload_0
    //   507: astore_1
    //   508: aload_2
    //   509: astore_0
    //   510: goto -253 -> 257
    //   513: aload 8
    //   515: astore 5
    //   517: aload 9
    //   519: astore 6
    //   521: aload_2
    //   522: ldc_w 658
    //   525: invokevirtual 566	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   528: ifeq +75 -> 603
    //   531: aload 8
    //   533: astore 5
    //   535: aload 9
    //   537: astore 6
    //   539: new 660	org/apache/http/client/methods/HttpDelete
    //   542: dup
    //   543: aload_1
    //   544: invokespecial 661	org/apache/http/client/methods/HttpDelete:<init>	(Ljava/lang/String;)V
    //   547: astore_0
    //   548: aload 7
    //   550: astore_1
    //   551: goto -384 -> 167
    //   554: astore_0
    //   555: aload 6
    //   557: astore_1
    //   558: goto -301 -> 257
    //   561: aload_1
    //   562: ifnull +7 -> 569
    //   565: aload_1
    //   566: invokevirtual 154	java/io/ByteArrayOutputStream:close	()V
    //   569: aload 4
    //   571: invokestatic 592	com/sina/weibo/sdk/net/HttpManager:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   574: aload_0
    //   575: areturn
    //   576: astore_1
    //   577: goto -312 -> 265
    //   580: astore_1
    //   581: goto -12 -> 569
    //   584: astore_0
    //   585: aconst_null
    //   586: astore 4
    //   588: aload 5
    //   590: astore_1
    //   591: goto -334 -> 257
    //   594: astore_2
    //   595: aconst_null
    //   596: astore_1
    //   597: aload 4
    //   599: astore_0
    //   600: goto -364 -> 236
    //   603: aconst_null
    //   604: astore_0
    //   605: aload 7
    //   607: astore_1
    //   608: goto -441 -> 167
    //   611: astore_2
    //   612: aload 4
    //   614: astore_1
    //   615: goto -379 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	paramContext	Context
    //   0	618	1	paramString1	String
    //   0	618	2	paramString2	String
    //   0	618	3	paramWeiboParameters	WeiboParameters
    //   4	609	4	localObject1	Object
    //   7	582	5	localObject2	Object
    //   18	538	6	localObject3	Object
    //   13	593	7	localObject4	Object
    //   1	531	8	localObject5	Object
    //   10	526	9	localObject6	Object
    //   199	25	10	i	int
    // Exception table:
    //   from	to	target	type
    //   32	51	229	java/io/IOException
    //   59	64	229	java/io/IOException
    //   72	81	229	java/io/IOException
    //   89	117	229	java/io/IOException
    //   125	134	229	java/io/IOException
    //   142	164	229	java/io/IOException
    //   173	182	229	java/io/IOException
    //   188	201	229	java/io/IOException
    //   215	229	229	java/io/IOException
    //   280	289	229	java/io/IOException
    //   297	319	229	java/io/IOException
    //   327	336	229	java/io/IOException
    //   344	352	229	java/io/IOException
    //   521	531	229	java/io/IOException
    //   539	548	229	java/io/IOException
    //   236	249	249	finally
    //   352	390	505	finally
    //   390	405	505	finally
    //   414	422	505	finally
    //   426	451	505	finally
    //   451	489	505	finally
    //   492	502	505	finally
    //   32	51	554	finally
    //   59	64	554	finally
    //   72	81	554	finally
    //   89	117	554	finally
    //   125	134	554	finally
    //   142	164	554	finally
    //   173	182	554	finally
    //   188	201	554	finally
    //   215	229	554	finally
    //   280	289	554	finally
    //   297	319	554	finally
    //   327	336	554	finally
    //   344	352	554	finally
    //   521	531	554	finally
    //   539	548	554	finally
    //   261	265	576	java/io/IOException
    //   565	569	580	java/io/IOException
    //   15	20	584	finally
    //   15	20	594	java/io/IOException
    //   352	390	611	java/io/IOException
    //   390	405	611	java/io/IOException
    //   414	422	611	java/io/IOException
    //   426	451	611	java/io/IOException
    //   451	489	611	java/io/IOException
    //   492	502	611	java/io/IOException
  }
  
  private static void setHttpCommonParam(Context paramContext, WeiboParameters paramWeiboParameters)
  {
    Object localObject2 = "";
    if (!TextUtils.isEmpty(paramWeiboParameters.getAppKey()))
    {
      localObject1 = Utility.getAid(paramContext, paramWeiboParameters.getAppKey());
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramWeiboParameters.put("aid", (String)localObject1);
        localObject2 = localObject1;
      }
    }
    String str = getTimestamp();
    paramWeiboParameters.put("oauth_timestamp", str);
    Object localObject1 = paramWeiboParameters.get("access_token");
    Object localObject3 = paramWeiboParameters.get("refresh_token");
    Object localObject4 = paramWeiboParameters.get("phone");
    if ((localObject1 != null) && ((localObject1 instanceof String))) {
      localObject1 = (String)localObject1;
    }
    for (;;)
    {
      paramWeiboParameters.put("oauth_sign", getOauthSign(paramContext, (String)localObject2, (String)localObject1, paramWeiboParameters.getAppKey(), str));
      return;
      if ((localObject3 != null) && ((localObject3 instanceof String))) {
        localObject1 = (String)localObject3;
      } else if ((localObject4 != null) && ((localObject4 instanceof String))) {
        localObject1 = (String)localObject4;
      } else {
        localObject1 = "";
      }
    }
  }
  
  public static void shutdownHttpClient(HttpClient paramHttpClient)
  {
    if (paramHttpClient != null) {}
    try
    {
      paramHttpClient.getConnectionManager().closeExpiredConnections();
      return;
    }
    catch (Exception paramHttpClient) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\net\HttpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */