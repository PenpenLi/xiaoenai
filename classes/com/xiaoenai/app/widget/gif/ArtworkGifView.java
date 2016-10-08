package com.xiaoenai.app.widget.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout.LayoutParams;

public class ArtworkGifView
  extends GifView
{
  public ArtworkGifView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ArtworkGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    this.j = null;
    this.i = paramInt;
    this.c = 0;
    this.d = 0;
    this.k = false;
    this.b = paramBitmap;
    this.e = this.b.getWidth();
    this.f = this.b.getHeight();
    setLayoutParams(new LinearLayout.LayoutParams(this.e, this.f));
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.i = 0;
    this.j = paramString;
    this.c = 0;
    this.d = 0;
    this.k = false;
    this.b = paramBitmap;
    this.e = this.b.getWidth();
    this.f = this.b.getHeight();
    setLayoutParams(new LinearLayout.LayoutParams(this.e, this.f));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b == null) {}
    do
    {
      Bitmap localBitmap;
      do
      {
        long l;
        do
        {
          do
          {
            do
            {
              return;
              if (this.n != null)
              {
                this.n.setAntiAlias(true);
                this.n.setFilterBitmap(true);
                this.n.setDither(true);
              }
              if (this.d != 0) {
                break;
              }
            } while (!this.k);
            a();
            return;
          } while ((this.d == 1) || (this.d != 2));
          if (this.c == 1)
          {
            paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, null);
            invalidate();
            return;
          }
          if (this.c != 2) {
            break label233;
          }
          if (!this.k) {
            break;
          }
          l = System.currentTimeMillis();
        } while (this.a == null);
        if (this.g + this.a.a(this.h) < l)
        {
          this.g += this.a.a(this.h);
          c();
        }
        localBitmap = this.a.b(this.h);
      } while ((localBitmap == null) || (localBitmap.isRecycled()));
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      invalidate();
      return;
    } while (this.a == null);
    paramCanvas.drawBitmap(this.a.b(this.h), 0.0F, 0.0F, null);
    return;
    label233:
    paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, null);
  }
  
  public void setGif(int paramInt)
  {
    a(paramInt, BitmapFactory.decodeResource(getResources(), paramInt));
  }
  
  public void setGif(String paramString)
  {
    a(paramString, BitmapFactory.decodeFile(paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\gif\ArtworkGifView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */