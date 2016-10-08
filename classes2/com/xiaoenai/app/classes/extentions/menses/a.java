package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.l;

public class a
{
  private static String a = null;
  private static FragmentActivity b = null;
  
  public static void a(Context paramContext)
  {
    a(paramContext, true);
  }
  
  private static void a(Context paramContext, boolean paramBoolean)
  {
    if (User.isSingle())
    {
      ac.j();
      return;
    }
    ac.a();
    new com.xiaoenai.app.net.b(new b(paramContext, paramContext)).c();
    new l(new c(paramContext)).w();
  }
  
  public static void a(FragmentActivity paramFragmentActivity)
  {
    a(paramFragmentActivity, null);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, String paramString)
  {
    if (ac.l() != -1)
    {
      paramFragmentActivity.startActivity(b(paramFragmentActivity, paramString));
      paramFragmentActivity.overridePendingTransition(2130968604, 2130968605);
      return;
    }
    paramString = new Intent();
    paramString.setClass(paramFragmentActivity, MensesEditSexActivity.class);
    paramFragmentActivity.startActivity(paramString);
    paramFragmentActivity.overridePendingTransition(2130968604, 2130968605);
  }
  
  public static Intent b(FragmentActivity paramFragmentActivity, String paramString)
  {
    a = paramString;
    b = paramFragmentActivity;
    Intent localIntent = new Intent();
    if ((0L != ac.b()) || (0L != ac.f()))
    {
      if (paramString != null) {
        localIntent.putExtra("back", paramString);
      }
      localIntent.setClass(paramFragmentActivity, MensesActivity.class);
      return localIntent;
    }
    if (ac.l() == 1)
    {
      localIntent.setClass(paramFragmentActivity, MensesActivity.class);
      return localIntent;
    }
    a(paramFragmentActivity.getApplicationContext(), false);
    localIntent.setClass(paramFragmentActivity, MensesSettingActivity.class);
    return localIntent;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */