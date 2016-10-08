package org.cocos2dx.lib;

import android.text.Editable;
import android.text.TextWatcher;

class Cocos2dxEditBoxHelper$1$1
  implements TextWatcher
{
  Cocos2dxEditBoxHelper$1$1(Cocos2dxEditBoxHelper.1 param1) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Cocos2dxEditBoxHelper.access$000().runOnGLThread(new Cocos2dxEditBoxHelper.1.1.1(this, paramCharSequence));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */