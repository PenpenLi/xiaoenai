package com.bumptech.glide.d.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.d.b.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

public abstract class f
  implements a<InputStream>
{
  public static final f a = new g();
  public static final f b = new h();
  public static final f c = new i();
  private static final Set<o.a> d = EnumSet.of(o.a.b, o.a.c, o.a.d);
  private static final Queue<BitmapFactory.Options> e = com.bumptech.glide.i.h.a(0);
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt5;
    if (paramInt5 == Integer.MIN_VALUE) {
      i = paramInt3;
    }
    paramInt5 = paramInt4;
    if (paramInt4 == Integer.MIN_VALUE) {
      paramInt5 = paramInt2;
    }
    if ((paramInt1 == 90) || (paramInt1 == 270))
    {
      paramInt1 = a(paramInt3, paramInt2, paramInt5, i);
      if (paramInt1 != 0) {
        break label78;
      }
    }
    label78:
    for (paramInt1 = 0;; paramInt1 = Integer.highestOneBit(paramInt1))
    {
      return Math.max(1, paramInt1);
      paramInt1 = a(paramInt2, paramInt3, paramInt5, i);
      break;
    }
  }
  
  private static Bitmap.Config a(InputStream paramInputStream, com.bumptech.glide.d.a parama)
  {
    if ((parama == com.bumptech.glide.d.a.a) || (parama == com.bumptech.glide.d.a.b) || (Build.VERSION.SDK_INT == 16)) {
      return Bitmap.Config.ARGB_8888;
    }
    paramInputStream.mark(1024);
    for (;;)
    {
      try
      {
        bool2 = new o(paramInputStream).a();
      }
      catch (IOException localIOException)
      {
        boolean bool2;
        boolean bool1;
        if (!Log.isLoggable("Downsampler", 5)) {
          continue;
        }
        Log.w("Downsampler", "Cannot determine whether the image has alpha or not from header for format " + parama, localIOException);
        try
        {
          paramInputStream.reset();
          bool1 = false;
        }
        catch (IOException paramInputStream)
        {
          if (Log.isLoggable("Downsampler", 5)) {
            Log.w("Downsampler", "Cannot reset the input stream", paramInputStream);
          }
          bool1 = false;
        }
        continue;
      }
      finally
      {
        try
        {
          paramInputStream.reset();
          throw parama;
        }
        catch (IOException paramInputStream)
        {
          if (!Log.isLoggable("Downsampler", 5)) {
            continue;
          }
          Log.w("Downsampler", "Cannot reset the input stream", paramInputStream);
          continue;
        }
      }
      try
      {
        paramInputStream.reset();
        bool1 = bool2;
      }
      catch (IOException paramInputStream)
      {
        bool1 = bool2;
        if (!Log.isLoggable("Downsampler", 5)) {
          continue;
        }
        Log.w("Downsampler", "Cannot reset the input stream", paramInputStream);
        bool1 = bool2;
      }
    }
    if (bool1) {
      return Bitmap.Config.ARGB_8888;
    }
    return Bitmap.Config.RGB_565;
  }
  
  private Bitmap a(com.bumptech.glide.i.f paramf, r paramr, BitmapFactory.Options paramOptions, c paramc, int paramInt1, int paramInt2, int paramInt3, com.bumptech.glide.d.a parama)
  {
    parama = a(paramf, parama);
    paramOptions.inSampleSize = paramInt3;
    paramOptions.inPreferredConfig = parama;
    if (((paramOptions.inSampleSize == 1) || (19 <= Build.VERSION.SDK_INT)) && (a(paramf))) {
      a(paramOptions, paramc.b((int)Math.ceil(paramInt1 / paramInt3), (int)Math.ceil(paramInt2 / paramInt3), parama));
    }
    return b(paramf, paramr, paramOptions);
  }
  
  private static void a(BitmapFactory.Options paramOptions)
  {
    b(paramOptions);
    synchronized (e)
    {
      e.offer(paramOptions);
      return;
    }
  }
  
  @TargetApi(11)
  private static void a(BitmapFactory.Options paramOptions, Bitmap paramBitmap)
  {
    if (11 <= Build.VERSION.SDK_INT) {
      paramOptions.inBitmap = paramBitmap;
    }
  }
  
  private static boolean a(InputStream paramInputStream)
  {
    boolean bool1;
    if (19 <= Build.VERSION.SDK_INT) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      paramInputStream.mark(1024);
      try
      {
        o.a locala = new o(paramInputStream).b();
        boolean bool2 = d.contains(locala);
        try
        {
          paramInputStream.reset();
          return bool2;
        }
        catch (IOException paramInputStream)
        {
          bool1 = bool2;
        }
        if (Log.isLoggable("Downsampler", 5))
        {
          Log.w("Downsampler", "Cannot reset the input stream", paramInputStream);
          return bool2;
        }
      }
      catch (IOException localIOException)
      {
        localIOException = localIOException;
        if (Log.isLoggable("Downsampler", 5)) {
          Log.w("Downsampler", "Cannot determine the image type from header", localIOException);
        }
        try
        {
          paramInputStream.reset();
          return false;
        }
        catch (IOException paramInputStream)
        {
          for (;;)
          {
            if (Log.isLoggable("Downsampler", 5)) {
              Log.w("Downsampler", "Cannot reset the input stream", paramInputStream);
            }
          }
        }
      }
      finally {}
    }
    try
    {
      paramInputStream.reset();
      throw ((Throwable)localObject);
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        if (Log.isLoggable("Downsampler", 5)) {
          Log.w("Downsampler", "Cannot reset the input stream", paramInputStream);
        }
      }
    }
  }
  
  private static Bitmap b(com.bumptech.glide.i.f paramf, r paramr, BitmapFactory.Options paramOptions)
  {
    if (paramOptions.inJustDecodeBounds) {
      paramf.mark(5242880);
    }
    for (;;)
    {
      paramr = BitmapFactory.decodeStream(paramf, null, paramOptions);
      try
      {
        if (paramOptions.inJustDecodeBounds) {
          paramf.reset();
        }
        return paramr;
        paramr.a();
      }
      catch (IOException paramf)
      {
        while (!Log.isLoggable("Downsampler", 6)) {}
        Log.e("Downsampler", "Exception loading inDecodeBounds=" + paramOptions.inJustDecodeBounds + " sample=" + paramOptions.inSampleSize, paramf);
      }
    }
    return paramr;
  }
  
  /* Error */
  @TargetApi(11)
  private static BitmapFactory.Options b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	com/bumptech/glide/d/d/a/f:e	Ljava/util/Queue;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic 43	com/bumptech/glide/d/d/a/f:e	Ljava/util/Queue;
    //   12: invokeinterface 243 1 0
    //   17: checkcast 156	android/graphics/BitmapFactory$Options
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: ifnonnull +15 -> 41
    //   29: new 156	android/graphics/BitmapFactory$Options
    //   32: dup
    //   33: invokespecial 244	android/graphics/BitmapFactory$Options:<init>	()V
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 183	com/bumptech/glide/d/d/a/f:b	(Landroid/graphics/BitmapFactory$Options;)V
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	5	0	localObject2	Object
    //   20	6	1	localOptions	BitmapFactory.Options
    //   46	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	23	46	finally
    //   47	49	46	finally
    //   3	9	51	finally
    //   29	41	51	finally
    //   49	51	51	finally
  }
  
  @TargetApi(11)
  private static void b(BitmapFactory.Options paramOptions)
  {
    paramOptions.inTempStorage = null;
    paramOptions.inDither = false;
    paramOptions.inScaled = false;
    paramOptions.inSampleSize = 1;
    paramOptions.inPreferredConfig = null;
    paramOptions.inJustDecodeBounds = false;
    paramOptions.outWidth = 0;
    paramOptions.outHeight = 0;
    paramOptions.outMimeType = null;
    if (11 <= Build.VERSION.SDK_INT)
    {
      paramOptions.inBitmap = null;
      paramOptions.inMutable = true;
    }
  }
  
  protected abstract int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  /* Error */
  public Bitmap a(InputStream paramInputStream, c paramc, int paramInt1, int paramInt2, com.bumptech.glide.d.a parama)
  {
    // Byte code:
    //   0: invokestatic 273	com/bumptech/glide/i/a:a	()Lcom/bumptech/glide/i/a;
    //   3: astore 6
    //   5: aload 6
    //   7: invokevirtual 276	com/bumptech/glide/i/a:b	()[B
    //   10: astore 7
    //   12: aload 6
    //   14: invokevirtual 276	com/bumptech/glide/i/a:b	()[B
    //   17: astore 8
    //   19: invokestatic 278	com/bumptech/glide/d/d/a/f:b	()Landroid/graphics/BitmapFactory$Options;
    //   22: astore 9
    //   24: new 224	com/bumptech/glide/d/d/a/r
    //   27: dup
    //   28: aload_1
    //   29: aload 8
    //   31: invokespecial 281	com/bumptech/glide/d/d/a/r:<init>	(Ljava/io/InputStream;[B)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokestatic 286	com/bumptech/glide/i/c:a	(Ljava/io/InputStream;)Lcom/bumptech/glide/i/c;
    //   39: astore 10
    //   41: new 214	com/bumptech/glide/i/f
    //   44: dup
    //   45: aload 10
    //   47: invokespecial 287	com/bumptech/glide/i/f:<init>	(Ljava/io/InputStream;)V
    //   50: astore 11
    //   52: aload 10
    //   54: ldc -44
    //   56: invokevirtual 288	com/bumptech/glide/i/c:mark	(I)V
    //   59: new 109	com/bumptech/glide/d/d/a/o
    //   62: dup
    //   63: aload 10
    //   65: invokespecial 112	com/bumptech/glide/d/d/a/o:<init>	(Ljava/io/InputStream;)V
    //   68: invokevirtual 291	com/bumptech/glide/d/d/a/o:c	()I
    //   71: istore 13
    //   73: aload 10
    //   75: invokevirtual 292	com/bumptech/glide/i/c:reset	()V
    //   78: aload 9
    //   80: aload 7
    //   82: putfield 248	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   85: aload_0
    //   86: aload 11
    //   88: aload_1
    //   89: aload 9
    //   91: invokevirtual 295	com/bumptech/glide/d/d/a/f:a	(Lcom/bumptech/glide/i/f;Lcom/bumptech/glide/d/d/a/r;Landroid/graphics/BitmapFactory$Options;)[I
    //   94: astore 12
    //   96: aload 12
    //   98: iconst_0
    //   99: iaload
    //   100: istore 14
    //   102: aload 12
    //   104: iconst_1
    //   105: iaload
    //   106: istore 15
    //   108: aload_0
    //   109: aload 11
    //   111: aload_1
    //   112: aload 9
    //   114: aload_2
    //   115: iload 14
    //   117: iload 15
    //   119: aload_0
    //   120: iload 13
    //   122: invokestatic 299	com/bumptech/glide/d/d/a/u:a	(I)I
    //   125: iload 14
    //   127: iload 15
    //   129: iload_3
    //   130: iload 4
    //   132: invokespecial 301	com/bumptech/glide/d/d/a/f:a	(IIIII)I
    //   135: aload 5
    //   137: invokespecial 303	com/bumptech/glide/d/d/a/f:a	(Lcom/bumptech/glide/i/f;Lcom/bumptech/glide/d/d/a/r;Landroid/graphics/BitmapFactory$Options;Lcom/bumptech/glide/d/b/a/c;IIILcom/bumptech/glide/d/a;)Landroid/graphics/Bitmap;
    //   140: astore 11
    //   142: aload 10
    //   144: invokevirtual 306	com/bumptech/glide/i/c:a	()Ljava/io/IOException;
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +155 -> 304
    //   152: new 308	java/lang/RuntimeException
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 311	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   160: athrow
    //   161: astore_1
    //   162: aload 6
    //   164: aload 7
    //   166: invokevirtual 314	com/bumptech/glide/i/a:a	([B)Z
    //   169: pop
    //   170: aload 6
    //   172: aload 8
    //   174: invokevirtual 314	com/bumptech/glide/i/a:a	([B)Z
    //   177: pop
    //   178: aload 10
    //   180: invokevirtual 316	com/bumptech/glide/i/c:b	()V
    //   183: aload 9
    //   185: invokestatic 318	com/bumptech/glide/d/d/a/f:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   188: aload_1
    //   189: athrow
    //   190: astore 12
    //   192: ldc 120
    //   194: iconst_5
    //   195: invokestatic 126	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   198: ifeq +13 -> 211
    //   201: ldc 120
    //   203: ldc -128
    //   205: aload 12
    //   207: invokestatic 132	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   210: pop
    //   211: goto -133 -> 78
    //   214: astore 12
    //   216: ldc 120
    //   218: iconst_5
    //   219: invokestatic 126	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   222: ifeq +14 -> 236
    //   225: ldc 120
    //   227: ldc_w 320
    //   230: aload 12
    //   232: invokestatic 132	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   235: pop
    //   236: aload 10
    //   238: invokevirtual 292	com/bumptech/glide/i/c:reset	()V
    //   241: iconst_0
    //   242: istore 13
    //   244: goto -166 -> 78
    //   247: astore 12
    //   249: ldc 120
    //   251: iconst_5
    //   252: invokestatic 126	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   255: ifeq +13 -> 268
    //   258: ldc 120
    //   260: ldc -128
    //   262: aload 12
    //   264: invokestatic 132	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   267: pop
    //   268: iconst_0
    //   269: istore 13
    //   271: goto -193 -> 78
    //   274: astore_1
    //   275: aload 10
    //   277: invokevirtual 292	com/bumptech/glide/i/c:reset	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_2
    //   283: ldc 120
    //   285: iconst_5
    //   286: invokestatic 126	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   289: ifeq -9 -> 280
    //   292: ldc 120
    //   294: ldc -128
    //   296: aload_2
    //   297: invokestatic 132	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   300: pop
    //   301: goto -21 -> 280
    //   304: aconst_null
    //   305: astore_1
    //   306: aload 11
    //   308: ifnull +48 -> 356
    //   311: aload 11
    //   313: aload_2
    //   314: iload 13
    //   316: invokestatic 323	com/bumptech/glide/d/d/a/u:a	(Landroid/graphics/Bitmap;Lcom/bumptech/glide/d/b/a/c;I)Landroid/graphics/Bitmap;
    //   319: astore 5
    //   321: aload 5
    //   323: astore_1
    //   324: aload 11
    //   326: aload 5
    //   328: invokevirtual 326	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   331: ifne +25 -> 356
    //   334: aload 5
    //   336: astore_1
    //   337: aload_2
    //   338: aload 11
    //   340: invokeinterface 329 2 0
    //   345: ifne +11 -> 356
    //   348: aload 11
    //   350: invokevirtual 334	android/graphics/Bitmap:recycle	()V
    //   353: aload 5
    //   355: astore_1
    //   356: aload 6
    //   358: aload 7
    //   360: invokevirtual 314	com/bumptech/glide/i/a:a	([B)Z
    //   363: pop
    //   364: aload 6
    //   366: aload 8
    //   368: invokevirtual 314	com/bumptech/glide/i/a:a	([B)Z
    //   371: pop
    //   372: aload 10
    //   374: invokevirtual 316	com/bumptech/glide/i/c:b	()V
    //   377: aload 9
    //   379: invokestatic 318	com/bumptech/glide/d/d/a/f:a	(Landroid/graphics/BitmapFactory$Options;)V
    //   382: aload_1
    //   383: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	f
    //   0	384	1	paramInputStream	InputStream
    //   0	384	2	paramc	c
    //   0	384	3	paramInt1	int
    //   0	384	4	paramInt2	int
    //   0	384	5	parama	com.bumptech.glide.d.a
    //   3	362	6	locala	com.bumptech.glide.i.a
    //   10	349	7	arrayOfByte1	byte[]
    //   17	350	8	arrayOfByte2	byte[]
    //   22	356	9	localOptions	BitmapFactory.Options
    //   39	334	10	localc	com.bumptech.glide.i.c
    //   50	299	11	localObject	Object
    //   94	9	12	arrayOfInt	int[]
    //   190	16	12	localIOException1	IOException
    //   214	17	12	localIOException2	IOException
    //   247	16	12	localIOException3	IOException
    //   71	244	13	i	int
    //   100	26	14	j	int
    //   106	22	15	k	int
    // Exception table:
    //   from	to	target	type
    //   52	59	161	finally
    //   73	78	161	finally
    //   78	96	161	finally
    //   108	148	161	finally
    //   152	161	161	finally
    //   192	211	161	finally
    //   236	241	161	finally
    //   249	268	161	finally
    //   275	280	161	finally
    //   280	282	161	finally
    //   283	301	161	finally
    //   311	321	161	finally
    //   324	334	161	finally
    //   337	353	161	finally
    //   73	78	190	java/io/IOException
    //   59	73	214	java/io/IOException
    //   236	241	247	java/io/IOException
    //   59	73	274	finally
    //   216	236	274	finally
    //   275	280	282	java/io/IOException
  }
  
  public int[] a(com.bumptech.glide.i.f paramf, r paramr, BitmapFactory.Options paramOptions)
  {
    paramOptions.inJustDecodeBounds = true;
    b(paramf, paramr, paramOptions);
    paramOptions.inJustDecodeBounds = false;
    return new int[] { paramOptions.outWidth, paramOptions.outHeight };
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */