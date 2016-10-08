package com.xiaoenai.app.net.a;

import com.qiniu.android.dns.b;
import com.qiniu.android.dns.d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static a b;
  private b a = null;
  
  private a()
  {
    b();
  }
  
  public static a a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  public List<InetAddress> a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a != null)
    {
      String[] arrayOfString = this.a.a(paramString);
      localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length > 0)
        {
          paramString = new ArrayList();
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            localObject1 = paramString;
            if (i >= j) {
              break;
            }
            paramString.add(InetAddress.getByName(arrayOfString[i]));
            i += 1;
          }
        }
      }
    }
    return (List<InetAddress>)localObject1;
  }
  
  public void b()
  {
    Object localObject2 = null;
    d locald = com.qiniu.android.dns.b.a.c();
    com.qiniu.android.dns.a.a locala = new com.qiniu.android.dns.a.a();
    try
    {
      com.qiniu.android.dns.b.g localg1 = new com.qiniu.android.dns.b.g(InetAddress.getByName("223.6.6.6"));
      try
      {
        com.qiniu.android.dns.b.g localg2 = new com.qiniu.android.dns.b.g(InetAddress.getByName("114.114.115.115"));
        localObject2 = localg2;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Object localObject1;
          localIOException2.printStackTrace();
        }
      }
      this.a = new b(com.qiniu.android.dns.g.b, new d[] { locala, localg1, localObject2, locald });
      return;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        localIOException1.printStackTrace();
        localObject1 = null;
      }
    }
  }
  
  public String[] b(String paramString)
  {
    int i = 0;
    if (this.a == null)
    {
      paramString = InetAddress.getAllByName(paramString);
      String[] arrayOfString = new String[paramString.length];
      while (i < paramString.length)
      {
        arrayOfString[i] = paramString[i].getHostAddress();
        i += 1;
      }
      return arrayOfString;
    }
    com.xiaoenai.app.utils.f.a.c("############### HostName = {}", new Object[] { paramString });
    try
    {
      paramString = this.a.a(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UnknownHostException(paramString.getMessage());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */