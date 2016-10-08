package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class ac
  implements Runnable
{
  ac(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      DefaultItemAnimator.access$400(this.b, localViewHolder);
    }
    this.a.clear();
    DefaultItemAnimator.access$500(this.b).remove(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */