package com.alibaba.nb.android.trade.utils.http;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  public static String a(InputStream paramInputStream)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      str = new String(((ByteArrayOutputStream)localObject).toByteArray(), "UTF-8");
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
    finally
    {
      a(paramInputStream);
    }
    String str;
    a(paramInputStream);
    return str;
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\http\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */