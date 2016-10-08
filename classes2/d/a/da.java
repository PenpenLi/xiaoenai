package d.a;

import android.content.Context;
import java.util.List;
import java.util.Map;

public class da
{
  private static Context a;
  
  private da()
  {
    if (a != null) {}
  }
  
  public static da a(Context paramContext)
  {
    a = paramContext;
    return a.a();
  }
  
  public Map<String, List<z.d>> a()
  {
    try
    {
      Map localMap = a.b(ad.a(a).a());
      return localMap;
    }
    catch (Exception localException)
    {
      ax.d("upload agg date error");
      return null;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  /* Error */
  public void a(cj paramcj)
  {
    // Byte code:
    //   0: getstatic 14	d/a/da:a	Landroid/content/Context;
    //   3: invokestatic 29	d/a/ad:a	(Landroid/content/Context;)Ld/a/ad;
    //   6: invokevirtual 32	d/a/ad:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: invokestatic 55	d/a/a:a	(Landroid/database/sqlite/SQLiteDatabase;)Ljava/lang/String;
    //   14: astore_3
    //   15: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   18: invokestatic 66	d/a/dd:a	(J)Ljava/lang/String;
    //   21: astore 4
    //   23: aload_3
    //   24: ldc 68
    //   26: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +20 -> 49
    //   32: aload_1
    //   33: ldc 76
    //   35: iconst_0
    //   36: invokevirtual 81	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   39: getstatic 14	d/a/da:a	Landroid/content/Context;
    //   42: invokestatic 29	d/a/ad:a	(Landroid/content/Context;)Ld/a/ad;
    //   45: invokevirtual 41	d/a/ad:c	()V
    //   48: return
    //   49: aload_3
    //   50: aload 4
    //   52: invokevirtual 74	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne +19 -> 74
    //   58: aload_2
    //   59: aload_1
    //   60: invokestatic 84	d/a/a:a	(Landroid/database/sqlite/SQLiteDatabase;Ld/a/cj;)Z
    //   63: pop
    //   64: getstatic 14	d/a/da:a	Landroid/content/Context;
    //   67: invokestatic 29	d/a/ad:a	(Landroid/content/Context;)Ld/a/ad;
    //   70: invokevirtual 41	d/a/ad:c	()V
    //   73: return
    //   74: aload_2
    //   75: aload_1
    //   76: invokestatic 86	d/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ld/a/cj;)Z
    //   79: pop
    //   80: goto -16 -> 64
    //   83: astore_2
    //   84: aload_1
    //   85: iconst_0
    //   86: invokestatic 92	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   89: iconst_0
    //   90: invokevirtual 81	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   93: ldc 94
    //   95: invokestatic 49	d/a/ax:d	(Ljava/lang/String;)V
    //   98: getstatic 14	d/a/da:a	Landroid/content/Context;
    //   101: invokestatic 29	d/a/ad:a	(Landroid/content/Context;)Ld/a/ad;
    //   104: invokevirtual 41	d/a/ad:c	()V
    //   107: return
    //   108: astore_1
    //   109: getstatic 14	d/a/da:a	Landroid/content/Context;
    //   112: invokestatic 29	d/a/ad:a	(Landroid/content/Context;)Ld/a/ad;
    //   115: invokevirtual 41	d/a/ad:c	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	da
    //   0	120	1	paramcj	cj
    //   9	66	2	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   83	1	2	localException	Exception
    //   14	36	3	str1	String
    //   21	30	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	39	83	java/lang/Exception
    //   49	64	83	java/lang/Exception
    //   74	80	83	java/lang/Exception
    //   0	39	108	finally
    //   49	64	108	finally
    //   74	80	108	finally
    //   84	98	108	finally
  }
  
  public void a(cj paramcj, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      a.a(ad.a(a).b(), paramString, paramLong1, paramLong2);
      paramcj.a("success", false);
      return;
    }
    catch (Exception paramcj)
    {
      ax.d("package size to big or envelopeOverflowPackageCount exception");
      return;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  public void a(cj paramcj, List<String> paramList)
  {
    try
    {
      a.a(paramcj, ad.a(a).b(), paramList);
      return;
    }
    catch (Exception paramcj)
    {
      ax.d("saveToLimitCKTable exception");
      return;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  public void a(cj paramcj, Map<List<String>, cl> paramMap)
  {
    try
    {
      a.a(ad.a(a).b(), paramMap.values());
      paramcj.a("success", false);
      return;
    }
    catch (Exception paramcj)
    {
      ax.d("save agg data error");
      return;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  public void a(cj paramcj, boolean paramBoolean)
  {
    try
    {
      a.a(ad.a(a).b(), paramBoolean, paramcj);
      return;
    }
    catch (Exception paramcj)
    {
      ax.d("notifyUploadSuccess error");
      return;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  public List<String> b()
  {
    try
    {
      List localList = a.c(ad.a(a).a());
      return localList;
    }
    catch (Exception localException)
    {
      ax.d("loadCKToMemory exception");
      return null;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  public Map<String, List<z.e>> b(cj paramcj)
  {
    try
    {
      paramcj = a.a(paramcj, ad.a(a).a());
      return paramcj;
    }
    catch (Exception paramcj)
    {
      paramcj.printStackTrace();
      return null;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  public void b(cj paramcj, Map<String, cm> paramMap)
  {
    try
    {
      a.a(ad.a(a).b(), paramMap, paramcj);
      return;
    }
    catch (Exception paramcj)
    {
      ax.d("arrgetated system buffer exception");
      return;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  public void c(cj paramcj, Map<List<String>, cl> paramMap)
  {
    try
    {
      a.a(paramcj, ad.a(a).b(), paramMap.values());
      return;
    }
    catch (Exception paramcj)
    {
      ax.d("cacheToData error");
      return;
    }
    finally
    {
      ad.a(a).c();
    }
  }
  
  private static final class a
  {
    private static final da a = new da(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */