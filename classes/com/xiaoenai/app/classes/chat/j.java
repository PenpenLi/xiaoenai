package com.xiaoenai.app.classes.chat;

import com.xiaoenai.app.model.UserConfig;

class j
  implements Runnable
{
  j(BaseChatActivity paramBaseChatActivity) {}
  
  public void run()
  {
    if (UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue())
    {
      BaseChatActivity.c(this.a);
      return;
    }
    BaseChatActivity.d(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */