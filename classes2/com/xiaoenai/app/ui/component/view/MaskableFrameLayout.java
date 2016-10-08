package com.xiaoenai.app.ui.component.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.xiaoenai.app.ui.component.a.c;

public class MaskableFrameLayout
  extends FrameLayout
{
  private Handler a;
  @Nullable
  private Drawable b = null;
  @Nullable
  private Bitmap c = null;
  private boolean d = false;
  private Paint e = null;
  private PorterDuffXfermode f = null;
  
  public MaskableFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MaskableFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public MaskableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @NonNull
  private Paint a(boolean paramBoolean)
  {
    Paint localPaint = new Paint(1);
    localPaint.setAntiAlias(paramBoolean);
    localPaint.setXfermode(this.f);
    return localPaint;
  }
  
  private PorterDuffXfermode a(int paramInt)
  {
    PorterDuff.Mode localMode;
    switch (paramInt)
    {
    default: 
      localMode = PorterDuff.Mode.DST_IN;
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("Mode is {}", new Object[] { localMode.toString() });
      return new PorterDuffXfermode(localMode);
      if (Build.VERSION.SDK_INT >= 11) {
        localMode = PorterDuff.Mode.ADD;
      }
      for (;;)
      {
        localMode = PorterDuff.Mode.CLEAR;
        break;
        com.xiaoenai.app.utils.f.a.c("MODE_ADD is not supported on api lvl {}", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      }
      localMode = PorterDuff.Mode.DARKEN;
      continue;
      localMode = PorterDuff.Mode.DST;
      continue;
      localMode = PorterDuff.Mode.DST_ATOP;
      continue;
      localMode = PorterDuff.Mode.DST_IN;
      continue;
      localMode = PorterDuff.Mode.DST_OUT;
      continue;
      localMode = PorterDuff.Mode.DST_OVER;
      continue;
      localMode = PorterDuff.Mode.LIGHTEN;
      continue;
      localMode = PorterDuff.Mode.MULTIPLY;
      continue;
      if (Build.VERSION.SDK_INT >= 11) {
        localMode = PorterDuff.Mode.OVERLAY;
      }
      for (;;)
      {
        localMode = PorterDuff.Mode.SCREEN;
        break;
        com.xiaoenai.app.utils.f.a.c("MODE_OVERLAY is not supported on api lvl " + Build.VERSION.SDK_INT, new Object[0]);
      }
      localMode = PorterDuff.Mode.SRC;
      continue;
      localMode = PorterDuff.Mode.SRC_ATOP;
      continue;
      localMode = PorterDuff.Mode.SRC_IN;
      continue;
      localMode = PorterDuff.Mode.SRC_OUT;
      continue;
      localMode = PorterDuff.Mode.SRC_OVER;
      continue;
      localMode = PorterDuff.Mode.XOR;
    }
  }
  
  @Nullable
  private Drawable a(@NonNull TypedArray paramTypedArray)
  {
    return paramTypedArray.getDrawable(a.c.MaskableLayout_mask);
  }
  
  private void a()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
      localViewTreeObserver.addOnGlobalLayoutListener(new a(this, localViewTreeObserver));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (this.b != null) {
        a(b(this.b));
      }
      return;
    }
    com.xiaoenai.app.utils.f.a.c("Width and height must be higher than 0", new Object[0]);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new Handler();
    setDrawingCacheEnabled(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.e = a(false);
    paramContext = paramContext.getTheme();
    if (paramContext != null) {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.c.MaskableLayout, 0, 0);
    }
    for (;;)
    {
      try
      {
        a(a(paramContext));
        this.f = a(paramContext.getInteger(a.c.MaskableLayout_porterduffxfermode, 0));
        a(this.b);
        if (paramContext.getBoolean(a.c.MaskableLayout_anti_aliasing, false)) {
          this.e = a(true);
        }
        if (paramContext != null) {
          paramContext.recycle();
        }
        a();
        return;
      }
      finally
      {
        if (paramContext != null) {
          paramContext.recycle();
        }
      }
      com.xiaoenai.app.utils.f.a.c("Couldn't load theme, mask in xml won't be loaded.", new Object[0]);
    }
  }
  
  private void a(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if ((this.c != null) && (!this.c.isRecycled())) {
        this.c.recycle();
      }
      this.c = paramBitmap;
    }
  }
  
  private void a(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.b = paramDrawable;
      if ((this.b instanceof AnimationDrawable)) {
        this.b.setCallback(this);
      }
      return;
    }
    com.xiaoenai.app.utils.f.a.c("Are you sure you don't want to provide a mask ?", new Object[0]);
  }
  
  @Nullable
  private Bitmap b(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if ((getMeasuredWidth() > 0) && (getMeasuredHeight() > 0))
      {
        Bitmap localBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      com.xiaoenai.app.utils.f.a.c("Can't create a mask with height 0 or width 0. Or the layout has no children and is wrap content", new Object[0]);
      return null;
    }
    com.xiaoenai.app.utils.f.a.c("No bitmap mask loaded, view will NOT be masked !", new Object[0]);
    return null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.c != null) && (this.e != null))
    {
      this.e.setXfermode(this.f);
      paramCanvas.drawBitmap(this.c, 0.0F, 0.0F, this.e);
      this.e.setXfermode(null);
      return;
    }
    com.xiaoenai.app.utils.f.a.c("Mask or paint is null ...", new Object[0]);
  }
  
  @Nullable
  public Drawable getDrawableMask()
  {
    return this.b;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      a(paramDrawable);
      a(b(paramDrawable));
      invalidate();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable != null) && (paramRunnable != null)) {
      this.a.postAtTime(paramRunnable, paramLong);
    }
  }
  
  public void setMask(int paramInt)
  {
    Resources localResources = getResources();
    if (localResources != null)
    {
      setMask(localResources.getDrawable(paramInt));
      return;
    }
    com.xiaoenai.app.utils.f.a.c("Unable to load resources, mask will not be loaded as drawable", new Object[0]);
  }
  
  public void setMask(@Nullable Drawable paramDrawable)
  {
    a(paramDrawable);
    a(b(this.b));
    invalidate();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable != null) && (paramRunnable != null)) {
      this.a.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\MaskableFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */