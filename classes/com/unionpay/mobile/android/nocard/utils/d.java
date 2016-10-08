package com.unionpay.mobile.android.nocard.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.plugin.c;
import com.unionpay.mobile.android.utils.h;

public final class d
{
  public static void a(Context paramContext, b paramb)
  {
    h.b("uppay", "exit() +++");
    h.a("uppay", "reqId=" + paramb.D.a);
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if (paramb.D.f.length() > 0)
    {
      h.a("uppay", "result=" + paramb.D.f);
      switch (paramb.D.a)
      {
      }
    }
    for (;;)
    {
      if ((paramb.Q != null) && (paramb.Q.length() > 0) && (paramb.R != null) && (paramb.R.length() > 0))
      {
        boolean bool = paramb.P;
        paramContext = paramb.Q;
        paramb = paramb.R;
        if (bool) {
          new Thread(new e(paramContext, paramb)).start();
        }
      }
      localBaseActivity.b();
      localBaseActivity.finish();
      h.b("uppay", "exit() +++");
      return;
      h.b("uppay", " notifyBrowserResult() +++ ");
      Object localObject2 = null;
      paramContext = paramb.D.f;
      label271:
      Object localObject1;
      if (paramContext.equalsIgnoreCase("fail"))
      {
        paramContext = "1";
        localObject1 = localObject2;
        switch (paramb.D.a)
        {
        default: 
          localObject1 = localObject2;
        case 2: 
        case 3: 
          label314:
          paramContext = paramb.m + paramContext;
          h.a("uppay", "result URL= " + paramContext);
          if (1000 == paramb.D.a)
          {
            paramContext = new Intent("android.intent.action.VIEW", Uri.parse(paramContext));
            paramContext.addCategory("android.intent.category.BROWSABLE");
            localBaseActivity.startActivity(paramContext);
          }
          break;
        }
      }
      for (;;)
      {
        h.b("uppay", " notifyBrowserResult() --- ");
        break;
        if (paramContext.equalsIgnoreCase("cancel"))
        {
          paramContext = "-1";
          break label271;
        }
        paramContext = "0";
        break label271;
        localObject1 = new Intent("com.UCMobile.PluginApp.ActivityState");
        ((Intent)localObject1).putExtra("ActivityState", "inactive");
        ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
        localBaseActivity.sendBroadcast((Intent)localObject1);
        localObject1 = new Intent("com.unionpay.uppay.resultURL");
        h.b("uppay", " uc browser ");
        break label314;
        localObject1 = new Intent(paramb.D.b);
        h.b("uppay", " other browser ");
        h.a("uppay", " result Action=" + paramb.D.b);
        break label314;
        ((Intent)localObject1).putExtra("ResultURL", paramContext);
        h.a("browser", ((Intent)localObject1).toURI());
        localBaseActivity.sendBroadcast((Intent)localObject1);
      }
      h.b("uppay", "notifyAppResult() +++");
      paramContext = new Intent();
      paramContext.putExtra("pay_result", paramb.D.f);
      if ((paramb.Q != null) && (paramb.Q.length() > 0) && (paramb.R != null) && (paramb.R.length() > 0) && (!paramb.P))
      {
        paramContext.putExtra("notify_url", paramb.Q);
        paramContext.putExtra("notify_msg", paramb.R);
      }
      localBaseActivity.setResult(-1, paramContext);
      h.b("uppay", "notifyAppResult() ---");
      continue;
      h.b("uppay", "notifyTencentJarResult() +++");
      paramContext = new Intent();
      paramContext.putExtra("pay_result", paramb.D.f);
      paramContext.putExtra("tencentWID", paramb.D.h);
      paramContext.putExtra("tencentUID", paramb.D.g);
      paramContext.putExtra("bankInfo", paramb.D.j);
      paramContext.putExtra("cardType", paramb.D.k);
      paramContext.putExtra("cardNo", paramb.D.i);
      localBaseActivity.setResult(-1, paramContext);
      h.b("uppay", "notifyTencentJarResult() ---");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\nocard\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */