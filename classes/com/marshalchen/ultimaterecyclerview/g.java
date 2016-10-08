package com.marshalchen.ultimaterecyclerview;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class g<T extends RecyclerLoadingLayout>
  implements Unbinder
{
  protected T a;
  
  public g(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mRotateImg = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559680, "field 'mRotateImg'", ImageView.class));
    paramT.mHeaderTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559681, "field 'mHeaderTxt'", TextView.class));
  }
  
  public void unbind()
  {
    RecyclerLoadingLayout localRecyclerLoadingLayout = this.a;
    if (localRecyclerLoadingLayout == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRecyclerLoadingLayout.mRotateImg = null;
    localRecyclerLoadingLayout.mHeaderTxt = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */