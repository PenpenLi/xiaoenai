package com.xiaoenai.app.feature.feedback.view.widget;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.feature.feedback.a.d;

public class b<T extends BaseItemView>
  implements Unbinder
{
  protected T a;
  
  public b(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.rlItemRoot = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, a.d.rl_item_root, "field 'rlItemRoot'", RelativeLayout.class));
    paramT.tvTime = ((TextView)paramFinder.findRequiredViewAsType(paramObject, a.d.tv_time, "field 'tvTime'", TextView.class));
    paramT.ivAvatar = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, a.d.iv_avatar, "field 'ivAvatar'", ImageView.class));
    paramT.rlContent = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, a.d.rl_content, "field 'rlContent'", RelativeLayout.class));
    paramT.mSendingProgressBar = ((ProgressBar)paramFinder.findRequiredViewAsType(paramObject, a.d.pb_sending, "field 'mSendingProgressBar'", ProgressBar.class));
    paramT.tvStatus = ((TextView)paramFinder.findRequiredViewAsType(paramObject, a.d.tv_status, "field 'tvStatus'", TextView.class));
    paramT.ivStatus = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, a.d.iv_status, "field 'ivStatus'", ImageView.class));
    paramT.rlStatus = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, a.d.rl_status, "field 'rlStatus'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    BaseItemView localBaseItemView = this.a;
    if (localBaseItemView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBaseItemView.rlItemRoot = null;
    localBaseItemView.tvTime = null;
    localBaseItemView.ivAvatar = null;
    localBaseItemView.rlContent = null;
    localBaseItemView.mSendingProgressBar = null;
    localBaseItemView.tvStatus = null;
    localBaseItemView.ivStatus = null;
    localBaseItemView.rlStatus = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\widget\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */