package com.ta.utdid2.b.a;

public class e
{
  public static byte[] getBytes(int paramInt)
  {
    int i = (byte)(paramInt % 256);
    paramInt >>= 8;
    int j = (byte)(paramInt % 256);
    paramInt >>= 8;
    int k = (byte)(paramInt % 256);
    return new byte[] { (byte)((paramInt >> 8) % 256), k, j, i };
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */