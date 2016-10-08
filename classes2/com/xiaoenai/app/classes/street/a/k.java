package com.xiaoenai.app.classes.street.a;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import java.util.ArrayList;

class k
  implements PullToRefreshBase.e<ListView>
{
  k(j paramj) {}
  
  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    int i = Integer.parseInt(paramPullToRefreshBase.getTag().toString());
    if (i == 0) {
      ((g)j.a(this.a).get(i)).a(0);
    }
    for (;;)
    {
      ((g)j.a(this.a).get(i)).e();
      return;
      if (i == 1) {
        ((g)j.a(this.a).get(i)).b(0);
      } else if (i == 2) {
        ((g)j.a(this.a).get(i)).c(0);
      } else if (i == 3) {
        ((g)j.a(this.a).get(i)).d(0);
      } else if (i == 4) {
        ((g)j.a(this.a).get(i)).e(0);
      } else if (i == 5) {
        ((g)j.a(this.a).get(i)).f(0);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */