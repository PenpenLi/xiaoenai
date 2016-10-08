package com.alipay.sdk.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class f
{
  private static final boolean a = false;
  
  private static String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  private static void a() {}
  
  private static void a(Object paramObject)
  {
    if (!(paramObject instanceof Exception)) {}
  }
  
  private static void b() {}
  
  private static void c() {}
  
  private static void d() {}
  
  private static void e() {}
  
  private static void f() {}
  
  private static void g() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */