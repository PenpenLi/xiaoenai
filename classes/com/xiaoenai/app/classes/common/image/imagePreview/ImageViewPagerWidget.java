package com.xiaoenai.app.classes.common.image.imagePreview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ImageViewPagerWidget
  extends ViewPager
{
  public ImageViewPagerWidget(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageViewPagerWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      for (;;)
      {
        paramMotionEvent.printStackTrace();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      for (;;)
      {
        paramMotionEvent.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\ImageViewPagerWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */