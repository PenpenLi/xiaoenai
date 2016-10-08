package com.inmobi.rendering;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class InMobiAdActivity$1
  implements View.OnTouchListener
{
  InMobiAdActivity$1(InMobiAdActivity paramInMobiAdActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView.setBackgroundColor(-7829368);
      InMobiAdActivity.a(this.a, true);
      this.a.finish();
    }
    while (paramMotionEvent.getAction() != 0) {
      return true;
    }
    paramView.setBackgroundColor(-16711681);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\InMobiAdActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */