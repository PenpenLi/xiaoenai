package d.a;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

public class au
{
  public static int a;
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte[' '];
    a = 0;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        while (!localDeflater.finished())
        {
          int i = localDeflater.deflate(paramArrayOfByte);
          a += i;
          localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
        }
        if (localByteArrayOutputStream == null) {
          break label86;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        ByteArrayOutputStream localByteArrayOutputStream = null;
      }
    }
    localByteArrayOutputStream.close();
    label86:
    throw paramArrayOfByte;
    localDeflater.end();
    if (localByteArrayOutputStream != null) {
      localByteArrayOutputStream.close();
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */