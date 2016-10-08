package com.sina.weibo.sdk.statistic;

class WBAgentHandler$2
  implements Runnable
{
  WBAgentHandler$2(WBAgentHandler paramWBAgentHandler, String paramString) {}
  
  public void run()
  {
    LogFileUtil.writeToFile(LogFileUtil.getAppLogPath("app_logs"), this.val$content, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\WBAgentHandler$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */