package com.alibaba.sdk.android.security.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.trace.AliSDKLogger;

class AccessControllerManager$1
  implements PropertyChangeListener
{
  AccessControllerManager$1(AccessControllerManager paramAccessControllerManager) {}
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    if (("ACL_EXPIREDIN".equals(paramString1)) && (!TextUtils.isEmpty(paramString3))) {}
    try
    {
      long l = Long.parseLong(paramString3);
      AccessControllerManager.access$002(this.this$0, l + AccessControllerManager.access$100(this.this$0));
      SecurityGuardWrapper.INSTANCE.putValueInDynamicDataStore("alisdk.next_sdk_access_permissions_timestamp", String.valueOf(AccessControllerManager.access$000(this.this$0)));
      return;
    }
    catch (Exception paramString1)
    {
      AliSDKLogger.e("security", "Fail to update ACL_EXPIREDIN", paramString1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\AccessControllerManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */