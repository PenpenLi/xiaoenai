package com.xiaoenai.app.feature.feedback.c;

public class a
{
  private static long a;
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 13	java/lang/System:currentTimeMillis	()J
    //   6: lstore_1
    //   7: getstatic 15	com/xiaoenai/app/feature/feedback/c/a:a	J
    //   10: lstore_3
    //   11: lload_1
    //   12: lload_3
    //   13: lsub
    //   14: ldc2_w 16
    //   17: lcmp
    //   18: ifge +12 -> 30
    //   21: iconst_1
    //   22: istore 5
    //   24: ldc 2
    //   26: monitorexit
    //   27: iload 5
    //   29: ireturn
    //   30: lload_1
    //   31: putstatic 15	com/xiaoenai/app/feature/feedback/c/a:a	J
    //   34: iconst_0
    //   35: istore 5
    //   37: goto -13 -> 24
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	5	0	localObject	Object
    //   6	25	1	l1	long
    //   10	3	3	l2	long
    //   22	14	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	11	40	finally
    //   30	34	40	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */