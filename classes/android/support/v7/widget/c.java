package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

class c
  extends b
{
  public c(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.a.mIsSplit) {
      if (this.a.mSplitBackground != null) {
        this.a.mSplitBackground.getOutline(paramOutline);
      }
    }
    while (this.a.mBackground == null) {
      return;
    }
    this.a.mBackground.getOutline(paramOutline);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */