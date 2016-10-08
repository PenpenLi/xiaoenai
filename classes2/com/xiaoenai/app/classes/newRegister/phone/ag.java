package com.xiaoenai.app.classes.newRegister.phone;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;

public class ag<T extends PhoneRegisterVerifyActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private TextWatcher c;
  private View d;
  private View e;
  
  public ag(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.tipsTxt = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558694, "field 'tipsTxt'", TextView.class));
    paramT.phoneNumText = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558695, "field 'phoneNumText'", TextView.class));
    View localView = paramFinder.findRequiredView(paramObject, 2131558697, "field 'verifyCodeEdit' and method 'OnTextChanged'");
    paramT.verifyCodeEdit = ((EditText)paramFinder.castView(localView, 2131558697, "field 'verifyCodeEdit'", EditText.class));
    this.b = localView;
    this.c = new ah(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    localView = paramFinder.findRequiredView(paramObject, 2131558699, "field 'regetVerifyCodeText' and method 'doClick'");
    paramT.regetVerifyCodeText = ((TextView)paramFinder.castView(localView, 2131558699, "field 'regetVerifyCodeText'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new ai(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131558698, "field 'submitVerifyCodeBtn' and method 'next'");
    paramT.submitVerifyCodeBtn = ((Button)paramFinder.castView(localView, 2131558698, "field 'submitVerifyCodeBtn'", Button.class));
    this.e = localView;
    localView.setOnClickListener(new aj(this, paramT));
    paramT.textHint = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131558696, "field 'textHint'", TextView.class));
  }
  
  public void unbind()
  {
    PhoneRegisterVerifyActivity localPhoneRegisterVerifyActivity = this.a;
    if (localPhoneRegisterVerifyActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPhoneRegisterVerifyActivity.tipsTxt = null;
    localPhoneRegisterVerifyActivity.phoneNumText = null;
    localPhoneRegisterVerifyActivity.verifyCodeEdit = null;
    localPhoneRegisterVerifyActivity.regetVerifyCodeText = null;
    localPhoneRegisterVerifyActivity.submitVerifyCodeBtn = null;
    localPhoneRegisterVerifyActivity.textHint = null;
    ((TextView)this.b).removeTextChangedListener(this.c);
    this.c = null;
    this.b = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */