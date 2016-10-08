package com.alipay.security.mobile.module.a;

public final class b
{
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 10	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 14	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: invokevirtual 18	java/io/File:exists	()Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifne +21 -> 41
    //   23: new 20	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 23	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: aconst_null
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 26	java/io/IOException:printStackTrace	()V
    //   38: goto -7 -> 31
    //   41: aload_0
    //   42: invokevirtual 30	java/io/File:length	()J
    //   45: l2i
    //   46: newarray <illegal type>
    //   48: astore_1
    //   49: new 32	java/io/FileReader
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 35	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   57: astore_0
    //   58: aload_0
    //   59: astore_3
    //   60: aload_0
    //   61: aload_1
    //   62: invokevirtual 39	java/io/FileReader:read	([C)I
    //   65: pop
    //   66: aload_0
    //   67: invokevirtual 42	java/io/FileReader:close	()V
    //   70: aload_1
    //   71: invokestatic 48	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 26	java/io/IOException:printStackTrace	()V
    //   80: goto -10 -> 70
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_1
    //   88: aload_0
    //   89: astore_3
    //   90: aload_2
    //   91: invokevirtual 52	java/io/IOException:getMessage	()Ljava/lang/String;
    //   94: pop
    //   95: aload_0
    //   96: invokevirtual 42	java/io/FileReader:close	()V
    //   99: goto -29 -> 70
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 26	java/io/IOException:printStackTrace	()V
    //   107: goto -37 -> 70
    //   110: astore_0
    //   111: aload_2
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 42	java/io/FileReader:close	()V
    //   117: aload_0
    //   118: athrow
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 26	java/io/IOException:printStackTrace	()V
    //   124: goto -7 -> 117
    //   127: astore_0
    //   128: aload_3
    //   129: astore_1
    //   130: goto -17 -> 113
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_0
    //   136: goto -48 -> 88
    //   139: astore_2
    //   140: goto -52 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString1	String
    //   0	143	1	paramString2	String
    //   1	1	2	localObject	Object
    //   83	29	2	localIOException1	java.io.IOException
    //   133	1	2	localIOException2	java.io.IOException
    //   139	1	2	localIOException3	java.io.IOException
    //   59	70	3	str	String
    //   16	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   23	31	33	java/io/IOException
    //   66	70	75	java/io/IOException
    //   2	18	83	java/io/IOException
    //   41	49	83	java/io/IOException
    //   95	99	102	java/io/IOException
    //   2	18	110	finally
    //   41	49	110	finally
    //   49	58	110	finally
    //   113	117	119	java/io/IOException
    //   60	66	127	finally
    //   90	95	127	finally
    //   49	58	133	java/io/IOException
    //   60	66	139	java/io/IOException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */