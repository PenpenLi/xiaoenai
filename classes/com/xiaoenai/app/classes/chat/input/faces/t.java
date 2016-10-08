package com.xiaoenai.app.classes.chat.input.faces;

import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.GridView;
import com.xiaoenai.app.widget.CustomViewPager;

public class t
  implements View.OnTouchListener
{
  int a = -1;
  GridView b;
  View c;
  final Handler d = new Handler();
  Runnable e = new u(this);
  private p f;
  private CustomViewPager g = null;
  private a h;
  private int i = 1;
  
  public t(CustomViewPager paramCustomViewPager, p paramp, a parama, int paramInt)
  {
    this.g = paramCustomViewPager;
    this.f = paramp;
    this.h = parama;
    this.i = paramInt;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int k = 0;
    int j = 0;
    this.b = ((GridView)paramView);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      long l1;
      long l2;
      do
      {
        return true;
        do
        {
          j += 1;
          if (j >= this.b.getChildCount()) {
            break;
          }
          paramView = this.b.getChildAt(j);
        } while (!new Rect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
        this.a = j;
        this.c = paramView;
        this.d.postDelayed(this.e, 500L);
        return true;
        l1 = paramMotionEvent.getEventTime();
        l2 = paramMotionEvent.getDownTime();
        this.d.removeCallbacks(this.e);
      } while (l1 - l2 <= 500L);
      j = 0;
      while (j < this.b.getChildCount())
      {
        paramView = this.b.getChildAt(j);
        if ((new Rect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.f.b() != j))
        {
          this.f.a();
          paramMotionEvent = this.h.a(j);
          if (paramMotionEvent != null) {
            this.f.a(paramView, paramMotionEvent, j);
          }
          if (this.h == null) {
            break;
          }
          this.h.a(false);
          return true;
        }
        j += 1;
      }
      this.d.removeCallbacks(this.e);
      this.f.a();
      j = k;
      if (this.h != null)
      {
        this.h.a(true);
        j = k;
      }
      while (j < this.b.getChildCount())
      {
        paramView = this.b.getChildAt(j);
        if (new Rect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        {
          if ((this.a != j) || (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() >= 500L)) {
            break;
          }
          if (this.h != null) {
            this.h.a(this.h.a(j));
          }
          this.a = -1;
          return true;
        }
        j += 1;
      }
      this.d.removeCallbacks(this.e);
      this.f.a();
    } while (this.h == null);
    this.h.a(true);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract String a(int paramInt);
    
    public abstract void a(String paramString);
    
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */