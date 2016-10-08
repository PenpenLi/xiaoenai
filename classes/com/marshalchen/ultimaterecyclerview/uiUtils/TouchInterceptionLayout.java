package com.marshalchen.ultimaterecyclerview.uiUtils;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class TouchInterceptionLayout
  extends FrameLayout
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private PointF e;
  private MotionEvent f;
  private a g;
  
  public TouchInterceptionLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchInterceptionLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    paramMotionEvent.setAction(paramInt);
    return paramMotionEvent;
  }
  
  private void a(MotionEvent paramMotionEvent, MotionEvent... paramVarArgs)
  {
    if (paramMotionEvent == null) {
      return;
    }
    int i = getChildCount() - 1;
    label13:
    View localView;
    Object localObject;
    MotionEvent localMotionEvent;
    if (i >= 0)
    {
      localView = getChildAt(i);
      if (localView != null)
      {
        localObject = new Rect();
        localView.getHitRect((Rect)localObject);
        localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        if (((Rect)localObject).contains((int)localMotionEvent.getX(), (int)localMotionEvent.getY())) {
          break label82;
        }
      }
    }
    label82:
    boolean bool2;
    do
    {
      i -= 1;
      break label13;
      break;
      float f1 = -localView.getLeft();
      float f2 = -localView.getTop();
      if (paramVarArgs != null)
      {
        int k = paramVarArgs.length;
        int j = 0;
        for (boolean bool1 = false;; bool1 = bool2)
        {
          bool2 = bool1;
          if (j >= k) {
            break;
          }
          localObject = paramVarArgs[j];
          bool2 = bool1;
          if (localObject != null)
          {
            localObject = MotionEvent.obtainNoHistory((MotionEvent)localObject);
            ((MotionEvent)localObject).offsetLocation(f1, f2);
            bool2 = bool1 | localView.dispatchTouchEvent((MotionEvent)localObject);
          }
          j += 1;
        }
      }
      bool2 = false;
      localMotionEvent.offsetLocation(f1, f2);
    } while (!(bool2 | localView.dispatchTouchEvent(localMotionEvent)));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.g == null) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 1: 
    default: 
      return false;
    case 0: 
      this.e = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.f = MotionEvent.obtainNoHistory(paramMotionEvent);
      this.b = true;
      this.a = this.g.a(paramMotionEvent, false, 0.0F, 0.0F);
      this.c = this.a;
      this.d = false;
      return this.a;
    }
    if (this.e == null) {
      this.e = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    float f1 = paramMotionEvent.getX();
    float f2 = this.e.x;
    float f3 = paramMotionEvent.getY();
    float f4 = this.e.y;
    this.a = this.g.a(paramMotionEvent, true, f1 - f2, f3 - f4);
    return this.a;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.g != null) {}
    MotionEvent localMotionEvent;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
      do
      {
        return super.onTouchEvent(paramMotionEvent);
      } while (!this.a);
      this.g.a(paramMotionEvent);
      a(paramMotionEvent, new MotionEvent[0]);
      return true;
    case 2: 
      if (this.e == null) {
        this.e = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      float f2 = paramMotionEvent.getX() - this.e.x;
      float f1 = paramMotionEvent.getY() - this.e.y;
      this.a = this.g.a(paramMotionEvent, true, f2, f1);
      if (this.a)
      {
        if (!this.c)
        {
          this.c = true;
          localMotionEvent = MotionEvent.obtainNoHistory(this.f);
          localMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
          this.g.a(localMotionEvent);
          this.e = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
          f1 = 0.0F;
          f2 = 0.0F;
        }
        if (!this.d)
        {
          this.d = true;
          a(a(paramMotionEvent, 3), new MotionEvent[0]);
        }
        this.g.a(paramMotionEvent, f2, f1);
        this.b = true;
        return true;
      }
      if (this.b)
      {
        this.b = false;
        localMotionEvent = MotionEvent.obtainNoHistory(this.f);
        localMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
        a(paramMotionEvent, new MotionEvent[] { localMotionEvent });
      }
      for (;;)
      {
        this.c = false;
        this.d = false;
        break;
        a(paramMotionEvent, new MotionEvent[0]);
      }
    }
    this.c = false;
    if (this.a) {
      this.g.b(paramMotionEvent);
    }
    if (!this.d)
    {
      this.d = true;
      if (!this.b) {
        break label420;
      }
      this.b = false;
      localMotionEvent = MotionEvent.obtainNoHistory(this.f);
      localMotionEvent.setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
      a(paramMotionEvent, new MotionEvent[] { localMotionEvent });
    }
    for (;;)
    {
      return true;
      label420:
      a(paramMotionEvent, new MotionEvent[0]);
    }
  }
  
  public void setScrollInterceptionListener(a parama)
  {
    this.g = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(MotionEvent paramMotionEvent);
    
    public abstract void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2);
    
    public abstract boolean a(MotionEvent paramMotionEvent, boolean paramBoolean, float paramFloat1, float paramFloat2);
    
    public abstract void b(MotionEvent paramMotionEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\uiUtils\TouchInterceptionLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */