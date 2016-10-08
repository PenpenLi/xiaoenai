package com.unionpay.mobile.android.utils;

import java.io.IOException;

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
  
  public static byte[] a(String paramString)
  {
    return b(paramString);
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("Cannot decode null source array.");
    }
    if (paramInt + 0 > paramArrayOfByte.length) {
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) }));
    }
    if (paramInt == 0) {
      return new byte[0];
    }
    if (paramInt < 4) {
      throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + paramInt);
    }
    byte[] arrayOfByte2 = c;
    byte[] arrayOfByte1 = new byte[paramInt * 3 / 4];
    byte[] arrayOfByte3 = new byte[4];
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    byte[] arrayOfByte4;
    if (k < paramInt + 0)
    {
      m = arrayOfByte2[(paramArrayOfByte[k] & 0xFF)];
      if (m >= -5)
      {
        if (m < -1) {
          break label631;
        }
        m = j + 1;
        arrayOfByte3[j] = paramArrayOfByte[k];
        if (m <= 3) {
          break label620;
        }
        if (3 >= arrayOfByte3.length) {
          throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(arrayOfByte3.length), Integer.valueOf(0) }));
        }
        if ((i < 0) || (i + 2 >= arrayOfByte1.length)) {
          throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(arrayOfByte1.length), Integer.valueOf(i) }));
        }
        arrayOfByte4 = c;
        if (arrayOfByte3[2] == 61)
        {
          j = arrayOfByte4[arrayOfByte3[0]];
          arrayOfByte1[i] = ((byte)(((arrayOfByte4[arrayOfByte3[1]] & 0xFF) << 12 | (j & 0xFF) << 18) >>> 16));
          j = 1;
          label323:
          j += i;
          if (paramArrayOfByte[k] != 61) {
            break label592;
          }
        }
      }
    }
    for (;;)
    {
      paramArrayOfByte = new byte[j];
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, j);
      return paramArrayOfByte;
      if (arrayOfByte3[3] == 61)
      {
        j = arrayOfByte4[arrayOfByte3[0]];
        m = arrayOfByte4[arrayOfByte3[1]];
        j = (arrayOfByte4[arrayOfByte3[2]] & 0xFF) << 6 | (j & 0xFF) << 18 | (m & 0xFF) << 12;
        arrayOfByte1[i] = ((byte)(j >>> 16));
        arrayOfByte1[(i + 1)] = ((byte)(j >>> 8));
        j = 2;
        break label323;
      }
      j = arrayOfByte4[arrayOfByte3[0]];
      m = arrayOfByte4[arrayOfByte3[1]];
      int n = arrayOfByte4[arrayOfByte3[2]];
      j = arrayOfByte4[arrayOfByte3[3]] & 0xFF | (j & 0xFF) << 18 | (m & 0xFF) << 12 | (n & 0xFF) << 6;
      arrayOfByte1[i] = ((byte)(j >> 16));
      arrayOfByte1[(i + 1)] = ((byte)(j >> 8));
      arrayOfByte1[(i + 2)] = ((byte)j);
      j = 3;
      break label323;
      throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[] { Integer.valueOf(paramArrayOfByte[k] & 0xFF), Integer.valueOf(k) }));
      label592:
      i = 0;
      for (;;)
      {
        m = k + 1;
        k = j;
        j = i;
        i = k;
        k = m;
        break;
        label620:
        j = i;
        i = m;
        continue;
        label631:
        m = i;
        i = j;
        j = m;
      }
      j = i;
    }
  }
  
  /* Error */
  private static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: ifnonnull +13 -> 19
    //   9: new 165	java/lang/NullPointerException
    //   12: dup
    //   13: ldc -35
    //   15: invokespecial 170	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //   19: aload_0
    //   20: ldc -33
    //   22: invokevirtual 226	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_0
    //   29: aload_0
    //   30: arraylength
    //   31: invokestatic 228	com/unionpay/mobile/android/utils/a:a	([BI)[B
    //   34: astore 5
    //   36: aload 5
    //   38: ifnull +118 -> 156
    //   41: aload 5
    //   43: arraylength
    //   44: iconst_4
    //   45: if_icmplt +111 -> 156
    //   48: ldc -27
    //   50: aload 5
    //   52: iconst_0
    //   53: baload
    //   54: sipush 255
    //   57: iand
    //   58: aload 5
    //   60: iconst_1
    //   61: baload
    //   62: bipush 8
    //   64: ishl
    //   65: ldc -26
    //   67: iand
    //   68: ior
    //   69: if_icmpne +87 -> 156
    //   72: sipush 2048
    //   75: newarray <illegal type>
    //   77: astore 6
    //   79: new 232	java/io/ByteArrayOutputStream
    //   82: dup
    //   83: invokespecial 233	java/io/ByteArrayOutputStream:<init>	()V
    //   86: astore_3
    //   87: new 235	java/io/ByteArrayInputStream
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 238	java/io/ByteArrayInputStream:<init>	([B)V
    //   96: astore_1
    //   97: new 240	java/util/zip/GZIPInputStream
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 243	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   105: astore_0
    //   106: aload_0
    //   107: aload 6
    //   109: invokevirtual 247	java/util/zip/GZIPInputStream:read	([B)I
    //   112: istore 7
    //   114: iload 7
    //   116: iflt +52 -> 168
    //   119: aload_3
    //   120: aload 6
    //   122: iconst_0
    //   123: iload 7
    //   125: invokevirtual 251	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: goto -22 -> 106
    //   131: astore 4
    //   133: aload_0
    //   134: astore_2
    //   135: aload_1
    //   136: astore_0
    //   137: aload 4
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 254	java/io/IOException:printStackTrace	()V
    //   144: aload_3
    //   145: invokevirtual 257	java/io/ByteArrayOutputStream:close	()V
    //   148: aload_2
    //   149: invokevirtual 258	java/util/zip/GZIPInputStream:close	()V
    //   152: aload_0
    //   153: invokevirtual 259	java/io/ByteArrayInputStream:close	()V
    //   156: aload 5
    //   158: areturn
    //   159: astore_1
    //   160: aload_0
    //   161: invokevirtual 262	java/lang/String:getBytes	()[B
    //   164: astore_0
    //   165: goto -137 -> 28
    //   168: aload_3
    //   169: invokevirtual 265	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   172: astore_2
    //   173: aload_3
    //   174: invokevirtual 257	java/io/ByteArrayOutputStream:close	()V
    //   177: aload_0
    //   178: invokevirtual 258	java/util/zip/GZIPInputStream:close	()V
    //   181: aload_1
    //   182: invokevirtual 259	java/io/ByteArrayInputStream:close	()V
    //   185: aload_2
    //   186: areturn
    //   187: astore_0
    //   188: aload_2
    //   189: areturn
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_1
    //   195: aload 4
    //   197: astore_2
    //   198: aload_3
    //   199: invokevirtual 257	java/io/ByteArrayOutputStream:close	()V
    //   202: aload_2
    //   203: invokevirtual 258	java/util/zip/GZIPInputStream:close	()V
    //   206: aload_1
    //   207: invokevirtual 259	java/io/ByteArrayInputStream:close	()V
    //   210: aload_0
    //   211: athrow
    //   212: astore_3
    //   213: goto -36 -> 177
    //   216: astore_0
    //   217: goto -36 -> 181
    //   220: astore_1
    //   221: goto -73 -> 148
    //   224: astore_1
    //   225: goto -73 -> 152
    //   228: astore_0
    //   229: aload 5
    //   231: areturn
    //   232: astore_3
    //   233: goto -31 -> 202
    //   236: astore_2
    //   237: goto -31 -> 206
    //   240: astore_1
    //   241: goto -31 -> 210
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_1
    //   247: aload 4
    //   249: astore_2
    //   250: goto -52 -> 198
    //   253: astore_0
    //   254: aload 4
    //   256: astore_2
    //   257: goto -59 -> 198
    //   260: astore 4
    //   262: aload_0
    //   263: astore_2
    //   264: aload 4
    //   266: astore_0
    //   267: goto -69 -> 198
    //   270: astore 4
    //   272: aload_0
    //   273: astore_1
    //   274: aload 4
    //   276: astore_0
    //   277: goto -79 -> 198
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_3
    //   283: aconst_null
    //   284: astore_0
    //   285: goto -145 -> 140
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_0
    //   291: goto -151 -> 140
    //   294: astore 4
    //   296: aload_1
    //   297: astore_0
    //   298: aload 4
    //   300: astore_1
    //   301: goto -161 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString	String
    //   25	116	1	localObject1	Object
    //   159	23	1	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   194	13	1	localObject2	Object
    //   220	1	1	localException1	Exception
    //   224	1	1	localException2	Exception
    //   240	1	1	localException3	Exception
    //   246	28	1	str	String
    //   280	1	1	localIOException1	IOException
    //   288	9	1	localIOException2	IOException
    //   300	1	1	localIOException3	IOException
    //   4	199	2	localObject3	Object
    //   236	1	2	localException4	Exception
    //   249	15	2	localObject4	Object
    //   86	113	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   212	1	3	localException5	Exception
    //   232	1	3	localException6	Exception
    //   282	1	3	localObject5	Object
    //   1	1	4	localObject6	Object
    //   131	124	4	localIOException4	IOException
    //   260	5	4	localObject7	Object
    //   270	5	4	localObject8	Object
    //   294	5	4	localIOException5	IOException
    //   34	196	5	arrayOfByte1	byte[]
    //   77	44	6	arrayOfByte2	byte[]
    //   112	12	7	i	int
    // Exception table:
    //   from	to	target	type
    //   106	114	131	java/io/IOException
    //   119	128	131	java/io/IOException
    //   168	173	131	java/io/IOException
    //   19	26	159	java/io/UnsupportedEncodingException
    //   181	185	187	java/lang/Exception
    //   79	87	190	finally
    //   173	177	212	java/lang/Exception
    //   177	181	216	java/lang/Exception
    //   144	148	220	java/lang/Exception
    //   148	152	224	java/lang/Exception
    //   152	156	228	java/lang/Exception
    //   198	202	232	java/lang/Exception
    //   202	206	236	java/lang/Exception
    //   206	210	240	java/lang/Exception
    //   87	97	244	finally
    //   97	106	253	finally
    //   106	114	260	finally
    //   119	128	260	finally
    //   168	173	260	finally
    //   140	144	270	finally
    //   79	87	280	java/io/IOException
    //   87	97	288	java/io/IOException
    //   97	106	294	java/io/IOException
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */