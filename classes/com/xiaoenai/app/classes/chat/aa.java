package com.xiaoenai.app.classes.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aa
  implements View.OnTouchListener
{
  aa(ChatActivity paramChatActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.f();
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */