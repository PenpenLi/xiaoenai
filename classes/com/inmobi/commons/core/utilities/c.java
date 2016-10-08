package com.inmobi.commons.core.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.inmobi.commons.a.a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  private static final String a = c.class.getSimpleName();
  
  public static String a(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramString;
    if (paramMap != null)
    {
      localObject = paramString;
      if (paramMap.size() > 0)
      {
        paramMap = paramMap.entrySet().iterator();
        for (;;)
        {
          localObject = paramString;
          if (!paramMap.hasNext()) {
            break;
          }
          localObject = (Map.Entry)paramMap.next();
          paramString = paramString.replace((CharSequence)((Map.Entry)localObject).getKey(), (CharSequence)((Map.Entry)localObject).getValue());
        }
      }
    }
    return (String)localObject;
  }
  
  public static String a(Map<String, ? extends Object> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append(String.format(Locale.US, "%s=%s", new Object[] { a(str), a(paramMap.get(str).toString()) }));
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to close closable", paramCloseable);
    }
  }
  
  public static void a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      HashMap localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getValue() == null) || (((String)localEntry.getValue()).trim().length() == 0) || (localEntry.getKey() == null) || (((String)localEntry.getKey()).trim().length() == 0))
        {
          localIterator.remove();
        }
        else if (!((String)localEntry.getKey()).equals(((String)localEntry.getKey()).trim()))
        {
          localIterator.remove();
          localHashMap.put(((String)localEntry.getKey()).trim(), ((String)localEntry.getValue()).trim());
        }
        else
        {
          localHashMap.put(localEntry.getKey(), ((String)localEntry.getValue()).trim());
        }
      }
      paramMap.putAll(localHashMap);
    }
  }
  
  public static boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)a.b().getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected()) && (!b());
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream = localByteArrayOutputStream.toByteArray();
    }
    finally
    {
      localByteArrayOutputStream.close();
    }
    localByteArrayOutputStream.close();
    return paramInputStream;
  }
  
  /* Error */
  public static byte[] a(@android.support.annotation.NonNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 212	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 215	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_3
    //   9: new 217	java/util/zip/GZIPInputStream
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 220	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokestatic 222	com/inmobi/commons/core/utilities/c:a	(Ljava/io/InputStream;)[B
    //   24: astore_2
    //   25: aload_3
    //   26: invokestatic 224	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   29: aload_1
    //   30: invokestatic 224	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: getstatic 132	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   43: getstatic 16	com/inmobi/commons/core/utilities/c:a	Ljava/lang/String;
    //   46: ldc -30
    //   48: aload_2
    //   49: invokestatic 139	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   52: aload_3
    //   53: invokestatic 224	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   56: aload_1
    //   57: invokestatic 224	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_0
    //   66: astore_1
    //   67: aload_3
    //   68: invokestatic 224	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   71: aload_2
    //   72: invokestatic 224	com/inmobi/commons/core/utilities/c:a	(Ljava/io/Closeable;)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: astore_2
    //   80: goto -13 -> 67
    //   83: astore_2
    //   84: goto -46 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramArrayOfByte	byte[]
    //   17	59	1	localObject1	Object
    //   77	1	1	localObject2	Object
    //   24	10	2	arrayOfByte	byte[]
    //   35	14	2	localIOException1	IOException
    //   64	16	2	localObject3	Object
    //   83	1	2	localIOException2	IOException
    //   8	60	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   9	18	35	java/io/IOException
    //   9	18	62	finally
    //   20	25	77	finally
    //   40	52	77	finally
    //   20	25	83	java/io/IOException
  }
  
  private static boolean b()
  {
    PowerManager localPowerManager = (PowerManager)a.b().getSystemService("power");
    if (Build.VERSION.SDK_INT > 22) {
      return localPowerManager.isDeviceIdleMode();
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */