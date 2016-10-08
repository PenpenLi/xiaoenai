package com.xiaoenai.app.classes.settings.account;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.CleanableEditText;

public class cw<T extends SettingPhoneInputActivity>
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
  
  public cw(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131559710, "field 'mEtvPhone', method 'onEditorAction', and method 'onPhoneTextChange'");
    paramT.mEtvPhone = ((CleanableEditText)paramFinder.castView(localView, 2131559710, "field 'mEtvPhone'", CleanableEditText.class));
    this.b = localView;
    ((TextView)localView).setOnEditorActionListener(new cx(this, paramT));
    this.c = new cy(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    paramT.mLlPhoneLayout = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559709, "field 'mLlPhoneLayout'", LinearLayout.class));
    localView = paramFinder.findRequiredView(paramObject, 2131559712, "field 'mEtvCode' and method 'onCodeTextChange'");
    paramT.mEtvCode = ((EditText)paramFinder.castView(localView, 2131559712, "field 'mEtvCode'", EditText.class));
    this.d = localView;
    this.e = new cz(this, paramT);
    ((TextView)localView).addTextChangedListener(this.e);
    paramT.mLlCodeLayout = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131559711, "field 'mLlCodeLayout'", LinearLayout.class));
    localView = paramFinder.findRequiredView(paramObject, 2131559714, "field 'mBtnUnbind' and method 'onClick'");
    paramT.mBtnUnbind = ((Button)paramFinder.castView(localView, 2131559714, "field 'mBtnUnbind'", Button.class));
    this.f = localView;
    localView.setOnClickListener(new da(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131559715, "field 'mBtnSubmit' and method 'onClick'");
    paramT.mBtnSubmit = ((Button)paramFinder.castView(localView, 2131559715, "field 'mBtnSubmit'", Button.class));
    this.g = localView;
    localView.setOnClickListener(new db(this, paramT));
    paramObject = paramFinder.findRequiredView(paramObject, 2131559713, "field 'mBtnRegetCode' and method 'onClick'");
    paramT.mBtnRegetCode = ((Button)paramFinder.castView((View)paramObject, 2131559713, "field 'mBtnRegetCode'", Button.class));
    this.h = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new dc(this, paramT));
  }
  
  public void unbind()
  {
    SettingPhoneInputActivity localSettingPhoneInputActivity = this.a;
    if (localSettingPhoneInputActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSettingPhoneInputActivity.mEtvPhone = null;
    localSettingPhoneInputActivity.mLlPhoneLayout = null;
    localSettingPhoneInputActivity.mEtvCode = null;
    localSettingPhoneInputActivity.mLlCodeLayout = null;
    localSettingPhoneInputActivity.mBtnUnbind = null;
    localSettingPhoneInputActivity.mBtnSubmit = null;
    localSettingPhoneInputActivity.mBtnRegetCode = null;
    ((TextView)this.b).setOnEditorActionListener(null);
    ((TextView)this.b).removeTextChangedListener(this.c);
    this.c = null;
    this.b = null;
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */