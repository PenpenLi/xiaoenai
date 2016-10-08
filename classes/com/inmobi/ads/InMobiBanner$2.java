package com.inmobi.ads;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.inmobi.commons.core.utilities.info.DisplayInfo;

class InMobiBanner$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  InMobiBanner$2(InMobiBanner paramInMobiBanner) {}
  
  public void onGlobalLayout()
  {
    InMobiBanner.access$502(this.a, DisplayInfo.b(this.a.getMeasuredWidth()));
    InMobiBanner.access$602(this.a, DisplayInfo.b(this.a.getMeasuredHeight()));
    if (this.a.hasValidSize())
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
    else {
      return;
    }
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiBanner$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */