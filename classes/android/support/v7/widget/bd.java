package android.support.v7.widget;

import android.view.View;

class bd
  implements Runnable
{
  bd(ScrollingTabContainerView paramScrollingTabContainerView, View paramView) {}
  
  public void run()
  {
    int i = this.a.getLeft();
    int j = (this.b.getWidth() - this.a.getWidth()) / 2;
    this.b.smoothScrollTo(i - j, 0);
    this.b.mTabSelector = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */