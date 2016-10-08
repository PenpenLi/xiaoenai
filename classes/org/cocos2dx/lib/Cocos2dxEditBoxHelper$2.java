package org.cocos2dx.lib;

import android.util.Log;
import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$2
  implements Runnable
{
  Cocos2dxEditBoxHelper$2(int paramInt) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null)
    {
      Cocos2dxEditBoxHelper.access$300().remove(this.val$index);
      Cocos2dxEditBoxHelper.access$100().removeView(localCocos2dxEditBox);
      Log.e(Cocos2dxEditBoxHelper.access$200(), "remove EditBox");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */