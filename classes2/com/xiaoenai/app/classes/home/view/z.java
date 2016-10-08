package com.xiaoenai.app.classes.home.view;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class z<T extends LifeServiceLayout>
  implements Unbinder
{
  protected T a;
  
  public z(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mStreetGuideRecyclerView = ((RecyclerView)paramFinder.findRequiredViewAsType(paramObject, 2131559570, "field 'mStreetGuideRecyclerView'", RecyclerView.class));
    paramT.mTitleView = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559569, "field 'mTitleView'", TextView.class));
  }
  
  public void unbind()
  {
    LifeServiceLayout localLifeServiceLayout = this.a;
    if (localLifeServiceLayout == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLifeServiceLayout.mStreetGuideRecyclerView = null;
    localLifeServiceLayout.mTitleView = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */