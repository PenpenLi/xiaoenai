package com.bumptech.glide.d.c;

import com.bumptech.glide.d.b;
import java.io.InputStream;

public class o
  implements b<InputStream>
{
  public String a()
  {
    return "";
  }
  
  /* Error */
  public boolean a(InputStream paramInputStream, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: invokestatic 24	com/bumptech/glide/i/a:a	()Lcom/bumptech/glide/i/a;
    //   3: invokevirtual 28	com/bumptech/glide/i/a:b	()[B
    //   6: astore_3
    //   7: aload_1
    //   8: aload_3
    //   9: invokevirtual 34	java/io/InputStream:read	([B)I
    //   12: istore 4
    //   14: iload 4
    //   16: iconst_m1
    //   17: if_icmpeq +43 -> 60
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: iload 4
    //   25: invokevirtual 40	java/io/OutputStream:write	([BII)V
    //   28: goto -21 -> 7
    //   31: astore_1
    //   32: ldc 42
    //   34: iconst_3
    //   35: invokestatic 48	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   38: ifeq +12 -> 50
    //   41: ldc 42
    //   43: ldc 50
    //   45: aload_1
    //   46: invokestatic 54	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   49: pop
    //   50: invokestatic 24	com/bumptech/glide/i/a:a	()Lcom/bumptech/glide/i/a;
    //   53: aload_3
    //   54: invokevirtual 57	com/bumptech/glide/i/a:a	([B)Z
    //   57: pop
    //   58: iconst_0
    //   59: ireturn
    //   60: invokestatic 24	com/bumptech/glide/i/a:a	()Lcom/bumptech/glide/i/a;
    //   63: aload_3
    //   64: invokevirtual 57	com/bumptech/glide/i/a:a	([B)Z
    //   67: pop
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_1
    //   71: invokestatic 24	com/bumptech/glide/i/a:a	()Lcom/bumptech/glide/i/a;
    //   74: aload_3
    //   75: invokevirtual 57	com/bumptech/glide/i/a:a	([B)Z
    //   78: pop
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	o
    //   0	81	1	paramInputStream	InputStream
    //   0	81	2	paramOutputStream	java.io.OutputStream
    //   6	69	3	arrayOfByte	byte[]
    //   12	12	4	i	int
    // Exception table:
    //   from	to	target	type
    //   7	14	31	java/io/IOException
    //   20	28	31	java/io/IOException
    //   7	14	70	finally
    //   20	28	70	finally
    //   32	50	70	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */