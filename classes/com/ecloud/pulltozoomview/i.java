package com.ecloud.pulltozoomview;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class i<V extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<V>
{
  private final List<a> a;
  
  public a a(int paramInt)
  {
    if ((this.a != null) && (this.a.size() > paramInt)) {
      return (a)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(a parama)
  {
    this.a.add(parama);
    notifyItemInserted(this.a.size());
  }
  
  public void b(a parama)
  {
    int i = this.a.indexOf(parama);
    if (i >= 0)
    {
      this.a.remove(i);
      notifyItemRemoved(i);
    }
  }
  
  public static class a<V extends RecyclerView.ViewHolder>
  {
    public final int a;
    public final V b;
    
    public a(int paramInt, V paramV)
    {
      this.a = paramInt;
      this.b = paramV;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */