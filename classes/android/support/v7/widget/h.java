package android.support.v7.widget;

import android.view.View;

class h
  extends ListPopupWindow.ForwardingListener
{
  h(ActionMenuPresenter.d paramd, View paramView, ActionMenuPresenter paramActionMenuPresenter)
  {
    super(paramView);
  }
  
  public ListPopupWindow getPopup()
  {
    if (ActionMenuPresenter.a(this.b.a) == null) {
      return null;
    }
    return ActionMenuPresenter.a(this.b.a).d();
  }
  
  public boolean onForwardingStarted()
  {
    this.b.a.d();
    return true;
  }
  
  public boolean onForwardingStopped()
  {
    if (ActionMenuPresenter.b(this.b.a) != null) {
      return false;
    }
    this.b.a.e();
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */