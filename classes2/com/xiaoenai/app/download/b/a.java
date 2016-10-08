package com.xiaoenai.app.download.b;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class a
  implements HttpClient
{
  private static final HttpRequestInterceptor a = new b();
  private final HttpClient b;
  private RuntimeException c = new IllegalStateException("AndroidHttpClient created and never closed");
  private volatile b d;
  
  private a(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    this.b = new c(this, paramClientConnectionManager, paramHttpParams);
  }
  
  public static a a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static a a(String paramString, Context paramContext)
  {
    paramContext = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(paramContext, false);
    HttpConnectionParams.setConnectionTimeout(paramContext, 60000);
    HttpConnectionParams.setSoTimeout(paramContext, 60000);
    HttpConnectionParams.setSocketBufferSize(paramContext, 8192);
    HttpClientParams.setRedirecting(paramContext, false);
    HttpProtocolParams.setUserAgent(paramContext, paramString);
    paramString = new SchemeRegistry();
    paramString.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    return new a(new ThreadSafeClientConnManager(paramContext, paramString), paramContext);
  }
  
  private static String b(HttpUriRequest paramHttpUriRequest, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("curl ");
    Object localObject = paramHttpUriRequest.getAllHeaders();
    int j = localObject.length;
    int i = 0;
    HttpRequest localHttpRequest;
    if (i < j)
    {
      localHttpRequest = localObject[i];
      if ((!paramBoolean) && ((localHttpRequest.getName().equals("Authorization")) || (localHttpRequest.getName().equals("Cookie")))) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("--header \"");
        localStringBuilder.append(localHttpRequest.toString().trim());
        localStringBuilder.append("\" ");
      }
    }
    localObject = paramHttpUriRequest.getURI();
    if ((paramHttpUriRequest instanceof RequestWrapper))
    {
      localHttpRequest = ((RequestWrapper)paramHttpUriRequest).getOriginal();
      if ((localHttpRequest instanceof HttpUriRequest)) {
        localObject = ((HttpUriRequest)localHttpRequest).getURI();
      }
    }
    for (;;)
    {
      localStringBuilder.append("\"");
      localStringBuilder.append(localObject);
      localStringBuilder.append("\"");
      if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest))
      {
        paramHttpUriRequest = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
        if ((paramHttpUriRequest != null) && (paramHttpUriRequest.isRepeatable()))
        {
          if (paramHttpUriRequest.getContentLength() >= 1024L) {
            break label261;
          }
          localObject = new ByteArrayOutputStream();
          paramHttpUriRequest.writeTo((OutputStream)localObject);
          paramHttpUriRequest = ((ByteArrayOutputStream)localObject).toString();
          localStringBuilder.append(" --data-ascii \"").append(paramHttpUriRequest).append("\"");
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        label261:
        localStringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
      }
    }
  }
  
  public void a()
  {
    if (this.c != null)
    {
      getConnectionManager().shutdown();
      this.c = null;
    }
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    return (T)this.b.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    return (T)this.b.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    return (T)this.b.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    return (T)this.b.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    return this.b.execute(paramHttpHost, paramHttpRequest);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    return this.b.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
  {
    return this.b.execute(paramHttpUriRequest);
  }
  
  public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    return this.b.execute(paramHttpUriRequest, paramHttpContext);
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.c != null)
    {
      Log.e("AndroidHttpClient", "Leak found", this.c);
      this.c = null;
    }
  }
  
  public ClientConnectionManager getConnectionManager()
  {
    return this.b.getConnectionManager();
  }
  
  public HttpParams getParams()
  {
    return this.b.getParams();
  }
  
  private class a
    implements HttpRequestInterceptor
  {
    private a() {}
    
    public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    {
      paramHttpContext = a.a(a.this);
      if ((paramHttpContext != null) && (a.b.a(paramHttpContext)) && ((paramHttpRequest instanceof HttpUriRequest))) {
        a.b.a(paramHttpContext, a.a((HttpUriRequest)paramHttpRequest, false));
      }
    }
  }
  
  private static class b
  {
    private final String a;
    private final int b;
    
    private void a(String paramString)
    {
      Log.println(this.b, this.a, paramString);
    }
    
    private boolean a()
    {
      return Log.isLoggable(this.a, this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\download\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */