package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.support.v7.c.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class x
{
  private static final int[] b = { 16842804, 16843119, 16843117, 16843120, 16843118 };
  private static final int[] c = { a.a.textAllCaps };
  final TextView a;
  private by d;
  private by e;
  private by f;
  private by g;
  
  x(TextView paramTextView)
  {
    this.a = paramTextView;
  }
  
  protected static by a(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    paramContext = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramAppCompatDrawableManager = new by();
      paramAppCompatDrawableManager.d = true;
      paramAppCompatDrawableManager.a = paramContext;
      return paramAppCompatDrawableManager;
    }
    return null;
  }
  
  static x a(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new y(paramTextView);
    }
    return new x(paramTextView);
  }
  
  void a()
  {
    if ((this.d != null) || (this.e != null) || (this.f != null) || (this.g != null))
    {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawables();
      a(arrayOfDrawable[0], this.d);
      a(arrayOfDrawable[1], this.e);
      a(arrayOfDrawable[2], this.f);
      a(arrayOfDrawable[3], this.g);
    }
  }
  
  void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, c);
    if (paramContext.hasValue(0)) {
      a(paramContext.getBoolean(0, false));
    }
    paramContext.recycle();
  }
  
  final void a(Drawable paramDrawable, by paramby)
  {
    if ((paramDrawable != null) && (paramby != null)) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramby, this.a.getDrawableState());
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    int j = 1;
    Context localContext = this.a.getContext();
    Object localObject = AppCompatDrawableManager.get();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, b, paramInt, 0);
    int i = localTypedArray.getResourceId(0, -1);
    if (localTypedArray.hasValue(1)) {
      this.d = a(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(1, 0));
    }
    if (localTypedArray.hasValue(2)) {
      this.e = a(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(2, 0));
    }
    if (localTypedArray.hasValue(3)) {
      this.f = a(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(3, 0));
    }
    if (localTypedArray.hasValue(4)) {
      this.g = a(localContext, (AppCompatDrawableManager)localObject, localTypedArray.getResourceId(4, 0));
    }
    localTypedArray.recycle();
    boolean bool;
    if (!(this.a.getTransformationMethod() instanceof PasswordTransformationMethod))
    {
      if (i == -1) {
        break label266;
      }
      localObject = localContext.obtainStyledAttributes(i, a.k.TextAppearance);
      if (!((TypedArray)localObject).hasValue(a.k.TextAppearance_textAllCaps)) {
        break label257;
      }
      bool = ((TypedArray)localObject).getBoolean(a.k.TextAppearance_textAllCaps, false);
      i = 1;
      ((TypedArray)localObject).recycle();
    }
    for (;;)
    {
      paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, c, paramInt, 0);
      if (paramAttributeSet.hasValue(0)) {
        bool = paramAttributeSet.getBoolean(0, false);
      }
      for (paramInt = j;; paramInt = i)
      {
        paramAttributeSet.recycle();
        if (paramInt != 0) {
          a(bool);
        }
        return;
      }
      label257:
      i = 0;
      bool = false;
      break;
      label266:
      i = 0;
      bool = false;
    }
  }
  
  void a(boolean paramBoolean)
  {
    TextView localTextView = this.a;
    if (paramBoolean) {}
    for (a locala = new a(this.a.getContext());; locala = null)
    {
      localTextView.setTransformationMethod(locala);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */