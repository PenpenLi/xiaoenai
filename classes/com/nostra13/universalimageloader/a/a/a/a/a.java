package com.nostra13.universalimageloader.a.a.a.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
  private static final OutputStream r = new c();
  final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File c;
  private final File d;
  private final File e;
  private final File f;
  private final int g;
  private long h;
  private int i;
  private final int j;
  private long k = 0L;
  private int l = 0;
  private Writer m;
  private final LinkedHashMap<String, b> n = new LinkedHashMap(0, 0.75F, true);
  private int o;
  private long p = 0L;
  private final Callable<Void> q = new b(this);
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.c = paramFile;
    this.g = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.j = paramInt2;
    this.h = paramLong;
    this.i = paramInt3;
  }
  
  private a a(String paramString, long paramLong)
  {
    for (;;)
    {
      a locala;
      try
      {
        j();
        e(paramString);
        b localb = (b)this.n.get(paramString);
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
          this.n.put(paramString, localb);
          locala = new a(localb, null);
          b.a(localb, locala);
          this.m.write("DIRTY " + paramString + '\n');
          this.m.flush();
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
  
  public static a a(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt3 <= 0) {
      throw new IllegalArgumentException("maxFileCount <= 0");
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
        break label165;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new a(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
      if (!((a)localObject).d.exists()) {
        break label227;
      }
      try
      {
        ((a)localObject).f();
        ((a)localObject).g();
        ((a)localObject).m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((a)localObject).d, true), g.a));
        return (a)localObject;
      }
      catch (IOException localIOException)
      {
        label165:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((a)localObject).d();
      }
      a((File)localObject, localFile, false);
    }
    label227:
    paramFile.mkdirs();
    paramFile = new a(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
    paramFile.h();
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
          if (i1 >= this.j) {
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
      if (i2 < this.j)
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
            this.k = (this.k - l1 + l2);
            this.l += 1;
          }
        }
        else {
          a(parama);
        }
      }
      else
      {
        this.o += 1;
        b.a(localb, null);
        if ((b.d(localb) | paramBoolean))
        {
          b.a(localb, true);
          this.m.write("CLEAN " + b.c(localb) + localb.a() + '\n');
          if (paramBoolean)
          {
            l1 = this.p;
            this.p = (1L + l1);
            b.a(localb, l1);
          }
        }
        for (;;)
        {
          this.m.flush();
          if ((this.k <= this.h) && (this.l <= this.i) && (!i())) {
            break;
          }
          this.b.submit(this.q);
          break;
          this.n.remove(b.c(localb));
          this.m.write("REMOVE " + b.c(localb) + '\n');
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
        this.n.remove(str);
      }
    }
    else
    {
      str = paramString.substring(i2, i3);
    }
    for (;;)
    {
      b localb2 = (b)this.n.get(str);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(str, null);
        this.n.put(str, localb1);
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
  
  private void e(String paramString)
  {
    if (!a.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
    }
  }
  
  private void f()
  {
    e locale = new e(new FileInputStream(this.d), g.a);
    int i1;
    try
    {
      String str1 = locale.a();
      String str2 = locale.a();
      String str3 = locale.a();
      String str4 = locale.a();
      String str5 = locale.a();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.g).equals(str3)) || (!Integer.toString(this.j).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      g.a(locale);
      throw ((Throwable)localObject);
    }
  }
  
  private void g()
  {
    a(this.e);
    Iterator localIterator = this.n.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int i1;
      if (b.a(localb) == null)
      {
        i1 = 0;
        while (i1 < this.j)
        {
          this.k += b.b(localb)[i1];
          this.l += 1;
          i1 += 1;
        }
      }
      else
      {
        b.a(localb, null);
        i1 = 0;
        while (i1 < this.j)
        {
          a(localb.a(i1));
          a(localb.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        if (this.m != null) {
          this.m.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), g.a));
        b localb;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.g));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.j));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.n.values().iterator();
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
    if (this.d.exists()) {
      a(this.d, this.f, true);
    }
    a(this.e, this.d, false);
    this.f.delete();
    this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), g.a));
  }
  
  private boolean i()
  {
    return (this.o >= 2000) && (this.o >= this.n.size());
  }
  
  private void j()
  {
    if (this.m == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void k()
  {
    while (this.k > this.h) {
      c((String)((Map.Entry)this.n.entrySet().iterator().next()).getKey());
    }
  }
  
  private void l()
  {
    while (this.l > this.i) {
      c((String)((Map.Entry)this.n.entrySet().iterator().next()).getKey());
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
    //   5: invokespecial 137	com/nostra13/universalimageloader/a/a/a/a/a:j	()V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 140	com/nostra13/universalimageloader/a/a/a/a/a:e	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 77	com/nostra13/universalimageloader/a/a/a/a/a:n	Ljava/util/LinkedHashMap;
    //   17: aload_1
    //   18: invokevirtual 144	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 13	com/nostra13/universalimageloader/a/a/a/a/a$b
    //   24: astore 5
    //   26: aload 5
    //   28: ifnonnull +9 -> 37
    //   31: aload_3
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: aload_3
    //   38: astore_2
    //   39: aload 5
    //   41: invokestatic 281	com/nostra13/universalimageloader/a/a/a/a/a$b:d	(Lcom/nostra13/universalimageloader/a/a/a/a/a$b;)Z
    //   44: ifeq -11 -> 33
    //   47: aload_0
    //   48: getfield 127	com/nostra13/universalimageloader/a/a/a/a/a:j	I
    //   51: anewarray 110	java/io/File
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 127	com/nostra13/universalimageloader/a/a/a/a/a:j	I
    //   59: anewarray 491	java/io/InputStream
    //   62: astore 4
    //   64: iconst_0
    //   65: istore 7
    //   67: iload 7
    //   69: aload_0
    //   70: getfield 127	com/nostra13/universalimageloader/a/a/a/a/a:j	I
    //   73: if_icmpge +83 -> 156
    //   76: aload 5
    //   78: iload 7
    //   80: invokevirtual 297	com/nostra13/universalimageloader/a/a/a/a/a$b:a	(I)Ljava/io/File;
    //   83: astore 6
    //   85: aload_2
    //   86: iload 7
    //   88: aload 6
    //   90: aastore
    //   91: aload 4
    //   93: iload 7
    //   95: new 408	java/io/FileInputStream
    //   98: dup
    //   99: aload 6
    //   101: invokespecial 410	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: aastore
    //   105: iload 7
    //   107: iconst_1
    //   108: iadd
    //   109: istore 7
    //   111: goto -44 -> 67
    //   114: astore_1
    //   115: iconst_0
    //   116: istore 7
    //   118: aload_3
    //   119: astore_2
    //   120: iload 7
    //   122: aload_0
    //   123: getfield 127	com/nostra13/universalimageloader/a/a/a/a/a:j	I
    //   126: if_icmpge -93 -> 33
    //   129: aload_3
    //   130: astore_2
    //   131: aload 4
    //   133: iload 7
    //   135: aaload
    //   136: ifnull -103 -> 33
    //   139: aload 4
    //   141: iload 7
    //   143: aaload
    //   144: invokestatic 437	com/nostra13/universalimageloader/a/a/a/a/g:a	(Ljava/io/Closeable;)V
    //   147: iload 7
    //   149: iconst_1
    //   150: iadd
    //   151: istore 7
    //   153: goto -35 -> 118
    //   156: aload_0
    //   157: aload_0
    //   158: getfield 134	com/nostra13/universalimageloader/a/a/a/a/a:o	I
    //   161: iconst_1
    //   162: iadd
    //   163: putfield 134	com/nostra13/universalimageloader/a/a/a/a/a:o	I
    //   166: aload_0
    //   167: getfield 164	com/nostra13/universalimageloader/a/a/a/a/a:m	Ljava/io/Writer;
    //   170: new 166	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 493
    //   180: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: bipush 10
    //   189: invokevirtual 176	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   192: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 496	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   198: pop
    //   199: aload_0
    //   200: invokespecial 326	com/nostra13/universalimageloader/a/a/a/a/a:i	()Z
    //   203: ifeq +15 -> 218
    //   206: aload_0
    //   207: getfield 97	com/nostra13/universalimageloader/a/a/a/a/a:b	Ljava/util/concurrent/ThreadPoolExecutor;
    //   210: aload_0
    //   211: getfield 104	com/nostra13/universalimageloader/a/a/a/a/a:q	Ljava/util/concurrent/Callable;
    //   214: invokevirtual 330	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   217: pop
    //   218: new 16	com/nostra13/universalimageloader/a/a/a/a/a$c
    //   221: dup
    //   222: aload_0
    //   223: aload_1
    //   224: aload 5
    //   226: invokestatic 149	com/nostra13/universalimageloader/a/a/a/a/a$b:e	(Lcom/nostra13/universalimageloader/a/a/a/a/a$b;)J
    //   229: aload_2
    //   230: aload 4
    //   232: aload 5
    //   234: invokestatic 304	com/nostra13/universalimageloader/a/a/a/a/a$b:b	(Lcom/nostra13/universalimageloader/a/a/a/a/a$b;)[J
    //   237: aconst_null
    //   238: invokespecial 499	com/nostra13/universalimageloader/a/a/a/a/a$c:<init>	(Lcom/nostra13/universalimageloader/a/a/a/a/a;Ljava/lang/String;J[Ljava/io/File;[Ljava/io/InputStream;[JLcom/nostra13/universalimageloader/a/a/a/a/b;)V
    //   241: astore_2
    //   242: goto -209 -> 33
    //   245: astore_1
    //   246: aload_0
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	a
    //   0	250	1	paramString	String
    //   32	210	2	localObject1	Object
    //   1	129	3	localObject2	Object
    //   62	169	4	arrayOfInputStream	InputStream[]
    //   24	209	5	localb	b
    //   83	17	6	localFile	File
    //   65	87	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   67	85	114	java/io/FileNotFoundException
    //   91	105	114	java/io/FileNotFoundException
    //   4	26	245	finally
    //   39	64	245	finally
    //   67	85	245	finally
    //   91	105	245	finally
    //   120	129	245	finally
    //   139	147	245	finally
    //   156	218	245	finally
    //   218	242	245	finally
  }
  
  public File a()
  {
    return this.c;
  }
  
  public long b()
  {
    try
    {
      long l1 = this.h;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public a b(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public int c()
  {
    try
    {
      int i1 = this.i;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        j();
        e(paramString);
        b localb = (b)this.n.get(paramString);
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
          this.k -= b.b(localb)[i1];
          this.l -= 1;
          b.b(localb)[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.j)
        {
          localObject = localb.a(i1);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.o += 1;
      this.m.append("REMOVE " + paramString + '\n');
      this.n.remove(paramString);
      if (i()) {
        this.b.submit(this.q);
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
        Object localObject1 = this.m;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.n.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          b localb = (b)((Iterator)localObject1).next();
          if (b.a(localb) == null) {
            continue;
          }
          b.a(localb).b();
          continue;
        }
        k();
      }
      finally {}
      l();
      this.m.close();
      this.m = null;
    }
  }
  
  public void d()
  {
    close();
    g.a(this.c);
  }
  
  public final class a
  {
    private final a.b b;
    private final boolean[] c;
    private boolean d;
    private boolean e;
    
    private a(a.b paramb)
    {
      this.b = paramb;
      if (a.b.d(paramb)) {}
      for (this$1 = null;; this$1 = new boolean[a.f(a.this)])
      {
        this.c = a.this;
        return;
      }
    }
    
    public OutputStream a(int paramInt)
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
      try
      {
        Object localObject2 = new FileOutputStream(localFile);
        localObject2 = new a((OutputStream)localObject2, null);
        return (OutputStream)localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          a.g(a.this).mkdirs();
          try
          {
            FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            OutputStream localOutputStream = a.e();
            return localOutputStream;
          }
        }
      }
    }
    
    public void a()
    {
      if (this.d)
      {
        a.a(a.this, this, false);
        a.this.c(a.b.c(this.b));
      }
      for (;;)
      {
        this.e = true;
        return;
        a.a(a.this, this, true);
      }
    }
    
    public void b()
    {
      a.a(a.this, this, false);
    }
    
    private class a
      extends FilterOutputStream
    {
      private a(OutputStream paramOutputStream)
      {
        super();
      }
      
      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          a.a.a(a.a.this, true);
        }
      }
      
      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          a.a.a(a.a.this, true);
        }
      }
      
      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          a.a.a(a.a.this, true);
        }
      }
      
      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException paramArrayOfByte)
        {
          a.a.a(a.a.this, true);
        }
      }
    }
  }
  
  private final class b
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private a.a e;
    private long f;
    
    private b(String paramString)
    {
      this.b = paramString;
      this.c = new long[a.f(a.this)];
    }
    
    private void a(String[] paramArrayOfString)
    {
      if (paramArrayOfString.length != a.f(a.this)) {
        throw b(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.c[i] = Long.parseLong(paramArrayOfString[i]);
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
      return new File(a.g(a.this), this.b + "" + paramInt);
    }
    
    public String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.c;
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
      return new File(a.g(a.this), this.b + "" + paramInt + ".tmp");
    }
  }
  
  public final class c
    implements Closeable
  {
    private final String b;
    private final long c;
    private File[] d;
    private final InputStream[] e;
    private final long[] f;
    
    private c(String paramString, long paramLong, File[] paramArrayOfFile, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
    {
      this.b = paramString;
      this.c = paramLong;
      this.d = paramArrayOfFile;
      this.e = paramArrayOfInputStream;
      this.f = paramArrayOfLong;
    }
    
    public File a(int paramInt)
    {
      return this.d[paramInt];
    }
    
    public void close()
    {
      InputStream[] arrayOfInputStream = this.e;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        g.a(arrayOfInputStream[i]);
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */