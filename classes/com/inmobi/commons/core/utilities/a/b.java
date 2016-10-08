package com.inmobi.commons.core.utilities.a;

import android.annotation.SuppressLint;
import android.util.Base64;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  private static final String a = b.class.getSimpleName();
  private static String b = "AES";
  private static String c = "AES/CBC/PKCS7Padding";
  private static byte[] d;
  
  public static String a(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = b(paramString1.getBytes("UTF-8"), paramArrayOfByte1, paramArrayOfByte2);
      byte[] arrayOfByte = a(paramString1, paramArrayOfByte3);
      paramString1 = a(paramString1);
      arrayOfByte = a(arrayOfByte);
      paramArrayOfByte2 = a(paramArrayOfByte2);
      paramString1 = new String(Base64.encode(b(a(a(b(b(a(paramArrayOfByte1), a(paramArrayOfByte3)), paramArrayOfByte2), paramString3, paramString2)), b(paramString1, arrayOfByte)), 8));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a()
  {
    byte[] arrayOfByte = new byte[16];
    try
    {
      SecureRandom.getInstance("SHA1PRNG", "Crypto").nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return arrayOfByte;
    }
    catch (NoSuchProviderException localNoSuchProviderException)
    {
      localNoSuchProviderException.printStackTrace();
    }
    return arrayOfByte;
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    new SecureRandom().nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    long l = paramArrayOfByte.length;
    Object localObject = ByteBuffer.allocate(8);
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject).putLong(l);
    localObject = ((ByteBuffer)localObject).array();
    byte[] arrayOfByte = new byte[localObject.length + paramArrayOfByte.length];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, localObject.length, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramString2 = new BigInteger(paramString2, 16);
    paramString1 = new BigInteger(paramString1, 16);
    try
    {
      paramString1 = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(paramString2, paramString1));
      paramString2 = Cipher.getInstance("RSA/ECB/nopadding");
      paramString2.init(1, paramString1);
      paramArrayOfByte = paramString2.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (InvalidKeySpecException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, 0, paramArrayOfByte2.length, "HmacSHA1");
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(paramArrayOfByte2);
      paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, b);
    try
    {
      Cipher localCipher = Cipher.getInstance(c);
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec(paramArrayOfByte3));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", paramArrayOfByte1);
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", paramArrayOfByte1);
      return null;
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", paramArrayOfByte1);
      return null;
    }
    catch (IllegalBlockSizeException paramArrayOfByte1)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", paramArrayOfByte1);
      return null;
    }
    catch (BadPaddingException paramArrayOfByte1)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", paramArrayOfByte1);
      return null;
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", paramArrayOfByte1);
    }
    return null;
  }
  
  /* Error */
  public static byte[] b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 216	com/inmobi/commons/core/utilities/a/a
    //   6: dup
    //   7: invokespecial 217	com/inmobi/commons/core/utilities/a/a:<init>	()V
    //   10: astore_0
    //   11: invokestatic 221	java/lang/System:currentTimeMillis	()J
    //   14: ldc2_w 222
    //   17: ldiv
    //   18: aload_0
    //   19: invokevirtual 225	com/inmobi/commons/core/utilities/a/a:c	()J
    //   22: lsub
    //   23: ldc2_w 226
    //   26: lcmp
    //   27: ifle +29 -> 56
    //   30: invokestatic 229	com/inmobi/commons/core/utilities/a/b:a	()[B
    //   33: putstatic 231	com/inmobi/commons/core/utilities/a/b:d	[B
    //   36: aload_0
    //   37: getstatic 231	com/inmobi/commons/core/utilities/a/b:d	[B
    //   40: iconst_0
    //   41: invokestatic 235	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   44: invokevirtual 238	com/inmobi/commons/core/utilities/a/a:a	(Ljava/lang/String;)V
    //   47: getstatic 231	com/inmobi/commons/core/utilities/a/b:d	[B
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: areturn
    //   56: getstatic 231	com/inmobi/commons/core/utilities/a/b:d	[B
    //   59: ifnonnull -12 -> 47
    //   62: aload_0
    //   63: invokevirtual 240	com/inmobi/commons/core/utilities/a/a:b	()Ljava/lang/String;
    //   66: astore_1
    //   67: aload_1
    //   68: iconst_0
    //   69: invokestatic 244	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   72: putstatic 231	com/inmobi/commons/core/utilities/a/b:d	[B
    //   75: goto -28 -> 47
    //   78: astore_1
    //   79: getstatic 205	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   82: getstatic 20	com/inmobi/commons/core/utilities/a/b:a	Ljava/lang/String;
    //   85: ldc -10
    //   87: aload_1
    //   88: invokestatic 212	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: invokestatic 229	com/inmobi/commons/core/utilities/a/b:a	()[B
    //   94: putstatic 231	com/inmobi/commons/core/utilities/a/b:d	[B
    //   97: aload_0
    //   98: getstatic 231	com/inmobi/commons/core/utilities/a/b:d	[B
    //   101: iconst_0
    //   102: invokestatic 235	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   105: invokevirtual 238	com/inmobi/commons/core/utilities/a/a:a	(Ljava/lang/String;)V
    //   108: goto -61 -> 47
    //   111: astore_0
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	88	0	localObject1	Object
    //   111	5	0	localObject2	Object
    //   66	2	1	str	String
    //   78	10	1	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   67	75	78	java/lang/IllegalArgumentException
    //   3	47	111	finally
    //   47	51	111	finally
    //   56	67	111	finally
    //   67	75	111	finally
    //   79	108	111	finally
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  @SuppressLint({"TrulyRandom"})
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, b);
    paramArrayOfByte3 = new IvParameterSpec(paramArrayOfByte3);
    try
    {
      Cipher localCipher = Cipher.getInstance(c);
      localCipher.init(1, paramArrayOfByte2, paramArrayOfByte3);
      localCipher.init(1, paramArrayOfByte2, paramArrayOfByte3);
      localCipher.init(1, paramArrayOfByte2, paramArrayOfByte3);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (IllegalBlockSizeException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (BadPaddingException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */