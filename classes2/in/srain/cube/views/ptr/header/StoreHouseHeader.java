package in.srain.cube.views.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Transformation;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.a.a;
import in.srain.cube.views.ptr.b.b;
import in.srain.cube.views.ptr.d;
import java.util.ArrayList;

public class StoreHouseHeader
  extends View
  implements d
{
  public ArrayList<j> a = new ArrayList();
  private int b = -1;
  private float c = 1.0F;
  private int d = -1;
  private float e = 0.7F;
  private int f = -1;
  private float g = 0.0F;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private float l = 0.4F;
  private float m = 1.0F;
  private float n = 0.4F;
  private int o = 1000;
  private int p = 1000;
  private int q = 400;
  private Transformation r = new Transformation();
  private boolean s = false;
  private a t = new a(null);
  private int u = -1;
  
  public StoreHouseHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public StoreHouseHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    b.a(getContext());
    this.b = b.a(1.0F);
    this.d = b.a(40.0F);
    this.f = (b.a / 2);
  }
  
  private void b()
  {
    this.s = true;
    a.a(this.t);
    invalidate();
  }
  
  private void c()
  {
    this.s = false;
    a.b(this.t);
  }
  
  private int getBottomOffset()
  {
    return getPaddingBottom() + b.a(10.0F);
  }
  
  private int getTopOffset()
  {
    return getPaddingTop() + b.a(10.0F);
  }
  
  private void setProgress(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout)
  {
    c();
    int i1 = 0;
    while (i1 < this.a.size())
    {
      ((j)this.a.get(i1)).a(this.f);
      i1 += 1;
    }
  }
  
  public void a(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, a parama)
  {
    setProgress(Math.min(1.0F, parama.w()));
    invalidate();
  }
  
  public void b(PtrFrameLayout paramPtrFrameLayout) {}
  
  public void c(PtrFrameLayout paramPtrFrameLayout)
  {
    b();
  }
  
  public void d(PtrFrameLayout paramPtrFrameLayout)
  {
    c();
  }
  
  public int getLoadingAniDuration()
  {
    return this.o;
  }
  
  public float getScale()
  {
    return this.c;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f2 = this.g;
    int i2 = paramCanvas.save();
    int i3 = this.a.size();
    int i1 = 0;
    if (i1 < i3)
    {
      paramCanvas.save();
      j localj = (j)this.a.get(i1);
      float f1 = this.j;
      float f3 = localj.a.x + f1;
      f1 = this.k;
      float f4 = localj.a.y + f1;
      if (this.s)
      {
        localj.getTransformation(getDrawingTime(), this.r);
        paramCanvas.translate(f3, f4);
      }
      label156:
      float f5;
      for (;;)
      {
        localj.a(paramCanvas);
        paramCanvas.restore();
        for (;;)
        {
          i1 += 1;
          break;
          if (f2 != 0.0F) {
            break label156;
          }
          localj.a(this.f);
        }
        f1 = (1.0F - this.e) * i1 / i3;
        f5 = this.e;
        if ((f2 != 1.0F) && (f2 < 1.0F - (1.0F - f5 - f1))) {
          break label216;
        }
        paramCanvas.translate(f3, f4);
        localj.a(this.l);
      }
      label216:
      if (f2 <= f1) {}
      for (f1 = 0.0F;; f1 = Math.min(1.0F, (f2 - f1) / this.e))
      {
        f5 = localj.b;
        float f6 = -this.d;
        Matrix localMatrix = new Matrix();
        localMatrix.postRotate(360.0F * f1);
        localMatrix.postScale(f1, f1);
        localMatrix.postTranslate(f3 + f5 * (1.0F - f1), f4 + f6 * (1.0F - f1));
        localj.a(f1 * this.l);
        paramCanvas.concat(localMatrix);
        break;
      }
    }
    if (this.s) {
      invalidate();
    }
    paramCanvas.restoreToCount(i2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getTopOffset() + this.i + getBottomOffset(), 1073741824));
    this.j = ((getMeasuredWidth() - this.h) / 2);
    this.k = getTopOffset();
    this.d = getTopOffset();
  }
  
  public void setLoadingAniDuration(int paramInt)
  {
    this.o = paramInt;
    this.p = paramInt;
  }
  
  public void setScale(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  private class a
    implements Runnable
  {
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private boolean f = true;
    
    private a() {}
    
    private void a()
    {
      this.f = true;
      this.b = 0;
      this.e = (StoreHouseHeader.a(StoreHouseHeader.this) / StoreHouseHeader.this.a.size());
      this.c = (StoreHouseHeader.b(StoreHouseHeader.this) / this.e);
      this.d = (StoreHouseHeader.this.a.size() / this.c + 1);
      run();
    }
    
    private void b()
    {
      this.f = false;
      StoreHouseHeader.this.removeCallbacks(this);
    }
    
    public void run()
    {
      int j = this.b;
      int k = this.c;
      int i = 0;
      if (i < this.d)
      {
        int m = this.c * i + j % k;
        if (m > this.b) {}
        for (;;)
        {
          i += 1;
          break;
          int n = StoreHouseHeader.this.a.size();
          j localj = (j)StoreHouseHeader.this.a.get(m % n);
          localj.setFillAfter(false);
          localj.setFillEnabled(true);
          localj.setFillBefore(false);
          localj.setDuration(StoreHouseHeader.c(StoreHouseHeader.this));
          localj.a(StoreHouseHeader.d(StoreHouseHeader.this), StoreHouseHeader.e(StoreHouseHeader.this));
        }
      }
      this.b += 1;
      if (this.f) {
        StoreHouseHeader.this.postDelayed(this, this.e);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\StoreHouseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */