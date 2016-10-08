package com.xiaoenai.app.widget;

import android.os.Handler;
import android.os.Message;
import android.view.View;

class k
  extends Handler
{
  k(LazyScrollView paramLazyScrollView) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (LazyScrollView.a(this.a).getMeasuredHeight() > this.a.getScrollY() + this.a.getHeight() + 40) {
            break;
          }
        } while (LazyScrollView.b(this.a) == null);
        LazyScrollView.b(this.a).a();
        return;
        if (this.a.getScrollY() != 0) {
          break;
        }
      } while (LazyScrollView.b(this.a) == null);
      LazyScrollView.b(this.a).b();
      return;
    } while (LazyScrollView.b(this.a) == null);
    LazyScrollView.b(this.a).c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */