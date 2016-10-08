package android.support.v7.widget;

class as
  implements Runnable
{
  as(RecyclerView paramRecyclerView) {}
  
  public void run()
  {
    if ((!RecyclerView.access$100(this.a)) || (this.a.isLayoutRequested())) {
      return;
    }
    if (RecyclerView.access$200(this.a))
    {
      RecyclerView.access$302(this.a, true);
      return;
    }
    RecyclerView.access$400(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */