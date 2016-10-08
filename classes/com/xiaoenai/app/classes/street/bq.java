package com.xiaoenai.app.classes.street;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bq
  implements View.OnTouchListener
{
  bq(StreetFeedbackActivity paramStreetFeedbackActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.i();
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */