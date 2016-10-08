package b.a.b;

import b.a.h;
import b.al;
import b.aq;
import b.z;

public final class o
{
  static final String a = h.a().b();
  public static final String b = a + "-Sent-Millis";
  public static final String c = a + "-Received-Millis";
  public static final String d = a + "-Selected-Protocol";
  public static final String e = a + "-Response-Source";
  
  public static long a(al paramal)
  {
    return a(paramal.c());
  }
  
  public static long a(aq paramaq)
  {
    return a(paramaq.f());
  }
  
  public static long a(z paramz)
  {
    return b(paramz.a("Content-Length"));
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  private static long b(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */