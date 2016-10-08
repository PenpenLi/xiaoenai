package com.bumptech.glide.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
  implements Closeable
{
  final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File b;
  private final File c;
  private final File d;
  private final File e;
  private final int f;
  private long g;
  private final int h;
  private long i = 0L;
  private Writer j;
  private final LinkedHashMap<String, b> k = new LinkedHashMap(0, 0.75F, true);
  private int l;
  private long m = 0L;
  private final Callable<Void> n = new b(this);
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramFile;
    this.f = paramInt1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.e = new File(paramFile, "journal.bkp");
    this.h = paramInt2;
    this.g = paramLong;
  }
  
  private a a(String paramString, long paramLong)
  {
    for (;;)
    {
      a locala;
      try
      {
        f();
        b localb = (b)this.k.get(paramString);
        if (paramLong != -1L) {
          if (localb != null)
          {
            long l1 = b.e(localb);
            if (l1 == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localb == null)
        {
          localb = new b(paramString, null);
          this.k.put(paramString, localb);
          locala = new a(localb, null);
          b.a(localb, locala);
          this.j.append("DIRTY");
          this.j.append(' ');
          this.j.append(paramString);
          this.j.append('\n');
          this.j.flush();
          paramString = locala;
          continue;
        }
        locala = b.a(localb);
      }
      finally {}
      if (locala != null) {
        paramString = null;
      }
    }
  }
  
  public static a a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label113;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new a(paramFile, paramInt1, paramInt2, paramLong);
      if (!((a)localObject).c.exists()) {
        break label174;
      }
      try
      {
        ((a)localObject).b();
        ((a)localObject).c();
        return (a)localObject;
      }
      catch (IOException localIOException)
      {
        label113:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((a)localObject).a();
      }
      a((File)localObject, localFile, false);
    }
    label174:
    paramFile.mkdirs();
    paramFile = new a(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.d();
    return paramFile;
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int i3 = 0;
    b localb;
    try
    {
      localb = a.a(parama);
      if (b.a(localb) != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!b.d(localb))
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.h) {
            break;
          }
          if (a.b(parama)[i1] == 0)
          {
            parama.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!localb.b(i1).exists())
          {
            parama.b();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.h)
      {
        parama = localb.b(i2);
        if (paramBoolean)
        {
          if (parama.exists())
          {
            File localFile = localb.a(i2);
            parama.renameTo(localFile);
            l1 = b.b(localb)[i2];
            long l2 = localFile.length();
            b.b(localb)[i2] = l2;
            this.i = (this.i - l1 + l2);
          }
        }
        else {
          a(parama);
        }
      }
      else
      {
        this.l += 1;
        b.a(localb, null);
        if ((b.d(localb) | paramBoolean))
        {
          b.a(localb, true);
          this.j.append("CLEAN");
          this.j.append(' ');
          this.j.append(b.c(localb));
          this.j.append(localb.a());
          this.j.append('\n');
          if (paramBoolean)
          {
            l1 = this.m;
            this.m = (1L + l1);
            b.a(localb, l1);
          }
        }
        for (;;)
        {
          this.j.flush();
          if ((this.i <= this.g) && (!e())) {
            break;
          }
          this.a.submit(this.n);
          break;
          this.k.remove(b.c(localb));
          this.j.append("REMOVE");
          this.j.append(' ');
          this.j.append(b.c(localb));
          this.j.append('\n');
        }
      }
      i2 += 1;
    }
  }
  
  private static void a(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void b()
  {
    c localc = new c(new FileInputStream(this.c), e.a);
    label235:
    try
    {
      String str1 = localc.a();
      String str2 = localc.a();
      String str3 = localc.a();
      String str4 = localc.a();
      String str5 = localc.a();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.f).equals(str3)) || (!Integer.toString(this.h).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      e.a(localc);
      throw ((Throwable)localObject);
      int i1 = 0;
      try
      {
        for (;;)
        {
          d(localc.a());
          i1 += 1;
        }
        d();
      }
      catch (EOFException localEOFException)
      {
        this.l = (i1 - this.k.size());
        if (!localc.b()) {
          break label235;
        }
      }
      e.a(localc);
      return;
    }
  }
  
  private void c()
  {
    a(this.d);
    Iterator localIterator = this.k.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int i1;
      if (b.a(localb) == null)
      {
        i1 = 0;
        while (i1 < this.h)
        {
          this.i += b.b(localb)[i1];
          i1 += 1;
        }
      }
      else
      {
        b.a(localb, null);
        i1 = 0;
        while (i1 < this.h)
        {
          a(localb.a(i1));
          a(localb.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        if (this.j != null) {
          this.j.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d), e.a));
        b localb;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.f));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.h));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.k.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localb = (b)localIterator.next();
          if (b.a(localb) != null)
          {
            localBufferedWriter.write("DIRTY " + b.c(localb) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        ((Writer)localObject1).write("CLEAN " + b.c(localb) + localb.a() + '\n');
      }
      finally {}
    }
    ((Writer)localObject1).close();
    if (this.c.exists()) {
      a(this.c, this.e, true);
    }
    a(this.d, this.c, false);
    this.e.delete();
    this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), e.a));
  }
  
  private void d(String paramString)
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str;
    if (i3 == -1)
    {
      str = paramString.substring(i2);
      if ((i1 == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
        this.k.remove(str);
      }
    }
    else
    {
      str = paramString.substring(i2, i3);
    }
    for (;;)
    {
      b localb2 = (b)this.k.get(str);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(str, null);
        this.k.put(str, localb1);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        b.a(localb1, true);
        b.a(localb1, null);
        b.a(localb1, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        b.a(localb1, new a(localb1, null));
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private boolean e()
  {
    return (this.l >= 2000) && (this.l >= this.k.size());
  }
  
  private void f()
  {
    if (this.j == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void g()
  {
    while (this.i > this.g) {
      c((String)((Map.Entry)this.k.entrySet().iterator().next()).getKey());
    }
  }
  
  /* Error */
  public c a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 109	com/bumptech/glide/a/a:f	()V
    //   8: aload_0
    //   9: getfield 50	com/bumptech/glide/a/a:k	Ljava/util/LinkedHashMap;
    //   12: aload_1
    //   13: invokevirtual 113	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 11	com/bumptech/glide/a/a$b
    //   19: astore 4
    //   21: aload 4
    //   23: ifnonnull +9 -> 32
    //   26: aload_3
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: areturn
    //   32: aload_3
    //   33: astore_2
    //   34: aload 4
    //   36: invokestatic 229	com/bumptech/glide/a/a$b:d	(Lcom/bumptech/glide/a/a$b;)Z
    //   39: ifeq -11 -> 28
    //   42: aload 4
    //   44: getfield 447	com/bumptech/glide/a/a$b:a	[Ljava/io/File;
    //   47: astore 5
    //   49: aload 5
    //   51: arraylength
    //   52: istore 7
    //   54: iconst_0
    //   55: istore 6
    //   57: iload 6
    //   59: iload 7
    //   61: if_icmpge +25 -> 86
    //   64: aload_3
    //   65: astore_2
    //   66: aload 5
    //   68: iload 6
    //   70: aaload
    //   71: invokevirtual 166	java/io/File:exists	()Z
    //   74: ifeq -46 -> 28
    //   77: iload 6
    //   79: iconst_1
    //   80: iadd
    //   81: istore 6
    //   83: goto -26 -> 57
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 106	com/bumptech/glide/a/a:l	I
    //   91: iconst_1
    //   92: iadd
    //   93: putfield 106	com/bumptech/glide/a/a:l	I
    //   96: aload_0
    //   97: getfield 133	com/bumptech/glide/a/a:j	Ljava/io/Writer;
    //   100: ldc_w 425
    //   103: invokevirtual 141	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   106: pop
    //   107: aload_0
    //   108: getfield 133	com/bumptech/glide/a/a:j	Ljava/io/Writer;
    //   111: bipush 32
    //   113: invokevirtual 144	java/io/Writer:append	(C)Ljava/io/Writer;
    //   116: pop
    //   117: aload_0
    //   118: getfield 133	com/bumptech/glide/a/a:j	Ljava/io/Writer;
    //   121: aload_1
    //   122: invokevirtual 141	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   125: pop
    //   126: aload_0
    //   127: getfield 133	com/bumptech/glide/a/a:j	Ljava/io/Writer;
    //   130: bipush 10
    //   132: invokevirtual 144	java/io/Writer:append	(C)Ljava/io/Writer;
    //   135: pop
    //   136: aload_0
    //   137: invokespecial 273	com/bumptech/glide/a/a:e	()Z
    //   140: ifeq +15 -> 155
    //   143: aload_0
    //   144: getfield 70	com/bumptech/glide/a/a:a	Ljava/util/concurrent/ThreadPoolExecutor;
    //   147: aload_0
    //   148: getfield 77	com/bumptech/glide/a/a:n	Ljava/util/concurrent/Callable;
    //   151: invokevirtual 277	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   154: pop
    //   155: new 14	com/bumptech/glide/a/a$c
    //   158: dup
    //   159: aload_0
    //   160: aload_1
    //   161: aload 4
    //   163: invokestatic 118	com/bumptech/glide/a/a$b:e	(Lcom/bumptech/glide/a/a$b;)J
    //   166: aload 4
    //   168: getfield 447	com/bumptech/glide/a/a$b:a	[Ljava/io/File;
    //   171: aload 4
    //   173: invokestatic 251	com/bumptech/glide/a/a$b:b	(Lcom/bumptech/glide/a/a$b;)[J
    //   176: aconst_null
    //   177: invokespecial 450	com/bumptech/glide/a/a$c:<init>	(Lcom/bumptech/glide/a/a;Ljava/lang/String;J[Ljava/io/File;[JLcom/bumptech/glide/a/b;)V
    //   180: astore_2
    //   181: goto -153 -> 28
    //   184: astore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_1
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	a
    //   0	189	1	paramString	String
    //   27	154	2	localObject1	Object
    //   1	64	3	localObject2	Object
    //   19	153	4	localb	b
    //   47	20	5	arrayOfFile	File[]
    //   55	27	6	i1	int
    //   52	10	7	i2	int
    // Exception table:
    //   from	to	target	type
    //   4	21	184	finally
    //   34	54	184	finally
    //   66	77	184	finally
    //   86	155	184	finally
    //   155	181	184	finally
  }
  
  public void a()
  {
    close();
    e.a(this.b);
  }
  
  public a b(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public boolean c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        f();
        b localb = (b)this.k.get(paramString);
        Object localObject;
        if (localb != null)
        {
          localObject = b.a(localb);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.i -= b.b(localb)[i1];
          b.b(localb)[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.h)
        {
          localObject = localb.a(i1);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.l += 1;
      this.j.append("REMOVE");
      this.j.append(' ');
      this.j.append(paramString);
      this.j.append('\n');
      this.k.remove(paramString);
      if (e()) {
        this.a.submit(this.n);
      }
      boolean bool = true;
    }
  }
  
  public void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.j;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.k.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          b localb = (b)((Iterator)localObject1).next();
          if (b.a(localb) == null) {
            continue;
          }
          b.a(localb).b();
          continue;
        }
        g();
      }
      finally {}
      this.j.close();
      this.j = null;
    }
  }
  
  public final class a
  {
    private final a.b b;
    private final boolean[] c;
    private boolean d;
    
    private a(a.b paramb)
    {
      this.b = paramb;
      if (a.b.d(paramb)) {}
      for (this$1 = null;; this$1 = new boolean[a.e(a.this)])
      {
        this.c = a.this;
        return;
      }
    }
    
    public File a(int paramInt)
    {
      synchronized (a.this)
      {
        if (a.b.a(this.b) != this) {
          throw new IllegalStateException();
        }
      }
      if (!a.b.d(this.b)) {
        this.c[paramInt] = true;
      }
      File localFile = this.b.b(paramInt);
      if (!a.f(a.this).exists()) {
        a.f(a.this).mkdirs();
      }
      return localFile;
    }
    
    public void a()
    {
      a.a(a.this, this, true);
      this.d = true;
    }
    
    public void b()
    {
      a.a(a.this, this, false);
    }
    
    public void c()
    {
      if (!this.d) {}
      try
      {
        b();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  private final class b
  {
    File[] a;
    File[] b;
    private final String d;
    private final long[] e;
    private boolean f;
    private a.a g;
    private long h;
    
    private b(String paramString)
    {
      this.d = paramString;
      this.e = new long[a.e(a.this)];
      this.a = new File[a.e(a.this)];
      this.b = new File[a.e(a.this)];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      while (i < a.e(a.this))
      {
        paramString.append(i);
        this.a[i] = new File(a.f(a.this), paramString.toString());
        paramString.append(".tmp");
        this.b[i] = new File(a.f(a.this), paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
    }
    
    private void a(String[] paramArrayOfString)
    {
      if (paramArrayOfString.length != a.e(a.this)) {
        throw b(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.e[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw b(paramArrayOfString);
      }
    }
    
    private IOException b(String[] paramArrayOfString)
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    public File a(int paramInt)
    {
      return this.a[paramInt];
    }
    
    public String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.e;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        localStringBuilder.append(' ').append(l);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public File b(int paramInt)
    {
      return this.b[paramInt];
    }
  }
  
  public final class c
  {
    private final String b;
    private final long c;
    private final long[] d;
    private final File[] e;
    
    private c(String paramString, long paramLong, File[] paramArrayOfFile, long[] paramArrayOfLong)
    {
      this.b = paramString;
      this.c = paramLong;
      this.e = paramArrayOfFile;
      this.d = paramArrayOfLong;
    }
    
    public File a(int paramInt)
    {
      return this.e[paramInt];
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */