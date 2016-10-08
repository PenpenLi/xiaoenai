package com.alipay.security.mobile.module.c;

import java.io.File;

public final class a
{
  public static String a(String paramString)
  {
    Object localObject1 = "";
    try
    {
      localObject2 = System.getProperty(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (com.alipay.security.mobile.module.c.a.a.a((String)localObject1)) {
      localObject2 = b.a(".SystemConfig" + File.separator + paramString);
    }
    return (String)localObject2;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 20	com/alipay/security/mobile/module/c/a/a:a	(Ljava/lang/String;)Z
    //   4: ifne +9 -> 13
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 56	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: invokestatic 59	com/alipay/security/mobile/module/c/b:a	()Z
    //   16: ifeq +92 -> 108
    //   19: new 22	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 24
    //   25: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   31: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: invokestatic 59	com/alipay/security/mobile/module/c/b:a	()Z
    //   45: ifeq +63 -> 108
    //   48: new 30	java/io/File
    //   51: dup
    //   52: invokestatic 65	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   55: aload_0
    //   56: invokespecial 68	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 71	java/io/File:exists	()Z
    //   64: ifne +11 -> 75
    //   67: aload_0
    //   68: invokevirtual 74	java/io/File:getParentFile	()Ljava/io/File;
    //   71: invokevirtual 77	java/io/File:mkdirs	()Z
    //   74: pop
    //   75: new 30	java/io/File
    //   78: dup
    //   79: aload_0
    //   80: invokevirtual 80	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_2
    //   89: new 83	java/io/FileWriter
    //   92: dup
    //   93: aload_0
    //   94: iconst_0
    //   95: invokespecial 86	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   98: astore_0
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 89	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   104: aload_0
    //   105: invokevirtual 93	java/io/FileWriter:close	()V
    //   108: return
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull -5 -> 108
    //   116: aload_0
    //   117: invokevirtual 93	java/io/FileWriter:close	()V
    //   120: return
    //   121: astore_0
    //   122: return
    //   123: astore_0
    //   124: aload_2
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 93	java/io/FileWriter:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: return
    //   138: astore_0
    //   139: return
    //   140: astore_1
    //   141: goto -7 -> 134
    //   144: astore_2
    //   145: aload_0
    //   146: astore_1
    //   147: aload_2
    //   148: astore_0
    //   149: goto -23 -> 126
    //   152: astore_1
    //   153: goto -41 -> 112
    //   156: astore_2
    //   157: goto -144 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString1	String
    //   0	160	1	paramString2	String
    //   88	37	2	localObject1	Object
    //   144	4	2	localObject2	Object
    //   156	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   89	99	109	java/lang/Exception
    //   116	120	121	java/io/IOException
    //   89	99	123	finally
    //   42	75	136	java/lang/Exception
    //   75	87	136	java/lang/Exception
    //   104	108	136	java/lang/Exception
    //   116	120	136	java/lang/Exception
    //   130	134	136	java/lang/Exception
    //   134	136	136	java/lang/Exception
    //   104	108	138	java/io/IOException
    //   130	134	140	java/io/IOException
    //   99	104	144	finally
    //   99	104	152	java/lang/Exception
    //   0	13	156	java/lang/Throwable
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */