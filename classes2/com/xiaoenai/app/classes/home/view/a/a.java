package com.xiaoenai.app.classes.home.view.a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaoenai.app.classes.home.model.HomeDiscoverItem;
import com.xiaoenai.app.classes.home.view.viewHolder.LifeServiceItemViewHolder;
import com.xiaoenai.app.classes.home.view.viewHolder.LifeServiceItemViewHolder.a;
import java.util.List;

public class a
  extends RecyclerView.Adapter
{
  private LifeServiceItemViewHolder.a a;
  private List<HomeDiscoverItem> b;
  
  public a(LifeServiceItemViewHolder.a parama)
  {
    this.a = parama;
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public void a(List<HomeDiscoverItem> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.b != null)
    {
      if (this.b.size() % 4 > 0) {
        return this.b.size() + 1;
      }
      return this.b.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((a() % 4 > 0) && (paramInt == getItemCount() - 1))
    {
      ((LifeServiceItemViewHolder)paramViewHolder).a(null);
      return;
    }
    ((LifeServiceItemViewHolder)paramViewHolder).a((HomeDiscoverItem)this.b.get(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new LifeServiceItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903264, null), this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */