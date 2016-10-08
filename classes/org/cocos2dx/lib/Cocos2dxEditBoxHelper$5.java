package org.cocos2dx.lib;

import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$5
  implements Runnable
{
  Cocos2dxEditBoxHelper$5(int paramInt, String paramString) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null) {
      localCocos2dxEditBox.setHint(this.val$text);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */