package com.xiaoenai.app.classes.chat.input;

import android.widget.Button;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.input.faces.r;

class b
  implements Runnable
{
  b(InputFragment paramInputFragment) {}
  
  public void run()
  {
    InputFragment.e(this.a).setTag("keyboard_tag");
    InputFragment.e(this.a).setBackgroundResource(2130838806);
    r.a(this.a, 2131558817, InputFragment.l(this.a));
    ((ChatActivity)this.a.getActivity()).v();
    InputFragment.a(this.a, true);
    this.a.i();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */