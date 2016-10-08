package com.xiaoenai.app.classes.chat.input;

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
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.input.a.i;

public class l
  extends com.xiaoenai.app.common.view.a.a
{
  private ChatActivity a;
  private View b = null;
  private int c = 0;
  
  public static void a(InputFragment paramInputFragment)
  {
    Object localObject = paramInputFragment.getActivity();
    if (localObject != null)
    {
      i.a(paramInputFragment);
      paramInputFragment = (l)((FragmentActivity)localObject).getSupportFragmentManager().findFragmentByTag("KeyBoardFragment");
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
    com.xiaoenai.app.utils.f.a.c("KeyBoardFragment show", new Object[0]);
    FragmentActivity localFragmentActivity = paramInputFragment.getActivity();
    l locall = (l)localFragmentActivity.getSupportFragmentManager().findFragmentByTag("KeyBoardFragment");
    FragmentTransaction localFragmentTransaction = localFragmentActivity.getSupportFragmentManager().beginTransaction();
    if (locall == null)
    {
      locall = new l();
      localFragmentTransaction.add(paramInt1, locall, "KeyBoardFragment");
    }
    for (;;)
    {
      locall.a(paramInt2);
      localFragmentTransaction.commitAllowingStateLoss();
      paramInputFragment.a(locall);
      return;
      Fragment localFragment = localFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt1);
      if ((localFragment != null) && (!a(localFragmentActivity, paramInt1))) {
        localFragmentTransaction.hide(localFragment);
      }
      localFragmentTransaction.show(locall);
    }
  }
  
  public static boolean a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt);
    return (paramFragmentActivity != null) && ((paramFragmentActivity instanceof l));
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
    this.b = paramLayoutInflater.inflate(2130903107, paramViewGroup, false);
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
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */