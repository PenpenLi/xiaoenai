package com.b.a.a;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class e
  implements Runnable
{
  private final AbstractHttpClient a;
  private final HttpContext b;
  private final HttpUriRequest c;
  private final s d;
  private int e;
  private final AtomicBoolean f = new AtomicBoolean();
  private boolean g;
  private volatile boolean h;
  private boolean i;
  
  public e(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, s params)
  {
    this.a = ((AbstractHttpClient)u.a(paramAbstractHttpClient, "client"));
    this.b = ((HttpContext)u.a(paramHttpContext, "context"));
    this.c = ((HttpUriRequest)u.a(paramHttpUriRequest, "request"));
    this.d = ((s)u.a(params, "responseHandler"));
  }
  
  private void c()
  {
    if (a()) {}
    HttpResponse localHttpResponse;
    do
    {
      do
      {
        do
        {
          return;
          if (this.c.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
          }
          if ((this.d instanceof o)) {
            ((o)this.d).a(this.c);
          }
          localHttpResponse = this.a.execute(this.c, this.b);
        } while (a());
        this.d.onPreProcessResponse(this.d, localHttpResponse);
      } while (a());
      this.d.sendResponseMessage(localHttpResponse);
    } while (a());
    this.d.onPostProcessResponse(this.d, localHttpResponse);
  }
  
  private void d()
  {
    Object localObject1 = null;
    HttpRequestRetryHandler localHttpRequestRetryHandler = this.a.getHttpRequestRetryHandler();
    int k = 1;
    if (k != 0) {}
    label285:
    for (;;)
    {
      try
      {
        c();
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        IOException localIOException1 = new IOException("UnknownHostException exception: " + localUnknownHostException.getMessage());
        if (this.e > 0)
        {
          j = this.e + 1;
          this.e = j;
          if (localHttpRequestRetryHandler.retryRequest(localUnknownHostException, j, this.b))
          {
            bool = true;
            break label285;
            localObject2 = localIOException1;
            k = bool;
            if (!bool) {
              break;
            }
            this.d.sendRetryMessage(this.e);
            localObject2 = localIOException1;
            k = bool;
            break;
          }
        }
      }
      catch (Exception localException)
      {
        a.a.b("AsyncHttpRequest", "Unhandled exception origin cause", localException);
        Object localObject2 = new IOException("Unhandled exception: " + localException.getMessage());
        throw ((Throwable)localObject2);
        bool = false;
      }
      catch (NullPointerException localNullPointerException)
      {
        IOException localIOException2 = new IOException("NPE in HttpClient: " + localNullPointerException.getMessage());
        j = this.e + 1;
        this.e = j;
        bool = localHttpRequestRetryHandler.retryRequest(localIOException2, j, this.b);
      }
      catch (IOException localIOException3)
      {
        int j;
        boolean bool;
        if (!a())
        {
          j = this.e + 1;
          this.e = j;
          bool = localHttpRequestRetryHandler.retryRequest(localIOException3, j, this.b);
        }
      }
    }
  }
  
  private void e()
  {
    try
    {
      if ((!this.h) && (this.f.get()) && (!this.g))
      {
        this.g = true;
        this.d.sendCancelMessage();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(e parame) {}
  
  public boolean a()
  {
    boolean bool = this.f.get();
    if (bool) {
      e();
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.f.set(true);
    this.c.abort();
    return a();
  }
  
  public void b(e parame) {}
  
  public boolean b()
  {
    return (a()) || (this.h);
  }
  
  public void run()
  {
    if (a()) {}
    for (;;)
    {
      return;
      if (!this.i)
      {
        this.i = true;
        a(this);
      }
      if (a()) {
        continue;
      }
      this.d.sendStartMessage();
      if (a()) {
        continue;
      }
      try
      {
        d();
        if (a()) {
          continue;
        }
        this.d.sendFinishMessage();
        if (a()) {
          continue;
        }
        b(this);
        this.h = true;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (!a()) {
            this.d.sendFailureMessage(0, null, null, localIOException);
          } else {
            a.a.b("AsyncHttpRequest", "makeRequestWithRetries returned error", localIOException);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */