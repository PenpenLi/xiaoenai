package org.cocos2dx.lib;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class Cocos2dxEditBoxHelper$1$3
  implements View.OnKeyListener
{
  Cocos2dxEditBoxHelper$1$3(Cocos2dxEditBoxHelper.1 param1, Cocos2dxEditBox paramCocos2dxEditBox) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 66) && ((this.val$editBox.getInputType() & 0x20000) != 131072))
    {
      Cocos2dxEditBoxHelper.closeKeyboard(this.this$0.val$index);
      Cocos2dxEditBoxHelper.access$000().getGLSurfaceView().requestFocus();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$1$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */