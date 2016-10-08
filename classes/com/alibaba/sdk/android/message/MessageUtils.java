package com.alibaba.sdk.android.message;

import android.content.Context;
import android.content.res.Resources;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.ResourceUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MessageUtils
{
  private static Map<Integer, Message> cachedMessageMetas = new HashMap();
  private static final Object defaultMessageLoadLock;
  private static final Message defaultMessageNotFoundMessage;
  private static final Message defaultUnknownErrorMessage;
  private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private static volatile Message messageNotFoundMessage;
  private static volatile Message unknownErrorMessage;
  
  static
  {
    defaultMessageLoadLock = new Object();
    defaultMessageNotFoundMessage = new Message();
    defaultMessageNotFoundMessage.code = 1;
    defaultMessageNotFoundMessage.message = "未在消息文件中找到 id 为 {0} 的消息";
    defaultMessageNotFoundMessage.action = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
    defaultMessageNotFoundMessage.type = "E";
    defaultUnknownErrorMessage = new Message();
    defaultUnknownErrorMessage.code = 2;
    defaultUnknownErrorMessage.message = "检索消息时发生如下错误 {0}";
    defaultUnknownErrorMessage.action = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
    defaultUnknownErrorMessage.type = "E";
  }
  
  /* Error */
  public static Message createMessage(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: getstatic 25	com/alibaba/sdk/android/message/MessageUtils:cachedMessageMetas	Ljava/util/Map;
    //   12: iload_0
    //   13: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 87 2 0
    //   21: checkcast 35	com/alibaba/sdk/android/message/Message
    //   24: astore_2
    //   25: aload_2
    //   26: ifnonnull +168 -> 194
    //   29: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   32: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   35: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   38: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   41: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   44: invokevirtual 97	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   47: iload_0
    //   48: invokestatic 101	com/alibaba/sdk/android/message/MessageUtils:loadMessage	(I)Lcom/alibaba/sdk/android/message/Message;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +17 -> 70
    //   56: getstatic 25	com/alibaba/sdk/android/message/MessageUtils:cachedMessageMetas	Ljava/util/Map;
    //   59: iload_0
    //   60: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aload_2
    //   64: invokeinterface 105 3 0
    //   69: pop
    //   70: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   73: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   76: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   79: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   82: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   85: invokevirtual 106	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   88: aload_2
    //   89: ifnonnull +44 -> 133
    //   92: iload_0
    //   93: invokestatic 109	com/alibaba/sdk/android/message/MessageUtils:createMessageNotFoundMessage	(I)Lcom/alibaba/sdk/android/message/Message;
    //   96: astore_1
    //   97: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   100: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   103: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   112: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   115: invokevirtual 106	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_1
    //   122: invokestatic 115	com/alibaba/sdk/android/trace/AliSDKLogger:printStackTraceAndMore	(Ljava/lang/Throwable;)V
    //   125: aload_1
    //   126: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokestatic 123	com/alibaba/sdk/android/message/MessageUtils:createUnknownErrorMessage	(Ljava/lang/String;)Lcom/alibaba/sdk/android/message/Message;
    //   132: areturn
    //   133: aload_1
    //   134: arraylength
    //   135: istore_0
    //   136: iload_0
    //   137: ifne +14 -> 151
    //   140: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   143: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   146: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   149: aload_2
    //   150: areturn
    //   151: aload_2
    //   152: invokevirtual 127	com/alibaba/sdk/android/message/Message:clone	()Ljava/lang/Object;
    //   155: checkcast 35	com/alibaba/sdk/android/message/Message
    //   158: astore_3
    //   159: aload_3
    //   160: aload_2
    //   161: getfield 48	com/alibaba/sdk/android/message/Message:message	Ljava/lang/String;
    //   164: aload_1
    //   165: invokestatic 133	java/text/MessageFormat:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   168: putfield 48	com/alibaba/sdk/android/message/Message:message	Ljava/lang/String;
    //   171: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   174: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   177: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   180: aload_3
    //   181: areturn
    //   182: astore_1
    //   183: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   186: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   189: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   192: aload_1
    //   193: athrow
    //   194: goto -106 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramInt	int
    //   0	197	1	paramVarArgs	Object[]
    //   24	137	2	localMessage1	Message
    //   158	23	3	localMessage2	Message
    // Exception table:
    //   from	to	target	type
    //   47	52	108	finally
    //   56	70	108	finally
    //   70	79	108	finally
    //   0	25	120	java/lang/Exception
    //   29	47	120	java/lang/Exception
    //   79	88	120	java/lang/Exception
    //   97	106	120	java/lang/Exception
    //   109	120	120	java/lang/Exception
    //   140	149	120	java/lang/Exception
    //   171	180	120	java/lang/Exception
    //   183	194	120	java/lang/Exception
    //   92	97	182	finally
    //   133	136	182	finally
    //   151	171	182	finally
  }
  
  private static Message createMessageNotFoundMessage(int paramInt)
  {
    if (messageNotFoundMessage == null) {}
    synchronized (defaultMessageLoadLock)
    {
      if (messageNotFoundMessage == null)
      {
        messageNotFoundMessage = loadMessage(1);
        if (messageNotFoundMessage == null) {
          messageNotFoundMessage = defaultMessageNotFoundMessage;
        }
      }
    }
    return messageNotFoundMessage;
  }
  
  private static Message createUnknownErrorMessage(String paramString)
  {
    if (unknownErrorMessage == null) {}
    synchronized (defaultMessageLoadLock)
    {
      if (unknownErrorMessage == null)
      {
        unknownErrorMessage = loadMessage(2);
        if (unknownErrorMessage == null) {
          unknownErrorMessage = defaultUnknownErrorMessage;
        }
      }
    }
    return unknownErrorMessage;
  }
  
  /* Error */
  public static String getMessageContent(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: getstatic 25	com/alibaba/sdk/android/message/MessageUtils:cachedMessageMetas	Ljava/util/Map;
    //   12: iload_0
    //   13: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16: invokeinterface 87 2 0
    //   21: checkcast 35	com/alibaba/sdk/android/message/Message
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: ifnonnull +62 -> 90
    //   31: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   34: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   37: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   40: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   43: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   46: invokevirtual 97	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   49: iload_0
    //   50: invokestatic 101	com/alibaba/sdk/android/message/MessageUtils:loadMessage	(I)Lcom/alibaba/sdk/android/message/Message;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +17 -> 72
    //   58: getstatic 25	com/alibaba/sdk/android/message/MessageUtils:cachedMessageMetas	Ljava/util/Map;
    //   61: iload_0
    //   62: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aload_2
    //   66: invokeinterface 105 3 0
    //   71: pop
    //   72: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   75: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   78: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   81: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual 106	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   90: aload_2
    //   91: ifnonnull +50 -> 141
    //   94: iload_0
    //   95: invokestatic 109	com/alibaba/sdk/android/message/MessageUtils:createMessageNotFoundMessage	(I)Lcom/alibaba/sdk/android/message/Message;
    //   98: getfield 48	com/alibaba/sdk/android/message/Message:message	Ljava/lang/String;
    //   101: astore_1
    //   102: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   105: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   108: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   111: aload_1
    //   112: areturn
    //   113: astore_1
    //   114: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   117: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   120: invokevirtual 106	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic 115	com/alibaba/sdk/android/trace/AliSDKLogger:printStackTraceAndMore	(Ljava/lang/Throwable;)V
    //   130: aload_1
    //   131: invokevirtual 119	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: invokestatic 123	com/alibaba/sdk/android/message/MessageUtils:createUnknownErrorMessage	(Ljava/lang/String;)Lcom/alibaba/sdk/android/message/Message;
    //   137: getfield 48	com/alibaba/sdk/android/message/Message:message	Ljava/lang/String;
    //   140: areturn
    //   141: aload_2
    //   142: getfield 48	com/alibaba/sdk/android/message/Message:message	Ljava/lang/String;
    //   145: aload_1
    //   146: invokestatic 133	java/text/MessageFormat:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   149: astore_1
    //   150: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   153: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   156: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   159: aload_1
    //   160: areturn
    //   161: astore_1
    //   162: getstatic 30	com/alibaba/sdk/android/message/MessageUtils:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   165: invokevirtual 71	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   168: invokevirtual 90	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramInt	int
    //   0	173	1	paramVarArgs	Object[]
    //   26	116	2	localMessage1	Message
    //   24	4	3	localMessage2	Message
    // Exception table:
    //   from	to	target	type
    //   49	54	113	finally
    //   58	72	113	finally
    //   72	81	113	finally
    //   0	25	125	java/lang/Exception
    //   31	49	125	java/lang/Exception
    //   81	90	125	java/lang/Exception
    //   102	111	125	java/lang/Exception
    //   114	125	125	java/lang/Exception
    //   150	159	125	java/lang/Exception
    //   162	173	125	java/lang/Exception
    //   94	102	161	finally
    //   141	150	161	finally
  }
  
  private static Message loadMessage(int paramInt)
  {
    try
    {
      int i = ResourceUtils.getIdentifier(KernelContext.context, "string", "alisdk_message_" + paramInt + "_message");
      if (i == 0) {
        return null;
      }
      Message localMessage = new Message();
      localMessage.code = paramInt;
      localMessage.message = KernelContext.context.getResources().getString(i);
      i = ResourceUtils.getIdentifier(KernelContext.context, "string", "alisdk_message_" + paramInt + "_action");
      if (i != 0) {}
      for (localMessage.action = KernelContext.context.getResources().getString(i);; localMessage.action = "")
      {
        i = ResourceUtils.getIdentifier(KernelContext.context, "string", "alisdk_message_" + paramInt + "_type");
        if (i == 0) {
          break;
        }
        localMessage.type = KernelContext.context.getResources().getString(i);
        return localMessage;
      }
      localException.type = "I";
    }
    catch (Exception localException)
    {
      AliSDKLogger.e("kernel", "Fail to get message of the code " + paramInt + ", the error message is " + localException.getMessage());
      return null;
    }
    return localException;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\message\MessageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */