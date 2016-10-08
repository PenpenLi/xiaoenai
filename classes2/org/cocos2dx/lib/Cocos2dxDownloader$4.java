package org.cocos2dx.lib;

import com.b.a.a.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class Cocos2dxDownloader$4
  implements Runnable
{
  Cocos2dxDownloader$4(Cocos2dxDownloader paramCocos2dxDownloader) {}
  
  public void run()
  {
    Iterator localIterator = Cocos2dxDownloader.access$300(this.val$downloader).entrySet().iterator();
    while (localIterator.hasNext())
    {
      DownloadTask localDownloadTask = (DownloadTask)((Map.Entry)localIterator.next()).getValue();
      if (localDownloadTask.handle != null) {
        localDownloadTask.handle.a(true);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxDownloader$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */