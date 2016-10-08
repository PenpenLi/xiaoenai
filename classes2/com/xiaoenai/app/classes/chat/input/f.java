package com.xiaoenai.app.classes.chat.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.as;

class f
  implements View.OnClickListener
{
  f(InputFragment paramInputFragment) {}
  
  public void onClick(View paramView)
  {
    if (InputFragment.f(this.a).getTag().equals("voice_TAG"))
    {
      if (!as.c())
      {
        h.c(this.a.getActivity(), 2131101067, 1500L);
        return;
      }
      this.a.i();
      this.a.j();
      InputFragment.g(this.a);
      InputFragment.h(this.a);
      this.a.q();
      this.a.h();
      return;
    }
    InputFragment.d(this.a);
    this.a.g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */