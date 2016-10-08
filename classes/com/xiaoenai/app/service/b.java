package com.xiaoenai.app.service;

import android.os.Environment;
import android.os.Message;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class b
  extends Thread
{
  b(DownloadService paramDownloadService, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new DefaultHttpClient().execute(new HttpGet(this.a)).getEntity();
      long l3 = ((HttpEntity)localObject).getContentLength();
      localObject = ((HttpEntity)localObject).getContent();
      BufferedInputStream localBufferedInputStream;
      FileOutputStream localFileOutputStream;
      BufferedOutputStream localBufferedOutputStream;
      if (localObject != null)
      {
        DownloadService.a(this.b, new File(Environment.getExternalStorageDirectory(), this.a.substring(this.a.lastIndexOf("/") + 1)));
        if (DownloadService.a(this.b).exists()) {
          DownloadService.a(this.b).delete();
        }
        DownloadService.a(this.b).createNewFile();
        localBufferedInputStream = new BufferedInputStream((InputStream)localObject);
        localFileOutputStream = new FileOutputStream(DownloadService.a(this.b));
        localBufferedOutputStream = new BufferedOutputStream(localFileOutputStream);
        long l1 = 0L;
        byte[] arrayOfByte = new byte['Ѐ'];
        for (;;)
        {
          int i = localBufferedInputStream.read(arrayOfByte);
          if ((i == -1) || (DownloadService.b(this.b))) {
            break;
          }
          localBufferedOutputStream.write(arrayOfByte, 0, i);
          long l2 = l1 + i;
          i = (int)(l2 / l3 * 100.0D);
          l1 = l2;
          if (i - DownloadService.c(this.b) >= 5)
          {
            DownloadService.a(this.b, i);
            Message localMessage4 = DownloadService.d(this.b).obtainMessage(3, Integer.valueOf(i));
            DownloadService.d(this.b).sendMessage(localMessage4);
            l1 = l2;
          }
        }
      }
      Message localMessage1;
      Message localMessage2;
      Message localMessage3;
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localMessage1 = DownloadService.d(this.b).obtainMessage(4, this.b.getString(2131101074));
      DownloadService.d(this.b).sendMessage(localMessage1);
      return;
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      localFileOutputStream.flush();
      localFileOutputStream.close();
      localMessage1.close();
      localBufferedInputStream.close();
      if (!DownloadService.b(this.b))
      {
        localMessage1 = DownloadService.d(this.b).obtainMessage(2, DownloadService.a(this.b));
        DownloadService.d(this.b).sendMessage(localMessage1);
        return;
      }
    }
    catch (IOException localIOException)
    {
      localMessage2 = DownloadService.d(this.b).obtainMessage(4, this.b.getString(2131101074));
      DownloadService.d(this.b).sendMessage(localMessage2);
      return;
      DownloadService.a(this.b).delete();
      return;
    }
    catch (Exception localException)
    {
      localMessage3 = DownloadService.d(this.b).obtainMessage(4, this.b.getString(2131101074));
      DownloadService.d(this.b).sendMessage(localMessage3);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */