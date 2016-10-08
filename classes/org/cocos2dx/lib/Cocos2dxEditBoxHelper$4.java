package org.cocos2dx.lib;

import android.graphics.Color;
import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$4
  implements Runnable
{
  Cocos2dxEditBoxHelper$4(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null) {
      localCocos2dxEditBox.setTextColor(Color.argb(this.val$alpha, this.val$red, this.val$green, this.val$blue));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */