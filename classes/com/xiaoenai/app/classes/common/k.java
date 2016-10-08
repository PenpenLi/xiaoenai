package com.xiaoenai.app.classes.common;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;

class k
  implements View.OnTouchListener
{
  k(DebugActivity paramDebugActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.mScrollView.requestDisallowInterceptTouchEvent(false);
      return false;
    }
    this.a.mScrollView.requestDisallowInterceptTouchEvent(true);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */