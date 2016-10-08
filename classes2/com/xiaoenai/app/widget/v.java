package com.xiaoenai.app.widget;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;

class v
  implements View.OnTouchListener
{
  v(TouchImageView paramTouchImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.p != null) {
      this.a.p.onTouchEvent(paramMotionEvent);
    }
    paramView = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    int i = (int)Math.abs(paramView.x - this.a.d.x);
    int j = (int)Math.abs(paramView.y - this.a.d.y);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.a.setImageMatrix(this.a.a);
      this.a.invalidate();
      return true;
      this.a.c.set(paramView);
      this.a.d.set(this.a.c);
      this.a.b = 1;
      TouchImageView.a(this.a, 65036);
      continue;
      if (this.a.b == 1)
      {
        float f3 = paramView.x;
        float f4 = this.a.c.x;
        float f1 = paramView.y;
        float f2 = this.a.c.y;
        f3 = this.a.b(f3 - f4, this.a.h, this.a.l * this.a.k);
        f1 = this.a.b(f1 - f2, this.a.i, this.a.m * this.a.k);
        this.a.a.postTranslate(f3, f1);
        this.a.a();
        this.a.c.set(paramView.x, paramView.y);
      }
      if ((i > TouchImageView.j) || (j > TouchImageView.j))
      {
        TouchImageView.b(this.a);
        continue;
        this.a.b = 0;
        if ((i < TouchImageView.j) && (j < TouchImageView.j)) {
          this.a.performClick();
        }
        TouchImageView.b(this.a);
        continue;
        this.a.b = 0;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */