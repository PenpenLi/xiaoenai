package com.alimama.mobile.sdk.shell;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.InstantiationException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.alimama.mobile.sdk.config.MMUSDKFactory;
import com.alimama.mobile.sdk.config.system.APFSystem;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.MMUSDKImpl;
import com.alimama.mobile.sdk.config.system.bridge.CMPluginBridge;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.util.HashMap;
import java.util.Map;

public class MMUWall
  extends FragmentActivity
{
  public static Object extra = null;
  Fragment mFragment;
  Map<String, Object> map;
  private MMUSDKImpl mmuSDK;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      boolean bool = ((Boolean)CMPluginBridge.BaseFragment_dispatchKeyEvent.invoke(this.mFragment, new Object[] { paramKeyEvent })).booleanValue();
      if (bool) {
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.mmuSDK.accountServiceHandleResult(paramInt1, paramInt2, paramIntent, this)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getBundleExtra("msg");
    this.map = new HashMap();
    this.map.put("handler", localBundle);
    if (extra != null)
    {
      this.map.put("preload", extra);
      extra = null;
    }
    try
    {
      super.onCreate(paramBundle);
    }
    catch (Fragment.InstantiationException paramBundle)
    {
      try
      {
        for (;;)
        {
          paramBundle = new FrameLayout(this);
          paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          paramBundle.setId(16908300);
          requestWindowFeature(1);
          setContentView(paramBundle);
          this.mmuSDK = ((MMUSDKImpl)MMUSDKFactory.getMMUSDK());
          this.mFragment = this.mmuSDK.getApfSystem().findFragment(this.map);
          paramBundle = getSupportFragmentManager().beginTransaction();
          paramBundle.add(16908300, this.mFragment);
          paramBundle.commit();
          Log.e("E", String.format("######### NO.3 [%d]", new Object[] { Integer.valueOf(getResources().getIdentifier("taobao_xp_hl_webview_error_button_background_selector", "drawable", "com.alimama.mobile.sdk.handle")) }));
          return;
          paramBundle = paramBundle;
          MMLog.e(paramBundle, "", new Object[0]);
          finish();
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.e("AlimamaWall", "", paramBundle);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\shell\MMUWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */