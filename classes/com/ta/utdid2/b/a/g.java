package com.ta.utdid2.b.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

public class g
{
  public static String a(Context paramContext)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (paramContext != null) {}
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label50;
      }
      paramContext = paramContext.getDeviceId();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
        continue;
        paramContext = null;
      }
    }
    localObject1 = paramContext;
    paramContext = (Context)localObject1;
    if (i.a((String)localObject1)) {
      paramContext = c();
    }
    return paramContext;
  }
  
  public static String b(Context paramContext)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (paramContext != null) {}
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label50;
      }
      paramContext = paramContext.getSubscriberId();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
        continue;
        paramContext = null;
      }
    }
    localObject1 = paramContext;
    paramContext = (Context)localObject1;
    if (i.a((String)localObject1)) {
      paramContext = c();
    }
    return paramContext;
  }
  
  public static final String c()
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (int)System.nanoTime();
    int k = new Random().nextInt();
    int m = new Random().nextInt();
    byte[] arrayOfByte1 = e.getBytes(i);
    byte[] arrayOfByte2 = e.getBytes(j);
    byte[] arrayOfByte3 = e.getBytes(k);
    byte[] arrayOfByte4 = e.getBytes(m);
    byte[] arrayOfByte5 = new byte[16];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 4, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 8, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 12, 4);
    return b.encodeToString(arrayOfByte5, 2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\b\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */