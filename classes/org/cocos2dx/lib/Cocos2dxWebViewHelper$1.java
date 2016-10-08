package org.cocos2dx.lib;

import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

final class Cocos2dxWebViewHelper$1
  implements Runnable
{
  Cocos2dxWebViewHelper$1(int paramInt) {}
  
  public void run()
  {
    Cocos2dxWebView localCocos2dxWebView = new Cocos2dxWebView(Cocos2dxWebViewHelper.access$000(), this.val$index);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    Cocos2dxWebViewHelper.access$100().addView(localCocos2dxWebView, localLayoutParams);
    Cocos2dxWebViewHelper.access$200().put(this.val$index, localCocos2dxWebView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxWebViewHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */