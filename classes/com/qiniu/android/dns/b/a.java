package com.qiniu.android.dns.b;

import com.qiniu.android.dns.d;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a
{
  public static InetAddress[] a()
  {
    ArrayList localArrayList;
    try
    {
      LineNumberReader localLineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
      localArrayList = new ArrayList(5);
      for (;;)
      {
        String str = localLineNumberReader.readLine();
        if (str == null) {
          break;
        }
        int i = str.indexOf("]: [");
        if (i != -1)
        {
          Object localObject = str.substring(1, i);
          str = str.substring(i + 4, str.length() - 1);
          if ((((String)localObject).endsWith(".dns")) || (((String)localObject).endsWith(".dns1")) || (((String)localObject).endsWith(".dns2")) || (((String)localObject).endsWith(".dns3")) || (((String)localObject).endsWith(".dns4")))
          {
            localObject = InetAddress.getByName(str);
            if (localObject != null)
            {
              str = ((InetAddress)localObject).getHostAddress();
              if ((str != null) && (str.length() != 0)) {
                localArrayList.add(localObject);
              }
            }
          }
        }
      }
      while (localArrayList.size() <= 0) {}
    }
    catch (IOException localIOException)
    {
      Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByExec", localIOException);
      return null;
    }
    InetAddress[] arrayOfInetAddress = (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
    return arrayOfInetAddress;
  }
  
  public static InetAddress[] b()
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        Method localMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
        localArrayList = new ArrayList(5);
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "net.dns1";
        arrayOfString[1] = "net.dns2";
        arrayOfString[2] = "net.dns3";
        arrayOfString[3] = "net.dns4";
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          Object localObject = (String)localMethod.invoke(null, new Object[] { arrayOfString[i] });
          if ((localObject == null) || (((String)localObject).length() == 0)) {
            break label188;
          }
          localObject = InetAddress.getByName((String)localObject);
          if (localObject == null) {
            break label188;
          }
          String str = ((InetAddress)localObject).getHostAddress();
          if ((str == null) || (str.length() == 0) || (localArrayList.contains(localObject))) {
            break label188;
          }
          localArrayList.add(localObject);
        }
      }
      catch (Exception localException)
      {
        Logger.getLogger("AndroidDnsServer").log(Level.WARNING, "Exception in findDNSByReflection", localException);
        return null;
      }
      if (localArrayList.size() > 0)
      {
        InetAddress[] arrayOfInetAddress = (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
        return arrayOfInetAddress;
        label188:
        i += 1;
      }
    }
  }
  
  public static d c()
  {
    return new b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */