package com.xiaoenai.app.classes.extentions.todo;

import android.app.Activity;
import android.content.Intent;

public class q
{
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, TodoActivity.class);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */