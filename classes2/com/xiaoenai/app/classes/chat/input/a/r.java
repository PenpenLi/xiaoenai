package com.xiaoenai.app.classes.chat.input.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.common.dialog.e;

class r
  implements View.OnClickListener
{
  r(i parami) {}
  
  public void onClick(View paramView)
  {
    i.g(this.a).dismiss();
    if (i.a(this.a))
    {
      i.a(this.a, false);
      i.h(this.a);
    }
    i.e(this.a).s();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */