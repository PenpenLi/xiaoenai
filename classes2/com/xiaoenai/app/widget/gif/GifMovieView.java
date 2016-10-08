package com.xiaoenai.app.widget.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.xiaoenai.app.R.styleable;
import com.xiaoenai.app.utils.ab;
import java.io.InputStream;

public class GifMovieView
  extends ImageView
{
  private int a;
  private Movie b;
  private long c;
  private int d = 0;
  private float e;
  private float f;
  private float g;
  private int h;
  private int i;
  private volatile boolean j = false;
  private boolean k = true;
  
  public GifMovieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GifMovieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"NewApi"})
  private void a()
  {
    if (this.k)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        postInvalidateOnAnimation();
      }
    }
    else {
      return;
    }
    invalidate();
  }
  
  @SuppressLint({"NewApi"})
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GifMoviewView, paramInt, 2131296598);
    this.a = paramContext.getResourceId(0, -1);
    this.j = paramContext.getBoolean(1, false);
    paramContext.recycle();
    if (this.a != -1) {
      this.b = Movie.decodeStream(getResources().openRawResource(this.a));
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.b.setTime(this.d);
    paramCanvas.save(1);
    paramCanvas.scale(this.g, this.g);
    this.b.draw(paramCanvas, this.e / this.g, this.f / this.g);
    paramCanvas.restore();
  }
  
  private void b()
  {
    long l = SystemClock.uptimeMillis();
    if (this.c == 0L) {
      this.c = l;
    }
    int n = this.b.duration();
    int m = n;
    if (n == 0) {
      m = 1000;
    }
    this.d = ((int)((l - this.c) % m));
  }
  
  public Movie getMovie()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b != null)
    {
      if (!this.j)
      {
        b();
        a(paramCanvas);
        a();
      }
    }
    else {
      return;
    }
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = ((getWidth() - this.h) / 2.0F);
    this.f = ((getHeight() - this.i) / 2.0F);
    if (getVisibility() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.k = paramBoolean;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m;
    int n;
    if (this.b != null)
    {
      m = this.b.width();
      n = this.b.height();
      if (View.MeasureSpec.getMode(paramInt1) == 0) {
        break label146;
      }
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      if (m <= paramInt1) {
        break label146;
      }
    }
    label146:
    for (float f1 = m / paramInt1;; f1 = 1.0F)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
        if (n <= paramInt1) {}
      }
      for (float f2 = n / paramInt1;; f2 = 1.0F)
      {
        this.g = (1.0F / Math.max(f1, f2));
        this.h = ((int)(m * this.g));
        this.i = ((int)(n * this.g));
        setMeasuredDimension(this.h, this.i);
        return;
        paramInt1 = ab.a(120.0F);
        setMeasuredDimension(paramInt1, paramInt1);
        return;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onScreenStateChanged(int paramInt)
  {
    boolean bool = true;
    super.onScreenStateChanged(paramInt);
    if (paramInt == 1) {}
    for (;;)
    {
      this.k = bool;
      a();
      return;
      bool = false;
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.k = bool;
      a();
      return;
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.k = bool;
      a();
      return;
    }
  }
  
  public void setMovie(Movie paramMovie)
  {
    this.b = paramMovie;
    requestLayout();
  }
  
  public void setMovieBytes(byte[] paramArrayOfByte)
  {
    this.b = Movie.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    requestLayout();
  }
  
  public void setMovieFilePath(String paramString)
  {
    this.b = Movie.decodeFile(paramString);
    requestLayout();
  }
  
  public void setMovieResource(int paramInt)
  {
    this.a = paramInt;
    this.b = Movie.decodeStream(getResources().openRawResource(this.a));
    requestLayout();
  }
  
  public void setMovieStream(InputStream paramInputStream)
  {
    this.b = Movie.decodeStream(paramInputStream);
    requestLayout();
  }
  
  public void setMovieTime(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setPaused(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (!paramBoolean) {
      this.c = (SystemClock.uptimeMillis() - this.d);
    }
    invalidate();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\gif\GifMovieView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */