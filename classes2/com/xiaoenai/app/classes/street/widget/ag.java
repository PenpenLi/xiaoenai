package com.xiaoenai.app.classes.street.widget;

import android.widget.ScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xiaoenai.app.classes.street.StreetProductDetailActivity;
import com.xiaoenai.app.widget.PullToRefreshScrollViewEx;

class ag
  implements PullToRefreshBase.e<ScrollView>
{
  ag(ad paramad) {}
  
  public void a(PullToRefreshBase<ScrollView> paramPullToRefreshBase)
  {
    ad.e(this.a).l();
    ((StreetProductDetailActivity)this.a.getActivity()).c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */