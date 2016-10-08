package com.xiaoenai.app.classes.chat.messagelist.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.d.t;

public abstract class BaseItemView
  extends RelativeLayout
{
  protected int a;
  @BindView(2131558832)
  protected FrameLayout mFlAvatar;
  @BindView(2131558843)
  protected ImageView mIvStatusFailed;
  @BindView(2131558847)
  protected ImageView mIvVoiceLoadError;
  @BindView(2131558833)
  protected LinearLayout mLlAvatar;
  @BindView(2131558834)
  protected AvatarView mMessageAvatar;
  @BindView(2131558839)
  protected RelativeLayout mMessageBody;
  @BindView(2131558830)
  protected TextView mMessageTime;
  @BindView(2131558836)
  protected AvatarView mPickerAvatar;
  @BindView(2131558835)
  protected LinearLayout mPickerAvatarBg;
  @BindView(2131558842)
  protected ProgressView mPvStatusSending;
  @BindView(2131558840)
  protected LinearLayout mRlStatus;
  @BindView(2131558844)
  protected LinearLayout mRlStatusTxt;
  @BindView(2131558837)
  protected RelativeLayout mRlUserName;
  @BindView(2131558846)
  protected LinearLayout mRlVoiceStatus;
  @BindView(2131558845)
  protected TextView mTvMessageStatus;
  @BindView(2131558838)
  protected TextView mTvUserName;
  @BindView(2131558848)
  protected ImageView mVoiceUnread;
  
  public BaseItemView(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2130903112, this);
    ButterKnife.bind(this);
    setNickNameVisibility(8);
    paramContext = getMsgContentView();
    if (paramContext != null) {
      this.mMessageBody.addView(paramContext);
    }
  }
  
  public void a()
  {
    if (this.a == 2) {}
    for (String str = User.getInstance().getLoverAvatar();; str = User.getInstance().getAvatar())
    {
      this.mMessageAvatar.setRoundedImage(str);
      return;
    }
  }
  
  public AvatarView getAvatar()
  {
    return this.mMessageAvatar;
  }
  
  public LinearLayout getAvatarBg()
  {
    return this.mLlAvatar;
  }
  
  protected FrameLayout getAvatarLayout()
  {
    return this.mFlAvatar;
  }
  
  public RelativeLayout getMessageBody()
  {
    return this.mMessageBody;
  }
  
  public abstract View getMsgContentView();
  
  public AvatarView getPickerAvatar()
  {
    return this.mPickerAvatar;
  }
  
  public LinearLayout getPickerAvatarBg()
  {
    return this.mPickerAvatarBg;
  }
  
  public ImageView getSendFailedImageView()
  {
    return this.mIvStatusFailed;
  }
  
  public int getUserType()
  {
    return this.a;
  }
  
  public void setCreatedAt(String paramString)
  {
    if (paramString != null)
    {
      this.mMessageTime.setText(paramString);
      this.mMessageTime.setVisibility(0);
      return;
    }
    this.mMessageTime.setVisibility(8);
  }
  
  public abstract void setImageResource(int paramInt);
  
  public void setNickNameVisibility(int paramInt)
  {
    this.mRlUserName.setVisibility(paramInt);
  }
  
  public void setSendFailedClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mIvStatusFailed.setOnClickListener(paramOnClickListener);
  }
  
  public void setStatus(int paramInt)
  {
    if (this.a == 2) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case -3: 
      this.mPvStatusSending.setVisibility(8);
      this.mIvStatusFailed.setVisibility(8);
      this.mTvMessageStatus.setVisibility(8);
      return;
    case -1: 
      this.mPvStatusSending.setVisibility(0);
      this.mIvStatusFailed.setVisibility(8);
      this.mTvMessageStatus.setText(2131100894);
      this.mTvMessageStatus.setVisibility(8);
      return;
    case -2: 
      this.mPvStatusSending.setVisibility(8);
      this.mIvStatusFailed.setVisibility(0);
      this.mTvMessageStatus.setText(2131100894);
      this.mTvMessageStatus.setVisibility(8);
      return;
    case 1: 
      this.mPvStatusSending.setVisibility(8);
      this.mIvStatusFailed.setVisibility(8);
      this.mTvMessageStatus.setVisibility(0);
      this.mTvMessageStatus.setText(2131100024);
      this.mTvMessageStatus.setBackgroundResource(2130838845);
      return;
    }
    this.mPvStatusSending.setVisibility(8);
    this.mIvStatusFailed.setVisibility(8);
    this.mTvMessageStatus.setVisibility(0);
    this.mTvMessageStatus.setText(2131100025);
    this.mTvMessageStatus.setBackgroundResource(2130838844);
  }
  
  public void setUserType(int paramInt)
  {
    this.a = paramInt;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.mMessageBody.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.mFlAvatar.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.mRlStatus.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams4 = (RelativeLayout.LayoutParams)this.mRlStatusTxt.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams5 = (RelativeLayout.LayoutParams)this.mRlVoiceStatus.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams6 = (RelativeLayout.LayoutParams)this.mVoiceUnread.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams7 = (RelativeLayout.LayoutParams)this.mRlUserName.getLayoutParams();
    if (paramInt == 2)
    {
      this.mMessageBody.setBackgroundDrawable(getResources().getDrawable(2130837637));
      localLayoutParams2.addRule(9, -1);
      localLayoutParams2.addRule(11, 0);
      localLayoutParams2.setMargins(0, 0, t.a(getContext(), 8.0F), 0);
      localLayoutParams1.addRule(1, this.mFlAvatar.getId());
      localLayoutParams1.addRule(0, -1);
      localLayoutParams3.addRule(1, this.mMessageBody.getId());
      localLayoutParams3.addRule(0, -1);
      localLayoutParams3.setMargins(t.a(getContext(), 8.0F), 0, 0, 0);
      localLayoutParams4.addRule(1, this.mMessageBody.getId());
      localLayoutParams4.addRule(0, -1);
      localLayoutParams4.setMargins(t.a(getContext(), 8.0F), 0, 0, 0);
      localLayoutParams5.addRule(1, this.mMessageBody.getId());
      localLayoutParams5.addRule(0, -1);
      localLayoutParams6.addRule(0, -1);
      localLayoutParams6.addRule(1, this.mMessageBody.getId());
      localLayoutParams6.setMargins(t.a(getContext(), 8.0F), 0, 0, 0);
      localLayoutParams7.addRule(0, -1);
      localLayoutParams7.addRule(1, this.mFlAvatar.getId());
      this.mRlUserName.setGravity(3);
      ((RelativeLayout.LayoutParams)this.mTvUserName.getLayoutParams()).setMargins(t.a(getContext(), 12.0F), 0, 0, 0);
      this.mTvUserName.setSingleLine();
      this.mTvUserName.setGravity(3);
      this.mTvUserName.setText(User.getInstance().getLoverNickName());
    }
    for (;;)
    {
      this.mFlAvatar.setLayoutParams(localLayoutParams2);
      this.mMessageBody.setLayoutParams(localLayoutParams1);
      this.mRlStatus.setLayoutParams(localLayoutParams3);
      this.mRlStatusTxt.setLayoutParams(localLayoutParams4);
      this.mRlVoiceStatus.setLayoutParams(localLayoutParams5);
      this.mVoiceUnread.setLayoutParams(localLayoutParams6);
      a();
      return;
      this.mMessageBody.setBackgroundDrawable(getResources().getDrawable(2130837641));
      localLayoutParams2.addRule(11, -1);
      localLayoutParams2.addRule(9, 0);
      localLayoutParams2.setMargins(t.a(getContext(), 8.0F), 0, 0, 0);
      localLayoutParams1.addRule(0, this.mFlAvatar.getId());
      localLayoutParams1.addRule(1, -1);
      localLayoutParams3.addRule(1, -1);
      localLayoutParams3.addRule(0, this.mMessageBody.getId());
      localLayoutParams3.setMargins(0, 0, t.a(getContext(), 8.0F), 0);
      localLayoutParams4.addRule(1, -1);
      localLayoutParams4.addRule(0, this.mMessageBody.getId());
      localLayoutParams4.setMargins(0, 0, t.a(getContext(), 8.0F), t.a(getContext(), 2.0F));
      localLayoutParams5.addRule(1, -1);
      localLayoutParams5.addRule(0, this.mRlStatusTxt.getId());
      this.mVoiceUnread.setVisibility(8);
      localLayoutParams7.addRule(1, -1);
      localLayoutParams7.addRule(0, this.mFlAvatar.getId());
      this.mRlUserName.setGravity(5);
      ((RelativeLayout.LayoutParams)this.mTvUserName.getLayoutParams()).setMargins(0, 0, t.a(getContext(), 12.0F), 0);
      this.mTvUserName.setSingleLine();
      this.mTvUserName.setGravity(5);
      this.mTvUserName.setText(User.getInstance().getNickName());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\BaseItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */