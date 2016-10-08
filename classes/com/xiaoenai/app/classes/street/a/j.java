package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.c;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.common.a.a;
import com.xiaoenai.app.classes.common.a.b;
import java.util.ArrayList;

public class j
  extends PagerAdapter
{
  private Handler a;
  private Context b;
  private ArrayList<g> c;
  private SparseArray<View> d;
  private PullToRefreshBase.e<ListView> e = null;
  
  public j(Context paramContext, Handler paramHandler)
  {
    this.b = paramContext;
    this.a = paramHandler;
    this.c = new ArrayList();
    this.d = new SparseArray();
    c();
    this.e = b();
  }
  
  private PullToRefreshBase.e<ListView> b()
  {
    return new k(this);
  }
  
  private void c()
  {
    int i = 0;
    while (i < 6)
    {
      this.c.add(new g(this.b, i, this.a));
      i += 1;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    ((g)this.c.get(paramInt)).d();
  }
  
  public void b(int paramInt)
  {
    if (((g)this.c.get(paramInt)).c() <= 0) {
      ((g)this.c.get(paramInt)).d();
    }
    while (paramInt != 1) {
      return;
    }
    b localb = new b();
    Bundle localBundle = new Bundle();
    localBundle.putInt("order_size_keys", ((g)this.c.get(paramInt)).c());
    localb.a(localBundle);
    a.a().a(835L, localb);
  }
  
  public int c(int paramInt)
  {
    return ((g)this.c.get(paramInt)).c();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((g)this.c.get(paramInt)).b();
    ((g)this.c.get(paramInt)).a(null);
    paramObject = (View)paramObject;
    ((ViewPager)paramView).removeView((View)paramObject);
    this.d.remove(paramInt);
  }
  
  public int getCount()
  {
    return 6;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    PullToRefreshListView localPullToRefreshListView = (PullToRefreshListView)LayoutInflater.from(this.b).inflate(2130903278, null);
    ((ViewPager)paramView).addView(localPullToRefreshListView);
    localPullToRefreshListView.setAdapter((ListAdapter)this.c.get(paramInt));
    ((g)this.c.get(paramInt)).a(localPullToRefreshListView);
    localPullToRefreshListView.setOnLastItemVisibleListener((PullToRefreshBase.c)this.c.get(paramInt));
    localPullToRefreshListView.setOnRefreshListener(this.e);
    localPullToRefreshListView.setTag(Integer.valueOf(paramInt));
    this.d.put(paramInt, localPullToRefreshListView);
    return localPullToRefreshListView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */