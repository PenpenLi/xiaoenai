package com.xiaoenai.app.utils.d;

import java.io.UnsupportedEncodingException;

public final class g
{
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Parameter may not be null");
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("charset may not be null or empty");
    }
    try
    {
      paramString = new String(paramArrayOfByte, paramInt1, paramInt2, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return new String(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Parameter may not be null");
    }
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */