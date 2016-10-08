package com.alipay.security.mobile.module.c.a;

public final class a
{
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label48;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label48:
    return true;
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 31	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: new 37	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 44	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 46	java/io/BufferedReader
    //   29: dup
    //   30: new 48	java/io/InputStreamReader
    //   33: dup
    //   34: new 50	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: ldc 53
    //   44: invokespecial 56	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: invokespecial 59	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 63	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +26 -> 83
    //   60: aload_2
    //   61: aload_1
    //   62: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: goto -15 -> 51
    //   69: astore_1
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 70	java/io/BufferedReader:close	()V
    //   78: aload_2
    //   79: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: areturn
    //   83: aload_0
    //   84: invokevirtual 70	java/io/BufferedReader:close	()V
    //   87: goto -9 -> 78
    //   90: astore_0
    //   91: goto -13 -> 78
    //   94: astore_1
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 70	java/io/BufferedReader:close	()V
    //   105: aload_1
    //   106: athrow
    //   107: astore_0
    //   108: goto -30 -> 78
    //   111: astore_0
    //   112: goto -7 -> 105
    //   115: astore_1
    //   116: goto -19 -> 97
    //   119: astore_0
    //   120: aload_1
    //   121: astore_0
    //   122: goto -52 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   1	61	1	str	String
    //   69	1	1	localIOException	java.io.IOException
    //   94	12	1	localObject1	Object
    //   115	6	1	localObject2	Object
    //   9	70	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	56	69	java/io/IOException
    //   60	66	69	java/io/IOException
    //   83	87	90	java/lang/Throwable
    //   10	24	94	finally
    //   26	51	94	finally
    //   74	78	107	java/lang/Throwable
    //   101	105	111	java/lang/Throwable
    //   51	56	115	finally
    //   60	66	115	finally
    //   10	24	119	java/io/IOException
    //   26	51	119	java/io/IOException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */