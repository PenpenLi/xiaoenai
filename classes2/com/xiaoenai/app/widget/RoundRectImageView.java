package com.xiaoenai.app.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundRectImageView
  extends ImageView
{
  private Paint a;
  private int b = 20;
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    this.a.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    this.a.setColor(-12434878);
    paramBitmap.getWidth();
    localCanvas.drawRoundRect(localRectF, paramInt, paramInt, this.a);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, this.a);
    return localBitmap;
  }
  
  private void a(Context paramContext)
  {
    this.a = new Paint();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getDrawable();
    Rect localRect1;
    Rect localRect2;
    if (localObject != null)
    {
      localObject = a(((BitmapDrawable)localObject).getBitmap(), this.b);
      localRect1 = new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      localRect2 = new Rect(0, 0, getWidth(), getHeight());
      this.a.reset();
      paramCanvas.drawBitmap((Bitmap)localObject, localRect1, localRect2, this.a);
    }
    for (;;)
    {
      localObject = getBackground();
      if (localObject == null) {
        break;
      }
      localObject = a(((BitmapDrawable)localObject).getBitmap(), this.b);
      localRect1 = new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      localRect2 = new Rect(0, 0, getWidth(), getHeight());
      this.a.reset();
      paramCanvas.drawBitmap((Bitmap)localObject, localRect1, localRect2, this.a);
      return;
      super.onDraw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setRoundPx(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\RoundRectImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */