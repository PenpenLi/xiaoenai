package com.xiaoenai.app.classes.forum;

import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import com.xiaoenai.app.ui.component.view.ProgressView;

public class bi<T extends ForumNotifyActivity>
  implements Unbinder
{
  protected T a;
  
  public bi(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mRecyclerview = ((RefreshCustomUltimateRecyclerview)paramFinder.findRequiredViewAsType(paramObject, 2131558668, "field 'mRecyclerview'", RefreshCustomUltimateRecyclerview.class));
    paramT.mProgessView = ((ProgressView)paramFinder.findRequiredViewAsType(paramObject, 2131558669, "field 'mProgessView'", ProgressView.class));
  }
  
  public void unbind()
  {
    ForumNotifyActivity localForumNotifyActivity = this.a;
    if (localForumNotifyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localForumNotifyActivity.mRecyclerview = null;
    localForumNotifyActivity.mProgessView = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */