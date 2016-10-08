package com.inmobi.rendering.mraid;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class MraidMediaProcessor$2
  implements View.OnKeyListener
{
  MraidMediaProcessor$2(MraidMediaProcessor paramMraidMediaProcessor) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      MraidMediaProcessor.a(this.a).a(true);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\MraidMediaProcessor$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */