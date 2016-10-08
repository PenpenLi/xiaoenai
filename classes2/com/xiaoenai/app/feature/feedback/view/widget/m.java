package com.xiaoenai.app.feature.feedback.view.widget;

import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.feature.feedback.a.d;

public class m<T extends TipTextItemView>
  implements Unbinder
{
  protected T a;
  
  public m(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.rlTipRoot = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, a.d.rl_tip_root, "field 'rlTipRoot'", RelativeLayout.class));
    paramT.tvTip = ((TextView)paramFinder.findRequiredViewAsType(paramObject, a.d.tv_tip, "field 'tvTip'", TextView.class));
  }
  
  public void unbind()
  {
    TipTextItemView localTipTextItemView = this.a;
    if (localTipTextItemView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localTipTextItemView.rlTipRoot = null;
    localTipTextItemView.tvTip = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\widget\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */