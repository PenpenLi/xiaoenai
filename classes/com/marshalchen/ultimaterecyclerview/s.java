package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public abstract class s<VH extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<VH>
{
  protected View b = null;
  protected UltimateRecyclerView.a c = null;
  public boolean d = false;
  protected a e = null;
  
  public abstract int a();
  
  public abstract VH a(ViewGroup paramViewGroup);
  
  public void a(UltimateRecyclerView.a parama)
  {
    this.c = parama;
  }
  
  public <T> void a(List<T> paramList, T paramT, int paramInt)
  {
    paramList.add(paramInt, paramT);
    int i = paramInt;
    if (this.c != null) {
      i = paramInt + 1;
    }
    notifyItemInserted(i);
  }
  
  public abstract VH b(View paramView);
  
  public void c(View paramView)
  {
    this.b = paramView;
  }
  
  public View d()
  {
    return this.b;
  }
  
  public void d(View paramView)
  {
    this.b = paramView;
    this.d = true;
  }
  
  protected boolean e()
  {
    return this.c != null;
  }
  
  public int getItemCount()
  {
    int i = 0;
    if (this.c != null) {
      i = 1;
    }
    int j = i;
    if (this.b != null) {
      j = i + 1;
    }
    return j + a();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == getItemCount() - 1) && (this.b != null))
    {
      if (this.d) {
        return 3;
      }
      return 2;
    }
    if ((paramInt == 0) && (this.c != null)) {
      return 1;
    }
    return 0;
  }
  
  public VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder;
    if (paramInt == 2)
    {
      localViewHolder = b(this.b);
      paramViewGroup = localViewHolder;
      if (a() == 0)
      {
        localViewHolder.itemView.setVisibility(8);
        paramViewGroup = localViewHolder;
      }
    }
    do
    {
      return paramViewGroup;
      if (paramInt == 1)
      {
        if (this.c == null) {
          break;
        }
        return b(this.c);
      }
      if (paramInt != 3) {
        break;
      }
      localViewHolder = b(this.b);
      paramViewGroup = localViewHolder;
    } while (a() != 0);
    localViewHolder.itemView.setVisibility(8);
    return localViewHolder;
    return a(paramViewGroup);
  }
  
  public static abstract interface a {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */