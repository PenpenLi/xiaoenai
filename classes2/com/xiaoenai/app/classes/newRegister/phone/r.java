package com.xiaoenai.app.classes.newRegister.phone;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.CleanableEditText;

public class r<T extends PhoneRegisterSettingPWActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private TextWatcher c;
  private View d;
  private TextWatcher e;
  private View f;
  private View g;
  private View h;
  
  public r(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131558691, "field 'mNewPasswordEditText', method 'editorAction', and method 'OnTextChanged'");
    paramT.mNewPasswordEditText = ((CleanableEditText)paramFinder.castView(localView, 2131558691, "field 'mNewPasswordEditText'", CleanableEditText.class));
    this.b = localView;
    ((TextView)localView).setOnEditorActionListener(new s(this, paramT));
    this.c = new t(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    localView = paramFinder.findRequiredView(paramObject, 2131558692, "field 'mNewPasswordConfirmEditText', method 'editorAction1', and method 'OnTextChanged'");
    paramT.mNewPasswordConfirmEditText = ((CleanableEditText)paramFinder.castView(localView, 2131558692, "field 'mNewPasswordConfirmEditText'", CleanableEditText.class));
    this.d = localView;
    ((TextView)localView).setOnEditorActionListener(new u(this, paramT));
    this.e = new v(this, paramT);
    ((TextView)localView).addTextChangedListener(this.e);
    localView = paramFinder.findRequiredView(paramObject, 2131558675, "field 'mAvatarImageView' and method 'chooseAvatar'");
    paramT.mAvatarImageView = ((ImageView)paramFinder.castView(localView, 2131558675, "field 'mAvatarImageView'", ImageView.class));
    this.f = localView;
    localView.setOnClickListener(new w(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131558693, "field 'mLoginBtn' and method 'finishRegister'");
    paramT.mLoginBtn = ((Button)paramFinder.castView(localView, 2131558693, "field 'mLoginBtn'", Button.class));
    this.g = localView;
    localView.setOnClickListener(new x(this, paramT));
    paramT.mAvatarLayout = paramFinder.findRequiredView(paramObject, 2131558690, "field 'mAvatarLayout'");
    paramT.mMainLayout = paramFinder.findRequiredView(paramObject, 2131558671, "field 'mMainLayout'");
    paramFinder = paramFinder.findRequiredView(paramObject, 2131558670, "method 'hideIme'");
    this.h = paramFinder;
    paramFinder.setOnClickListener(new y(this, paramT));
  }
  
  public void unbind()
  {
    PhoneRegisterSettingPWActivity localPhoneRegisterSettingPWActivity = this.a;
    if (localPhoneRegisterSettingPWActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPhoneRegisterSettingPWActivity.mNewPasswordEditText = null;
    localPhoneRegisterSettingPWActivity.mNewPasswordConfirmEditText = null;
    localPhoneRegisterSettingPWActivity.mAvatarImageView = null;
    localPhoneRegisterSettingPWActivity.mLoginBtn = null;
    localPhoneRegisterSettingPWActivity.mAvatarLayout = null;
    localPhoneRegisterSettingPWActivity.mMainLayout = null;
    ((TextView)this.b).setOnEditorActionListener(null);
    ((TextView)this.b).removeTextChangedListener(this.c);
    this.c = null;
    this.b = null;
    ((TextView)this.d).setOnEditorActionListener(null);
    ((TextView)this.d).removeTextChangedListener(this.e);
    this.e = null;
    this.d = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */