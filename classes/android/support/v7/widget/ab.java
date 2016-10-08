package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Iterator;

class ab
  implements Runnable
{
  ab(DefaultItemAnimator paramDefaultItemAnimator, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      DefaultItemAnimator.a locala = (DefaultItemAnimator.a)localIterator.next();
      DefaultItemAnimator.access$200(this.b, locala);
    }
    this.a.clear();
    DefaultItemAnimator.access$300(this.b).remove(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */