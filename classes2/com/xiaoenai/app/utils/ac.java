package com.xiaoenai.app.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

final class ac
  implements Runnable
{
  ac(Context paramContext, View paramView) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.b, 2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */