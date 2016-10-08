package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

class y
  extends x
{
  private static final int[] b = { 16843666, 16843667 };
  private by c;
  private by d;
  
  y(TextView paramTextView)
  {
    super(paramTextView);
  }
  
  void a()
  {
    super.a();
    if ((this.c != null) || (this.d != null))
    {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.c);
      a(arrayOfDrawable[2], this.d);
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    Context localContext = this.a.getContext();
    AppCompatDrawableManager localAppCompatDrawableManager = AppCompatDrawableManager.get();
    paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, b, paramInt, 0);
    if (paramAttributeSet.hasValue(0)) {
      this.c = a(localContext, localAppCompatDrawableManager, paramAttributeSet.getResourceId(0, 0));
    }
    if (paramAttributeSet.hasValue(1)) {
      this.d = a(localContext, localAppCompatDrawableManager, paramAttributeSet.getResourceId(1, 0));
    }
    paramAttributeSet.recycle();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */