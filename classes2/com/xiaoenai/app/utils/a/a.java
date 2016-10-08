package com.xiaoenai.app.utils.a;

import android.os.Process;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class a
{
  private static Map<String, a> a = new HashMap();
  private a b;
  
  private a(File paramFile, long paramLong, int paramInt)
  {
    if ((!paramFile.exists()) && (!paramFile.mkdirs())) {
      throw new RuntimeException("can't make dirs in " + paramFile.getAbsolutePath());
    }
    this.b = new a(paramFile, paramLong, paramInt, null);
  }
  
  public static a a(File paramFile, long paramLong, int paramInt)
  {
    a locala2 = (a)a.get(paramFile.getAbsoluteFile() + b());
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramFile, paramLong, paramInt);
      a.put(paramFile.getAbsolutePath() + b(), locala1);
    }
    return locala1;
  }
  
  private static String b()
  {
    return "_" + Process.myPid();
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 60	com/xiaoenai/app/utils/a/a:b	Lcom/xiaoenai/app/utils/a/a$a;
    //   7: aload_1
    //   8: invokestatic 99	com/xiaoenai/app/utils/a/a$a:b	(Lcom/xiaoenai/app/utils/a/a$a;Ljava/lang/String;)Ljava/io/File;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 31	java/io/File:exists	()Z
    //   16: ifne +8 -> 24
    //   19: aload 5
    //   21: astore_2
    //   22: aload_2
    //   23: areturn
    //   24: new 101	java/io/BufferedReader
    //   27: dup
    //   28: new 103	java/io/FileReader
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 106	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   36: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_3
    //   40: ldc 111
    //   42: astore 4
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: invokevirtual 114	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnull +30 -> 84
    //   57: aload_3
    //   58: astore_2
    //   59: new 38	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   66: aload 4
    //   68: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload 6
    //   73: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 4
    //   81: goto -37 -> 44
    //   84: aload_3
    //   85: astore_2
    //   86: aload 4
    //   88: invokestatic 117	com/xiaoenai/app/utils/a/a$b:a	(Ljava/lang/String;)Z
    //   91: ifne +30 -> 121
    //   94: aload_3
    //   95: astore_2
    //   96: aload 4
    //   98: invokestatic 119	com/xiaoenai/app/utils/a/a$b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_1
    //   102: aload_1
    //   103: astore_2
    //   104: aload_3
    //   105: ifnull -83 -> 22
    //   108: aload_3
    //   109: invokevirtual 122	java/io/BufferedReader:close	()V
    //   112: aload_1
    //   113: areturn
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   119: aload_1
    //   120: areturn
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 122	java/io/BufferedReader:close	()V
    //   129: aload_0
    //   130: aload_1
    //   131: invokevirtual 128	com/xiaoenai/app/utils/a/a:d	(Ljava/lang/String;)Z
    //   134: pop
    //   135: aconst_null
    //   136: areturn
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   142: goto -13 -> 129
    //   145: astore 4
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_1
    //   150: astore_2
    //   151: aload 4
    //   153: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   156: aload 5
    //   158: astore_2
    //   159: aload_1
    //   160: ifnull -138 -> 22
    //   163: aload_1
    //   164: invokevirtual 122	java/io/BufferedReader:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_2
    //   180: ifnull +7 -> 187
    //   183: aload_2
    //   184: invokevirtual 122	java/io/BufferedReader:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: astore_2
    //   190: aload_2
    //   191: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore_1
    //   198: goto -19 -> 179
    //   201: astore 4
    //   203: aload_3
    //   204: astore_1
    //   205: goto -56 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	a
    //   0	208	1	paramString	String
    //   11	93	2	localObject1	Object
    //   114	2	2	localIOException1	java.io.IOException
    //   137	2	2	localIOException2	java.io.IOException
    //   150	34	2	localObject2	Object
    //   189	2	2	localIOException3	java.io.IOException
    //   39	165	3	localBufferedReader	java.io.BufferedReader
    //   42	55	4	str1	String
    //   145	7	4	localIOException4	java.io.IOException
    //   201	1	4	localIOException5	java.io.IOException
    //   1	156	5	localObject3	Object
    //   50	22	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   108	112	114	java/io/IOException
    //   125	129	137	java/io/IOException
    //   24	40	145	java/io/IOException
    //   163	167	169	java/io/IOException
    //   24	40	176	finally
    //   183	187	189	java/io/IOException
    //   46	52	197	finally
    //   59	81	197	finally
    //   86	94	197	finally
    //   96	102	197	finally
    //   151	156	197	finally
    //   46	52	201	java/io/IOException
    //   59	81	201	java/io/IOException
    //   86	94	201	java/io/IOException
    //   96	102	201	java/io/IOException
  }
  
  public void a()
  {
    a.a(this.b);
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/xiaoenai/app/utils/a/a:b	Lcom/xiaoenai/app/utils/a/a$a;
    //   4: aload_1
    //   5: invokestatic 134	com/xiaoenai/app/utils/a/a$a:a	(Lcom/xiaoenai/app/utils/a/a$a;Ljava/lang/String;)Ljava/io/File;
    //   8: astore 5
    //   10: aconst_null
    //   11: astore_1
    //   12: new 136	java/io/BufferedWriter
    //   15: dup
    //   16: new 138	java/io/FileWriter
    //   19: dup
    //   20: aload 5
    //   22: invokespecial 139	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   25: sipush 1024
    //   28: invokespecial 142	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: aload_2
    //   36: invokevirtual 145	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   39: aload_3
    //   40: ifnull +11 -> 51
    //   43: aload_3
    //   44: invokevirtual 148	java/io/BufferedWriter:flush	()V
    //   47: aload_3
    //   48: invokevirtual 149	java/io/BufferedWriter:close	()V
    //   51: aload_0
    //   52: getfield 60	com/xiaoenai/app/utils/a/a:b	Lcom/xiaoenai/app/utils/a/a$a;
    //   55: aload 5
    //   57: invokestatic 152	com/xiaoenai/app/utils/a/a$a:a	(Lcom/xiaoenai/app/utils/a/a$a;Ljava/io/File;)V
    //   60: return
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   66: goto -15 -> 51
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   80: aload_2
    //   81: ifnull +11 -> 92
    //   84: aload_2
    //   85: invokevirtual 148	java/io/BufferedWriter:flush	()V
    //   88: aload_2
    //   89: invokevirtual 149	java/io/BufferedWriter:close	()V
    //   92: aload_0
    //   93: getfield 60	com/xiaoenai/app/utils/a/a:b	Lcom/xiaoenai/app/utils/a/a$a;
    //   96: aload 5
    //   98: invokestatic 152	com/xiaoenai/app/utils/a/a$a:a	(Lcom/xiaoenai/app/utils/a/a$a;Ljava/io/File;)V
    //   101: return
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   107: goto -15 -> 92
    //   110: astore_3
    //   111: aload_1
    //   112: astore_2
    //   113: aload_3
    //   114: astore_1
    //   115: aload_2
    //   116: ifnull +11 -> 127
    //   119: aload_2
    //   120: invokevirtual 148	java/io/BufferedWriter:flush	()V
    //   123: aload_2
    //   124: invokevirtual 149	java/io/BufferedWriter:close	()V
    //   127: aload_0
    //   128: getfield 60	com/xiaoenai/app/utils/a/a:b	Lcom/xiaoenai/app/utils/a/a$a;
    //   131: aload 5
    //   133: invokestatic 152	com/xiaoenai/app/utils/a/a$a:a	(Lcom/xiaoenai/app/utils/a/a$a;Ljava/io/File;)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 125	java/io/IOException:printStackTrace	()V
    //   143: goto -16 -> 127
    //   146: astore_3
    //   147: aload_1
    //   148: astore_2
    //   149: aload_3
    //   150: astore_1
    //   151: goto -36 -> 115
    //   154: astore 4
    //   156: aload_3
    //   157: astore_2
    //   158: goto -85 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	a
    //   0	161	1	paramString1	String
    //   0	161	2	paramString2	String
    //   31	17	3	localBufferedWriter	java.io.BufferedWriter
    //   110	4	3	localObject1	Object
    //   146	11	3	localObject2	Object
    //   69	7	4	localIOException1	java.io.IOException
    //   154	1	4	localIOException2	java.io.IOException
    //   8	124	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   43	51	61	java/io/IOException
    //   12	32	69	java/io/IOException
    //   84	92	102	java/io/IOException
    //   12	32	110	finally
    //   119	127	138	java/io/IOException
    //   34	39	146	finally
    //   75	80	146	finally
    //   34	39	154	java/io/IOException
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, b.a(paramInt, paramString2));
  }
  
  public File b(String paramString)
  {
    paramString = a.a(this.b, paramString);
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  public File c(String paramString)
  {
    return a.a(this.b, paramString);
  }
  
  public boolean d(String paramString)
  {
    return a.c(this.b, paramString);
  }
  
  public class a
  {
    protected File a;
    private final AtomicLong c;
    private final AtomicInteger d;
    private final long e;
    private final int f;
    private final Map<File, Long> g = Collections.synchronizedMap(new HashMap());
    
    private a(File paramFile, long paramLong, int paramInt)
    {
      this.a = paramFile;
      this.e = paramLong;
      this.f = paramInt;
      this.c = new AtomicLong();
      this.d = new AtomicInteger();
      a();
    }
    
    private File a(String paramString)
    {
      paramString = b(paramString);
      Long localLong = Long.valueOf(System.currentTimeMillis());
      paramString.setLastModified(localLong.longValue());
      this.g.put(paramString, localLong);
      return paramString;
    }
    
    private void a()
    {
      new Thread(new c(this)).start();
    }
    
    private void a(File paramFile)
    {
      for (int i = this.d.get(); i + 1 > this.f; i = this.d.addAndGet(-1))
      {
        l1 = c();
        this.c.addAndGet(-l1);
      }
      this.d.addAndGet(1);
      long l2 = b(paramFile);
      for (long l1 = this.c.get(); l1 + l2 > this.e; l1 = this.c.addAndGet(-l1)) {
        l1 = c();
      }
      this.c.addAndGet(l2);
      Long localLong = Long.valueOf(System.currentTimeMillis());
      paramFile.setLastModified(localLong.longValue());
      this.g.put(paramFile, localLong);
    }
    
    private long b(File paramFile)
    {
      return paramFile.length();
    }
    
    private File b(String paramString)
    {
      return new File(this.a, paramString.hashCode() + "");
    }
    
    private void b()
    {
      this.g.clear();
      this.c.set(0L);
      File[] arrayOfFile = this.a.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          arrayOfFile[i].delete();
          i += 1;
        }
      }
    }
    
    private long c()
    {
      File localFile = null;
      long l1;
      if (this.g.isEmpty())
      {
        l1 = 0L;
        return l1;
      }
      Object localObject1 = this.g.entrySet();
      for (;;)
      {
        synchronized (this.g)
        {
          Iterator localIterator = ((Set)localObject1).iterator();
          localObject1 = null;
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (localFile == null)
            {
              localFile = (File)localEntry.getKey();
              localObject1 = (Long)localEntry.getValue();
            }
            else
            {
              Long localLong = (Long)localEntry.getValue();
              if (localLong.longValue() < ((Long)localObject1).longValue())
              {
                localFile = (File)localEntry.getKey();
                localObject1 = localLong;
              }
            }
          }
          else
          {
            long l2 = b(localFile);
            l1 = l2;
            if (!localFile.delete()) {
              break;
            }
            this.g.remove(localFile);
            return l2;
          }
        }
      }
    }
    
    private boolean c(String paramString)
    {
      return a(paramString).delete();
    }
  }
  
  private static class b
  {
    private static int a(byte[] paramArrayOfByte, char paramChar)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        if (paramArrayOfByte[i] == paramChar) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    private static String a(int paramInt)
    {
      for (String str = System.currentTimeMillis() + ""; str.length() < 13; str = "0" + str) {}
      return str + "-" + paramInt + ' ';
    }
    
    private static boolean a(byte[] paramArrayOfByte)
    {
      String[] arrayOfString = c(paramArrayOfByte);
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        for (paramArrayOfByte = arrayOfString[0]; paramArrayOfByte.startsWith("0"); paramArrayOfByte = paramArrayOfByte.substring(1, paramArrayOfByte.length())) {}
        long l1 = Long.valueOf(paramArrayOfByte).longValue();
        long l2 = Long.valueOf(arrayOfString[1]).longValue();
        if (System.currentTimeMillis() > l1 + l2 * 1000L) {
          return true;
        }
      }
      return false;
    }
    
    private static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = paramInt2 - paramInt1;
      if (i < 0) {
        throw new IllegalArgumentException(paramInt1 + " > " + paramInt2);
      }
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
      return arrayOfByte;
    }
    
    private static String b(int paramInt, String paramString)
    {
      return a(paramInt) + paramString;
    }
    
    private static boolean b(byte[] paramArrayOfByte)
    {
      return (paramArrayOfByte != null) && (paramArrayOfByte.length > 15) && (paramArrayOfByte[13] == 45) && (a(paramArrayOfByte, ' ') > 14);
    }
    
    private static boolean c(String paramString)
    {
      return a(paramString.getBytes());
    }
    
    private static String[] c(byte[] paramArrayOfByte)
    {
      if (b(paramArrayOfByte)) {
        return new String[] { new String(a(paramArrayOfByte, 0, 13)), new String(a(paramArrayOfByte, 14, a(paramArrayOfByte, ' '))) };
      }
      return null;
    }
    
    private static String d(String paramString)
    {
      String str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (b(paramString.getBytes())) {
          str = paramString.substring(paramString.indexOf(' ') + 1, paramString.length());
        }
      }
      return str;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */