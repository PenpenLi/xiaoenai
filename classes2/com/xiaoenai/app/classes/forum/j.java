package com.xiaoenai.app.classes.forum;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class j<T extends ForumActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public j(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131559227, "method 'doNewPostAction'");
    this.b = localView;
    localView.setOnClickListener(new k(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131559228, "method 'goMessage'");
    this.c = localView;
    localView.setOnClickListener(new l(this, paramT));
    paramFinder = paramFinder.findRequiredView(paramObject, 2131559230, "method 'forumSetting'");
    this.d = paramFinder;
    paramFinder.setOnClickListener(new m(this, paramT));
  }
  
  public void unbind()
  {
    if (this.a == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */