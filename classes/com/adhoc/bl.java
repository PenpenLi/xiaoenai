package com.adhoc;

import java.nio.charset.Charset;

public abstract class bl
{
  public static bl a(bf parambf, String paramString)
  {
    Object localObject = cb.c;
    bf localbf = parambf;
    if (parambf != null)
    {
      Charset localCharset = parambf.a();
      localObject = localCharset;
      localbf = parambf;
      if (localCharset == null)
      {
        localObject = cb.c;
        localbf = bf.a(parambf + "; charset=utf-8");
      }
    }
    return a(localbf, paramString.getBytes((Charset)localObject));
  }
  
  public static bl a(bf parambf, byte[] paramArrayOfByte)
  {
    return a(parambf, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static bl a(bf parambf, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    cb.a(paramArrayOfByte.length, paramInt1, paramInt2);
    return new bm(parambf, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  public abstract bf a();
  
  public abstract void a(ep paramep);
  
  public long b()
  {
    return -1L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */