package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$11
  implements Runnable
{
  Cocos2dxEditBoxHelper$11(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null) {
      localCocos2dxEditBox.setInputMode(this.val$inputMode);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */