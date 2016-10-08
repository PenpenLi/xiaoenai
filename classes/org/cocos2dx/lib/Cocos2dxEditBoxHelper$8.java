package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$8
  implements Runnable
{
  Cocos2dxEditBoxHelper$8(int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null) {
      if (!this.val$visible) {
        break label52;
      }
    }
    label52:
    for (int i = 0;; i = 8)
    {
      localCocos2dxEditBox.setVisibility(i);
      if (!this.val$visible) {
        break;
      }
      localCocos2dxEditBox.requestFocus();
      Cocos2dxEditBoxHelper.openKeyboard(this.val$index);
      return;
    }
    Cocos2dxEditBoxHelper.access$000().getGLSurfaceView().requestFocus();
    Cocos2dxEditBoxHelper.closeKeyboard(this.val$index);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */