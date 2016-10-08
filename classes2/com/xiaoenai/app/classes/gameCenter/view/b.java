package com.xiaoenai.app.classes.gameCenter.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class b
  implements View.OnTouchListener
{
  b(HorizontalListView paramHorizontalListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return HorizontalListView.a(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\view\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */