package com.sina.weibo.sdk.utils;

import java.io.File;

class AidTask$1
  implements Runnable
{
  AidTask$1(AidTask paramAidTask) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i >= 1) {
        return;
      }
      File localFile = AidTask.access$0(this.this$0, i);
      try
      {
        localFile.delete();
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\AidTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */