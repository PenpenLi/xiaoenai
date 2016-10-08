package d.a;

import com.f.a.o.b;
import java.io.File;

class v
  implements o.b
{
  v(u paramu) {}
  
  public void a(File paramFile) {}
  
  /* Error */
  public boolean b(File paramFile)
  {
    // Byte code:
    //   0: new 23	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokestatic 30	d/a/aw:b	(Ljava/io/InputStream;)[B
    //   13: astore_1
    //   14: aload_2
    //   15: invokestatic 34	d/a/aw:c	(Ljava/io/InputStream;)V
    //   18: aload_0
    //   19: getfield 12	d/a/v:a	Ld/a/u;
    //   22: invokestatic 39	d/a/u:a	(Ld/a/u;)Ld/a/q;
    //   25: aload_1
    //   26: invokevirtual 44	d/a/q:a	([B)[B
    //   29: astore_1
    //   30: aload_1
    //   31: ifnonnull +51 -> 82
    //   34: iconst_1
    //   35: istore_3
    //   36: iload_3
    //   37: iconst_2
    //   38: if_icmpne +26 -> 64
    //   41: aload_0
    //   42: getfield 12	d/a/v:a	Ld/a/u;
    //   45: invokestatic 47	d/a/u:b	(Ld/a/u;)Ld/a/x;
    //   48: invokevirtual 53	d/a/x:l	()Z
    //   51: ifeq +13 -> 64
    //   54: aload_0
    //   55: getfield 12	d/a/v:a	Ld/a/u;
    //   58: invokestatic 47	d/a/u:b	(Ld/a/u;)Ld/a/x;
    //   61: invokevirtual 56	d/a/x:k	()V
    //   64: aload_0
    //   65: getfield 12	d/a/v:a	Ld/a/u;
    //   68: invokestatic 59	d/a/u:c	(Ld/a/u;)Z
    //   71: ifeq +23 -> 94
    //   74: iconst_1
    //   75: ireturn
    //   76: aload_2
    //   77: invokestatic 34	d/a/aw:c	(Ljava/io/InputStream;)V
    //   80: aload_1
    //   81: athrow
    //   82: aload_0
    //   83: getfield 12	d/a/v:a	Ld/a/u;
    //   86: aload_1
    //   87: invokestatic 62	d/a/u:a	(Ld/a/u;[B)I
    //   90: istore_3
    //   91: goto -55 -> 36
    //   94: iload_3
    //   95: iconst_1
    //   96: if_icmpne +9 -> 105
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_1
    //   102: goto -26 -> 76
    //   105: iconst_1
    //   106: ireturn
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: goto -34 -> 76
    //   113: astore_1
    //   114: iconst_0
    //   115: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	v
    //   0	116	1	paramFile	File
    //   8	102	2	localFileInputStream	java.io.FileInputStream
    //   35	62	3	i	int
    // Exception table:
    //   from	to	target	type
    //   9	14	101	finally
    //   0	9	107	finally
    //   14	30	113	java/lang/Exception
    //   41	64	113	java/lang/Exception
    //   64	74	113	java/lang/Exception
    //   76	82	113	java/lang/Exception
    //   82	91	113	java/lang/Exception
  }
  
  public void c(File paramFile)
  {
    u.b(this.a).j();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */