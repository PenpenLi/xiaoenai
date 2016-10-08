package android.support.v7.widget;

import android.view.View;

class l
  extends ListPopupWindow.ForwardingListener
{
  l(ActivityChooserView paramActivityChooserView, View paramView)
  {
    super(paramView);
  }
  
  public ListPopupWindow getPopup()
  {
    return ActivityChooserView.access$100(this.a);
  }
  
  protected boolean onForwardingStarted()
  {
    this.a.showPopup();
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    this.a.dismissPopup();
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */