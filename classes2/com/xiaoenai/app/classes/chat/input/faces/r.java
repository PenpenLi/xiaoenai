package com.xiaoenai.app.classes.chat.input.faces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.input.InputFragment;
import com.xiaoenai.app.classes.chat.input.InputFragment.a;
import com.xiaoenai.app.classes.store.StickerActivity;
import com.xiaoenai.app.utils.b;
import java.util.ArrayList;
import java.util.Iterator;

public class r
  extends com.xiaoenai.app.common.view.a.a
  implements InputFragment.a, FaceFragmentBottomBar.a
{
  public static int a = 2;
  private FragmentTabHost b;
  private FaceFragmentBottomBar c;
  private TabWidget d;
  private ArrayList<String> f = new ArrayList();
  private View g = null;
  private int h = 0;
  
  private int a()
  {
    Iterator localIterator = b.a().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.f.contains(str)) {
        break label66;
      }
      this.f.add(str);
      a(b.e(str), str);
      i += 1;
    }
    label66:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static void a(InputFragment paramInputFragment)
  {
    Object localObject = paramInputFragment.getActivity();
    paramInputFragment = (r)((FragmentActivity)localObject).getSupportFragmentManager().findFragmentByTag("FacesFragment");
    if ((paramInputFragment != null) && (paramInputFragment.isAdded()))
    {
      localObject = ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).hide(paramInputFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public static void a(InputFragment paramInputFragment, int paramInt1, int paramInt2)
  {
    FragmentActivity localFragmentActivity = paramInputFragment.getActivity();
    r localr = (r)localFragmentActivity.getSupportFragmentManager().findFragmentByTag("FacesFragment");
    FragmentTransaction localFragmentTransaction = localFragmentActivity.getSupportFragmentManager().beginTransaction();
    if (localr == null)
    {
      localr = new r();
      localFragmentTransaction.add(paramInt1, localr, "FacesFragment");
    }
    for (;;)
    {
      localr.b(paramInt2);
      localFragmentTransaction.commitAllowingStateLoss();
      paramInputFragment.a(localr);
      return;
      Fragment localFragment = localFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt1);
      if ((localFragment != null) && (!a(localFragmentActivity, paramInt1))) {
        localFragmentTransaction.hide(localFragment);
      }
      localFragmentTransaction.show(localr);
    }
  }
  
  private void a(ArrayList<String> paramArrayList, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("url-list", paramArrayList);
    localBundle.putString("faceName", paramString);
    paramArrayList = b.d(paramString);
    paramArrayList = paramArrayList + "/" + "tab_icon.png";
    this.c.a(paramArrayList);
    this.b.addTab(this.b.newTabSpec(paramString).setIndicator(paramString), a.class, localBundle);
  }
  
  public static boolean a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().findFragmentById(paramInt);
    return (paramFragmentActivity != null) && ((paramFragmentActivity instanceof r));
  }
  
  private void b(boolean paramBoolean)
  {
    ((ChatActivity)getActivity()).g_().d().setCursorVisible(paramBoolean);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      Intent localIntent = new Intent(getActivity(), StickerActivity.class);
      localIntent.putExtra("from", "FacesFragment");
      getActivity().startActivity(localIntent);
      getActivity().overridePendingTransition(2130968608, 2130968609);
      return;
    }
    if (paramInt < 3)
    {
      a = paramInt;
      this.b.setCurrentTab(paramInt - 1);
      if (a == 2)
      {
        b(true);
        return;
      }
      b(false);
      return;
    }
    a = paramInt;
    paramInt = this.c.getTabCount();
    int i = a;
    this.b.setCurrentTab(paramInt - i + 2 - 1);
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.setEditTextChange(paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.g != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.g.getLayoutParams();
      if (paramInt != localLayoutParams.height)
      {
        localLayoutParams.height = paramInt;
        this.g.setLayoutParams(localLayoutParams);
      }
    }
    this.h = paramInt;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903105, paramViewGroup, false);
    if (this.h > 0) {
      paramLayoutInflater.getLayoutParams().height = this.h;
    }
    this.b = ((FragmentTabHost)paramLayoutInflater.findViewById(16908306));
    this.b.setup(getActivity(), getChildFragmentManager(), 2131558806);
    this.c = ((FaceFragmentBottomBar)paramLayoutInflater.findViewById(2131558805));
    this.d = ((TabWidget)paramLayoutInflater.findViewById(16908307));
    this.d.setVisibility(8);
    this.b.addTab(this.b.newTabSpec("recent").setIndicator("recent"), v.class, null);
    this.b.addTab(this.b.newTabSpec("classic").setIndicator("classic"), f.class, null);
    this.c.setOnTabSelectedListener(this);
    this.c.setFaceSendBtnListener(new s(this));
    ((ChatActivity)getActivity()).g_().a(this);
    this.g = paramLayoutInflater;
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b = null;
    if (((ChatActivity)getActivity()).g_() != null) {
      ((ChatActivity)getActivity()).g_().a(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    int i = a();
    if ((i > 0) && (a > 2)) {
      a = i + a;
    }
    FaceFragmentBottomBar localFaceFragmentBottomBar;
    if (a == 0)
    {
      this.c.a(2);
      this.b.setCurrentTab(1);
      if ((a == 2) && (((ChatActivity)getActivity()).g_().d() != null))
      {
        localFaceFragmentBottomBar = this.c;
        if (((ChatActivity)getActivity()).g_().d().getText().toString().length() > 0) {
          break label216;
        }
      }
    }
    label216:
    for (boolean bool = true;; bool = false)
    {
      localFaceFragmentBottomBar.setEditTextChange(bool);
      this.c.a();
      return;
      if (a < 3)
      {
        this.c.a(a);
        this.b.setCurrentTab(a - 1);
        if (a == 2)
        {
          b(true);
          break;
        }
        b(false);
        break;
      }
      i = this.c.getTabCount();
      int j = a;
      this.c.a(a);
      this.b.setCurrentTab(i - j + 2 - 1);
      b(false);
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */