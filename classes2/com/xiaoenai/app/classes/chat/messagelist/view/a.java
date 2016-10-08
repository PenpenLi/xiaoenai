package com.xiaoenai.app.classes.chat.messagelist.view;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.ui.component.view.ProgressView;

public class a<T extends BaseItemView>
  implements Unbinder
{
  protected T a;
  
  public a(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mMessageTime = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558830, "field 'mMessageTime'", TextView.class));
    paramT.mLlAvatar = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558833, "field 'mLlAvatar'", LinearLayout.class));
    paramT.mMessageAvatar = ((AvatarView)paramFinder.findRequiredViewAsType(paramObject, 2131558834, "field 'mMessageAvatar'", AvatarView.class));
    paramT.mPickerAvatar = ((AvatarView)paramFinder.findRequiredViewAsType(paramObject, 2131558836, "field 'mPickerAvatar'", AvatarView.class));
    paramT.mPickerAvatarBg = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558835, "field 'mPickerAvatarBg'", LinearLayout.class));
    paramT.mFlAvatar = ((FrameLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558832, "field 'mFlAvatar'", FrameLayout.class));
    paramT.mTvUserName = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558838, "field 'mTvUserName'", TextView.class));
    paramT.mRlUserName = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558837, "field 'mRlUserName'", RelativeLayout.class));
    paramT.mMessageBody = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558839, "field 'mMessageBody'", RelativeLayout.class));
    paramT.mPvStatusSending = ((ProgressView)paramFinder.findRequiredViewAsType(paramObject, 2131558842, "field 'mPvStatusSending'", ProgressView.class));
    paramT.mIvStatusFailed = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558843, "field 'mIvStatusFailed'", ImageView.class));
    paramT.mTvMessageStatus = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558845, "field 'mTvMessageStatus'", TextView.class));
    paramT.mRlStatusTxt = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558844, "field 'mRlStatusTxt'", LinearLayout.class));
    paramT.mRlStatus = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558840, "field 'mRlStatus'", LinearLayout.class));
    paramT.mIvVoiceLoadError = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558847, "field 'mIvVoiceLoadError'", ImageView.class));
    paramT.mVoiceUnread = ((ImageView)paramFinder.findRequiredViewAsType(paramObject, 2131558848, "field 'mVoiceUnread'", ImageView.class));
    paramT.mRlVoiceStatus = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558846, "field 'mRlVoiceStatus'", LinearLayout.class));
  }
  
  public void unbind()
  {
    BaseItemView localBaseItemView = this.a;
    if (localBaseItemView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBaseItemView.mMessageTime = null;
    localBaseItemView.mLlAvatar = null;
    localBaseItemView.mMessageAvatar = null;
    localBaseItemView.mPickerAvatar = null;
    localBaseItemView.mPickerAvatarBg = null;
    localBaseItemView.mFlAvatar = null;
    localBaseItemView.mTvUserName = null;
    localBaseItemView.mRlUserName = null;
    localBaseItemView.mMessageBody = null;
    localBaseItemView.mPvStatusSending = null;
    localBaseItemView.mIvStatusFailed = null;
    localBaseItemView.mTvMessageStatus = null;
    localBaseItemView.mRlStatusTxt = null;
    localBaseItemView.mRlStatus = null;
    localBaseItemView.mIvVoiceLoadError = null;
    localBaseItemView.mVoiceUnread = null;
    localBaseItemView.mRlVoiceStatus = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */