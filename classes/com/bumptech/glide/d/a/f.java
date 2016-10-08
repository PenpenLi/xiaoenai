package com.bumptech.glide.d.a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.i.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
  implements c<InputStream>
{
  private static final b a = new a(null);
  private final com.bumptech.glide.d.c.e b;
  private final b c;
  private HttpURLConnection d;
  private InputStream e;
  private volatile boolean f;
  
  public f(com.bumptech.glide.d.c.e parame)
  {
    this(parame, a);
  }
  
  f(com.bumptech.glide.d.c.e parame, b paramb)
  {
    this.b = parame;
    this.c = paramb;
  }
  
  private InputStream a(HttpURLConnection paramHttpURLConnection)
  {
    int i;
    if (TextUtils.isEmpty(paramHttpURLConnection.getContentEncoding())) {
      i = paramHttpURLConnection.getContentLength();
    }
    for (this.e = b.a(paramHttpURLConnection.getInputStream(), i);; this.e = paramHttpURLConnection.getInputStream())
    {
      return this.e;
      if (Log.isLoggable("HttpUrlFetcher", 3)) {
        Log.d("HttpUrlFetcher", "Got non empty content encoding: " + paramHttpURLConnection.getContentEncoding());
      }
    }
  }
  
  private InputStream a(URL paramURL1, int paramInt, URL paramURL2, Map<String, String> paramMap)
  {
    if (paramInt >= 5) {
      throw new IOException("Too many (> 5) redirects!");
    }
    if (paramURL2 != null) {
      try
      {
        if (paramURL1.toURI().equals(paramURL2.toURI())) {
          throw new IOException("In re-direct loop");
        }
      }
      catch (URISyntaxException paramURL2) {}
    }
    this.d = this.c.a(paramURL1);
    paramURL2 = paramMap.entrySet().iterator();
    while (paramURL2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramURL2.next();
      this.d.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if (TextUtils.isEmpty(this.d.getRequestProperty("Accept-Encoding"))) {
      this.d.setRequestProperty("Accept-Encoding", "identity");
    }
    this.d.setConnectTimeout(2500);
    this.d.setReadTimeout(2500);
    this.d.setUseCaches(false);
    this.d.setDoInput(true);
    this.d.connect();
    if (this.f) {
      return null;
    }
    int i = this.d.getResponseCode();
    if (i / 100 == 2) {
      return a(this.d);
    }
    if (i / 100 == 3)
    {
      paramURL2 = this.d.getHeaderField("Location");
      if (TextUtils.isEmpty(paramURL2)) {
        throw new IOException("Received empty or null redirect url");
      }
      return a(new URL(paramURL1, paramURL2), paramInt + 1, paramURL1, paramMap);
    }
    if (i == -1) {
      throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
    }
    throw new IOException("Request failed " + i + ": " + this.d.getResponseMessage());
  }
  
  public void a()
  {
    if (this.e != null) {}
    try
    {
      this.e.close();
      if (this.d != null) {
        this.d.disconnect();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public InputStream b(com.bumptech.glide.e parame)
  {
    return a(this.b.a(), 0, null, this.b.b());
  }
  
  public String b()
  {
    return this.b.c();
  }
  
  public void c()
  {
    this.f = true;
  }
  
  private static class a
    implements f.b
  {
    public HttpURLConnection a(URL paramURL)
    {
      return (HttpURLConnection)paramURL.openConnection();
    }
  }
  
  static abstract interface b
  {
    public abstract HttpURLConnection a(URL paramURL);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */