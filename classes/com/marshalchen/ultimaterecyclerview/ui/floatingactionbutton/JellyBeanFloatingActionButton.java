package com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.marshalchen.ultimaterecyclerview.d.e;

public class JellyBeanFloatingActionButton
  extends FloatingActionButton
{
  protected float a;
  protected float j;
  
  public JellyBeanFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public JellyBeanFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected LayerDrawable a(RectF paramRectF)
  {
    return new LayerDrawable(new Drawable[] { b(paramRectF), getIconDrawable() });
  }
  
  protected void a(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray.getFloat(d.e.FloatActionButton_urv_fab_alphaPressed, 0.5F);
    this.j = paramTypedArray.getFloat(d.e.FloatActionButton_urv_fab_alphaNormal, 0.5F);
    this.e = 2;
  }
  
  protected StateListDrawable b(RectF paramRectF)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = a(paramRectF, this.c, this.a);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    paramRectF = a(paramRectF, this.b, this.j);
    localStateListDrawable.addState(new int[0], paramRectF);
    return localStateListDrawable;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\ui\floatingactionbutton\JellyBeanFloatingActionButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */