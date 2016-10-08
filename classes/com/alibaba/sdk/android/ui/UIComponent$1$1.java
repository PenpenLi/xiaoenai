package com.alibaba.sdk.android.ui;

import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.ui.bus.UIBus;

class UIComponent$1$1
  implements PropertyChangeListener
{
  UIComponent$1$1(UIComponent.1 param1) {}
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    if (!"uibus-configs".equals(paramString1)) {
      return;
    }
    UIBus.getDefault().refresh();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\UIComponent$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */