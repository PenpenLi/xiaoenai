package com.xiaoenai.app.classes.street;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.common.a.a;
import com.xiaoenai.app.classes.street.a.g;

public class StreetOrderAfterSaleActivity
  extends StreetBaseActivity
{
  private PullToRefreshListView a;
  private g b;
  private LinearLayout c;
  
  private void c()
  {
    this.a = ((PullToRefreshListView)findViewById(2131559913));
    this.b = new g(this, 5, null);
    this.c = ((LinearLayout)findViewById(2131559914));
    this.a.setAdapter(this.b);
    this.b.a(this.a);
  }
  
  private void d()
  {
    a.a().a(835L, new cm(this));
  }
  
  private void f()
  {
    this.a.setOnRefreshListener(new cn(this));
    this.b.d();
  }
  
  public int a()
  {
    return 2130903348;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    d();
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a.a().a(835L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\StreetOrderAfterSaleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */