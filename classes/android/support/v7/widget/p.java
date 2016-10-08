package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class p
{
  private final CompoundButton a;
  private final AppCompatDrawableManager b;
  private ColorStateList c = null;
  private PorterDuff.Mode d = null;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  
  p(CompoundButton paramCompoundButton, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    this.a = paramCompoundButton;
    this.b = paramAppCompatDrawableManager;
  }
  
  int a(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.a);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  ColorStateList a()
  {
    return this.c;
  }
  
  void a(ColorStateList paramColorStateList)
  {
    this.c = paramColorStateList;
    this.e = true;
    d();
  }
  
  void a(@Nullable PorterDuff.Mode paramMode)
  {
    this.d = paramMode;
    this.f = true;
    d();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, a.k.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.k.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(a.k.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.a.setButtonDrawable(this.b.getDrawable(this.a.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(a.k.CompoundButton_buttonTint)) {
        CompoundButtonCompat.setButtonTintList(this.a, paramAttributeSet.getColorStateList(a.k.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(a.k.CompoundButton_buttonTintMode)) {
        CompoundButtonCompat.setButtonTintMode(this.a, DrawableUtils.parseTintMode(paramAttributeSet.getInt(a.k.CompoundButton_buttonTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  PorterDuff.Mode b()
  {
    return this.d;
  }
  
  void c()
  {
    if (this.g)
    {
      this.g = false;
      return;
    }
    this.g = true;
    d();
  }
  
  void d()
  {
    Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.a);
    if ((localDrawable != null) && ((this.e) || (this.f)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (this.e) {
        DrawableCompat.setTintList(localDrawable, this.c);
      }
      if (this.f) {
        DrawableCompat.setTintMode(localDrawable, this.d);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.a.getDrawableState());
      }
      this.a.setButtonDrawable(localDrawable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */