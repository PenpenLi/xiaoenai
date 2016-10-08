package com.xiaoenai.app.classes.settings;

import android.os.Handler;
import android.os.Message;

class p
  extends Handler
{
  p(SettingFeedbackActivity paramSettingFeedbackActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1) {
      this.a.g();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */