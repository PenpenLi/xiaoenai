package com.xiaoenai.app.classes.newRegister.phone;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.CleanableEditText;

public class e<T extends PhoneRegisterActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private TextWatcher c;
  private View d;
  
  public e(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131558687, "field 'phoneNumEditTxt', method 'onEditorAction', and method 'onTextChanged'");
    paramT.phoneNumEditTxt = ((CleanableEditText)paramFinder.castView(localView, 2131558687, "field 'phoneNumEditTxt'", CleanableEditText.class));
    this.b = localView;
    ((TextView)localView).setOnEditorActionListener(new f(this, paramT));
    this.c = new g(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    paramObject = paramFinder.findRequiredView(paramObject, 2131558688, "field 'registerBtn' and method 'doClick'");
    paramT.registerBtn = ((Button)paramFinder.castView((View)paramObject, 2131558688, "field 'registerBtn'", Button.class));
    this.d = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new h(this, paramT));
  }
  
  public void unbind()
  {
    PhoneRegisterActivity localPhoneRegisterActivity = this.a;
    if (localPhoneRegisterActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localPhoneRegisterActivity.phoneNumEditTxt = null;
    localPhoneRegisterActivity.registerBtn = null;
    ((TextView)this.b).setOnEditorActionListener(null);
    ((TextView)this.b).removeTextChangedListener(this.c);
    this.c = null;
    this.b = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */