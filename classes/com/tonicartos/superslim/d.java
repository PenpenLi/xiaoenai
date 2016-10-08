package com.tonicartos.superslim;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;

public class d
{
  public final RecyclerView.Recycler a;
  public final SparseArray<View> b;
  public final boolean c;
  private final RecyclerView.State d;
  
  public d(RecyclerView.LayoutManager paramLayoutManager, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    this.b = new SparseArray(paramLayoutManager.getChildCount());
    this.d = paramState;
    this.a = paramRecycler;
    if (paramLayoutManager.getLayoutDirection() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      return;
    }
  }
  
  public RecyclerView.State a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.b.remove(paramInt);
  }
  
  public void a(int paramInt, View paramView)
  {
    this.b.put(paramInt, paramView);
  }
  
  public View b(int paramInt)
  {
    return (View)this.b.get(paramInt);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.b.size())
    {
      this.a.recycleView((View)this.b.valueAt(i));
      i += 1;
    }
  }
  
  public a c(int paramInt)
  {
    View localView2 = b(paramInt);
    if (localView2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      View localView1 = localView2;
      if (localView2 == null) {
        localView1 = this.a.getViewForPosition(paramInt);
      }
      return new a(localView1, bool);
    }
  }
  
  public static class a
  {
    public final View a;
    public final boolean b;
    
    public a(View paramView, boolean paramBoolean)
    {
      this.a = paramView;
      this.b = paramBoolean;
    }
    
    public LayoutManager.LayoutParams a()
    {
      return (LayoutManager.LayoutParams)this.a.getLayoutParams();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tonicartos\superslim\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */