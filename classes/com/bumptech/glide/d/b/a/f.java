package com.bumptech.glide.d.b.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class f
  implements c
{
  private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
  private final g b;
  private final Set<Bitmap.Config> c;
  private final int d;
  private final a e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public f(int paramInt)
  {
    this(paramInt, f(), g());
  }
  
  f(int paramInt, g paramg, Set<Bitmap.Config> paramSet)
  {
    this.d = paramInt;
    this.f = paramInt;
    this.b = paramg;
    this.c = paramSet;
    this.e = new b(null);
  }
  
  /* Error */
  private void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/bumptech/glide/d/b/a/f:g	I
    //   6: iload_1
    //   7: if_icmple +43 -> 50
    //   10: aload_0
    //   11: getfield 58	com/bumptech/glide/d/b/a/f:b	Lcom/bumptech/glide/d/b/a/g;
    //   14: invokeinterface 74 1 0
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +32 -> 53
    //   24: ldc 76
    //   26: iconst_5
    //   27: invokestatic 82	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   30: ifeq +15 -> 45
    //   33: ldc 76
    //   35: ldc 84
    //   37: invokestatic 88	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: invokespecial 90	com/bumptech/glide/d/b/a/f:e	()V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 69	com/bumptech/glide/d/b/a/f:g	I
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: getfield 65	com/bumptech/glide/d/b/a/f:e	Lcom/bumptech/glide/d/b/a/f$a;
    //   57: aload_2
    //   58: invokeinterface 93 2 0
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 69	com/bumptech/glide/d/b/a/f:g	I
    //   68: aload_0
    //   69: getfield 58	com/bumptech/glide/d/b/a/f:b	Lcom/bumptech/glide/d/b/a/g;
    //   72: aload_2
    //   73: invokeinterface 96 2 0
    //   78: isub
    //   79: putfield 69	com/bumptech/glide/d/b/a/f:g	I
    //   82: aload_2
    //   83: invokevirtual 101	android/graphics/Bitmap:recycle	()V
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 103	com/bumptech/glide/d/b/a/f:k	I
    //   91: iconst_1
    //   92: iadd
    //   93: putfield 103	com/bumptech/glide/d/b/a/f:k	I
    //   96: ldc 76
    //   98: iconst_3
    //   99: invokestatic 82	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   102: ifeq +37 -> 139
    //   105: ldc 76
    //   107: new 105	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   114: ldc 108
    //   116: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: getfield 58	com/bumptech/glide/d/b/a/f:b	Lcom/bumptech/glide/d/b/a/g;
    //   123: aload_2
    //   124: invokeinterface 115 2 0
    //   129: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 121	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: pop
    //   139: aload_0
    //   140: invokespecial 123	com/bumptech/glide/d/b/a/f:d	()V
    //   143: goto -141 -> 2
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	f
    //   0	151	1	paramInt	int
    //   19	105	2	localBitmap	Bitmap
    //   146	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	146	finally
    //   24	45	146	finally
    //   45	50	146	finally
    //   53	139	146	finally
    //   139	143	146	finally
  }
  
  private void c()
  {
    b(this.f);
  }
  
  private void d()
  {
    if (Log.isLoggable("LruBitmapPool", 2)) {
      e();
    }
  }
  
  private void e()
  {
    Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.b);
  }
  
  private static g f()
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return new i();
    }
    return new a();
  }
  
  private static Set<Bitmap.Config> g()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(Arrays.asList(Bitmap.Config.values()));
    if (Build.VERSION.SDK_INT >= 19) {
      localHashSet.add(null);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      paramConfig = b(paramInt1, paramInt2, paramConfig);
      if (paramConfig != null) {
        paramConfig.eraseColor(0);
      }
      return paramConfig;
    }
    finally {}
  }
  
  public void a(float paramFloat)
  {
    try
    {
      this.f = Math.round(this.d * paramFloat);
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "trimMemory, level=" + paramInt);
    }
    if (paramInt >= 60) {
      b();
    }
    while (paramInt < 40) {
      return;
    }
    b(this.f / 2);
  }
  
  public boolean a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      try
      {
        throw new NullPointerException("Bitmap must not be null");
      }
      finally {}
    }
    if ((!paramBitmap.isMutable()) || (this.b.c(paramBitmap) > this.f) || (!this.c.contains(paramBitmap.getConfig()))) {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.b.b(paramBitmap) + ", is mutable: " + paramBitmap.isMutable() + ", is allowed config: " + this.c.contains(paramBitmap.getConfig()));
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      int m = this.b.c(paramBitmap);
      this.b.a(paramBitmap);
      this.e.a(paramBitmap);
      this.j += 1;
      this.g = (m + this.g);
      if (Log.isLoggable("LruBitmapPool", 2)) {
        Log.v("LruBitmapPool", "Put bitmap in pool=" + this.b.b(paramBitmap));
      }
      d();
      c();
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(12)
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/bumptech/glide/d/b/a/f:b	Lcom/bumptech/glide/d/b/a/g;
    //   6: astore 5
    //   8: aload_3
    //   9: ifnull +135 -> 144
    //   12: aload_3
    //   13: astore 4
    //   15: aload 5
    //   17: iload_1
    //   18: iload_2
    //   19: aload 4
    //   21: invokeinterface 256 4 0
    //   26: astore 4
    //   28: aload 4
    //   30: ifnonnull +122 -> 152
    //   33: ldc 76
    //   35: iconst_3
    //   36: invokestatic 82	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   39: ifeq +40 -> 79
    //   42: ldc 76
    //   44: new 105	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 258
    //   54: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: getfield 58	com/bumptech/glide/d/b/a/f:b	Lcom/bumptech/glide/d/b/a/g;
    //   61: iload_1
    //   62: iload_2
    //   63: aload_3
    //   64: invokeinterface 261 4 0
    //   69: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 121	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 136	com/bumptech/glide/d/b/a/f:i	I
    //   84: iconst_1
    //   85: iadd
    //   86: putfield 136	com/bumptech/glide/d/b/a/f:i	I
    //   89: ldc 76
    //   91: iconst_2
    //   92: invokestatic 82	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   95: ifeq +40 -> 135
    //   98: ldc 76
    //   100: new 105	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 263
    //   110: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 58	com/bumptech/glide/d/b/a/f:b	Lcom/bumptech/glide/d/b/a/g;
    //   117: iload_1
    //   118: iload_2
    //   119: aload_3
    //   120: invokeinterface 261 4 0
    //   125: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 154	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   134: pop
    //   135: aload_0
    //   136: invokespecial 123	com/bumptech/glide/d/b/a/f:d	()V
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 4
    //   143: areturn
    //   144: getstatic 38	com/bumptech/glide/d/b/a/f:a	Landroid/graphics/Bitmap$Config;
    //   147: astore 4
    //   149: goto -134 -> 15
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 129	com/bumptech/glide/d/b/a/f:h	I
    //   157: iconst_1
    //   158: iadd
    //   159: putfield 129	com/bumptech/glide/d/b/a/f:h	I
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 69	com/bumptech/glide/d/b/a/f:g	I
    //   167: aload_0
    //   168: getfield 58	com/bumptech/glide/d/b/a/f:b	Lcom/bumptech/glide/d/b/a/g;
    //   171: aload 4
    //   173: invokeinterface 96 2 0
    //   178: isub
    //   179: putfield 69	com/bumptech/glide/d/b/a/f:g	I
    //   182: aload_0
    //   183: getfield 65	com/bumptech/glide/d/b/a/f:e	Lcom/bumptech/glide/d/b/a/f$a;
    //   186: aload 4
    //   188: invokeinterface 93 2 0
    //   193: getstatic 159	android/os/Build$VERSION:SDK_INT	I
    //   196: bipush 12
    //   198: if_icmplt -109 -> 89
    //   201: aload 4
    //   203: iconst_1
    //   204: invokevirtual 267	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   207: goto -118 -> 89
    //   210: astore_3
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_3
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	f
    //   0	215	1	paramInt1	int
    //   0	215	2	paramInt2	int
    //   0	215	3	paramConfig	Bitmap.Config
    //   13	189	4	localObject	Object
    //   6	10	5	localg	g
    // Exception table:
    //   from	to	target	type
    //   2	8	210	finally
    //   15	28	210	finally
    //   33	79	210	finally
    //   79	89	210	finally
    //   89	135	210	finally
    //   135	139	210	finally
    //   144	149	210	finally
    //   152	207	210	finally
  }
  
  public void b()
  {
    if (Log.isLoggable("LruBitmapPool", 3)) {
      Log.d("LruBitmapPool", "clearMemory");
    }
    b(0);
  }
  
  private static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap);
    
    public abstract void b(Bitmap paramBitmap);
  }
  
  private static class b
    implements f.a
  {
    public void a(Bitmap paramBitmap) {}
    
    public void b(Bitmap paramBitmap) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */