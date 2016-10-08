package com.xiaoenai.app.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.xiaoenai.app.utils.ab;

public class TouchImageView
  extends ImageView
{
  static final int j = ab.a(10.0F);
  Matrix a;
  int b = 0;
  PointF c = new PointF();
  PointF d = new PointF();
  float e = 1.0F;
  float f = 3.0F;
  float[] g;
  int h;
  int i;
  float k = 1.0F;
  protected float l;
  protected float m;
  int n;
  int o;
  ScaleGestureDetector p;
  Context q;
  private boolean r;
  private Handler s = null;
  private a t = null;
  
  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    this.r = true;
    if (this.s == null) {
      this.s = new Handler();
    }
    if (this.t != null) {
      this.s.removeCallbacks(this.t);
    }
    for (;;)
    {
      this.s.postDelayed(this.t, ViewConfiguration.getLongPressTimeout() - paramInt);
      return;
      this.t = new a();
    }
  }
  
  @TargetApi(8)
  private void a(Context paramContext)
  {
    super.setClickable(true);
    this.q = paramContext;
    if (Build.VERSION.SDK_INT >= 8) {
      this.p = new ScaleGestureDetector(paramContext, new b(null));
    }
    this.a = new Matrix();
    this.g = new float[9];
    setImageMatrix(this.a);
    setScaleType(ImageView.ScaleType.MATRIX);
    setOnTouchListener(new v(this));
  }
  
  private void b()
  {
    this.r = false;
    if ((this.s != null) && (this.t != null)) {
      this.s.removeCallbacks(this.t);
    }
  }
  
  float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 0.0F;
    if (paramFloat3 <= paramFloat2)
    {
      paramFloat2 -= paramFloat3;
      paramFloat3 = 0.0F;
      if (paramFloat1 >= paramFloat3) {
        break label37;
      }
      paramFloat3 = -paramFloat1 + paramFloat3;
    }
    label37:
    do
    {
      return paramFloat3;
      paramFloat3 = paramFloat2 - paramFloat3;
      paramFloat2 = 0.0F;
      break;
      paramFloat3 = f1;
    } while (paramFloat1 <= paramFloat2);
    return -paramFloat1 + paramFloat2;
  }
  
  void a()
  {
    this.a.getValues(this.g);
    float f2 = this.g[2];
    float f1 = this.g[5];
    f2 = a(f2, this.h, this.l * this.k);
    f1 = a(f1, this.i, this.m * this.k);
    if ((f2 != 0.0F) || (f1 != 0.0F)) {
      this.a.postTranslate(f2, f1);
    }
  }
  
  float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 <= paramFloat2) {
      paramFloat1 = 0.0F;
    }
    return paramFloat1;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool = false;
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0)) {
      bool = true;
    }
    float f1;
    float f2;
    do
    {
      return bool;
      paramInt = localDrawable.getIntrinsicWidth();
      f1 = this.h / paramInt;
      this.a.getValues(this.g);
      f2 = Math.abs(this.g[0]);
      Log.d("canScrollHorizontally", String.format("%f -- %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) }));
    } while (f2 * 0.95D <= f1);
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.h = View.MeasureSpec.getSize(paramInt1);
    this.i = View.MeasureSpec.getSize(paramInt2);
    if (((this.o == this.h) && (this.o == this.i)) || (this.h == 0) || (this.i == 0)) {}
    Drawable localDrawable;
    do
    {
      return;
      this.o = this.i;
      this.n = this.h;
      if (this.k != 1.0F) {
        break;
      }
      localDrawable = getDrawable();
    } while ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0));
    paramInt1 = localDrawable.getIntrinsicWidth();
    paramInt2 = localDrawable.getIntrinsicHeight();
    Log.d("bmSize", "bmWidth: " + paramInt1 + " bmHeight : " + paramInt2);
    float f1 = Math.min(this.h / paramInt1, this.i / paramInt2);
    this.a.setScale(f1, f1);
    float f4 = this.i;
    float f5 = paramInt2;
    float f2 = this.h;
    float f3 = paramInt1;
    f4 = (f4 - f5 * f1) / 2.0F;
    f1 = (f2 - f3 * f1) / 2.0F;
    this.a.postTranslate(f1, f4);
    this.l = (this.h - f1 * 2.0F);
    this.m = (this.i - f4 * 2.0F);
    setImageMatrix(this.a);
    a();
  }
  
  public void setMaxZoom(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      if (TouchImageView.a(TouchImageView.this)) {
        TouchImageView.a(TouchImageView.this, false);
      }
      try
      {
        TouchImageView.this.performLongClick();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  @TargetApi(8)
  private class b
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private b() {}
    
    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      float f1 = paramScaleGestureDetector.getScaleFactor();
      float f2 = TouchImageView.this.k;
      TouchImageView localTouchImageView = TouchImageView.this;
      localTouchImageView.k *= f1;
      if (TouchImageView.this.k > TouchImageView.this.f)
      {
        TouchImageView.this.k = TouchImageView.this.f;
        f1 = TouchImageView.this.f / f2;
        if ((TouchImageView.this.l * TouchImageView.this.k > TouchImageView.this.h) && (TouchImageView.this.m * TouchImageView.this.k > TouchImageView.this.i)) {
          break label214;
        }
        TouchImageView.this.a.postScale(f1, f1, TouchImageView.this.h / 2, TouchImageView.this.i / 2);
      }
      for (;;)
      {
        TouchImageView.this.a();
        return true;
        if (TouchImageView.this.k >= TouchImageView.this.e) {
          break;
        }
        TouchImageView.this.k = TouchImageView.this.e;
        f1 = TouchImageView.this.e / f2;
        break;
        label214:
        TouchImageView.this.a.postScale(f1, f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      }
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.this.b = 2;
      return true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\TouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */