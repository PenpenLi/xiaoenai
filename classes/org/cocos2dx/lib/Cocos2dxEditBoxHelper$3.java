package org.cocos2dx.lib;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.SparseArray;

final class Cocos2dxEditBoxHelper$3
  implements Runnable
{
  Cocos2dxEditBoxHelper$3(int paramInt, String paramString, float paramFloat) {}
  
  public void run()
  {
    Cocos2dxEditBox localCocos2dxEditBox = (Cocos2dxEditBox)Cocos2dxEditBoxHelper.access$300().get(this.val$index);
    if (localCocos2dxEditBox != null) {
      if (this.val$fontName.isEmpty()) {
        break label76;
      }
    }
    label76:
    for (Typeface localTypeface = Typeface.create(this.val$fontName, 0);; localTypeface = Typeface.DEFAULT)
    {
      if (this.val$fontSize >= 0.0F)
      {
        float f = Cocos2dxEditBoxHelper.access$000().getResources().getDisplayMetrics().density;
        localCocos2dxEditBox.setTextSize(2, this.val$fontSize / f);
      }
      localCocos2dxEditBox.setTypeface(localTypeface);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxEditBoxHelper$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */