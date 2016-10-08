package com.xiaoenai.app.utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OpenUDID_service
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return new z(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\OpenUDID_service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */