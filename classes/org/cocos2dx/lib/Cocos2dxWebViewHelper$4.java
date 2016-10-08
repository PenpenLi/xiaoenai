package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxWebViewHelper$4
  implements Runnable
{
  Cocos2dxWebViewHelper$4(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Cocos2dxWebView localCocos2dxWebView = (Cocos2dxWebView)Cocos2dxWebViewHelper.access$200().get(this.val$index);
    if (localCocos2dxWebView != null) {
      localCocos2dxWebView.setWebViewRect(this.val$left, this.val$top, this.val$maxWidth, this.val$maxHeight);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxWebViewHelper$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */