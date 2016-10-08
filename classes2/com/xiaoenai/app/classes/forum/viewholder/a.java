package com.xiaoenai.app.classes.forum.viewholder;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class a<T extends ForumMomentViewHolder>
  implements Unbinder
{
  protected T a;
  
  public a(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559250, "field 'mImg'", ImageView.class));
    paramT.mIngFlag = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559251, "field 'mIngFlag'", TextView.class));
    paramT.mTitle = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559252, "field 'mTitle'", TextView.class));
    paramT.mTime = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559253, "field 'mTime'", TextView.class));
  }
  
  public void unbind()
  {
    ForumMomentViewHolder localForumMomentViewHolder = this.a;
    if (localForumMomentViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localForumMomentViewHolder.mImg = null;
    localForumMomentViewHolder.mIngFlag = null;
    localForumMomentViewHolder.mTitle = null;
    localForumMomentViewHolder.mTime = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\viewholder\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */