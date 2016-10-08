package com.xiaoenai.app.classes.home.view;

import android.widget.TextView;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.utils.ak;

class t
  implements Runnable
{
  t(s params) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      long l1 = ak.b();
      long l2 = this.a.a.d();
      this.a.b.setText(ak.h(l1 - l2));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */