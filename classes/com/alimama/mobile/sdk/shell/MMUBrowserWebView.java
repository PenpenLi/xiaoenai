package com.alimama.mobile.sdk.shell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.alimama.mobile.sdk.MMUSDK;
import com.alimama.mobile.sdk.config.MMUSDKFactory;
import com.alimama.mobile.sdk.config.system.bridge.CMPluginBridge;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

public class MMUBrowserWebView
  extends FragmentActivity
{
  private Fragment mFragment;
  String url = "";
  
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
    if (!MMUSDKFactory.getMMUSDK().accountServiceHandleResult(paramInt1, paramInt2, paramIntent, this))
    {
      MMUSDKFactory.getMMUSDK().alimamaJsSdkOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (!CMPluginBridge.BrowserFragmentHandleResult(paramInt1, paramInt2, paramIntent, this.mFragment)) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    for (;;)
    {
      try
      {
        MMUSDKFactory.getMMUSDK().init(getApplication());
        paramBundle = new FrameLayout(this);
        paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        paramBundle.setId(16908300);
        requestWindowFeature(1);
        setContentView(paramBundle);
        if (getIntent().hasExtra("url")) {
          this.url = getIntent().getExtras().getString("url");
        }
        if (!getIntent().hasExtra("referer")) {
          break label420;
        }
        paramBundle = getIntent().getExtras().getString("referer");
        if (getIntent().hasExtra("interceptUrl"))
        {
          str1 = getIntent().getExtras().getString("interceptUrl");
          String str2 = "";
          if (getIntent().hasExtra("onUrlInterceptCallBack")) {
            str2 = getIntent().getExtras().getString("onUrlInterceptCallBack");
          }
          if (getIntent().hasExtra("report")) {
            bool = getIntent().getBooleanExtra("report", true);
          }
          FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
          if (getIntent().hasExtra("slide_anim")) {
            localFragmentTransaction.setCustomAnimations(17432578, 17432579);
          }
          this.mFragment = CMPluginBridge.getBrowserFragment();
          Bundle localBundle = new Bundle();
          localBundle.putString("url", this.url);
          if (!TextUtils.isEmpty(paramBundle)) {
            localBundle.putString("referer", paramBundle);
          }
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("interceptUrl", str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            localBundle.putString("onUrlInterceptCallBack", str2);
          }
          if (getIntent().hasExtra("promoter")) {
            localBundle.putParcelable("promoter", getIntent().getExtras().getParcelable("promoter"));
          }
          if (getIntent().hasExtra("transinfo")) {
            localBundle.putString("transinfo", getIntent().getExtras().getString("transinfo"));
          }
          localBundle.putBoolean("report", bool);
          this.mFragment.setArguments(localBundle);
          if (this.mFragment != null)
          {
            localFragmentTransaction.add(16908300, this.mFragment);
            localFragmentTransaction.commit();
            return;
          }
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        Log.e("AlimamaWall", "", paramBundle);
        return;
      }
      String str1 = "";
      continue;
      label420:
      paramBundle = "";
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    MMUSDKFactory.getMMUSDK().alimamaJsSdkOnDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    MMUSDKFactory.getMMUSDK().alimamaJsSdkOnPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    MMUSDKFactory.getMMUSDK().alimamaJsSdkOnResume();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\shell\MMUBrowserWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */