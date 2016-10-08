package org.cocos2dx.lib;

import com.b.a.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

final class Cocos2dxDownloader$3
  implements Runnable
{
  Cocos2dxDownloader$3(String paramString1, Cocos2dxDownloader paramCocos2dxDownloader, int paramInt, String paramString2) {}
  
  public void run()
  {
    DownloadTask localDownloadTask = new DownloadTask();
    if (this.val$path.length() == 0)
    {
      localDownloadTask.handler = new DataTaskHandler(this.val$downloader, this.val$id);
      localDownloadTask.handle = Cocos2dxDownloader.access$100(this.val$downloader).a(Cocos2dxHelper.getActivity(), this.val$url, localDownloadTask.handler);
    }
    if (this.val$path.length() == 0) {}
    while (localDownloadTask.handle == null)
    {
      Cocos2dxHelper.runOnGLThread(new Cocos2dxDownloader.3.1(this, "Can't create DownloadTask for " + this.val$url));
      return;
      localObject = new File(this.val$path + Cocos2dxDownloader.access$200(this.val$downloader));
      if (!((File)localObject).isDirectory())
      {
        File localFile = ((File)localObject).getParentFile();
        if ((localFile.isDirectory()) || (localFile.mkdirs()))
        {
          localFile = new File(this.val$path);
          if (!((File)localObject).isDirectory())
          {
            localDownloadTask.handler = new FileTaskHandler(this.val$downloader, this.val$id, (File)localObject, localFile);
            long l = ((File)localObject).length();
            if (l <= 0L) {
              break label345;
            }
            localObject = new ArrayList();
            ((List)localObject).add(new BasicHeader("Range", "bytes=" + l + "-"));
          }
        }
      }
    }
    label345:
    for (Object localObject = (Header[])((List)localObject).toArray(new Header[((List)localObject).size()]);; localObject = null)
    {
      localDownloadTask.handle = Cocos2dxDownloader.access$100(this.val$downloader).a(Cocos2dxHelper.getActivity(), this.val$url, (Header[])localObject, null, localDownloadTask.handler);
      break;
      Cocos2dxDownloader.access$300(this.val$downloader).put(Integer.valueOf(this.val$id), localDownloadTask);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxDownloader$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */