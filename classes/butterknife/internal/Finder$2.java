package butterknife.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;

 enum Finder$2
{
  Finder$2()
  {
    super(paramString, paramInt, null);
  }
  
  public View findOptionalView(Object paramObject, @IdRes int paramInt)
  {
    return ((Activity)paramObject).findViewById(paramInt);
  }
  
  public Context getContext(Object paramObject)
  {
    return (Activity)paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\internal\Finder$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */