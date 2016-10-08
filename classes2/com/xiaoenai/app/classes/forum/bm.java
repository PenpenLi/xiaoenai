package com.xiaoenai.app.classes.forum;

import com.xiaoenai.app.classes.forum.presenter.h;

class bm
  implements Runnable
{
  bm(bl parambl) {}
  
  public void run()
  {
    ForumPostActivity.b(this.a.a, ForumPostActivity.e(this.a.a));
    ForumPostActivity.b(this.a.a, ForumPostActivity.f(this.a.a));
    ForumPostActivity.a(this.a.a).b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */