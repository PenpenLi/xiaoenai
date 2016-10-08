package com.xiaoenai.app.classes.store;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class DownloadReceiver
  extends BroadcastReceiver
{
  private Handler a;
  
  public DownloadReceiver(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (paramIntent.getAction().equals("com.xiaoenai.app.download.TASK_CHANGE")) {
      i = paramIntent.getIntExtra("type", -1);
    }
    Bundle localBundle;
    switch (i)
    {
    default: 
      return;
    case 0: 
      paramContext = new Message();
      paramContext.what = i;
      localBundle = new Bundle();
      localBundle.putLong("totalSize", paramIntent.getLongExtra("totalSize", 0L));
      localBundle.putLong("downloadSize", paramIntent.getLongExtra("downloadSize", 0L));
      localBundle.putLong("process_progress", paramIntent.getLongExtra("process_progress", 0L));
      localBundle.putString("url", paramIntent.getStringExtra("url"));
      paramContext.setData(localBundle);
      this.a.sendMessage(paramContext);
      return;
    case 1: 
      paramContext = new Message();
      paramContext.what = i;
      paramContext.obj = paramIntent.getStringExtra("filePath");
      localBundle = new Bundle();
      localBundle.putString("url", paramIntent.getStringExtra("url"));
      paramContext.setData(localBundle);
      this.a.sendMessage(paramContext);
      return;
    case 9: 
      paramContext = new Message();
      paramContext.what = i;
      paramContext.obj = paramIntent.getStringExtra("filePath");
      localBundle = new Bundle();
      localBundle.putString("url", paramIntent.getStringExtra("url"));
      paramContext.setData(localBundle);
      this.a.sendMessage(paramContext);
      return;
    case 10: 
      paramContext = new Message();
      paramContext.what = i;
      paramContext.obj = paramIntent.getStringExtra("filePath");
      localBundle = new Bundle();
      localBundle.putString("url", paramIntent.getStringExtra("url"));
      paramContext.setData(localBundle);
      this.a.sendMessage(paramContext);
      return;
    }
    paramContext = new Message();
    paramContext.what = i;
    this.a.sendMessage(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\DownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */