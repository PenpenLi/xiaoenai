package com.xiaoenai.app.classes.extentions.anniversary;

import android.view.inputmethod.InputMethodManager;

class f
  implements Runnable
{
  f(AnniversaryAddActivity paramAnniversaryAddActivity) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(AnniversaryAddActivity.a(this.a), 2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */