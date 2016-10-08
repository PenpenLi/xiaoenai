package org.cocos2dx.lib;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class Cocos2dxEditBoxHelper$1$4
  implements TextView.OnEditorActionListener
{
  Cocos2dxEditBoxHelper$1$4(Cocos2dxEditBoxHelper.1 param1) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      Cocos2dxEditBoxHelper.closeKeyboard(this.this$0.val$index);
      Cocos2dxEditBoxHelper.access$000().getGLSurfaceView().requestFocus();
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$1$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */