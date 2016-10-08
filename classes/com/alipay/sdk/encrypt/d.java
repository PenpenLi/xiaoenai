package com.alipay.sdk.encrypt;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class d
{
  public static final String a = "SHA1WithRSA";
  private static final String b = "RSA";
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 23	java/security/spec/X509EncodedKeySpec
    //   5: dup
    //   6: aload_1
    //   7: invokestatic 28	com/alipay/sdk/encrypt/a:a	(Ljava/lang/String;)[B
    //   10: invokespecial 31	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   13: astore_1
    //   14: ldc 11
    //   16: invokestatic 37	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   19: aload_1
    //   20: invokevirtual 41	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   23: astore_3
    //   24: ldc 43
    //   26: invokestatic 48	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   29: astore_1
    //   30: aload_1
    //   31: iconst_1
    //   32: aload_3
    //   33: invokevirtual 52	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   36: aload_0
    //   37: ldc 54
    //   39: invokevirtual 59	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   42: astore_3
    //   43: aload_1
    //   44: invokevirtual 63	javax/crypto/Cipher:getBlockSize	()I
    //   47: istore 6
    //   49: new 65	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: invokespecial 66	java/io/ByteArrayOutputStream:<init>	()V
    //   56: astore_0
    //   57: iconst_0
    //   58: istore 4
    //   60: iload 4
    //   62: aload_3
    //   63: arraylength
    //   64: if_icmpge +43 -> 107
    //   67: aload_3
    //   68: arraylength
    //   69: iload 4
    //   71: isub
    //   72: iload 6
    //   74: if_icmpge +104 -> 178
    //   77: aload_3
    //   78: arraylength
    //   79: iload 4
    //   81: isub
    //   82: istore 5
    //   84: aload_0
    //   85: aload_1
    //   86: aload_3
    //   87: iload 4
    //   89: iload 5
    //   91: invokevirtual 70	javax/crypto/Cipher:doFinal	([BII)[B
    //   94: invokevirtual 73	java/io/ByteArrayOutputStream:write	([B)V
    //   97: iload 4
    //   99: iload 6
    //   101: iadd
    //   102: istore 4
    //   104: goto -44 -> 60
    //   107: new 56	java/lang/String
    //   110: dup
    //   111: aload_0
    //   112: invokevirtual 77	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   115: invokestatic 80	com/alipay/sdk/encrypt/a:a	([B)Ljava/lang/String;
    //   118: invokespecial 83	java/lang/String:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_0
    //   123: invokevirtual 86	java/io/ByteArrayOutputStream:close	()V
    //   126: aload_1
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +44 -> 176
    //   135: aload_0
    //   136: invokevirtual 86	java/io/ByteArrayOutputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: aconst_null
    //   143: areturn
    //   144: astore_0
    //   145: aload_2
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 86	java/io/ByteArrayOutputStream:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: astore_0
    //   158: aload_1
    //   159: areturn
    //   160: astore_1
    //   161: goto -6 -> 155
    //   164: astore_2
    //   165: aload_0
    //   166: astore_1
    //   167: aload_2
    //   168: astore_0
    //   169: goto -22 -> 147
    //   172: astore_1
    //   173: goto -42 -> 131
    //   176: aconst_null
    //   177: areturn
    //   178: iload 6
    //   180: istore 5
    //   182: goto -98 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString1	String
    //   0	185	1	paramString2	String
    //   1	145	2	localObject1	Object
    //   164	4	2	localObject2	Object
    //   23	64	3	localObject3	Object
    //   58	45	4	i	int
    //   82	99	5	j	int
    //   47	132	6	k	int
    // Exception table:
    //   from	to	target	type
    //   2	57	128	java/lang/Exception
    //   135	139	141	java/io/IOException
    //   2	57	144	finally
    //   122	126	157	java/io/IOException
    //   151	155	160	java/io/IOException
    //   60	84	164	finally
    //   84	97	164	finally
    //   107	122	164	finally
    //   60	84	172	java/lang/Exception
    //   84	97	172	java/lang/Exception
    //   107	122	172	java/lang/Exception
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(paramString3)));
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initVerify(paramString3);
      localSignature.update(paramString1.getBytes("utf-8"));
      boolean bool = localSignature.verify(a.a(paramString2));
      return bool;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  private static PublicKey b(String paramString1, String paramString2)
  {
    paramString2 = new X509EncodedKeySpec(a.a(paramString2));
    return KeyFactory.getInstance(paramString1).generatePublic(paramString2);
  }
  
  /* Error */
  private static String c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 109	java/security/spec/PKCS8EncodedKeySpec
    //   5: dup
    //   6: aload_1
    //   7: invokestatic 28	com/alipay/sdk/encrypt/a:a	(Ljava/lang/String;)[B
    //   10: invokespecial 110	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   13: astore_1
    //   14: ldc 11
    //   16: invokestatic 37	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   19: aload_1
    //   20: invokevirtual 114	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   23: astore_3
    //   24: ldc 43
    //   26: invokestatic 48	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   29: astore_1
    //   30: aload_1
    //   31: iconst_2
    //   32: aload_3
    //   33: invokevirtual 52	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   36: aload_0
    //   37: invokestatic 28	com/alipay/sdk/encrypt/a:a	(Ljava/lang/String;)[B
    //   40: astore_3
    //   41: aload_1
    //   42: invokevirtual 63	javax/crypto/Cipher:getBlockSize	()I
    //   45: istore 6
    //   47: new 65	java/io/ByteArrayOutputStream
    //   50: dup
    //   51: invokespecial 66	java/io/ByteArrayOutputStream:<init>	()V
    //   54: astore_0
    //   55: iconst_0
    //   56: istore 4
    //   58: iload 4
    //   60: aload_3
    //   61: arraylength
    //   62: if_icmpge +43 -> 105
    //   65: aload_3
    //   66: arraylength
    //   67: iload 4
    //   69: isub
    //   70: iload 6
    //   72: if_icmpge +101 -> 173
    //   75: aload_3
    //   76: arraylength
    //   77: iload 4
    //   79: isub
    //   80: istore 5
    //   82: aload_0
    //   83: aload_1
    //   84: aload_3
    //   85: iload 4
    //   87: iload 5
    //   89: invokevirtual 70	javax/crypto/Cipher:doFinal	([BII)[B
    //   92: invokevirtual 73	java/io/ByteArrayOutputStream:write	([B)V
    //   95: iload 4
    //   97: iload 6
    //   99: iadd
    //   100: istore 4
    //   102: goto -44 -> 58
    //   105: new 56	java/lang/String
    //   108: dup
    //   109: aload_0
    //   110: invokevirtual 77	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: invokespecial 115	java/lang/String:<init>	([B)V
    //   116: astore_1
    //   117: aload_0
    //   118: invokevirtual 86	java/io/ByteArrayOutputStream:close	()V
    //   121: aload_1
    //   122: areturn
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +44 -> 171
    //   130: aload_0
    //   131: invokevirtual 86	java/io/ByteArrayOutputStream:close	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_2
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 86	java/io/ByteArrayOutputStream:close	()V
    //   150: aload_0
    //   151: athrow
    //   152: astore_0
    //   153: aload_1
    //   154: areturn
    //   155: astore_1
    //   156: goto -6 -> 150
    //   159: astore_2
    //   160: aload_0
    //   161: astore_1
    //   162: aload_2
    //   163: astore_0
    //   164: goto -22 -> 142
    //   167: astore_1
    //   168: goto -42 -> 126
    //   171: aconst_null
    //   172: areturn
    //   173: iload 6
    //   175: istore 5
    //   177: goto -95 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString1	String
    //   0	180	1	paramString2	String
    //   1	140	2	localObject1	Object
    //   159	4	2	localObject2	Object
    //   23	62	3	localObject3	Object
    //   56	45	4	i	int
    //   80	96	5	j	int
    //   45	129	6	k	int
    // Exception table:
    //   from	to	target	type
    //   2	55	123	java/lang/Exception
    //   130	134	136	java/io/IOException
    //   2	55	139	finally
    //   117	121	152	java/io/IOException
    //   146	150	155	java/io/IOException
    //   58	82	159	finally
    //   82	95	159	finally
    //   105	117	159	finally
    //   58	82	167	java/lang/Exception
    //   82	95	167	java/lang/Exception
    //   105	117	167	java/lang/Exception
  }
  
  private static String d(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new PKCS8EncodedKeySpec(a.a(paramString2));
      paramString2 = KeyFactory.getInstance("RSA").generatePrivate(paramString2);
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initSign(paramString2);
      localSignature.update(paramString1.getBytes("utf-8"));
      paramString1 = a.a(localSignature.sign());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\encrypt\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */