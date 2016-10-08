package butterknife.internal;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;

 enum Finder$1
{
  Finder$1()
  {
    super(paramString, paramInt, null);
  }
  
  public View findOptionalView(Object paramObject, @IdRes int paramInt)
  {
    return ((View)paramObject).findViewById(paramInt);
  }
  
  public Context getContext(Object paramObject)
  {
    return ((View)paramObject).getContext();
  }
  
  protected String getResourceEntryName(Object paramObject, @IdRes int paramInt)
  {
    if (((View)paramObject).isInEditMode()) {
      return "<unavailable while editing>";
    }
    return super.getResourceEntryName(paramObject, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\internal\Finder$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */