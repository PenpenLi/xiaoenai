package android.support.v7.widget;

import android.support.v4.widget.CursorAdapter;

class bj
  implements Runnable
{
  bj(SearchView paramSearchView) {}
  
  public void run()
  {
    if ((SearchView.access$100(this.a) != null) && ((SearchView.access$100(this.a) instanceof bv))) {
      SearchView.access$100(this.a).changeCursor(null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */