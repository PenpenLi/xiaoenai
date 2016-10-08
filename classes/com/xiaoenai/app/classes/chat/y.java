package com.xiaoenai.app.classes.chat;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.AutoHeightLayout;

class y
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  y(ChatActivity paramChatActivity) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.a.a.getWindowVisibleDisplayFrame(localRect);
    int i = this.a.a.getRootView().getHeight() - (localRect.bottom - localRect.top);
    if (i > 100) {
      if (!ChatActivity.a(this.a)) {
        this.a.q();
      }
    }
    for (;;)
    {
      a.c("Keyboard Size : {}", new Object[] { Integer.valueOf(i) });
      return;
      ChatActivity.a(this.a, false);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */