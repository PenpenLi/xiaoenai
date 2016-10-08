package com.xiaoenai.app.classes.home.view.viewHolder;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class a<T extends LifeServiceHeaderViewHolder>
  implements Unbinder
{
  protected T a;
  
  public a(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.titleText = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559569, "field 'titleText'", TextView.class));
  }
  
  public void unbind()
  {
    LifeServiceHeaderViewHolder localLifeServiceHeaderViewHolder = this.a;
    if (localLifeServiceHeaderViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLifeServiceHeaderViewHolder.titleText = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\viewHolder\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */