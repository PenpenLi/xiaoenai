package com.alibaba.sdk.android.security.impl;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.security.CertificateService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateManager
  implements CertificateService
{
  public static final CertificateManager INSTANCE = new CertificateManager();
  private static final String PUBLIC_KEY = "public_key";
  private static final String ROOT_CER_FILE_NAME = "com_taobao_tae_sdk_root_cer";
  private static final String TAG = CertificateManager.class.getSimpleName();
  private String backupCer = "-----BEGIN CERTIFICATE-----\nMIIFMjCCBBqgAwIBAgIQQUKC74+LfVtEUeMQXbwpUjANBgkqhkiG9w0BAQUFADCB\ntTELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDEvMC0GA1UEAxMm\nVmVyaVNpZ24gQ2xhc3MgMyBTZWN1cmUgU2VydmVyIENBIC0gRzMwHhcNMTUwNDEz\nMDAwMDAwWhcNMTYwNjExMjM1OTU5WjCBgjELMAkGA1UEBhMCQ04xETAPBgNVBAgT\nCFpoZWppYW5nMREwDwYDVQQHFAhIYW5nemhvdTEoMCYGA1UEChQfVGFvYmFvKENo\naW5hKSBTb2Z0d2FyZSBDby4sIEx0ZDEMMAoGA1UECxQDUkRDMRUwEwYDVQQDFAwq\nLnRhb2Jhby5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDSu3i9\nyBzihy+IFEIlc3dIEM9CZKQGD6eehE6csRU1BC8fTdPk7jv4CMoTr9mA7kGQtiLP\neU+rsDRwmSb3wht/y+9f8UbE0EpzAmTwChC8M4wWctZ8+JwsXyWf8c1ZNtU6/Y9w\n+lUJjOHM2vSJq0pur7tTAbAorECJqCl0T/KxNSgL5Q0M0PXqawJY1GSKBWCf/Gow\n8SRGBJdHj18l6/xfGK9KwlJFPqVLjoRywiFXICxAkBHPmQFXmg4yQvvkqas47Uw9\nCb9RcVbp/+qaHP0OR4FGLsPPJLJUkaOXqgaEAPu0sg4+QBDVFbUCHsG7mrGQuKd3\ntFQh/rqN3pOXglDbAgMBAAGjggFtMIIBaTAjBgNVHREEHDAaggwqLnRhb2Jhby5j\nb22CCnRhb2Jhby5jb20wCQYDVR0TBAIwADAOBgNVHQ8BAf8EBAMCBaAwKwYDVR0f\nBCQwIjAgoB6gHIYaaHR0cDovL3NkLnN5bWNiLmNvbS9zZC5jcmwwYQYDVR0gBFow\nWDBWBgZngQwBAgIwTDAjBggrBgEFBQcCARYXaHR0cHM6Ly9kLnN5bWNiLmNvbS9j\ncHMwJQYIKwYBBQUHAgIwGQwXaHR0cHM6Ly9kLnN5bWNiLmNvbS9ycGEwHQYDVR0l\nBBYwFAYIKwYBBQUHAwEGCCsGAQUFBwMCMB8GA1UdIwQYMBaAFA1EXBZTRMGCfh0g\nqyX0AWPYvnmlMFcGCCsGAQUFBwEBBEswSTAfBggrBgEFBQcwAYYTaHR0cDovL3Nk\nLnN5bWNkLmNvbTAmBggrBgEFBQcwAoYaaHR0cDovL3NkLnN5bWNiLmNvbS9zZC5j\ncnQwDQYJKoZIhvcNAQEFBQADggEBAB0yazrmBTUnspwVSxiEPUjXC8xnSHgiFhhs\n1rgs2777wQuruVVKl8GSFvUWBwN4MrZR0ff4abG4ommeFKRCru5uGbhFq3omLRlf\nA8jZKTdTbXP0CJcbvfLtEaDPlPZxVNyi89y5KqOrppioEl4qS2ZFqY/n72dB3TKx\nN6UlSoshjA6+qvSgJrArf+T9Agjvm+u0ufzJUCoLf/Bn7PIT1o2scNxFUbxWR8SE\nAF7t4UogeKUIwd+NJOKoAma7SM0tqDToMZjG60Z3pTdoe+FnTjTPjWsB7X4qK+9v\nk0nBzvZTVaTUlozMJ/9EheActcKJyftOUWH/lCx24IW0iN0LOtc=\n-----END CERTIFICATE-----";
  private Context context;
  private String expectedSubjectCNName = "CN=*.taobao.com";
  private volatile byte[] publicKey;
  
  private X509Certificate genCer(InputStream paramInputStream, CertificateFactory paramCertificateFactory)
  {
    try
    {
      paramInputStream = (X509Certificate)paramCertificateFactory.generateCertificate(paramInputStream);
      return paramInputStream;
    }
    catch (CertificateException paramInputStream)
    {
      throw new RuntimeException(paramInputStream);
    }
  }
  
  private InputStream getDefaultBackupTBCert()
  {
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.backupCer.getBytes("UTF-8"));
      return localByteArrayInputStream;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }
  
  private void verify(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    for (;;)
    {
      int i;
      try
      {
        paramX509Certificate2.verify(paramX509Certificate1.getPublicKey());
        paramX509Certificate1 = paramX509Certificate2.getSubjectDN().getName().split("[,]");
        int j = paramX509Certificate1.length;
        i = 0;
        if (i < j)
        {
          paramX509Certificate2 = paramX509Certificate1[i];
          if (!TextUtils.isEmpty(paramX509Certificate2))
          {
            boolean bool = this.expectedSubjectCNName.equals(paramX509Certificate2);
            if (!bool) {}
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramX509Certificate1)
      {
        throw new RuntimeException(paramX509Certificate1);
      }
      i += 1;
    }
  }
  
  public byte[] getPublicKey()
  {
    if (this.publicKey == null) {
      return SecurityGuardWrapper.INSTANCE.getByteArrayFromDynamicDataStore("public_key");
    }
    return this.publicKey;
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
    this.publicKey = SecurityGuardWrapper.INSTANCE.getByteArrayFromDynamicDataStore("public_key");
    if (this.publicKey == null) {
      refreshCer();
    }
  }
  
  /* Error */
  public void refreshCer()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: getstatic 141	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   10: ifeq +8 -> 18
    //   13: ldc -113
    //   15: invokestatic 149	com/taobao/tae/sdk/log/SdkCoreLog:startTimeRecord	(Ljava/lang/String;)V
    //   18: ldc -105
    //   20: invokestatic 155	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   23: astore 5
    //   25: new 157	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   32: ldc -96
    //   34: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 167	com/alibaba/sdk/android/ConfigManager:INIT_SERVER_HOST	Ljava/lang/String;
    //   40: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc -87
    //   45: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 172	com/alibaba/sdk/android/ConfigManager:SDK_INTERNAL_VERSION	Ljava/lang/String;
    //   51: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 181	com/alibaba/sdk/android/util/HttpHelper:get	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: astore_1
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: aload_1
    //   65: aload 5
    //   67: invokespecial 183	com/alibaba/sdk/android/security/impl/CertificateManager:genCer	(Ljava/io/InputStream;Ljava/security/cert/CertificateFactory;)Ljava/security/cert/X509Certificate;
    //   70: astore 4
    //   72: aload_3
    //   73: astore_2
    //   74: ldc 15
    //   76: invokestatic 189	com/alibaba/sdk/android/util/ResourceUtils:getRDrawable	(Ljava/lang/String;)I
    //   79: istore 6
    //   81: iload 6
    //   83: ifne +165 -> 248
    //   86: aload_3
    //   87: astore_2
    //   88: bipush 12
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc -65
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: ldc 15
    //   103: aastore
    //   104: invokestatic 197	com/alibaba/sdk/android/message/MessageUtils:createMessage	(I[Ljava/lang/Object;)Lcom/alibaba/sdk/android/message/Message;
    //   107: astore 4
    //   109: aload_3
    //   110: astore_2
    //   111: getstatic 37	com/alibaba/sdk/android/security/impl/CertificateManager:TAG	Ljava/lang/String;
    //   114: aload 4
    //   116: invokestatic 203	com/alibaba/sdk/android/trace/AliSDKLogger:log	(Ljava/lang/String;Lcom/alibaba/sdk/android/message/Message;)V
    //   119: aload_3
    //   120: astore_2
    //   121: new 205	com/alibaba/sdk/android/AlibabaSDKException
    //   124: dup
    //   125: aload 4
    //   127: invokespecial 208	com/alibaba/sdk/android/AlibabaSDKException:<init>	(Lcom/alibaba/sdk/android/message/Message;)V
    //   130: athrow
    //   131: astore_3
    //   132: aconst_null
    //   133: astore 4
    //   135: aload_1
    //   136: astore_2
    //   137: aload 4
    //   139: astore_1
    //   140: getstatic 141	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   143: ifeq +28 -> 171
    //   146: ldc -113
    //   148: getstatic 37	com/alibaba/sdk/android/security/impl/CertificateManager:TAG	Ljava/lang/String;
    //   151: ldc -113
    //   153: invokestatic 212	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   156: iconst_1
    //   157: anewarray 74	java/lang/String
    //   160: dup
    //   161: iconst_0
    //   162: ldc -42
    //   164: aastore
    //   165: invokestatic 218	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   168: invokestatic 222	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: getstatic 37	com/alibaba/sdk/android/security/impl/CertificateManager:TAG	Ljava/lang/String;
    //   174: aload_3
    //   175: invokevirtual 225	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   178: aload_3
    //   179: invokestatic 229	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: new 61	java/lang/RuntimeException
    //   185: dup
    //   186: aload_3
    //   187: invokespecial 64	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   190: athrow
    //   191: astore 4
    //   193: aload_2
    //   194: astore_3
    //   195: aload_1
    //   196: astore_2
    //   197: aload 4
    //   199: astore_1
    //   200: aload_2
    //   201: invokestatic 235	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   204: aload_3
    //   205: invokestatic 235	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: getstatic 37	com/alibaba/sdk/android/security/impl/CertificateManager:TAG	Ljava/lang/String;
    //   214: aload_1
    //   215: invokevirtual 236	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   218: aload_1
    //   219: invokestatic 229	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_0
    //   223: invokespecial 238	com/alibaba/sdk/android/security/impl/CertificateManager:getDefaultBackupTBCert	()Ljava/io/InputStream;
    //   226: astore_1
    //   227: goto -166 -> 61
    //   230: astore_2
    //   231: aload_3
    //   232: astore_2
    //   233: aload_0
    //   234: aload_0
    //   235: invokespecial 238	com/alibaba/sdk/android/security/impl/CertificateManager:getDefaultBackupTBCert	()Ljava/io/InputStream;
    //   238: aload 5
    //   240: invokespecial 183	com/alibaba/sdk/android/security/impl/CertificateManager:genCer	(Ljava/io/InputStream;Ljava/security/cert/CertificateFactory;)Ljava/security/cert/X509Certificate;
    //   243: astore 4
    //   245: goto -173 -> 72
    //   248: aload_3
    //   249: astore_2
    //   250: aload_0
    //   251: getfield 132	com/alibaba/sdk/android/security/impl/CertificateManager:context	Landroid/content/Context;
    //   254: invokevirtual 244	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   257: iload 6
    //   259: invokevirtual 250	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   262: astore_3
    //   263: aload_3
    //   264: astore_2
    //   265: aload_0
    //   266: aload_0
    //   267: aload_3
    //   268: aload 5
    //   270: invokespecial 183	com/alibaba/sdk/android/security/impl/CertificateManager:genCer	(Ljava/io/InputStream;Ljava/security/cert/CertificateFactory;)Ljava/security/cert/X509Certificate;
    //   273: aload 4
    //   275: invokespecial 252	com/alibaba/sdk/android/security/impl/CertificateManager:verify	(Ljava/security/cert/X509Certificate;Ljava/security/cert/X509Certificate;)V
    //   278: aload_3
    //   279: astore_2
    //   280: aload_0
    //   281: aload 4
    //   283: invokevirtual 89	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   286: invokeinterface 257 1 0
    //   291: putfield 120	com/alibaba/sdk/android/security/impl/CertificateManager:publicKey	[B
    //   294: aload_3
    //   295: astore_2
    //   296: getstatic 125	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:INSTANCE	Lcom/alibaba/sdk/android/security/impl/SecurityGuardWrapper;
    //   299: ldc 12
    //   301: aload_0
    //   302: getfield 120	com/alibaba/sdk/android/security/impl/CertificateManager:publicKey	[B
    //   305: invokevirtual 261	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:putValueInDynamicDataStore	(Ljava/lang/String;[B)V
    //   308: aload_3
    //   309: astore_2
    //   310: getstatic 125	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:INSTANCE	Lcom/alibaba/sdk/android/security/impl/SecurityGuardWrapper;
    //   313: aload_0
    //   314: getfield 120	com/alibaba/sdk/android/security/impl/CertificateManager:publicKey	[B
    //   317: invokevirtual 264	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:savePublicKey	([B)V
    //   320: aload_3
    //   321: astore_2
    //   322: getstatic 141	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   325: ifeq +31 -> 356
    //   328: aload_3
    //   329: astore_2
    //   330: ldc -113
    //   332: getstatic 37	com/alibaba/sdk/android/security/impl/CertificateManager:TAG	Ljava/lang/String;
    //   335: ldc -113
    //   337: invokestatic 212	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   340: iconst_1
    //   341: anewarray 74	java/lang/String
    //   344: dup
    //   345: iconst_0
    //   346: ldc_w 266
    //   349: aastore
    //   350: invokestatic 218	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   353: invokestatic 222	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_3
    //   357: invokestatic 235	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   360: aload_1
    //   361: invokestatic 235	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   364: return
    //   365: astore_1
    //   366: aconst_null
    //   367: astore_3
    //   368: aload 4
    //   370: astore_2
    //   371: goto -171 -> 200
    //   374: astore 4
    //   376: aload_1
    //   377: astore_3
    //   378: aload 4
    //   380: astore_1
    //   381: goto -181 -> 200
    //   384: astore_3
    //   385: aconst_null
    //   386: astore_1
    //   387: goto -247 -> 140
    //   390: astore 5
    //   392: aload_3
    //   393: astore_2
    //   394: aload_1
    //   395: astore 4
    //   397: aload 5
    //   399: astore_3
    //   400: aload_2
    //   401: astore_1
    //   402: aload 4
    //   404: astore_2
    //   405: goto -265 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	CertificateManager
    //   60	149	1	localObject1	Object
    //   210	9	1	localException1	Exception
    //   226	135	1	localInputStream	InputStream
    //   365	12	1	localObject2	Object
    //   380	22	1	localObject3	Object
    //   6	195	2	localObject4	Object
    //   230	1	2	localException2	Exception
    //   232	173	2	localObject5	Object
    //   4	116	3	localObject6	Object
    //   131	56	3	localCertificateException1	CertificateException
    //   194	184	3	localObject7	Object
    //   384	9	3	localCertificateException2	CertificateException
    //   399	1	3	localObject8	Object
    //   1	137	4	localObject9	Object
    //   191	7	4	localObject10	Object
    //   243	126	4	localX509Certificate	X509Certificate
    //   374	5	4	localObject11	Object
    //   395	8	4	localObject12	Object
    //   23	246	5	localCertificateFactory	CertificateFactory
    //   390	8	5	localCertificateException3	CertificateException
    //   79	179	6	i	int
    // Exception table:
    //   from	to	target	type
    //   63	72	131	java/security/cert/CertificateException
    //   74	81	131	java/security/cert/CertificateException
    //   88	109	131	java/security/cert/CertificateException
    //   111	119	131	java/security/cert/CertificateException
    //   121	131	131	java/security/cert/CertificateException
    //   233	245	131	java/security/cert/CertificateException
    //   250	263	131	java/security/cert/CertificateException
    //   140	171	191	finally
    //   171	191	191	finally
    //   25	61	210	java/lang/Exception
    //   63	72	230	java/lang/Exception
    //   7	18	365	finally
    //   18	25	365	finally
    //   25	61	365	finally
    //   211	227	365	finally
    //   63	72	374	finally
    //   74	81	374	finally
    //   88	109	374	finally
    //   111	119	374	finally
    //   121	131	374	finally
    //   233	245	374	finally
    //   250	263	374	finally
    //   265	278	374	finally
    //   280	294	374	finally
    //   296	308	374	finally
    //   310	320	374	finally
    //   322	328	374	finally
    //   330	356	374	finally
    //   7	18	384	java/security/cert/CertificateException
    //   18	25	384	java/security/cert/CertificateException
    //   25	61	384	java/security/cert/CertificateException
    //   211	227	384	java/security/cert/CertificateException
    //   265	278	390	java/security/cert/CertificateException
    //   280	294	390	java/security/cert/CertificateException
    //   296	308	390	java/security/cert/CertificateException
    //   310	320	390	java/security/cert/CertificateException
    //   322	328	390	java/security/cert/CertificateException
    //   330	356	390	java/security/cert/CertificateException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\CertificateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */