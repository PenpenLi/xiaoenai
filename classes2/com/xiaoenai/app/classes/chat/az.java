package com.xiaoenai.app.classes.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.k;

class az
  implements View.OnClickListener
{
  az(av paramav, a parama, e parame) {}
  
  public void onClick(View paramView)
  {
    paramView = new g(av.a(this.c));
    paramView.a(2131100002);
    paramView.d(k.j);
    paramView.a(2131100104, new ba(this));
    paramView.b(2131099973, new bb(this));
    paramView.show();
    this.b.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */