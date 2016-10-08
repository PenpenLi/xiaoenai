package c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class p
{
  private static final Logger a = Logger.getLogger(p.class.getName());
  
  public static g a(y paramy)
  {
    if (paramy == null) {
      throw new IllegalArgumentException("sink == null");
    }
    return new t(paramy);
  }
  
  public static h a(z paramz)
  {
    if (paramz == null) {
      throw new IllegalArgumentException("source == null");
    }
    return new u(paramz);
  }
  
  public static y a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, new aa());
  }
  
  private static y a(OutputStream paramOutputStream, aa paramaa)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramaa == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new q(paramaa, paramOutputStream);
  }
  
  public static y a(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    a locala = c(paramSocket);
    return locala.a(a(paramSocket.getOutputStream(), locala));
  }
  
  public static z a(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return a(new FileInputStream(paramFile));
  }
  
  public static z a(InputStream paramInputStream)
  {
    return a(paramInputStream, new aa());
  }
  
  private static z a(InputStream paramInputStream, aa paramaa)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramaa == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    return new r(paramaa, paramInputStream);
  }
  
  public static y b(File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return a(new FileOutputStream(paramFile));
  }
  
  public static z b(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    a locala = c(paramSocket);
    return locala.a(a(paramSocket.getInputStream(), locala));
  }
  
  private static a c(Socket paramSocket)
  {
    return new s(paramSocket);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */