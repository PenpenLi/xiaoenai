package com.taobao.dp.c;

public final class d
{
  public static String a(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + "0" + str2;; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toLowerCase();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */