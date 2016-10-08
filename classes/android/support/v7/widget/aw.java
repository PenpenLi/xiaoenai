package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

class aw
  implements z.b
{
  aw(RecyclerView paramRecyclerView) {}
  
  public int a()
  {
    return this.a.getChildCount();
  }
  
  public int a(View paramView)
  {
    return this.a.indexOfChild(paramView);
  }
  
  public void a(int paramInt)
  {
    View localView = this.a.getChildAt(paramInt);
    if (localView != null) {
      RecyclerView.access$1200(this.a, localView);
    }
    this.a.removeViewAt(paramInt);
  }
  
  public void a(View paramView, int paramInt)
  {
    this.a.addView(paramView, paramInt);
    RecyclerView.access$1100(this.a, paramView);
  }
  
  public void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if ((!localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore())) {
        throw new IllegalArgumentException("Called attach on a child which is not detached: " + localViewHolder);
      }
      localViewHolder.clearTmpDetachFlag();
    }
    RecyclerView.access$1300(this.a, paramView, paramInt, paramLayoutParams);
  }
  
  public RecyclerView.ViewHolder b(View paramView)
  {
    return RecyclerView.getChildViewHolderInt(paramView);
  }
  
  public View b(int paramInt)
  {
    return this.a.getChildAt(paramInt);
  }
  
  public void b()
  {
    int j = a();
    int i = 0;
    while (i < j)
    {
      RecyclerView.access$1200(this.a, b(i));
      i += 1;
    }
    this.a.removeAllViews();
  }
  
  public void c(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.getChildViewHolderInt((View)localObject);
      if (localObject != null)
      {
        if ((((RecyclerView.ViewHolder)localObject).isTmpDetached()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore())) {
          throw new IllegalArgumentException("called detach on an already detached child " + localObject);
        }
        ((RecyclerView.ViewHolder)localObject).addFlags(256);
      }
    }
    RecyclerView.access$1400(this.a, paramInt);
  }
  
  public void c(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      RecyclerView.ViewHolder.access$1500(paramView);
    }
  }
  
  public void d(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      RecyclerView.ViewHolder.access$1600(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */