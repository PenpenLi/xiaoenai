package com.bumptech.glide.d.d.b;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.d.b.k;

public abstract class a<T extends Drawable>
  implements k<T>
{
  protected final T a;
  
  public a(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("Drawable must not be null!");
    }
    this.a = paramT;
  }
  
  public final T a()
  {
    return this.a.getConstantState().newDrawable();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */