package com.xiaoenai.app.classes.album;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class u
  implements AbsListView.OnScrollListener
{
  u(t paramt) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)) {
      t.a(this.a).e_();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\album\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */