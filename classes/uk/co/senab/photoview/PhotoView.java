package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class PhotoView
  extends ImageView
  implements c
{
  private d a;
  private ImageView.ScaleType b;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    a();
  }
  
  protected void a()
  {
    if ((this.a == null) || (this.a.c() == null)) {
      this.a = new d(this);
    }
    if (this.b != null)
    {
      setScaleType(this.b);
      this.b = null;
    }
  }
  
  public Matrix getDisplayMatrix()
  {
    return this.a.l();
  }
  
  public RectF getDisplayRect()
  {
    return this.a.b();
  }
  
  public c getIPhotoViewImplementation()
  {
    return this.a;
  }
  
  @Deprecated
  public float getMaxScale()
  {
    return getMaximumScale();
  }
  
  public float getMaximumScale()
  {
    return this.a.f();
  }
  
  public float getMediumScale()
  {
    return this.a.e();
  }
  
  @Deprecated
  public float getMidScale()
  {
    return getMediumScale();
  }
  
  @Deprecated
  public float getMinScale()
  {
    return getMinimumScale();
  }
  
  public float getMinimumScale()
  {
    return this.a.d();
  }
  
  @Deprecated
  public d.d getOnPhotoTapListener()
  {
    return this.a.i();
  }
  
  @Deprecated
  public d.g getOnViewTapListener()
  {
    return this.a.j();
  }
  
  public float getScale()
  {
    return this.a.g();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.a.h();
  }
  
  public Bitmap getVisibleRectangleBitmap()
  {
    return this.a.n();
  }
  
  protected void onAttachedToWindow()
  {
    a();
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    this.a.a();
    super.onDetachedFromWindow();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null) {
      this.a.k();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.a != null) {
      this.a.k();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.a != null) {
      this.a.k();
    }
  }
  
  @Deprecated
  public void setMaxScale(float paramFloat)
  {
    setMaximumScale(paramFloat);
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.a.e(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.a.d(paramFloat);
  }
  
  @Deprecated
  public void setMidScale(float paramFloat)
  {
    setMediumScale(paramFloat);
  }
  
  @Deprecated
  public void setMinScale(float paramFloat)
  {
    setMinimumScale(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.a.c(paramFloat);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.a(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a.a(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(d.c paramc)
  {
    this.a.a(paramc);
  }
  
  public void setOnPhotoTapListener(d.d paramd)
  {
    this.a.a(paramd);
  }
  
  public void setOnScaleChangeListener(d.e parame)
  {
    this.a.a(parame);
  }
  
  public void setOnSingleFlingListener(d.f paramf)
  {
    this.a.a(paramf);
  }
  
  public void setOnViewTapListener(d.g paramg)
  {
    this.a.a(paramg);
  }
  
  public void setPhotoViewRotation(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.a.b(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.a.f(paramFloat);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.a != null)
    {
      this.a.a(paramScaleType);
      return;
    }
    this.b = paramScaleType;
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\uk\co\senab\photoview\PhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */