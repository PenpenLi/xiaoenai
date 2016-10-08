package com.xiaoenai.app.widget;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class l
  implements View.OnTouchListener
{
  l(LazyScrollView paramLazyScrollView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if ((LazyScrollView.a(this.a) != null) && (LazyScrollView.b(this.a) != null)) {
        LazyScrollView.c(this.a).sendMessageDelayed(LazyScrollView.c(this.a).obtainMessage(1), 200L);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */