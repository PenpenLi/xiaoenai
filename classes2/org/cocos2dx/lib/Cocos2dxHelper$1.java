package org.cocos2dx.lib;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.a.a.a.a;

final class Cocos2dxHelper$1
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Cocos2dxHelper.access$002(a.a.a(paramIBinder));
    Cocos2dxHelper.fastLoading(7);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Cocos2dxHelper.access$200().getApplicationContext().unbindService(Cocos2dxHelper.access$100());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */