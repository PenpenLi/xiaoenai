package com.baidu.location;

import android.util.Log;
import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class s$3
  extends Thread
{
  s$3(s params) {}
  
  public void run()
  {
    this.a.cR = c.jdMethod_for();
    this.a.T();
    int i = this.a.c0;
    s.jdMethod_if(this.a);
    Object localObject1 = null;
    if (i > 0) {}
    for (;;)
    {
      try
      {
        HttpPost localHttpPost = new HttpPost(this.a.cR);
        try
        {
          localObject1 = new FileEntity(new File(this.a.cW), "binary/octet-stream");
          localHttpPost.setHeader("Content-Type", "application/octet-stream");
          localHttpPost.setHeader("Accept-Charset", "UTF-8;");
          localHttpPost.setEntity((HttpEntity)localObject1);
          localObject1 = new DefaultHttpClient();
          ((HttpClient)localObject1).getParams().setParameter("http.connection.timeout", Integer.valueOf(12000));
          ((HttpClient)localObject1).getParams().setParameter("http.socket.timeout", Integer.valueOf(12000));
          HttpProtocolParams.setUseExpectContinue(((HttpClient)localObject1).getParams(), false);
          if (((s.M() == 1) || (s.M() == 4)) && ((this.a.c0 - i) % 2 == 0))
          {
            HttpHost localHttpHost = new HttpHost(s.O(), s.S(), "http");
            ((HttpClient)localObject1).getParams().setParameter("http.route.default-proxy", localHttpHost);
          }
          localObject1 = ((HttpClient)localObject1).execute(localHttpPost);
          if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200)
          {
            this.a.cS = ((HttpResponse)localObject1).getEntity();
            this.a.jdMethod_do(true);
            if (i > 0) {
              continue;
            }
            s.cY += 1;
            this.a.cS = null;
            this.a.jdMethod_do(false);
            s.jdMethod_if(this.a, false);
            return;
          }
          localHttpPost.abort();
          localObject1 = localHttpPost;
          i -= 1;
        }
        catch (Exception localException1)
        {
          localObject2 = localHttpPost;
        }
      }
      catch (Exception localException2)
      {
        Object localObject2;
        continue;
      }
      ((HttpPost)localObject2).abort();
      Log.d("baidu_location_service", "NetworkCommunicationException!");
      continue;
      s.cY = 0;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\s$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */