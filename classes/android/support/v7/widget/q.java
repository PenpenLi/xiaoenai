package android.support.v7.widget;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class q
  implements ViewTreeObserver.OnScrollChangedListener
{
  q(Field paramField, PopupWindow paramPopupWindow, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener) {}
  
  public void onScrollChanged()
  {
    try
    {
      WeakReference localWeakReference = (WeakReference)this.a.get(this.b);
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null) {
          return;
        }
        this.c.onScrollChanged();
        return;
      }
    }
    catch (IllegalAccessException localIllegalAccessException) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */