package com.xiaoenai.app.widget.gif;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GifDecoderView
  extends ImageView
{
  private HandlerThread a = new HandlerThread("GifDecoderView");
  private Handler b;
  private a c;
  
  public GifDecoderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.start();
    this.b = new Handler(this.a.getLooper());
  }
  
  public void a()
  {
    if (this.c != null)
    {
      this.c.a();
      this.b.removeCallbacks(this.c);
      this.c = null;
    }
  }
  
  public void b()
  {
    a();
    this.b.removeCallbacks(this.c);
    if (this.a.isAlive()) {
      this.a.quit();
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    b();
  }
  
  private class a
    implements Runnable
  {
    boolean a;
    a b;
    private String d;
    
    public void a()
    {
      this.a = false;
      Thread.currentThread().interrupt();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: new 36	com/xiaoenai/app/widget/gif/a
      //   4: dup
      //   5: invokespecial 39	com/xiaoenai/app/widget/gif/a:<init>	()V
      //   8: putfield 41	com/xiaoenai/app/widget/gif/GifDecoderView$a:b	Lcom/xiaoenai/app/widget/gif/a;
      //   11: new 43	java/io/FileInputStream
      //   14: dup
      //   15: new 45	java/io/File
      //   18: dup
      //   19: aload_0
      //   20: getfield 47	com/xiaoenai/app/widget/gif/GifDecoderView$a:d	Ljava/lang/String;
      //   23: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
      //   26: invokespecial 53	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   29: astore_1
      //   30: aload_0
      //   31: getfield 41	com/xiaoenai/app/widget/gif/GifDecoderView$a:b	Lcom/xiaoenai/app/widget/gif/a;
      //   34: aload_1
      //   35: invokevirtual 56	com/xiaoenai/app/widget/gif/a:a	(Ljava/io/InputStream;)I
      //   38: pop
      //   39: aload_1
      //   40: invokevirtual 59	java/io/FileInputStream:close	()V
      //   43: aload_0
      //   44: getfield 41	com/xiaoenai/app/widget/gif/GifDecoderView$a:b	Lcom/xiaoenai/app/widget/gif/a;
      //   47: invokevirtual 62	com/xiaoenai/app/widget/gif/a:a	()I
      //   50: istore 5
      //   52: aload_0
      //   53: getfield 19	com/xiaoenai/app/widget/gif/GifDecoderView$a:a	Z
      //   56: ifeq +129 -> 185
      //   59: invokestatic 25	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   62: invokevirtual 66	java/lang/Thread:isInterrupted	()Z
      //   65: ifne +120 -> 185
      //   68: iconst_0
      //   69: istore_2
      //   70: iload_2
      //   71: iload 5
      //   73: if_icmpge -21 -> 52
      //   76: aload_0
      //   77: getfield 19	com/xiaoenai/app/widget/gif/GifDecoderView$a:a	Z
      //   80: ifeq -28 -> 52
      //   83: invokestatic 25	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   86: invokevirtual 66	java/lang/Thread:isInterrupted	()Z
      //   89: ifne -37 -> 52
      //   92: getstatic 71	com/xiaoenai/app/classes/chat/messagelist/a:a	Ljava/lang/Boolean;
      //   95: invokevirtual 76	java/lang/Boolean:booleanValue	()Z
      //   98: ifne +29 -> 127
      //   101: aload_0
      //   102: getfield 41	com/xiaoenai/app/widget/gif/GifDecoderView$a:b	Lcom/xiaoenai/app/widget/gif/a;
      //   105: iload_2
      //   106: invokevirtual 79	com/xiaoenai/app/widget/gif/a:b	(I)Landroid/graphics/Bitmap;
      //   109: astore_1
      //   110: aload_0
      //   111: getfield 81	com/xiaoenai/app/widget/gif/GifDecoderView$a:c	Lcom/xiaoenai/app/widget/gif/GifDecoderView;
      //   114: new 83	com/xiaoenai/app/widget/gif/b
      //   117: dup
      //   118: aload_0
      //   119: aload_1
      //   120: invokespecial 86	com/xiaoenai/app/widget/gif/b:<init>	(Lcom/xiaoenai/app/widget/gif/GifDecoderView$a;Landroid/graphics/Bitmap;)V
      //   123: invokevirtual 90	com/xiaoenai/app/widget/gif/GifDecoderView:post	(Ljava/lang/Runnable;)Z
      //   126: pop
      //   127: aload_0
      //   128: getfield 41	com/xiaoenai/app/widget/gif/GifDecoderView$a:b	Lcom/xiaoenai/app/widget/gif/a;
      //   131: iload_2
      //   132: invokevirtual 93	com/xiaoenai/app/widget/gif/a:a	(I)I
      //   135: istore 4
      //   137: iload 4
      //   139: istore_3
      //   140: iload 4
      //   142: iconst_m1
      //   143: if_icmpne +7 -> 150
      //   146: sipush 1000
      //   149: istore_3
      //   150: iload_3
      //   151: i2l
      //   152: lstore 6
      //   154: lload 6
      //   156: invokestatic 97	java/lang/Thread:sleep	(J)V
      //   159: iload_2
      //   160: iconst_1
      //   161: iadd
      //   162: istore_2
      //   163: goto -93 -> 70
      //   166: astore_1
      //   167: aload_1
      //   168: invokevirtual 100	java/lang/Exception:printStackTrace	()V
      //   171: return
      //   172: astore_1
      //   173: aload_0
      //   174: iconst_0
      //   175: putfield 19	com/xiaoenai/app/widget/gif/GifDecoderView$a:a	Z
      //   178: aload_1
      //   179: invokevirtual 101	java/lang/InterruptedException:printStackTrace	()V
      //   182: goto -23 -> 159
      //   185: aload_0
      //   186: aconst_null
      //   187: putfield 41	com/xiaoenai/app/widget/gif/GifDecoderView$a:b	Lcom/xiaoenai/app/widget/gif/a;
      //   190: invokestatic 106	java/lang/System:gc	()V
      //   193: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	194	0	this	a
      //   29	91	1	localObject	Object
      //   166	2	1	localException	Exception
      //   172	7	1	localInterruptedException	InterruptedException
      //   69	94	2	i	int
      //   139	12	3	j	int
      //   135	9	4	k	int
      //   50	24	5	m	int
      //   152	3	6	l	long
      // Exception table:
      //   from	to	target	type
      //   11	43	166	java/lang/Exception
      //   154	159	172	java/lang/InterruptedException
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\gif\GifDecoderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */