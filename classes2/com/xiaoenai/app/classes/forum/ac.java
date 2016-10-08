package com.xiaoenai.app.classes.forum;

import android.widget.TextView;
import com.xiaoenai.app.classes.common.dialog.v;
import com.xiaoenai.app.model.Forum.f;

class ac
  implements Runnable
{
  ac(aa paramaa) {}
  
  public void run()
  {
    this.a.d.l_();
    if (this.a.a)
    {
      ForumMineInfoActivity.c().e = this.a.b;
      ForumMineInfoActivity.j(this.a.d).setText(ForumMineInfoActivity.i(this.a.d)[this.a.b]);
      ForumMineInfoActivity.d(this.a.d).dismiss();
    }
    for (;;)
    {
      f.a(ForumMineInfoActivity.c());
      return;
      ForumMineInfoActivity.c().b = this.a.c;
      ForumMineInfoActivity.k(this.a.d).setText(this.a.c);
      ForumMineInfoActivity.h(this.a.d);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */