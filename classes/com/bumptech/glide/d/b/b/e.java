package com.bumptech.glide.d.b.b;

import android.util.Log;
import com.bumptech.glide.a.a.c;
import java.io.File;
import java.io.IOException;

public class e
  implements a
{
  private static e a = null;
  private final c b = new c();
  private final k c;
  private final File d;
  private final int e;
  private com.bumptech.glide.a.a f;
  
  protected e(File paramFile, int paramInt)
  {
    this.d = paramFile;
    this.e = paramInt;
    this.c = new k();
  }
  
  public static a a(File paramFile, int paramInt)
  {
    try
    {
      if (a == null) {
        a = new e(paramFile, paramInt);
      }
      paramFile = a;
      return paramFile;
    }
    finally {}
  }
  
  private com.bumptech.glide.a.a b()
  {
    try
    {
      if (this.f == null) {
        this.f = com.bumptech.glide.a.a.a(this.d, 1, 1, this.e);
      }
      com.bumptech.glide.a.a locala = this.f;
      return locala;
    }
    finally {}
  }
  
  private void c()
  {
    try
    {
      this.f = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public File a(com.bumptech.glide.d.c paramc)
  {
    paramc = this.c.a(paramc);
    Object localObject = null;
    try
    {
      a.c localc = b().a(paramc);
      paramc = (com.bumptech.glide.d.c)localObject;
      if (localc != null) {
        paramc = localc.a(0);
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramc = (com.bumptech.glide.d.c)localObject;
      } while (!Log.isLoggable("DiskLruCacheWrapper", 5));
      Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", localIOException);
    }
    return paramc;
    return null;
  }
  
  public void a()
  {
    try
    {
      b().a();
      c();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
          Log.w("DiskLruCacheWrapper", "Unable to clear disk cache", localIOException);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public void a(com.bumptech.glide.d.c paramc, a.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/bumptech/glide/d/b/b/e:c	Lcom/bumptech/glide/d/b/b/k;
    //   4: aload_1
    //   5: invokevirtual 58	com/bumptech/glide/d/b/b/k:a	(Lcom/bumptech/glide/d/c;)Ljava/lang/String;
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 32	com/bumptech/glide/d/b/b/e:b	Lcom/bumptech/glide/d/b/b/c;
    //   13: aload_1
    //   14: invokevirtual 92	com/bumptech/glide/d/b/b/c:a	(Lcom/bumptech/glide/d/c;)V
    //   17: aload_0
    //   18: invokespecial 60	com/bumptech/glide/d/b/b/e:b	()Lcom/bumptech/glide/a/a;
    //   21: aload_3
    //   22: invokevirtual 95	com/bumptech/glide/a/a:b	(Ljava/lang/String;)Lcom/bumptech/glide/a/a$a;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +25 -> 52
    //   30: aload_2
    //   31: aload_3
    //   32: iconst_0
    //   33: invokevirtual 98	com/bumptech/glide/a/a$a:a	(I)Ljava/io/File;
    //   36: invokeinterface 103 2 0
    //   41: ifeq +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 104	com/bumptech/glide/a/a$a:a	()V
    //   48: aload_3
    //   49: invokevirtual 105	com/bumptech/glide/a/a$a:c	()V
    //   52: aload_0
    //   53: getfield 32	com/bumptech/glide/d/b/b/e:b	Lcom/bumptech/glide/d/b/b/c;
    //   56: aload_1
    //   57: invokevirtual 107	com/bumptech/glide/d/b/b/c:b	(Lcom/bumptech/glide/d/c;)V
    //   60: return
    //   61: astore_2
    //   62: aload_3
    //   63: invokevirtual 105	com/bumptech/glide/a/a$a:c	()V
    //   66: aload_2
    //   67: athrow
    //   68: astore_2
    //   69: ldc 70
    //   71: iconst_5
    //   72: invokestatic 76	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   75: ifeq +12 -> 87
    //   78: ldc 70
    //   80: ldc 109
    //   82: aload_2
    //   83: invokestatic 82	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   86: pop
    //   87: aload_0
    //   88: getfield 32	com/bumptech/glide/d/b/b/e:b	Lcom/bumptech/glide/d/b/b/c;
    //   91: aload_1
    //   92: invokevirtual 107	com/bumptech/glide/d/b/b/c:b	(Lcom/bumptech/glide/d/c;)V
    //   95: return
    //   96: astore_2
    //   97: aload_0
    //   98: getfield 32	com/bumptech/glide/d/b/b/e:b	Lcom/bumptech/glide/d/b/b/c;
    //   101: aload_1
    //   102: invokevirtual 107	com/bumptech/glide/d/b/b/c:b	(Lcom/bumptech/glide/d/c;)V
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	e
    //   0	107	1	paramc	com.bumptech.glide.d.c
    //   0	107	2	paramb	a.b
    //   8	55	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	48	61	finally
    //   17	26	68	java/io/IOException
    //   48	52	68	java/io/IOException
    //   62	68	68	java/io/IOException
    //   17	26	96	finally
    //   48	52	96	finally
    //   62	68	96	finally
    //   69	87	96	finally
  }
  
  public void b(com.bumptech.glide.d.c paramc)
  {
    paramc = this.c.a(paramc);
    try
    {
      b().c(paramc);
      return;
    }
    catch (IOException paramc)
    {
      while (!Log.isLoggable("DiskLruCacheWrapper", 5)) {}
      Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", paramc);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */