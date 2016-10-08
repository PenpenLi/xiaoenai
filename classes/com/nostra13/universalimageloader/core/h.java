package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.a.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

final class h
  implements com.nostra13.universalimageloader.b.b.a, Runnable
{
  final String a;
  final com.nostra13.universalimageloader.core.e.a b;
  final c c;
  final com.nostra13.universalimageloader.core.f.a d;
  final com.nostra13.universalimageloader.core.f.b e;
  private final e f;
  private final g g;
  private final Handler h;
  private final d i;
  private final com.nostra13.universalimageloader.core.d.b j;
  private final com.nostra13.universalimageloader.core.d.b k;
  private final com.nostra13.universalimageloader.core.d.b l;
  private final com.nostra13.universalimageloader.core.b.b m;
  private final String n;
  private final com.nostra13.universalimageloader.core.a.e o;
  private final boolean p;
  private f q = f.a;
  
  public h(e parame, g paramg, Handler paramHandler)
  {
    this.f = parame;
    this.g = paramg;
    this.h = paramHandler;
    this.i = parame.a;
    this.j = this.i.p;
    this.k = this.i.s;
    this.l = this.i.t;
    this.m = this.i.q;
    this.a = paramg.a;
    this.n = paramg.b;
    this.b = paramg.c;
    this.o = paramg.d;
    this.c = paramg.e;
    this.d = paramg.f;
    this.e = paramg.g;
    this.p = this.c.s();
  }
  
  private Bitmap a(String paramString)
  {
    com.nostra13.universalimageloader.core.a.h localh = this.b.c();
    paramString = new com.nostra13.universalimageloader.core.b.c(this.n, paramString, this.a, this.o, localh, h(), this.c);
    return this.m.a(paramString);
  }
  
  private void a(com.nostra13.universalimageloader.core.a.b.a parama, Throwable paramThrowable)
  {
    if ((this.p) || (p()) || (j())) {
      return;
    }
    a(new j(this, parama, paramThrowable), false, this.h, this.f);
  }
  
  static void a(Runnable paramRunnable, boolean paramBoolean, Handler paramHandler, e parame)
  {
    if (paramBoolean)
    {
      paramRunnable.run();
      return;
    }
    if (paramHandler == null)
    {
      parame.a(paramRunnable);
      return;
    }
    paramHandler.post(paramRunnable);
  }
  
  private boolean b()
  {
    AtomicBoolean localAtomicBoolean = this.f.d();
    if (localAtomicBoolean.get()) {}
    synchronized (this.f.e())
    {
      if (localAtomicBoolean.get()) {
        com.nostra13.universalimageloader.b.c.a("ImageLoader is paused. Waiting...  [%s]", new Object[] { this.n });
      }
      try
      {
        this.f.e().wait();
        com.nostra13.universalimageloader.b.c.a(".. Resume loading [%s]", new Object[] { this.n });
        return j();
      }
      catch (InterruptedException localInterruptedException)
      {
        com.nostra13.universalimageloader.b.c.d("Task was interrupted [%s]", new Object[] { this.n });
        return true;
      }
    }
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.i.o.a(this.a);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      Object localObject2 = new com.nostra13.universalimageloader.core.a.e(paramInt1, paramInt2);
      c localc = new c.a().a(this.c).a(com.nostra13.universalimageloader.core.a.d.d).a();
      localObject1 = new com.nostra13.universalimageloader.core.b.c(this.n, com.nostra13.universalimageloader.core.d.b.a.c.b(((File)localObject1).getAbsolutePath()), this.a, (com.nostra13.universalimageloader.core.a.e)localObject2, com.nostra13.universalimageloader.core.a.h.a, h(), localc);
      localObject2 = this.m.a((com.nostra13.universalimageloader.core.b.c)localObject1);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (this.i.f != null)
        {
          com.nostra13.universalimageloader.b.c.a("Process image before cache on disk [%s]", new Object[] { this.n });
          localObject2 = this.i.f.a((Bitmap)localObject2);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            com.nostra13.universalimageloader.b.c.d("Bitmap processor for disk cache returned null [%s]", new Object[] { this.n });
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 != null)
      {
        boolean bool = this.i.o.a(this.a, (Bitmap)localObject1);
        ((Bitmap)localObject1).recycle();
        return bool;
      }
    }
    return false;
  }
  
  private boolean c()
  {
    if (this.c.f())
    {
      com.nostra13.universalimageloader.b.c.a("Delay %d ms before loading...  [%s]", new Object[] { Integer.valueOf(this.c.l()), this.n });
      try
      {
        Thread.sleep(this.c.l());
        return j();
      }
      catch (InterruptedException localInterruptedException)
      {
        com.nostra13.universalimageloader.b.c.d("Task was interrupted [%s]", new Object[] { this.n });
        return true;
      }
    }
    return false;
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    if ((p()) || (j())) {
      return false;
    }
    if (this.e != null) {
      a(new i(this, paramInt1, paramInt2), false, this.h, this.f);
    }
    return true;
  }
  
  private Bitmap d()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.i.o.a(this.a);
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
        {
          com.nostra13.universalimageloader.b.c.a("Load image from disk cache [%s]", new Object[] { this.n });
          this.q = f.b;
          i();
          localObject1 = a(com.nostra13.universalimageloader.core.d.b.a.c.b(((File)localObject1).getAbsolutePath()));
          if (localObject1 != null)
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
          }
        }
        Object localObject7;
        String str;
        File localFile;
        Object localObject2 = null;
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        try
        {
          if (((Bitmap)localObject1).getWidth() > 0)
          {
            localObject7 = localObject1;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (((Bitmap)localObject1).getHeight() > 0) {}
          }
          else
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            com.nostra13.universalimageloader.b.c.a("Load image from network [%s]", new Object[] { this.n });
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            this.q = f.a;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            str = this.a;
            localObject7 = str;
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            if (this.c.i())
            {
              localObject7 = str;
              localObject3 = localObject1;
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject6 = localObject1;
              if (e())
              {
                localObject3 = localObject1;
                localObject4 = localObject1;
                localObject5 = localObject1;
                localObject6 = localObject1;
                localFile = this.i.o.a(this.a);
                localObject7 = str;
                if (localFile != null)
                {
                  localObject3 = localObject1;
                  localObject4 = localObject1;
                  localObject5 = localObject1;
                  localObject6 = localObject1;
                  localObject7 = com.nostra13.universalimageloader.core.d.b.a.c.b(localFile.getAbsolutePath());
                }
              }
            }
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            i();
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            localObject1 = a((String)localObject7);
            if (localObject1 != null)
            {
              localObject3 = localObject1;
              localObject4 = localObject1;
              localObject5 = localObject1;
              localObject6 = localObject1;
              if (((Bitmap)localObject1).getWidth() > 0)
              {
                localObject7 = localObject1;
                localObject3 = localObject1;
                localObject4 = localObject1;
                localObject5 = localObject1;
                localObject6 = localObject1;
                if (((Bitmap)localObject1).getHeight() > 0) {
                  continue;
                }
              }
            }
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject6 = localObject1;
            a(com.nostra13.universalimageloader.core.a.b.a.b, null);
            localObject7 = localObject1;
          }
          return (Bitmap)localObject7;
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          continue;
        }
        localIllegalStateException1 = localIllegalStateException1;
        localObject6 = null;
        a(com.nostra13.universalimageloader.core.a.b.a.c, null);
        return (Bitmap)localObject6;
      }
      catch (a locala)
      {
        throw locala;
      }
      catch (IOException localIOException1)
      {
        localObject5 = null;
        com.nostra13.universalimageloader.b.c.a(localIOException1);
        a(com.nostra13.universalimageloader.core.a.b.a.a, localIOException1);
        return (Bitmap)localObject5;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject4 = null;
        com.nostra13.universalimageloader.b.c.a(localOutOfMemoryError1);
        a(com.nostra13.universalimageloader.core.a.b.a.d, localOutOfMemoryError1);
        return (Bitmap)localObject4;
      }
      catch (Throwable localThrowable1)
      {
        localObject3 = null;
        com.nostra13.universalimageloader.b.c.a(localThrowable1);
        a(com.nostra13.universalimageloader.core.a.b.a.e, localThrowable1);
        return (Bitmap)localObject3;
      }
    }
  }
  
  private boolean e()
  {
    com.nostra13.universalimageloader.b.c.a("Cache image on disk [%s]", new Object[] { this.n });
    try
    {
      boolean bool = f();
      if (bool)
      {
        int i1 = this.i.d;
        int i2 = this.i.e;
        if ((i1 > 0) || (i2 > 0))
        {
          com.nostra13.universalimageloader.b.c.a("Resize image in disk cache [%s]", new Object[] { this.n });
          b(i1, i2);
        }
      }
      return bool;
    }
    catch (IOException localIOException)
    {
      com.nostra13.universalimageloader.b.c.a(localIOException);
    }
    return false;
  }
  
  private boolean f()
  {
    InputStream localInputStream = h().a(this.a, this.c.n());
    if (localInputStream == null)
    {
      com.nostra13.universalimageloader.b.c.d("No stream for image [%s]", new Object[] { this.n });
      return false;
    }
    try
    {
      boolean bool = this.i.o.a(this.a, localInputStream, this);
      return bool;
    }
    finally
    {
      com.nostra13.universalimageloader.b.b.a(localInputStream);
    }
  }
  
  private void g()
  {
    if ((this.p) || (p())) {
      return;
    }
    a(new k(this), false, this.h, this.f);
  }
  
  private com.nostra13.universalimageloader.core.d.b h()
  {
    if (this.f.f()) {
      return this.k;
    }
    if (this.f.g()) {
      return this.l;
    }
    return this.j;
  }
  
  private void i()
  {
    k();
    m();
  }
  
  private boolean j()
  {
    return (l()) || (n());
  }
  
  private void k()
  {
    if (l()) {
      throw new a();
    }
  }
  
  private boolean l()
  {
    if (this.b.e())
    {
      com.nostra13.universalimageloader.b.c.a("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] { this.n });
      return true;
    }
    return false;
  }
  
  private void m()
  {
    if (n()) {
      throw new a();
    }
  }
  
  private boolean n()
  {
    String str = this.f.a(this.b);
    if (!this.n.equals(str)) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      com.nostra13.universalimageloader.b.c.a("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] { this.n });
      return true;
    }
    return false;
  }
  
  private void o()
  {
    if (p()) {
      throw new a();
    }
  }
  
  private boolean p()
  {
    if (Thread.interrupted())
    {
      com.nostra13.universalimageloader.b.c.a("Task was interrupted [%s]", new Object[] { this.n });
      return true;
    }
    return false;
  }
  
  String a()
  {
    return this.a;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (this.p) || (c(paramInt1, paramInt2));
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 410	com/nostra13/universalimageloader/core/h:b	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokespecial 412	com/nostra13/universalimageloader/core/h:c	()Z
    //   12: ifne -5 -> 7
    //   15: aload_0
    //   16: getfield 56	com/nostra13/universalimageloader/core/h:g	Lcom/nostra13/universalimageloader/core/g;
    //   19: getfield 415	com/nostra13/universalimageloader/core/g:h	Ljava/util/concurrent/locks/ReentrantLock;
    //   22: astore_3
    //   23: ldc_w 417
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   36: aastore
    //   37: invokestatic 186	com/nostra13/universalimageloader/b/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aload_3
    //   41: invokevirtual 422	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   44: ifeq +20 -> 64
    //   47: ldc_w 424
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 186	com/nostra13/universalimageloader/b/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_3
    //   65: invokevirtual 427	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   68: aload_0
    //   69: invokespecial 311	com/nostra13/universalimageloader/core/h:i	()V
    //   72: aload_0
    //   73: getfield 64	com/nostra13/universalimageloader/core/h:i	Lcom/nostra13/universalimageloader/core/d;
    //   76: getfield 430	com/nostra13/universalimageloader/core/d:n	Lcom/nostra13/universalimageloader/a/b/a;
    //   79: aload_0
    //   80: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   83: invokeinterface 433 2 0
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 436	android/graphics/Bitmap:isRecycled	()Z
    //   97: ifeq +270 -> 367
    //   100: aload_0
    //   101: invokespecial 438	com/nostra13/universalimageloader/core/h:d	()Landroid/graphics/Bitmap;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnonnull +8 -> 114
    //   109: aload_3
    //   110: invokevirtual 441	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   113: return
    //   114: aload_0
    //   115: invokespecial 311	com/nostra13/universalimageloader/core/h:i	()V
    //   118: aload_0
    //   119: invokespecial 443	com/nostra13/universalimageloader/core/h:o	()V
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 105	com/nostra13/universalimageloader/core/h:c	Lcom/nostra13/universalimageloader/core/c;
    //   128: invokevirtual 445	com/nostra13/universalimageloader/core/c:d	()Z
    //   131: ifeq +59 -> 190
    //   134: ldc_w 447
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 186	com/nostra13/universalimageloader/b/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 105	com/nostra13/universalimageloader/core/h:c	Lcom/nostra13/universalimageloader/core/c;
    //   155: invokevirtual 450	com/nostra13/universalimageloader/core/c:o	()Lcom/nostra13/universalimageloader/core/g/a;
    //   158: aload_2
    //   159: invokeinterface 258 2 0
    //   164: astore_2
    //   165: aload_2
    //   166: astore_1
    //   167: aload_2
    //   168: ifnonnull +22 -> 190
    //   171: ldc_w 452
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_0
    //   181: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 195	com/nostra13/universalimageloader/b/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_2
    //   189: astore_1
    //   190: aload_1
    //   191: astore_2
    //   192: aload_1
    //   193: ifnull +52 -> 245
    //   196: aload_1
    //   197: astore_2
    //   198: aload_0
    //   199: getfield 105	com/nostra13/universalimageloader/core/h:c	Lcom/nostra13/universalimageloader/core/c;
    //   202: invokevirtual 454	com/nostra13/universalimageloader/core/c:h	()Z
    //   205: ifeq +40 -> 245
    //   208: ldc_w 456
    //   211: iconst_1
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_0
    //   218: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 186	com/nostra13/universalimageloader/b/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload_0
    //   226: getfield 64	com/nostra13/universalimageloader/core/h:i	Lcom/nostra13/universalimageloader/core/d;
    //   229: getfield 430	com/nostra13/universalimageloader/core/d:n	Lcom/nostra13/universalimageloader/a/b/a;
    //   232: aload_0
    //   233: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   236: aload_1
    //   237: invokeinterface 457 3 0
    //   242: pop
    //   243: aload_1
    //   244: astore_2
    //   245: aload_2
    //   246: astore_1
    //   247: aload_2
    //   248: ifnull +71 -> 319
    //   251: aload_2
    //   252: astore_1
    //   253: aload_0
    //   254: getfield 105	com/nostra13/universalimageloader/core/h:c	Lcom/nostra13/universalimageloader/core/c;
    //   257: invokevirtual 458	com/nostra13/universalimageloader/core/c:e	()Z
    //   260: ifeq +59 -> 319
    //   263: ldc_w 460
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_0
    //   273: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   276: aastore
    //   277: invokestatic 186	com/nostra13/universalimageloader/b/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: aload_0
    //   281: getfield 105	com/nostra13/universalimageloader/core/h:c	Lcom/nostra13/universalimageloader/core/c;
    //   284: invokevirtual 462	com/nostra13/universalimageloader/core/c:p	()Lcom/nostra13/universalimageloader/core/g/a;
    //   287: aload_2
    //   288: invokeinterface 258 2 0
    //   293: astore_2
    //   294: aload_2
    //   295: astore_1
    //   296: aload_2
    //   297: ifnonnull +22 -> 319
    //   300: ldc_w 464
    //   303: iconst_1
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: aload_0
    //   310: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   313: aastore
    //   314: invokestatic 195	com/nostra13/universalimageloader/b/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload_2
    //   318: astore_1
    //   319: aload_0
    //   320: invokespecial 311	com/nostra13/universalimageloader/core/h:i	()V
    //   323: aload_0
    //   324: invokespecial 443	com/nostra13/universalimageloader/core/h:o	()V
    //   327: aload_3
    //   328: invokevirtual 441	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   331: new 466	com/nostra13/universalimageloader/core/b
    //   334: dup
    //   335: aload_1
    //   336: aload_0
    //   337: getfield 56	com/nostra13/universalimageloader/core/h:g	Lcom/nostra13/universalimageloader/core/g;
    //   340: aload_0
    //   341: getfield 54	com/nostra13/universalimageloader/core/h:f	Lcom/nostra13/universalimageloader/core/e;
    //   344: aload_0
    //   345: getfield 52	com/nostra13/universalimageloader/core/h:q	Lcom/nostra13/universalimageloader/core/a/f;
    //   348: invokespecial 469	com/nostra13/universalimageloader/core/b:<init>	(Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/g;Lcom/nostra13/universalimageloader/core/e;Lcom/nostra13/universalimageloader/core/a/f;)V
    //   351: aload_0
    //   352: getfield 120	com/nostra13/universalimageloader/core/h:p	Z
    //   355: aload_0
    //   356: getfield 58	com/nostra13/universalimageloader/core/h:h	Landroid/os/Handler;
    //   359: aload_0
    //   360: getfield 54	com/nostra13/universalimageloader/core/h:f	Lcom/nostra13/universalimageloader/core/e;
    //   363: invokestatic 154	com/nostra13/universalimageloader/core/h:a	(Ljava/lang/Runnable;ZLandroid/os/Handler;Lcom/nostra13/universalimageloader/core/e;)V
    //   366: return
    //   367: aload_0
    //   368: getstatic 471	com/nostra13/universalimageloader/core/a/f:c	Lcom/nostra13/universalimageloader/core/a/f;
    //   371: putfield 52	com/nostra13/universalimageloader/core/h:q	Lcom/nostra13/universalimageloader/core/a/f;
    //   374: ldc_w 473
    //   377: iconst_1
    //   378: anewarray 4	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: aload_0
    //   384: getfield 93	com/nostra13/universalimageloader/core/h:n	Ljava/lang/String;
    //   387: aastore
    //   388: invokestatic 186	com/nostra13/universalimageloader/b/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   391: goto -146 -> 245
    //   394: astore_1
    //   395: aload_0
    //   396: invokespecial 475	com/nostra13/universalimageloader/core/h:g	()V
    //   399: aload_3
    //   400: invokevirtual 441	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   403: return
    //   404: astore_1
    //   405: aload_3
    //   406: invokevirtual 441	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   409: aload_1
    //   410: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	h
    //   123	213	1	localObject1	Object
    //   394	1	1	locala	a
    //   404	6	1	localObject2	Object
    //   88	230	2	localObject3	Object
    //   22	384	3	localReentrantLock	java.util.concurrent.locks.ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   68	89	394	com/nostra13/universalimageloader/core/h$a
    //   93	100	394	com/nostra13/universalimageloader/core/h$a
    //   100	105	394	com/nostra13/universalimageloader/core/h$a
    //   114	122	394	com/nostra13/universalimageloader/core/h$a
    //   124	165	394	com/nostra13/universalimageloader/core/h$a
    //   171	188	394	com/nostra13/universalimageloader/core/h$a
    //   198	243	394	com/nostra13/universalimageloader/core/h$a
    //   253	294	394	com/nostra13/universalimageloader/core/h$a
    //   300	317	394	com/nostra13/universalimageloader/core/h$a
    //   319	327	394	com/nostra13/universalimageloader/core/h$a
    //   367	391	394	com/nostra13/universalimageloader/core/h$a
    //   68	89	404	finally
    //   93	100	404	finally
    //   100	105	404	finally
    //   114	122	404	finally
    //   124	165	404	finally
    //   171	188	404	finally
    //   198	243	404	finally
    //   253	294	404	finally
    //   300	317	404	finally
    //   319	327	404	finally
    //   367	391	404	finally
    //   395	399	404	finally
  }
  
  class a
    extends Exception
  {
    a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */