package com.xiaoenai.app.classes.common.mvp.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView.c;
import com.marshalchen.ultimaterecyclerview.e;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.mvp.view.c;
import com.xiaoenai.app.ui.component.view.ProgressView;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.List;

public abstract class BaseListActivity<T>
  extends TitleBarActivity
  implements UltimateRecyclerView.c, com.xiaoenai.app.classes.common.mvp.view.b<T>
{
  public void a(int paramInt1, int paramInt2)
  {
    com.xiaoenai.app.utils.f.a.c("reqData loadMore {}", new Object[] { Integer.valueOf(paramInt1) });
    i().i_().postDelayed(new b(this), 1000L);
  }
  
  public void a(List<T> paramList, boolean paramBoolean)
  {
    e locale = i().d();
    if (paramBoolean)
    {
      locale.c(paramList);
      return;
    }
    locale.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i().i_().a(i().d().d());
      return;
    }
    i().i_().f();
  }
  
  public void b(List<T> paramList, boolean paramBoolean)
  {
    e locale = i().d();
    if (paramBoolean)
    {
      locale.d(paramList);
      return;
    }
    locale.b(paramList);
  }
  
  public Context c()
  {
    return this;
  }
  
  public void g()
  {
    i().i_().a.setBackgroundColor(0);
    i().i_().setHasFixedSize(true);
    i().i_().setClipToPadding(true);
    i().i_().setSaveEnabled(false);
    i().i_().setOnLoadMoreListener(this);
    i().i_().e.setBackgroundColor(0);
    i().i_().e();
    i().i_().a.setPtrHandler(new a(this));
  }
  
  public void h()
  {
    if (i().i_().getAdapter() == null) {
      i().i_().setAdapter(i().d());
    }
    i().f().d();
  }
  
  public void h_()
  {
    i().i_().setVisibility(8);
    i().e().a();
  }
  
  public abstract c<T> i();
  
  public abstract void j();
  
  public void j_()
  {
    i().e().b();
    i().i_().setVisibility(0);
    i().i_().a.d();
  }
  
  public boolean k_()
  {
    return isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j();
    g();
    h();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    i().f().f();
  }
  
  protected void onResume()
  {
    super.onResume();
    i().f().e();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\mvp\view\activity\BaseListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */