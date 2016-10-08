package org.cocos2dx.lib;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;

class Cocos2dxEditBoxHelper$1$2
  implements View.OnFocusChangeListener
{
  Cocos2dxEditBoxHelper$1$2(Cocos2dxEditBoxHelper.1 param1, Cocos2dxEditBox paramCocos2dxEditBox) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Cocos2dxEditBoxHelper.access$000().runOnGLThread(new Cocos2dxEditBoxHelper.1.2.1(this));
      this.val$editBox.setSelection(this.val$editBox.getText().length());
      Cocos2dxEditBoxHelper.access$100().setEnableForceDoLayout(true);
      Cocos2dxEditBoxHelper.access$000().getGLSurfaceView().setSoftKeyboardShown(true);
      Log.d(Cocos2dxEditBoxHelper.access$200(), "edit box get focus");
      return;
    }
    this.val$editBox.setVisibility(8);
    Cocos2dxEditBoxHelper.access$000().runOnGLThread(new Cocos2dxEditBoxHelper.1.2.2(this));
    Cocos2dxEditBoxHelper.access$100().setEnableForceDoLayout(false);
    Log.d(Cocos2dxEditBoxHelper.access$200(), "edit box lose focus");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$1$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */