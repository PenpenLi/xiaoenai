package com.sina.weibo.sdk.cmd;

import android.content.SharedPreferences;

class WbAppActivator$1
  implements Runnable
{
  WbAppActivator$1(WbAppActivator paramWbAppActivator, SharedPreferences paramSharedPreferences) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	com/sina/weibo/sdk/cmd/WbAppActivator:access$0	()Ljava/lang/String;
    //   3: new 31	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 33
    //   9: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   16: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   19: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   22: invokevirtual 50	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   25: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 59	com/sina/weibo/sdk/utils/LogUtil:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   35: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   38: invokevirtual 62	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   41: ifne +4 -> 45
    //   44: return
    //   45: aconst_null
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_2
    //   50: astore_1
    //   51: aload_0
    //   52: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   55: invokestatic 66	com/sina/weibo/sdk/cmd/WbAppActivator:access$2	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Landroid/content/Context;
    //   58: aload_0
    //   59: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   62: invokestatic 70	com/sina/weibo/sdk/cmd/WbAppActivator:access$3	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/lang/String;
    //   65: invokestatic 74	com/sina/weibo/sdk/cmd/WbAppActivator:access$4	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 4
    //   70: aload 4
    //   72: ifnull +317 -> 389
    //   75: aload_2
    //   76: astore_1
    //   77: new 76	com/sina/weibo/sdk/cmd/CmdInfo
    //   80: dup
    //   81: aload 4
    //   83: invokestatic 82	com/sina/weibo/sdk/utils/AesEncrypt:Decrypt	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokespecial 83	com/sina/weibo/sdk/cmd/CmdInfo:<init>	(Ljava/lang/String;)V
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   94: aload_2
    //   95: invokevirtual 87	com/sina/weibo/sdk/cmd/CmdInfo:getInstallCmds	()Ljava/util/List;
    //   98: invokestatic 91	com/sina/weibo/sdk/cmd/WbAppActivator:access$5	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;Ljava/util/List;)V
    //   101: aload_0
    //   102: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   105: aload_2
    //   106: invokevirtual 94	com/sina/weibo/sdk/cmd/CmdInfo:getInvokeCmds	()Ljava/util/List;
    //   109: invokestatic 97	com/sina/weibo/sdk/cmd/WbAppActivator:access$6	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;Ljava/util/List;)V
    //   112: aload_0
    //   113: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   116: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   119: invokevirtual 100	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   122: aload_2
    //   123: ifnull +39 -> 162
    //   126: aload_0
    //   127: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   130: invokestatic 66	com/sina/weibo/sdk/cmd/WbAppActivator:access$2	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Landroid/content/Context;
    //   133: aload_0
    //   134: getfield 16	com/sina/weibo/sdk/cmd/WbAppActivator$1:val$sdkSp	Landroid/content/SharedPreferences;
    //   137: aload_2
    //   138: invokevirtual 104	com/sina/weibo/sdk/cmd/CmdInfo:getFrequency	()I
    //   141: i2l
    //   142: invokestatic 110	com/sina/weibo/sdk/cmd/WbAppActivator$FrequencyHelper:saveFrequency	(Landroid/content/Context;Landroid/content/SharedPreferences;J)V
    //   145: aload_0
    //   146: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   149: invokestatic 66	com/sina/weibo/sdk/cmd/WbAppActivator:access$2	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Landroid/content/Context;
    //   152: aload_0
    //   153: getfield 16	com/sina/weibo/sdk/cmd/WbAppActivator$1:val$sdkSp	Landroid/content/SharedPreferences;
    //   156: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   159: invokestatic 119	com/sina/weibo/sdk/cmd/WbAppActivator$FrequencyHelper:saveLastTime	(Landroid/content/Context;Landroid/content/SharedPreferences;J)V
    //   162: invokestatic 29	com/sina/weibo/sdk/cmd/WbAppActivator:access$0	()Ljava/lang/String;
    //   165: new 31	java/lang/StringBuilder
    //   168: dup
    //   169: ldc 121
    //   171: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   178: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   181: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   184: invokevirtual 50	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 59	com/sina/weibo/sdk/utils/LogUtil:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: return
    //   194: astore_1
    //   195: aload_3
    //   196: astore_2
    //   197: aload_1
    //   198: astore_3
    //   199: aload_2
    //   200: astore_1
    //   201: invokestatic 29	com/sina/weibo/sdk/cmd/WbAppActivator:access$0	()Ljava/lang/String;
    //   204: aload_3
    //   205: invokevirtual 124	com/sina/weibo/sdk/exception/WeiboException:getMessage	()Ljava/lang/String;
    //   208: invokestatic 127	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_0
    //   212: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   215: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   218: invokevirtual 100	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   221: aload_2
    //   222: ifnull +39 -> 261
    //   225: aload_0
    //   226: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   229: invokestatic 66	com/sina/weibo/sdk/cmd/WbAppActivator:access$2	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Landroid/content/Context;
    //   232: aload_0
    //   233: getfield 16	com/sina/weibo/sdk/cmd/WbAppActivator$1:val$sdkSp	Landroid/content/SharedPreferences;
    //   236: aload_2
    //   237: invokevirtual 104	com/sina/weibo/sdk/cmd/CmdInfo:getFrequency	()I
    //   240: i2l
    //   241: invokestatic 110	com/sina/weibo/sdk/cmd/WbAppActivator$FrequencyHelper:saveFrequency	(Landroid/content/Context;Landroid/content/SharedPreferences;J)V
    //   244: aload_0
    //   245: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   248: invokestatic 66	com/sina/weibo/sdk/cmd/WbAppActivator:access$2	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Landroid/content/Context;
    //   251: aload_0
    //   252: getfield 16	com/sina/weibo/sdk/cmd/WbAppActivator$1:val$sdkSp	Landroid/content/SharedPreferences;
    //   255: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   258: invokestatic 119	com/sina/weibo/sdk/cmd/WbAppActivator$FrequencyHelper:saveLastTime	(Landroid/content/Context;Landroid/content/SharedPreferences;J)V
    //   261: invokestatic 29	com/sina/weibo/sdk/cmd/WbAppActivator:access$0	()Ljava/lang/String;
    //   264: new 31	java/lang/StringBuilder
    //   267: dup
    //   268: ldc 121
    //   270: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   273: aload_0
    //   274: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   277: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   280: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   283: invokevirtual 50	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   286: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 59	com/sina/weibo/sdk/utils/LogUtil:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: return
    //   293: astore_3
    //   294: aload_1
    //   295: astore_2
    //   296: aload_3
    //   297: astore_1
    //   298: aload_0
    //   299: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   302: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   305: invokevirtual 100	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   308: aload_2
    //   309: ifnull +39 -> 348
    //   312: aload_0
    //   313: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   316: invokestatic 66	com/sina/weibo/sdk/cmd/WbAppActivator:access$2	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Landroid/content/Context;
    //   319: aload_0
    //   320: getfield 16	com/sina/weibo/sdk/cmd/WbAppActivator$1:val$sdkSp	Landroid/content/SharedPreferences;
    //   323: aload_2
    //   324: invokevirtual 104	com/sina/weibo/sdk/cmd/CmdInfo:getFrequency	()I
    //   327: i2l
    //   328: invokestatic 110	com/sina/weibo/sdk/cmd/WbAppActivator$FrequencyHelper:saveFrequency	(Landroid/content/Context;Landroid/content/SharedPreferences;J)V
    //   331: aload_0
    //   332: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   335: invokestatic 66	com/sina/weibo/sdk/cmd/WbAppActivator:access$2	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Landroid/content/Context;
    //   338: aload_0
    //   339: getfield 16	com/sina/weibo/sdk/cmd/WbAppActivator$1:val$sdkSp	Landroid/content/SharedPreferences;
    //   342: invokestatic 116	java/lang/System:currentTimeMillis	()J
    //   345: invokestatic 119	com/sina/weibo/sdk/cmd/WbAppActivator$FrequencyHelper:saveLastTime	(Landroid/content/Context;Landroid/content/SharedPreferences;J)V
    //   348: invokestatic 29	com/sina/weibo/sdk/cmd/WbAppActivator:access$0	()Ljava/lang/String;
    //   351: new 31	java/lang/StringBuilder
    //   354: dup
    //   355: ldc 121
    //   357: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: aload_0
    //   361: getfield 14	com/sina/weibo/sdk/cmd/WbAppActivator$1:this$0	Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   364: invokestatic 40	com/sina/weibo/sdk/cmd/WbAppActivator:access$1	(Lcom/sina/weibo/sdk/cmd/WbAppActivator;)Ljava/util/concurrent/locks/ReentrantLock;
    //   367: invokevirtual 46	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   370: invokevirtual 50	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   373: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 59	com/sina/weibo/sdk/utils/LogUtil:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_1
    //   380: athrow
    //   381: astore_1
    //   382: goto -84 -> 298
    //   385: astore_3
    //   386: goto -187 -> 199
    //   389: aconst_null
    //   390: astore_2
    //   391: goto -279 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	1
    //   50	27	1	localObject1	Object
    //   194	4	1	localWeiboException1	com.sina.weibo.sdk.exception.WeiboException
    //   200	180	1	localObject2	Object
    //   381	1	1	localObject3	Object
    //   46	345	2	localObject4	Object
    //   48	157	3	localObject5	Object
    //   293	4	3	localObject6	Object
    //   385	1	3	localWeiboException2	com.sina.weibo.sdk.exception.WeiboException
    //   68	14	4	str	String
    // Exception table:
    //   from	to	target	type
    //   51	70	194	com/sina/weibo/sdk/exception/WeiboException
    //   77	90	194	com/sina/weibo/sdk/exception/WeiboException
    //   51	70	293	finally
    //   77	90	293	finally
    //   201	211	293	finally
    //   90	112	381	finally
    //   90	112	385	com/sina/weibo/sdk/exception/WeiboException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\cmd\WbAppActivator$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */