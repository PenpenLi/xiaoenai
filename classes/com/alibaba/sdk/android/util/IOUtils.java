package com.alibaba.sdk.android.util;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils
{
  private static final String TAG = IOUtils.class.getSimpleName();
  
  public static void closeQuietly(Closeable paramCloseable)
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
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    for (;;)
    {
      int i;
      if (!Thread.interrupted())
      {
        i = paramInputStream.read(arrayOfByte, 0, paramInt);
        if (i != -1) {}
      }
      else
      {
        paramOutputStream.flush();
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramInputStream)
    {
      Log.e(TAG, null, paramInputStream);
      return null;
    }
  }
  
  public static String toString(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        paramString.write(arrayOfByte, 0, i);
      }
      paramString = new String(paramString.toByteArray(), "UTF-8");
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
    finally
    {
      closeQuietly(paramInputStream);
    }
    closeQuietly(paramInputStream);
    return paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */