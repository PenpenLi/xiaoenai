package android.support.v7.widget;

class at
  implements Runnable
{
  at(RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    if (this.a.mItemAnimator != null) {
      this.a.mItemAnimator.runPendingAnimations();
    }
    RecyclerView.access$602(this.a, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */