package com.alipay.sdk.tid;

import android.content.Context;
import android.text.TextUtils;

public final class b
{
  private static b c;
  public String a;
  public String b;
  
  public static b a()
  {
    try
    {
      if (c == null)
      {
        c = new b();
        localObject1 = com.alipay.sdk.sys.b.a().a;
        a locala = new a((Context)localObject1);
        String str2 = com.alipay.sdk.util.b.a((Context)localObject1).a();
        String str3 = com.alipay.sdk.util.b.a((Context)localObject1).b();
        c.a = locala.b(str2, str3);
        c.b = locala.c(str2, str3);
        if (TextUtils.isEmpty(c.b))
        {
          b localb = c;
          String str1 = Long.toHexString(System.currentTimeMillis());
          localObject1 = str1;
          if (str1.length() > 10) {
            localObject1 = str1.substring(str1.length() - 10);
          }
          localb.b = ((String)localObject1);
        }
        locala.a(str2, str3, c.a, c.b);
      }
      Object localObject1 = c;
      return (b)localObject1;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    a locala = new a(paramContext);
    try
    {
      locala.a(com.alipay.sdk.util.b.a(paramContext).a(), com.alipay.sdk.util.b.a(paramContext).b(), this.a, this.b);
      locala.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      locala.close();
      return;
    }
    finally
    {
      paramContext = finally;
      locala.close();
      throw paramContext;
    }
  }
  
  private void a(String paramString)
  {
    this.a = paramString;
  }
  
  private String b()
  {
    return this.a;
  }
  
  private void b(String paramString)
  {
    this.b = paramString;
  }
  
  private String c()
  {
    return this.b;
  }
  
  private boolean d()
  {
    return TextUtils.isEmpty(this.a);
  }
  
  private static void e()
  {
    Object localObject = com.alipay.sdk.sys.b.a().a;
    String str1 = com.alipay.sdk.util.b.a((Context)localObject).a();
    String str2 = com.alipay.sdk.util.b.a((Context)localObject).b();
    localObject = new a((Context)localObject);
    ((a)localObject).a(str1, str2);
    ((a)localObject).close();
  }
  
  private static String f()
  {
    String str2 = Long.toHexString(System.currentTimeMillis());
    String str1 = str2;
    if (str2.length() > 10) {
      str1 = str2.substring(str2.length() - 10);
    }
    return str1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\tid\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */