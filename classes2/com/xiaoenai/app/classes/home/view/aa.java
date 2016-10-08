package com.xiaoenai.app.classes.home.view;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.xiaoenai.app.utils.ab;

class aa
  implements View.OnTouchListener
{
  aa(LoverSearchView paramLoverSearchView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      paramView = this.a.getContext();
      if ((paramView instanceof Activity)) {
        ab.b((Activity)paramView);
      }
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */