package com.xiaoenai.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomScrollView
  extends ScrollView
{
  private float a;
  private float b;
  private float c;
  private float d;
  private a e = null;
  private float f = 0.0F;
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public float getOldY()
  {
    return this.f;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    float f1;
    float f3;
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.b = 0.0F;
        this.a = 0.0F;
        this.c = paramMotionEvent.getX();
        this.d = paramMotionEvent.getY();
      }
      f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      f3 = this.c;
      float f4 = this.d;
      this.a += Math.abs(f1 - this.c);
      this.b += Math.abs(f2 - this.d);
      this.c = f1;
      this.d = f2;
      if ((this.b > this.a) && (this.e != null)) {
        this.e.b(f2 - f4);
      }
    } while (this.a <= this.b);
    if (this.e != null) {
      this.e.a(f1 - f3);
    }
    return false;
  }
  
  public void setOldY(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void setOnGestureDetectorListener(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(float paramFloat);
    
    public abstract void b(float paramFloat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\CustomScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */