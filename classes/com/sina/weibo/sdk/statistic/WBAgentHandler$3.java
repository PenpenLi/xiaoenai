package com.sina.weibo.sdk.statistic;

import android.content.Context;
import java.util.TimerTask;

class WBAgentHandler$3
  extends TimerTask
{
  WBAgentHandler$3(WBAgentHandler paramWBAgentHandler, Context paramContext) {}
  
  public void run()
  {
    LogReport.uploadAppLogs(this.val$context, WBAgentHandler.access$0(this.this$0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\WBAgentHandler$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */