package org.cocos2dx.lib;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.widget.FrameLayout.LayoutParams;

final class Cocos2dxEditBoxHelper$1
  implements Runnable
{
  Cocos2dxEditBoxHelper$1(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = new Cocos2dxEditBox(Cocos2dxEditBoxHelper.access$000());
    localCocos2dxEditBox.setFocusable(true);
    localCocos2dxEditBox.setFocusableInTouchMode(true);
    localCocos2dxEditBox.setInputFlag(4);
    localCocos2dxEditBox.setInputMode(6);
    localCocos2dxEditBox.setReturnType(0);
    localCocos2dxEditBox.setHintTextColor(-7829368);
    localCocos2dxEditBox.setVisibility(4);
    localCocos2dxEditBox.setBackgroundColor(0);
    localCocos2dxEditBox.setTextColor(-1);
    localCocos2dxEditBox.setSingleLine();
    localCocos2dxEditBox.setOpenGLViewScaleX(this.val$scaleX);
    float f = Cocos2dxEditBoxHelper.access$000().getResources().getDisplayMetrics().density;
    int i = Cocos2dxEditBoxHelper.convertToSP((int)(this.val$height * 0.33F / f) - this.val$scaleX * 5.0F / f) / 2;
    localCocos2dxEditBox.setPadding(Cocos2dxEditBoxHelper.convertToSP((int)(this.val$scaleX * 5.0F / f)), i, 0, i);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.val$left;
    localLayoutParams.topMargin = this.val$top;
    localLayoutParams.width = this.val$width;
    localLayoutParams.height = this.val$height;
    localLayoutParams.gravity = 51;
    Cocos2dxEditBoxHelper.access$100().addView(localCocos2dxEditBox, localLayoutParams);
    localCocos2dxEditBox.addTextChangedListener(new Cocos2dxEditBoxHelper.1.1(this));
    localCocos2dxEditBox.setOnFocusChangeListener(new Cocos2dxEditBoxHelper.1.2(this, localCocos2dxEditBox));
    localCocos2dxEditBox.setOnKeyListener(new Cocos2dxEditBoxHelper.1.3(this, localCocos2dxEditBox));
    localCocos2dxEditBox.setOnEditorActionListener(new Cocos2dxEditBoxHelper.1.4(this));
    Cocos2dxEditBoxHelper.access$300().put(this.val$index, localCocos2dxEditBox);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */