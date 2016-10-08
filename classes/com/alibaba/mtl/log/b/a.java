package com.alibaba.mtl.log.b;

import android.text.TextUtils;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import java.util.List;

public class a
{
  private static StringBuilder a = new StringBuilder();
  private static volatile long e;
  private static long f;
  private static long g;
  private static long h;
  private static long i;
  private static long j = 0L;
  private static long k = 0L;
  private static long l = 0L;
  private static long m = 0L;
  private static long n;
  private static long o;
  private static long p;
  private static long q;
  private static long r;
  private static long s;
  private static long t;
  private static int jdField_u_of_type_Int;
  private static long jdField_u_of_type_Long;
  private static int jdField_v_of_type_Int = 0;
  private static long jdField_v_of_type_Long;
  private static int jdField_w_of_type_Int = 0;
  private static long jdField_w_of_type_Long;
  private static long x;
  private static long y;
  
  static
  {
    n = 0L;
    o = 0L;
    p = 0L;
    q = 0L;
    r = 0L;
    s = 0L;
    t = 0L;
    jdField_u_of_type_Long = 0L;
    jdField_v_of_type_Long = 0L;
    jdField_w_of_type_Long = 0L;
    x = 0L;
    y = 0L;
  }
  
  public static void A()
  {
    try
    {
      jdField_u_of_type_Long += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void B()
  {
    String str = l.u();
    if ("wifi".equalsIgnoreCase(str))
    {
      m += 1L;
      return;
    }
    if ("3G".equalsIgnoreCase(str))
    {
      k += 1L;
      return;
    }
    if ("4G".equalsIgnoreCase(str))
    {
      l += 1L;
      return;
    }
    if ("2G".equalsIgnoreCase(str))
    {
      j += 1L;
      return;
    }
    jdField_v_of_type_Int += 1;
  }
  
  /* Error */
  public static void C()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	com/alibaba/mtl/log/b/a:jdField_w_of_type_Int	I
    //   6: iconst_1
    //   7: iadd
    //   8: putstatic 43	com/alibaba/mtl/log/b/a:jdField_w_of_type_Int	I
    //   11: getstatic 99	com/alibaba/mtl/log/b/a:e	J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifne +17 -> 33
    //   19: getstatic 101	com/alibaba/mtl/log/b/a:g	J
    //   22: lstore_1
    //   23: lload_1
    //   24: lconst_0
    //   25: lcmp
    //   26: ifne +7 -> 33
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: getstatic 106	com/alibaba/mtl/log/a:o	Z
    //   36: ifne +11 -> 47
    //   39: getstatic 43	com/alibaba/mtl/log/b/a:jdField_w_of_type_Int	I
    //   42: bipush 6
    //   44: if_icmplt -15 -> 29
    //   47: iconst_1
    //   48: invokestatic 110	com/alibaba/mtl/log/b/a:c	(Z)V
    //   51: goto -22 -> 29
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   54	5	0	localObject	Object
    //   22	2	1	l1	long
    // Exception table:
    //   from	to	target	type
    //   3	23	54	finally
    //   33	47	54	finally
    //   47	51	54	finally
  }
  
  public static void a(List<com.alibaba.mtl.log.model.a> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    int i4 = 0;
    int i2;
    for (int i1 = 0;; i1 = i2)
    {
      try
      {
        if (i4 < paramList.size())
        {
          com.alibaba.mtl.log.model.a locala = (com.alibaba.mtl.log.model.a)paramList.get(i4);
          i2 = i1;
          if (locala != null)
          {
            int i3 = i1;
            if (!"6005".equalsIgnoreCase(locala.U)) {
              i3 = i1 + 1;
            }
            a.append(locala.Y);
            i2 = i3;
            if (i4 != paramList.size() - 1)
            {
              a.append(",");
              i2 = i3;
            }
          }
        }
        else
        {
          i.a("CoreStatics", new Object[] { "[uploadInc]:", Long.valueOf(g), "count:", Integer.valueOf(paramInt) });
          g += paramInt;
          i.a("CoreStatics", new Object[] { "[uploadInc]:", Long.valueOf(g) });
          if (i1 == paramInt) {
            break;
          }
          i.a("CoreStatics", "Mutil Process Upload Error");
          break;
        }
      }
      finally {}
      i4 += 1;
    }
  }
  
  public static void c(boolean paramBoolean) {}
  
  public static void d(int paramInt)
  {
    try
    {
      jdField_u_of_type_Int += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return "6005".equalsIgnoreCase(paramString.trim());
  }
  
  public static void o(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = e(paramString);
        if (bool) {
          return;
        }
        if ("65501".equalsIgnoreCase(paramString))
        {
          y += 1L;
          e += 1L;
          continue;
        }
        if (!"65133".equalsIgnoreCase(paramString)) {
          break label70;
        }
      }
      finally {}
      jdField_w_of_type_Long += 1L;
      continue;
      label70:
      if ("65502".equalsIgnoreCase(paramString)) {
        x += 1L;
      } else if ("65503".equalsIgnoreCase(paramString)) {
        jdField_v_of_type_Long += 1L;
      }
    }
  }
  
  /* Error */
  public static void p(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 183	com/alibaba/mtl/log/b/a:e	(Ljava/lang/String;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: getstatic 193	com/alibaba/mtl/log/b/a:f	J
    //   19: lconst_1
    //   20: ladd
    //   21: putstatic 193	com/alibaba/mtl/log/b/a:f	J
    //   24: invokestatic 195	com/alibaba/mtl/log/b/a:B	()V
    //   27: goto -15 -> 12
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramString	String
    //   7	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	30	finally
    //   16	27	30	finally
  }
  
  public static void r()
  {
    try
    {
      h += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void s()
  {
    try
    {
      i += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void t()
  {
    try
    {
      n += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void u()
  {
    try
    {
      o += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void v()
  {
    try
    {
      p += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void w()
  {
    try
    {
      q += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void x()
  {
    try
    {
      r += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void y()
  {
    try
    {
      s += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void z()
  {
    try
    {
      t += 1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */