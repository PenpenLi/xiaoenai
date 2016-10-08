package com.xiaoenai.app.classes.street;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.xiaoenai.app.classes.street.model.Order;
import com.xiaoenai.app.classes.street.pay.a;

class bw
  extends Handler
{
  bw(StreetOrderActivity paramStreetOrderActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 153)
    {
      paramMessage = paramMessage.getData();
      StreetOrderActivity.a(this.a, (Order)paramMessage.getParcelable("street_order_key"));
      a.a(this.a, new bx(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */