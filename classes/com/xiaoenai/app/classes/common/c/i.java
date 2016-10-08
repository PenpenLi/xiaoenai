package com.xiaoenai.app.classes.common.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaoenai.app.utils.ae;
import org.json.JSONObject;

public class i
  implements d
{
  private static void a(Activity paramActivity, g paramg)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    try
    {
      localIntent.setData(Uri.parse(new JSONObject(paramg.e()).optString("url")));
      paramActivity.startActivity(localIntent);
      if (paramg.c())
      {
        paramActivity.finish();
        paramActivity.overridePendingTransition(2130968595, 2130968596);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(Context paramContext, g paramg)
  {
    if (((paramg.a() == null) || (paramg.a().equalsIgnoreCase("xiaoenai.event.browser"))) && (!ae.a(paramg.e()))) {
      a((Activity)paramContext, paramg);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */