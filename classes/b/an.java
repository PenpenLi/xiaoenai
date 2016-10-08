package b;

import b.a.j;
import c.g;
import java.io.File;
import java.nio.charset.Charset;

public abstract class an
{
  public static an a(ae paramae, File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("content == null");
    }
    return new ap(paramae, paramFile);
  }
  
  public static an a(ae paramae, String paramString)
  {
    Object localObject = j.c;
    ae localae = paramae;
    if (paramae != null)
    {
      Charset localCharset = paramae.b();
      localObject = localCharset;
      localae = paramae;
      if (localCharset == null)
      {
        localObject = j.c;
        localae = ae.a(paramae + "; charset=utf-8");
      }
    }
    return a(localae, paramString.getBytes((Charset)localObject));
  }
  
  public static an a(ae paramae, byte[] paramArrayOfByte)
  {
    return a(paramae, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static an a(ae paramae, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    j.a(paramArrayOfByte.length, paramInt1, paramInt2);
    return new ao(paramae, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  public abstract ae a();
  
  public abstract void a(g paramg);
  
  public long b()
  {
    return -1L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */