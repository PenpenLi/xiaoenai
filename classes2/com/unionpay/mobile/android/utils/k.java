package com.unionpay.mobile.android.utils;

final class k
  extends Thread
{
  k(i parami) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 19	java/lang/Thread:run	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc2_w 20
    //   10: invokevirtual 27	java/lang/Object:wait	(J)V
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: getfield 10	com/unionpay/mobile/android/utils/k:a	Lcom/unionpay/mobile/android/utils/i;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: invokestatic 33	com/unionpay/mobile/android/utils/i:b	()Lorg/simalliance/openmobileapi/SEService;
    //   25: ifnull +12 -> 37
    //   28: invokestatic 33	com/unionpay/mobile/android/utils/i:b	()Lorg/simalliance/openmobileapi/SEService;
    //   31: invokevirtual 39	org/simalliance/openmobileapi/SEService:isConnected	()Z
    //   34: ifne +23 -> 57
    //   37: ldc 41
    //   39: ldc 43
    //   41: invokestatic 49	com/unionpay/mobile/android/utils/h:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: getfield 10	com/unionpay/mobile/android/utils/k:a	Lcom/unionpay/mobile/android/utils/i;
    //   49: invokestatic 52	com/unionpay/mobile/android/utils/i:b	(Lcom/unionpay/mobile/android/utils/i;)Landroid/os/Handler;
    //   52: iconst_2
    //   53: invokevirtual 58	android/os/Handler:sendEmptyMessage	(I)Z
    //   56: pop
    //   57: aload_1
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 61	java/lang/InterruptedException:printStackTrace	()V
    //   70: ldc 41
    //   72: new 63	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 68	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 49	com/unionpay/mobile/android/utils/h:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: goto -78 -> 15
    //   96: astore_2
    //   97: aload_1
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	k
    //   60	4	1	localObject1	Object
    //   65	33	1	localInterruptedException	InterruptedException
    //   96	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	15	60	finally
    //   4	6	65	java/lang/InterruptedException
    //   61	65	65	java/lang/InterruptedException
    //   22	37	96	finally
    //   37	57	96	finally
    //   57	59	96	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */