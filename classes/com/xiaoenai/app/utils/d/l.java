package com.xiaoenai.app.utils.d;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class l
{
  private static int a = -1;
  
  public static int a(Context paramContext)
  {
    if (a < 0) {
      a = t.a(paramContext, 300.0F);
    }
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("DEFAULT_KEYBOARD_HEIGHT", 0);
    if ((i > 0) && (a != i)) {}
    for (;;)
    {
      a = i;
      return i;
      i = a;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (a != paramInt)
    {
      PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt("DEFAULT_KEYBOARD_HEIGHT", paramInt).apply();
      a = paramInt;
    }
  }
  
  public static void a(View paramView)
  {
    if ((paramView == null) || (paramView.getWindowToken() == null)) {
      return;
    }
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static void b(Context paramContext)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity)) || (((Activity)paramContext).getCurrentFocus() == null)) {
      return;
    }
    try
    {
      paramContext = ((Activity)paramContext).getCurrentFocus();
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getContext().getSystemService("input_method");
      paramContext.clearFocus();
      localInputMethodManager.hideSoftInputFromWindow(paramContext.getWindowToken(), 0);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */