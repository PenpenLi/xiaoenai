package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;

class o
{
  private final View a;
  private final AppCompatDrawableManager b;
  private by c;
  private by d;
  private by e;
  
  o(View paramView, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    this.a = paramView;
    this.b = paramAppCompatDrawableManager;
  }
  
  private boolean b(@NonNull Drawable paramDrawable)
  {
    if (this.e == null) {
      this.e = new by();
    }
    by localby = this.e;
    localby.a();
    Object localObject = ViewCompat.getBackgroundTintList(this.a);
    if (localObject != null)
    {
      localby.d = true;
      localby.a = ((ColorStateList)localObject);
    }
    localObject = ViewCompat.getBackgroundTintMode(this.a);
    if (localObject != null)
    {
      localby.c = true;
      localby.b = ((PorterDuff.Mode)localObject);
    }
    if ((localby.d) || (localby.c))
    {
      AppCompatDrawableManager.tintDrawable(paramDrawable, localby, this.a.getDrawableState());
      return true;
    }
    return false;
  }
  
  ColorStateList a()
  {
    if (this.d != null) {
      return this.d.a;
    }
    return null;
  }
  
  void a(int paramInt)
  {
    if (this.b != null) {}
    for (ColorStateList localColorStateList = this.b.getTintList(this.a.getContext(), paramInt);; localColorStateList = null)
    {
      b(localColorStateList);
      return;
    }
  }
  
  void a(ColorStateList paramColorStateList)
  {
    if (this.d == null) {
      this.d = new by();
    }
    this.d.a = paramColorStateList;
    this.d.d = true;
    c();
  }
  
  void a(PorterDuff.Mode paramMode)
  {
    if (this.d == null) {
      this.d = new by();
    }
    this.d.b = paramMode;
    this.d.c = true;
    c();
  }
  
  void a(Drawable paramDrawable)
  {
    b(null);
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, a.k.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(a.k.ViewBackgroundHelper_android_background))
      {
        ColorStateList localColorStateList = this.b.getTintList(this.a.getContext(), paramAttributeSet.getResourceId(a.k.ViewBackgroundHelper_android_background, -1));
        if (localColorStateList != null) {
          b(localColorStateList);
        }
      }
      if (paramAttributeSet.hasValue(a.k.ViewBackgroundHelper_backgroundTint)) {
        ViewCompat.setBackgroundTintList(this.a, paramAttributeSet.getColorStateList(a.k.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.hasValue(a.k.ViewBackgroundHelper_backgroundTintMode)) {
        ViewCompat.setBackgroundTintMode(this.a, DrawableUtils.parseTintMode(paramAttributeSet.getInt(a.k.ViewBackgroundHelper_backgroundTintMode, -1), null));
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
    if (this.d != null) {
      return this.d.b;
    }
    return null;
  }
  
  void b(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.c == null) {
        this.c = new by();
      }
      this.c.a = paramColorStateList;
      this.c.d = true;
    }
    for (;;)
    {
      c();
      return;
      this.c = null;
    }
  }
  
  void c()
  {
    Drawable localDrawable = this.a.getBackground();
    if ((localDrawable == null) || ((Build.VERSION.SDK_INT == 21) && (b(localDrawable)))) {}
    do
    {
      return;
      if (this.d != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, this.d, this.a.getDrawableState());
        return;
      }
    } while (this.c == null);
    AppCompatDrawableManager.tintDrawable(localDrawable, this.c, this.a.getDrawableState());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */