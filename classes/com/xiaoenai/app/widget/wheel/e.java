package com.xiaoenai.app.widget.wheel;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

public class e
{
  private List<View> a;
  private List<View> b;
  private WheelView c;
  
  public e(WheelView paramWheelView)
  {
    this.c = paramWheelView;
  }
  
  private View a(List<View> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      View localView = (View)paramList.get(0);
      paramList.remove(0);
      return localView;
    }
    return null;
  }
  
  private List<View> a(View paramView, List<View> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new LinkedList();
    }
    ((List)localObject).add(paramView);
    return (List<View>)localObject;
  }
  
  private void a(View paramView, int paramInt)
  {
    int j = this.c.getViewAdapter().a();
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < j) {}
    }
    else
    {
      i = paramInt;
      if (!this.c.c())
      {
        this.b = a(paramView, this.b);
        return;
      }
    }
    while (i < 0) {
      i += j;
    }
    this.a = a(paramView, this.a);
  }
  
  public int a(LinearLayout paramLinearLayout, int paramInt, a parama)
  {
    int j = 0;
    int i = paramInt;
    if (j < paramLinearLayout.getChildCount())
    {
      int k;
      int m;
      if (!parama.a(paramInt))
      {
        a(paramLinearLayout.getChildAt(j), paramInt);
        paramLinearLayout.removeViewAt(j);
        k = j;
        m = i;
        if (j == 0)
        {
          m = i + 1;
          k = j;
        }
      }
      for (;;)
      {
        paramInt += 1;
        j = k;
        i = m;
        break;
        k = j + 1;
        m = i;
      }
    }
    return i;
  }
  
  public View a()
  {
    return a(this.a);
  }
  
  public View b()
  {
    return a(this.b);
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */