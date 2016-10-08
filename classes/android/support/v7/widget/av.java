package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class av
  implements cg.b
{
  av(RecyclerView paramRecyclerView) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.a.mLayout.removeAndRecycleView(paramViewHolder.itemView, this.a.mRecycler);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    this.a.mRecycler.unscrapView(paramViewHolder);
    RecyclerView.access$700(this.a, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    RecyclerView.access$800(this.a, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (RecyclerView.access$900(this.a)) {
      if (this.a.mItemAnimator.animateChange(paramViewHolder, paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
        RecyclerView.access$1000(this.a);
      }
    }
    while (!this.a.mItemAnimator.animatePersistence(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      return;
    }
    RecyclerView.access$1000(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */