package com.xiaoenai.app.classes.forum.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.Section;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.net.m;

class am
  implements View.OnClickListener
{
  am(ForumTopicViewPresenter paramForumTopicViewPresenter, e parame, m paramm, Section paramSection) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    new g(this.b).d(ForumTopicViewPresenter.c(this.d).b, this.c.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */