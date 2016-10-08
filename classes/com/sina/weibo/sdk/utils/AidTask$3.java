package com.sina.weibo.sdk.utils;

import android.os.Message;
import com.sina.weibo.sdk.exception.WeiboException;
import java.util.concurrent.locks.ReentrantLock;

class AidTask$3
  implements Runnable
{
  AidTask$3(AidTask paramAidTask, AidTask.AidResultCallBack paramAidResultCallBack) {}
  
  public void run()
  {
    AidTask.access$1(this.this$0).lock();
    localObject2 = AidTask.access$2(this.this$0);
    Object localObject4 = null;
    Object localObject3 = localObject4;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localObject2;
    }
    try
    {
      localObject3 = AidTask.access$3(this.this$0);
      localObject1 = localObject2;
      localObject2 = AidTask.AidInfo.parseJson((String)localObject3);
      localObject1 = localObject2;
      AidTask.access$4(this.this$0, (String)localObject3);
      localObject1 = localObject2;
      AidTask.access$5(this.this$0, (AidTask.AidInfo)localObject2);
      localObject1 = localObject2;
      localObject3 = localObject4;
    }
    catch (WeiboException localWeiboException)
    {
      for (;;)
      {
        LogUtil.e("AidTask", "AidTaskInit WeiboException Msg : " + localWeiboException.getMessage());
        continue;
        ((Message)localObject2).what = 1002;
        ((Message)localObject2).obj = localWeiboException;
      }
    }
    AidTask.access$1(this.this$0).unlock();
    localObject2 = Message.obtain();
    if (localObject1 != null)
    {
      ((Message)localObject2).what = 1001;
      ((Message)localObject2).obj = localObject1;
      AidTask.access$6(this.this$0).setCallback(this.val$callback);
      AidTask.access$6(this.this$0).sendMessage((Message)localObject2);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\AidTask$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */