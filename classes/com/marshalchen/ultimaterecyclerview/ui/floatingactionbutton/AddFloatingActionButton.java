package com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import com.marshalchen.ultimaterecyclerview.d.a;
import com.marshalchen.ultimaterecyclerview.d.e;

public class AddFloatingActionButton
  extends FloatingActionButton
{
  protected int a;
  
  public AddFloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AddFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AddFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
    {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, d.e.AddFloatingActionButton, 0, 0);
      if (localTypedArray == null) {}
    }
    for (;;)
    {
      try
      {
        this.a = localTypedArray.getColor(d.e.AddFloatingActionButton_plusIconColor, a(17170443));
        localTypedArray.recycle();
        super.a(paramContext, paramAttributeSet);
        return;
      }
      finally
      {
        localTypedArray.recycle();
      }
      this.a = a(17170443);
    }
  }
  
  protected Drawable getIconDrawable()
  {
    float f1 = b(d.a.fab_icon_size);
    float f2 = f1 / 2.0F;
    float f3 = b(d.a.fab_plus_icon_size);
    float f4 = b(d.a.fab_plus_icon_stroke) / 2.0F;
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new a(this, (f1 - f3) / 2.0F, f2, f4, f1));
    Paint localPaint = localShapeDrawable.getPaint();
    localPaint.setColor(this.a);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    return localShapeDrawable;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\ui\floatingactionbutton\AddFloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */