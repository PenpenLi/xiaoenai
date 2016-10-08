package com.xiaoenai.app.classes.extentions.anniversary;

import android.app.Activity;
import android.content.Intent;
import com.xiaoenai.app.utils.c.c;

public class a
{
  public static void a(Activity paramActivity)
  {
    c.a();
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, AnniversaryActivity.class);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */