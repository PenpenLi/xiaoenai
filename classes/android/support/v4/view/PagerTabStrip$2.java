package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

class PagerTabStrip$2
  implements View.OnClickListener
{
  PagerTabStrip$2(PagerTabStrip paramPagerTabStrip) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mPager.setCurrentItem(this.this$0.mPager.getCurrentItem() + 1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\view\PagerTabStrip$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */