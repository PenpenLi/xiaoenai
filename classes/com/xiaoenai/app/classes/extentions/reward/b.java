package com.xiaoenai.app.classes.extentions.reward;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;

public class b
  extends BaseAdapter
{
  private Object[] a;
  private Context b;
  
  public b(Object[] paramArrayOfObject, Context paramContext)
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
    if (this.a != null) {
      return this.a.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a != null) {
      return this.a[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new RewardView(this.b);
      paramView.setTag(paramView);
    }
    for (;;)
    {
      c.a((BaseTask)getItem(paramInt), (RewardView)paramView, this.b);
      return paramView;
      paramView = (View)paramView.getTag();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\reward\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */