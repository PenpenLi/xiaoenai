package com.xiaoenai.app.classes.forum.presenter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;

class ai
  implements View.OnClickListener
{
  ai(ForumTopicViewPresenter paramForumTopicViewPresenter, e parame, m paramm, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (ForumTopicViewPresenter.b(this.d))
    {
      ForumTopicViewPresenter.a(this.d, this.b);
      return;
    }
    h.c(this.c, 2131100507, 2000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */