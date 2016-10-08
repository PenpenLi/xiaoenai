package com.xiaoenai.app.utils;

import android.app.Activity;
import android.content.Intent;

public class ah
{
  private static int a;
  
  public static void a(Activity paramActivity, int paramInt)
  {
    a = paramInt;
    paramActivity.finish();
    paramActivity.startActivity(new Intent(paramActivity, paramActivity.getClass()));
    paramActivity.overridePendingTransition(2130968595, 2130968596);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    a = paramInt1;
    paramActivity.finish();
    Intent localIntent = new Intent(paramActivity, paramActivity.getClass());
    localIntent.putExtra(paramString, paramInt2);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968595, 2130968596);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */