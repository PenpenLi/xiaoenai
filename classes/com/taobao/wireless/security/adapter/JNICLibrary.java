package com.taobao.wireless.security.adapter;

public class JNICLibrary
{
  private static JNICLibrary a;
  
  public static JNICLibrary a()
  {
    if (a == null) {
      a = new JNICLibrary();
    }
    return a;
  }
  
  public final String a(String paramString1, String paramString2, int paramInt)
  {
    return (String)doCommandNative(301, new int[] { paramInt }, new String[] { paramString1, paramString2 }, null, null);
  }
  
  public final byte[] a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    return (byte[])doCommandNative(a.a, new int[] { paramInt3, paramInt1, paramInt2 }, new String[] { paramString }, new byte[][] { paramArrayOfByte1, paramArrayOfByte2 }, null);
  }
  
  public final byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return (byte[])doCommandNative(700, new int[] { paramInt1, paramInt2 }, null, new byte[][] { paramArrayOfByte1, paramArrayOfByte2 }, null);
  }
  
  public final byte[] a(int paramInt1, String paramString, String[] paramArrayOfString, int paramInt2)
  {
    return (byte[])doCommandNative(300, new int[] { paramInt1, paramInt2 }, new String[] { paramString }, null, new Object[] { paramArrayOfString });
  }
  
  public native Object doCommandNative(int paramInt, int[] paramArrayOfInt, String[] paramArrayOfString, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\JNICLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */