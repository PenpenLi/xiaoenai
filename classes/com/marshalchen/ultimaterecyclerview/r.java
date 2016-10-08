package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.marshalchen.ultimaterecyclerview.swipe.SwipeLayout;
import com.marshalchen.ultimaterecyclerview.swipe.SwipeLayout.c;
import com.marshalchen.ultimaterecyclerview.swipe.SwipeLayout.i;

public class r
  extends RecyclerView.ViewHolder
{
  public SwipeLayout a = null;
  public SwipeLayout.c b = null;
  public SwipeLayout.i c = null;
  public int d = -1;
  
  public r(View paramView)
  {
    super(paramView);
    this.a = ((SwipeLayout)paramView.findViewById(d.c.recyclerview_swipe));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */