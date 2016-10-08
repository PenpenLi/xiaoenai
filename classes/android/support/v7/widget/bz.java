package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class bz
  extends ba
{
  private final WeakReference<Context> a;
  
  public bz(@NonNull Context paramContext, @NonNull Resources paramResources)
  {
    super(paramResources);
    this.a = new WeakReference(paramContext);
  }
  
  public Drawable getDrawable(int paramInt)
  {
    Drawable localDrawable = super.getDrawable(paramInt);
    Context localContext = (Context)this.a.get();
    if ((localDrawable != null) && (localContext != null))
    {
      AppCompatDrawableManager.get();
      AppCompatDrawableManager.tintDrawableUsingColorFilter(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */