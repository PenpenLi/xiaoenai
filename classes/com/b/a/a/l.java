package com.b.a.a;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

class l
  extends DefaultRedirectHandler
{
  private final boolean a;
  
  public l(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  /* Error */
  public java.net.URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 20	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 22
    //   10: invokespecial 25	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_1
    //   15: ldc 27
    //   17: invokeinterface 33 2 0
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +40 -> 64
    //   27: new 35	org/apache/http/ProtocolException
    //   30: dup
    //   31: new 37	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   38: ldc 40
    //   40: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokeinterface 48 1 0
    //   49: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: ldc 53
    //   54: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 58	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;)V
    //   63: athrow
    //   64: aload_3
    //   65: invokeinterface 63 1 0
    //   70: ldc 65
    //   72: ldc 67
    //   74: invokevirtual 73	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 4
    //   79: new 75	java/net/URI
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 76	java/net/URI:<init>	(Ljava/lang/String;)V
    //   88: astore_3
    //   89: aload_1
    //   90: invokeinterface 80 1 0
    //   95: astore 4
    //   97: aload_3
    //   98: invokevirtual 84	java/net/URI:isAbsolute	()Z
    //   101: ifne +307 -> 408
    //   104: aload 4
    //   106: ldc 86
    //   108: invokeinterface 92 2 0
    //   113: ifeq +65 -> 178
    //   116: new 35	org/apache/http/ProtocolException
    //   119: dup
    //   120: new 37	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   127: ldc 94
    //   129: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: ldc 96
    //   138: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 58	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;)V
    //   147: athrow
    //   148: astore_1
    //   149: new 35	org/apache/http/ProtocolException
    //   152: dup
    //   153: new 37	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   160: ldc 98
    //   162: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 4
    //   167: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: aload_1
    //   174: invokespecial 101	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: athrow
    //   178: aload_2
    //   179: ldc 103
    //   181: invokeinterface 109 2 0
    //   186: checkcast 111	org/apache/http/HttpHost
    //   189: astore_1
    //   190: aload_1
    //   191: ifnonnull +13 -> 204
    //   194: new 113	java/lang/IllegalStateException
    //   197: dup
    //   198: ldc 115
    //   200: invokespecial 116	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   203: athrow
    //   204: aload_2
    //   205: ldc 118
    //   207: invokeinterface 109 2 0
    //   212: checkcast 120	org/apache/http/HttpRequest
    //   215: astore 5
    //   217: new 75	java/net/URI
    //   220: dup
    //   221: aload 5
    //   223: invokeinterface 124 1 0
    //   228: invokeinterface 129 1 0
    //   233: invokespecial 76	java/net/URI:<init>	(Ljava/lang/String;)V
    //   236: aload_1
    //   237: iconst_1
    //   238: invokestatic 135	org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lorg/apache/http/HttpHost;Z)Ljava/net/URI;
    //   241: aload_3
    //   242: invokestatic 139	org/apache/http/client/utils/URIUtils:resolve	(Ljava/net/URI;Ljava/net/URI;)Ljava/net/URI;
    //   245: astore_1
    //   246: aload 4
    //   248: ldc -115
    //   250: invokeinterface 144 2 0
    //   255: ifeq +151 -> 406
    //   258: aload_2
    //   259: ldc -110
    //   261: invokeinterface 109 2 0
    //   266: checkcast 148	org/apache/http/impl/client/RedirectLocations
    //   269: astore 4
    //   271: aload 4
    //   273: astore_3
    //   274: aload 4
    //   276: ifnonnull +20 -> 296
    //   279: new 148	org/apache/http/impl/client/RedirectLocations
    //   282: dup
    //   283: invokespecial 149	org/apache/http/impl/client/RedirectLocations:<init>	()V
    //   286: astore_3
    //   287: aload_2
    //   288: ldc -110
    //   290: aload_3
    //   291: invokeinterface 153 3 0
    //   296: aload_1
    //   297: invokevirtual 156	java/net/URI:getFragment	()Ljava/lang/String;
    //   300: ifnull +96 -> 396
    //   303: aload_1
    //   304: new 111	org/apache/http/HttpHost
    //   307: dup
    //   308: aload_1
    //   309: invokevirtual 159	java/net/URI:getHost	()Ljava/lang/String;
    //   312: aload_1
    //   313: invokevirtual 163	java/net/URI:getPort	()I
    //   316: aload_1
    //   317: invokevirtual 166	java/net/URI:getScheme	()Ljava/lang/String;
    //   320: invokespecial 169	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iconst_1
    //   324: invokestatic 135	org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lorg/apache/http/HttpHost;Z)Ljava/net/URI;
    //   327: astore_2
    //   328: aload_3
    //   329: aload_2
    //   330: invokevirtual 173	org/apache/http/impl/client/RedirectLocations:contains	(Ljava/net/URI;)Z
    //   333: ifeq +68 -> 401
    //   336: new 175	org/apache/http/client/CircularRedirectException
    //   339: dup
    //   340: new 37	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   347: ldc -79
    //   349: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_2
    //   353: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: ldc -77
    //   358: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokespecial 180	org/apache/http/client/CircularRedirectException:<init>	(Ljava/lang/String;)V
    //   367: athrow
    //   368: astore_1
    //   369: new 35	org/apache/http/ProtocolException
    //   372: dup
    //   373: aload_1
    //   374: invokevirtual 183	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   377: aload_1
    //   378: invokespecial 101	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: athrow
    //   382: astore_1
    //   383: new 35	org/apache/http/ProtocolException
    //   386: dup
    //   387: aload_1
    //   388: invokevirtual 183	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   391: aload_1
    //   392: invokespecial 101	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: athrow
    //   396: aload_1
    //   397: astore_2
    //   398: goto -70 -> 328
    //   401: aload_3
    //   402: aload_2
    //   403: invokevirtual 187	org/apache/http/impl/client/RedirectLocations:add	(Ljava/net/URI;)V
    //   406: aload_1
    //   407: areturn
    //   408: aload_3
    //   409: astore_1
    //   410: goto -164 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	l
    //   0	413	1	paramHttpResponse	HttpResponse
    //   0	413	2	paramHttpContext	HttpContext
    //   22	387	3	localObject1	Object
    //   77	198	4	localObject2	Object
    //   215	7	5	localHttpRequest	org.apache.http.HttpRequest
    // Exception table:
    //   from	to	target	type
    //   79	89	148	java/net/URISyntaxException
    //   217	246	368	java/net/URISyntaxException
    //   303	328	382	java/net/URISyntaxException
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (!this.a) {
      return false;
    }
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    switch (paramHttpResponse.getStatusLine().getStatusCode())
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */