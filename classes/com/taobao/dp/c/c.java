package com.taobao.dp.c;

public final class c
{
  private static byte a = -78;
  
  public static byte a(byte[] paramArrayOfByte)
  {
    int i = -51;
    int j;
    if (paramArrayOfByte.length > 0) {
      j = -51;
    }
    int k;
    for (i = 0;; i = k)
    {
      k = i + 1;
      i = (byte)(paramArrayOfByte[i] ^ j);
      j = 0;
      if (j < 8)
      {
        if ((i & 0x1) > 0) {
          i = i >> 1 ^ a;
        }
        for (;;)
        {
          i = (byte)i;
          j += 1;
          break;
          i >>= 1;
        }
      }
      if (k >= paramArrayOfByte.length) {
        return (byte)(i ^ 0xFF);
      }
      j = i;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */