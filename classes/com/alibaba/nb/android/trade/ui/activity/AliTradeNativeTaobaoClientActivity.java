package com.alibaba.nb.android.trade.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.alibaba.nb.android.trade.a.c;
import com.alibaba.nb.android.trade.model.inner.AliTradeApplinkOpenType;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.util.Map;

public class AliTradeNativeTaobaoClientActivity
  extends Activity
{
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void onStart()
  {
    Object localObject1 = null;
    super.onStart();
    Object localObject4 = getIntent();
    if (localObject4 != null)
    {
      setIntent(null);
      Object localObject2 = ((Intent)localObject4).getStringExtra("actionName");
      Object localObject3;
      if ("showNative".equals(localObject2))
      {
        localObject3 = ((Intent)localObject4).getStringExtra("id");
        Map localMap = (Map)((Intent)localObject4).getSerializableExtra("actionParameters");
        if (((Intent)localObject4).getSerializableExtra("pid") != null) {
          localObject1 = (String)((Intent)localObject4).getSerializableExtra("pid");
        }
        localObject4 = (AliTradeApplinkOpenType)((Intent)localObject4).getSerializableExtra("type");
        StringBuilder localStringBuilder = new StringBuilder("NativeTaobaoClientActivity.start()--Back From NativeTaobao: action:showNative itemId:");
        if (localObject3 == null)
        {
          localObject2 = "null";
          localStringBuilder = localStringBuilder.append((String)localObject2).append(" taokePid:");
          if (localObject1 != null) {
            break label175;
          }
        }
        label175:
        for (localObject2 = "null";; localObject2 = localObject1)
        {
          AliSDKLogger.i("BaichuanTLOG", (String)localObject2);
          if (!c.a(this, (AliTradeApplinkOpenType)localObject4, (String)localObject3, AliTradeConfigServiceImpl.getInstance().getIsvCode(), (String)localObject1, "alisdk://", localMap)) {
            finish();
          }
          return;
          localObject2 = localObject3;
          break;
        }
      }
      if (isTaskRoot())
      {
        localObject3 = new StringBuilder("NativeTaobaoClientActivity.start()--Back From NativeTaobao(jump through scheme url): action:");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        AliSDKLogger.i("BaichuanTLOG", (String)localObject1);
        localObject1 = getPackageManager().getLaunchIntentForPackage(getPackageName());
        ((Intent)localObject1).addFlags(67108864);
        startActivity((Intent)localObject1);
      }
      finish();
      return;
    }
    finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\ui\activity\AliTradeNativeTaobaoClientActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */