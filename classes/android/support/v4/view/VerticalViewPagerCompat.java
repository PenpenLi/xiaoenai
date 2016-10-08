package android.support.v4.view;

import android.database.DataSetObserver;

public final class VerticalViewPagerCompat
{
  public static void setDataSetObserver(PagerAdapter paramPagerAdapter, DataSetObserver paramDataSetObserver)
  {
    paramPagerAdapter.registerDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\view\VerticalViewPagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */