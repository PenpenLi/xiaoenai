package com.sina.weibo.sdk.utils;

import com.sina.weibo.sdk.exception.WeiboException;
import java.util.concurrent.locks.ReentrantLock;

class AidTask$2
  implements Runnable
{
  AidTask$2(AidTask paramAidTask) {}
  
  public void run()
  {
    if (!AidTask.access$1(this.this$0).tryLock())
    {
      LogUtil.e("AidTask", "tryLock : false, return");
      return;
    }
    Object localObject = AidTask.access$2(this.this$0);
    int i;
    int j;
    if (localObject == null)
    {
      i = 1;
      j = i + 1;
    }
    for (;;)
    {
      try
      {
        localObject = AidTask.access$3(this.this$0);
        AidTask.AidInfo localAidInfo = AidTask.AidInfo.parseJson((String)localObject);
        AidTask.access$4(this.this$0, (String)localObject);
        AidTask.access$5(this.this$0, localAidInfo);
        AidTask.access$1(this.this$0).unlock();
        return;
      }
      catch (WeiboException localWeiboException)
      {
        LogUtil.e("AidTask", "AidTaskInit WeiboException Msg : " + localWeiboException.getMessage());
        i = j;
      }
      if (j < 3) {
        break;
      }
      continue;
      AidTask.access$5(this.this$0, localWeiboException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\AidTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */