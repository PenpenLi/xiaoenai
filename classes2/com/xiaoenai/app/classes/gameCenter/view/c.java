package com.xiaoenai.app.classes.gameCenter.view;

import android.database.DataSetObserver;

class c
  extends DataSetObserver
{
  c(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged()
  {
    HorizontalListView.a(this.a, true);
    HorizontalListView.b(this.a, false);
    HorizontalListView.b(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
  
  public void onInvalidated()
  {
    HorizontalListView.b(this.a, false);
    HorizontalListView.b(this.a);
    HorizontalListView.c(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */