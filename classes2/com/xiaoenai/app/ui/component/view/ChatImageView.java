package com.xiaoenai.app.ui.component.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.xiaoenai.app.ui.component.a.c;

public class ChatImageView
  extends ImageView
{
  private int a;
  private Bitmap b;
  private Bitmap c;
  private NinePatchDrawable d;
  private Bitmap e;
  private Paint f;
  private Paint g;
  private Matrix h;
  
  public ChatImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ChatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.ChatImageView, 0, 0);
    if (paramContext != null)
    {
      this.a = paramContext.getResourceId(a.c.ChatImageView_chat_image_mask, 0);
      paramContext.recycle();
    }
    a();
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  private void a()
  {
    this.h = new Matrix();
    this.f = new Paint(1);
    if (this.a <= 0) {
      return;
    }
    this.c = BitmapFactory.decodeResource(getResources(), this.a);
    byte[] arrayOfByte = this.c.getNinePatchChunk();
    if ((arrayOfByte != null) && (NinePatch.isNinePatchChunk(arrayOfByte))) {
      this.d = new NinePatchDrawable(getResources(), this.c, arrayOfByte, new Rect(), null);
    }
    b();
  }
  
  private void b()
  {
    if (this.a <= 0) {}
    int j;
    int k;
    do
    {
      do
      {
        return;
      } while (this.b == null);
      j = getWidth();
      k = getHeight();
    } while ((j <= 0) || (k <= 0));
    int i;
    Canvas localCanvas;
    int m;
    float f2;
    float f3;
    float f1;
    if ((this.e != null) && (this.e.getWidth() == j) && (this.e.getHeight() == k))
    {
      i = 1;
      if (i == 0) {
        this.e = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      }
      localCanvas = new Canvas(this.e);
      if (i != 0) {
        localCanvas.drawColor(0);
      }
      this.h.reset();
      i = this.b.getWidth();
      m = this.b.getHeight();
      if (i * k <= j * m) {
        break label318;
      }
      f2 = k / m;
      f3 = j;
      float f4 = i;
      f1 = f2;
      f2 = (f3 - f4 * f2) * 0.5F;
      f4 = 0.0F;
      f3 = f1;
      f1 = f4;
      label189:
      this.h.setScale(f3, f3);
      this.h.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
      localCanvas.save();
      localCanvas.concat(this.h);
      localCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.f);
      localCanvas.restore();
      if (this.d == null) {
        break label344;
      }
      this.d.getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.d.setBounds(0, 0, j, k);
      this.d.draw(localCanvas);
    }
    for (;;)
    {
      super.setImageBitmap(this.e);
      return;
      i = 0;
      break;
      label318:
      f3 = j / i;
      f1 = (k - m * f3) * 0.5F;
      f2 = 0.0F;
      break label189;
      label344:
      if (this.c != null)
      {
        if (this.g == null)
        {
          this.g = new Paint(1);
          this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        localCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.g);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
    if ((this.a > 0) && (this.b != null))
    {
      b();
      return;
    }
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    Bitmap localBitmap = a(paramDrawable);
    if (this.b == localBitmap)
    {
      super.setImageDrawable(paramDrawable);
      return;
    }
    this.b = localBitmap;
    b();
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    this.b = a(getResources().getDrawable(paramInt));
    b();
  }
  
  public void setMaskResource(int paramInt)
  {
    if (paramInt != this.a)
    {
      this.a = paramInt;
      a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\ChatImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */