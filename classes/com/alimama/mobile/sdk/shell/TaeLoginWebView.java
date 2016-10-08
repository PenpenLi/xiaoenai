package com.alimama.mobile.sdk.shell;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.alimama.mobile.sdk.config.system.bridge.TaePluginBridge;

public class TaeLoginWebView
  extends FragmentActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = new FrameLayout(this);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      paramBundle.setId(16908300);
      requestWindowFeature(1);
      setContentView(paramBundle);
      paramBundle = getSupportFragmentManager().beginTransaction();
      Fragment localFragment = TaePluginBridge.getInstance().getLoginWebViewFragment();
      if (localFragment != null)
      {
        paramBundle.add(16908300, localFragment);
        paramBundle.commit();
        return;
      }
      finish();
      return;
    }
    catch (Exception paramBundle)
    {
      Log.e("AlimamaWall", "", paramBundle);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\shell\TaeLoginWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */