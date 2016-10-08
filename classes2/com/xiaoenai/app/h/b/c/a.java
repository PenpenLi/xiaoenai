package com.xiaoenai.app.h.b.c;

import android.app.Activity;
import android.app.Application;
import com.alimama.mobile.sdk.MMUSDK;
import com.alimama.mobile.sdk.config.MMUFeedProperties;
import com.alimama.mobile.sdk.config.MMUSDKFactory;
import com.alimama.mobile.sdk.config.MmuProperties.ACCT;
import com.xiaoenai.app.h.b.b.c;

public final class a
{
  private static boolean a = false;
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, com.xiaoenai.app.h.b.b.a parama)
  {
    if (a)
    {
      paramActivity = new MMUFeedProperties(paramActivity, paramString);
      paramActivity.setMMUFeedListener(new c(parama));
      paramActivity.setAcct(MmuProperties.ACCT.DATA);
      paramActivity.setAdSize(paramInt1, paramInt2);
      paramActivity.addCustomAdapter(291, new com.xiaoenai.app.h.b.a.a());
      paramActivity.setReqCount(1);
      MMUSDKFactory.getMMUSDK().attach(paramActivity);
      return;
    }
    parama.a(paramString);
  }
  
  public static void a(Application paramApplication)
  {
    if (!a)
    {
      MMUSDKFactory.getMMUSDK().setInitAsyncListener(new b());
      MMUSDKFactory.getMMUSDK().initAsync(paramApplication);
    }
  }
  
  public static void a(Class<? extends Activity> paramClass)
  {
    if (a) {
      MMUSDKFactory.registerAcvitity(paramClass);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */