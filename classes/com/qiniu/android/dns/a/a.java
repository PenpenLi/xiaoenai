package com.qiniu.android.dns.a;

import com.qiniu.android.dns.c;
import com.qiniu.android.dns.d;
import com.qiniu.android.dns.g;
import com.qiniu.android.dns.h;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a
  implements d
{
  private final String a;
  
  public a()
  {
    this("119.29.29.29");
  }
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  public h[] a(c paramc, g paramg)
  {
    try
    {
      paramc = new URI("http://" + this.a + "/d?ttl=1&dn=" + paramc.a);
      paramg = new DefaultHttpClient();
      HttpGet localHttpGet = new HttpGet();
      localHttpGet.setURI(paramc);
      paramc = paramg.execute(localHttpGet);
      if (paramc.getStatusLine().getStatusCode() != 200) {
        return null;
      }
    }
    catch (URISyntaxException paramc)
    {
      throw new AssertionError(paramc);
    }
    paramc = paramc.getEntity();
    long l = paramc.getContentLength();
    if ((l > 1024L) || (l == 0L)) {
      return null;
    }
    paramc = paramc.getContent();
    paramg = new byte[(int)l];
    try
    {
      i = paramc.read(paramg);
      paramc.close();
      paramc = new String(paramg, 0, i).split(",");
      if (paramc.length != 2) {
        return null;
      }
    }
    catch (IOException paramg)
    {
      throw paramg;
    }
    finally
    {
      paramc.close();
    }
    int j;
    try
    {
      j = Integer.parseInt(paramc[1]);
      paramc = paramc[0].split(";");
      if (paramc.length == 0) {
        return null;
      }
    }
    catch (Exception paramc)
    {
      return null;
    }
    paramg = new h[paramc.length];
    l = System.currentTimeMillis() / 1000L;
    int i = 0;
    while (i < paramc.length)
    {
      paramg[i] = new h(paramc[i], 1, j, l);
      i += 1;
    }
    return paramg;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */