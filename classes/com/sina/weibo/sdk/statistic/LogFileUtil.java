package com.sina.weibo.sdk.statistic;

import android.os.Environment;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.MD5;
import java.io.File;

class LogFileUtil
{
  public static final String ANALYTICS_FILE_NAME = "app_logs";
  private static final String ANALYTICS_FILE_SUFFIX = ".txt";
  private static final String SDCARD_WEIBO_ANALYTICS_DIR = "/sina/weibo/.applogs/";
  
  public static boolean delete(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    while (!paramString.isFile()) {
      return false;
    }
    paramString.delete();
    return true;
  }
  
  public static String getAppLogPath(String paramString)
  {
    String str = "";
    if (LogReport.getPackageName() != null) {
      str = MD5.hexdigest(LogReport.getPackageName()) + "/";
    }
    return getSDPath() + "/sina/weibo/.applogs/" + str + paramString + ".txt";
  }
  
  public static String getAppLogs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return readStringFromFile(paramString);
  }
  
  private static String getSDPath()
  {
    String str = null;
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (File localFile = Environment.getExternalStorageDirectory();; localFile = null)
    {
      if (localFile != null) {
        str = localFile.toString();
      }
      return str;
    }
  }
  
  /* Error */
  private static String readStringFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 39
    //   9: areturn
    //   10: new 23	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 33	java/io/File:isFile	()Z
    //   23: ifeq +10 -> 33
    //   26: aload_0
    //   27: invokevirtual 30	java/io/File:exists	()Z
    //   30: ifne +6 -> 36
    //   33: ldc 39
    //   35: areturn
    //   36: aconst_null
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_2
    //   40: new 47	java/lang/StringBuilder
    //   43: dup
    //   44: aload_0
    //   45: invokevirtual 105	java/io/File:length	()J
    //   48: l2i
    //   49: invokespecial 108	java/lang/StringBuilder:<init>	(I)V
    //   52: astore_3
    //   53: new 110	java/io/BufferedReader
    //   56: dup
    //   57: new 112	java/io/FileReader
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 115	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   65: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   68: astore_0
    //   69: aload_0
    //   70: astore_1
    //   71: aload_0
    //   72: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnonnull +16 -> 93
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 124	java/io/BufferedReader:close	()V
    //   88: aload_3
    //   89: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: areturn
    //   93: aload_0
    //   94: astore_1
    //   95: aload_3
    //   96: aload_2
    //   97: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: goto -32 -> 69
    //   104: astore_2
    //   105: aload_0
    //   106: astore_1
    //   107: aload_2
    //   108: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   111: aload_0
    //   112: ifnull -24 -> 88
    //   115: aload_0
    //   116: invokevirtual 124	java/io/BufferedReader:close	()V
    //   119: goto -31 -> 88
    //   122: astore_0
    //   123: goto -35 -> 88
    //   126: astore_1
    //   127: aload_2
    //   128: astore_0
    //   129: aload_1
    //   130: astore_2
    //   131: aload_0
    //   132: astore_1
    //   133: aload_2
    //   134: invokevirtual 128	java/lang/OutOfMemoryError:printStackTrace	()V
    //   137: aload_0
    //   138: ifnull -50 -> 88
    //   141: aload_0
    //   142: invokevirtual 124	java/io/BufferedReader:close	()V
    //   145: goto -57 -> 88
    //   148: astore_0
    //   149: goto -61 -> 88
    //   152: astore_0
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 124	java/io/BufferedReader:close	()V
    //   161: aload_0
    //   162: athrow
    //   163: astore_1
    //   164: goto -3 -> 161
    //   167: astore_0
    //   168: goto -80 -> 88
    //   171: astore_0
    //   172: goto -19 -> 153
    //   175: astore_2
    //   176: goto -45 -> 131
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -77 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   37	70	1	str1	String
    //   126	4	1	localOutOfMemoryError1	OutOfMemoryError
    //   132	26	1	str2	String
    //   163	1	1	localIOException1	java.io.IOException
    //   39	58	2	str3	String
    //   104	24	2	localIOException2	java.io.IOException
    //   130	4	2	localOutOfMemoryError2	OutOfMemoryError
    //   175	1	2	localOutOfMemoryError3	OutOfMemoryError
    //   179	1	2	localIOException3	java.io.IOException
    //   52	44	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   71	76	104	java/io/IOException
    //   95	101	104	java/io/IOException
    //   115	119	122	java/io/IOException
    //   53	69	126	java/lang/OutOfMemoryError
    //   141	145	148	java/io/IOException
    //   53	69	152	finally
    //   133	137	152	finally
    //   157	161	163	java/io/IOException
    //   84	88	167	java/io/IOException
    //   71	76	171	finally
    //   95	101	171	finally
    //   107	111	171	finally
    //   71	76	175	java/lang/OutOfMemoryError
    //   95	101	175	java/lang/OutOfMemoryError
    //   53	69	179	java/io/IOException
  }
  
  /* Error */
  public static void writeToFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore 9
    //   9: iload 9
    //   11: ifeq +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: ldc -124
    //   20: new 47	java/lang/StringBuilder
    //   23: dup
    //   24: ldc -122
    //   26: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 140	com/sina/weibo/sdk/utils/LogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_1
    //   40: ifnull -26 -> 14
    //   43: aload_1
    //   44: invokevirtual 143	java/lang/String:length	()I
    //   47: ifeq -33 -> 14
    //   50: new 47	java/lang/StringBuilder
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_3
    //   60: iconst_0
    //   61: invokevirtual 147	java/lang/StringBuilder:charAt	(I)C
    //   64: bipush 91
    //   66: if_icmpne +12 -> 78
    //   69: aload_3
    //   70: iconst_0
    //   71: iconst_1
    //   72: ldc 39
    //   74: invokevirtual 151	java/lang/StringBuilder:replace	(IILjava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: aload_3
    //   80: invokevirtual 152	java/lang/StringBuilder:length	()I
    //   83: iconst_1
    //   84: isub
    //   85: invokevirtual 147	java/lang/StringBuilder:charAt	(I)C
    //   88: bipush 44
    //   90: if_icmpeq +20 -> 110
    //   93: aload_3
    //   94: aload_3
    //   95: invokevirtual 152	java/lang/StringBuilder:length	()I
    //   98: iconst_1
    //   99: isub
    //   100: aload_3
    //   101: invokevirtual 152	java/lang/StringBuilder:length	()I
    //   104: ldc -102
    //   106: invokevirtual 151	java/lang/StringBuilder:replace	(IILjava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: new 23	java/io/File
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_0
    //   122: invokevirtual 157	java/io/File:getParentFile	()Ljava/io/File;
    //   125: astore 4
    //   127: aload 4
    //   129: invokevirtual 30	java/io/File:exists	()Z
    //   132: ifne +9 -> 141
    //   135: aload 4
    //   137: invokevirtual 160	java/io/File:mkdirs	()Z
    //   140: pop
    //   141: aload_0
    //   142: invokevirtual 30	java/io/File:exists	()Z
    //   145: ifne +59 -> 204
    //   148: aload_0
    //   149: invokevirtual 163	java/io/File:createNewFile	()Z
    //   152: pop
    //   153: iload_2
    //   154: istore 9
    //   156: new 165	java/io/FileWriter
    //   159: dup
    //   160: aload_0
    //   161: iload 9
    //   163: invokespecial 168	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   166: astore_0
    //   167: aload_0
    //   168: aload_3
    //   169: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokevirtual 171	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   175: aload_0
    //   176: invokevirtual 174	java/io/FileWriter:flush	()V
    //   179: aload_0
    //   180: ifnull -166 -> 14
    //   183: aload_0
    //   184: invokevirtual 175	java/io/FileWriter:close	()V
    //   187: goto -173 -> 14
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   195: goto -181 -> 14
    //   198: astore_0
    //   199: ldc 2
    //   201: monitorexit
    //   202: aload_0
    //   203: athrow
    //   204: iload_2
    //   205: istore 9
    //   207: aload_0
    //   208: invokevirtual 178	java/io/File:lastModified	()J
    //   211: lconst_0
    //   212: lcmp
    //   213: ifle -57 -> 156
    //   216: invokestatic 183	java/lang/System:currentTimeMillis	()J
    //   219: lstore 5
    //   221: aload_0
    //   222: invokevirtual 178	java/io/File:lastModified	()J
    //   225: lstore 7
    //   227: iload_2
    //   228: istore 9
    //   230: lload 5
    //   232: lload 7
    //   234: lsub
    //   235: ldc2_w 184
    //   238: lcmp
    //   239: ifle -83 -> 156
    //   242: iconst_0
    //   243: istore 9
    //   245: goto -89 -> 156
    //   248: astore_0
    //   249: aload_1
    //   250: astore_0
    //   251: aload_0
    //   252: ifnull -238 -> 14
    //   255: aload_0
    //   256: invokevirtual 175	java/io/FileWriter:close	()V
    //   259: goto -245 -> 14
    //   262: astore_0
    //   263: aload_0
    //   264: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   267: goto -253 -> 14
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: aload_0
    //   274: ifnull +7 -> 281
    //   277: aload_0
    //   278: invokevirtual 175	java/io/FileWriter:close	()V
    //   281: aload_1
    //   282: athrow
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   288: goto -7 -> 281
    //   291: astore_1
    //   292: goto -19 -> 273
    //   295: astore_1
    //   296: goto -45 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramString1	String
    //   0	299	1	paramString2	String
    //   0	299	2	paramBoolean	boolean
    //   58	111	3	localStringBuilder	StringBuilder
    //   125	11	4	localFile	File
    //   219	12	5	l1	long
    //   225	8	7	l2	long
    //   7	237	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   183	187	190	java/io/IOException
    //   3	9	198	finally
    //   18	39	198	finally
    //   43	78	198	finally
    //   78	110	198	finally
    //   110	119	198	finally
    //   183	187	198	finally
    //   191	195	198	finally
    //   255	259	198	finally
    //   263	267	198	finally
    //   277	281	198	finally
    //   281	283	198	finally
    //   284	288	198	finally
    //   121	141	248	java/io/IOException
    //   141	153	248	java/io/IOException
    //   156	167	248	java/io/IOException
    //   207	227	248	java/io/IOException
    //   255	259	262	java/io/IOException
    //   121	141	270	finally
    //   141	153	270	finally
    //   156	167	270	finally
    //   207	227	270	finally
    //   277	281	283	java/io/IOException
    //   167	179	291	finally
    //   167	179	295	java/io/IOException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\LogFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */