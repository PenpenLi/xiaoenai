package com.xiaoenai.app.classes.common.mvp.view.a;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView.c;
import com.marshalchen.ultimaterecyclerview.e;
import com.xiaoenai.app.ui.component.view.ProgressView;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.List;

public abstract class a<T>
  extends com.xiaoenai.app.common.view.a.a
  implements UltimateRecyclerView.c, com.xiaoenai.app.classes.common.mvp.view.b<T>
{
  public void a()
  {
    g().i_().a.setBackgroundColor(0);
    g().i_().setHasFixedSize(true);
    g().i_().setClipToPadding(true);
    g().i_().setSaveEnabled(false);
    g().i_().setOnLoadMoreListener(this);
    g().i_().e();
    g().i_().e.setBackgroundColor(0);
    g().i_().a.setPtrHandler(new b(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    com.xiaoenai.app.utils.f.a.c("reqData loadMore {}", new Object[] { Integer.valueOf(paramInt1) });
    g().i_().postDelayed(new c(this), 1000L);
  }
  
  public void a(List<T> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g().d().c(paramList);
      return;
    }
    g().d().a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g().i_().a(g().d().d());
      return;
    }
    g().i_().f();
  }
  
  public void b()
  {
    if (g().i_().getAdapter() == null) {
      g().i_().setAdapter(g().d());
    }
    g().f().d();
  }
  
  public void b(List<T> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g().d().d(paramList);
      return;
    }
    g().d().b(paramList);
  }
  
  public Context c()
  {
    return getActivity();
  }
  
  public abstract com.xiaoenai.app.classes.common.mvp.view.c<T> g();
  
  public void h() {}
  
  public void h_()
  {
    g().i_().setVisibility(8);
    g().e().a();
  }
  
  public void i() {}
  
  public void j_()
  {
    g().e().b();
    g().i_().setVisibility(0);
    g().i_().a.d();
  }
  
  public boolean k_()
  {
    return (!isAdded()) && (getActivity().isFinishing());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g().f().f();
  }
  
  public void onResume()
  {
    super.onResume();
    g().f().e();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\mvp\view\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */