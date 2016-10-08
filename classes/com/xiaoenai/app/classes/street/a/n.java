package com.xiaoenai.app.classes.street.a;

import android.support.v4.view.DirectionalViewPager.OnInterceptTouchListener;
import android.view.MotionEvent;
import com.xiaoenai.app.widget.PullToRefreshScrollViewEx;
import com.xiaoenai.app.widget.WebViewInsideViewPager;

class n
  implements DirectionalViewPager.OnInterceptTouchListener
{
  n(l paraml) {}
  
  public boolean onOnInterceptTouch(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (l.b(this.a) != 0) {
              break;
            }
          } while (l.c(this.a) == null);
          l.c(this.a).setOldY(paramMotionEvent.getY());
          return true;
        } while ((l.b(this.a) != 1) || (l.d(this.a) == null));
        l.d(this.a).setOldY(paramMotionEvent.getY());
        return true;
        if (l.b(this.a) == 0)
        {
          if (l.c(this.a) != null) {
            return l.c(this.a).a(paramMotionEvent);
          }
        }
        else if ((l.b(this.a) == 1) && (l.d(this.a) != null)) {
          return l.d(this.a).a(paramMotionEvent);
        }
        if (l.b(this.a) != 0) {
          break;
        }
      } while (l.c(this.a) == null);
      l.c(this.a).setOldY(0.0F);
      return true;
    } while ((l.b(this.a) != 1) || (l.d(this.a) == null));
    l.d(this.a).setOldY(0.0F);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */