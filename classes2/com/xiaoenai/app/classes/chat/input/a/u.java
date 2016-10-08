package com.xiaoenai.app.classes.chat.input.a;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.model.status.Status;

class u
  implements View.OnTouchListener
{
  private float d = -1.0F;
  private VelocityTracker e;
  private final int f = 30;
  
  u(i.a parama, Status paramStatus, TextView paramTextView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      this.e = VelocityTracker.obtain();
    }
    this.e.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i)
    {
    default: 
      if (paramMotionEvent.getAction() == 0)
      {
        this.b.getBackground().setColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -50.0F, 0.0F, 1.0F, 0.0F, 0.0F, -50.0F, 0.0F, 0.0F, 1.0F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        if (Build.VERSION.SDK_INT < 16)
        {
          this.b.setBackgroundDrawable(this.b.getBackground());
          this.b.setTextColor(this.b.getTextColors());
        }
      }
      break;
    }
    while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3))
    {
      return true;
      i.j(this.c.a).postDelayed(i.i(this.c.a), 1000L);
      this.d = f1;
      break;
      i = (int)(this.d - f1);
      this.d = f1;
      if (Math.abs(i) > 5) {}
      try
      {
        i.k(this.c.a).onTouchEvent(paramMotionEvent);
        if (Math.abs(i) <= 2) {
          break;
        }
        i.j(this.c.a).removeCallbacks(i.i(this.c.a));
      }
      catch (IllegalArgumentException paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
        }
      }
      if ((this.d == f1) && (!i.a(this.c.a))) {
        i.e(this.c.a).a(this.a.getContent(), this.a.getType());
      }
      i.j(this.c.a).removeCallbacks(i.i(this.c.a));
      break;
      this.b.setBackground(this.b.getBackground());
      this.b.setTextColor(this.b.getTextColors());
      return true;
    }
    this.b.getBackground().setColorFilter(new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
    if (Build.VERSION.SDK_INT < 16)
    {
      this.b.setBackgroundDrawable(this.b.getBackground());
      this.b.setTextColor(this.b.getTextColors());
      return true;
    }
    this.b.setBackground(this.b.getBackground());
    this.b.setTextColor(this.b.getTextColors());
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */