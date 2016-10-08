package com.xiaoenai.app.classes.settings.account;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.CleanableEditText;

public class v<T extends SettingChangePasswordActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private TextWatcher c;
  private View d;
  private TextWatcher e;
  private View f;
  private TextWatcher g;
  private View h;
  
  public v(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131559738, "field 'editTextOldPass' and method 'onAfterChange'");
    paramT.editTextOldPass = ((CleanableEditText)paramFinder.castView(localView, 2131559738, "field 'editTextOldPass'", CleanableEditText.class));
    this.b = localView;
    this.c = new w(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    localView = paramFinder.findRequiredView(paramObject, 2131559612, "field 'editTextNewPass' and method 'onAfterChange'");
    paramT.editTextNewPass = ((CleanableEditText)paramFinder.castView(localView, 2131559612, "field 'editTextNewPass'", CleanableEditText.class));
    this.d = localView;
    this.e = new x(this, paramT);
    ((TextView)localView).addTextChangedListener(this.e);
    localView = paramFinder.findRequiredView(paramObject, 2131559613, "field 'editTextNewPassConfirm', method 'onEditorAction', and method 'onAfterChange'");
    paramT.editTextNewPassConfirm = ((CleanableEditText)paramFinder.castView(localView, 2131559613, "field 'editTextNewPassConfirm'", CleanableEditText.class));
    this.f = localView;
    ((TextView)localView).setOnEditorActionListener(new y(this, paramT));
    this.g = new z(this, paramT);
    ((TextView)localView).addTextChangedListener(this.g);
    paramObject = paramFinder.findRequiredView(paramObject, 2131559707, "field 'btnSave' and method 'onClick'");
    paramT.btnSave = ((Button)paramFinder.castView((View)paramObject, 2131559707, "field 'btnSave'", Button.class));
    this.h = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new aa(this, paramT));
  }
  
  public void unbind()
  {
    SettingChangePasswordActivity localSettingChangePasswordActivity = this.a;
    if (localSettingChangePasswordActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSettingChangePasswordActivity.editTextOldPass = null;
    localSettingChangePasswordActivity.editTextNewPass = null;
    localSettingChangePasswordActivity.editTextNewPassConfirm = null;
    localSettingChangePasswordActivity.btnSave = null;
    ((TextView)this.b).removeTextChangedListener(this.c);
    this.c = null;
    this.b = null;
    ((TextView)this.d).removeTextChangedListener(this.e);
    this.e = null;
    this.d = null;
    ((TextView)this.f).setOnEditorActionListener(null);
    ((TextView)this.f).removeTextChangedListener(this.g);
    this.g = null;
    this.f = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */