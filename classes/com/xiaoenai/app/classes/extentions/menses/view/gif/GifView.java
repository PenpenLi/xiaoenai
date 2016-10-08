package com.xiaoenai.app.classes.extentions.menses.view.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import java.io.InputStream;

public class GifView
  extends View
  implements a
{
  private b a = null;
  private Bitmap b = null;
  private a c = null;
  private b d = b.b;
  private boolean e = true;
  private boolean f = false;
  private int g = -1;
  private int h = -1;
  private Rect i = null;
  private Handler j = new d(this);
  
  public GifView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    if (this.j != null)
    {
      Message localMessage = this.j.obtainMessage();
      this.j.sendMessage(localMessage);
    }
  }
  
  private void setGifDecoderImage(InputStream paramInputStream)
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
    this.a = new b(paramInputStream, this);
    this.a.start();
  }
  
  private void setGifDecoderImage(byte[] paramArrayOfByte)
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
    this.a = new b(paramArrayOfByte, this);
    this.a.start();
  }
  
  public void a()
  {
    if (this.f) {
      this.f = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.i = new Rect();
      this.i.left = 0;
      this.i.top = 0;
      this.i.right = paramInt1;
      this.i.bottom = paramInt2;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.a == null) {
        break label234;
      }
      switch (this.d.ordinal())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (paramInt != -1);
              if (this.a.b() <= 1) {
                break;
              }
            } while (this.c != null);
            this.c = new a(null);
            this.c.start();
            return;
            c();
            return;
            if (paramInt == 1)
            {
              this.b = this.a.c();
              c();
              return;
            }
          } while (paramInt != -1);
          if (this.a.b() <= 1) {
            break;
          }
        } while (this.c != null);
        this.c = new a(null);
        this.c.start();
        return;
        c();
        return;
        if (paramInt == 1)
        {
          this.b = this.a.c();
          c();
          return;
        }
      } while (paramInt != -1);
      if (this.a.b() <= 1) {
        break;
      }
    } while (this.c != null);
    this.c = new a(null);
    this.c.start();
    return;
    c();
    return;
    label234:
    com.xiaoenai.app.utils.f.a.a("parse error", new Object[0]);
  }
  
  public void b()
  {
    if ((this.c != null) && (this.c.isAlive())) {
      this.c.interrupt();
    }
    if (this.a != null)
    {
      int k = 0;
      while (k < this.a.b())
      {
        Bitmap localBitmap = this.a.a(k);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          localBitmap.recycle();
          System.gc();
        }
        k += 1;
      }
      this.a.a();
    }
    this.e = false;
    this.c = null;
    this.a = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a == null) {}
    do
    {
      return;
      if (this.b == null) {
        this.b = this.a.c();
      }
    } while (this.b == null);
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if ((this.g == -1) && (this.h == -1)) {
      paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, null);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(k);
      return;
      paramCanvas.drawBitmap(this.b, null, this.i, null);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 1;
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    int k;
    float f1;
    if (this.a == null)
    {
      k = 1;
      f1 = m / k;
      float f2 = k / m;
      i2 = Math.max(m + (i2 + i3), getSuggestedMinimumWidth());
      n = Math.max(k + (n + i1), getSuggestedMinimumHeight());
      k = resolveSize(i2, paramInt1);
      m = resolveSize(n, paramInt2);
      if (k >= i2) {
        break label156;
      }
      paramInt1 = (int)(k * f2);
      paramInt2 = k;
    }
    for (;;)
    {
      a(paramInt2, paramInt1);
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      m = this.a.a;
      k = this.a.b;
      break;
      label156:
      paramInt1 = m;
      paramInt2 = k;
      if (m < n)
      {
        paramInt2 = (int)(m * f1);
        paramInt1 = m;
      }
    }
  }
  
  public void setGifImage(int paramInt)
  {
    setGifDecoderImage(getResources().openRawResource(paramInt));
  }
  
  public void setGifImage(InputStream paramInputStream)
  {
    setGifDecoderImage(paramInputStream);
  }
  
  public void setGifImage(byte[] paramArrayOfByte)
  {
    setGifDecoderImage(paramArrayOfByte);
  }
  
  public void setGifImageType(b paramb)
  {
    if (this.a == null) {
      this.d = paramb;
    }
  }
  
  private class a
    extends Thread
  {
    private a() {}
    
    public void run()
    {
      if (GifView.a(GifView.this) == null) {}
      label11:
      label109:
      for (;;)
      {
        return;
        Object localObject1 = GifView.d(GifView.this).obtainMessage();
        GifView.d(GifView.this).sendMessage((Message)localObject1);
        Object localObject2;
        SystemClock.sleep(localObject2);
        for (;;)
        {
          if (!GifView.b(GifView.this)) {
            break label109;
          }
          if (!GifView.c(GifView.this))
          {
            localObject1 = GifView.a(GifView.this).d();
            if (localObject1 == null) {
              break;
            }
            GifView.a(GifView.this, ((c)localObject1).a);
            long l = ((c)localObject1).b;
            if (GifView.d(GifView.this) != null) {
              break label11;
            }
            return;
          }
          SystemClock.sleep(10L);
        }
      }
    }
  }
  
  public static enum b
  {
    final int d;
    
    private b(int paramInt)
    {
      this.d = paramInt;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\view\gif\GifView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */