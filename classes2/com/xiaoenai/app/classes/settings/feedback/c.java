package com.xiaoenai.app.classes.settings.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.g;

class c
  implements View.OnClickListener
{
  c(a parama, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama1, com.xiaoenai.app.classes.common.dialog.e parame) {}
  
  public void onClick(View paramView)
  {
    paramView = new g(a.a(this.c));
    paramView.a(2131100002);
    paramView.a(2131100104, new d(this));
    paramView.b(2131099973, new e(this));
    paramView.show();
    this.b.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */