package com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import com.c.c.a;
import com.marshalchen.ultimaterecyclerview.d.a;
import com.marshalchen.ultimaterecyclerview.d.b;
import com.marshalchen.ultimaterecyclerview.d.e;

public class FloatingActionButton
  extends ImageButton
{
  private static final int a = Color.argb(128, 255, 255, 255);
  private static final int j = Color.argb(128, 0, 0, 0);
  protected int b;
  protected int c;
  @DrawableRes
  protected int d;
  protected int e;
  protected float f;
  protected float g;
  protected float h;
  protected int i;
  private final Interpolator k = new AccelerateDecelerateInterpolator();
  private boolean l = false;
  private float m = -1.0F;
  private float n = -1.0F;
  
  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @SuppressLint({"NewApi"})
  private void setBackgroundCompat(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  protected int a(float paramFloat)
  {
    return (int)(255.0F * paramFloat);
  }
  
  protected int a(@ColorRes int paramInt)
  {
    return getResources().getColor(paramInt);
  }
  
  protected Drawable a(RectF paramRectF, int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.i, this.i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt);
    localCanvas.drawOval(paramRectF, localPaint);
    return new BitmapDrawable(getResources(), localBitmap);
  }
  
  protected Drawable a(RectF paramRectF, int paramInt, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.i, this.i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt);
    localPaint.setAlpha(a(paramFloat));
    localCanvas.drawOval(paramRectF, localPaint);
    return new BitmapDrawable(getResources(), localBitmap);
  }
  
  protected LayerDrawable a(RectF paramRectF)
  {
    if (this.e == 2) {
      return new LayerDrawable(new Drawable[] { b(paramRectF), c(paramRectF), getIconDrawable() });
    }
    return new LayerDrawable(new Drawable[] { getResources().getDrawable(d(this.e)), b(paramRectF), c(paramRectF), getIconDrawable() });
  }
  
  protected void a()
  {
    float f2 = this.g;
    float f1 = this.g - this.h;
    LayerDrawable localLayerDrawable = a(new RectF(f2, f1, this.f + f2, this.f + f1));
    f2 = (this.f - b(d.a.fab_icon_size)) / 2.0F;
    int i1 = (int)(this.g + f2);
    int i2 = (int)(f1 + f2);
    int i3 = (int)(this.g + this.h + f2);
    localLayerDrawable.setLayerInset(localLayerDrawable.getNumberOfLayers() - 1, i1, i2, i1, i3);
    setBackgroundCompat(localLayerDrawable);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.b = a(17170451);
    this.c = a(17170450);
    this.d = 0;
    this.e = 0;
    if (paramAttributeSet != null) {
      b(paramContext, paramAttributeSet);
    }
    this.f = c(this.e);
    this.g = b(d.a.fab_shadow_radius);
    this.h = b(d.a.fab_shadow_offset);
    this.i = ((int)(this.f + 2.0F * this.g));
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    paramAttributeSet = new Point();
    if (Build.VERSION.SDK_INT >= 13) {
      paramContext.getSize(paramAttributeSet);
    }
    for (this.n = paramAttributeSet.y;; this.n = paramContext.getHeight())
    {
      a();
      return;
    }
  }
  
  protected void a(TypedArray paramTypedArray) {}
  
  protected float b(@DimenRes int paramInt)
  {
    return getResources().getDimension(paramInt);
  }
  
  protected StateListDrawable b(RectF paramRectF)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = a(paramRectF, this.c);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    paramRectF = a(paramRectF, this.b);
    localStateListDrawable.addState(new int[0], paramRectF);
    return localStateListDrawable;
  }
  
  protected void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.e.FloatActionButton, 0, 0);
    if (paramContext != null) {}
    try
    {
      this.b = paramContext.getColor(d.e.FloatActionButton_urv_fab_colorNormal, a(17170451));
      this.c = paramContext.getColor(d.e.FloatActionButton_urv_fab_colorPressed, a(17170450));
      this.e = paramContext.getInt(d.e.FloatActionButton_urv_fab_size, 0);
      this.d = paramContext.getResourceId(d.e.FloatActionButton_icon, 0);
      a(paramContext);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected float c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(d.a.fab_size_normal);
    case 0: 
      return b(d.a.fab_size_normal);
    case 1: 
      return b(d.a.fab_size_mini);
    }
    return b(d.a.fab_size_normal);
  }
  
  protected Drawable c(RectF paramRectF)
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.i, this.i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    float f1 = b(d.a.fab_stroke_width);
    float f2 = f1 / 2.0F;
    Object localObject = new RectF(paramRectF.left - f2, paramRectF.top - f2, paramRectF.right + f2, paramRectF.bottom + f2);
    paramRectF = new RectF(paramRectF.left + f2, paramRectF.top + f2, paramRectF.right - f2, paramRectF.bottom - f2);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(f1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-16777216);
    localPaint.setAlpha(a(0.02F));
    localCanvas.drawOval((RectF)localObject, localPaint);
    f1 = paramRectF.centerX();
    f2 = paramRectF.top;
    float f3 = paramRectF.centerX();
    float f4 = paramRectF.bottom;
    int i1 = j;
    localObject = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(f1, f2, f3, f4, new int[] { 0, i1, -16777216 }, new float[] { 0.0F, 0.8F, 1.0F }, (Shader.TileMode)localObject));
    localPaint.setAlpha(a(0.04F));
    localCanvas.drawOval(paramRectF, localPaint);
    f1 = paramRectF.centerX();
    f2 = paramRectF.top;
    f3 = paramRectF.centerX();
    f4 = paramRectF.bottom;
    i1 = a;
    localObject = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(f1, f2, f3, f4, new int[] { -1, i1, 0 }, new float[] { 0.0F, 0.2F, 1.0F }, (Shader.TileMode)localObject));
    localPaint.setAlpha(a(0.8F));
    localCanvas.drawOval(paramRectF, localPaint);
    return new BitmapDrawable(getResources(), localBitmap);
  }
  
  @DrawableRes
  protected int d(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return -1;
    case 0: 
      return d.b.urv_floating_action_button_fab_bg_normal;
    }
    return d.b.urv_floating_action_button_fab_bg_mini;
  }
  
  protected Drawable getIconDrawable()
  {
    if (this.d != 0) {
      return getResources().getDrawable(this.d);
    }
    return new ColorDrawable(0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.m == -1.0F) {
      this.m = a.b(this);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.i, this.i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\ui\floatingactionbutton\FloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */