package com.taobao.dp.a;

import android.os.Build.VERSION;
import com.taobao.dp.c.d;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class a
{
  private static a a = null;
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public static String a(String paramString)
  {
    String str = b();
    Object localObject2 = KeyGenerator.getInstance("AES");
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
      ((SecureRandom)localObject1).setSeed(str.getBytes());
    }
    for (;;)
    {
      ((KeyGenerator)localObject2).init(128, (SecureRandom)localObject1);
      localObject1 = new SecretKeySpec(((KeyGenerator)localObject2).generateKey().getEncoded(), "AES");
      localObject2 = Cipher.getInstance("AES");
      paramString = paramString.getBytes("utf-8");
      ((Cipher)localObject2).init(1, (Key)localObject1);
      return d.a(((Cipher)localObject2).doFinal(paramString));
      localObject1 = new SecureRandom(str.getBytes());
    }
  }
  
  private static String b()
  {
    int[] arrayOfInt = new int[32];
    arrayOfInt[0] = 76;
    arrayOfInt[1] = 58;
    arrayOfInt[2] = 79;
    arrayOfInt[3] = 79;
    arrayOfInt[4] = 60;
    arrayOfInt[5] = 75;
    arrayOfInt[6] = 61;
    arrayOfInt[7] = 72;
    arrayOfInt[8] = 75;
    arrayOfInt[9] = 78;
    arrayOfInt[10] = 61;
    arrayOfInt[11] = 79;
    arrayOfInt[12] = 78;
    arrayOfInt[13] = 60;
    arrayOfInt[14] = 62;
    arrayOfInt[15] = 72;
    arrayOfInt[16] = 64;
    arrayOfInt[17] = 77;
    arrayOfInt[18] = 76;
    arrayOfInt[19] = 75;
    arrayOfInt[20] = 64;
    arrayOfInt[21] = 74;
    arrayOfInt[22] = 59;
    arrayOfInt[23] = 78;
    arrayOfInt[24] = 76;
    arrayOfInt[25] = 64;
    arrayOfInt[26] = 72;
    arrayOfInt[27] = 77;
    arrayOfInt[28] = 73;
    arrayOfInt[29] = 58;
    arrayOfInt[30] = 59;
    arrayOfInt[31] = 72;
    arrayOfInt;
    char[] arrayOfChar1 = new char[2];
    char[] tmp198_197 = arrayOfChar1;
    tmp198_197[0] = 120;
    char[] tmp203_198 = tmp198_197;
    tmp203_198[1] = 121;
    tmp203_198;
    char[] arrayOfChar2 = new char[32];
    int i = 0;
    if (i < 32)
    {
      if (i < 16) {
        arrayOfChar2[i] = ((char)(arrayOfInt[i] ^ arrayOfChar1[0]));
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfChar2[i] = ((char)(arrayOfInt[i] ^ arrayOfChar1[1]));
      }
    }
    return new String(arrayOfChar2);
  }
  
  public static String b(String paramString)
  {
    byte[] arrayOfByte = null;
    Object localObject = b();
    KeyGenerator localKeyGenerator;
    if (paramString == null)
    {
      localKeyGenerator = KeyGenerator.getInstance("AES");
      if (Build.VERSION.SDK_INT < 17) {
        break label160;
      }
      paramString = SecureRandom.getInstance("SHA1PRNG", "Crypto");
      paramString.setSeed(((String)localObject).getBytes());
    }
    for (;;)
    {
      localKeyGenerator.init(128, paramString);
      paramString = new SecretKeySpec(localKeyGenerator.generateKey().getEncoded(), "AES");
      localObject = Cipher.getInstance("AES");
      ((Cipher)localObject).init(2, paramString);
      return new String(((Cipher)localObject).doFinal(arrayOfByte));
      int j = paramString.length();
      if (j % 2 != 0) {
        break;
      }
      arrayOfByte = new byte[j / 2];
      int i = 0;
      while (i != j / 2)
      {
        arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
        i += 1;
      }
      break;
      label160:
      paramString = new SecureRandom(((String)localObject).getBytes());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */