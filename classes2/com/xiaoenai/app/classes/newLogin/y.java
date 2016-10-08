package com.xiaoenai.app.classes.newLogin;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;

public class y<T extends LoginActivity>
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
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  
  public y(T paramT, Finder paramFinder, Object paramObject)
  {
    this.a = paramT;
    paramT.mTopLayout = ((RelativeLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558672, "field 'mTopLayout'", RelativeLayout.class));
    paramT.mOtherLoginLayout = ((LinearLayout)paramFinder.findRequiredViewAsType(paramObject, 2131558683, "field 'mOtherLoginLayout'", LinearLayout.class));
    View localView = paramFinder.findRequiredView(paramObject, 2131558677, "field 'mAccountEditText', method 'OnEditorAction', and method 'OnTextChanged'");
    paramT.mAccountEditText = ((CleanableEditText)paramFinder.castView(localView, 2131558677, "field 'mAccountEditText'", CleanableEditText.class));
    this.b = localView;
    ((TextView)localView).setOnEditorActionListener(new z(this, paramT));
    this.c = new ad(this, paramT);
    ((TextView)localView).addTextChangedListener(this.c);
    localView = paramFinder.findRequiredView(paramObject, 2131558678, "field 'mPasswordEditText', method 'OnEditorAction', and method 'OnTextChanged'");
    paramT.mPasswordEditText = ((CleanableEditText)paramFinder.castView(localView, 2131558678, "field 'mPasswordEditText'", CleanableEditText.class));
    this.d = localView;
    ((TextView)localView).setOnEditorActionListener(new ae(this, paramT));
    this.e = new af(this, paramT);
    ((TextView)localView).addTextChangedListener(this.e);
    localView = paramFinder.findRequiredView(paramObject, 2131558679, "field 'mLoginBtn' and method 'login'");
    paramT.mLoginBtn = ((Button)paramFinder.castView(localView, 2131558679, "field 'mLoginBtn'", Button.class));
    this.f = localView;
    localView.setOnClickListener(new ag(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131558684, "field 'mQQLoginBtn' and method 'mQqLogin'");
    paramT.mQQLoginBtn = ((ImageButton)paramFinder.castView(localView, 2131558684, "field 'mQQLoginBtn'", ImageButton.class));
    this.g = localView;
    localView.setOnClickListener(new ah(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131558685, "field 'mWechatLoginBtn' and method 'mWechatLoginBtn'");
    paramT.mWechatLoginBtn = ((ImageButton)paramFinder.castView(localView, 2131558685, "field 'mWechatLoginBtn'", ImageButton.class));
    this.h = localView;
    localView.setOnClickListener(new ai(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131558686, "field 'mWeiboLoginBtn' and method 'mWeiboLogin'");
    paramT.mWeiboLoginBtn = ((ImageButton)paramFinder.castView(localView, 2131558686, "field 'mWeiboLoginBtn'", ImageButton.class));
    this.i = localView;
    localView.setOnClickListener(new aj(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131558673, "field 'mAboutBtn' and method 'about'");
    paramT.mAboutBtn = ((ImageButton)paramFinder.castView(localView, 2131558673, "field 'mAboutBtn'", ImageButton.class));
    this.j = localView;
    localView.setOnClickListener(new ak(this, paramT));
    paramT.mTitleBar = ((TitleBarView)paramFinder.findRequiredViewAsType(paramObject, 2131558682, "field 'mTitleBar'", TitleBarView.class));
    paramT.mMainLayout = paramFinder.findRequiredView(paramObject, 2131558671, "field 'mMainLayout'");
    localView = paramFinder.findRequiredView(paramObject, 2131558680, "method 'register'");
    this.k = localView;
    localView.setOnClickListener(new aa(this, paramT));
    localView = paramFinder.findRequiredView(paramObject, 2131558681, "method 'forgot'");
    this.l = localView;
    localView.setOnClickListener(new ab(this, paramT));
    paramFinder = paramFinder.findRequiredView(paramObject, 2131558670, "method 'hideIme'");
    this.m = paramFinder;
    paramFinder.setOnClickListener(new ac(this, paramT));
  }
  
  public void unbind()
  {
    LoginActivity localLoginActivity = this.a;
    if (localLoginActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLoginActivity.mTopLayout = null;
    localLoginActivity.mOtherLoginLayout = null;
    localLoginActivity.mAccountEditText = null;
    localLoginActivity.mPasswordEditText = null;
    localLoginActivity.mLoginBtn = null;
    localLoginActivity.mQQLoginBtn = null;
    localLoginActivity.mWechatLoginBtn = null;
    localLoginActivity.mWeiboLoginBtn = null;
    localLoginActivity.mAboutBtn = null;
    localLoginActivity.mTitleBar = null;
    localLoginActivity.mMainLayout = null;
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
    this.i.setOnClickListener(null);
    this.i = null;
    this.j.setOnClickListener(null);
    this.j = null;
    this.k.setOnClickListener(null);
    this.k = null;
    this.l.setOnClickListener(null);
    this.l = null;
    this.m.setOnClickListener(null);
    this.m = null;
    this.a = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */