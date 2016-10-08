package com.adhoc;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class ex
{
  private static final Logger a = Logger.getLogger(ex.class.getName());
  
  public static ep a(ff paramff)
  {
    if (paramff == null) {
      throw new IllegalArgumentException("sink == null");
    }
    return new fb(paramff);
  }
  
  public static eq a(fg paramfg)
  {
    if (paramfg == null) {
      try
      {
        throw new IllegalArgumentException("source == null");
      }
      catch (Throwable paramfg)
      {
        fl.a(paramfg);
        return null;
      }
    }
    paramfg = new fc(paramfg);
    return paramfg;
  }
  
  private static ff a(OutputStream paramOutputStream, fh paramfh)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramfh == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new ey(paramfh, paramOutputStream);
  }
  
  public static ff a(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    ek localek = c(paramSocket);
    return localek.a(a(paramSocket.getOutputStream(), localek));
  }
  
  private static fg a(InputStream paramInputStream, fh paramfh)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramfh == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new ez(paramfh, paramInputStream);
  }
  
  public static fg b(Socket paramSocket)
  {
    if (paramSocket == null) {
      try
      {
        throw new IllegalArgumentException("socket == null");
      }
      catch (Throwable paramSocket)
      {
        fl.a(paramSocket);
        return null;
      }
    }
    ek localek = c(paramSocket);
    paramSocket = localek.a(a(paramSocket.getInputStream(), localek));
    return paramSocket;
  }
  
  private static ek c(Socket paramSocket)
  {
    return new fa(paramSocket);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */