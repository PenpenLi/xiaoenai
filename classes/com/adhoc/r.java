package com.adhoc;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class r
{
  private static r a;
  
  public static r a()
  {
    if (a == null) {
      a = new r();
    }
    return a;
  }
  
  private File c(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir(), paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramString)
    {
      fl.a(paramString);
    }
    return paramContext;
  }
  
  public void a(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir(), paramString);
    if (paramContext.exists()) {
      paramContext.delete();
    }
    fl.a("清除文件缓存文件");
  }
  
  /* Error */
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokespecial 58	com/adhoc/r:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   11: astore_1
    //   12: new 60	java/io/BufferedWriter
    //   15: dup
    //   16: new 62	java/io/OutputStreamWriter
    //   19: dup
    //   20: new 64	java/io/FileOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokevirtual 68	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: iconst_1
    //   29: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   32: invokespecial 74	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   35: invokespecial 77	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   38: astore_1
    //   39: aload_1
    //   40: aload_3
    //   41: invokevirtual 80	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   44: aload_1
    //   45: invokevirtual 83	java/io/BufferedWriter:close	()V
    //   48: new 85	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   55: ldc 88
    //   57: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_3
    //   61: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 51	com/adhoc/fl:a	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: monitorexit
    //   72: iload 4
    //   74: ireturn
    //   75: astore_1
    //   76: ldc 97
    //   78: invokestatic 100	com/adhoc/fl:b	(Ljava/lang/String;)V
    //   81: iconst_0
    //   82: istore 4
    //   84: goto -14 -> 70
    //   87: astore_1
    //   88: ldc 102
    //   90: invokestatic 100	com/adhoc/fl:b	(Ljava/lang/String;)V
    //   93: iconst_0
    //   94: istore 4
    //   96: goto -26 -> 70
    //   99: astore_1
    //   100: aload_1
    //   101: invokestatic 105	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   104: iconst_0
    //   105: istore 4
    //   107: goto -37 -> 70
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	r
    //   0	115	1	paramContext	Context
    //   0	115	2	paramString1	String
    //   0	115	3	paramString2	String
    //   1	105	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   12	70	75	java/io/FileNotFoundException
    //   12	70	87	java/io/IOException
    //   12	70	99	java/lang/Throwable
    //   5	12	110	finally
    //   12	70	110	finally
    //   76	81	110	finally
    //   88	93	110	finally
    //   100	104	110	finally
  }
  
  public ArrayList<String> b(Context paramContext, String paramString)
  {
    localArrayList = new ArrayList();
    Object localObject = c(paramContext, paramString);
    try
    {
      localObject = new BufferedReader(new InputStreamReader(new FileInputStream((File)localObject), "utf-8"));
      for (;;)
      {
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        localArrayList.add(str);
        fl.a(str);
      }
      return localArrayList;
    }
    catch (FileNotFoundException paramContext)
    {
      fl.a(paramContext);
      return localArrayList;
      ((BufferedReader)localObject).close();
      return localArrayList;
    }
    catch (IOException localIOException)
    {
      fl.b("Fails to read file: " + paramString);
      paramContext.deleteFile(paramString);
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */