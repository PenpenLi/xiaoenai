package com.baidu.location;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class s$1
  extends Thread
{
  s$1(s params) {}
  
  public void run()
  {
    this.a.cR = c.jdMethod_for();
    this.a.T();
    int i = this.a.c0;
    s.jdMethod_if(this.a);
    for (;;)
    {
      if (i > 0) {}
      try
      {
        localHttpGet = new HttpGet(this.a.cR);
        localHttpGet.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        localHttpGet.setHeader("Accept-Charset", "UTF-8;");
        Object localObject = new DefaultHttpClient();
        ((HttpClient)localObject).getParams().setParameter("http.connection.timeout", Integer.valueOf(12000));
        ((HttpClient)localObject).getParams().setParameter("http.socket.timeout", Integer.valueOf(12000));
        HttpProtocolParams.setUseExpectContinue(((HttpClient)localObject).getParams(), false);
        if (((s.M() == 1) || (s.M() == 4)) && ((this.a.c0 - i) % 2 == 0))
        {
          HttpHost localHttpHost = new HttpHost(s.O(), s.S(), "http");
          ((HttpClient)localObject).getParams().setParameter("http.route.default-proxy", localHttpHost);
        }
        localObject = ((HttpClient)localObject).execute(localHttpGet);
        if (((HttpResponse)localObject).getStatusLine().getStatusCode() != 200) {
          break label272;
        }
        this.a.cS = ((HttpResponse)localObject).getEntity();
        this.a.jdMethod_do(true);
        if (i > 0) {
          break;
        }
        s.cY += 1;
        this.a.cS = null;
        this.a.jdMethod_do(false);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          HttpGet localHttpGet;
          Log.d("baidu_location_service", "NetworkCommunicationException!");
          continue;
          s.cY = 0;
        }
      }
      s.jdMethod_if(this.a, false);
      return;
      label272:
      localHttpGet.abort();
      i -= 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\s$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */