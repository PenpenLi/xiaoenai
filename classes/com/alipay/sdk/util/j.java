package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alipay.android.app.IRemoteServiceCallback.Stub;
import java.lang.ref.WeakReference;

final class j
  extends IRemoteServiceCallback.Stub
{
  j(h paramh) {}
  
  public final boolean isHideLoadingScreen()
  {
    return false;
  }
  
  public final void payEnd(boolean paramBoolean, String paramString) {}
  
  public final void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN", null);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    try
    {
      localBundle.putInt("CallingPid", paramInt);
      localIntent.putExtras(localBundle);
      localIntent.setClassName(paramString1, paramString2);
      ((Activity)h.b(this.a).get()).startActivity(localIntent);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\util\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */