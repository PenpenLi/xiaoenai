package com.xiaoenai.app.f;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class b
{
  private static HttpClient a;
  
  public static HttpClient a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = new BasicHttpParams();
        HttpProtocolParams.setVersion((HttpParams)localObject1, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset((HttpParams)localObject1, "UTF-8");
        HttpProtocolParams.setUseExpectContinue((HttpParams)localObject1, true);
        ConnManagerParams.setTimeout((HttpParams)localObject1, 60000L);
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject1, 60000);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject1, 60000);
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        a = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject1, localSchemeRegistry), (HttpParams)localObject1);
      }
      Object localObject1 = a;
      return (HttpClient)localObject1;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */