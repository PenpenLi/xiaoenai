package butterknife.internal;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;

 enum Finder$3
{
  Finder$3()
  {
    super(paramString, paramInt, null);
  }
  
  public View findOptionalView(Object paramObject, @IdRes int paramInt)
  {
    return ((Dialog)paramObject).findViewById(paramInt);
  }
  
  public Context getContext(Object paramObject)
  {
    return ((Dialog)paramObject).getContext();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\butterknife\internal\Finder$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */