package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.chat.messagelist.view.n;
import com.xiaoenai.app.utils.as;

final class e
  implements View.OnClickListener
{
  e(n paramn, com.xiaoenai.app.classes.chat.messagelist.message.model.d paramd) {}
  
  public void onClick(View paramView)
  {
    if ((as.g(this.a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) || (as.g(this.a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")))
    {
      this.a.getMessageBody().setClickable(false);
      this.b.c(true);
      d.b(this.b, this.a);
      d.c(this.b, this.a);
      return;
    }
    d.b(this.a.getContext());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */