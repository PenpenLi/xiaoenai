package android.support.v7.widget;

import android.view.View;

class t
  extends ListPopupWindow.ForwardingListener
{
  t(AppCompatSpinner paramAppCompatSpinner, View paramView, AppCompatSpinner.b paramb)
  {
    super(paramView);
  }
  
  public ListPopupWindow getPopup()
  {
    return this.a;
  }
  
  public boolean onForwardingStarted()
  {
    if (!AppCompatSpinner.access$000(this.b).isShowing()) {
      AppCompatSpinner.access$000(this.b).show();
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */