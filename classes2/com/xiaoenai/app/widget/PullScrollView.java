package com.xiaoenai.app.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;

public class PullScrollView
  extends ScrollView
{
  private ImageView a;
  private int b;
  private View c;
  private Rect d = new Rect();
  private float e;
  private boolean f = false;
  private boolean g = false;
  private int h;
  private int i;
  private int j;
  private int k;
  private a l;
  private b m = b.c;
  
  public PullScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, Math.abs(this.h - this.j), 0.0F);
    localTranslateAnimation.setDuration(200L);
    this.a.startAnimation(localTranslateAnimation);
    this.a.layout(this.a.getLeft(), this.h, this.a.getRight(), this.i);
    localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.c.getTop(), this.d.top);
    localTranslateAnimation.setDuration(200L);
    this.c.startAnimation(localTranslateAnimation);
    this.c.layout(this.d.left, this.d.top, this.d.right, this.d.bottom);
    this.d.setEmpty();
    if ((this.j > this.h + 50) && (this.l != null)) {
      this.l.a();
    }
  }
  
  private void a(float paramFloat)
  {
    float f2 = 0.0F;
    label41:
    float f1;
    if ((paramFloat < 0.0F) && (this.m == b.c))
    {
      this.m = b.a;
      if (this.m != b.a) {
        break label293;
      }
      if (paramFloat >= 0.0F) {
        break label288;
      }
      this.g = false;
      this.f = false;
      f1 = paramFloat;
    }
    label288:
    label293:
    do
    {
      if (this.g)
      {
        if (this.d.isEmpty()) {
          this.d.set(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
        }
        paramFloat = 0.5F * f1 * 0.35F;
        this.j = ((int)(this.h + paramFloat));
        this.k = ((int)(paramFloat + this.i));
        this.a.layout(this.a.getLeft(), this.j, this.a.getRight(), this.k);
        f1 *= 0.35F;
        int n = this.k - this.b;
        paramFloat = f1;
        if (this.d.top + f1 > n) {
          paramFloat = f1 - (this.d.top + f1 - n);
        }
        this.c.layout(this.d.left, (int)(this.d.top + paramFloat), this.d.right, (int)(paramFloat + this.d.bottom));
      }
      return;
      if ((paramFloat <= 0.0F) || (this.m != b.c)) {
        break;
      }
      this.m = b.b;
      break;
      paramFloat = 0.0F;
      break label41;
      f1 = paramFloat;
    } while (this.m != b.b);
    if (getScrollY() <= paramFloat)
    {
      this.f = true;
      this.g = true;
    }
    if (paramFloat < 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      f1 = paramFloat;
      break;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 0: 
      this.e = paramMotionEvent.getY();
      int n = this.a.getTop();
      this.h = n;
      this.j = n;
      n = this.a.getBottom();
      this.i = n;
      this.k = n;
      return;
    case 2: 
      a(paramMotionEvent.getY() - this.e);
      return;
    }
    if (b()) {
      a();
    }
    if (getScrollY() == 0) {
      this.m = b.c;
    }
    this.g = false;
    this.f = false;
  }
  
  private boolean b()
  {
    return (!this.d.isEmpty()) && (this.g);
  }
  
  protected void onFinishInflate()
  {
    if (getChildCount() > 0) {
      this.c = getChildAt(0);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (getScrollY() == 0) {
      this.m = b.c;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.c != null) {
      a(paramMotionEvent);
    }
    if (this.f) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnTurnListener(a parama)
  {
    this.l = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  private static enum b
  {
    private b() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\PullScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */