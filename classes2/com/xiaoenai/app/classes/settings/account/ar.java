package com.xiaoenai.app.classes.settings.account;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.CleanableEditText;

public class ar<T extends SettingNameOrMailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private TextWatcher c;
  private View d;
  
  public ar(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    View localView = paramFinder.findRequiredView(paramObject, 2131559705, "field 'mEtvEmailOrNickname', method 'onEditorAction', and method 'onAfterTextChange'");
    paramT.mEtvEmailOrNickname = ((CleanableEditText)paramFinder.castView(localView, 2131559705, "field 'mEtvEmailOrNickname'", CleanableEditText.class));
    this.b = localView;
    ((TextView)localView).setOnEditorActionListener(new as(this, paramT));
    this.c = new at(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    paramT.mTvTip = ((TextView)paramFinder.findRequiredViewAsType(paramObject, 2131559706, "field 'mTvTip'", TextView.class));
    paramObject = paramFinder.findRequiredView(paramObject, 2131559707, "field 'mBtnSave' and method 'onClick'");
    paramT.mBtnSave = ((Button)paramFinder.castView((View)paramObject, 2131559707, "field 'mBtnSave'", Button.class));
    this.d = ((View)paramObject);
    ((View)paramObject).setOnClickListener(new au(this, paramT));
  }
  
  public void unbind()
  {
    SettingNameOrMailActivity localSettingNameOrMailActivity = this.a;
    if (localSettingNameOrMailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSettingNameOrMailActivity.mEtvEmailOrNickname = null;
    localSettingNameOrMailActivity.mTvTip = null;
    localSettingNameOrMailActivity.mBtnSave = null;
    ((TextView)this.b).setOnEditorActionListener(null);
    ((TextView)this.b).removeTextChangedListener(this.c);
    this.c = null;
    this.b = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */