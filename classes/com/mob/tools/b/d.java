package com.mob.tools.b;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class d
{
  private FileOutputStream a;
  private FileLock b;
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   18: invokevirtual 22	java/nio/channels/FileLock:release	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   26: goto -15 -> 11
    //   29: astore_1
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	d
    //   6	2	1	localFileLock	FileLock
    //   29	1	1	localThrowable	Throwable
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	26	29	java/lang/Throwable
    //   2	7	33	finally
    //   14	26	33	finally
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new 25	java/io/FileOutputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 27	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: putfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull -10 -> 14
    //   27: aload_0
    //   28: getfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   31: invokevirtual 32	java/io/FileOutputStream:close	()V
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   39: goto -25 -> 14
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: goto -14 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	d
    //   0	51	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	14	17	java/lang/Throwable
    //   2	14	42	finally
    //   18	23	42	finally
    //   27	34	42	finally
    //   34	39	42	finally
    //   27	34	47	java/lang/Throwable
  }
  
  /* Error */
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +9 -> 19
    //   13: iload_3
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: iload_1
    //   20: ifeq +33 -> 53
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   28: invokevirtual 37	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: invokevirtual 43	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   34: putfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   37: aload_0
    //   38: getfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   41: astore_2
    //   42: iload_3
    //   43: istore_1
    //   44: aload_2
    //   45: ifnull -30 -> 15
    //   48: iconst_1
    //   49: istore_1
    //   50: goto -35 -> 15
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   58: invokevirtual 37	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   61: invokevirtual 46	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   64: putfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   67: goto -30 -> 37
    //   70: astore_2
    //   71: aload_0
    //   72: getfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull -40 -> 37
    //   80: aload_0
    //   81: getfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   84: invokevirtual 22	java/nio/channels/FileLock:release	()V
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 17	com/mob/tools/b/d:b	Ljava/nio/channels/FileLock;
    //   92: goto -55 -> 37
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: astore_2
    //   101: goto -14 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	d
    //   0	104	1	paramBoolean	boolean
    //   8	37	2	localObject1	Object
    //   70	1	2	localThrowable1	Throwable
    //   75	2	2	localFileLock	FileLock
    //   95	4	2	localObject2	Object
    //   100	1	2	localThrowable2	Throwable
    //   1	42	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   23	37	70	java/lang/Throwable
    //   53	67	70	java/lang/Throwable
    //   4	9	95	finally
    //   23	37	95	finally
    //   37	42	95	finally
    //   53	67	95	finally
    //   71	76	95	finally
    //   80	87	95	finally
    //   87	92	95	finally
    //   80	87	100	java/lang/Throwable
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 48	com/mob/tools/b/d:a	()V
    //   18: aload_0
    //   19: getfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   22: invokevirtual 32	java/io/FileOutputStream:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 29	com/mob/tools/b/d:a	Ljava/io/FileOutputStream;
    //   30: goto -19 -> 11
    //   33: astore_1
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	d
    //   6	2	1	localFileOutputStream	FileOutputStream
    //   33	1	1	localThrowable	Throwable
    //   37	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	30	33	java/lang/Throwable
    //   2	7	37	finally
    //   14	18	37	finally
    //   18	30	37	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */