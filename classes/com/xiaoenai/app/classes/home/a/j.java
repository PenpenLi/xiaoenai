package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xiaoenai.app.classes.home.model.HomeDiscoverBaseItem;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.home.model.HomeLifeServiceItem;
import com.xiaoenai.app.classes.home.view.HomeDiscoverItemView;
import com.xiaoenai.app.classes.home.view.LifeServiceLayout;
import com.xiaoenai.app.classes.home.view.viewHolder.LifeServiceItemViewHolder.a;
import com.xiaoenai.app.utils.ab;
import java.util.List;

public class j
  extends BaseAdapter
{
  private List<HomeDiscoverBaseItem> a;
  private Context b = null;
  private LifeServiceItemViewHolder.a c;
  
  public j(Context paramContext, LifeServiceItemViewHolder.a parama)
  {
    this.b = paramContext;
    this.c = parama;
  }
  
  private View a(int paramInt)
  {
    View localView = new View(this.b);
    if (paramInt == 0) {}
    for (paramInt = ab.a(15.0F);; paramInt = ab.a(20.0F))
    {
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, paramInt));
      return localView;
    }
  }
  
  private int b(int paramInt)
  {
    if (paramInt > 0) {}
    for (HomeDiscoverBaseItem localHomeDiscoverBaseItem1 = (HomeDiscoverBaseItem)getItem(paramInt - 1);; localHomeDiscoverBaseItem1 = null)
    {
      if (paramInt < getCount() - 1) {}
      for (HomeDiscoverBaseItem localHomeDiscoverBaseItem2 = (HomeDiscoverBaseItem)getItem(paramInt + 1);; localHomeDiscoverBaseItem2 = null)
      {
        if ((localHomeDiscoverBaseItem1 != null) && (1 == localHomeDiscoverBaseItem1.getType()) && ((localHomeDiscoverBaseItem2 == null) || ((localHomeDiscoverBaseItem2 != null) && (localHomeDiscoverBaseItem2.getType() != 0)))) {
          return 2;
        }
        if ((localHomeDiscoverBaseItem1 != null) && (1 == localHomeDiscoverBaseItem1.getType())) {
          return 0;
        }
        if ((localHomeDiscoverBaseItem2 != null) && ((1 == localHomeDiscoverBaseItem2.getType()) || (localHomeDiscoverBaseItem2.getType() != 0))) {
          return 1;
        }
        return 3;
      }
    }
  }
  
  public void a(List<HomeDiscoverBaseItem> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.a != null) {
      i = this.a.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a != null) && (paramInt < this.a.size()) && (paramInt >= 0)) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HomeDiscoverBaseItem localHomeDiscoverBaseItem = (HomeDiscoverBaseItem)getItem(paramInt);
    if (1 == localHomeDiscoverBaseItem.getType())
    {
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (paramView.getTag() == Integer.valueOf(localHomeDiscoverBaseItem.getType())) {}
      }
      else
      {
        paramViewGroup = new LinearLayout(this.b);
        paramView = a(paramInt);
        if (Build.VERSION.SDK_INT <= 15) {
          break label104;
        }
        paramViewGroup.setBackground(this.b.getResources().getDrawable(2130837828));
      }
      for (;;)
      {
        ((LinearLayout)paramViewGroup).addView(paramView);
        paramViewGroup.setTag(Integer.valueOf(localHomeDiscoverBaseItem.getType()));
        return paramViewGroup;
        label104:
        paramViewGroup.setBackgroundResource(2130837828);
      }
    }
    if (localHomeDiscoverBaseItem.getType() == 0)
    {
      HomeDiscoverItem localHomeDiscoverItem = (HomeDiscoverItem)localHomeDiscoverBaseItem;
      if ((paramView == null) || (paramView.getTag() != Integer.valueOf(localHomeDiscoverBaseItem.getType())))
      {
        localObject = new HomeDiscoverItemView(this.b);
        paramView = (View)localObject;
      }
      for (;;)
      {
        paramViewGroup = paramView;
        if (localHomeDiscoverItem == null) {
          break;
        }
        paramViewGroup = paramView;
        if (localObject == null) {
          break;
        }
        paramInt = b(paramInt);
        ((HomeDiscoverItemView)localObject).setDiscoverItem(localHomeDiscoverItem);
        ((HomeDiscoverItemView)localObject).a();
        ((HomeDiscoverItemView)localObject).setItemLine(paramInt);
        paramViewGroup = paramView;
        break;
        localObject = (HomeDiscoverItemView)paramView;
      }
    }
    Object localObject = (HomeLifeServiceItem)localHomeDiscoverBaseItem;
    if ((paramView == null) || (paramView.getTag() != Integer.valueOf(localHomeDiscoverBaseItem.getType())))
    {
      paramViewGroup = new LifeServiceLayout(this.b, this.c);
      paramView = paramViewGroup;
    }
    for (;;)
    {
      paramViewGroup.a(((HomeLifeServiceItem)localObject).getmLifeServiceItemList());
      paramViewGroup = paramView;
      break;
      paramViewGroup = (LifeServiceLayout)paramView;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */