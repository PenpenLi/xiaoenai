package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper
  extends ContextWrapper
{
  private static final ArrayList<WeakReference<TintContextWrapper>> sCache = new ArrayList();
  private Resources mResources;
  private final Resources.Theme mTheme;
  
  private TintContextWrapper(@NonNull Context paramContext)
  {
    super(paramContext);
    if (VectorEnabledTintResources.shouldBeUsed())
    {
      this.mTheme = getResources().newTheme();
      this.mTheme.setTo(paramContext.getTheme());
      return;
    }
    this.mTheme = null;
  }
  
  private static boolean shouldWrap(@NonNull Context paramContext)
  {
    if (((paramContext instanceof TintContextWrapper)) || ((paramContext.getResources() instanceof bz)) || ((paramContext.getResources() instanceof VectorEnabledTintResources))) {}
    while ((AppCompatDelegate.j()) && (Build.VERSION.SDK_INT > 20)) {
      return false;
    }
    return true;
  }
  
  public static Context wrap(@NonNull Context paramContext)
  {
    Object localObject = paramContext;
    int j;
    int i;
    if (shouldWrap(paramContext))
    {
      j = sCache.size();
      i = 0;
    }
    while (i < j)
    {
      localObject = (WeakReference)sCache.get(i);
      if (localObject != null) {}
      for (localObject = (TintContextWrapper)((WeakReference)localObject).get(); (localObject != null) && (((TintContextWrapper)localObject).getBaseContext() == paramContext); localObject = null) {
        return (Context)localObject;
      }
      i += 1;
    }
    paramContext = new TintContextWrapper(paramContext);
    sCache.add(new WeakReference(paramContext));
    return paramContext;
  }
  
  public Resources getResources()
  {
    if (this.mResources == null) {
      if (this.mTheme != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = new bz(this, super.getResources());; localObject = new VectorEnabledTintResources(this, super.getResources()))
    {
      this.mResources = ((Resources)localObject);
      return this.mResources;
    }
  }
  
  public Resources.Theme getTheme()
  {
    if (this.mTheme == null) {
      return super.getTheme();
    }
    return this.mTheme;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mTheme == null)
    {
      super.setTheme(paramInt);
      return;
    }
    this.mTheme.applyStyle(paramInt, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\TintContextWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */