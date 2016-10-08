package com.alibaba.sdk.android.initialization.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.alibaba.sdk.android.config.PropertyChangeListener;
import java.util.Timer;

class DynamicConfigInitHandler$1
  implements PropertyChangeListener
{
  DynamicConfigInitHandler$1(DynamicConfigInitHandler paramDynamicConfigInitHandler) {}
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if ("DISABLE_CONFIG_POLL".equals(paramString1))
        {
          if (("T".equals(paramString3)) && (DynamicConfigInitHandler.access$000(this.this$0) != null))
          {
            DynamicConfigInitHandler.access$000(this.this$0).cancel();
            DynamicConfigInitHandler.access$002(this.this$0, null);
            return;
          }
          if ((!"F".equals(paramString3)) || (DynamicConfigInitHandler.access$000(this.this$0) != null)) {
            continue;
          }
          this.this$0.startConfigFetchThread();
          continue;
        }
        if (!"CONFIG_POLL_INTERVAL".equals(paramString1)) {
          continue;
        }
      }
      finally {}
      if ((paramString3 != null) && (!paramString3.equals(String.valueOf(DynamicConfigInitHandler.access$100(this.this$0)))))
      {
        if (DynamicConfigInitHandler.access$000(this.this$0) != null)
        {
          DynamicConfigInitHandler.access$000(this.this$0).cancel();
          DynamicConfigInitHandler.access$002(this.this$0, null);
        }
        this.this$0.startConfigFetchThread();
      }
      else
      {
        boolean bool = "CONFIG_EXPIREDIN".equals(paramString1);
        if (bool) {
          try
          {
            if (!TextUtils.isEmpty(paramString3))
            {
              long l = Long.parseLong(paramString3);
              DynamicConfigInitHandler.access$200(this.this$0).edit().putLong("expireIn", l).commit();
            }
          }
          catch (Exception paramString1) {}
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\initialization\impl\DynamicConfigInitHandler$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */