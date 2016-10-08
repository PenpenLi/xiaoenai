package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxWebViewHelper$6
  implements Runnable
{
  Cocos2dxWebViewHelper$6(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Cocos2dxWebView localCocos2dxWebView = (Cocos2dxWebView)Cocos2dxWebViewHelper.access$200().get(this.val$index);
    if (localCocos2dxWebView != null) {
      localCocos2dxWebView.loadDataWithBaseURL(this.val$baseURL, this.val$data, this.val$mimeType, this.val$encoding, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxWebViewHelper$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */