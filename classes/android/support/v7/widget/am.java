package android.support.v7.widget;

import android.view.View;

class am
  implements Runnable
{
  am(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    View localView = this.a.getAnchorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.a.show();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */