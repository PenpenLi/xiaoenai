package com.xiaoenai.app.widget;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class u<T extends TitleBarView>
  implements Unbinder
{
  protected T a;
  
  public u(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mTitleRootLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131560119, "field 'mTitleRootLayout'", RelativeLayout.class));
    paramT.mLeftLayout = ((ViewGroup)paramFinder.findRequiredViewAsType(paramObject, 2131560120, "field 'mLeftLayout'", ViewGroup.class));
    paramT.mLeft1 = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131560121, "field 'mLeft1'", ImageView.class));
    paramT.mLeft2 = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131560122, "field 'mLeft2'", TextView.class));
    paramT.mMiddleLayout = ((ViewGroup)paramFinder.findRequiredViewAsType(paramObject, 2131560123, "field 'mMiddleLayout'", ViewGroup.class));
    paramT.mTitleTextView = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131560124, "field 'mTitleTextView'", TextView.class));
    paramT.mRightLayout = ((ViewGroup)paramFinder.findRequiredViewAsType(paramObject, 2131560125, "field 'mRightLayout'", ViewGroup.class));
    paramT.mRight1 = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131560126, "field 'mRight1'", TextView.class));
    paramT.mRight2 = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131560127, "field 'mRight2'", TextView.class));
  }
  
  public void unbind()
  {
    TitleBarView localTitleBarView = this.a;
    if (localTitleBarView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localTitleBarView.mTitleRootLayout = null;
    localTitleBarView.mLeftLayout = null;
    localTitleBarView.mLeft1 = null;
    localTitleBarView.mLeft2 = null;
    localTitleBarView.mMiddleLayout = null;
    localTitleBarView.mTitleTextView = null;
    localTitleBarView.mRightLayout = null;
    localTitleBarView.mRight1 = null;
    localTitleBarView.mRight2 = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */