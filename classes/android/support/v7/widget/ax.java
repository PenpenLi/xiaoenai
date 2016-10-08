package android.support.v7.widget;

class ax
  implements n.a
{
  ax(RecyclerView paramRecyclerView) {}
  
  public RecyclerView.ViewHolder a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.a.findViewHolderForPosition(paramInt, true);
    if (localViewHolder == null) {}
    while (this.a.mChildHelper.c(localViewHolder.itemView)) {
      return null;
    }
    return localViewHolder;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.offsetPositionRecordsForRemove(paramInt1, paramInt2, true);
    this.a.mItemsAddedOrRemoved = true;
    RecyclerView.State.access$1712(this.a.mState, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.viewRangeUpdate(paramInt1, paramInt2, paramObject);
    this.a.mItemsChanged = true;
  }
  
  public void a(n.b paramb)
  {
    c(paramb);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.offsetPositionRecordsForRemove(paramInt1, paramInt2, false);
    this.a.mItemsAddedOrRemoved = true;
  }
  
  public void b(n.b paramb)
  {
    c(paramb);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.a.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    this.a.mItemsAddedOrRemoved = true;
  }
  
  void c(n.b paramb)
  {
    switch (paramb.a)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      this.a.mLayout.onItemsAdded(this.a, paramb.b, paramb.d);
      return;
    case 2: 
      this.a.mLayout.onItemsRemoved(this.a, paramb.b, paramb.d);
      return;
    case 4: 
      this.a.mLayout.onItemsUpdated(this.a, paramb.b, paramb.d, paramb.c);
      return;
    }
    this.a.mLayout.onItemsMoved(this.a, paramb.b, paramb.d, 1);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.a.offsetPositionRecordsForMove(paramInt1, paramInt2);
    this.a.mItemsAddedOrRemoved = true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */