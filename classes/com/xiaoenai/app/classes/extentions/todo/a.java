package com.xiaoenai.app.classes.extentions.todo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.TitleBarView;

public class a
  extends h
{
  private static String a;
  private static long b;
  private static com.xiaoenai.app.classes.extentions.todo.a.b d;
  private static Handler e;
  private boolean c = false;
  
  public static a a(FragmentActivity paramFragmentActivity, int paramInt, com.xiaoenai.app.classes.extentions.todo.a.b paramb, Handler paramHandler)
  {
    if ((a)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("NewTodoEditFragment") != null) {}
    a locala = new a();
    a = paramb.f();
    b = paramb.b();
    d = paramb;
    e = paramHandler;
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
    paramFragmentActivity.addToBackStack(null);
    paramFragmentActivity.setCustomAnimations(2130968595, 2130968597);
    paramFragmentActivity.add(paramInt, locala, "NewTodoEditFragment");
    paramFragmentActivity.commitAllowingStateLoss();
    return locala;
  }
  
  public static void a(FragmentActivity paramFragmentActivity)
  {
    a locala = (a)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("NewTodoEditFragment");
    if ((locala != null) && (locala.isAdded()))
    {
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
      paramFragmentActivity.setCustomAnimations(2130968596, 2130968597);
      paramFragmentActivity.remove(locala);
      paramFragmentActivity.commitAllowingStateLoss();
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    new com.xiaoenai.app.net.b(new g(this, getActivity(), paramBoolean, paramString)).a(Integer.valueOf(d.e()), paramString, null);
  }
  
  public static a b(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = (a)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("NewTodoEditFragment");
    if ((paramFragmentActivity != null) && (paramFragmentActivity.isAdded())) {
      return paramFragmentActivity;
    }
    return null;
  }
  
  public void a()
  {
    if ((!e()) && (this.c))
    {
      b();
      return;
    }
    a(getActivity());
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    EditText localEditText = super.h();
    if (a != null) {}
    for (paramView = a;; paramView = "")
    {
      localEditText.setText(paramView);
      super.i().setText(ak.e(b * 1000L));
      super.h().addTextChangedListener(new b(this));
      return;
    }
  }
  
  public void b()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(getActivity());
    localg.a(2131100898, new e(this));
    localg.b(2131099973, new f(this));
    localg.a(2131101543);
    localg.show();
  }
  
  protected void b(View paramView)
  {
    super.g().setLeftButtonClickListener(new c(this));
    super.g().setRightButtonClickListener(new d(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.a((TitleBarView)paramView.findViewById(2131558471));
    a(paramView);
    b(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */