package com.xiaoenai.app.classes.extentions.todo;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class i
  implements Runnable
{
  i(h paramh) {}
  
  public void run()
  {
    h.a(this.a, (InputMethodManager)h.a(this.a).getContext().getSystemService("input_method"));
    h.b(this.a).showSoftInput(h.a(this.a), 1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */