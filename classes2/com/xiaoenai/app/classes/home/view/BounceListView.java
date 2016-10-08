package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Scroller;
import com.xiaoenai.app.utils.ab;

public class BounceListView
  extends ListView
{
  ao a;
  int b;
  int c;
  float d;
  float e;
  float f;
  float g;
  int h;
  int i;
  int j;
  View k;
  View l;
  boolean m;
  private Context n;
  private Scroller o;
  private int p = 0;
  private boolean q = true;
  
  public BounceListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.n = paramContext;
    this.o = new Scroller(this.n);
  }
  
  public BounceListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void computeScroll()
  {
    if (!this.q) {
      super.computeScroll();
    }
    int i2;
    do
    {
      do
      {
        return;
      } while (!this.o.computeScrollOffset());
      int i1 = this.o.getCurrX();
      i2 = this.o.getCurrY();
      this.l.layout(0, 0, i1 + this.l.getWidth(), i2);
      invalidate();
    } while ((this.o.isFinished()) || (!this.m) || (i2 <= 200) || (i2 >= this.p));
    this.l.setLayoutParams(new RelativeLayout.LayoutParams(this.l.getWidth(), i2));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.q) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.p == 0) {
      this.p = ab.b();
    }
    int i1 = paramMotionEvent.getAction();
    if (!this.o.isFinished()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.l = this.k.findViewById(2131558989);
    this.f = paramMotionEvent.getX();
    this.g = paramMotionEvent.getY();
    this.k.getTop();
    switch (i1)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.b = this.l.getLeft();
      this.c = this.l.getBottom();
      this.i = getWidth();
      this.j = getHeight();
      this.h = this.l.getHeight();
      this.d = this.f;
      this.e = this.g;
      this.a = new ao(this.l.getLeft(), this.l.getBottom(), this.l.getLeft(), this.l.getBottom() + 200);
      continue;
      if ((this.k.isShown()) && (this.k.getTop() >= 0))
      {
        if (this.a != null)
        {
          i1 = this.a.a(this.g - this.e);
          if ((i1 >= this.c) && (i1 <= this.k.getBottom() + 200) && (i1 < this.p)) {
            this.l.setLayoutParams(new RelativeLayout.LayoutParams(this.l.getWidth(), i1));
          }
        }
        this.m = false;
        continue;
        this.m = true;
        this.o.startScroll(this.l.getLeft(), this.l.getBottom(), 0 - this.l.getLeft(), this.h - this.l.getBottom(), 200);
        invalidate();
      }
    }
  }
  
  public void setBounceAble(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setHeadView(View paramView)
  {
    this.k = paramView;
  }
  
  public void setMaxlen(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\BounceListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */