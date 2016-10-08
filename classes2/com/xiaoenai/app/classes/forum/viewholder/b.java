package com.xiaoenai.app.classes.forum.viewholder;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class b<T extends ForumNotifyViewHolder>
  implements Unbinder
{
  protected T a;
  
  public b(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mIconImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559255, "field 'mIconImg'", ImageView.class));
    paramT.mNickNameTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559256, "field 'mNickNameTxt'", TextView.class));
    paramT.mCreatedTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559260, "field 'mCreatedTxt'", TextView.class));
    paramT.mTitle = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559257, "field 'mTitle'", TextView.class));
    paramT.mPostContent = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559258, "field 'mPostContent'", TextView.class));
    paramT.mReplyPostContent = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559259, "field 'mReplyPostContent'", TextView.class));
    paramT.mTopDivider = paramFinder.findRequiredView(paramObject, 2131559196, "field 'mTopDivider'");
    paramT.mBottomDivider = paramFinder.findRequiredView(paramObject, 2131559222, "field 'mBottomDivider'");
  }
  
  public void unbind()
  {
    ForumNotifyViewHolder localForumNotifyViewHolder = this.a;
    if (localForumNotifyViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localForumNotifyViewHolder.mIconImg = null;
    localForumNotifyViewHolder.mNickNameTxt = null;
    localForumNotifyViewHolder.mCreatedTxt = null;
    localForumNotifyViewHolder.mTitle = null;
    localForumNotifyViewHolder.mPostContent = null;
    localForumNotifyViewHolder.mReplyPostContent = null;
    localForumNotifyViewHolder.mTopDivider = null;
    localForumNotifyViewHolder.mBottomDivider = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\viewholder\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */