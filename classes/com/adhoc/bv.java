package com.adhoc;

public abstract class bv
  implements Runnable
{
  protected final String b;
  
  public bv(String paramString, Object... paramVarArgs)
  {
    this.b = String.format(paramString, paramVarArgs);
  }
  
  protected abstract void b();
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: invokevirtual 35	java/lang/Thread:getName	()Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: astore_2
    //   9: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: aload_0
    //   13: getfield 21	com/adhoc/bv:b	Ljava/lang/String;
    //   16: invokevirtual 39	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: astore_2
    //   21: aload_0
    //   22: invokevirtual 41	com/adhoc/bv:b	()V
    //   25: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload_1
    //   32: ifnonnull +25 -> 57
    //   35: new 43	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   42: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   45: invokevirtual 54	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: ldc 56
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore_2
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 39	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   62: return
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: astore_2
    //   68: aload_3
    //   69: invokestatic 68	com/adhoc/fl:a	(Ljava/lang/Throwable;)V
    //   72: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: aload_1
    //   79: ifnonnull +25 -> 104
    //   82: new 43	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   89: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 54	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: ldc 56
    //   97: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_2
    //   104: aload_3
    //   105: aload_2
    //   106: invokevirtual 39	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   109: return
    //   110: astore_2
    //   111: aconst_null
    //   112: astore_1
    //   113: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   116: astore 4
    //   118: aload_1
    //   119: astore_3
    //   120: aload_1
    //   121: ifnonnull +25 -> 146
    //   124: new 43	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   131: invokestatic 50	java/lang/System:currentTimeMillis	()J
    //   134: invokevirtual 54	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc 56
    //   139: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_3
    //   146: aload 4
    //   148: aload_3
    //   149: invokevirtual 39	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: athrow
    //   154: astore_3
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: goto -46 -> 113
    //   162: astore_3
    //   163: goto -97 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	bv
    //   6	151	1	localObject1	Object
    //   8	98	2	localObject2	Object
    //   110	46	2	localObject3	Object
    //   158	1	2	localObject4	Object
    //   28	30	3	localThread1	Thread
    //   63	6	3	localThrowable1	Throwable
    //   75	74	3	localObject5	Object
    //   154	4	3	localObject6	Object
    //   162	1	3	localThrowable2	Throwable
    //   116	31	4	localThread2	Thread
    // Exception table:
    //   from	to	target	type
    //   0	7	63	java/lang/Throwable
    //   0	7	110	finally
    //   9	19	154	finally
    //   21	25	154	finally
    //   68	72	154	finally
    //   9	19	162	java/lang/Throwable
    //   21	25	162	java/lang/Throwable
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */