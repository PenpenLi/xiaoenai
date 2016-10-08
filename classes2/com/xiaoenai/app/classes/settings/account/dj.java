package com.xiaoenai.app.classes.settings.account;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.CleanableEditText;

public class dj<T extends SettingUserNameActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private TextWatcher c;
  private View d;
  
  public dj(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131559719, "field 'mEtvUsername', method 'onEditorAction', and method 'afterTextChanged'");
    paramT.mEtvUsername = ((CleanableEditText)paramFinder.castView(localView, 2131559719, "field 'mEtvUsername'", CleanableEditText.class));
    this.b = localView;
    ((TextView)localView).setOnEditorActionListener(new dk(this, paramT));
    this.c = new dl(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    paramObject = paramFinder.findRequiredView(paramObject, 2131559707, "field 'mBtnSave' and method 'onClick'");
    paramT.mBtnSave = ((Button)paramFinder.castView((View)paramObject, 2131559707, "field 'mBtnSave'", Button.class));
    this.d = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new dm(this, paramT));
  }
  
  public void unbind()
  {
    SettingUserNameActivity localSettingUserNameActivity = this.a;
    if (localSettingUserNameActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSettingUserNameActivity.mEtvUsername = null;
    localSettingUserNameActivity.mBtnSave = null;
    ((TextView)this.b).setOnEditorActionListener(null);
    ((TextView)this.b).removeTextChangedListener(this.c);
    this.c = null;
    this.b = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */