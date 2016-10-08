package com.inmobi.rendering;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class a$3
  extends BroadcastReceiver
{
  a$3(a parama, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if ((paramIntent != null) && ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction())))
    {
      long l = paramIntent.getLongExtra("extra_download_id", 0L);
      paramContext = new DownloadManager.Query();
      paramContext.setFilterById(new long[] { l });
      paramContext = a.b(this.b).query(paramContext);
      if (paramContext.moveToFirst())
      {
        i = paramContext.getColumnIndex("status");
        if (16 != paramContext.getInt(i)) {
          break label113;
        }
        a.a(this.b).a(this.a, "File failed to download", "storePicture");
      }
    }
    for (;;)
    {
      paramContext.close();
      return;
      label113:
      if (8 == paramContext.getInt(i)) {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "Download completed");
      } else if (1 == paramContext.getInt(i)) {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "Download queued");
      } else if (2 == paramContext.getInt(i)) {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a.a(), "Download ongoing");
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */