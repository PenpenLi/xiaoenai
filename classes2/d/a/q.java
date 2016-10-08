package d.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.f.a.a;
import com.f.a.d;
import java.net.URLEncoder;

public class q
{
  private String a;
  private String b = "10.0.0.172";
  private int c = 80;
  private Context d;
  private o e;
  
  public q(Context paramContext)
  {
    this.d = paramContext;
    this.a = a(paramContext);
  }
  
  private String a(Context paramContext)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("Android");
    localStringBuffer1.append("/");
    localStringBuffer1.append("6.0.1");
    localStringBuffer1.append(" ");
    try
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(av.t(paramContext));
      localStringBuffer2.append("/");
      localStringBuffer2.append(av.b(paramContext));
      localStringBuffer2.append(" ");
      localStringBuffer2.append(Build.MODEL);
      localStringBuffer2.append("/");
      localStringBuffer2.append(Build.VERSION.RELEASE);
      localStringBuffer2.append(" ");
      localStringBuffer2.append(aw.a(a.a(paramContext)));
      localStringBuffer1.append(URLEncoder.encode(localStringBuffer2.toString(), "UTF-8"));
      return localStringBuffer1.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private boolean a()
  {
    if (this.d.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.d.getPackageName()) != 0) {
      return false;
    }
    try
    {
      Object localObject = (ConnectivityManager)this.d.getSystemService("connectivity");
      if (!av.a(this.d, "android.permission.ACCESS_NETWORK_STATE")) {
        return false;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() != 1))
      {
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (localObject != null) {
          if ((!((String)localObject).equals("cmwap")) && (!((String)localObject).equals("3gwap")))
          {
            boolean bool = ((String)localObject).equals("uniwap");
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 146	d/a/q:e	Ld/a/o;
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: getfield 146	d/a/q:e	Ld/a/o;
    //   11: invokeinterface 150 1 0
    //   16: aload_0
    //   17: invokespecial 152	d/a/q:a	()Z
    //   20: ifeq +343 -> 363
    //   23: new 154	java/net/Proxy
    //   26: dup
    //   27: getstatic 160	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   30: new 162	java/net/InetSocketAddress
    //   33: dup
    //   34: aload_0
    //   35: getfield 22	d/a/q:b	Ljava/lang/String;
    //   38: aload_0
    //   39: getfield 24	d/a/q:c	I
    //   42: invokespecial 165	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   45: invokespecial 168	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   48: astore_3
    //   49: new 170	java/net/URL
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 173	java/net/URL:<init>	(Ljava/lang/String;)V
    //   57: aload_3
    //   58: invokevirtual 177	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   61: checkcast 179	java/net/HttpURLConnection
    //   64: astore_3
    //   65: aload_3
    //   66: astore 4
    //   68: aload_3
    //   69: ldc -75
    //   71: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   74: invokestatic 191	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   77: invokevirtual 195	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_3
    //   81: astore 4
    //   83: aload_3
    //   84: ldc -59
    //   86: aload_0
    //   87: getfield 31	d/a/q:a	Ljava/lang/String;
    //   90: invokevirtual 195	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_3
    //   94: astore 4
    //   96: aload_3
    //   97: ldc -57
    //   99: ldc -55
    //   101: invokevirtual 195	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: astore 4
    //   107: aload_3
    //   108: ldc -53
    //   110: ldc -55
    //   112: invokevirtual 195	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_3
    //   116: astore 4
    //   118: aload_3
    //   119: sipush 10000
    //   122: invokevirtual 207	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   125: aload_3
    //   126: astore 4
    //   128: aload_3
    //   129: sipush 30000
    //   132: invokevirtual 210	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   135: aload_3
    //   136: astore 4
    //   138: aload_3
    //   139: ldc -44
    //   141: invokevirtual 215	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   144: aload_3
    //   145: astore 4
    //   147: aload_3
    //   148: iconst_1
    //   149: invokevirtual 219	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   152: aload_3
    //   153: astore 4
    //   155: aload_3
    //   156: iconst_1
    //   157: invokevirtual 222	java/net/HttpURLConnection:setDoInput	(Z)V
    //   160: aload_3
    //   161: astore 4
    //   163: aload_3
    //   164: iconst_0
    //   165: invokevirtual 225	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   168: aload_3
    //   169: astore 4
    //   171: getstatic 228	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   174: invokestatic 234	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   177: bipush 8
    //   179: if_icmpge +14 -> 193
    //   182: aload_3
    //   183: astore 4
    //   185: ldc -20
    //   187: ldc -18
    //   189: invokestatic 241	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: pop
    //   193: aload_3
    //   194: astore 4
    //   196: aload_3
    //   197: invokevirtual 245	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   200: astore 5
    //   202: aload_3
    //   203: astore 4
    //   205: aload 5
    //   207: aload_1
    //   208: invokevirtual 251	java/io/OutputStream:write	([B)V
    //   211: aload_3
    //   212: astore 4
    //   214: aload 5
    //   216: invokevirtual 254	java/io/OutputStream:flush	()V
    //   219: aload_3
    //   220: astore 4
    //   222: aload 5
    //   224: invokevirtual 257	java/io/OutputStream:close	()V
    //   227: aload_3
    //   228: astore 4
    //   230: aload_0
    //   231: getfield 146	d/a/q:e	Ld/a/o;
    //   234: ifnull +15 -> 249
    //   237: aload_3
    //   238: astore 4
    //   240: aload_0
    //   241: getfield 146	d/a/q:e	Ld/a/o;
    //   244: invokeinterface 259 1 0
    //   249: aload_3
    //   250: astore 4
    //   252: aload_3
    //   253: invokevirtual 262	java/net/HttpURLConnection:getResponseCode	()I
    //   256: istore 7
    //   258: aload_3
    //   259: astore 4
    //   261: aload_3
    //   262: ldc -53
    //   264: invokevirtual 265	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore_1
    //   268: aload_3
    //   269: astore 4
    //   271: aload_1
    //   272: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifne +176 -> 451
    //   278: aload_3
    //   279: astore 4
    //   281: aload_1
    //   282: ldc_w 273
    //   285: invokevirtual 277	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   288: ifeq +163 -> 451
    //   291: iconst_1
    //   292: istore 6
    //   294: iload 7
    //   296: sipush 200
    //   299: if_icmpne +116 -> 415
    //   302: iload 6
    //   304: ifeq +111 -> 415
    //   307: aload_3
    //   308: astore 4
    //   310: new 279	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 282
    //   320: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_2
    //   324: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 290	d/a/ax:b	(Ljava/lang/String;)V
    //   333: aload_3
    //   334: astore 4
    //   336: aload_3
    //   337: invokevirtual 294	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   340: astore_1
    //   341: aload_1
    //   342: invokestatic 297	d/a/aw:b	(Ljava/io/InputStream;)[B
    //   345: astore_2
    //   346: aload_3
    //   347: astore 4
    //   349: aload_1
    //   350: invokestatic 300	d/a/aw:c	(Ljava/io/InputStream;)V
    //   353: aload_3
    //   354: ifnull +7 -> 361
    //   357: aload_3
    //   358: invokevirtual 303	java/net/HttpURLConnection:disconnect	()V
    //   361: aload_2
    //   362: areturn
    //   363: new 170	java/net/URL
    //   366: dup
    //   367: aload_2
    //   368: invokespecial 173	java/net/URL:<init>	(Ljava/lang/String;)V
    //   371: invokevirtual 306	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   374: checkcast 179	java/net/HttpURLConnection
    //   377: astore_3
    //   378: goto -313 -> 65
    //   381: astore_2
    //   382: aload_3
    //   383: astore 4
    //   385: aload_1
    //   386: invokestatic 300	d/a/aw:c	(Ljava/io/InputStream;)V
    //   389: aload_3
    //   390: astore 4
    //   392: aload_2
    //   393: athrow
    //   394: astore_1
    //   395: aload_3
    //   396: astore 4
    //   398: ldc_w 308
    //   401: aload_1
    //   402: invokestatic 311	d/a/ax:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   405: aload_3
    //   406: ifnull +7 -> 413
    //   409: aload_3
    //   410: invokevirtual 303	java/net/HttpURLConnection:disconnect	()V
    //   413: aconst_null
    //   414: areturn
    //   415: aload_3
    //   416: ifnull +7 -> 423
    //   419: aload_3
    //   420: invokevirtual 303	java/net/HttpURLConnection:disconnect	()V
    //   423: aconst_null
    //   424: areturn
    //   425: astore_1
    //   426: aconst_null
    //   427: astore 4
    //   429: aload 4
    //   431: ifnull +8 -> 439
    //   434: aload 4
    //   436: invokevirtual 303	java/net/HttpURLConnection:disconnect	()V
    //   439: aload_1
    //   440: athrow
    //   441: astore_1
    //   442: goto -13 -> 429
    //   445: astore_1
    //   446: aconst_null
    //   447: astore_3
    //   448: goto -53 -> 395
    //   451: iconst_0
    //   452: istore 6
    //   454: goto -160 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	q
    //   0	457	1	paramArrayOfByte	byte[]
    //   0	457	2	paramString	String
    //   48	400	3	localObject1	Object
    //   66	369	4	localObject2	Object
    //   200	23	5	localOutputStream	java.io.OutputStream
    //   292	161	6	i	int
    //   256	44	7	j	int
    // Exception table:
    //   from	to	target	type
    //   341	346	381	finally
    //   68	80	394	java/lang/Exception
    //   83	93	394	java/lang/Exception
    //   96	104	394	java/lang/Exception
    //   107	115	394	java/lang/Exception
    //   118	125	394	java/lang/Exception
    //   128	135	394	java/lang/Exception
    //   138	144	394	java/lang/Exception
    //   147	152	394	java/lang/Exception
    //   155	160	394	java/lang/Exception
    //   163	168	394	java/lang/Exception
    //   171	182	394	java/lang/Exception
    //   185	193	394	java/lang/Exception
    //   196	202	394	java/lang/Exception
    //   205	211	394	java/lang/Exception
    //   214	219	394	java/lang/Exception
    //   222	227	394	java/lang/Exception
    //   230	237	394	java/lang/Exception
    //   240	249	394	java/lang/Exception
    //   252	258	394	java/lang/Exception
    //   261	268	394	java/lang/Exception
    //   271	278	394	java/lang/Exception
    //   281	291	394	java/lang/Exception
    //   310	333	394	java/lang/Exception
    //   336	341	394	java/lang/Exception
    //   349	353	394	java/lang/Exception
    //   385	389	394	java/lang/Exception
    //   392	394	394	java/lang/Exception
    //   0	16	425	finally
    //   16	65	425	finally
    //   363	378	425	finally
    //   68	80	441	finally
    //   83	93	441	finally
    //   96	104	441	finally
    //   107	115	441	finally
    //   118	125	441	finally
    //   128	135	441	finally
    //   138	144	441	finally
    //   147	152	441	finally
    //   155	160	441	finally
    //   163	168	441	finally
    //   171	182	441	finally
    //   185	193	441	finally
    //   196	202	441	finally
    //   205	211	441	finally
    //   214	219	441	finally
    //   222	227	441	finally
    //   230	237	441	finally
    //   240	249	441	finally
    //   252	258	441	finally
    //   261	268	441	finally
    //   271	278	441	finally
    //   281	291	441	finally
    //   310	333	441	finally
    //   336	341	441	finally
    //   349	353	441	finally
    //   385	389	441	finally
    //   392	394	441	finally
    //   398	405	441	finally
    //   0	16	445	java/lang/Exception
    //   16	65	445	java/lang/Exception
    //   363	378	445	java/lang/Exception
  }
  
  public void a(o paramo)
  {
    this.e = paramo;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = null;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte2 = arrayOfByte1;
      if (i < d.d.length)
      {
        arrayOfByte1 = a(paramArrayOfByte, d.d[i]);
        if (arrayOfByte1 == null) {
          break label54;
        }
        arrayOfByte2 = arrayOfByte1;
        if (this.e != null)
        {
          this.e.c();
          arrayOfByte2 = arrayOfByte1;
        }
      }
      return arrayOfByte2;
      label54:
      if (this.e != null) {
        this.e.d();
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */