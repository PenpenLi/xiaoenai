package com.xiaoenai.app.classes.street.widget.viewHolder;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class d<T extends StreetSceneHeaderViewHolder>
  implements Unbinder
{
  protected T a;
  
  public d(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mHeaderText = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559367, "field 'mHeaderText'", TextView.class));
  }
  
  public void unbind()
  {
    StreetSceneHeaderViewHolder localStreetSceneHeaderViewHolder = this.a;
    if (localStreetSceneHeaderViewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localStreetSceneHeaderViewHolder.mHeaderText = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\viewHolder\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */