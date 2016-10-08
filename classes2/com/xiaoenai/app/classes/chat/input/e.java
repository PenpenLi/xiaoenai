package com.xiaoenai.app.classes.chat.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.classes.chat.ChatActivity;

class e
  implements View.OnClickListener
{
  e(InputFragment paramInputFragment) {}
  
  public void onClick(View paramView)
  {
    ((ChatActivity)this.a.getActivity()).q();
    if (InputFragment.e(this.a).getTag().equals("faces_tag"))
    {
      this.a.b(0);
      InputFragment.c(this.a);
      InputFragment.d(this.a);
      this.a.h();
      return;
    }
    this.a.j();
    this.a.g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */