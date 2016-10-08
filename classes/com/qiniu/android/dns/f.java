package com.qiniu.android.dns;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class f
{
  private static String a = "";
  
  public static String a()
  {
    try
    {
      DatagramSocket localDatagramSocket = new DatagramSocket();
      localDatagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
      InetAddress localInetAddress = localDatagramSocket.getLocalAddress();
      localDatagramSocket.close();
      return localInetAddress.getHostAddress();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 50	com/qiniu/android/dns/f:a	()Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: getstatic 12	com/qiniu/android/dns/f:a	Ljava/lang/String;
    //   11: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq +10 -> 26
    //   19: iconst_0
    //   20: istore_1
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: putstatic 12	com/qiniu/android/dns/f:a	Ljava/lang/String;
    //   30: iconst_1
    //   31: istore_1
    //   32: goto -11 -> 21
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	21	0	str	String
    //   35	5	0	localObject	Object
    //   14	18	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	15	35	finally
    //   26	30	35	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */