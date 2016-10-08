package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$13
  implements Runnable
{
  Cocos2dxEditBoxHelper$13(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null) {
      localCocos2dxEditBox.setEditBoxViewRect(this.val$left, this.val$top, this.val$maxWidth, this.val$maxHeight);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */