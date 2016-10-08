package com.xiaoenai.app.widget.wheel;

import android.database.DataSetObserver;

class j
  extends DataSetObserver
{
  j(WheelView paramWheelView) {}
  
  public void onChanged()
  {
    this.a.a(false);
  }
  
  public void onInvalidated()
  {
    this.a.a(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */