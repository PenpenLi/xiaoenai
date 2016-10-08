package com.baidu.location;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import java.util.List;
import org.apache.http.HttpEntity;

abstract class s
  implements ax, n
{
  private static int cU = 4;
  private static String cX = "10.0.0.172";
  protected static int cY = 0;
  private static int cZ = 80;
  public int c0 = 3;
  public String cR = null;
  public HttpEntity cS = null;
  public List cT = null;
  private boolean cV = false;
  public String cW = null;
  
  private void L()
  {
    cU = P();
  }
  
  private int P()
  {
    Context localContext = f.getServiceContext();
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)localContext.getSystemService("connectivity");
        if (localObject1 == null) {
          return 4;
        }
        NetworkInfo localNetworkInfo2 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localNetworkInfo2 != null) {}
        Cursor localCursor;
        NetworkInfo localNetworkInfo1;
        int i;
        return 4;
      }
      catch (SecurityException localSecurityException1)
      {
        try
        {
          if (!localNetworkInfo2.isAvailable()) {
            break label272;
          }
          if (localNetworkInfo2.getType() == 1) {
            return 3;
          }
          localObject1 = Uri.parse("content://telephony/carriers/preferapn");
          localCursor = localContext.getContentResolver().query((Uri)localObject1, null, null, null, null);
          if ((localCursor != null) && (localCursor.moveToFirst()))
          {
            localObject1 = localCursor.getString(localCursor.getColumnIndex("apn"));
            if ((localObject1 != null) && (((String)localObject1).toLowerCase().contains("ctwap")))
            {
              localObject1 = Proxy.getDefaultHost();
              if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null"))) {
                break label276;
              }
              cX = (String)localObject1;
              cZ = 80;
              if (localCursor == null) {
                break label274;
              }
              localCursor.close();
              break label274;
            }
            if ((localObject1 != null) && (((String)localObject1).toLowerCase().contains("wap")))
            {
              localObject1 = Proxy.getDefaultHost();
              if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null"))) {
                break label284;
              }
              cX = (String)localObject1;
              cZ = 80;
              if (localCursor == null) {
                break label282;
              }
              localCursor.close();
              break label282;
            }
          }
          if (localCursor != null) {
            localCursor.close();
          }
          return 2;
        }
        catch (SecurityException localSecurityException2)
        {
          localObject2 = localNetworkInfo2;
          continue;
        }
        localSecurityException1 = localSecurityException1;
        localNetworkInfo1 = null;
        try
        {
          i = jdMethod_if(localContext, localNetworkInfo1);
          return i;
        }
        catch (Exception localException1)
        {
          return 4;
        }
      }
      catch (Exception localException2)
      {
        return 4;
      }
      label272:
      label274:
      return 1;
      label276:
      Object localObject2 = "10.0.0.200";
      continue;
      label282:
      return 1;
      label284:
      localObject2 = "10.0.0.172";
    }
  }
  
  private static int jdMethod_if(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    int j = 2;
    int i;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.getExtraInfo() != null))
    {
      paramContext = paramNetworkInfo.getExtraInfo().toLowerCase();
      if (paramContext != null) {
        if ((paramContext.startsWith("cmwap")) || (paramContext.startsWith("uniwap")) || (paramContext.startsWith("3gwap")))
        {
          paramContext = Proxy.getDefaultHost();
          if ((paramContext != null) && (!paramContext.equals("")) && (!paramContext.equals("null")))
          {
            cX = paramContext;
            i = 1;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return i;
                  paramContext = "10.0.0.172";
                  break;
                  if (paramContext.startsWith("ctwap"))
                  {
                    paramContext = Proxy.getDefaultHost();
                    if ((paramContext != null) && (!paramContext.equals("")) && (!paramContext.equals("null"))) {}
                    for (;;)
                    {
                      cX = paramContext;
                      return 1;
                      paramContext = "10.0.0.200";
                    }
                  }
                  i = j;
                } while (paramContext.startsWith("cmnet"));
                i = j;
              } while (paramContext.startsWith("uninet"));
              i = j;
            } while (paramContext.startsWith("ctnet"));
            i = j;
          } while (paramContext.startsWith("3gnet"));
          paramContext = Proxy.getDefaultHost();
          i = j;
        } while (paramContext == null);
        i = j;
      } while (paramContext.length() <= 0);
      if ("10.0.0.172".equals(paramContext.trim()))
      {
        cX = "10.0.0.172";
        return 1;
      }
      i = j;
    } while (!"10.0.0.200".equals(paramContext.trim()));
    cX = "10.0.0.200";
    return 1;
  }
  
  public static boolean jdMethod_if(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext.getActiveNetworkInfo() != null)
      {
        boolean bool = paramContext.getActiveNetworkInfo().isAvailable();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return false;
  }
  
  public void N()
  {
    new s.2(this).start();
  }
  
  public void Q()
  {
    new s.1(this).start();
  }
  
  public void R()
  {
    new s.3(this).start();
  }
  
  abstract void T();
  
  abstract void jdMethod_do(boolean paramBoolean);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */