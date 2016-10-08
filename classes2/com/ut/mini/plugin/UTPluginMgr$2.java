package com.ut.mini.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class UTPluginMgr$2
  extends Handler
{
  UTPluginMgr$2(UTPluginMgr paramUTPluginMgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof UTPluginMgr.a)))
    {
      Object localObject = (UTPluginMgr.a)paramMessage.obj;
      paramMessage = ((UTPluginMgr.a)localObject).a();
      int i = ((UTPluginMgr.a)localObject).i();
      localObject = ((UTPluginMgr.a)localObject).getMsgObj();
      if (paramMessage != null) {
        try
        {
          if ((localObject instanceof UTPluginMsgDispatchDelegate))
          {
            localObject = (UTPluginMsgDispatchDelegate)localObject;
            if (((UTPluginMsgDispatchDelegate)localObject).isMatchPlugin(paramMessage)) {
              paramMessage.onPluginMsgArrivedFromSDK(i, ((UTPluginMsgDispatchDelegate)localObject).getDispatchObject(paramMessage));
            }
          }
          else
          {
            paramMessage.onPluginMsgArrivedFromSDK(i, localObject);
            return;
          }
        }
        catch (Throwable paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\plugin\UTPluginMgr$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */