package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$12
  implements Runnable
{
  Cocos2dxEditBoxHelper$12(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null) {
      localCocos2dxEditBox.setInputFlag(this.val$inputFlag);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */