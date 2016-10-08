package com.xiaoenai.app.utils.e.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

public class a
  extends com.nostra13.universalimageloader.core.d.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    return paramString1.replaceFirst(paramString2, paramString3);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (a(paramInt))
    {
      com.f.a.b.b(paramContext, "QiniuDownloadFailure");
      com.xiaoenai.app.h.a.a.a().a(paramContext, "mzd_http_dns_error_5xx_v2");
    }
    if (b(paramInt)) {
      com.xiaoenai.app.h.a.a.a().a(paramContext, "mzd_http_dns_error_4xx_v2");
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt / 100 == 5);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt > 0) && (paramInt / 100 == 4);
  }
  
  private InputStream i(String paramString, Object paramObject)
  {
    paramString = c(paramString, paramObject);
    int i = 0;
    int j = paramString.getResponseCode();
    while ((paramString.getResponseCode() / 100 == 3) && (i < 5))
    {
      paramString = c(paramString.getHeaderField("Location"), paramObject);
      i += 1;
    }
    try
    {
      paramObject = paramString.getInputStream();
      if (!a(paramString))
      {
        com.nostra13.universalimageloader.b.b.a((Closeable)paramObject);
        throw new IOException("Image request failed with response code " + paramString.getResponseCode());
      }
    }
    catch (IOException paramObject)
    {
      com.nostra13.universalimageloader.b.b.a(paramString.getErrorStream());
      throw ((Throwable)paramObject);
    }
    if (a(j)) {
      com.f.a.b.b(this.a, "QiniuDownloadFailure");
    }
    return new com.nostra13.universalimageloader.core.a.a(new BufferedInputStream((InputStream)paramObject, 32768), paramString.getContentLength());
  }
  
  private InputStream j(String paramString, Object paramObject)
  {
    Object localObject3 = null;
    com.xiaoenai.app.utils.f.a.c("use UrlConnection dns uri = {}", new Object[] { paramString });
    String str = new URL(paramString).getHost();
    Iterator localIterator = com.xiaoenai.app.net.a.b.a(str).iterator();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    InputStream localInputStream;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label355;
      }
      localObject2 = (String)localIterator.next();
      com.xiaoenai.app.utils.f.a.c("ip = {}", new Object[] { localObject2 });
      com.xiaoenai.app.utils.f.a.c("imageUrl:{}", new Object[] { paramString });
      localObject2 = a(paramString, str, (String)localObject2);
      com.xiaoenai.app.utils.f.a.c("imageLoad url:{}", new Object[] { localObject2 });
      localObject2 = c((String)localObject2, paramObject);
      ((HttpURLConnection)localObject2).setRequestProperty("Host", str);
      i = ((HttpURLConnection)localObject2).getResponseCode();
      int j = 0;
      try
      {
        while ((((HttpURLConnection)localObject2).getResponseCode() / 100 == 3) && (j < 5))
        {
          localObject2 = c(((HttpURLConnection)localObject2).getHeaderField("Location"), paramObject);
          j += 1;
        }
      }
      catch (IOException localIOException1) {}
      if (200 != i) {
        IOException localIOException2 = new IOException("Image request failed with response code " + ((HttpURLConnection)localObject2).getResponseCode());
      } else {
        try
        {
          localInputStream = ((HttpURLConnection)localObject2).getInputStream();
          if (a((HttpURLConnection)localObject2)) {
            break;
          }
          com.nostra13.universalimageloader.b.b.a(localInputStream);
          throw new IOException("Image request failed with response code " + ((HttpURLConnection)localObject2).getResponseCode());
        }
        catch (IOException localIOException3)
        {
          com.nostra13.universalimageloader.b.b.a(((HttpURLConnection)localObject2).getErrorStream());
        }
      }
    }
    label355:
    for (paramString = new com.nostra13.universalimageloader.core.a.a(new BufferedInputStream(localInputStream, 32768), ((HttpURLConnection)localObject2).getContentLength());; paramString = (String)localObject3)
    {
      a(this.a, i);
      if (paramString != null) {
        return paramString;
      }
      if (localIOException3 != null) {
        throw localIOException3;
      }
      throw new IOException("unexpect error");
    }
  }
  
  protected InputStream b(String paramString, Object paramObject)
  {
    if (com.xiaoenai.app.h.a.a.a().a(this.a, "mzd_http_dns_enable", false)) {
      return j(paramString, paramObject);
    }
    return i(paramString, paramObject);
  }
  
  protected HttpURLConnection c(String paramString, Object paramObject)
  {
    HttpURLConnection localHttpURLConnection = super.c(paramString, paramObject);
    if (paramString.startsWith("https")) {
      ((HttpsURLConnection)localHttpURLConnection).setHostnameVerifier(new b(this));
    }
    if ((paramObject != null) && ((paramObject instanceof Bundle)))
    {
      paramString = ((Bundle)paramObject).getString("Cookie");
      if (!TextUtils.isEmpty(paramString)) {
        localHttpURLConnection.setRequestProperty("Cookie", paramString);
      }
    }
    return localHttpURLConnection;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\e\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */