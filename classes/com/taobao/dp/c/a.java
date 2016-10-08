package com.taobao.dp.c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public final class a
{
  public static int a()
  {
    return a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
  }
  
  /* Error */
  private static int a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_1
    //   6: iconst_0
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: new 18	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 22	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: new 24	java/io/BufferedReader
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 27	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 31	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +12 -> 48
    //   39: aload_2
    //   40: invokevirtual 36	java/lang/String:trim	()Ljava/lang/String;
    //   43: invokestatic 41	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   46: istore 4
    //   48: aload_0
    //   49: invokevirtual 45	java/io/FileReader:close	()V
    //   52: aload_1
    //   53: invokevirtual 46	java/io/BufferedReader:close	()V
    //   56: iload 4
    //   58: ireturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 45	java/io/FileReader:close	()V
    //   74: iload 5
    //   76: istore 4
    //   78: aload_1
    //   79: ifnull -23 -> 56
    //   82: aload_1
    //   83: invokevirtual 46	java/io/BufferedReader:close	()V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_0
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_3
    //   95: astore_1
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 45	java/io/FileReader:close	()V
    //   104: iload 5
    //   106: istore 4
    //   108: aload_1
    //   109: ifnull -53 -> 56
    //   112: aload_1
    //   113: invokevirtual 46	java/io/BufferedReader:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: iconst_0
    //   120: ireturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 45	java/io/FileReader:close	()V
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 46	java/io/BufferedReader:close	()V
    //   140: aload_1
    //   141: athrow
    //   142: astore_0
    //   143: goto -91 -> 52
    //   146: astore_0
    //   147: iload 4
    //   149: ireturn
    //   150: astore_0
    //   151: goto -77 -> 74
    //   154: astore_0
    //   155: goto -51 -> 104
    //   158: astore_0
    //   159: goto -27 -> 132
    //   162: astore_0
    //   163: goto -23 -> 140
    //   166: astore_1
    //   167: goto -43 -> 124
    //   170: astore_3
    //   171: aload_1
    //   172: astore_2
    //   173: aload_3
    //   174: astore_1
    //   175: goto -51 -> 124
    //   178: astore_1
    //   179: aload_3
    //   180: astore_1
    //   181: goto -85 -> 96
    //   184: astore_2
    //   185: goto -89 -> 96
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_1
    //   191: goto -125 -> 66
    //   194: astore_2
    //   195: goto -129 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   5	108	1	localObject1	Object
    //   121	20	1	localObject2	Object
    //   166	6	1	localObject3	Object
    //   174	1	1	localObject4	Object
    //   178	1	1	localIOException1	IOException
    //   180	1	1	localObject5	Object
    //   188	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   190	1	1	localObject6	Object
    //   3	170	2	localObject7	Object
    //   184	1	2	localIOException2	IOException
    //   194	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	94	3	localObject8	Object
    //   170	10	3	localObject9	Object
    //   10	138	4	i	int
    //   7	98	5	j	int
    // Exception table:
    //   from	to	target	type
    //   12	21	59	java/io/FileNotFoundException
    //   82	86	88	java/io/IOException
    //   12	21	91	java/io/IOException
    //   112	116	118	java/io/IOException
    //   12	21	121	finally
    //   48	52	142	java/io/IOException
    //   52	56	146	java/io/IOException
    //   70	74	150	java/io/IOException
    //   100	104	154	java/io/IOException
    //   128	132	158	java/io/IOException
    //   136	140	162	java/io/IOException
    //   21	30	166	finally
    //   30	35	170	finally
    //   39	48	170	finally
    //   21	30	178	java/io/IOException
    //   30	35	184	java/io/IOException
    //   39	48	184	java/io/IOException
    //   21	30	188	java/io/FileNotFoundException
    //   30	35	194	java/io/FileNotFoundException
    //   39	48	194	java/io/FileNotFoundException
  }
  
  public static String b()
  {
    try
    {
      FileReader localFileReader = new FileReader("/proc/cpuinfo");
      BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
      String str1 = "";
      do
      {
        String str2;
        do
        {
          str2 = localBufferedReader.readLine();
          localObject = str1;
          if (str2 == null) {
            break;
          }
        } while ((str2 == null) || (str2.length() <= 0));
        localObject = str2.split(":");
      } while ((localObject == null) || (localObject.length <= 1) || (!localObject[0].contains("BogoMIPS")));
      Object localObject = localObject[1].trim();
      localBufferedReader.close();
      localFileReader.close();
      return (String)localObject;
    }
    catch (IOException localIOException) {}
    return "";
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 18	java/io/FileReader
    //   5: dup
    //   6: ldc 49
    //   8: invokespecial 22	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 24	java/io/BufferedReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 27	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 31	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +25 -> 52
    //   30: aload_3
    //   31: ldc 72
    //   33: iconst_2
    //   34: invokevirtual 75	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   37: iconst_1
    //   38: aaload
    //   39: astore_3
    //   40: aload_0
    //   41: invokevirtual 45	java/io/FileReader:close	()V
    //   44: aload_1
    //   45: invokevirtual 46	java/io/BufferedReader:close	()V
    //   48: aload_3
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: aload_0
    //   53: invokevirtual 45	java/io/FileReader:close	()V
    //   56: aload_1
    //   57: invokevirtual 46	java/io/BufferedReader:close	()V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: areturn
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 45	java/io/FileReader:close	()V
    //   78: aload_2
    //   79: astore_0
    //   80: aload_1
    //   81: ifnull -31 -> 50
    //   84: aload_1
    //   85: invokevirtual 46	java/io/BufferedReader:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aconst_null
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 45	java/io/FileReader:close	()V
    //   106: aload_2
    //   107: astore_0
    //   108: aload_1
    //   109: ifnull -59 -> 50
    //   112: aload_1
    //   113: invokevirtual 46	java/io/BufferedReader:close	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: areturn
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_1
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 45	java/io/FileReader:close	()V
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 46	java/io/BufferedReader:close	()V
    //   142: aload_2
    //   143: athrow
    //   144: astore_0
    //   145: goto -101 -> 44
    //   148: astore_0
    //   149: aload_3
    //   150: areturn
    //   151: astore_0
    //   152: goto -96 -> 56
    //   155: astore_0
    //   156: goto -78 -> 78
    //   159: astore_0
    //   160: goto -54 -> 106
    //   163: astore_0
    //   164: goto -30 -> 134
    //   167: astore_0
    //   168: goto -26 -> 142
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -48 -> 126
    //   177: astore_2
    //   178: goto -52 -> 126
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -86 -> 98
    //   187: astore_3
    //   188: goto -90 -> 98
    //   191: astore_1
    //   192: aconst_null
    //   193: astore_1
    //   194: goto -124 -> 70
    //   197: astore_3
    //   198: goto -128 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	42	0	localObject1	Object
    //   62	1	0	localIOException1	IOException
    //   65	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   69	11	0	localObject2	Object
    //   90	1	0	localIOException2	IOException
    //   93	1	0	localIOException3	IOException
    //   97	11	0	localObject3	Object
    //   118	1	0	localIOException4	IOException
    //   123	8	0	localObject4	Object
    //   144	1	0	localIOException5	IOException
    //   148	1	0	localIOException6	IOException
    //   151	1	0	localIOException7	IOException
    //   155	1	0	localIOException8	IOException
    //   159	1	0	localIOException9	IOException
    //   163	1	0	localIOException10	IOException
    //   167	1	0	localIOException11	IOException
    //   20	154	1	localBufferedReader	BufferedReader
    //   181	1	1	localIOException12	IOException
    //   183	1	1	localObject5	Object
    //   191	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   193	1	1	localObject6	Object
    //   1	106	2	localObject7	Object
    //   121	22	2	localObject8	Object
    //   171	1	2	localObject9	Object
    //   177	1	2	localObject10	Object
    //   25	125	3	str	String
    //   187	1	3	localIOException13	IOException
    //   197	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   56	60	62	java/io/IOException
    //   2	12	65	java/io/FileNotFoundException
    //   84	88	90	java/io/IOException
    //   2	12	93	java/io/IOException
    //   112	116	118	java/io/IOException
    //   2	12	121	finally
    //   40	44	144	java/io/IOException
    //   44	48	148	java/io/IOException
    //   52	56	151	java/io/IOException
    //   74	78	155	java/io/IOException
    //   102	106	159	java/io/IOException
    //   130	134	163	java/io/IOException
    //   138	142	167	java/io/IOException
    //   12	21	171	finally
    //   21	26	177	finally
    //   30	40	177	finally
    //   12	21	181	java/io/IOException
    //   21	26	187	java/io/IOException
    //   30	40	187	java/io/IOException
    //   12	21	191	java/io/FileNotFoundException
    //   21	26	197	java/io/FileNotFoundException
    //   30	40	197	java/io/FileNotFoundException
  }
  
  public static String d()
  {
    String str2 = "0000000000000000";
    try
    {
      LineNumberReader localLineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial").getInputStream()));
      int i = 1;
      for (;;)
      {
        String str1 = str2;
        if (i < 100)
        {
          String str3 = localLineNumberReader.readLine();
          str1 = str2;
          if (str3 != null)
          {
            if (str3.indexOf("Serial") < 0) {
              break label83;
            }
            str1 = str3.substring(str3.indexOf(":") + 1, str3.length()).trim();
          }
        }
        return str1;
        label83:
        i += 1;
      }
      return "0000000000000000";
    }
    catch (Exception localException) {}
  }
  
  public static String e()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new b()).length;
      return String.valueOf(i);
    }
    catch (Exception localException) {}
    return "1";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */