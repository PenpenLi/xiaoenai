package com.xiaoenai.app.classes.chat.input.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.input.InputFragment;

public class a
  extends com.xiaoenai.app.common.view.a.a
{
  private ChatActivity a;
  private View b = null;
  private int c = 0;
  
  public static a a(FragmentActivity paramFragmentActivity)
  {
    return (a)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("PlusFragment");
  }
  
  public static void a(InputFragment paramInputFragment)
  {
    Object localObject = paramInputFragment.getActivity();
    if (localObject != null)
    {
      i.a(paramInputFragment);
      paramInputFragment = (a)((FragmentActivity)localObject).getSupportFragmentManager().findFragmentByTag("PlusFragment");
      if ((paramInputFragment != null) && (paramInputFragment.isAdded()))
      {
        localObject = ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject).hide(paramInputFragment);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
    }
  }
  
  public static void a(InputFragment paramInputFragment, int paramInt1, int paramInt2)
  {
    com.xiaoenai.app.utils.f.a.c("PlusFragment show", new Object[0]);
    FragmentActivity localFragmentActivity = paramInputFragment.getActivity();
    a locala = (a)localFragmentActivity.getSupportFragmentManager().findFragmentByTag("PlusFragment");
    FragmentTransaction localFragmentTransaction = localFragmentActivity.getSupportFragmentManager().beginTransaction();
    if (locala == null)
    {
      locala = new a();
      localFragmentTransaction.add(paramInt1, locala, "PlusFragment");
    }
    for (;;)
    {
      locala.a(paramInt2);
      localFragmentTransaction.commitAllowingStateLoss();
      paramInputFragment.a(locala);
      return;
      Fragment localFragment = localFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt1);
      if ((localFragment != null) && (!a(localFragmentActivity, paramInt1))) {
        localFragmentTransaction.hide(localFragment);
      }
      localFragmentTransaction.show(locala);
    }
  }
  
  public static boolean a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt);
    return (paramFragmentActivity != null) && ((paramFragmentActivity instanceof a));
  }
  
  public void a(int paramInt)
  {
    if (this.b != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
      if (paramInt != localLayoutParams.height)
      {
        localLayoutParams.height = paramInt;
        this.b.setLayoutParams(localLayoutParams);
      }
    }
    this.c = paramInt;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = ((ChatActivity)paramActivity);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2130903108, paramViewGroup, false);
    if (this.c > 0) {
      this.b.getLayoutParams().height = this.c;
    }
    return this.b;
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.a = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((ImageButton)paramView.findViewById(2131558818)).setOnClickListener(new b(this));
    ((ImageButton)paramView.findViewById(2131558819)).setOnClickListener(new c(this));
    ((ImageButton)paramView.findViewById(2131558820)).setOnClickListener(new d(this));
    ((ImageButton)paramView.findViewById(2131558822)).setOnClickListener(new e(this));
    ((ImageButton)paramView.findViewById(2131558821)).setOnClickListener(new f(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */