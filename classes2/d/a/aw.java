package d.a;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class aw
{
  public static final String a = System.getProperty("line.separator");
  
  public static String a(InputStream paramInputStream)
  {
    paramInputStream = new InputStreamReader(paramInputStream);
    char[] arrayOfChar = new char['Ѐ'];
    StringWriter localStringWriter = new StringWriter();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (-1 == i) {
        break;
      }
      localStringWriter.write(arrayOfChar, 0, i);
    }
    return localStringWriter.toString();
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject1 = paramString.getBytes();
      Object localObject2 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject2).reset();
      ((MessageDigest)localObject2).update((byte[])localObject1);
      localObject1 = ((MessageDigest)localObject2).digest();
      localObject2 = new StringBuffer();
      while (i < localObject1.length)
      {
        ((StringBuffer)localObject2).append(String.format("%02X", new Object[] { Byte.valueOf(localObject1[i]) }));
        i += 1;
      }
      localObject1 = ((StringBuffer)localObject2).toString();
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return paramString.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
  }
  
  public static void a(File paramFile, String paramString)
  {
    a(paramFile, paramString.getBytes());
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte)
  {
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      paramFile.flush();
      return;
    }
    finally
    {
      a(paramFile);
    }
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (Exception paramOutputStream) {}
  }
  
  public static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i = 0;
      while (i < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      ax.b("helper", "getMD5 error", paramString);
    }
    return "";
  }
  
  public static byte[] b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void c(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */