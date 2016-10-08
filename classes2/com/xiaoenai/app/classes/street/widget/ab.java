package com.xiaoenai.app.classes.street.widget;

import com.xiaoenai.app.classes.street.model.ProductInfo;

class ab
  implements Runnable
{
  ab(aa paramaa) {}
  
  public void run()
  {
    if (StreetPayBottomView.d(this.a.a) > 0L) {
      StreetPayBottomView.a(this.a.a, StreetPayBottomView.c(this.a.a).getStatus(), StreetPayBottomView.e(this.a.a));
    }
    do
    {
      return;
      StreetPayBottomView.a(this.a.a, StreetPayBottomView.c(this.a.a).getStatus(), 0L);
      this.a.a.a();
    } while (StreetPayBottomView.b(this.a.a) == null);
    StreetPayBottomView.b(this.a.a).d(StreetPayBottomView.c(this.a.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */