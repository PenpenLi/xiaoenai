package com.xiaoenai.app.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.f.a.b;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.service.DownloadService;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.k;
import java.util.Date;
import org.cocos2dx.cpp.GameBaseActivity;

public class an
{
  public static int a()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static void a(Context paramContext)
  {
    String str1;
    if (v.a(paramContext))
    {
      str1 = String.format("%tj", new Object[] { new Date() });
      String str2 = AppSettings.getString("last_check_update", "0");
      String str3 = AppSettings.getString("last_cancel_update", "0");
      if (Integer.parseInt(str1) > Integer.parseInt(str2))
      {
        if (str3.equals("0")) {
          break label88;
        }
        if (Integer.parseInt(str1) - Integer.parseInt(str3) >= 7)
        {
          b(paramContext);
          AppSettings.setString("last_check_update", str1);
        }
      }
    }
    return;
    label88:
    b(paramContext);
    AppSettings.setString("last_check_update", str1);
  }
  
  public static void a(GameBaseActivity paramGameBaseActivity)
  {
    new l(new ap(paramGameBaseActivity)).j();
  }
  
  private static void b(Context paramContext)
  {
    new l(new ao(paramContext)).j();
  }
  
  private static void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaoenai.service.DOWNLOAD");
    localIntent.setClass(paramContext, DownloadService.class);
    localIntent.putExtra("url", paramString);
    paramContext.getApplicationContext().startService(localIntent);
    b.b(Xiaoenai.j(), "UpdateApp");
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    g localg = new g(paramContext);
    localg.a(paramString1);
    localg.d(k.i);
    localg.a(2131099696, new aq(paramContext, paramString2));
    localg.b(2131099694, new ar());
    localg.show();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */