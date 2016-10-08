package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshBase.h;
import com.handmark.pulltorefresh.library.l.c;

@SuppressLint({"ViewConstructor"})
public class b
  extends f
{
  private final Animation f;
  private final Animation g;
  
  public b(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.h paramh, TypedArray paramTypedArray)
  {
    super(paramContext, paramb, paramh, paramTypedArray);
    if (paramb == PullToRefreshBase.b.b) {}
    for (int i = 65356;; i = 180)
    {
      this.f = new RotateAnimation(0.0F, i, 1, 0.5F, 1, 0.5F);
      this.f.setInterpolator(a);
      this.f.setDuration(150L);
      this.f.setFillAfter(true);
      this.g = new RotateAnimation(i, 0.0F, 1, 0.5F, 1, 0.5F);
      this.g.setInterpolator(a);
      this.g.setDuration(150L);
      this.g.setFillAfter(true);
      return;
    }
  }
  
  private float getDrawableRotationAngle()
  {
    switch (c.a[this.d.ordinal()])
    {
    }
    do
    {
      return 0.0F;
      if (this.e == PullToRefreshBase.h.b) {
        return 90.0F;
      }
      return 180.0F;
    } while (this.e != PullToRefreshBase.h.b);
    return 270.0F;
  }
  
  protected void a()
  {
    if (this.f == this.b.getAnimation()) {
      this.b.startAnimation(this.g);
    }
  }
  
  protected void a(float paramFloat) {}
  
  protected void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      paramDrawable = this.b.getLayoutParams();
      int k = Math.max(i, j);
      paramDrawable.height = k;
      paramDrawable.width = k;
      this.b.requestLayout();
      this.b.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate((paramDrawable.width - j) / 2.0F, (paramDrawable.height - i) / 2.0F);
      localMatrix.postRotate(getDrawableRotationAngle(), paramDrawable.width / 2.0F, paramDrawable.height / 2.0F);
      this.b.setImageMatrix(localMatrix);
    }
  }
  
  protected void b()
  {
    this.b.clearAnimation();
    this.b.setVisibility(4);
    this.c.setVisibility(0);
  }
  
  protected void c()
  {
    this.b.startAnimation(this.f);
  }
  
  protected void d()
  {
    this.b.clearAnimation();
    this.c.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  protected int getDefaultDrawableResId()
  {
    return l.c.default_ptr_flip;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\internal\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */