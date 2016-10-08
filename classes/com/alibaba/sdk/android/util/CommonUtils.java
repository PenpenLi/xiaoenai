package com.alibaba.sdk.android.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.callback.FailureCallback;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.task.InitWaitTask;
import java.io.EOFException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;

public class CommonUtils
{
  private static String CURRENT_PROCESS_NAME;
  private static String PREFIX = "\\u";
  
  private static String char2Ascii(char paramChar)
  {
    if (paramChar > 'ÿ')
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(PREFIX);
      String str = Integer.toHexString(paramChar >> '\b');
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      str = Integer.toHexString(paramChar & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return Character.toString(paramChar);
  }
  
  public static int dp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat);
  }
  
  public static String getAndroidManifestMetadata(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext.metaData == null) {
        return null;
      }
      paramContext = paramContext.metaData.get(paramString);
      if (paramContext != null)
      {
        paramContext = paramContext.toString();
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String getCurrentProcessName()
  {
    if (KernelContext.context == null) {
      return null;
    }
    if (CURRENT_PROCESS_NAME != null) {
      return CURRENT_PROCESS_NAME;
    }
    try
    {
      Object localObject = ((ActivityManager)KernelContext.context.getSystemService("activity")).getRunningAppProcesses();
      if (localObject == null) {
        return null;
      }
      int i = Process.myPid();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i)
        {
          CURRENT_PROCESS_NAME = localRunningAppProcessInfo.processName;
          localObject = localRunningAppProcessInfo.processName;
          return (String)localObject;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  /* Error */
  private static java.security.PublicKey getPublicKeyFromX509(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 156	java/security/spec/X509EncodedKeySpec
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 159	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   8: astore_0
    //   9: ldc -95
    //   11: invokestatic 167	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 171	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: astore_0
    //   24: new 173	java/lang/RuntimeException
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   32: athrow
    //   33: astore_0
    //   34: new 173	java/lang/RuntimeException
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramArrayOfByte	byte[]
    //   14	2	1	localKeyFactory	java.security.KeyFactory
    // Exception table:
    //   from	to	target	type
    //   9	15	23	java/security/NoSuchAlgorithmException
    //   15	21	33	java/security/spec/InvalidKeySpecException
  }
  
  public static int isApplicationDefaultProcess()
  {
    if (KernelContext.context == null) {}
    String str;
    do
    {
      return -1;
      str = getCurrentProcessName();
    } while (str == null);
    if (str.equals(KernelContext.context.getPackageName())) {
      return 1;
    }
    return 0;
  }
  
  public static boolean isConnectionTimeout(Throwable paramThrowable)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if (((paramThrowable instanceof SocketTimeoutException)) || ((paramThrowable instanceof EOFException)) || ((paramThrowable instanceof ConnectException)))
    {
      i = 1;
      if (i == 0) {
        break label38;
      }
      bool1 = true;
    }
    label38:
    do
    {
      do
      {
        return bool1;
        i = 0;
        break;
        paramThrowable = paramThrowable.getCause();
        bool1 = bool2;
      } while (paramThrowable == null);
      if (((paramThrowable instanceof SocketTimeoutException)) || ((paramThrowable instanceof EOFException))) {
        break label72;
      }
      bool1 = bool2;
    } while (!(paramThrowable instanceof ConnectException));
    label72:
    return true;
  }
  
  public static boolean isDebuggable()
  {
    if (ConfigManager.DEBUG) {}
    for (;;)
    {
      return true;
      try
      {
        int i = KernelContext.context.getPackageManager().getApplicationInfo(KernelContext.context.getPackageName(), 16384).flags;
        if ((i & 0x2) != 0) {
          continue;
        }
        return false;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        throw new RuntimeException(localNameNotFoundException);
      }
    }
  }
  
  public static boolean isEqual(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean isNetworkAvailable()
  {
    if (KernelContext.context == null) {
      return true;
    }
    return isNetworkAvailable(KernelContext.context);
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
    } while (paramContext == null);
    int j = paramContext.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramContext[i];
      if ((localObject == null) || ((((NetworkInfo)localObject).getState() != NetworkInfo.State.CONNECTED) && (((NetworkInfo)localObject).getState() != NetworkInfo.State.CONNECTING))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i += 1;
      break;
    }
  }
  
  public static String native2Ascii(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      localStringBuilder.append(char2Ascii(paramString.charAt(i)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void onFailure(FailureCallback paramFailureCallback, int paramInt, String paramString)
  {
    if (paramFailureCallback == null) {
      return;
    }
    KernelContext.executorService.postUITask(new CommonUtils.3(paramFailureCallback, paramInt, paramString));
  }
  
  public static void onFailure(FailureCallback paramFailureCallback, ResultCode paramResultCode)
  {
    if (paramFailureCallback == null) {
      return;
    }
    KernelContext.executorService.postUITask(new CommonUtils.2(paramFailureCallback, paramResultCode));
  }
  
  public static void onFailure(FailureCallback paramFailureCallback, Message paramMessage)
  {
    if (paramFailureCallback == null) {
      return;
    }
    KernelContext.executorService.postUITask(new CommonUtils.1(paramFailureCallback, paramMessage));
  }
  
  /* Error */
  public static byte[] rsaEncrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 277	com/alibaba/sdk/android/util/CommonUtils:getPublicKeyFromX509	([B)Ljava/security/PublicKey;
    //   4: astore_1
    //   5: ldc_w 279
    //   8: invokestatic 284	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   11: astore_3
    //   12: aload_3
    //   13: iconst_1
    //   14: aload_1
    //   15: invokevirtual 288	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   18: aload_3
    //   19: invokevirtual 291	javax/crypto/Cipher:getBlockSize	()I
    //   22: istore 6
    //   24: new 293	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 294	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore_2
    //   32: iconst_0
    //   33: istore 4
    //   35: aload_2
    //   36: astore_1
    //   37: iload 4
    //   39: aload_0
    //   40: arraylength
    //   41: if_icmpge +49 -> 90
    //   44: aload_2
    //   45: astore_1
    //   46: aload_0
    //   47: arraylength
    //   48: iload 4
    //   50: isub
    //   51: iload 6
    //   53: if_icmpge +81 -> 134
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: arraylength
    //   60: iload 4
    //   62: isub
    //   63: istore 5
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: aload_3
    //   69: aload_0
    //   70: iload 4
    //   72: iload 5
    //   74: invokevirtual 298	javax/crypto/Cipher:doFinal	([BII)[B
    //   77: invokevirtual 301	java/io/ByteArrayOutputStream:write	([B)V
    //   80: iload 4
    //   82: iload 6
    //   84: iadd
    //   85: istore 4
    //   87: goto -52 -> 35
    //   90: aload_2
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 305	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   96: astore_0
    //   97: aload_2
    //   98: invokestatic 311	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aload_0
    //   102: areturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_1
    //   106: new 173	java/lang/RuntimeException
    //   109: dup
    //   110: aload_0
    //   111: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   114: athrow
    //   115: astore_0
    //   116: aload_1
    //   117: invokestatic 311	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -9 -> 116
    //   128: astore_0
    //   129: aload_2
    //   130: astore_1
    //   131: goto -25 -> 106
    //   134: iload 6
    //   136: istore 5
    //   138: goto -73 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramArrayOfByte1	byte[]
    //   0	141	1	paramArrayOfByte2	byte[]
    //   31	99	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   11	58	3	localCipher	javax.crypto.Cipher
    //   33	53	4	i	int
    //   63	74	5	j	int
    //   22	113	6	k	int
    // Exception table:
    //   from	to	target	type
    //   0	32	103	java/lang/Exception
    //   37	44	115	finally
    //   46	56	115	finally
    //   58	65	115	finally
    //   67	80	115	finally
    //   92	97	115	finally
    //   106	115	115	finally
    //   0	32	122	finally
    //   37	44	128	java/lang/Exception
    //   46	56	128	java/lang/Exception
    //   58	65	128	java/lang/Exception
    //   67	80	128	java/lang/Exception
    //   92	97	128	java/lang/Exception
  }
  
  public static void startInitWaitTask(Activity paramActivity, FailureCallback paramFailureCallback, Runnable paramRunnable, String paramString)
  {
    new InitWaitTask(paramActivity, paramFailureCallback, paramRunnable, paramString).execute(new Void[0]);
  }
  
  public static String toString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static void toast(String paramString)
  {
    KernelContext.executorService.postUITask(new CommonUtils.4(paramString));
  }
  
  public static void toastSystemException()
  {
    toast("com_taobao_tae_sdk_system_exception");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */