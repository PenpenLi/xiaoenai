package com.xiaoenai.app.classes.chat.input.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.as;

class f
  implements View.OnClickListener
{
  f(a parama) {}
  
  public void onClick(View paramView)
  {
    if (a.a(this.a) != null)
    {
      if ((!as.g(a.a(this.a), "android.permission.ACCESS_FINE_LOCATION")) && (!as.g(a.a(this.a), "android.permission.ACCESS_COARSE_LOCATION"))) {
        break label51;
      }
      a.a(this.a).o();
    }
    label51:
    do
    {
      return;
      paramView = ConfigCenter.getHelpPage();
    } while (ae.a(paramView));
    k localk = new k(this.a.getContext());
    localk.d(k.i);
    localk.a(2131100127, 2131100054, new g(this), 2131099685, new h(this, paramView));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */