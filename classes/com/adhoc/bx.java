package com.adhoc;

import java.net.InetAddress;
import java.net.UnknownHostException;

final class bx
  implements bw
{
  public InetAddress[] a(String paramString)
  {
    if (paramString == null) {
      throw new UnknownHostException("host == null");
    }
    return InetAddress.getAllByName(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */