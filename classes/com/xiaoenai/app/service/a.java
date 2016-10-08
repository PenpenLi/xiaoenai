package com.xiaoenai.app.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;
import com.xiaoenai.app.utils.w;
import java.io.File;

class a
  extends Handler
{
  a(ApkDownloadService paramApkDownloadService) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      long l = paramMessage.getData().getLong("process_progress");
      if (l != ApkDownloadService.a(this.a))
      {
        ApkDownloadService.b(this.a).setTextViewText(2131559690, this.a.getString(2131101075) + l + "%");
        ApkDownloadService.b(this.a).setProgressBar(2131559689, 100, (int)l, false);
        w.a(this.a, ApkDownloadService.c(this.a), ApkDownloadService.a(this.a, ApkDownloadService.b(this.a)));
      }
      ApkDownloadService.a(this.a, (int)l);
      return;
    case 1: 
      ApkDownloadService.a(this.a, 0);
      w.a(this.a, ApkDownloadService.c(this.a));
      ApkDownloadService.a(this.a, new File((String)paramMessage.obj), this.a);
      return;
    case 10: 
      ApkDownloadService.a(this.a, 0);
      w.a(this.a, ApkDownloadService.c(this.a));
      return;
    }
    ApkDownloadService.a(this.a, 0);
    w.a(this.a, ApkDownloadService.c(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */