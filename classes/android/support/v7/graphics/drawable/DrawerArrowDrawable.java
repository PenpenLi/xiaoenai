package android.support.v7.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable
  extends Drawable
{
  private static final float b = (float)Math.toRadians(45.0D);
  private final Paint a;
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g;
  private final Path h;
  private final int i;
  private boolean j;
  private float k;
  private float l;
  private int m;
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int n;
    float f1;
    label137:
    float f2;
    switch (this.m)
    {
    case 2: 
    default: 
      if (DrawableCompat.getLayoutDirection(this) == 1)
      {
        n = 1;
        f1 = (float)Math.sqrt(this.c * this.c * 2.0F);
        float f5 = a(this.d, f1, this.k);
        float f3 = a(this.d, this.e, this.k);
        float f4 = Math.round(a(0.0F, this.l, this.k));
        float f6 = a(0.0F, b, this.k);
        if (n == 0) {
          break label452;
        }
        f1 = 0.0F;
        if (n == 0) {
          break label458;
        }
        f2 = 180.0F;
        label145:
        f1 = a(f1, f2, this.k);
        f2 = (float)Math.round(f5 * Math.cos(f6));
        f5 = (float)Math.round(f5 * Math.sin(f6));
        this.h.rewind();
        f6 = a(this.f + this.a.getStrokeWidth(), -this.l, this.k);
        float f7 = -f3 / 2.0F;
        this.h.moveTo(f7 + f4, 0.0F);
        this.h.rLineTo(f3 - f4 * 2.0F, 0.0F);
        this.h.moveTo(f7, f6);
        this.h.rLineTo(f2, f5);
        this.h.moveTo(f7, -f6);
        this.h.rLineTo(f2, -f5);
        this.h.close();
        paramCanvas.save();
        f2 = this.a.getStrokeWidth();
        f2 = (float)((int)(localRect.height() - 3.0F * f2 - this.f * 2.0F) / 4 * 2 + (f2 * 1.5D + this.f));
        paramCanvas.translate(localRect.centerX(), f2);
        if (!this.g) {
          break label469;
        }
        if ((n ^ this.j) == 0) {
          break label463;
        }
        n = -1;
        label389:
        paramCanvas.rotate(n * f1);
      }
      break;
    }
    for (;;)
    {
      paramCanvas.drawPath(this.h, this.a);
      paramCanvas.restore();
      return;
      n = 0;
      break;
      n = 1;
      break;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        n = 1;
        break;
      }
      n = 0;
      break;
      n = 0;
      break;
      label452:
      f1 = -180.0F;
      break label137;
      label458:
      f2 = 0.0F;
      break label145;
      label463:
      n = 1;
      break label389;
      label469:
      if (n != 0) {
        paramCanvas.rotate(180.0F);
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.i;
  }
  
  public int getIntrinsicWidth()
  {
    return this.i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.a.getAlpha())
    {
      this.a.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ArrowDirection {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\graphics\drawable\DrawerArrowDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */