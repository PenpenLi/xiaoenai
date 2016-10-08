package com.xiaoenai.app.classes.street.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.handmark.pulltorefresh.library.PullToRefreshBase.c;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.common.a.a;
import com.xiaoenai.app.classes.common.a.b;
import com.xiaoenai.app.classes.street.d.t;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.model.Order.OnOrderOpListener;
import com.xiaoenai.app.classes.street.widget.StreetOrderListItemLayout;
import com.xiaoenai.app.net.ae;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ab;
import java.util.ArrayList;

public class g
  extends BaseAdapter
  implements PullToRefreshBase.c
{
  public ArrayList<t> a = new ArrayList();
  private Context b;
  private PullToRefreshListView c;
  private boolean d = true;
  private int e = 0;
  private Handler f;
  private Order.OnOrderOpListener g = null;
  private ArrayList<Order> h = new ArrayList();
  
  public g(Context paramContext, int paramInt, Handler paramHandler)
  {
    this.b = paramContext;
    this.e = paramInt;
    this.f = paramHandler;
    this.g = f();
  }
  
  private m a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return new i(this, this.b, paramInt1, paramBoolean, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, m paramm)
  {
    new ae(paramm).a(paramInt1, paramInt2, paramInt3);
  }
  
  private void a(int paramInt1, int paramInt2, m paramm)
  {
    new ae(paramm).a(paramInt1, paramInt2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = 0;
      while (i < this.h.size())
      {
        ((Order)this.h.get(i)).setIsShowCheckBtn(true);
        i += 1;
      }
    }
  }
  
  private Order.OnOrderOpListener f()
  {
    return new h(this);
  }
  
  private void g(int paramInt)
  {
    this.h.remove(paramInt);
    notifyDataSetChanged();
    b localb = new b();
    Bundle localBundle = new Bundle();
    localBundle.putInt("order_size_keys", this.h.size());
    localb.a(localBundle);
    a.a().a(835L, localb);
  }
  
  public void a()
  {
    if (this.d)
    {
      if (this.e != 0) {
        break label23;
      }
      a(c());
    }
    label23:
    do
    {
      return;
      if (this.e == 1)
      {
        b(c());
        return;
      }
      if (this.e == 2)
      {
        c(c());
        return;
      }
      if (this.e == 3)
      {
        d(c());
        return;
      }
      if (this.e == 4)
      {
        e(c());
        return;
      }
    } while (this.e != 5);
    f(getCount());
  }
  
  public void a(int paramInt)
  {
    a(0, paramInt, 20, a(paramInt, false, 0));
  }
  
  public void a(PullToRefreshListView paramPullToRefreshListView)
  {
    this.c = paramPullToRefreshListView;
  }
  
  public void a(ArrayList<Order> paramArrayList, boolean paramBoolean)
  {
    this.h = paramArrayList;
    a(paramBoolean);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        ((t)this.a.get(i)).c();
        i += 1;
      }
      this.a.clear();
    }
  }
  
  public void b(int paramInt)
  {
    a(1, paramInt, 20, a(paramInt, true, 1));
  }
  
  public void b(ArrayList<Order> paramArrayList, boolean paramBoolean)
  {
    this.h.addAll(paramArrayList);
    a(paramBoolean);
    notifyDataSetChanged();
  }
  
  public int c()
  {
    return this.h.size();
  }
  
  public void c(int paramInt)
  {
    a(2, paramInt, 20, a(paramInt, false, 2));
  }
  
  public void d()
  {
    if (this.c != null)
    {
      this.c.setRefreshing(true);
      this.d = true;
    }
  }
  
  public void d(int paramInt)
  {
    a(3, paramInt, 20, a(paramInt, false, 3));
  }
  
  public void e()
  {
    this.d = true;
  }
  
  public void e(int paramInt)
  {
    a(4, paramInt, 20, a(paramInt, false, 4));
  }
  
  public void f(int paramInt)
  {
    a(paramInt, 20, a(paramInt, false, 0));
  }
  
  public int getCount()
  {
    int j = this.h.size();
    int i = j;
    if (this.d)
    {
      i = j;
      if (j >= 20) {
        i = j + 1;
      }
    }
    j = i;
    if (i > 0)
    {
      j = i;
      if (this.e == 1) {
        j = i + 1;
      }
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    return this.h.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt == getCount() - 1) && (this.e == 1) && (!this.d))
    {
      paramView = new LinearLayout(this.b);
      paramViewGroup = new View(this.b);
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, ab.a(50.0F)));
      ((LinearLayout)paramView).addView(paramViewGroup);
      return paramView;
    }
    Object localObject;
    if ((this.d) && (((paramInt == getCount() - 2) && (this.e == 1)) || ((paramInt == getCount() - 1) && (paramInt >= 20))))
    {
      paramView = new LinearLayout(this.b);
      paramViewGroup = new ProgressBar(this.b);
      paramViewGroup.setIndeterminateDrawable(this.b.getResources().getDrawable(2130838790));
      localObject = new LinearLayout.LayoutParams(ab.a(25.0F), ab.a(25.0F));
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      ((LinearLayout.LayoutParams)localObject).topMargin = ab.a(5.0F);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = ab.a(5.0F);
      ((LinearLayout.LayoutParams)localObject).leftMargin = ab.a(5.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = ab.a(5.0F);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.setPadding(5, 5, 5, 5);
      ((LinearLayout)paramView).setGravity(17);
      ((LinearLayout)paramView).addView(paramViewGroup);
      return paramView;
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = new LinearLayout(this.b);
      ((LinearLayout)paramView).setOrientation(1);
      paramViewGroup = new StreetOrderListItemLayout(this.b);
      ((LinearLayout)paramView).addView(paramViewGroup);
      localObject = new View(this.b);
      ((LinearLayout)paramView).addView((View)localObject, new LinearLayout.LayoutParams(-1, (int)this.b.getResources().getDimension(2131230891)));
      ((View)localObject).setBackgroundColor(this.b.getResources().getColor(2131493020));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = new t(paramViewGroup, (Order)getItem(paramInt), this.g, paramInt, this.f);
      paramViewGroup.a();
      this.a.add(paramViewGroup);
      return paramView;
      paramViewGroup = (StreetOrderListItemLayout)paramView.getTag();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */