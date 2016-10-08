package com.alibaba.mtl.log.d;

import android.os.SystemClock;
import com.alibaba.mtl.log.c.c;
import com.alibaba.mtl.log.e.a.a;
import com.alibaba.mtl.log.e.e;
import com.alibaba.mtl.log.e.e.a;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.k;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.e.t;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public abstract class b
  implements Runnable
{
  static int A = 0;
  private static volatile boolean E = false;
  private static boolean F = false;
  int B = -1;
  int C = 0;
  float a = 200.0F;
  
  private void K()
  {
    if (!l.isConnected()) {}
    while ((F) || (E)) {
      return;
    }
    E = true;
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        if (k.c(com.alibaba.mtl.log.a.getContext())) {
          break label61;
        }
        i.a("UploadTask", new Object[] { "Other Process is Uploading, break" });
      }
      label53:
      label61:
      List localList;
      int j;
      Object localObject2;
      for (;;)
      {
        E = false;
        k.release();
        return;
        c.a().E();
        localList = c.a().a(h());
        if ((localList == null) || (localList.size() == 0))
        {
          E = false;
        }
        else
        {
          j = b(localList);
          localObject2 = a(localList);
          if ((localObject2 != null) && (((Map)localObject2).size() != 0)) {
            break;
          }
          E = false;
        }
      }
      for (;;)
      {
        try
        {
          long l1 = SystemClock.elapsedRealtime();
          localObject2 = a(t.a(com.alibaba.mtl.log.a.a.R, null, (Map)localObject2), (Map)localObject2);
          boolean bool1 = ((a.a)localObject2).G;
          long l2 = SystemClock.elapsedRealtime();
          a(Boolean.valueOf(bool1), l2 - l1);
          if (bool1)
          {
            int k = c.a().a(localList);
            if (k < localList.size() - j) {
              J();
            }
            com.alibaba.mtl.log.b.a.a(localList, k);
            com.alibaba.mtl.log.b.a.r();
            long l3 = SystemClock.elapsedRealtime();
            i.a("UploadTask", new Object[] { "logs.size():", Integer.valueOf(localList.size()), " selfMonitorLogCount:", Integer.valueOf(j) });
            i.a("UploadTask", new Object[] { "upload isSendSuccess:", Boolean.valueOf(bool1), " consume:", Long.valueOf(l2 - l1), " delete consume:", Long.valueOf(l3 - l2) });
          }
        }
        catch (Throwable localThrowable2)
        {
          boolean bool2;
          k.release();
          continue;
        }
        finally
        {
          k.release();
        }
        try
        {
          Thread.sleep(new Random().nextInt(5000));
          k.release();
          i += 1;
          break;
          com.alibaba.mtl.log.b.a.d(localList.size() - j);
          com.alibaba.mtl.log.b.a.s();
          bool2 = ((a.a)localObject2).i();
          if (bool2)
          {
            k.release();
            break label53;
          }
          if (!((a.a)localObject2).j()) {
            continue;
          }
          F = true;
          k.release();
        }
        catch (Throwable localThrowable1)
        {
          i.a("UploadTask", "thread sleep interrupted", localThrowable1);
        }
      }
    }
  }
  
  private int a(Boolean paramBoolean, long paramLong)
  {
    if (paramLong < 0L) {
      return this.B;
    }
    float f = this.C / (float)paramLong;
    if (paramBoolean.booleanValue())
    {
      if (paramLong > 45000L) {
        return this.B;
      }
      this.B = ((int)(f * 45000.0F / this.a - A));
      if (this.B >= 1) {
        break label130;
      }
      this.B = 1;
      A = 0;
    }
    for (;;)
    {
      i.a("UploadTask", new Object[] { "winsize:", Integer.valueOf(this.B) });
      return this.B;
      this.B /= 2;
      A += 1;
      break;
      label130:
      if (this.B > 350) {
        this.B = 350;
      }
    }
  }
  
  private a.a a(String paramString, Map<String, Object> paramMap)
  {
    if (paramString != null)
    {
      paramMap = e.a(2, paramString, paramMap, false).e;
      i.a("UploadTask", new Object[] { "url:", paramString });
      if (paramMap != null) {
        try
        {
          paramString = new String(paramMap, "UTF-8");
          if (paramString != null)
          {
            i.a("UploadTask", new Object[] { "result:", paramString });
            return com.alibaba.mtl.log.e.a.a(paramString);
          }
        }
        catch (UnsupportedEncodingException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        }
      }
    }
    return a.a.a;
  }
  
  private List<String> a(com.alibaba.mtl.log.model.a parama)
  {
    return com.alibaba.mtl.log.a.a.a(parama.U);
  }
  
  private Map<String, Object> a(List<com.alibaba.mtl.log.model.a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      localObject2 = a((com.alibaba.mtl.log.model.a)paramList.get(i));
      if (localObject2 != null)
      {
        int j = 0;
        if (j < ((List)localObject2).size())
        {
          localObject1 = (StringBuilder)localHashMap.get(((List)localObject2).get(j));
          if (localObject1 == null)
          {
            localObject1 = new StringBuilder();
            localHashMap.put(((List)localObject2).get(j), localObject1);
          }
          for (;;)
          {
            ((StringBuilder)localObject1).append(((com.alibaba.mtl.log.model.a)paramList.get(i)).h());
            j += 1;
            break;
            ((StringBuilder)localObject1).append("\n");
          }
        }
      }
      i += 1;
    }
    Object localObject1 = new HashMap();
    this.C = 0;
    Object localObject2 = localHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      byte[] arrayOfByte = a(((StringBuilder)localHashMap.get(str)).toString());
      ((HashMap)localObject1).put(str, arrayOfByte);
      this.C += arrayOfByte.length;
    }
    this.a = (this.C / paramList.size());
    i.a("UploadTask", new Object[] { "averagePackageSize:", Float.valueOf(this.a) });
    return (Map<String, Object>)localObject1;
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 315	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 316	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 318	java/util/zip/GZIPOutputStream
    //   12: dup
    //   13: aload 5
    //   15: invokespecial 321	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_3
    //   22: aload_1
    //   23: ldc -36
    //   25: invokevirtual 324	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   28: invokevirtual 328	java/util/zip/GZIPOutputStream:write	([B)V
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: invokevirtual 331	java/util/zip/GZIPOutputStream:flush	()V
    //   37: aload_3
    //   38: ifnull +7 -> 45
    //   41: aload_3
    //   42: invokevirtual 334	java/util/zip/GZIPOutputStream:close	()V
    //   45: aload 5
    //   47: invokevirtual 338	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   50: ldc_w 340
    //   53: invokestatic 345	com/alibaba/mtl/log/e/n:a	([BLjava/lang/String;)[B
    //   56: astore_1
    //   57: aload 5
    //   59: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   62: aload_1
    //   63: areturn
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: astore_2
    //   70: aload 4
    //   72: invokevirtual 347	java/io/IOException:printStackTrace	()V
    //   75: aload_1
    //   76: ifnull -31 -> 45
    //   79: aload_1
    //   80: invokevirtual 334	java/util/zip/GZIPOutputStream:close	()V
    //   83: goto -38 -> 45
    //   86: astore_1
    //   87: goto -42 -> 45
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 334	java/util/zip/GZIPOutputStream:close	()V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: goto -59 -> 45
    //   107: astore_2
    //   108: goto -7 -> 101
    //   111: astore_2
    //   112: aload_1
    //   113: areturn
    //   114: astore_1
    //   115: goto -22 -> 93
    //   118: astore 4
    //   120: aload_3
    //   121: astore_1
    //   122: goto -54 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	b
    //   0	125	1	paramString	String
    //   20	78	2	localObject	Object
    //   107	1	2	localException1	Exception
    //   111	1	2	localException2	Exception
    //   18	103	3	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   64	7	4	localIOException1	java.io.IOException
    //   118	1	4	localIOException2	java.io.IOException
    //   7	51	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	19	64	java/io/IOException
    //   79	83	86	java/lang/Exception
    //   9	19	90	finally
    //   41	45	103	java/lang/Exception
    //   97	101	107	java/lang/Exception
    //   57	62	111	java/lang/Exception
    //   21	31	114	finally
    //   33	37	114	finally
    //   70	75	114	finally
    //   21	31	118	java/io/IOException
    //   33	37	118	java/io/IOException
  }
  
  private int b(List<com.alibaba.mtl.log.model.a> paramList)
  {
    if (paramList == null) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < paramList.size(); j = k)
    {
      String str = ((com.alibaba.mtl.log.model.a)paramList.get(i)).U;
      k = j;
      if (str != null)
      {
        k = j;
        if ("6005".equalsIgnoreCase(str.toString())) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  private int h()
  {
    String str;
    if (this.B == -1)
    {
      str = l.u();
      if (!"wifi".equalsIgnoreCase(str)) {
        break label33;
      }
      this.B = 20;
    }
    for (;;)
    {
      return this.B;
      label33:
      if ("4G".equalsIgnoreCase(str)) {
        this.B = 16;
      } else if ("3G".equalsIgnoreCase(str)) {
        this.B = 12;
      } else {
        this.B = 8;
      }
    }
  }
  
  public static boolean isRunning()
  {
    return E;
  }
  
  public abstract void I();
  
  public abstract void J();
  
  public void run()
  {
    try
    {
      K();
      I();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */