package com.xiaoenai.app.classes.street;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xiaoenai.app.classes.street.a.g;

class cn
  implements PullToRefreshBase.e<ListView>
{
  cn(StreetOrderAfterSaleActivity paramStreetOrderAfterSaleActivity) {}
  
  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    StreetOrderAfterSaleActivity.b(this.a).f(0);
    StreetOrderAfterSaleActivity.b(this.a).e();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */