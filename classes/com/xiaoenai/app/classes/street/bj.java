package com.xiaoenai.app.classes.street;

import android.os.Handler;
import android.os.Message;

class bj
  extends Handler
{
  bj(StreetFeedbackActivity paramStreetFeedbackActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1) {
      this.a.g();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */