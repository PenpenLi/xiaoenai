package com.taobao.dp.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class d
{
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
      ZipEntry localZipEntry = new ZipEntry("zip");
      localZipEntry.setSize(paramArrayOfByte.length);
      localZipOutputStream.putNextEntry(localZipEntry);
      localZipOutputStream.write(paramArrayOfByte);
      localZipOutputStream.closeEntry();
      localZipOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localByteArrayOutputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
      paramArrayOfByte = null;
    }
    return paramArrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    ZipInputStream localZipInputStream = null;
    ByteArrayOutputStream localByteArrayOutputStream = null;
    Object localObject = localZipInputStream;
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      localObject = localZipInputStream;
      localZipInputStream = new ZipInputStream(localByteArrayInputStream);
      paramArrayOfByte = localByteArrayOutputStream;
      for (;;)
      {
        localObject = paramArrayOfByte;
        if (localZipInputStream.getNextEntry() == null) {
          break;
        }
        localObject = paramArrayOfByte;
        byte[] arrayOfByte = new byte['Ѐ'];
        localObject = paramArrayOfByte;
        localByteArrayOutputStream = new ByteArrayOutputStream();
        for (;;)
        {
          localObject = paramArrayOfByte;
          int i = localZipInputStream.read(arrayOfByte, 0, 1024);
          if (i == -1) {
            break;
          }
          localObject = paramArrayOfByte;
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        localObject = paramArrayOfByte;
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localObject = paramArrayOfByte;
        localByteArrayOutputStream.flush();
        localObject = paramArrayOfByte;
        localByteArrayOutputStream.close();
      }
      localObject = paramArrayOfByte;
      localZipInputStream.close();
      localObject = paramArrayOfByte;
      localByteArrayInputStream.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return (byte[])localObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */