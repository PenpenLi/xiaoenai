package android.support.v7.widget;

import android.view.MenuItem;

class ca
  implements ActionMenuView.OnMenuItemClickListener
{
  ca(Toolbar paramToolbar) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (Toolbar.access$000(this.a) != null) {
      return Toolbar.access$000(this.a).onMenuItemClick(paramMenuItem);
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */