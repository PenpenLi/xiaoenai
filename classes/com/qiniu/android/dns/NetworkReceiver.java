package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Locale;

public final class NetworkReceiver
  extends BroadcastReceiver
{
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  private static b b;
  
  public static g a(NetworkInfo paramNetworkInfo, Context paramContext)
  {
    if (paramNetworkInfo == null) {
      return g.a;
    }
    if (paramNetworkInfo.getType() == 1)
    {
      paramNetworkInfo = g.a.b;
      i = 0;
      return new g(paramNetworkInfo, i);
    }
    g.a locala = g.a.c;
    paramContext = paramContext.getContentResolver().query(a, null, null, null, null);
    if (paramContext != null)
    {
      paramContext.moveToFirst();
      String str = paramContext.getString(paramContext.getColumnIndex("user"));
      if ((TextUtils.isEmpty(str)) || ((!str.startsWith("ctwap")) && (!str.startsWith("ctnet")))) {}
    }
    for (int i = 1;; i = 0)
    {
      paramContext.close();
      if (i != 1)
      {
        paramNetworkInfo = paramNetworkInfo.getExtraInfo();
        if (paramNetworkInfo != null)
        {
          paramNetworkInfo = paramNetworkInfo.toLowerCase(Locale.getDefault());
          if ((paramNetworkInfo.equals("cmwap")) || (paramNetworkInfo.equals("cmnet")))
          {
            i = 3;
            paramNetworkInfo = locala;
            break;
          }
          if ((paramNetworkInfo.equals("3gnet")) || (paramNetworkInfo.equals("uninet")) || (paramNetworkInfo.equals("3gwap")) || (paramNetworkInfo.equals("uniwap")))
          {
            i = 2;
            paramNetworkInfo = locala;
            break;
          }
        }
      }
      paramNetworkInfo = locala;
      break;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (b == null) {
      return;
    }
    paramContext = a(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo(), paramContext);
    b.a(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\NetworkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */