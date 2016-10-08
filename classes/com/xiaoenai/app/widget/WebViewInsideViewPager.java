package com.xiaoenai.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class WebViewInsideViewPager
  extends WebView
{
  private float a = 0.0F;
  
  public WebViewInsideViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebViewInsideViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebViewInsideViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return false;
    } while (((int)(getContentHeight() * getScale()) == getHeight() + getScrollY()) && ((paramMotionEvent.getY() < this.a) || (getScrollY() != 0)));
    return true;
  }
  
  public float getOldY()
  {
    return this.a;
  }
  
  public void setOldY(float paramFloat)
  {
    this.a = paramFloat;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\WebViewInsideViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */