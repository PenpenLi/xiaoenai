package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class aw<T extends MensesSettingActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public aw(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131559133, "field 'mStopView' and method 'showColseDialog'");
    paramT.mStopView = ((TextView)paramFinder.castView(localView, 2131559133, "field 'mStopView'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new ax(this, paramT));
    paramObject = paramFinder.findRequiredView(paramObject, 2131559131, "field 'mScrollStopView' and method 'showColseDialog'");
    paramT.mScrollStopView = ((TextView)paramFinder.castView((View)paramObject, 2131559131, "field 'mScrollStopView'", TextView.class));
    this.c = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new ay(this, paramT));
  }
  
  public void unbind()
  {
    MensesSettingActivity localMensesSettingActivity = this.a;
    if (localMensesSettingActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMensesSettingActivity.mStopView = null;
    localMensesSettingActivity.mScrollStopView = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */