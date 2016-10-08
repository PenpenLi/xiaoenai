package com.inmobi.rendering;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class RenderView$7$5
  implements View.OnKeyListener
{
  RenderView$7$5(RenderView.7 param7) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Back pressed when HTML5 video is playing.");
      RenderView.7.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\RenderView$7$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */