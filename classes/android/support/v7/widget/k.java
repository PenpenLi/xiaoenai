package android.support.v7.widget;

import android.support.v4.view.ActionProvider;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class k
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  k(ActivityChooserView paramActivityChooserView) {}
  
  public void onGlobalLayout()
  {
    if (this.a.isShowingPopup())
    {
      if (this.a.isShown()) {
        break label31;
      }
      ActivityChooserView.access$100(this.a).dismiss();
    }
    label31:
    do
    {
      return;
      ActivityChooserView.access$100(this.a).show();
    } while (this.a.mProvider == null);
    this.a.mProvider.subUiVisibilityChanged(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */