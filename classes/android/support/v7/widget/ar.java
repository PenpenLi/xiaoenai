package android.support.v7.widget;

import android.support.v7.view.menu.l;
import android.view.View;

class ar
  extends ListPopupWindow.ForwardingListener
{
  ar(PopupMenu paramPopupMenu, View paramView)
  {
    super(paramView);
  }
  
  public ListPopupWindow getPopup()
  {
    return PopupMenu.access$000(this.a).d();
  }
  
  protected boolean onForwardingStarted()
  {
    this.a.show();
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    this.a.dismiss();
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */