package com.d.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Deprecated
public abstract class b
  implements Serializable
{
  private boolean a;
  private String b;
  private boolean c;
  private transient int d;
  
  protected b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.a = paramBoolean1;
    this.c = paramBoolean2;
    this.b = paramString;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.a = paramObjectInputStream.readBoolean();
    this.b = ((String)paramObjectInputStream.readObject());
    this.c = paramObjectInputStream.readBoolean();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeBoolean(this.a);
    paramObjectOutputStream.writeObject(this.b);
    paramObjectOutputStream.writeBoolean(this.c);
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: putfield 55	com/d/a/a/b:d	I
    //   5: invokestatic 59	com/d/a/a/e/b:a	()Z
    //   8: ifeq +22 -> 30
    //   11: ldc 61
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: invokevirtual 65	java/lang/Object:getClass	()Ljava/lang/Class;
    //   23: invokevirtual 71	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   26: aastore
    //   27: invokestatic 74	com/d/a/a/e/b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: invokevirtual 76	com/d/a/a/b:c	()V
    //   34: invokestatic 59	com/d/a/a/e/b:a	()Z
    //   37: ifeq +22 -> 59
    //   40: ldc 78
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_0
    //   49: invokevirtual 65	java/lang/Object:getClass	()Ljava/lang/Class;
    //   52: invokevirtual 71	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   55: aastore
    //   56: invokestatic 74	com/d/a/a/e/b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_2
    //   62: aload_2
    //   63: ldc 80
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 83	com/d/a/a/e/b:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: invokevirtual 87	com/d/a/a/b:g	()I
    //   76: istore 4
    //   78: iload_1
    //   79: iload 4
    //   81: if_icmpge +29 -> 110
    //   84: iconst_1
    //   85: istore 5
    //   87: iload 5
    //   89: istore 6
    //   91: iload 5
    //   93: ifeq +10 -> 103
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 90	com/d/a/a/b:a	(Ljava/lang/Throwable;)Z
    //   101: istore 6
    //   103: iload 6
    //   105: ifeq +39 -> 144
    //   108: iconst_0
    //   109: ireturn
    //   110: iconst_0
    //   111: istore 5
    //   113: goto -26 -> 87
    //   116: astore_2
    //   117: aload_2
    //   118: ldc 92
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 83	com/d/a/a/e/b:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: iload 5
    //   129: istore 6
    //   131: goto -28 -> 103
    //   134: astore_2
    //   135: iconst_1
    //   136: istore_1
    //   137: iload 5
    //   139: ifeq +14 -> 153
    //   142: iconst_0
    //   143: ireturn
    //   144: aload_0
    //   145: invokevirtual 94	com/d/a/a/b:d	()V
    //   148: iconst_1
    //   149: ireturn
    //   150: astore_2
    //   151: iconst_1
    //   152: ireturn
    //   153: iload_1
    //   154: ifeq +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 94	com/d/a/a/b:d	()V
    //   161: aload_2
    //   162: athrow
    //   163: astore_3
    //   164: goto -3 -> 161
    //   167: astore_2
    //   168: iconst_0
    //   169: istore_1
    //   170: iconst_0
    //   171: istore 5
    //   173: goto -36 -> 137
    //   176: astore_2
    //   177: iconst_0
    //   178: istore 5
    //   180: iconst_1
    //   181: istore_1
    //   182: goto -45 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	b
    //   0	185	1	paramInt	int
    //   61	37	2	localThrowable1	Throwable
    //   116	2	2	localThrowable2	Throwable
    //   134	1	2	localObject1	Object
    //   150	12	2	localThrowable3	Throwable
    //   167	1	2	localObject2	Object
    //   176	1	2	localObject3	Object
    //   163	1	3	localThrowable4	Throwable
    //   76	6	4	i	int
    //   85	94	5	bool1	boolean
    //   89	41	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   30	59	61	java/lang/Throwable
    //   96	103	116	java/lang/Throwable
    //   96	103	134	finally
    //   117	127	134	finally
    //   144	148	150	java/lang/Throwable
    //   157	161	163	java/lang/Throwable
    //   30	59	167	finally
    //   62	78	176	finally
  }
  
  protected abstract boolean a(Throwable paramThrowable);
  
  public abstract void b();
  
  public abstract void c();
  
  protected abstract void d();
  
  public final boolean e()
  {
    return this.a;
  }
  
  public final String f()
  {
    return this.b;
  }
  
  protected int g()
  {
    return 20;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */