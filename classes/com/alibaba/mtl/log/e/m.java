package com.alibaba.mtl.log.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class m
{
  private static final Random a = new Random();
  
  public static String getImei(Context paramContext)
  {
    localObject4 = null;
    Object localObject1 = localObject4;
    if (paramContext != null) {}
    do
    {
      try
      {
        localObject1 = paramContext.getSharedPreferences("UTCommon", 0).getString("_ie", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new String(c.decode(((String)localObject1).getBytes(), 2), "UTF-8");
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool)
          {
            localObject4 = localObject1;
            return (String)localObject4;
          }
        }
      }
      catch (Exception localException1) {}
      try
      {
        localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
        if (localObject2 == null) {
          break label164;
        }
        localObject2 = ((TelephonyManager)localObject2).getDeviceId();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject3 = localObject4;
          continue;
          continue;
          localObject3 = null;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject2 = getUniqueID();
      localObject4 = localObject2;
    } while (paramContext == null);
    try
    {
      paramContext = paramContext.getSharedPreferences("UTCommon", 0).edit();
      paramContext.putString("_ie", new String(c.encode(((String)localObject2).getBytes("UTF-8"), 2)));
      paramContext.commit();
      return (String)localObject2;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramContext.printStackTrace();
      return (String)localObject2;
    }
  }
  
  public static String getImsi(Context paramContext)
  {
    localObject4 = null;
    Object localObject1 = localObject4;
    if (paramContext != null) {}
    do
    {
      try
      {
        localObject1 = paramContext.getSharedPreferences("UTCommon", 0).getString("_is", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new String(c.decode(((String)localObject1).getBytes(), 2), "UTF-8");
          boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool)
          {
            localObject4 = localObject1;
            return (String)localObject4;
          }
        }
      }
      catch (Exception localException1) {}
      try
      {
        localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
        if (localObject2 == null) {
          break label164;
        }
        localObject2 = ((TelephonyManager)localObject2).getSubscriberId();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject3 = localObject4;
          continue;
          continue;
          localObject3 = null;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject2 = getUniqueID();
      localObject4 = localObject2;
    } while (paramContext == null);
    try
    {
      paramContext = paramContext.getSharedPreferences("UTCommon", 0).edit();
      paramContext.putString("_is", new String(c.encode(((String)localObject2).getBytes("UTF-8"), 2)));
      paramContext.commit();
      return (String)localObject2;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      paramContext.printStackTrace();
      return (String)localObject2;
    }
  }
  
  public static final String getUniqueID()
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (int)System.nanoTime();
    int k = a.nextInt();
    int m = a.nextInt();
    byte[] arrayOfByte1 = f.getBytes(i);
    byte[] arrayOfByte2 = f.getBytes(j);
    byte[] arrayOfByte3 = f.getBytes(k);
    byte[] arrayOfByte4 = f.getBytes(m);
    byte[] arrayOfByte5 = new byte[16];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 4, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 8, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 12, 4);
    return c.encodeToString(arrayOfByte5, 2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */