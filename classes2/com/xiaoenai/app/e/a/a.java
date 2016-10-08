package com.xiaoenai.app.e.a;

import android.net.Uri;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.utils.v;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class a
{
  protected final int a = 5000;
  protected final int b = 20000;
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    return paramString1.replaceFirst(paramString2, paramString3);
  }
  
  private InputStream d(String paramString, Object paramObject)
  {
    HttpURLConnection localHttpURLConnection = c(paramString, paramObject);
    int i = 0;
    while ((localHttpURLConnection.getResponseCode() / 100 == 3) && (i < 5))
    {
      localHttpURLConnection = c(localHttpURLConnection.getHeaderField("Location"), paramObject);
      i += 1;
    }
    try
    {
      com.xiaoenai.app.utils.f.a.c("ResponseCode {} length = {}", new Object[] { Integer.valueOf(localHttpURLConnection.getResponseCode()), Integer.valueOf(localHttpURLConnection.getContentLength()) });
      paramObject = localHttpURLConnection.getInputStream();
      com.xiaoenai.app.utils.f.a.c("getStreamFromNetwork fileUrl = {}", new Object[] { paramString });
      if (localHttpURLConnection.getResponseCode() != 200)
      {
        com.xiaoenai.app.utils.d.k.a((Closeable)paramObject);
        throw new IOException("Image request failed with response code " + localHttpURLConnection.getResponseCode());
      }
    }
    catch (IOException paramObject)
    {
      com.xiaoenai.app.utils.f.a.a("IOE: {}", new Object[] { ((IOException)paramObject).getMessage() });
      com.xiaoenai.app.utils.f.a.a(true, "Error {} {} {} {}", new Object[] { paramString, Integer.valueOf(localHttpURLConnection.getResponseCode()), ((IOException)paramObject).getMessage(), localHttpURLConnection.getErrorStream() });
      com.xiaoenai.app.utils.d.k.a(localHttpURLConnection.getErrorStream());
      throw ((Throwable)paramObject);
    }
    if (v.b(localHttpURLConnection.getResponseCode())) {
      com.f.a.b.b(Xiaoenai.j(), "QiniuDownloadFailure");
    }
    v.b(null, localHttpURLConnection.getResponseCode());
    return new com.xiaoenai.app.utils.e.a.a(new BufferedInputStream((InputStream)paramObject, 32768), localHttpURLConnection.getContentLength());
  }
  
  private InputStream e(String paramString, Object paramObject)
  {
    String str = new URL(paramString).getHost();
    Iterator localIterator = com.xiaoenai.app.net.a.b.a(str).iterator();
    int i = 0;
    Object localObject;
    for (IOException localIOException1 = null;; localIOException1 = new IOException("Image request failed with response code " + ((HttpURLConnection)localObject).getResponseCode()))
    {
      if (!localIterator.hasNext()) {
        break label423;
      }
      localObject = (String)localIterator.next();
      com.xiaoenai.app.utils.f.a.c("fileUrl:{}", new Object[] { paramString });
      localObject = a(paramString, str, (String)localObject);
      com.xiaoenai.app.utils.f.a.c("fileUrl trans url:{}", new Object[] { localObject });
      localObject = c((String)localObject, paramObject);
      ((HttpURLConnection)localObject).setRequestProperty("Host", str);
      ((HttpURLConnection)localObject).setRequestProperty("Cookie", "qiniuToken=" + com.xiaoenai.app.utils.k.a(paramString, AppModel.getInstance().getAudioKey()));
      int j = 0;
      i = ((HttpURLConnection)localObject).getResponseCode();
      while ((((HttpURLConnection)localObject).getResponseCode() / 100 == 3) && (j < 5))
      {
        localObject = c(((HttpURLConnection)localObject).getHeaderField("Location"), paramObject);
        j += 1;
      }
      if (200 == i) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        com.xiaoenai.app.utils.f.a.c("ResponseCode {}  length = {}", new Object[] { Integer.valueOf(((HttpURLConnection)localObject).getResponseCode()), Integer.valueOf(((HttpURLConnection)localObject).getContentLength()) });
        InputStream localInputStream = ((HttpURLConnection)localObject).getInputStream();
        com.xiaoenai.app.utils.f.a.c("getStreamFromNetwork fileUrl = {}", new Object[] { paramString });
        paramString = new com.xiaoenai.app.utils.e.a.a(new BufferedInputStream(localInputStream, 32768), ((HttpURLConnection)localObject).getContentLength());
        if (v.b(i)) {
          com.f.a.b.b(Xiaoenai.j(), "QiniuDownloadFailure");
        }
        v.b(null, i);
        if (paramString == null) {
          break label407;
        }
        return paramString;
      }
      catch (IOException localIOException2)
      {
        com.xiaoenai.app.utils.f.a.c("IOE: {}", new Object[] { localIOException2.getMessage() });
        com.xiaoenai.app.utils.f.a.c(true, "Error {} {} {} {}", new Object[] { paramString, Integer.valueOf(((HttpURLConnection)localObject).getResponseCode()), localIOException2.getMessage(), ((HttpURLConnection)localObject).getErrorStream() });
        com.xiaoenai.app.utils.d.k.a(((HttpURLConnection)localObject).getErrorStream());
      }
      break;
      label407:
      if (localIOException2 != null) {
        throw localIOException2;
      }
      throw new IOException("unexpect error");
      label423:
      paramString = null;
    }
  }
  
  public InputStream a(String paramString, Object paramObject)
  {
    return b(paramString, paramObject);
  }
  
  protected InputStream b(String paramString, Object paramObject)
  {
    com.xiaoenai.app.utils.f.a.c("use UrlConnection dns uri = {}", new Object[] { paramString });
    if (com.xiaoenai.app.h.a.a.a().a(null, "mzd_http_dns_enable", false)) {
      return e(paramString, paramObject);
    }
    return d(paramString, paramObject);
  }
  
  protected HttpURLConnection c(String paramString, Object paramObject)
  {
    Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%");
    paramObject = (HttpURLConnection)new URL(paramString).openConnection();
    ((HttpURLConnection)paramObject).setConnectTimeout(this.a);
    ((HttpURLConnection)paramObject).setReadTimeout(20000);
    ((HttpURLConnection)paramObject).setRequestProperty("Cookie", "qiniuToken=" + com.xiaoenai.app.utils.k.a(paramString, AppModel.getInstance().getAudioKey()));
    return (HttpURLConnection)paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\e\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */