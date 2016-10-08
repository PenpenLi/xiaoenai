package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.b.a;
import com.mob.tools.e;
import com.mob.tools.log.d;

public class ScaledImageView
  extends ImageView
  implements View.OnTouchListener
{
  private Bitmap a;
  private float b;
  private float[] c;
  private int d;
  private a e;
  private Matrix f;
  private int g;
  private Matrix h;
  
  public ScaledImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ScaledImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.d *= this.d;
    setOnTouchListener(this);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        switch (paramMotionEvent.getAction())
        {
        case 0: 
          this.f = new Matrix();
          this.f.set(getImageMatrix());
          this.h = new Matrix();
          this.h.set(this.f);
          this.c = new float[] { paramMotionEvent.getX(0), paramMotionEvent.getY(0) };
          this.g = 1;
        }
      }
      catch (Throwable paramView)
      {
        e.a().w(paramView);
        break label795;
        paramView = new float[2];
        paramView[0] = paramMotionEvent.getX(0);
        paramView[1] = paramMotionEvent.getY(0);
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = paramMotionEvent.getX(1);
        arrayOfFloat[1] = paramMotionEvent.getY(1);
        float f1 = paramView[0] - arrayOfFloat[0];
        float f2 = paramView[1] - arrayOfFloat[1];
        this.b = (f2 * f2 + f1 * f1);
        this.g = 3;
        continue;
        this.c = new float[] { paramMotionEvent.getX(1), paramMotionEvent.getY(1) };
        this.h.set(this.f);
        this.g = 2;
        continue;
        paramView = new float[2];
        paramView[0] = paramMotionEvent.getX(0);
        paramView[1] = paramMotionEvent.getY(0);
        arrayOfFloat = new float[2];
        arrayOfFloat[0] = paramMotionEvent.getX(1);
        arrayOfFloat[1] = paramMotionEvent.getY(1);
        f1 = paramView[0] - arrayOfFloat[0];
        f2 = paramView[1] - arrayOfFloat[1];
        this.b = (f2 * f2 + f1 * f1);
        this.g = 3;
        continue;
        this.c = new float[] { paramMotionEvent.getX(0), paramMotionEvent.getY(0) };
        this.h.set(this.f);
        this.g = 1;
        continue;
        if (this.g != 1) {
          continue;
        }
        paramView = new float[2];
        paramView[0] = paramMotionEvent.getX(0);
        paramView[1] = paramMotionEvent.getY(0);
        this.f.set(this.h);
        this.f.postTranslate(paramView[0] - this.c[0], paramView[1] - this.c[1]);
        continue;
        if (this.g != 2) {
          continue;
        }
        paramView = new float[2];
        paramView[0] = paramMotionEvent.getX(1);
        paramView[1] = paramMotionEvent.getY(1);
        this.f.set(this.h);
        this.f.postTranslate(paramView[0] - this.c[0], paramView[1] - this.c[1]);
        continue;
        if (this.g != 3) {
          continue;
        }
        paramView = new float[2];
        paramView[0] = paramMotionEvent.getX(0);
        paramView[1] = paramMotionEvent.getY(0);
        arrayOfFloat = new float[2];
        arrayOfFloat[0] = paramMotionEvent.getX(1);
        arrayOfFloat[1] = paramMotionEvent.getY(1);
        f1 = paramView[0] - arrayOfFloat[0];
        f2 = paramView[1] - arrayOfFloat[1];
        this.f.set(this.h);
        f1 = (float)Math.sqrt((f1 * f1 + f2 * f2) / this.b);
        paramMotionEvent = new float[2];
        paramMotionEvent[0] = ((paramView[0] + arrayOfFloat[0]) / 2.0F);
        paramMotionEvent[1] = ((paramView[1] + arrayOfFloat[1]) / 2.0F);
        this.f.postScale(f1, f1, paramMotionEvent[0], paramMotionEvent[1]);
        continue;
        return false;
      }
      setImageMatrix(this.f);
      break label795;
      if (this.e != null) {
        this.e.a(this.f);
      }
      f1 = paramMotionEvent.getX(0) - this.c[0];
      f2 = paramMotionEvent.getY(0) - this.c[1];
      if ((this.g == 1) && (f1 * f1 + f2 * f2 <= this.d)) {
        performClick();
      }
      this.g = 0;
    }
    label795:
    return true;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    setImageBitmap(paramBitmap);
    Object localObject = new int[2];
    localObject[0] = getWidth();
    localObject[1] = getHeight();
    paramBitmap = new int[2];
    paramBitmap[0] = this.a.getWidth();
    paramBitmap[1] = this.a.getHeight();
    int[] arrayOfInt1 = a.a(paramBitmap, (int[])localObject);
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = ((localObject[0] - arrayOfInt1[0]) / 2);
    arrayOfInt2[1] = ((localObject[1] - arrayOfInt1[1]) / 2);
    localObject = new float[2];
    localObject[0] = (arrayOfInt1[0] / paramBitmap[0]);
    localObject[1] = (arrayOfInt1[1] / paramBitmap[1]);
    this.f = new Matrix();
    this.f.set(getImageMatrix());
    this.f.postScale(localObject[0], localObject[1]);
    this.f.postTranslate(arrayOfInt2[0], arrayOfInt2[1]);
    if (this.e != null) {
      this.e.a(this.f);
    }
    setImageMatrix(this.f);
  }
  
  public void setOnMatrixChangedListener(a parama)
  {
    this.e = parama;
    if (this.f != null)
    {
      if (this.e != null) {
        this.e.a(this.f);
      }
      setImageMatrix(this.f);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Matrix paramMatrix);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\ScaledImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */