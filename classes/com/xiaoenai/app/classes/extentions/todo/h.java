package com.xiaoenai.app.classes.extentions.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.b;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.TitleBarView;

public class h
  extends Fragment
{
  private InputMethodManager a;
  private TitleBarView b;
  private EditText c;
  private TextView d;
  private TextView e;
  private com.xiaoenai.app.ui.a.h f;
  
  private void a(String paramString)
  {
    new b(new l(this, getActivity(), paramString)).b(paramString);
  }
  
  public static void c(FragmentActivity paramFragmentActivity)
  {
    h localh = (h)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("NewTodoFragment");
    if ((localh != null) && (localh.isAdded()))
    {
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
      paramFragmentActivity.setCustomAnimations(2130968602, 2130968603);
      paramFragmentActivity.remove(localh);
      paramFragmentActivity.commitAllowingStateLoss();
    }
  }
  
  public static boolean d(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = (h)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("NewTodoFragment");
    return (paramFragmentActivity != null) && (paramFragmentActivity.isAdded()) && (paramFragmentActivity.e());
  }
  
  public static h e(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = (h)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("NewTodoFragment");
    if ((paramFragmentActivity != null) && (paramFragmentActivity.isAdded())) {
      return paramFragmentActivity;
    }
    return null;
  }
  
  protected void a(View paramView)
  {
    this.d = ((TextView)paramView.findViewById(2131559178));
    this.e = ((TextView)paramView.findViewById(2131559179));
    String str2 = User.getInstance().getNickName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equalsIgnoreCase("")) {}
    }
    else
    {
      str1 = User.getInstance().getUserName();
    }
    this.d.setText(str1);
    this.e.setText(ak.e(ak.a()));
    this.c = ((EditText)paramView.findViewById(2131559181));
  }
  
  public void a(TitleBarView paramTitleBarView)
  {
    this.b = paramTitleBarView;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.f = com.xiaoenai.app.ui.a.h.a(getActivity());
    this.f.setCancelable(paramBoolean);
    this.f.show();
  }
  
  public void b()
  {
    if ((this.f == null) || (!this.f.isShowing()))
    {
      g localg = new g(getActivity());
      localg.a(2131100898, new m(this));
      localg.b(2131099973, new n(this));
      localg.a(2131101543);
      localg.show();
    }
  }
  
  protected void b(View paramView)
  {
    this.b = ((TitleBarView)paramView.findViewById(2131558471));
    this.b.setLeftButtonClickListener(new j(this));
    this.b.setRightButtonClickListener(new k(this));
  }
  
  protected boolean e()
  {
    String str = this.c.getText().toString();
    return (str == null) || (str.equalsIgnoreCase(""));
  }
  
  protected void f()
  {
    if ((this.f != null) && (this.f.isShowing())) {
      this.f.dismiss();
    }
  }
  
  public TitleBarView g()
  {
    return this.b;
  }
  
  public EditText h()
  {
    return this.c;
  }
  
  public TextView i()
  {
    return this.e;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903189, paramViewGroup, false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.c.requestFocus();
    this.c.postDelayed(new i(this), 500L);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    b(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */