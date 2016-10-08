package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class r<T extends MensesActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public r(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mCloseIcon = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131559084, "field 'mCloseIcon'", ImageView.class));
    paramT.mLastMensesTme = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559099, "field 'mLastMensesTme'", TextView.class));
    paramT.mLayoutNotify = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559098, "field 'mLayoutNotify'", LinearLayout.class));
    paramT.mColseTip = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559094, "field 'mColseTip'", RelativeLayout.class));
    paramFinder = paramFinder.findRequiredView(paramObject, 2131559097, "method 'start'");
    this.b = paramFinder;
    paramFinder.setOnClickListener(new s(this, paramT));
  }
  
  public void unbind()
  {
    MensesActivity localMensesActivity = this.a;
    if (localMensesActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMensesActivity.mCloseIcon = null;
    localMensesActivity.mLastMensesTme = null;
    localMensesActivity.mLayoutNotify = null;
    localMensesActivity.mColseTip = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */