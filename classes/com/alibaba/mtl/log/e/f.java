package com.alibaba.mtl.log.e;

public class f
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */