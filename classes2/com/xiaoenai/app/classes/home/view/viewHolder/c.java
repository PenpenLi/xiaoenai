package com.xiaoenai.app.classes.home.view.viewHolder;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.remindButton.RemindButton;

public class c<T extends LifeServiceItemViewHolder>
  implements Unbinder
{
  protected T a;
  
  public c(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mIconImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558577, "field 'mIconImg'", ImageView.class));
    paramT.mTitleTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558578, "field 'mTitleTxt'", TextView.class));
    paramT.mRemindButton = ((RemindButton)paramFinder.findRequiredViewAsType(paramObject, 2131559568, "field 'mRemindButton'", RemindButton.class));
  }
  
  public void unbind()
  {
    LifeServiceItemViewHolder localLifeServiceItemViewHolder = this.a;
    if (localLifeServiceItemViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLifeServiceItemViewHolder.mIconImg = null;
    localLifeServiceItemViewHolder.mTitleTxt = null;
    localLifeServiceItemViewHolder.mRemindButton = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\viewHolder\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */