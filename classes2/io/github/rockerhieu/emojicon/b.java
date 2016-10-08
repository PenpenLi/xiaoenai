package io.github.rockerhieu.emojicon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import java.lang.ref.WeakReference;

class b
  extends DynamicDrawableSpan
{
  private final Context a;
  private final int b;
  private final int c;
  private final int d;
  private int e;
  private int f;
  private int g;
  private Drawable h;
  private WeakReference<Drawable> i;
  
  public b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt3);
    this.a = paramContext;
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = paramInt2;
    this.f = paramInt2;
    this.d = paramInt4;
  }
  
  private Drawable a()
  {
    if ((this.i == null) || (this.i.get() == null)) {
      this.i = new WeakReference(getDrawable());
    }
    return (Drawable)this.i.get();
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = a();
    paramCanvas.save();
    paramInt1 = paramInt5 - paramCharSequence.getBounds().bottom;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = (paramInt5 - paramInt3) / 2 + paramInt3 - (paramCharSequence.getBounds().bottom - paramCharSequence.getBounds().top) / 2 - this.g;
    }
    paramCanvas.translate(paramFloat, paramInt1);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    if (this.h == null) {}
    try
    {
      this.h = this.a.getResources().getDrawable(this.b);
      this.e = this.c;
      this.f = (this.e * this.h.getIntrinsicWidth() / this.h.getIntrinsicHeight());
      this.g = ((this.d - this.e) / 2);
      this.h.setBounds(0, this.g, this.f, this.g + this.e);
      return this.h;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\io\github\rockerhieu\emojicon\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */