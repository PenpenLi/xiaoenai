package com.b.a.a;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class a
{
  public static k a = new j();
  private int b = 10;
  private int c = 10000;
  private int d = 10000;
  private final DefaultHttpClient e;
  private final HttpContext f;
  private ExecutorService g;
  private final Map<Context, List<p>> h;
  private final Map<String, String> i;
  private boolean j = true;
  
  public a()
  {
    this(false, 80, 443);
  }
  
  public a(SchemeRegistry paramSchemeRegistry)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, this.c);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(this.b));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, this.d);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, this.c);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    paramSchemeRegistry = a(paramSchemeRegistry, localBasicHttpParams);
    if (paramSchemeRegistry != null) {}
    for (;;)
    {
      u.a(bool, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
      this.g = a();
      this.h = Collections.synchronizedMap(new WeakHashMap());
      this.i = new HashMap();
      this.f = new SyncBasicHttpContext(new BasicHttpContext());
      this.e = new DefaultHttpClient(paramSchemeRegistry, localBasicHttpParams);
      this.e.addRequestInterceptor(new b(this));
      this.e.addResponseInterceptor(new c(this));
      this.e.addRequestInterceptor(new d(this), 0);
      this.e.setHttpRequestRetryHandler(new t(5, 1500));
      return;
      bool = false;
    }
  }
  
  public a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this(a(paramBoolean, paramInt1, paramInt2));
  }
  
  public static String a(boolean paramBoolean, String paramString, r paramr)
  {
    Object localObject;
    if (paramString == null)
    {
      localObject = null;
      return (String)localObject;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject = new URL(URLDecoder.decode(paramString, "UTF-8"));
        localObject = new URI(((URL)localObject).getProtocol(), ((URL)localObject).getUserInfo(), ((URL)localObject).getHost(), ((URL)localObject).getPort(), ((URL)localObject).getPath(), ((URL)localObject).getQuery(), ((URL)localObject).getRef()).toASCIIString();
        paramString = (String)localObject;
        localObject = paramString;
        if (paramr == null) {
          break;
        }
        paramr = paramr.b().trim();
        localObject = paramString;
        if (paramr.equals("")) {
          break;
        }
        localObject = paramString;
        if (paramr.equals("?")) {
          break;
        }
        localObject = new StringBuilder().append(paramString);
        if (!paramString.contains("?")) {
          break label175;
        }
        paramString = "&";
        paramString = paramString;
        return paramString + paramr;
      }
      catch (Exception localException)
      {
        a.b("AsyncHttpClient", "getUrlWithQueryString encoding URL", localException);
      }
      continue;
      label175:
      paramString = "?";
    }
  }
  
  private static SchemeRegistry a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      a.b("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
    }
    int k = paramInt1;
    if (paramInt1 < 1)
    {
      k = 80;
      a.b("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 1)
    {
      paramInt1 = 443;
      a.b("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
    }
    if (paramBoolean) {}
    for (SSLSocketFactory localSSLSocketFactory = m.b();; localSSLSocketFactory = SSLSocketFactory.getSocketFactory())
    {
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), k));
      localSchemeRegistry.register(new Scheme("https", localSSLSocketFactory, paramInt1));
      return localSchemeRegistry;
    }
  }
  
  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      a.a("AsyncHttpClient", "Cannot close input stream", paramInputStream);
    }
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      a.a("AsyncHttpClient", "Cannot close output stream", paramOutputStream);
    }
  }
  
  public static void a(Class<?> paramClass)
  {
    if (paramClass != null) {
      t.a(paramClass);
    }
  }
  
  public static void a(HttpEntity paramHttpEntity)
  {
    if ((paramHttpEntity instanceof HttpEntityWrapper)) {}
    for (;;)
    {
      try
      {
        Field[] arrayOfField = HttpEntityWrapper.class.getDeclaredFields();
        int m = arrayOfField.length;
        int k = 0;
        Field localField;
        if (k < m)
        {
          localField = arrayOfField[k];
          if (localField.getName().equals("wrappedEntity"))
          {
            if (localField != null)
            {
              localField.setAccessible(true);
              paramHttpEntity = (HttpEntity)localField.get(paramHttpEntity);
              if (paramHttpEntity != null) {
                paramHttpEntity.consumeContent();
              }
            }
            return;
          }
          k += 1;
        }
        else
        {
          localField = null;
        }
      }
      catch (Throwable paramHttpEntity)
      {
        a.b("AsyncHttpClient", "wrappedEntity consume", paramHttpEntity);
        return;
      }
    }
  }
  
  public static boolean a(PushbackInputStream paramPushbackInputStream)
  {
    boolean bool = true;
    if (paramPushbackInputStream == null) {
      return false;
    }
    byte[] arrayOfByte = new byte[2];
    int k = paramPushbackInputStream.read(arrayOfByte);
    paramPushbackInputStream.unread(arrayOfByte);
    int m = arrayOfByte[0];
    int n = arrayOfByte[1];
    if ((k == 2) && (35615 == (n << 8 & 0xFF00 | m & 0xFF))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected e a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, s params, Context paramContext)
  {
    return new e(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, params);
  }
  
  public p a(Context paramContext, String paramString, r paramr, s params)
  {
    return b(this.e, this.f, new i(a(this.j, paramString, paramr)), null, params, paramContext);
  }
  
  public p a(Context paramContext, String paramString, s params)
  {
    return a(paramContext, paramString, null, params);
  }
  
  public p a(Context paramContext, String paramString, Header[] paramArrayOfHeader, r paramr, s params)
  {
    paramString = new i(a(this.j, paramString, paramr));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    return b(this.e, this.f, paramString, null, params, paramContext);
  }
  
  protected ExecutorService a()
  {
    return Executors.newCachedThreadPool();
  }
  
  protected ClientConnectionManager a(SchemeRegistry paramSchemeRegistry, BasicHttpParams paramBasicHttpParams)
  {
    return new ThreadSafeClientConnManager(paramBasicHttpParams, paramSchemeRegistry);
  }
  
  public void a(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 1000) {
      k = 10000;
    }
    b(k);
    c(k);
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, paramBoolean, paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    HttpParams localHttpParams = this.e.getParams();
    if (!paramBoolean2) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localHttpParams.setBooleanParameter("http.protocol.reject-relative-redirect", paramBoolean2);
      this.e.getParams().setBooleanParameter("http.protocol.allow-circular-redirects", paramBoolean3);
      this.e.setRedirectHandler(new l(paramBoolean1));
      return;
    }
  }
  
  protected p b(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String arg4, s params, Context paramContext)
  {
    if (paramHttpUriRequest == null) {
      throw new IllegalArgumentException("HttpUriRequest must not be null");
    }
    if (params == null) {
      throw new IllegalArgumentException("ResponseHandler must not be null");
    }
    if ((params.getUseSynchronousMode()) && (!params.getUsePoolThread())) {
      throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
    }
    if (??? != null)
    {
      if ((!(paramHttpUriRequest instanceof HttpEntityEnclosingRequestBase)) || (((HttpEntityEnclosingRequestBase)paramHttpUriRequest).getEntity() == null) || (!paramHttpUriRequest.containsHeader("Content-Type"))) {
        break label280;
      }
      a.c("AsyncHttpClient", "Passed contentType will be ignored because HttpEntity sets content type");
    }
    for (;;)
    {
      params.setRequestHeaders(paramHttpUriRequest.getAllHeaders());
      params.setRequestURI(paramHttpUriRequest.getURI());
      paramDefaultHttpClient = a(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, ???, params, paramContext);
      this.g.submit(paramDefaultHttpClient);
      paramHttpUriRequest = new p(paramDefaultHttpClient);
      if (paramContext != null) {
        synchronized (this.h)
        {
          paramHttpContext = (List)this.h.get(paramContext);
          paramDefaultHttpClient = paramHttpContext;
          if (paramHttpContext == null)
          {
            paramDefaultHttpClient = Collections.synchronizedList(new LinkedList());
            this.h.put(paramContext, paramDefaultHttpClient);
          }
          paramDefaultHttpClient.add(paramHttpUriRequest);
          paramDefaultHttpClient = paramDefaultHttpClient.iterator();
          while (paramDefaultHttpClient.hasNext()) {
            if (((p)paramDefaultHttpClient.next()).c())
            {
              paramDefaultHttpClient.remove();
              continue;
              label280:
              paramHttpUriRequest.setHeader("Content-Type", ???);
            }
          }
        }
      }
    }
    return paramHttpUriRequest;
  }
  
  public void b(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 1000) {
      k = 10000;
    }
    this.c = k;
    HttpParams localHttpParams = this.e.getParams();
    ConnManagerParams.setTimeout(localHttpParams, this.c);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, this.c);
  }
  
  public void c(int paramInt)
  {
    int k = paramInt;
    if (paramInt < 1000) {
      k = 10000;
    }
    this.d = k;
    HttpConnectionParams.setSoTimeout(this.e.getParams(), this.d);
  }
  
  private static class a
    extends HttpEntityWrapper
  {
    InputStream a;
    PushbackInputStream b;
    GZIPInputStream c;
    
    public a(HttpEntity paramHttpEntity)
    {
      super();
    }
    
    public void consumeContent()
    {
      a.a(this.a);
      a.a(this.b);
      a.a(this.c);
      super.consumeContent();
    }
    
    public InputStream getContent()
    {
      this.a = this.wrappedEntity.getContent();
      this.b = new PushbackInputStream(this.a, 2);
      if (a.a(this.b))
      {
        this.c = new GZIPInputStream(this.b);
        return this.c;
      }
      return this.b;
    }
    
    public long getContentLength()
    {
      if (this.wrappedEntity == null) {
        return 0L;
      }
      return this.wrappedEntity.getContentLength();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */