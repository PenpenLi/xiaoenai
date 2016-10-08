package com.alibaba.sdk.android.lock;

import android.content.Context;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class InterProcessLock
{
  public boolean disabled;
  public boolean enableUTLog;
  private volatile ProcessFileLock internalFileLock;
  private Object internalLoopLock = new Object();
  private File lockDir;
  private String lockName;
  public long tryLockTimeoutTimeMill = 2000L;
  
  public InterProcessLock(Context paramContext, String paramString)
  {
    this.lockDir = paramContext.getDir("alisdk_locks", 0);
    if (!this.lockDir.exists()) {
      this.lockDir.mkdirs();
    }
    this.lockName = paramString;
  }
  
  private void logUTMessage(String paramString, boolean paramBoolean, String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        UserTrackerService localUserTrackerService = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
        if (localUserTrackerService == null) {
          break;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("process", CommonUtils.getCurrentProcessName());
        if (paramVarArgs.length <= 1) {
          break label111;
        }
        int i = 0;
        int j = paramVarArgs.length;
        if (i >= j) {
          break label111;
        }
        localHashMap.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
        i += 2;
        continue;
        localUserTrackerService.sendCustomHit(paramString, 0L, paramVarArgs, localHashMap);
        return;
      }
      catch (Throwable paramString)
      {
        return;
      }
      paramVarArgs = "error";
      continue;
      label111:
      if (paramBoolean) {
        paramVarArgs = "success";
      }
    }
  }
  
  private FileLock tryLockQuietly(FileChannel paramFileChannel)
  {
    try
    {
      paramFileChannel = paramFileChannel.tryLock(0L, 10L, false);
      return paramFileChannel;
    }
    catch (Throwable paramFileChannel) {}
    return null;
  }
  
  public boolean tryLock()
  {
    try
    {
      boolean bool = tryLock(null);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean tryLock(String paramString)
  {
    boolean bool;
    Object localObject3;
    Object localObject2;
    for (;;)
    {
      Object localObject1;
      FileChannel localFileChannel;
      long l1;
      long l2;
      long l3;
      try
      {
        if (!this.disabled)
        {
          localObject1 = this.internalFileLock;
          if (localObject1 == null) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        localObject3 = null;
      }
      finally {}
      try
      {
        localObject1 = new File(this.lockDir, this.lockName);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).createNewFile();
        }
        localObject2 = new FileOutputStream((File)localObject1);
      }
      catch (Throwable localThrowable1)
      {
        Object localObject5 = null;
        localObject2 = localObject3;
        localObject3 = localObject5;
        continue;
      }
      try
      {
        localFileChannel = ((FileOutputStream)localObject2).getChannel();
        l1 = System.currentTimeMillis();
        l2 = this.tryLockTimeoutTimeMill;
        l3 = this.tryLockTimeoutTimeMill / 4L;
        localObject1 = null;
      }
      catch (Throwable localThrowable2)
      {
        localObject3 = null;
        continue;
        bool = false;
      }
      try
      {
        localObject3 = tryLockQuietly(localFileChannel);
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          if (System.currentTimeMillis() - (l1 + l2) < 0L)
          {
            localObject1 = localObject3;
            Object localObject6 = this.internalLoopLock;
            localObject1 = localObject3;
            try
            {
              this.internalLoopLock.wait(l3);
              localObject1 = localObject3;
              continue;
            }
            finally
            {
              localObject1 = localObject3;
            }
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject3 = localObject1;
        localObject1 = localThrowable3;
        if ((localObject3 == null) && (localObject2 != null)) {
          IOUtils.closeQuietly((Closeable)localObject2);
        }
        if (this.enableUTLog) {
          logUTMessage("tryLock_" + paramString, false, new String[] { "msg", "fail to get lock, the message is " + ((Throwable)localObject1).getMessage() });
        }
        bool = false;
      }
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (this.enableUTLog)
        {
          localObject1 = localObject3;
          logUTMessage("tryLock_" + paramString, false, new String[] { "msg", "fail to get lock" });
        }
      }
      else
      {
        localObject1 = localObject3;
        if (this.enableUTLog)
        {
          localObject1 = localObject3;
          logUTMessage("tryLock_" + paramString, true, new String[] { "msg", "get lock" });
        }
        localObject1 = localObject3;
        this.internalFileLock = new ProcessFileLock(null);
        localObject1 = localObject3;
        this.internalFileLock.fileLock = ((FileLock)localObject3);
        localObject1 = localObject3;
        this.internalFileLock.lockFileStream = ((FileOutputStream)localObject2);
        bool = true;
        continue;
      }
    }
  }
  
  public boolean unLock()
  {
    try
    {
      boolean bool = unLock(null);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean unLock(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 113	com/alibaba/sdk/android/lock/InterProcessLock:disabled	Z
    //   8: istore 4
    //   10: iload 4
    //   12: ifeq +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 115	com/alibaba/sdk/android/lock/InterProcessLock:internalFileLock	Lcom/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock;
    //   23: ifnonnull +8 -> 31
    //   26: iconst_0
    //   27: istore_3
    //   28: goto -13 -> 15
    //   31: aload_0
    //   32: getfield 115	com/alibaba/sdk/android/lock/InterProcessLock:internalFileLock	Lcom/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock;
    //   35: getfield 186	com/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock:fileLock	Ljava/nio/channels/FileLock;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +58 -> 98
    //   43: aload_0
    //   44: getfield 115	com/alibaba/sdk/android/lock/InterProcessLock:internalFileLock	Lcom/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock;
    //   47: getfield 186	com/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock:fileLock	Ljava/nio/channels/FileLock;
    //   50: invokevirtual 198	java/nio/channels/FileLock:release	()V
    //   53: aload_0
    //   54: getfield 152	com/alibaba/sdk/android/lock/InterProcessLock:enableUTLog	Z
    //   57: ifeq +41 -> 98
    //   60: aload_0
    //   61: new 154	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   68: ldc -56
    //   70: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: iconst_1
    //   81: iconst_2
    //   82: anewarray 166	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: ldc -88
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: ldc -54
    //   94: aastore
    //   95: invokespecial 175	com/alibaba/sdk/android/lock/InterProcessLock:logUTMessage	(Ljava/lang/String;Z[Ljava/lang/String;)V
    //   98: aload_0
    //   99: getfield 115	com/alibaba/sdk/android/lock/InterProcessLock:internalFileLock	Lcom/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock;
    //   102: getfield 190	com/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock:lockFileStream	Ljava/io/FileOutputStream;
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: getfield 115	com/alibaba/sdk/android/lock/InterProcessLock:internalFileLock	Lcom/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock;
    //   112: getfield 190	com/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock:lockFileStream	Ljava/io/FileOutputStream;
    //   115: invokestatic 150	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 115	com/alibaba/sdk/android/lock/InterProcessLock:internalFileLock	Lcom/alibaba/sdk/android/lock/InterProcessLock$ProcessFileLock;
    //   123: goto -108 -> 15
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: goto -34 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	InterProcessLock
    //   0	135	1	paramString	String
    //   38	2	2	localFileLock	FileLock
    //   1	27	3	bool1	boolean
    //   8	3	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	126	finally
    //   19	26	126	finally
    //   31	39	126	finally
    //   43	98	126	finally
    //   98	118	126	finally
    //   118	123	126	finally
    //   43	98	131	java/lang/Throwable
  }
  
  private static class ProcessFileLock
  {
    public FileLock fileLock;
    public FileOutputStream lockFileStream;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\lock\InterProcessLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */