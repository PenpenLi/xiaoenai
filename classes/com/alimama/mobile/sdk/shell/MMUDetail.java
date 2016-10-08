package com.alimama.mobile.sdk.shell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment.InstantiationException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.alimama.mobile.sdk.config.MMUSDKFactory;
import com.alimama.mobile.sdk.config.system.APFSystem;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.MMUSDKImpl;
import java.util.HashMap;
import java.util.Map;

public class MMUDetail
  extends FragmentActivity
{
  Map<String, Object> map = null;
  
  public void finish()
  {
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent().getExtras();
    if (localObject != null)
    {
      this.map = new HashMap();
      this.map.put("alimamaDetail", localObject);
    }
    try
    {
      super.onCreate(paramBundle);
      requestWindowFeature(1);
    }
    catch (Fragment.InstantiationException paramBundle)
    {
      for (;;)
      {
        try
        {
          paramBundle = new FrameLayout(this);
          paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          paramBundle.setId(16908300);
          setContentView(paramBundle);
          paramBundle = ((MMUSDKImpl)MMUSDKFactory.getMMUSDK()).getApfSystem().findFragment(this.map);
          localObject = getSupportFragmentManager().beginTransaction();
          ((FragmentTransaction)localObject).add(16908300, paramBundle);
          ((FragmentTransaction)localObject).commit();
          return;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        paramBundle = paramBundle;
        MMLog.e(paramBundle, "", new Object[0]);
        finish();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\shell\MMUDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */