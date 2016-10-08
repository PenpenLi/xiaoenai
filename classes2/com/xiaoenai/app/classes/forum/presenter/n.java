package com.xiaoenai.app.classes.forum.presenter;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class n
  implements View.OnTouchListener
{
  n(h paramh) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      h.b(this.a, true);
    }
    do
    {
      do
      {
        return true;
      } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
      h.b(this.a, false);
    } while (paramMotionEvent.getAction() != 1);
    paramView.performClick();
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */