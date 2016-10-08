package com.alibaba.nb.android.trade.utils.a;

import android.content.Context;
import android.content.res.Resources;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.utils.g;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class b
{
  private static Map<Integer, a> a = new HashMap();
  private static ReentrantReadWriteLock b = new ReentrantReadWriteLock();
  private static final a c;
  private static final a d;
  private static volatile a e;
  private static volatile a f;
  private static final Object g = new Object();
  
  static
  {
    a locala = new a();
    c = locala;
    locala.a = 1;
    c.c = "未在消息文件中找到 id 为 {0} 的消息";
    c.d = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
    c.b = "E";
    locala = new a();
    d = locala;
    locala.a = 2;
    d.c = "检索消息时发生如下错误 {0}";
    d.d = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
    d.b = "E";
  }
  
  private static a a(int paramInt)
  {
    if (e == null) {}
    synchronized (g)
    {
      if (e == null)
      {
        a locala = b(1);
        e = locala;
        if (locala == null) {
          e = c;
        }
      }
    }
    return e;
  }
  
  /* Error */
  public static a a(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: getstatic 25	com/alibaba/nb/android/trade/utils/a/b:a	Ljava/util/Map;
    //   12: iload_0
    //   13: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 105 2 0
    //   21: checkcast 35	com/alibaba/nb/android/trade/utils/a/a
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: ifnonnull +62 -> 90
    //   31: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   34: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   37: invokevirtual 108	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   40: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   43: invokevirtual 112	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   46: invokevirtual 115	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   49: iload_0
    //   50: invokestatic 66	com/alibaba/nb/android/trade/utils/a/b:b	(I)Lcom/alibaba/nb/android/trade/utils/a/a;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +17 -> 72
    //   58: getstatic 25	com/alibaba/nb/android/trade/utils/a/b:a	Ljava/util/Map;
    //   61: iload_0
    //   62: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aload_2
    //   66: invokeinterface 119 3 0
    //   71: pop
    //   72: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   75: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   78: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   81: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 112	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual 120	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   90: aload_2
    //   91: ifnonnull +44 -> 135
    //   94: iload_0
    //   95: invokestatic 122	com/alibaba/nb/android/trade/utils/a/b:a	(I)Lcom/alibaba/nb/android/trade/utils/a/a;
    //   98: astore_1
    //   99: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   102: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   105: invokevirtual 108	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   108: aload_1
    //   109: areturn
    //   110: astore_1
    //   111: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   114: invokevirtual 112	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   117: invokevirtual 120	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic 127	com/alibaba/nb/android/trade/utils/d/a:a	(Ljava/lang/Throwable;)V
    //   127: aload_1
    //   128: invokevirtual 131	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   131: invokestatic 134	com/alibaba/nb/android/trade/utils/a/b:a	(Ljava/lang/String;)Lcom/alibaba/nb/android/trade/utils/a/a;
    //   134: areturn
    //   135: aload_1
    //   136: arraylength
    //   137: istore_0
    //   138: iload_0
    //   139: ifne +14 -> 153
    //   142: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   145: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   148: invokevirtual 108	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   151: aload_2
    //   152: areturn
    //   153: aload_2
    //   154: invokevirtual 70	com/alibaba/nb/android/trade/utils/a/a:clone	()Ljava/lang/Object;
    //   157: checkcast 35	com/alibaba/nb/android/trade/utils/a/a
    //   160: astore_2
    //   161: aload_2
    //   162: aload_2
    //   163: getfield 46	com/alibaba/nb/android/trade/utils/a/a:c	Ljava/lang/String;
    //   166: aload_1
    //   167: invokestatic 82	java/text/MessageFormat:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   170: putfield 46	com/alibaba/nb/android/trade/utils/a/a:c	Ljava/lang/String;
    //   173: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   176: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   179: invokevirtual 108	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   182: aload_2
    //   183: areturn
    //   184: astore_1
    //   185: getstatic 30	com/alibaba/nb/android/trade/utils/a/b:b	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   188: invokevirtual 89	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   191: invokevirtual 108	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramInt	int
    //   0	196	1	paramVarArgs	Object[]
    //   26	157	2	locala1	a
    //   24	4	3	locala2	a
    // Exception table:
    //   from	to	target	type
    //   49	54	110	finally
    //   58	72	110	finally
    //   72	81	110	finally
    //   0	25	122	java/lang/Exception
    //   31	49	122	java/lang/Exception
    //   81	90	122	java/lang/Exception
    //   99	108	122	java/lang/Exception
    //   111	122	122	java/lang/Exception
    //   142	151	122	java/lang/Exception
    //   173	182	122	java/lang/Exception
    //   185	196	122	java/lang/Exception
    //   94	99	184	finally
    //   135	138	184	finally
    //   153	173	184	finally
  }
  
  private static a a(String paramString)
  {
    if (f == null) {}
    synchronized (g)
    {
      if (f == null)
      {
        a locala = b(2);
        f = locala;
        if (locala == null) {
          f = d;
        }
      }
    }
    return f;
  }
  
  private static a b(int paramInt)
  {
    try
    {
      int i = g.a(AliTradeContext.context, "string", "alisdk_message_" + paramInt + "_message");
      if (i == 0) {
        return null;
      }
      a locala = new a();
      locala.a = paramInt;
      locala.c = AliTradeContext.context.getResources().getString(i);
      i = g.a(AliTradeContext.context, "string", "alisdk_message_" + paramInt + "_action");
      if (i != 0) {}
      for (locala.d = AliTradeContext.context.getResources().getString(i);; locala.d = "")
      {
        i = g.a(AliTradeContext.context, "string", "alisdk_message_" + paramInt + "_type");
        if (i == 0) {
          break;
        }
        locala.b = AliTradeContext.context.getResources().getString(i);
        return locala;
      }
      localException.b = "I";
    }
    catch (Exception localException)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("kernel", "Fail to get message of the code " + paramInt + ", the error message is " + localException.getMessage());
      return null;
    }
    return localException;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */