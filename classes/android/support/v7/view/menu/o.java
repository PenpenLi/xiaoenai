package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class o
{
  public static Menu a(Context paramContext, SupportMenu paramSupportMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new p(paramContext, paramSupportMenu);
    }
    throw new UnsupportedOperationException();
  }
  
  public static MenuItem a(Context paramContext, SupportMenuItem paramSupportMenuItem)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new k(paramContext, paramSupportMenuItem);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new j(paramContext, paramSupportMenuItem);
    }
    throw new UnsupportedOperationException();
  }
  
  public static SubMenu a(Context paramContext, SupportSubMenu paramSupportSubMenu)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new r(paramContext, paramSupportSubMenu);
    }
    throw new UnsupportedOperationException();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\view\menu\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */