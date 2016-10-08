package android.support.v7.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

class w
  implements PopupWindow.OnDismissListener
{
  w(AppCompatSpinner.b paramb, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public void onDismiss()
  {
    ViewTreeObserver localViewTreeObserver = this.b.a.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */