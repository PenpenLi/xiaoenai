package com.xiaoenai.app.classes.forum.widget;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.classes.common.widget.RedView;

public class h<T extends RedPointThreeTabLayout>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public h(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mFirstRedView = ((RedView)paramFinder.findRequiredViewAsType(paramObject, 2131560115, "field 'mFirstRedView'", RedView.class));
    paramT.mMidRedView = ((RedView)paramFinder.findRequiredViewAsType(paramObject, 2131560116, "field 'mMidRedView'", RedView.class));
    paramT.mLastRedView = ((RedView)paramFinder.findRequiredViewAsType(paramObject, 2131560118, "field 'mLastRedView'", RedView.class));
    View localView = paramFinder.findRequiredView(paramObject, 2131560114, "field 'mFirstLayout' and method 'onFirstClick'");
    paramT.mFirstLayout = ((FrameLayout)paramFinder.castView(localView, 2131560114, "field 'mFirstLayout'", FrameLayout.class));
    this.b = localView;
    localView.setOnClickListener(new i(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131560038, "field 'mMidLayout' and method 'onMidClick'");
    paramT.mMidLayout = ((FrameLayout)paramFinder.castView(localView, 2131560038, "field 'mMidLayout'", FrameLayout.class));
    this.c = localView;
    localView.setOnClickListener(new j(this, paramT));
    paramObject = paramFinder.findRequiredView(paramObject, 2131560117, "field 'mLastLayout' and method 'onLastClick'");
    paramT.mLastLayout = ((FrameLayout)paramFinder.castView((View)paramObject, 2131560117, "field 'mLastLayout'", FrameLayout.class));
    this.d = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new k(this, paramT));
  }
  
  public void unbind()
  {
    RedPointThreeTabLayout localRedPointThreeTabLayout = this.a;
    if (localRedPointThreeTabLayout == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRedPointThreeTabLayout.mFirstRedView = null;
    localRedPointThreeTabLayout.mMidRedView = null;
    localRedPointThreeTabLayout.mLastRedView = null;
    localRedPointThreeTabLayout.mFirstLayout = null;
    localRedPointThreeTabLayout.mMidLayout = null;
    localRedPointThreeTabLayout.mLastLayout = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */