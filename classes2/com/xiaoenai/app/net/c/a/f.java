package com.xiaoenai.app.net.c.a;

import org.apache.http.client.HttpClient;

public class f
{
  private static HttpClient a;
  
  /* Error */
  public static HttpClient a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/xiaoenai/app/net/c/a/f:a	Lorg/apache/http/client/HttpClient;
    //   6: ifnonnull +148 -> 154
    //   9: new 23	org/apache/http/params/BasicHttpParams
    //   12: dup
    //   13: invokespecial 27	org/apache/http/params/BasicHttpParams:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 29
    //   20: iconst_0
    //   21: invokestatic 35	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: invokeinterface 41 3 0
    //   29: pop
    //   30: aload_1
    //   31: getstatic 47	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   34: invokestatic 53	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   37: aload_1
    //   38: ldc 55
    //   40: invokestatic 59	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   43: aload_1
    //   44: iconst_1
    //   45: invokestatic 63	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   48: aload_1
    //   49: ldc2_w 64
    //   52: invokestatic 71	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   55: aload_1
    //   56: sipush 30000
    //   59: invokestatic 77	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   62: aload_1
    //   63: sipush 30000
    //   66: invokestatic 80	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   69: new 82	org/apache/http/conn/scheme/SchemeRegistry
    //   72: dup
    //   73: invokespecial 83	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: new 85	org/apache/http/conn/scheme/Scheme
    //   81: dup
    //   82: ldc 87
    //   84: invokestatic 93	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   87: bipush 80
    //   89: invokespecial 96	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   92: invokevirtual 100	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   95: pop
    //   96: invokestatic 106	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   99: invokestatic 110	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   102: astore_0
    //   103: aload_0
    //   104: aconst_null
    //   105: aconst_null
    //   106: invokevirtual 114	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   109: aload_2
    //   110: new 85	org/apache/http/conn/scheme/Scheme
    //   113: dup
    //   114: ldc 116
    //   116: new 118	com/xiaoenai/app/net/c/b/a
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 121	com/xiaoenai/app/net/c/b/a:<init>	(Ljava/security/KeyStore;)V
    //   124: sipush 443
    //   127: invokespecial 96	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   130: invokevirtual 100	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   133: pop
    //   134: new 123	org/apache/http/impl/client/DefaultHttpClient
    //   137: dup
    //   138: new 125	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   141: dup
    //   142: aload_1
    //   143: aload_2
    //   144: invokespecial 128	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   147: aload_1
    //   148: invokespecial 131	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   151: putstatic 21	com/xiaoenai/app/net/c/a/f:a	Lorg/apache/http/client/HttpClient;
    //   154: getstatic 21	com/xiaoenai/app/net/c/a/f:a	Lorg/apache/http/client/HttpClient;
    //   157: astore_0
    //   158: ldc 2
    //   160: monitorexit
    //   161: aload_0
    //   162: areturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   168: goto -34 -> 134
    //   171: astore_0
    //   172: ldc 2
    //   174: monitorexit
    //   175: aload_0
    //   176: athrow
    //   177: astore_0
    //   178: goto -14 -> 164
    //   181: astore_0
    //   182: goto -18 -> 164
    //   185: astore_0
    //   186: goto -22 -> 164
    //   189: astore_0
    //   190: goto -26 -> 164
    //   193: astore_0
    //   194: goto -30 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   102	60	0	localObject1	Object
    //   163	2	0	localKeyStoreException	java.security.KeyStoreException
    //   171	5	0	localObject2	Object
    //   177	1	0	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   181	1	0	localCertificateException	java.security.cert.CertificateException
    //   185	1	0	localIOException	java.io.IOException
    //   189	1	0	localUnrecoverableKeyException	java.security.UnrecoverableKeyException
    //   193	1	0	localKeyManagementException	java.security.KeyManagementException
    //   16	132	1	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   76	68	2	localSchemeRegistry	org.apache.http.conn.scheme.SchemeRegistry
    // Exception table:
    //   from	to	target	type
    //   96	134	163	java/security/KeyStoreException
    //   3	96	171	finally
    //   96	134	171	finally
    //   134	154	171	finally
    //   154	158	171	finally
    //   164	168	171	finally
    //   96	134	177	java/security/NoSuchAlgorithmException
    //   96	134	181	java/security/cert/CertificateException
    //   96	134	185	java/io/IOException
    //   96	134	189	java/security/UnrecoverableKeyException
    //   96	134	193	java/security/KeyManagementException
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\c\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */