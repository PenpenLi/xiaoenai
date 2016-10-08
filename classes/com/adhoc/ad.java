package com.adhoc;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;

public class ad
{
  private static ad a;
  private Context b;
  
  private ad(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static ad a(Context paramContext)
  {
    if (a == null) {
      a = new ad(paramContext);
    }
    return a;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!b())
    {
      fl.b("写SDCARD文件失败！SDCARD 挂载状态 " + a(this.b).b());
      return false;
    }
    File localFile = new File(paramString1);
    if (localFile.exists())
    {
      localFile.delete();
      fl.a("删除文件" + paramString1);
    }
    try
    {
      localFile.createNewFile();
      paramString1 = new FileOutputStream(localFile);
      paramString1.write(paramString2.getBytes());
      paramString1.close();
      return true;
    }
    catch (Throwable paramString1)
    {
      fl.a(paramString1);
      try
      {
        localFile.delete();
        return false;
      }
      catch (Throwable paramString1)
      {
        fl.a(paramString1);
      }
    }
    return false;
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 27	com/adhoc/ad:b	()Z
    //   4: ifne +36 -> 40
    //   7: new 29	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   14: ldc 93
    //   16: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 15	com/adhoc/ad:b	Landroid/content/Context;
    //   23: invokestatic 38	com/adhoc/ad:a	(Landroid/content/Context;)Lcom/adhoc/ad;
    //   26: invokevirtual 27	com/adhoc/ad:b	()Z
    //   29: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 50	com/adhoc/fl:b	(Ljava/lang/String;)V
    //   38: aconst_null
    //   39: areturn
    //   40: new 52	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_2
    //   50: invokevirtual 57	java/io/File:exists	()Z
    //   53: ifeq -15 -> 38
    //   56: new 95	java/io/FileInputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore_3
    //   65: sipush 1024
    //   68: newarray <illegal type>
    //   70: astore_2
    //   71: aload_3
    //   72: aload_2
    //   73: iconst_0
    //   74: sipush 1024
    //   77: invokevirtual 100	java/io/FileInputStream:read	([BII)I
    //   80: istore 4
    //   82: iload 4
    //   84: ifle +10 -> 94
    //   87: aload_3
    //   88: invokevirtual 104	java/io/FileInputStream:available	()I
    //   91: ifle +39 -> 130
    //   94: new 29	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   101: ldc 106
    //   103: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 108
    //   112: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 64	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   121: aload_3
    //   122: invokevirtual 109	java/io/FileInputStream:close	()V
    //   125: aconst_null
    //   126: astore_1
    //   127: goto +76 -> 203
    //   130: new 74	java/lang/String
    //   133: dup
    //   134: aload_2
    //   135: iconst_0
    //   136: iload 4
    //   138: invokespecial 112	java/lang/String:<init>	([BII)V
    //   141: astore_2
    //   142: aload_3
    //   143: invokevirtual 109	java/io/FileInputStream:close	()V
    //   146: aload_2
    //   147: astore_1
    //   148: goto +55 -> 203
    //   151: astore_3
    //   152: new 29	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   159: ldc 114
    //   161: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 50	com/adhoc/fl:b	(Ljava/lang/String;)V
    //   174: aload_2
    //   175: astore_1
    //   176: goto +27 -> 203
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_2
    //   183: invokestatic 88	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   186: goto +17 -> 203
    //   189: astore_3
    //   190: aload_2
    //   191: astore_1
    //   192: aload_3
    //   193: astore_2
    //   194: goto -12 -> 182
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -48 -> 152
    //   203: aload_1
    //   204: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	ad
    //   0	205	1	paramString	String
    //   48	127	2	localObject1	Object
    //   179	12	2	localThrowable1	Throwable
    //   193	1	2	localObject2	Object
    //   197	1	2	localIOException1	java.io.IOException
    //   199	1	2	localObject3	Object
    //   64	79	3	localFileInputStream	java.io.FileInputStream
    //   151	1	3	localIOException2	java.io.IOException
    //   189	4	3	localThrowable2	Throwable
    //   80	57	4	i	int
    // Exception table:
    //   from	to	target	type
    //   142	146	151	java/io/IOException
    //   40	82	179	java/lang/Throwable
    //   87	94	179	java/lang/Throwable
    //   94	125	179	java/lang/Throwable
    //   130	142	179	java/lang/Throwable
    //   142	146	189	java/lang/Throwable
    //   40	82	197	java/io/IOException
    //   87	94	197	java/io/IOException
    //   94	125	197	java/io/IOException
    //   130	142	197	java/io/IOException
  }
  
  private String c()
  {
    Object localObject = null;
    if (b())
    {
      localObject = Environment.getExternalStoragePublicDirectory("Adhoc");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath();
    }
    return (String)localObject;
  }
  
  public String a()
  {
    String str = c();
    return b(str + "/" + "ADHOC_CLIENT_ID");
  }
  
  public boolean a(String paramString)
  {
    String str = c();
    return a(str + "/" + "ADHOC_CLIENT_ID", paramString);
  }
  
  public boolean b()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */