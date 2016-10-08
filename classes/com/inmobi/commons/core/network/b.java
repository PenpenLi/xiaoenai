package com.inmobi.commons.core.network;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class b
{
  private static final String a = b.class.getName();
  private NetworkRequest b;
  private HttpURLConnection c;
  
  public b(NetworkRequest paramNetworkRequest)
  {
    this.b = paramNetworkRequest;
  }
  
  private HttpURLConnection a(String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    a(paramString);
    return paramString;
  }
  
  private void a(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(this.b.o());
    paramHttpURLConnection.setReadTimeout(this.b.p());
    paramHttpURLConnection.setUseCaches(false);
    if (this.b.i() != null)
    {
      localObject = this.b.i().keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramHttpURLConnection.setRequestProperty(str, (String)this.b.i().get(str));
      }
    }
    Object localObject = this.b.n();
    paramHttpURLConnection.setRequestMethod(((NetworkRequest.RequestType)localObject).toString());
    if (localObject != NetworkRequest.RequestType.GET)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.setDoInput(true);
    }
  }
  
  /* Error */
  private c b()
  {
    // Byte code:
    //   0: new 131	com/inmobi/commons/core/network/c
    //   3: dup
    //   4: aload_0
    //   5: getfield 27	com/inmobi/commons/core/network/b:b	Lcom/inmobi/commons/core/network/NetworkRequest;
    //   8: invokespecial 133	com/inmobi/commons/core/network/c:<init>	(Lcom/inmobi/commons/core/network/NetworkRequest;)V
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   17: invokevirtual 138	java/net/HttpURLConnection:getResponseCode	()I
    //   20: istore 7
    //   22: getstatic 144	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   25: getstatic 20	com/inmobi/commons/core/network/b:a	Ljava/lang/String;
    //   28: new 146	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: getfield 27	com/inmobi/commons/core/network/b:b	Lcom/inmobi/commons/core/network/NetworkRequest;
    //   39: invokevirtual 150	com/inmobi/commons/core/network/NetworkRequest:h	()Ljava/lang/String;
    //   42: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc -100
    //   47: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload 7
    //   52: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 165	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    //   61: aconst_null
    //   62: astore 4
    //   64: aconst_null
    //   65: astore_3
    //   66: iload 7
    //   68: sipush 200
    //   71: if_icmpne +310 -> 381
    //   74: aload 4
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 27	com/inmobi/commons/core/network/b:b	Lcom/inmobi/commons/core/network/NetworkRequest;
    //   81: invokevirtual 168	com/inmobi/commons/core/network/NetworkRequest:g	()Z
    //   84: ifeq +59 -> 143
    //   87: aload 4
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   94: invokevirtual 171	java/net/HttpURLConnection:getContentLength	()I
    //   97: i2l
    //   98: aload_0
    //   99: getfield 27	com/inmobi/commons/core/network/b:b	Lcom/inmobi/commons/core/network/NetworkRequest;
    //   102: invokevirtual 175	com/inmobi/commons/core/network/NetworkRequest:f	()J
    //   105: lcmp
    //   106: ifle +37 -> 143
    //   109: aload 4
    //   111: astore_2
    //   112: aload 6
    //   114: new 177	com/inmobi/commons/core/network/NetworkError
    //   117: dup
    //   118: getstatic 183	com/inmobi/commons/core/network/NetworkError$ErrorCode:RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   121: ldc -71
    //   123: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   126: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   129: aload_3
    //   130: invokestatic 196	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   133: aload_0
    //   134: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   137: invokevirtual 199	java/net/HttpURLConnection:disconnect	()V
    //   140: aload 6
    //   142: areturn
    //   143: aload 4
    //   145: astore_2
    //   146: aload_0
    //   147: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   150: invokevirtual 203	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   153: astore_3
    //   154: aload_3
    //   155: astore_2
    //   156: aload_3
    //   157: invokestatic 206	com/inmobi/commons/core/utilities/c:a	(Ljava/io/InputStream;)[B
    //   160: astore 4
    //   162: aload_3
    //   163: astore_2
    //   164: aload 4
    //   166: arraylength
    //   167: ifne +72 -> 239
    //   170: aload_3
    //   171: astore_2
    //   172: aload 6
    //   174: ldc -48
    //   176: invokevirtual 210	com/inmobi/commons/core/network/c:a	(Ljava/lang/String;)V
    //   179: aload_3
    //   180: astore_2
    //   181: aload 6
    //   183: aload_0
    //   184: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   187: invokevirtual 213	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   190: invokevirtual 216	com/inmobi/commons/core/network/c:a	(Ljava/util/Map;)V
    //   193: goto -64 -> 129
    //   196: astore_1
    //   197: aload_2
    //   198: invokestatic 196	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   201: aload_0
    //   202: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   205: invokevirtual 199	java/net/HttpURLConnection:disconnect	()V
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: aload 6
    //   213: new 177	com/inmobi/commons/core/network/NetworkError
    //   216: dup
    //   217: getstatic 219	com/inmobi/commons/core/network/NetworkError$ErrorCode:HTTP_GATEWAY_TIMEOUT	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   220: getstatic 219	com/inmobi/commons/core/network/NetworkError$ErrorCode:HTTP_GATEWAY_TIMEOUT	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   223: invokevirtual 220	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   226: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   229: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   232: aload_1
    //   233: invokevirtual 223	java/net/SocketTimeoutException:printStackTrace	()V
    //   236: aload 6
    //   238: areturn
    //   239: aload_3
    //   240: astore_2
    //   241: aload 4
    //   243: astore_1
    //   244: aload_0
    //   245: getfield 27	com/inmobi/commons/core/network/b:b	Lcom/inmobi/commons/core/network/NetworkRequest;
    //   248: invokevirtual 226	com/inmobi/commons/core/network/NetworkRequest:q	()Z
    //   251: ifeq +46 -> 297
    //   254: aload_3
    //   255: astore_2
    //   256: aload_0
    //   257: getfield 27	com/inmobi/commons/core/network/b:b	Lcom/inmobi/commons/core/network/NetworkRequest;
    //   260: aload 4
    //   262: invokevirtual 229	com/inmobi/commons/core/network/NetworkRequest:a	([B)[B
    //   265: astore 4
    //   267: aload 4
    //   269: astore_1
    //   270: aload 4
    //   272: ifnonnull +25 -> 297
    //   275: aload_3
    //   276: astore_2
    //   277: aload 6
    //   279: new 177	com/inmobi/commons/core/network/NetworkError
    //   282: dup
    //   283: getstatic 232	com/inmobi/commons/core/network/NetworkError$ErrorCode:INVALID_ENCRYPTED_RESPONSE_RECEIVED	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   286: ldc -22
    //   288: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   291: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   294: aload 4
    //   296: astore_1
    //   297: aload_1
    //   298: astore 4
    //   300: aload_1
    //   301: ifnull +54 -> 355
    //   304: aload_3
    //   305: astore_2
    //   306: aload_1
    //   307: astore 4
    //   309: aload_0
    //   310: getfield 27	com/inmobi/commons/core/network/b:b	Lcom/inmobi/commons/core/network/NetworkRequest;
    //   313: invokevirtual 237	com/inmobi/commons/core/network/NetworkRequest:r	()Z
    //   316: ifeq +39 -> 355
    //   319: aload_3
    //   320: astore_2
    //   321: aload_1
    //   322: invokestatic 238	com/inmobi/commons/core/utilities/c:a	([B)[B
    //   325: astore_1
    //   326: aload_1
    //   327: astore 4
    //   329: aload_1
    //   330: ifnonnull +25 -> 355
    //   333: aload_3
    //   334: astore_2
    //   335: aload 6
    //   337: new 177	com/inmobi/commons/core/network/NetworkError
    //   340: dup
    //   341: getstatic 241	com/inmobi/commons/core/network/NetworkError$ErrorCode:GZIP_DECOMPRESSION_FAILED	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   344: ldc -13
    //   346: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   349: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   352: aload_1
    //   353: astore 4
    //   355: aload 4
    //   357: ifnull -178 -> 179
    //   360: aload_3
    //   361: astore_2
    //   362: aload 6
    //   364: new 90	java/lang/String
    //   367: dup
    //   368: aload 4
    //   370: ldc -11
    //   372: invokespecial 248	java/lang/String:<init>	([BLjava/lang/String;)V
    //   375: invokevirtual 210	com/inmobi/commons/core/network/c:a	(Ljava/lang/String;)V
    //   378: goto -199 -> 179
    //   381: aload 4
    //   383: astore_2
    //   384: iload 7
    //   386: invokestatic 252	com/inmobi/commons/core/network/NetworkError$ErrorCode:fromValue	(I)Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   389: astore 5
    //   391: aload 5
    //   393: astore_1
    //   394: aload 5
    //   396: ifnonnull +10 -> 406
    //   399: aload 4
    //   401: astore_2
    //   402: getstatic 255	com/inmobi/commons/core/network/NetworkError$ErrorCode:UNKNOWN_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   405: astore_1
    //   406: aload 4
    //   408: astore_2
    //   409: aload 6
    //   411: new 177	com/inmobi/commons/core/network/NetworkError
    //   414: dup
    //   415: aload_1
    //   416: new 146	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 257
    //   426: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: iload 7
    //   431: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   440: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   443: aload 4
    //   445: astore_2
    //   446: aload 6
    //   448: aload_0
    //   449: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   452: invokevirtual 213	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   455: invokevirtual 216	com/inmobi/commons/core/network/c:a	(Ljava/util/Map;)V
    //   458: goto -329 -> 129
    //   461: astore_1
    //   462: aload 6
    //   464: new 177	com/inmobi/commons/core/network/NetworkError
    //   467: dup
    //   468: getstatic 260	com/inmobi/commons/core/network/NetworkError$ErrorCode:NETWORK_IO_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   471: getstatic 260	com/inmobi/commons/core/network/NetworkError$ErrorCode:NETWORK_IO_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   474: invokevirtual 220	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   477: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   480: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   483: aload_1
    //   484: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   487: aload 6
    //   489: areturn
    //   490: astore_1
    //   491: aload 6
    //   493: new 177	com/inmobi/commons/core/network/NetworkError
    //   496: dup
    //   497: getstatic 264	com/inmobi/commons/core/network/NetworkError$ErrorCode:OUT_OF_MEMORY_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   500: getstatic 264	com/inmobi/commons/core/network/NetworkError$ErrorCode:OUT_OF_MEMORY_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   503: invokevirtual 220	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   506: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   509: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   512: aload_1
    //   513: invokevirtual 265	java/lang/OutOfMemoryError:printStackTrace	()V
    //   516: aload 6
    //   518: areturn
    //   519: astore_1
    //   520: aload 6
    //   522: new 177	com/inmobi/commons/core/network/NetworkError
    //   525: dup
    //   526: getstatic 255	com/inmobi/commons/core/network/NetworkError$ErrorCode:UNKNOWN_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   529: getstatic 255	com/inmobi/commons/core/network/NetworkError$ErrorCode:UNKNOWN_ERROR	Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;
    //   532: invokevirtual 220	com/inmobi/commons/core/network/NetworkError$ErrorCode:toString	()Ljava/lang/String;
    //   535: invokespecial 188	com/inmobi/commons/core/network/NetworkError:<init>	(Lcom/inmobi/commons/core/network/NetworkError$ErrorCode;Ljava/lang/String;)V
    //   538: invokevirtual 191	com/inmobi/commons/core/network/c:a	(Lcom/inmobi/commons/core/network/NetworkError;)V
    //   541: aload_1
    //   542: invokevirtual 266	java/lang/ArrayIndexOutOfBoundsException:printStackTrace	()V
    //   545: new 268	java/util/HashMap
    //   548: dup
    //   549: invokespecial 269	java/util/HashMap:<init>	()V
    //   552: astore_2
    //   553: aload_2
    //   554: ldc_w 271
    //   557: ldc_w 273
    //   560: invokeinterface 277 3 0
    //   565: pop
    //   566: aload_2
    //   567: ldc_w 279
    //   570: aload_1
    //   571: invokevirtual 282	java/lang/ArrayIndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   574: invokeinterface 277 3 0
    //   579: pop
    //   580: invokestatic 287	com/inmobi/commons/core/c/a:a	()Lcom/inmobi/commons/core/c/a;
    //   583: ldc_w 289
    //   586: ldc_w 291
    //   589: aload_2
    //   590: invokevirtual 294	com/inmobi/commons/core/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   593: aload 6
    //   595: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	b
    //   196	13	1	localObject1	Object
    //   210	23	1	localSocketTimeoutException	java.net.SocketTimeoutException
    //   243	173	1	localObject2	Object
    //   461	23	1	localIOException	IOException
    //   490	23	1	localOutOfMemoryError	OutOfMemoryError
    //   519	52	1	localArrayIndexOutOfBoundsException	ArrayIndexOutOfBoundsException
    //   76	514	2	localObject3	Object
    //   65	296	3	localObject4	Object
    //   62	382	4	localObject5	Object
    //   389	6	5	localErrorCode	NetworkError.ErrorCode
    //   11	583	6	localc	c
    //   20	410	7	i	int
    // Exception table:
    //   from	to	target	type
    //   77	87	196	finally
    //   90	109	196	finally
    //   112	129	196	finally
    //   146	154	196	finally
    //   156	162	196	finally
    //   164	170	196	finally
    //   172	179	196	finally
    //   181	193	196	finally
    //   244	254	196	finally
    //   256	267	196	finally
    //   277	294	196	finally
    //   309	319	196	finally
    //   321	326	196	finally
    //   335	352	196	finally
    //   362	378	196	finally
    //   384	391	196	finally
    //   402	406	196	finally
    //   409	443	196	finally
    //   446	458	196	finally
    //   13	61	210	java/net/SocketTimeoutException
    //   129	140	210	java/net/SocketTimeoutException
    //   197	210	210	java/net/SocketTimeoutException
    //   13	61	461	java/io/IOException
    //   129	140	461	java/io/IOException
    //   197	210	461	java/io/IOException
    //   13	61	490	java/lang/OutOfMemoryError
    //   129	140	490	java/lang/OutOfMemoryError
    //   197	210	490	java/lang/OutOfMemoryError
    //   13	61	519	java/lang/ArrayIndexOutOfBoundsException
    //   129	140	519	java/lang/ArrayIndexOutOfBoundsException
    //   197	210	519	java/lang/ArrayIndexOutOfBoundsException
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   4: ldc_w 296
    //   7: aload_1
    //   8: invokevirtual 299	java/lang/String:length	()I
    //   11: invokestatic 304	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   14: invokevirtual 98	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   21: ldc_w 306
    //   24: ldc_w 308
    //   27: invokevirtual 98	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 310	java/io/BufferedWriter
    //   33: dup
    //   34: new 312	java/io/OutputStreamWriter
    //   37: dup
    //   38: aload_0
    //   39: getfield 135	com/inmobi/commons/core/network/b:c	Ljava/net/HttpURLConnection;
    //   42: invokevirtual 316	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   45: invokespecial 319	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   48: invokespecial 322	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   51: astore_2
    //   52: aload_2
    //   53: aload_1
    //   54: invokevirtual 325	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   57: aload_2
    //   58: invokestatic 196	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   61: return
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: invokestatic 196	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: goto -7 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	b
    //   0	75	1	paramString	String
    //   51	15	2	localBufferedWriter	java.io.BufferedWriter
    // Exception table:
    //   from	to	target	type
    //   30	52	62	finally
    //   52	57	71	finally
  }
  
  public c a()
  {
    this.b.a();
    if (com.inmobi.commons.core.utilities.c.a()) {
      try
      {
        Object localObject = this.b.j();
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Url: " + (String)localObject);
        this.c = a((String)localObject);
        if (!this.b.m()) {
          this.c.setInstanceFollowRedirects(false);
        }
        if (this.b.n() == NetworkRequest.RequestType.POST) {
          b(this.b.l());
        }
        localObject = b();
        return (c)localObject;
      }
      catch (IOException localIOException)
      {
        localc2 = new c(this.b);
        localc2.a(new NetworkError(NetworkError.ErrorCode.NETWORK_IO_ERROR, localIOException.getLocalizedMessage()));
        localIOException.printStackTrace();
        return localc2;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localc2 = new c(this.b);
        localc2.a(new NetworkError(NetworkError.ErrorCode.HTTP_BAD_REQUEST, "The URL is malformed:" + NetworkError.ErrorCode.HTTP_BAD_REQUEST.toString()));
        localIllegalArgumentException.printStackTrace();
        return localc2;
      }
      catch (SecurityException localSecurityException)
      {
        c localc2 = new c(this.b);
        localc2.a(new NetworkError(NetworkError.ErrorCode.UNKNOWN_ERROR, localSecurityException.getLocalizedMessage()));
        localSecurityException.printStackTrace();
        HashMap localHashMap = new HashMap();
        localHashMap.put("type", "SecurityException");
        localHashMap.put("message", localSecurityException.getMessage());
        a.a().a("root", "ExceptionCaught", localHashMap);
        return localc2;
      }
    }
    c localc1 = new c(this.b);
    localc1.a(new NetworkError(NetworkError.ErrorCode.NETWORK_UNAVAILABLE_ERROR, "Network unavailable."));
    return localc1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\network\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */