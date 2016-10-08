package com.xiaoenai.app.classes.common.share;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class j
  implements View.OnClickListener
{
  j(ShareActivity paramShareActivity) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.b.getWindowToken(), 0);
    this.a.c(ShareActivity.a(this.a).l());
    this.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */