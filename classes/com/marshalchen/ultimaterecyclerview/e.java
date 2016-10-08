package com.marshalchen.ultimaterecyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.xiaoenai.app.utils.ab;
import java.util.ArrayList;
import java.util.List;

public abstract class e<T>
  extends s<f>
{
  protected List<T> a;
  
  public e(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    ProgressBar localProgressBar = new ProgressBar(paramContext);
    localProgressBar.setIndeterminateDrawable(paramContext.getResources().getDrawable(2130838790));
    paramContext = new LinearLayout.LayoutParams(ab.a(25.0F), ab.a(25.0F));
    paramContext.gravity = 17;
    paramContext.topMargin = ab.a(5.0F);
    paramContext.bottomMargin = ab.a(5.0F);
    paramContext.leftMargin = ab.a(5.0F);
    paramContext.rightMargin = ab.a(5.0F);
    localProgressBar.setLayoutParams(paramContext);
    localLinearLayout.setPadding(5, 5, 5, 5);
    localLinearLayout.setGravity(17);
    localLinearLayout.addView(localProgressBar);
    localLinearLayout.setBackgroundColor(0);
    this.b = localLinearLayout;
    paramContext = new RecyclerView.LayoutParams(-1, -2);
    this.b.setLayoutParams(paramContext);
  }
  
  public int a()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public f a(View paramView)
  {
    return new f(paramView);
  }
  
  public void a(int paramInt, List<T> paramList)
  {
    if (this.a != null) {
      this.a.addAll(paramInt, paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.a = paramList;
    }
  }
  
  public abstract void a(f paramf, int paramInt);
  
  public void a(T paramT, int paramInt)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    a(this.a, paramT, paramInt);
  }
  
  public void a(List<T> paramList)
  {
    if (paramList != null)
    {
      this.a = paramList;
      notifyDataSetChanged();
    }
  }
  
  public List<T> b()
  {
    return this.a;
  }
  
  public void b(List<T> paramList)
  {
    if (paramList != null) {
      this.a = paramList;
    }
  }
  
  public void c()
  {
    this.a = null;
    notifyDataSetChanged();
  }
  
  public void c(List<T> paramList)
  {
    if (this.a != null) {
      this.a.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.a = paramList;
    }
  }
  
  public void d(List<T> paramList)
  {
    if (this.a != null) {
      this.a.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.a = paramList;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */