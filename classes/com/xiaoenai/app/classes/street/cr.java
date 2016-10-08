package com.xiaoenai.app.classes.street;

import android.widget.ScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;

class cr
  implements PullToRefreshBase.e<ScrollView>
{
  cr(StreetOrderDetailActivity paramStreetOrderDetailActivity) {}
  
  public void a(PullToRefreshBase<ScrollView> paramPullToRefreshBase)
  {
    StreetOrderDetailActivity.d(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */