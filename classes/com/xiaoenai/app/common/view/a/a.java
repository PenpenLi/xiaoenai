package com.xiaoenai.app.common.view.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaoenai.app.common.internal.di.a.v.a;
import com.xiaoenai.app.common.internal.di.a.x;
import com.xiaoenai.app.common.view.activity.BaseActivity;
import com.xiaoenai.app.common.view.b.c;
import javax.inject.Inject;

public abstract class a
  extends Fragment
{
  private x a;
  private final String b = getClass().getSimpleName();
  @Inject
  protected c e;
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.e.c(this);
    com.xiaoenai.app.utils.f.a.c("{}:onActivityCreated", new Object[] { this.b });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.xiaoenai.app.utils.f.a.c("{}:onActivityResult", new Object[] { this.b });
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    com.xiaoenai.app.utils.f.a.c("{}:onAttach", new Object[] { this.b });
    r();
    this.e.d(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    com.xiaoenai.app.utils.f.a.c("{}:onConfigurationChanged", new Object[] { this.b });
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e.a(this);
    com.xiaoenai.app.utils.f.a.c("{}:onCreate", new Object[] { this.b });
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    com.xiaoenai.app.utils.f.a.c("{}:onCreateContextMenu", new Object[] { this.b });
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.e.b(this);
    com.xiaoenai.app.utils.f.a.c("{}:onActivityCreated", new Object[] { this.b });
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.e(this);
    com.xiaoenai.app.utils.f.a.c("{}:onDestroy", new Object[] { this.b });
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.e.j(this);
    com.xiaoenai.app.utils.f.a.c("{}:onDestroyView", new Object[] { this.b });
  }
  
  public void onDetach()
  {
    super.onDetach();
    com.xiaoenai.app.utils.f.a.c("{}:onDetach", new Object[] { this.b });
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    com.xiaoenai.app.utils.f.a.c("{}:onLowMemory", new Object[] { this.b });
  }
  
  public void onPause()
  {
    super.onPause();
    this.e.g(this);
    com.xiaoenai.app.utils.f.a.c("{}:onPause", new Object[] { this.b });
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    com.xiaoenai.app.utils.f.a.c("onRequestPermissionsResult", new Object[0]);
  }
  
  public void onResume()
  {
    super.onResume();
    this.e.f(this);
    com.xiaoenai.app.utils.f.a.c("{}:onResume", new Object[] { this.b });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    com.xiaoenai.app.utils.f.a.c("onSaveInstanceState", new Object[0]);
  }
  
  public void onStart()
  {
    super.onStart();
    this.e.h(this);
    com.xiaoenai.app.utils.f.a.c("{}:onStart", new Object[] { this.b });
  }
  
  public void onStop()
  {
    super.onStop();
    this.e.i(this);
    com.xiaoenai.app.utils.f.a.c("{}:onPause", new Object[] { this.b });
  }
  
  protected void r()
  {
    this.a = com.xiaoenai.app.common.internal.di.a.v.a().a(s()).a(t()).a();
    this.a.a(this);
  }
  
  protected com.xiaoenai.app.common.internal.di.a.a s()
  {
    return ((BaseActivity)getActivity()).B();
  }
  
  protected com.xiaoenai.app.common.internal.di.b.v t()
  {
    return new com.xiaoenai.app.common.internal.di.b.v(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\view\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */