package com.alipay.apmobilesecuritysdk.face;

class APSecuritySdk$1
  implements Runnable
{
  APSecuritySdk$1(APSecuritySdk paramAPSecuritySdk) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$1:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    //   4: invokestatic 24	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/util/LinkedList;
    //   7: invokevirtual 30	java/util/LinkedList:isEmpty	()Z
    //   10: ifne +38 -> 48
    //   13: aload_0
    //   14: getfield 12	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$1:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    //   17: invokestatic 24	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/util/LinkedList;
    //   20: invokevirtual 34	java/util/LinkedList:pollFirst	()Ljava/lang/Object;
    //   23: checkcast 36	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -28 -> 0
    //   31: aload_1
    //   32: invokevirtual 38	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:run	()V
    //   35: goto -35 -> 0
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 12	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$1:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    //   43: invokestatic 42	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:b	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/Thread;
    //   46: pop
    //   47: return
    //   48: aload_0
    //   49: getfield 12	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$1:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    //   52: invokestatic 42	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:b	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/Thread;
    //   55: pop
    //   56: return
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 12	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$1:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    //   62: invokestatic 42	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:b	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/Thread;
    //   65: pop
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	1
    //   26	6	1	localRunningTask	APSecuritySdk.RunningTask
    //   38	1	1	localThrowable	Throwable
    //   57	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	27	38	java/lang/Throwable
    //   31	35	38	java/lang/Throwable
    //   0	27	57	finally
    //   31	35	57	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\APSecuritySdk$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */