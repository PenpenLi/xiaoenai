package com.taobao.applink.auth;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Messenger;
import android.util.Log;
import com.taobao.applink.util.TBAppLinkUtil;

public class TBAppLinkAuthService
{
  private static final String START_SERVER_ACTION = "com.taobao.open.intent.action.AUTH";
  private static final int WHAT_ON_TO_CLIENT = 11802;
  private static final int WHAT_ON_TO_SERVICE = 11801;
  private static boolean isBind = false;
  private static ServiceConnection mConnection;
  private Handler mHandler;
  private TBAppLinkAuthListener mListner;
  private Messenger mMessenger;
  
  public TBAppLinkAuthService(TBAppLinkAuthListener paramTBAppLinkAuthListener)
  {
    if (paramTBAppLinkAuthListener == null) {
      return;
    }
    this.mListner = paramTBAppLinkAuthListener;
  }
  
  private void initService()
  {
    this.mHandler = new Handler(new TBAppLinkAuthService.1(this));
    this.mMessenger = new Messenger(this.mHandler);
    mConnection = new TBAppLinkAuthService.2(this);
  }
  
  private void unBindService()
  {
    try
    {
      if ((mConnection != null) && (isBind))
      {
        isBind = false;
        TBAppLinkUtil.getApplication().getApplicationContext().unbindService(mConnection);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("AppLink", localThrowable.toString());
    }
  }
  
  public void bindService()
  {
    if (TBAppLinkUtil.getApplication() == null) {
      return;
    }
    unBindService();
    initService();
    Intent localIntent = new Intent();
    localIntent.setAction("com.taobao.open.intent.action.AUTH");
    localIntent.setPackage("com.taobao.taobao");
    try
    {
      TBAppLinkUtil.getApplication().getApplicationContext().bindService(localIntent, mConnection, 1);
      isBind = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("AppLink", localThrowable.toString());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\auth\TBAppLinkAuthService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */