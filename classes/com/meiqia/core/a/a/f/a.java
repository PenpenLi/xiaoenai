package com.meiqia.core.a.a.f;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class a
{
  private static final byte[] b;
  private static final byte[] c;
  private static final byte[] d;
  private static final byte[] e;
  private static final byte[] f;
  private static final byte[] g;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      c = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      d = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      f = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      g = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      if ((!a) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = (byte[])localObject;
      } while (a);
      throw new AssertionError(localIOException.getMessage());
    }
    return paramArrayOfByte;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(paramArrayOfByte);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = 0;
    byte[] arrayOfByte = b(paramInt4);
    if (paramInt2 > 0)
    {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label25:
      if (paramInt2 <= 1) {
        break label104;
      }
    }
    label104:
    for (int i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; i = 0)
    {
      if (paramInt2 > 2) {
        j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = j | i | paramInt4;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        paramInt4 = 0;
        break label25;
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  private static int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null) {
      throw new NullPointerException("Source array was null.");
    }
    if (paramArrayOfByte2 == null) {
      throw new NullPointerException("Destination array was null.");
    }
    if ((paramInt1 < 0) || (paramInt1 + 3 >= paramArrayOfByte1.length)) {
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfByte1.length), Integer.valueOf(paramInt1) }));
    }
    if ((paramInt2 < 0) || (paramInt2 + 2 >= paramArrayOfByte2.length)) {
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfByte2.length), Integer.valueOf(paramInt2) }));
    }
    byte[] arrayOfByte = c(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6 | arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]] & 0xFF;
    paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  private static final byte[] b(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return d;
    }
    if ((paramInt & 0x20) == 32) {
      return f;
    }
    return b;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: ifnonnull +13 -> 20
    //   10: new 206	java/lang/NullPointerException
    //   13: dup
    //   14: ldc -22
    //   16: invokespecial 211	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: iload_1
    //   21: ifge +30 -> 51
    //   24: new 215	java/lang/IllegalArgumentException
    //   27: dup
    //   28: new 236	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   35: ldc -17
    //   37: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_1
    //   41: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 228	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: iload_2
    //   52: ifge +30 -> 82
    //   55: new 215	java/lang/IllegalArgumentException
    //   58: dup
    //   59: new 236	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   66: ldc -5
    //   68: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 228	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: iload_1
    //   83: iload_2
    //   84: iadd
    //   85: aload_0
    //   86: arraylength
    //   87: if_icmple +42 -> 129
    //   90: new 215	java/lang/IllegalArgumentException
    //   93: dup
    //   94: ldc -3
    //   96: iconst_3
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: iload_1
    //   103: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: iload_2
    //   110: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: aload_0
    //   117: arraylength
    //   118: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 227	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   125: invokespecial 228	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   128: athrow
    //   129: iload_3
    //   130: iconst_2
    //   131: iand
    //   132: ifeq +116 -> 248
    //   135: new 255	java/io/ByteArrayOutputStream
    //   138: dup
    //   139: invokespecial 256	java/io/ByteArrayOutputStream:<init>	()V
    //   142: astore 4
    //   144: new 6	com/meiqia/core/a/a/f/a$a
    //   147: dup
    //   148: aload 4
    //   150: iload_3
    //   151: iconst_1
    //   152: ior
    //   153: invokespecial 259	com/meiqia/core/a/a/f/a$a:<init>	(Ljava/io/OutputStream;I)V
    //   156: astore 6
    //   158: new 261	java/util/zip/GZIPOutputStream
    //   161: dup
    //   162: aload 6
    //   164: invokespecial 264	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore 5
    //   169: aload 5
    //   171: aload_0
    //   172: iload_1
    //   173: iload_2
    //   174: invokevirtual 268	java/util/zip/GZIPOutputStream:write	([BII)V
    //   177: aload 5
    //   179: invokevirtual 271	java/util/zip/GZIPOutputStream:close	()V
    //   182: aload 5
    //   184: invokevirtual 271	java/util/zip/GZIPOutputStream:close	()V
    //   187: aload 6
    //   189: invokevirtual 272	com/meiqia/core/a/a/f/a$a:close	()V
    //   192: aload 4
    //   194: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   197: aload 4
    //   199: invokevirtual 277	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   202: astore_0
    //   203: aload_0
    //   204: areturn
    //   205: astore 5
    //   207: aconst_null
    //   208: astore 4
    //   210: aconst_null
    //   211: astore_0
    //   212: aload 7
    //   214: astore 6
    //   216: aload 5
    //   218: athrow
    //   219: astore 8
    //   221: aload_0
    //   222: astore 7
    //   224: aload 4
    //   226: astore 5
    //   228: aload 8
    //   230: astore_0
    //   231: aload 6
    //   233: invokevirtual 271	java/util/zip/GZIPOutputStream:close	()V
    //   236: aload 5
    //   238: invokevirtual 272	com/meiqia/core/a/a/f/a$a:close	()V
    //   241: aload 7
    //   243: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   246: aload_0
    //   247: athrow
    //   248: iload_3
    //   249: bipush 8
    //   251: iand
    //   252: ifeq +153 -> 405
    //   255: iconst_1
    //   256: istore 11
    //   258: iload_2
    //   259: iconst_3
    //   260: idiv
    //   261: istore 10
    //   263: iload_2
    //   264: iconst_3
    //   265: irem
    //   266: ifle +145 -> 411
    //   269: iconst_4
    //   270: istore 9
    //   272: iload 9
    //   274: iload 10
    //   276: iconst_4
    //   277: imul
    //   278: iadd
    //   279: istore 10
    //   281: iload 10
    //   283: istore 9
    //   285: iload 11
    //   287: ifeq +13 -> 300
    //   290: iload 10
    //   292: iload 10
    //   294: bipush 76
    //   296: idiv
    //   297: iadd
    //   298: istore 9
    //   300: iload 9
    //   302: newarray <illegal type>
    //   304: astore 4
    //   306: iconst_0
    //   307: istore 10
    //   309: iconst_0
    //   310: istore 9
    //   312: iconst_0
    //   313: istore 12
    //   315: iload 12
    //   317: iload_2
    //   318: iconst_2
    //   319: isub
    //   320: if_icmpge +97 -> 417
    //   323: aload_0
    //   324: iload 12
    //   326: iload_1
    //   327: iadd
    //   328: iconst_3
    //   329: aload 4
    //   331: iload 9
    //   333: iload_3
    //   334: invokestatic 279	com/meiqia/core/a/a/f/a:a	([BII[BII)[B
    //   337: pop
    //   338: iload 10
    //   340: iconst_4
    //   341: iadd
    //   342: istore 14
    //   344: iload 14
    //   346: istore 10
    //   348: iload 9
    //   350: istore 13
    //   352: iload 11
    //   354: ifeq +36 -> 390
    //   357: iload 14
    //   359: istore 10
    //   361: iload 9
    //   363: istore 13
    //   365: iload 14
    //   367: bipush 76
    //   369: if_icmplt +21 -> 390
    //   372: aload 4
    //   374: iload 9
    //   376: iconst_4
    //   377: iadd
    //   378: bipush 10
    //   380: bastore
    //   381: iload 9
    //   383: iconst_1
    //   384: iadd
    //   385: istore 13
    //   387: iconst_0
    //   388: istore 10
    //   390: iload 13
    //   392: iconst_4
    //   393: iadd
    //   394: istore 9
    //   396: iload 12
    //   398: iconst_3
    //   399: iadd
    //   400: istore 12
    //   402: goto -87 -> 315
    //   405: iconst_0
    //   406: istore 11
    //   408: goto -150 -> 258
    //   411: iconst_0
    //   412: istore 9
    //   414: goto -142 -> 272
    //   417: iload 9
    //   419: istore 10
    //   421: iload 12
    //   423: iload_2
    //   424: if_icmpge +27 -> 451
    //   427: aload_0
    //   428: iload 12
    //   430: iload_1
    //   431: iadd
    //   432: iload_2
    //   433: iload 12
    //   435: isub
    //   436: aload 4
    //   438: iload 9
    //   440: iload_3
    //   441: invokestatic 279	com/meiqia/core/a/a/f/a:a	([BII[BII)[B
    //   444: pop
    //   445: iload 9
    //   447: iconst_4
    //   448: iadd
    //   449: istore 10
    //   451: aload 4
    //   453: astore_0
    //   454: iload 10
    //   456: aload 4
    //   458: arraylength
    //   459: iconst_1
    //   460: isub
    //   461: if_icmpgt -258 -> 203
    //   464: iload 10
    //   466: newarray <illegal type>
    //   468: astore_0
    //   469: aload 4
    //   471: iconst_0
    //   472: aload_0
    //   473: iconst_0
    //   474: iload 10
    //   476: invokestatic 285	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   479: aload_0
    //   480: areturn
    //   481: astore_0
    //   482: goto -295 -> 187
    //   485: astore_0
    //   486: goto -294 -> 192
    //   489: astore_0
    //   490: goto -293 -> 197
    //   493: astore 4
    //   495: goto -259 -> 236
    //   498: astore 4
    //   500: goto -259 -> 241
    //   503: astore 4
    //   505: goto -259 -> 246
    //   508: astore_0
    //   509: aconst_null
    //   510: astore 5
    //   512: aconst_null
    //   513: astore 7
    //   515: aload 8
    //   517: astore 6
    //   519: goto -288 -> 231
    //   522: astore_0
    //   523: aconst_null
    //   524: astore 5
    //   526: aload 8
    //   528: astore 6
    //   530: aload 4
    //   532: astore 7
    //   534: goto -303 -> 231
    //   537: astore_0
    //   538: aload 6
    //   540: astore 5
    //   542: aload 8
    //   544: astore 6
    //   546: aload 4
    //   548: astore 7
    //   550: goto -319 -> 231
    //   553: astore_0
    //   554: aload 5
    //   556: astore 7
    //   558: aload 6
    //   560: astore 5
    //   562: aload 7
    //   564: astore 6
    //   566: aload 4
    //   568: astore 7
    //   570: goto -339 -> 231
    //   573: astore 5
    //   575: aconst_null
    //   576: astore 6
    //   578: aload 4
    //   580: astore_0
    //   581: aload 6
    //   583: astore 4
    //   585: aload 7
    //   587: astore 6
    //   589: goto -373 -> 216
    //   592: astore 5
    //   594: aload 4
    //   596: astore_0
    //   597: aload 6
    //   599: astore 4
    //   601: aload 7
    //   603: astore 6
    //   605: goto -389 -> 216
    //   608: astore 8
    //   610: aload 5
    //   612: astore 7
    //   614: aload 4
    //   616: astore_0
    //   617: aload 8
    //   619: astore 5
    //   621: aload 6
    //   623: astore 4
    //   625: aload 7
    //   627: astore 6
    //   629: goto -413 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	paramArrayOfByte	byte[]
    //   0	632	1	paramInt1	int
    //   0	632	2	paramInt2	int
    //   0	632	3	paramInt3	int
    //   142	328	4	localObject1	Object
    //   493	1	4	localException1	Exception
    //   498	1	4	localException2	Exception
    //   503	76	4	localException3	Exception
    //   583	41	4	localObject2	Object
    //   167	16	5	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   205	12	5	localIOException1	IOException
    //   226	335	5	localObject3	Object
    //   573	1	5	localIOException2	IOException
    //   592	19	5	localIOException3	IOException
    //   619	1	5	localIOException4	IOException
    //   156	472	6	localObject4	Object
    //   4	622	7	localObject5	Object
    //   1	1	8	localObject6	Object
    //   219	324	8	localObject7	Object
    //   608	10	8	localIOException5	IOException
    //   270	179	9	i	int
    //   261	214	10	j	int
    //   256	151	11	k	int
    //   313	123	12	m	int
    //   350	44	13	n	int
    //   342	28	14	i1	int
    // Exception table:
    //   from	to	target	type
    //   135	144	205	java/io/IOException
    //   216	219	219	finally
    //   182	187	481	java/lang/Exception
    //   187	192	485	java/lang/Exception
    //   192	197	489	java/lang/Exception
    //   231	236	493	java/lang/Exception
    //   236	241	498	java/lang/Exception
    //   241	246	503	java/lang/Exception
    //   135	144	508	finally
    //   144	158	522	finally
    //   158	169	537	finally
    //   169	182	553	finally
    //   144	158	573	java/io/IOException
    //   158	169	592	java/io/IOException
    //   169	182	608	java/io/IOException
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }
  
  private static final byte[] c(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return e;
    }
    if ((paramInt & 0x20) == 32) {
      return g;
    }
    return c;
  }
  
  public static class a
    extends FilterOutputStream
  {
    private boolean a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    private boolean f;
    private byte[] g;
    private boolean h;
    private int i;
    private byte[] j;
    
    public a(OutputStream paramOutputStream, int paramInt)
    {
      super();
      boolean bool1;
      if ((paramInt & 0x8) != 0)
      {
        bool1 = true;
        this.f = bool1;
        if ((paramInt & 0x1) == 0) {
          break label106;
        }
        bool1 = bool2;
        label34:
        this.a = bool1;
        if (!this.a) {
          break label112;
        }
      }
      label106:
      label112:
      for (int k = 3;; k = 4)
      {
        this.d = k;
        this.c = new byte[this.d];
        this.b = 0;
        this.e = 0;
        this.h = false;
        this.g = new byte[4];
        this.i = paramInt;
        this.j = a.a(paramInt);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label34;
      }
    }
    
    public void a()
    {
      if (this.b > 0)
      {
        if (this.a)
        {
          this.out.write(a.a(this.g, this.c, this.b, this.i));
          this.b = 0;
        }
      }
      else {
        return;
      }
      throw new IOException("Base64 input not properly padded.");
    }
    
    public void close()
    {
      a();
      super.close();
      this.c = null;
      this.out = null;
    }
    
    public void write(int paramInt)
    {
      if (this.h) {
        this.out.write(paramInt);
      }
      do
      {
        do
        {
          do
          {
            return;
            if (!this.a) {
              break;
            }
            arrayOfByte = this.c;
            k = this.b;
            this.b = (k + 1);
            arrayOfByte[k] = ((byte)paramInt);
          } while (this.b < this.d);
          this.out.write(a.a(this.g, this.c, this.d, this.i));
          this.e += 4;
          if ((this.f) && (this.e >= 76))
          {
            this.out.write(10);
            this.e = 0;
          }
          this.b = 0;
          return;
          if (this.j[(paramInt & 0x7F)] <= -5) {
            break;
          }
          byte[] arrayOfByte = this.c;
          int k = this.b;
          this.b = (k + 1);
          arrayOfByte[k] = ((byte)paramInt);
        } while (this.b < this.d);
        paramInt = a.a(this.c, 0, this.g, 0, this.i);
        this.out.write(this.g, 0, paramInt);
        this.b = 0;
        return;
      } while (this.j[(paramInt & 0x7F)] == -5);
      throw new IOException("Invalid character in Base64 data.");
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.h) {
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      for (;;)
      {
        return;
        int k = 0;
        while (k < paramInt2)
        {
          write(paramArrayOfByte[(paramInt1 + k)]);
          k += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */