package com.inmobi.commons.core.utilities.a;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class c
{
  private static final String a = c.class.getSimpleName();
  
  @SuppressLint({"TrulyRandom"})
  public static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    try
    {
      Object localObject1 = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
      Object localObject2 = new BigInteger("010001", 16);
      localObject1 = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec((BigInteger)localObject1, (BigInteger)localObject2));
      localObject2 = Cipher.getInstance("RSA/ECB/nopadding");
      ((Cipher)localObject2).init(1, (Key)localObject1);
      paramString = new String(Base64.encode(a(paramString.getBytes("UTF-8"), 1, (Cipher)localObject2), 0));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", paramString);
      return null;
    }
    catch (NoSuchPaddingException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", paramString);
      return null;
    }
    catch (InvalidKeySpecException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", paramString);
      return null;
    }
    catch (InvalidKeyException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", paramString);
      return null;
    }
    catch (BadPaddingException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", paramString);
      return null;
    }
    catch (IllegalBlockSizeException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", paramString);
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", paramString);
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt, Cipher paramCipher)
  {
    if (paramInt == 1) {}
    int j = paramArrayOfByte.length;
    Object localObject3 = new byte[64];
    Object localObject1 = new byte[0];
    paramInt = 0;
    Object localObject4;
    Object localObject2;
    if (paramInt < j)
    {
      localObject4 = localObject3;
      localObject2 = localObject1;
      if (paramInt > 0)
      {
        localObject4 = localObject3;
        localObject2 = localObject1;
        if (paramInt % 64 == 0)
        {
          localObject2 = a((byte[])localObject1, paramCipher.doFinal((byte[])localObject3));
          if (paramInt + 64 <= j) {
            break label120;
          }
        }
      }
    }
    label120:
    for (int i = j - paramInt;; i = 64)
    {
      localObject4 = new byte[i];
      localObject4[(paramInt % 64)] = paramArrayOfByte[paramInt];
      paramInt += 1;
      localObject3 = localObject4;
      localObject1 = localObject2;
      break;
      return a((byte[])localObject1, paramCipher.doFinal((byte[])localObject3));
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */