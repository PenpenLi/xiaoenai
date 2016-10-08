package org.cocos2dx.lib;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ResizeLayout
  extends FrameLayout
{
  private boolean mEnableForceDoLayout = false;
  
  public ResizeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ResizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mEnableForceDoLayout) {
      new Handler().postDelayed(new ResizeLayout.1(this), 41L);
    }
  }
  
  public void setEnableForceDoLayout(boolean paramBoolean)
  {
    this.mEnableForceDoLayout = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\ResizeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */