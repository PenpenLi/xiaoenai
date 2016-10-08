package com.xiaoenai.app.classes.chat.input;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class h
  implements View.OnTouchListener
{
  h(InputFragment paramInputFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.j();
    this.a.i();
    InputFragment.a(this.a).setCursorVisible(true);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */