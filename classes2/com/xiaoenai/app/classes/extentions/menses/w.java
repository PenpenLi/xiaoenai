package com.xiaoenai.app.classes.extentions.menses;

import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class w<T extends MensesEditSexActivity>
  implements Unbinder
{
  protected T a;
  
  public w(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mButton = ((Button)paramFinder.findRequiredViewAsType(paramObject, 2131559108, "field 'mButton'", Button.class));
    paramT.mMalemSelector = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559103, "field 'mMalemSelector'", ImageView.class));
    paramT.mMalemSelectorIcon = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559104, "field 'mMalemSelectorIcon'", ImageView.class));
    paramT.mFemalemSelector = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559106, "field 'mFemalemSelector'", ImageView.class));
    paramT.mFemalemSelectorIcon = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559107, "field 'mFemalemSelectorIcon'", ImageView.class));
  }
  
  public void unbind()
  {
    MensesEditSexActivity localMensesEditSexActivity = this.a;
    if (localMensesEditSexActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMensesEditSexActivity.mButton = null;
    localMensesEditSexActivity.mMalemSelector = null;
    localMensesEditSexActivity.mMalemSelectorIcon = null;
    localMensesEditSexActivity.mFemalemSelector = null;
    localMensesEditSexActivity.mFemalemSelectorIcon = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */