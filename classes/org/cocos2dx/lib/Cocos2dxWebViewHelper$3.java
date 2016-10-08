package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxWebViewHelper$3
  implements Runnable
{
  Cocos2dxWebViewHelper$3(int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Cocos2dxWebView localCocos2dxWebView = (Cocos2dxWebView)Cocos2dxWebViewHelper.access$200().get(this.val$index);
    if (localCocos2dxWebView != null) {
      if (!this.val$visible) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 8)
    {
      localCocos2dxWebView.setVisibility(i);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxWebViewHelper$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */