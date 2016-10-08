package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class aa<T extends MensesMaleFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public aa(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mColseTip = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559113, "field 'mColseTip'", LinearLayout.class));
    paramT.mCloseIcon = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559112, "field 'mCloseIcon'", LinearLayout.class));
    paramObject = paramFinder.findRequiredView(paramObject, 2131559115, "field 'mConcernView' and method 'concern'");
    paramT.mConcernView = ((Button)paramFinder.castView((View)paramObject, 2131559115, "field 'mConcernView'", Button.class));
    this.b = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new ab(this, paramT));
  }
  
  public void unbind()
  {
    MensesMaleFragment localMensesMaleFragment = this.a;
    if (localMensesMaleFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMensesMaleFragment.mColseTip = null;
    localMensesMaleFragment.mCloseIcon = null;
    localMensesMaleFragment.mConcernView = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */