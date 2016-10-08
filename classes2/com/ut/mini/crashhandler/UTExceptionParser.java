package com.ut.mini.crashhandler;

public class UTExceptionParser
{
  /* Error */
  public static UTExceptionItem parse(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +261 -> 262
    //   4: new 6	com/ut/mini/crashhandler/UTExceptionParser$UTExceptionItem
    //   7: dup
    //   8: invokespecial 17	com/ut/mini/crashhandler/UTExceptionParser$UTExceptionItem:<init>	()V
    //   11: astore_3
    //   12: aload_0
    //   13: invokevirtual 23	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_2
    //   20: ifnonnull +5 -> 25
    //   23: aload_0
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +165 -> 191
    //   29: aload_1
    //   30: invokevirtual 27	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   33: astore_2
    //   34: aload_2
    //   35: arraylength
    //   36: ifle +155 -> 191
    //   39: aload_2
    //   40: iconst_0
    //   41: aaload
    //   42: ifnull +149 -> 191
    //   45: aload_1
    //   46: invokevirtual 31	java/lang/Throwable:toString	()Ljava/lang/String;
    //   49: astore_2
    //   50: ldc 33
    //   52: astore_1
    //   53: new 35	java/io/StringWriter
    //   56: dup
    //   57: invokespecial 36	java/io/StringWriter:<init>	()V
    //   60: astore 4
    //   62: new 38	java/io/PrintWriter
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 41	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   71: astore 5
    //   73: aload_0
    //   74: aload 5
    //   76: invokevirtual 45	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   79: aload 4
    //   81: invokevirtual 46	java/io/StringWriter:toString	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload 5
    //   87: invokevirtual 49	java/io/PrintWriter:close	()V
    //   90: aload 4
    //   92: invokevirtual 50	java/io/StringWriter:close	()V
    //   95: aload_2
    //   96: ldc 52
    //   98: invokevirtual 58	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   101: istore 6
    //   103: iload 6
    //   105: ifle +123 -> 228
    //   108: aload_2
    //   109: iload 6
    //   111: iconst_2
    //   112: iadd
    //   113: invokevirtual 62	java/lang/String:substring	(I)Ljava/lang/String;
    //   116: invokevirtual 65	java/lang/String:trim	()Ljava/lang/String;
    //   119: astore_1
    //   120: aload_3
    //   121: aload_1
    //   122: invokevirtual 69	com/ut/mini/crashhandler/UTExceptionParser$UTExceptionItem:setExpName	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: astore_1
    //   127: aload_0
    //   128: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +12 -> 143
    //   134: aload_0
    //   135: ldc 77
    //   137: ldc 79
    //   139: invokevirtual 83	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_1
    //   143: aload_3
    //   144: aload_1
    //   145: invokevirtual 86	com/ut/mini/crashhandler/UTExceptionParser$UTExceptionItem:setCrashDetail	(Ljava/lang/String;)V
    //   148: aload_3
    //   149: aload_1
    //   150: invokevirtual 90	java/lang/String:getBytes	()[B
    //   153: invokestatic 96	com/alibaba/mtl/log/e/j:b	([B)Ljava/lang/String;
    //   156: invokevirtual 99	com/ut/mini/crashhandler/UTExceptionParser$UTExceptionItem:setMd5	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: ldc 101
    //   162: invokevirtual 104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   165: ifne +21 -> 186
    //   168: aload_1
    //   169: ldc 106
    //   171: invokevirtual 104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   174: ifne +12 -> 186
    //   177: aload_1
    //   178: ldc 108
    //   180: invokevirtual 104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   183: ifeq +71 -> 254
    //   186: aload_3
    //   187: iconst_1
    //   188: invokevirtual 112	com/ut/mini/crashhandler/UTExceptionParser$UTExceptionItem:setmCrashedByUT	(Z)V
    //   191: aload_3
    //   192: areturn
    //   193: astore_0
    //   194: aload 5
    //   196: invokevirtual 49	java/io/PrintWriter:close	()V
    //   199: aload 4
    //   201: invokevirtual 50	java/io/StringWriter:close	()V
    //   204: aload_1
    //   205: astore_0
    //   206: goto -111 -> 95
    //   209: astore_0
    //   210: aload_1
    //   211: astore_0
    //   212: goto -117 -> 95
    //   215: astore_0
    //   216: aload 5
    //   218: invokevirtual 49	java/io/PrintWriter:close	()V
    //   221: aload 4
    //   223: invokevirtual 50	java/io/StringWriter:close	()V
    //   226: aload_0
    //   227: athrow
    //   228: aload_2
    //   229: ldc 114
    //   231: invokevirtual 58	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   234: istore 6
    //   236: aload_2
    //   237: astore_1
    //   238: iload 6
    //   240: ifle -120 -> 120
    //   243: aload_2
    //   244: iconst_0
    //   245: iload 6
    //   247: invokevirtual 117	java/lang/String:substring	(II)Ljava/lang/String;
    //   250: astore_1
    //   251: goto -131 -> 120
    //   254: aload_3
    //   255: iconst_0
    //   256: invokevirtual 112	com/ut/mini/crashhandler/UTExceptionParser$UTExceptionItem:setmCrashedByUT	(Z)V
    //   259: goto -68 -> 191
    //   262: aconst_null
    //   263: areturn
    //   264: astore_1
    //   265: goto -39 -> 226
    //   268: astore_1
    //   269: goto -174 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramThrowable	Throwable
    //   18	233	1	localObject1	Object
    //   264	1	1	localException1	Exception
    //   268	1	1	localException2	Exception
    //   16	228	2	localObject2	Object
    //   11	244	3	localUTExceptionItem	UTExceptionItem
    //   60	162	4	localStringWriter	java.io.StringWriter
    //   71	146	5	localPrintWriter	java.io.PrintWriter
    //   101	145	6	i	int
    // Exception table:
    //   from	to	target	type
    //   73	85	193	java/lang/Exception
    //   194	204	209	java/lang/Exception
    //   73	85	215	finally
    //   216	226	264	java/lang/Exception
    //   85	95	268	java/lang/Exception
  }
  
  public static class UTExceptionItem
  {
    boolean Q = false;
    String ap = null;
    String aq = null;
    String ar = null;
    
    public String getCrashDetail()
    {
      return this.ar;
    }
    
    public String getExpName()
    {
      return this.ap;
    }
    
    public String getMd5()
    {
      return this.aq;
    }
    
    public boolean isCrashedByUT()
    {
      return this.Q;
    }
    
    public void setCrashDetail(String paramString)
    {
      this.ar = paramString;
    }
    
    public void setExpName(String paramString)
    {
      this.ap = paramString;
    }
    
    public void setMd5(String paramString)
    {
      this.aq = paramString;
    }
    
    public void setmCrashedByUT(boolean paramBoolean)
    {
      this.Q = paramBoolean;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\crashhandler\UTExceptionParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */