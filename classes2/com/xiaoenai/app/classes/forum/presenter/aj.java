package com.xiaoenai.app.classes.forum.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.net.m;

class aj
  implements View.OnClickListener
{
  aj(ForumTopicViewPresenter paramForumTopicViewPresenter, e parame, m paramm) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    ForumTopicViewPresenter.a(this.c, this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */