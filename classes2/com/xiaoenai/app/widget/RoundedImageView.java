package com.xiaoenai.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaoenai.app.R.styleable;

public class RoundedImageView
  extends ImageView
{
  private float a = 0.0F;
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  private RoundRectShape e;
  private final Paint f = new Paint();
  private Bitmap g;
  private BitmapShader h;
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
    a(paramContext, paramAttributeSet);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView);
    this.a = paramContext.getDimensionPixelSize(0, 0);
    this.b = paramContext.getDimensionPixelSize(1, 0);
    this.d = paramContext.getDimensionPixelSize(2, 0);
    this.c = paramContext.getDimensionPixelSize(3, 0);
    this.e = new RoundRectShape(new float[] { this.a, this.a, this.b, this.b, this.c, this.c, this.d, this.d }, null, null);
  }
  
  public float getBottomLeftRadius()
  {
    return this.d;
  }
  
  public float getBottomRightRadius()
  {
    return this.c;
  }
  
  public float getTopLeftRadius()
  {
    return this.a;
  }
  
  public float getTopRightRadius()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() != null)
    {
      this.g = ((BitmapDrawable)getDrawable()).getBitmap();
      this.h = new BitmapShader(this.g, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }
    this.f.setShader(this.h);
    this.e.resize(getWidth(), getHeight());
    this.e.draw(paramCanvas, this.f);
  }
  
  public void setBottomLeftRadius(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void setBottomRightRadius(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void setTopLeftRadius(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void setTopRightRadius(float paramFloat)
  {
    this.b = paramFloat;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\RoundedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */