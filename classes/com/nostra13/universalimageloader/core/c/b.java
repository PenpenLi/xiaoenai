package com.nostra13.universalimageloader.core.c;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.a.f;

public class b
  implements a
{
  protected final Integer a;
  protected final float b;
  
  public b()
  {
    this(null);
  }
  
  public b(Integer paramInteger)
  {
    this(paramInteger, 0.0F);
  }
  
  public b(Integer paramInteger, float paramFloat)
  {
    this.a = paramInteger;
    this.b = paramFloat;
  }
  
  public void a(Bitmap paramBitmap, com.nostra13.universalimageloader.core.e.a parama, f paramf)
  {
    if (!(parama instanceof com.nostra13.universalimageloader.core.e.b)) {
      throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
    parama.a(new a(paramBitmap, this.a, this.b));
  }
  
  public static class a
    extends Drawable
  {
    protected float a;
    protected final RectF b = new RectF();
    protected final RectF c;
    protected final BitmapShader d;
    protected final Paint e;
    protected final Paint f;
    protected final float g;
    protected float h;
    
    public a(Bitmap paramBitmap, Integer paramInteger, float paramFloat)
    {
      this.a = (Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) / 2);
      this.d = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.c = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.e = new Paint();
      this.e.setAntiAlias(true);
      this.e.setShader(this.d);
      this.e.setFilterBitmap(true);
      this.e.setDither(true);
      if (paramInteger == null) {
        this.f = null;
      }
      for (;;)
      {
        this.g = paramFloat;
        this.h = (this.a - paramFloat / 2.0F);
        return;
        this.f = new Paint();
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setColor(paramInteger.intValue());
        this.f.setStrokeWidth(paramFloat);
        this.f.setAntiAlias(true);
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      paramCanvas.drawCircle(this.a, this.a, this.a, this.e);
      if (this.f != null) {
        paramCanvas.drawCircle(this.a, this.a, this.h, this.f);
      }
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    protected void onBoundsChange(Rect paramRect)
    {
      super.onBoundsChange(paramRect);
      this.b.set(0.0F, 0.0F, paramRect.width(), paramRect.height());
      this.a = (Math.min(paramRect.width(), paramRect.height()) / 2);
      this.h = (this.a - this.g / 2.0F);
      paramRect = new Matrix();
      paramRect.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
      this.d.setLocalMatrix(paramRect);
    }
    
    public void setAlpha(int paramInt)
    {
      this.e.setAlpha(paramInt);
    }
    
    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.e.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */