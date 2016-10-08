package com.xiaoenai.app.net.http.base.b;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.net.http.base.a.c;
import com.xiaoenai.app.net.http.base.e;

public abstract class a<T>
{
  protected String c;
  protected String d;
  protected Handler e;
  
  public a(Context paramContext)
  {
    this.e = new Handler(paramContext.getMainLooper());
  }
  
  /* Error */
  public java.io.File a(b.aq paramaq)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: sipush 2048
    //   5: newarray <illegal type>
    //   7: astore 4
    //   9: aload_1
    //   10: invokevirtual 39	b/aq:g	()Lb/as;
    //   13: invokevirtual 45	b/as:b	()Ljava/io/InputStream;
    //   16: astore_2
    //   17: aload_1
    //   18: invokevirtual 39	b/aq:g	()Lb/as;
    //   21: invokevirtual 48	b/as:a	()J
    //   24: lstore 9
    //   26: lconst_0
    //   27: lstore 7
    //   29: new 50	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: invokevirtual 53	com/xiaoenai/app/net/http/base/b/a:b	()Ljava/lang/String;
    //   37: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 60	java/io/File:exists	()Z
    //   45: ifne +8 -> 53
    //   48: aload_1
    //   49: invokevirtual 63	java/io/File:mkdirs	()Z
    //   52: pop
    //   53: new 50	java/io/File
    //   56: dup
    //   57: aload_1
    //   58: aload_0
    //   59: invokevirtual 65	com/xiaoenai/app/net/http/base/b/a:a	()Ljava/lang/String;
    //   62: invokespecial 68	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore 5
    //   67: new 70	java/io/FileOutputStream
    //   70: dup
    //   71: aload 5
    //   73: invokespecial 73	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_1
    //   77: aload_2
    //   78: aload 4
    //   80: invokevirtual 79	java/io/InputStream:read	([B)I
    //   83: istore 6
    //   85: iload 6
    //   87: iconst_m1
    //   88: if_icmpeq +68 -> 156
    //   91: lload 7
    //   93: iload 6
    //   95: i2l
    //   96: ladd
    //   97: lstore 7
    //   99: aload_1
    //   100: aload 4
    //   102: iconst_0
    //   103: iload 6
    //   105: invokevirtual 83	java/io/FileOutputStream:write	([BII)V
    //   108: aload_0
    //   109: getfield 28	com/xiaoenai/app/net/http/base/b/a:e	Landroid/os/Handler;
    //   112: new 85	com/xiaoenai/app/net/http/base/b/b
    //   115: dup
    //   116: aload_0
    //   117: lload 7
    //   119: lload 9
    //   121: invokespecial 88	com/xiaoenai/app/net/http/base/b/b:<init>	(Lcom/xiaoenai/app/net/http/base/b/a;JJ)V
    //   124: invokevirtual 92	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   127: pop
    //   128: goto -51 -> 77
    //   131: astore 4
    //   133: aload_1
    //   134: astore_3
    //   135: aload 4
    //   137: astore_1
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 95	java/io/InputStream:close	()V
    //   146: aload_3
    //   147: ifnull +7 -> 154
    //   150: aload_3
    //   151: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: aload_1
    //   157: invokevirtual 99	java/io/FileOutputStream:flush	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 95	java/io/InputStream:close	()V
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   176: aload 5
    //   178: areturn
    //   179: astore_2
    //   180: goto -12 -> 168
    //   183: astore_1
    //   184: aload 5
    //   186: areturn
    //   187: astore_2
    //   188: goto -42 -> 146
    //   191: astore_2
    //   192: goto -38 -> 154
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_2
    //   198: goto -60 -> 138
    //   201: astore_1
    //   202: goto -64 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	a
    //   0	205	1	paramaq	b.aq
    //   16	149	2	localInputStream	java.io.InputStream
    //   179	1	2	localIOException1	java.io.IOException
    //   187	1	2	localIOException2	java.io.IOException
    //   191	1	2	localIOException3	java.io.IOException
    //   197	1	2	localObject1	Object
    //   1	150	3	localaq	b.aq
    //   7	94	4	arrayOfByte	byte[]
    //   131	5	4	localObject2	Object
    //   65	120	5	localFile	java.io.File
    //   83	21	6	i	int
    //   27	91	7	l1	long
    //   24	96	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   77	85	131	finally
    //   99	128	131	finally
    //   156	160	131	finally
    //   164	168	179	java/io/IOException
    //   172	176	183	java/io/IOException
    //   142	146	187	java/io/IOException
    //   150	154	191	java/io/IOException
    //   9	17	195	finally
    //   17	26	201	finally
    //   29	53	201	finally
    //   53	77	201	finally
  }
  
  public abstract T a(byte[] paramArrayOfByte);
  
  public String a()
  {
    return this.d;
  }
  
  public void a(float paramFloat) {}
  
  public void a(float paramFloat, long paramLong) {}
  
  public abstract void a(c paramc, T paramT);
  
  public abstract void a(e parame);
  
  public abstract void a(T paramT);
  
  public String b()
  {
    return this.c;
  }
  
  public Handler c()
  {
    return this.e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\base\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */