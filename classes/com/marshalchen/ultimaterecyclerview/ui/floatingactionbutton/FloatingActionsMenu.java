package com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.c.c.a;
import com.marshalchen.ultimaterecyclerview.d.a;
import com.marshalchen.ultimaterecyclerview.d.c;
import com.marshalchen.ultimaterecyclerview.d.e;

public class FloatingActionsMenu
  extends ViewGroup
{
  private static Interpolator k = new OvershootInterpolator();
  private static Interpolator l = new DecelerateInterpolator(3.0F);
  private static Interpolator m = new DecelerateInterpolator();
  private int a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private boolean f = false;
  private AnimatorSet g = new AnimatorSet().setDuration(300L);
  private AnimatorSet h = new AnimatorSet().setDuration(300L);
  private AddFloatingActionButton i;
  private b j;
  private final Interpolator n = new AccelerateDecelerateInterpolator();
  private boolean o = false;
  private float p = -1.0F;
  private float q = -1.0F;
  
  public FloatingActionsMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public FloatingActionsMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(@ColorRes int paramInt)
  {
    return getResources().getColor(paramInt);
  }
  
  private void a(Context paramContext)
  {
    this.i = new b(this, paramContext);
    this.i.setId(d.c.fab_expand_menu_button);
    this.i.setOnClickListener(new c(this));
    addView(this.i, super.generateDefaultLayoutParams());
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = a(17170443);
    this.b = a(17170451);
    this.c = a(17170450);
    this.d = ((int)(getResources().getDimension(d.a.fab_actions_spacing) - getResources().getDimension(d.a.fab_shadow_radius) - getResources().getDimension(d.a.fab_shadow_offset)));
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, d.e.FloatingActionsMenu, 0, 0);
      if (paramAttributeSet == null) {}
    }
    for (;;)
    {
      try
      {
        this.a = paramAttributeSet.getColor(d.e.FloatingActionsMenu_addButtonPlusIconColor, a(17170443));
        this.b = paramAttributeSet.getColor(d.e.FloatingActionsMenu_addButtonColorNormal, a(17170451));
        this.c = paramAttributeSet.getColor(d.e.FloatingActionsMenu_addButtonColorPressed, a(17170450));
        this.f = paramAttributeSet.getBoolean(d.e.FloatingActionsMenu_addButtonIsHorizontal, false);
        paramAttributeSet.recycle();
        paramAttributeSet = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        Point localPoint = new Point();
        if (Build.VERSION.SDK_INT >= 13)
        {
          paramAttributeSet.getSize(localPoint);
          this.q = localPoint.y;
          a(paramContext);
          return;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      this.q = paramAttributeSet.getHeight();
    }
  }
  
  public void a()
  {
    if (this.e)
    {
      this.e = false;
      this.h.start();
      this.g.cancel();
    }
  }
  
  public void b()
  {
    if (this.e)
    {
      a();
      return;
    }
    c();
  }
  
  public void c()
  {
    if (!this.e)
    {
      this.e = true;
      this.h.cancel();
      this.g.start();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return super.checkLayoutParams(paramLayoutParams);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new a(super.generateDefaultLayoutParams());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new a(super.generateLayoutParams(paramAttributeSet));
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new a(super.generateLayoutParams(paramLayoutParams));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    bringChildToFront(this.i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = paramInt4 - paramInt2 - this.i.getMeasuredHeight();
    int i1 = paramInt3 - paramInt1 - this.i.getMeasuredWidth();
    if (!this.f) {
      this.i.layout(0, paramInt4, this.i.getMeasuredWidth(), this.i.getMeasuredHeight() + paramInt4);
    }
    View localView;
    for (;;)
    {
      paramInt3 = this.d;
      paramInt2 = this.d;
      paramInt1 = getChildCount() - 1;
      paramInt2 = i1 - paramInt2;
      paramInt3 = paramInt4 - paramInt3;
      for (;;)
      {
        if (paramInt1 < 0) {
          break label469;
        }
        localView = getChildAt(paramInt1);
        if (localView != this.i) {
          break;
        }
        paramInt1 -= 1;
      }
      this.i.layout(i1, 0, this.i.getMeasuredWidth() + i1, this.i.getMeasuredHeight());
    }
    paramInt3 -= localView.getMeasuredHeight();
    paramInt2 -= localView.getMeasuredWidth();
    if (!this.f)
    {
      localView.layout(0, paramInt3, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt3);
      label195:
      if (this.f) {
        break label355;
      }
      f2 = paramInt4 - paramInt3;
      if (!this.e) {
        break label342;
      }
      f1 = 0.0F;
      label220:
      localView.setTranslationY(f1);
      if (!this.e) {
        break label349;
      }
    }
    a locala;
    label342:
    label349:
    for (float f1 = 1.0F;; f1 = 0.0F)
    {
      localView.setAlpha(f1);
      locala = (a)localView.getLayoutParams();
      a.a(locala).setFloatValues(new float[] { 0.0F, f2 });
      a.b(locala).setFloatValues(new float[] { f2, 0.0F });
      locala.a(localView);
      paramInt3 -= this.d;
      paramInt2 -= this.d;
      break;
      localView.layout(paramInt2, 0, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight());
      break label195;
      f1 = f2;
      break label220;
    }
    label355:
    float f2 = i1 - paramInt2;
    if (this.e)
    {
      f1 = f2;
      label373:
      localView.setTranslationX(f1);
      if (!this.e) {
        break label463;
      }
    }
    label463:
    for (f1 = 1.0F;; f1 = 0.0F)
    {
      localView.setAlpha(f1);
      locala = (a)localView.getLayoutParams();
      a.c(locala).setFloatValues(new float[] { 0.0F, f2 });
      a.d(locala).setFloatValues(new float[] { f2, 0.0F });
      locala.a(localView);
      break;
      f1 = 0.0F;
      break label373;
    }
    label469:
    if (this.p == -1.0F) {
      this.p = a.b(this);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = 0;
    int i2 = 0;
    measureChildren(paramInt1, paramInt2);
    View localView;
    if (!this.f)
    {
      paramInt2 = 0;
      i1 = 0;
      paramInt1 = i2;
      while (paramInt1 < getChildCount())
      {
        localView = getChildAt(paramInt1);
        i1 = Math.max(i1, localView.getMeasuredWidth());
        paramInt2 += localView.getMeasuredHeight();
        paramInt1 += 1;
      }
      setMeasuredDimension(i1, (this.d * (getChildCount() - 1) + paramInt2) * 12 / 10);
      return;
    }
    int i1 = 0;
    paramInt1 = 0;
    paramInt2 = i3;
    while (paramInt2 < getChildCount())
    {
      localView = getChildAt(paramInt2);
      i1 = Math.max(i1, localView.getMeasuredHeight());
      paramInt1 += localView.getMeasuredWidth();
      paramInt2 += 1;
    }
    setMeasuredDimension((this.d * (getChildCount() - 1) + paramInt1) * 12 / 10, i1);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      paramParcelable = (SavedState)paramParcelable;
      this.e = paramParcelable.a;
      b localb;
      if (this.j != null)
      {
        localb = this.j;
        if (!this.e) {
          break label57;
        }
      }
      label57:
      for (float f1 = 135.0F;; f1 = 0.0F)
      {
        localb.a(f1);
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        return;
      }
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.e;
    return localSavedState;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new d();
    public boolean a;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.a = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.a) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  private class a
    extends ViewGroup.LayoutParams
  {
    private ObjectAnimator b = new ObjectAnimator();
    private ObjectAnimator c = new ObjectAnimator();
    private ObjectAnimator d = new ObjectAnimator();
    private ObjectAnimator e = new ObjectAnimator();
    private ObjectAnimator f = new ObjectAnimator();
    private ObjectAnimator g = new ObjectAnimator();
    
    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.b.setInterpolator(FloatingActionsMenu.d());
      this.c.setInterpolator(FloatingActionsMenu.d());
      this.d.setInterpolator(FloatingActionsMenu.e());
      this.e.setInterpolator(FloatingActionsMenu.f());
      this.f.setInterpolator(FloatingActionsMenu.f());
      this.g.setInterpolator(FloatingActionsMenu.f());
      this.g.setProperty(View.ALPHA);
      this.g.setFloatValues(new float[] { 1.0F, 0.0F });
      this.d.setProperty(View.ALPHA);
      this.d.setFloatValues(new float[] { 0.0F, 1.0F });
      this.e.setProperty(View.TRANSLATION_Y);
      this.f.setProperty(View.TRANSLATION_X);
      this.b.setProperty(View.TRANSLATION_Y);
      this.c.setProperty(View.TRANSLATION_X);
      FloatingActionsMenu.d(FloatingActionsMenu.this).play(this.d);
      if (!FloatingActionsMenu.f(FloatingActionsMenu.this)) {
        FloatingActionsMenu.d(FloatingActionsMenu.this).play(this.b);
      }
      for (;;)
      {
        FloatingActionsMenu.e(FloatingActionsMenu.this).play(this.g);
        if (FloatingActionsMenu.f(FloatingActionsMenu.this)) {
          break;
        }
        FloatingActionsMenu.e(FloatingActionsMenu.this).play(this.e);
        return;
        FloatingActionsMenu.d(FloatingActionsMenu.this).play(this.c);
      }
      FloatingActionsMenu.e(FloatingActionsMenu.this).play(this.f);
    }
    
    public void a(View paramView)
    {
      this.g.setTarget(paramView);
      this.e.setTarget(paramView);
      this.f.setTarget(paramView);
      this.d.setTarget(paramView);
      this.b.setTarget(paramView);
      this.c.setTarget(paramView);
    }
  }
  
  private static class b
    extends LayerDrawable
  {
    private float a;
    
    public b(Drawable paramDrawable)
    {
      super();
    }
    
    public void a(float paramFloat)
    {
      this.a = paramFloat;
      invalidateSelf();
    }
    
    public void draw(Canvas paramCanvas)
    {
      paramCanvas.save();
      paramCanvas.rotate(this.a, getBounds().centerX(), getBounds().centerY());
      super.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\ui\floatingactionbutton\FloatingActionsMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */