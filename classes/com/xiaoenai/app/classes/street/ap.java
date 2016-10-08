package com.xiaoenai.app.classes.street;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;

class ap
  implements PullToRefreshBase.e<ListView>
{
  ap(StreetCommentsAvtivity paramStreetCommentsAvtivity) {}
  
  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    StreetCommentsAvtivity.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */