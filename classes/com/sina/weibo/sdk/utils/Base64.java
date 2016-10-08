package com.sina.weibo.sdk.utils;

public final class Base64
{
  private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
  private static byte[] codes = new byte['Ā'];
  
  static
  {
    int i = 0;
    if (i >= 256)
    {
      i = 65;
      label28:
      if (i <= 90) {
        break label82;
      }
      i = 97;
      label37:
      if (i <= 122) {
        break label99;
      }
      i = 48;
    }
    for (;;)
    {
      if (i > 57)
      {
        codes[43] = 62;
        codes[47] = 63;
        return;
        codes[i] = -1;
        i += 1;
        break;
        label82:
        codes[i] = ((byte)(i - 65));
        i += 1;
        break label28;
        label99:
        codes[i] = ((byte)(i + 26 - 97));
        i += 1;
        break label37;
      }
      codes[i] = ((byte)(i + 52 - 48));
      i += 1;
    }
  }
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    int m = 0;
    int j = (paramArrayOfByte.length + 3) / 4 * 3;
    int i = j;
    if (paramArrayOfByte.length > 0)
    {
      i = j;
      if (paramArrayOfByte[(paramArrayOfByte.length - 1)] == 61) {
        i = j - 1;
      }
    }
    j = i;
    if (paramArrayOfByte.length > 1)
    {
      j = i;
      if (paramArrayOfByte[(paramArrayOfByte.length - 2)] == 61) {
        j = i - 1;
      }
    }
    byte[] arrayOfByte = new byte[j];
    int k = 0;
    int n = 0;
    int i1 = 0;
    if (k >= paramArrayOfByte.length)
    {
      if (m != arrayOfByte.length) {
        throw new RuntimeException("miscalculated data length!");
      }
    }
    else
    {
      int i3 = codes[(paramArrayOfByte[k] & 0xFF)];
      i2 = m;
      i = n;
      j = i1;
      if (i3 >= 0)
      {
        j = i1 + 6;
        i = n << 6 | i3;
        if (j < 8) {
          break label192;
        }
        j -= 8;
        arrayOfByte[m] = ((byte)(i >> j & 0xFF));
      }
    }
    label192:
    for (int i2 = m + 1;; i2 = m)
    {
      k += 1;
      m = i2;
      n = i;
      i1 = j;
      break;
      return arrayOfByte;
    }
  }
  
  public static char[] encode(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[(paramArrayOfByte.length + 2) / 3 * 4];
    int i = 0;
    int j = 0;
    if (j >= paramArrayOfByte.length) {
      return arrayOfChar1;
    }
    int m = (paramArrayOfByte[j] & 0xFF) << 8;
    if (j + 1 < paramArrayOfByte.length) {
      m |= paramArrayOfByte[(j + 1)] & 0xFF;
    }
    for (int k = 1;; k = 0)
    {
      m <<= 8;
      if (j + 2 < paramArrayOfByte.length) {
        m |= paramArrayOfByte[(j + 2)] & 0xFF;
      }
      for (int n = 1;; n = 0)
      {
        char[] arrayOfChar2 = alphabet;
        if (n != 0)
        {
          n = m & 0x3F;
          label115:
          arrayOfChar1[(i + 3)] = arrayOfChar2[n];
          m >>= 6;
          arrayOfChar2 = alphabet;
          if (k == 0) {
            break label214;
          }
        }
        label214:
        for (k = m & 0x3F;; k = 64)
        {
          arrayOfChar1[(i + 2)] = arrayOfChar2[k];
          k = m >> 6;
          arrayOfChar1[(i + 1)] = alphabet[(k & 0x3F)];
          arrayOfChar1[(i + 0)] = alphabet[(k >> 6 & 0x3F)];
          j += 3;
          i += 4;
          break;
          n = 64;
          break label115;
        }
      }
    }
  }
  
  public static byte[] encodebyte(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfByte.length + 2) / 3 * 4];
    int i = 0;
    int j = 0;
    if (j >= paramArrayOfByte.length) {
      return arrayOfByte;
    }
    int m = (paramArrayOfByte[j] & 0xFF) << 8;
    if (j + 1 < paramArrayOfByte.length) {
      m |= paramArrayOfByte[(j + 1)] & 0xFF;
    }
    for (int k = 1;; k = 0)
    {
      m <<= 8;
      if (j + 2 < paramArrayOfByte.length) {
        m |= paramArrayOfByte[(j + 2)] & 0xFF;
      }
      for (int n = 1;; n = 0)
      {
        char[] arrayOfChar = alphabet;
        if (n != 0)
        {
          n = m & 0x3F;
          label115:
          arrayOfByte[(i + 3)] = ((byte)arrayOfChar[n]);
          m >>= 6;
          arrayOfChar = alphabet;
          if (k == 0) {
            break label218;
          }
        }
        label218:
        for (k = m & 0x3F;; k = 64)
        {
          arrayOfByte[(i + 2)] = ((byte)arrayOfChar[k]);
          k = m >> 6;
          arrayOfByte[(i + 1)] = ((byte)alphabet[(k & 0x3F)]);
          arrayOfByte[(i + 0)] = ((byte)alphabet[(k >> 6 & 0x3F)]);
          j += 3;
          i += 4;
          break;
          n = 64;
          break label115;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */