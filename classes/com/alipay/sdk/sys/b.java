package com.alipay.sdk.sys;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.d;
import com.ta.utdid2.device.UTDevice;
import java.io.File;
import java.util.Random;

public final class b
{
  private static b c;
  public Context a;
  public d b;
  
  public static b a()
  {
    if (c == null) {
      c = new b();
    }
    return c;
  }
  
  /* Error */
  private static String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 24	java/lang/ProcessBuilder
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 27	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iconst_0
    //   11: invokevirtual 31	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 35	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   19: astore_0
    //   20: new 37	java/io/DataOutputStream
    //   23: dup
    //   24: aload_0
    //   25: invokevirtual 43	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 46	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: new 48	java/io/DataInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokevirtual 52	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 55	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: invokevirtual 59	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_2
    //   48: ldc 61
    //   50: invokevirtual 65	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   53: aload_2
    //   54: invokevirtual 68	java/io/DataOutputStream:flush	()V
    //   57: aload_0
    //   58: invokevirtual 72	java/lang/Process:waitFor	()I
    //   61: pop
    //   62: aload_0
    //   63: invokevirtual 75	java/lang/Process:destroy	()V
    //   66: aload_1
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: ldc 77
    //   73: astore_1
    //   74: aload_0
    //   75: invokevirtual 75	java/lang/Process:destroy	()V
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 75	java/lang/Process:destroy	()V
    //   90: aload_1
    //   91: athrow
    //   92: astore_0
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: goto -6 -> 90
    //   99: astore_1
    //   100: goto -14 -> 86
    //   103: astore_1
    //   104: ldc 77
    //   106: astore_1
    //   107: goto -33 -> 74
    //   110: astore_2
    //   111: goto -37 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramArrayOfString	String[]
    //   46	36	1	str1	String
    //   83	11	1	str2	String
    //   99	1	1	localObject	Object
    //   103	1	1	localException1	Exception
    //   106	1	1	str3	String
    //   31	23	2	localDataOutputStream	java.io.DataOutputStream
    //   110	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	20	68	java/lang/Exception
    //   74	78	80	java/lang/Exception
    //   0	20	83	finally
    //   62	66	92	java/lang/Exception
    //   86	90	95	java/lang/Exception
    //   20	47	99	finally
    //   47	62	99	finally
    //   20	47	103	java/lang/Exception
    //   47	62	110	java/lang/Exception
  }
  
  public static boolean b()
  {
    boolean bool = true;
    Object localObject = new String[5];
    localObject[0] = "/system/xbin/";
    localObject[1] = "/system/bin/";
    localObject[2] = "/system/sbin/";
    localObject[3] = "/sbin/";
    localObject[4] = "/vendor/bin/";
    int i = 0;
    try
    {
      while (i < localObject.length)
      {
        String str = localObject[i] + "su";
        if (new File(str).exists())
        {
          localObject = a(new String[] { "ls", "-l", str });
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            i = ((String)localObject).indexOf("root");
            int j = ((String)localObject).lastIndexOf("root");
            if (i != j) {}
          }
          else
          {
            bool = false;
          }
          return bool;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  private Context c()
  {
    return this.a;
  }
  
  private d d()
  {
    return this.b;
  }
  
  private static String e()
  {
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < 24)
    {
      switch (localRandom.nextInt(3))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 65.0D)));
        continue;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(Math.random() * 25.0D + 97.0D)));
        continue;
        localStringBuilder.append(String.valueOf(new Random().nextInt(10)));
      }
    }
    return localStringBuilder.toString();
  }
  
  private String f()
  {
    return UTDevice.getUtdid(this.a);
  }
  
  public final void a(Context paramContext, d paramd)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramd;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\sys\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */