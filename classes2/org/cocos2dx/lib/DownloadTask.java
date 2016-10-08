package org.cocos2dx.lib;

import com.b.a.a.f;
import com.b.a.a.p;

class DownloadTask
{
  long bytesReceived;
  byte[] data;
  p handle = null;
  f handler = null;
  long totalBytesExpected;
  long totalBytesReceived;
  
  DownloadTask()
  {
    resetStatus();
  }
  
  void resetStatus()
  {
    this.bytesReceived = 0L;
    this.totalBytesReceived = 0L;
    this.totalBytesExpected = 0L;
    this.data = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\DownloadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */