package com.xiaoenai.app.classes.gameCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomScrollView
  extends ScrollView
{
  private GestureDetector a = new GestureDetector(paramContext, new a());
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFadingEdgeLength(0);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (super.onInterceptTouchEvent(paramMotionEvent)) && (this.a.onTouchEvent(paramMotionEvent));
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    a() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return Math.abs(paramFloat2) > Math.abs(paramFloat1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\view\CustomScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */