package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class aa
  implements Runnable
{
  aa(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      DefaultItemAnimator.b localb = (DefaultItemAnimator.b)localIterator.next();
      DefaultItemAnimator.access$000(this.b, localb.a, localb.b, localb.c, localb.d, localb.e);
    }
    this.a.clear();
    DefaultItemAnimator.access$100(this.b).remove(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */