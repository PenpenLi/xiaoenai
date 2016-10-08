package com.inmobi.commons.core.utilities.uid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

public class ImIdShareBroadCastReceiver
  extends BroadcastReceiver
{
  private static final String a = ImIdShareBroadCastReceiver.class.getSimpleName();
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      paramString2 = null;
    }
    do
    {
      return paramString2;
      if ((paramString1 != null) && (paramString2 != null)) {
        break;
      }
    } while (paramString1 == null);
    return paramString1;
    String[] arrayOfString = paramString1.split(",");
    int i = 0;
    for (paramString1 = paramString2;; paramString1 = paramString2)
    {
      paramString2 = paramString1;
      if (i >= arrayOfString.length) {
        break;
      }
      paramString2 = paramString1;
      if (!paramString1.contains(arrayOfString[i])) {
        paramString2 = paramString1 + "," + arrayOfString[i];
      }
      i += 1;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.inmobi.share.id"))
    {
      b localb = new b(paramContext);
      String str4 = paramIntent.getExtras().getString("appid");
      String str1 = localb.d();
      String str5 = paramIntent.getExtras().getString("imid");
      String str2 = localb.f();
      String str3 = paramIntent.getExtras().getString("appendedid");
      long l1 = localb.e();
      long l2 = paramIntent.getExtras().getLong("imidts");
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Received broadcast for IDs. Received ID:" + str5 + " AppID:" + str4 + " AID:" + str3);
      if ((str2 != null) && (str4 != null))
      {
        if (!str2.contains(str4))
        {
          if (l2 < l1) {
            localb.c(str5);
          }
          paramIntent = new Intent();
          paramIntent.setAction("com.inmobi.share.id");
          paramIntent.putExtra("imid", str1);
          paramIntent.putExtra("appendedid", str2);
          paramIntent.putExtra("imidts", l1);
          paramIntent.putExtra("appid", c.a().c());
          paramContext.sendBroadcast(paramIntent);
        }
        localb.d(a(str3, str2));
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\uid\ImIdShareBroadCastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */