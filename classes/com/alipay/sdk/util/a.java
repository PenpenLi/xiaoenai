package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;

public final class a
{
  public static String[] a(String paramString)
  {
    int i = paramString.indexOf('(') + 1;
    int j = paramString.lastIndexOf(')');
    if ((i == 0) || (j == -1)) {
      return null;
    }
    paramString = paramString.substring(i, j).split(",");
    if (paramString != null)
    {
      i = 0;
      while (i < paramString.length)
      {
        if (!TextUtils.isEmpty(paramString[i]))
        {
          paramString[i] = paramString[i].trim();
          paramString[i] = paramString[i].replaceAll("'", "").replaceAll("\"", "");
        }
        i += 1;
      }
    }
    return paramString;
  }
  
  private static void b(String paramString)
  {
    paramString = a(paramString);
    if (paramString.length != 3) {}
    Context localContext;
    com.alipay.sdk.tid.b localb;
    do
    {
      do
      {
        return;
      } while (!TextUtils.equals("tid", paramString[0]));
      localContext = com.alipay.sdk.sys.b.a().a;
      localb = com.alipay.sdk.tid.b.a();
    } while ((TextUtils.isEmpty(paramString[1])) || (TextUtils.isEmpty(paramString[2])));
    localb.a = paramString[1];
    localb.b = paramString[2];
    paramString = new com.alipay.sdk.tid.a(localContext);
    try
    {
      paramString.a(b.a(localContext).a(), b.a(localContext).b(), localb.a, localb.b);
      paramString.close();
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      paramString.close();
      return;
    }
    finally
    {
      localObject = finally;
      paramString.close();
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */