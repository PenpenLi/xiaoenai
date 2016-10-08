package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.mob.tools.b.j;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.util.Random;

public class AsyncImageView
  extends ImageView
  implements Handler.Callback, a.a
{
  private static final Random a = new Random();
  private float[] b;
  private boolean c;
  private String d;
  private int e;
  private Bitmap f;
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if ((f1 == 0.0F) || (f2 == 0.0F)) {}
    Object localObject;
    float f3;
    do
    {
      do
      {
        return paramBitmap;
        localObject = getSize();
      } while ((localObject[0] == 0) || (localObject[1] == 0));
      f3 = localObject[1] * f1 / localObject[0];
    } while (f3 == f2);
    int[] arrayOfInt = new int[4];
    if (f3 < f2)
    {
      arrayOfInt[1] = ((int)((f2 - f3) / 2.0F));
      arrayOfInt[3] = arrayOfInt[1];
    }
    for (;;)
    {
      try
      {
        localObject = com.mob.tools.b.a.a(paramBitmap, arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
        return (Bitmap)localObject;
      }
      catch (Throwable localThrowable)
      {
        e.a().w(localThrowable);
      }
      arrayOfInt[0] = ((int)((f1 - f2 * localObject[0] / localObject[1]) / 2.0F));
      arrayOfInt[2] = arrayOfInt[0];
    }
    return paramBitmap;
  }
  
  private void a(Context paramContext)
  {
    if (isInEditMode())
    {
      setBackgroundColor(-16777216);
      return;
    }
    a.a(paramContext);
  }
  
  private Bitmap b(Bitmap paramBitmap)
  {
    try
    {
      Object localObject = getSize();
      localObject = com.mob.tools.b.a.a(paramBitmap, localObject[0], localObject[1], this.b[0], this.b[1], this.b[2], this.b[3]);
      return (Bitmap)localObject;
    }
    catch (Throwable localThrowable)
    {
      e.a().w(localThrowable);
    }
    return paramBitmap;
  }
  
  private int[] getSize()
  {
    int k = getWidth();
    int m = getHeight();
    int i;
    int j;
    if (k != 0)
    {
      i = m;
      j = k;
      if (m != 0) {}
    }
    else
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      i = m;
      j = k;
      if (localLayoutParams != null)
      {
        j = localLayoutParams.width;
        i = localLayoutParams.height;
      }
    }
    if (j != 0)
    {
      k = i;
      if (i != 0) {}
    }
    else
    {
      measure(0, 0);
      j = getMeasuredWidth();
      k = getMeasuredHeight();
    }
    return new int[] { j, k };
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = new float[] { paramFloat1, paramFloat2, paramFloat3, paramFloat4 };
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.trim().length() > 0)
      {
        localObject1 = localObject2;
        if (paramString.equals(this.d)) {
          localObject1 = paramBitmap;
        }
      }
    }
    paramBitmap = (Bitmap)localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (this.c) {
        localObject2 = a((Bitmap)localObject1);
      }
      paramBitmap = (Bitmap)localObject2;
      if (this.b != null) {
        paramBitmap = b((Bitmap)localObject2);
      }
    }
    localObject1 = new Message();
    ((Message)localObject1).what = 1;
    ((Message)localObject1).obj = new Object[] { paramString, paramBitmap };
    j.a((Message)localObject1, a.nextInt(300), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      Object localObject = ((Object[])(Object[])paramMessage.obj)[0];
      paramMessage = ((Object[])(Object[])paramMessage.obj)[1];
      if ((paramMessage != null) && (localObject != null) && (localObject.equals(this.d))) {
        setImageBitmap((Bitmap)paramMessage);
      }
    }
    else
    {
      return false;
    }
    if ((this.f != null) && (!this.f.isRecycled()))
    {
      setImageBitmap(this.f);
      return false;
    }
    setImageResource(this.e);
    return false;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.c) {
      localBitmap = a(paramBitmap);
    }
    paramBitmap = localBitmap;
    if (this.b != null) {
      paramBitmap = b(localBitmap);
    }
    setImageBitmap(paramBitmap);
  }
  
  public void setRound(float paramFloat)
  {
    a(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setScaleToCropCenter(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\AsyncImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */