package com.xiaoenai.app.feature.feedback.view.activity;

import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.feature.feedback.a.d;
import com.xiaoenai.app.feature.feedback.view.widget.InputLayoutView;
import com.xiaoenai.app.ui.xrecyclerview.XRecyclerView;

public class r<T extends FeedbackActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public r(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, a.d.xrv_view, "field 'mRecyclerView' and method 'onTouch'");
    paramT.mRecyclerView = ((XRecyclerView)paramFinder.castView(localView, a.d.xrv_view, "field 'mRecyclerView'", XRecyclerView.class));
    this.b = localView;
    localView.setOnTouchListener(new s(this, paramT));
    paramT.mInputLayoutView = ((InputLayoutView)paramFinder.findRequiredViewAsType(paramObject, a.d.root_layout, "field 'mInputLayoutView'", InputLayoutView.class));
    paramT.mRlChatBody = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, a.d.rl_chat_body, "field 'mRlChatBody'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    FeedbackActivity localFeedbackActivity = this.a;
    if (localFeedbackActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localFeedbackActivity.mRecyclerView = null;
    localFeedbackActivity.mInputLayoutView = null;
    localFeedbackActivity.mRlChatBody = null;
    this.b.setOnTouchListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */