package com.xiaoenai.app.feature.photoalbum.view.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CanotSlidingViewpager
  extends ViewPager
{
  private boolean a = true;
  
  public CanotSlidingViewpager(Context paramContext)
  {
    super(paramContext);
  }
  
  public CanotSlidingViewpager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setScrollble(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\widget\CanotSlidingViewpager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */