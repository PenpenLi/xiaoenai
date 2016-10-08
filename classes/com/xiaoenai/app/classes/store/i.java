package com.xiaoenai.app.classes.store;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.xiaoenai.app.classes.store.sticker.Sticker;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;

public class i
  extends BaseAdapter
{
  private Object[] a;
  private Context b;
  
  public i(Object[] paramArrayOfObject, Context paramContext)
  {
    this.a = paramArrayOfObject;
    this.b = paramContext;
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    this.a = paramArrayOfObject;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.a.length;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      int i = ab.a(60);
      paramViewGroup = new AbsListView.LayoutParams(i, i);
      paramView = new ImageView(this.b);
      paramView.setLayoutParams(paramViewGroup);
      paramView.setTag(paramView);
    }
    for (;;)
    {
      paramView.setBackgroundResource(2131493177);
      b.a((ImageView)paramView, ((Sticker)this.a[paramInt]).getUrl() + "?format/png", new j(this));
      return paramView;
      paramView = (View)paramView.getTag();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */