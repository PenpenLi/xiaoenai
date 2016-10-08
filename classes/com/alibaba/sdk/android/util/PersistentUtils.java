package com.alibaba.sdk.android.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PersistentUtils
{
  public static class ObjectStore<T>
  {
    private static final String TAG = "ObjectStore";
    private final String dir;
    private final String fileExt;
    
    public ObjectStore(String paramString1, String paramString2)
    {
      this.dir = paramString1;
      this.fileExt = paramString2;
    }
    
    @TargetApi(9)
    private long getApkLastUpdateTime()
    {
      Object localObject = KernelContext.context;
      if (localObject == null) {}
      for (;;)
      {
        return 0L;
        try
        {
          localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 128);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= 9))
          {
            long l = ((PackageInfo)localObject).lastUpdateTime;
            return l;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          AliSDKLogger.e("ObjectStore", localNameNotFoundException);
        }
      }
      return 0L;
    }
    
    /* Error */
    public T readItem()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: getstatic 36	com/alibaba/sdk/android/impl/KernelContext:context	Landroid/content/Context;
      //   5: ifnonnull +5 -> 10
      //   8: aconst_null
      //   9: areturn
      //   10: getstatic 36	com/alibaba/sdk/android/impl/KernelContext:context	Landroid/content/Context;
      //   13: aload_0
      //   14: getfield 20	com/alibaba/sdk/android/util/PersistentUtils$ObjectStore:dir	Ljava/lang/String;
      //   17: iconst_0
      //   18: invokevirtual 79	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
      //   21: invokevirtual 85	java/io/File:listFiles	()[Ljava/io/File;
      //   24: astore 5
      //   26: aload 5
      //   28: arraylength
      //   29: ifne +5 -> 34
      //   32: aconst_null
      //   33: areturn
      //   34: aload 5
      //   36: arraylength
      //   37: istore 7
      //   39: iconst_0
      //   40: istore 6
      //   42: lconst_0
      //   43: lstore 8
      //   45: aconst_null
      //   46: astore_1
      //   47: iload 6
      //   49: iload 7
      //   51: if_icmpge +109 -> 160
      //   54: aload 5
      //   56: iload 6
      //   58: aaload
      //   59: astore 4
      //   61: lload 8
      //   63: lstore 10
      //   65: aload_1
      //   66: astore_2
      //   67: aload 4
      //   69: invokevirtual 89	java/io/File:isFile	()Z
      //   72: ifeq +73 -> 145
      //   75: lload 8
      //   77: lstore 10
      //   79: aload_1
      //   80: astore_2
      //   81: aload 4
      //   83: invokevirtual 92	java/io/File:getName	()Ljava/lang/String;
      //   86: aload_0
      //   87: getfield 22	com/alibaba/sdk/android/util/PersistentUtils$ObjectStore:fileExt	Ljava/lang/String;
      //   90: invokevirtual 98	java/lang/String:endsWith	(Ljava/lang/String;)Z
      //   93: ifeq +52 -> 145
      //   96: aload 4
      //   98: invokevirtual 92	java/io/File:getName	()Ljava/lang/String;
      //   101: astore_2
      //   102: aload_2
      //   103: iconst_0
      //   104: aload_2
      //   105: invokevirtual 102	java/lang/String:length	()I
      //   108: aload_0
      //   109: getfield 22	com/alibaba/sdk/android/util/PersistentUtils$ObjectStore:fileExt	Ljava/lang/String;
      //   112: invokevirtual 102	java/lang/String:length	()I
      //   115: isub
      //   116: invokevirtual 106	java/lang/String:substring	(II)Ljava/lang/String;
      //   119: invokestatic 112	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   122: lstore 10
      //   124: lload 10
      //   126: lload 8
      //   128: lcmp
      //   129: ifle +130 -> 259
      //   132: aload 4
      //   134: astore_1
      //   135: lload 10
      //   137: lstore 8
      //   139: aload_1
      //   140: astore_2
      //   141: lload 8
      //   143: lstore 10
      //   145: iload 6
      //   147: iconst_1
      //   148: iadd
      //   149: istore 6
      //   151: lload 10
      //   153: lstore 8
      //   155: aload_2
      //   156: astore_1
      //   157: goto -110 -> 47
      //   160: aload_1
      //   161: ifnonnull +5 -> 166
      //   164: aconst_null
      //   165: areturn
      //   166: aload_0
      //   167: invokespecial 114	com/alibaba/sdk/android/util/PersistentUtils$ObjectStore:getApkLastUpdateTime	()J
      //   170: lstore 10
      //   172: lload 10
      //   174: lconst_0
      //   175: lcmp
      //   176: ifne +12 -> 188
      //   179: ldc 11
      //   181: ldc 116
      //   183: invokestatic 119	com/alibaba/sdk/android/trace/AliSDKLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   186: aconst_null
      //   187: areturn
      //   188: lload 8
      //   190: lload 10
      //   192: lcmp
      //   193: ifge +16 -> 209
      //   196: aload_1
      //   197: invokevirtual 122	java/io/File:delete	()Z
      //   200: ifne +7 -> 207
      //   203: aload_1
      //   204: invokevirtual 125	java/io/File:deleteOnExit	()V
      //   207: aconst_null
      //   208: areturn
      //   209: new 127	java/io/ObjectInputStream
      //   212: dup
      //   213: new 129	java/io/FileInputStream
      //   216: dup
      //   217: aload_1
      //   218: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   221: invokespecial 135	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   224: astore_2
      //   225: aload_2
      //   226: invokevirtual 138	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   229: astore_1
      //   230: aload_2
      //   231: invokestatic 144	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
      //   234: aload_1
      //   235: areturn
      //   236: astore_1
      //   237: aload_3
      //   238: astore_2
      //   239: aload_2
      //   240: invokestatic 144	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
      //   243: aload_1
      //   244: athrow
      //   245: astore_1
      //   246: goto -7 -> 239
      //   249: astore_2
      //   250: lload 8
      //   252: lstore 10
      //   254: aload_1
      //   255: astore_2
      //   256: goto -111 -> 145
      //   259: goto -120 -> 139
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	262	0	this	ObjectStore
      //   46	189	1	localObject1	Object
      //   236	8	1	localObject2	Object
      //   245	10	1	localObject3	Object
      //   66	174	2	localObject4	Object
      //   249	1	2	localException	Exception
      //   255	1	2	localObject5	Object
      //   1	237	3	localObject6	Object
      //   59	74	4	localFile	File
      //   24	31	5	arrayOfFile	File[]
      //   40	110	6	i	int
      //   37	15	7	j	int
      //   43	208	8	l1	long
      //   63	190	10	l2	long
      // Exception table:
      //   from	to	target	type
      //   209	225	236	finally
      //   225	230	245	finally
      //   102	124	249	java/lang/Exception
    }
    
    public void writeItem(T paramT)
    {
      if (Build.VERSION.SDK_INT < 9) {}
      while (CommonUtils.isApplicationDefaultProcess() != 1) {
        return;
      }
      localObject2 = KernelContext.context;
      localObject1 = null;
      try
      {
        localObject2 = ((Context)localObject2).getDir(this.dir, 0);
        long l = getApkLastUpdateTime();
        if (l == 0L)
        {
          AliSDKLogger.w("ObjectStore", "Fail to read the last apk update time, skip persistent data writing");
          IOUtils.closeQuietly(null);
          return;
        }
        localObject2 = new ObjectOutputStream(new FileOutputStream(new File((File)localObject2, l + this.fileExt)));
        IOUtils.closeQuietly((Closeable)localObject1);
      }
      finally
      {
        try
        {
          ((ObjectOutputStream)localObject2).writeObject(paramT);
          IOUtils.closeQuietly((Closeable)localObject2);
          return;
        }
        finally
        {
          localObject1 = localObject2;
        }
        paramT = finally;
      }
      throw paramT;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\PersistentUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */