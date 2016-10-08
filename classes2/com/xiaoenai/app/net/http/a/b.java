package com.xiaoenai.app.net.http.a;

import b.u;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

class b
  implements u
{
  b(a parama) {}
  
  public List<InetAddress> a(String paramString)
  {
    if (paramString == null) {
      throw new UnknownHostException("hostname == null");
    }
    try
    {
      List localList = com.xiaoenai.app.net.a.a.a().a(paramString);
      return localList;
    }
    catch (IOException localIOException) {}
    return u.b.a(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */