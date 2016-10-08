package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.m.a;
import android.support.v7.widget.DecorToolbar;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

class ab
  extends ActionBar
{
  private DecorToolbar a;
  private Window.Callback b;
  private boolean c;
  private boolean d;
  private ArrayList<ActionBar.a> e;
  private final Runnable f;
  
  private Menu j()
  {
    if (!this.c)
    {
      this.a.setMenuCallbacks(new a(null), new b(null));
      this.c = true;
    }
    return this.a.getMenu();
  }
  
  public int a()
  {
    return this.a.getDisplayOptions();
  }
  
  public void a(float paramFloat)
  {
    ViewCompat.setElevation(this.a.getViewGroup(), paramFloat);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.a.setWindowTitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = j();
    int i;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label54;
      }
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label60;
      }
    }
    label54:
    label60:
    for (boolean bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return true;
      i = -1;
      break;
    }
  }
  
  public boolean b()
  {
    return this.a.getVisibility() == 0;
  }
  
  public Context c()
  {
    return this.a.getContext();
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean == this.d) {}
    for (;;)
    {
      return;
      this.d = paramBoolean;
      int j = this.e.size();
      int i = 0;
      while (i < j)
      {
        ((ActionBar.a)this.e.get(i)).a(paramBoolean);
        i += 1;
      }
    }
  }
  
  public boolean e()
  {
    this.a.getViewGroup().removeCallbacks(this.f);
    ViewCompat.postOnAnimation(this.a.getViewGroup(), this.f);
    return true;
  }
  
  public boolean f()
  {
    if (this.a.hasExpandedActionView())
    {
      this.a.collapseActionView();
      return true;
    }
    return false;
  }
  
  public boolean g()
  {
    ViewGroup localViewGroup = this.a.getViewGroup();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  void h()
  {
    this.a.getViewGroup().removeCallbacks(this.f);
  }
  
  void i()
  {
    Menu localMenu = j();
    if ((localMenu instanceof f)) {}
    for (localf = (f)localMenu;; localf = null)
    {
      if (localf != null) {
        localf.g();
      }
      try
      {
        localMenu.clear();
        if ((!this.b.onCreatePanelMenu(0, localMenu)) || (!this.b.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
      }
      finally
      {
        if (localf == null) {
          break;
        }
        localf.h();
      }
    }
  }
  
  private final class a
    implements m.a
  {
    private boolean b;
    
    private a() {}
    
    public void onCloseMenu(f paramf, boolean paramBoolean)
    {
      if (this.b) {
        return;
      }
      this.b = true;
      ab.b(ab.this).dismissPopupMenus();
      if (ab.a(ab.this) != null) {
        ab.a(ab.this).onPanelClosed(108, paramf);
      }
      this.b = false;
    }
    
    public boolean onOpenSubMenu(f paramf)
    {
      if (ab.a(ab.this) != null)
      {
        ab.a(ab.this).onMenuOpened(108, paramf);
        return true;
      }
      return false;
    }
  }
  
  private final class b
    implements f.a
  {
    private b() {}
    
    public boolean onMenuItemSelected(f paramf, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public void onMenuModeChange(f paramf)
    {
      if (ab.a(ab.this) != null)
      {
        if (!ab.b(ab.this).isOverflowMenuShowing()) {
          break label41;
        }
        ab.a(ab.this).onPanelClosed(108, paramf);
      }
      label41:
      while (!ab.a(ab.this).onPreparePanel(0, null, paramf)) {
        return;
      }
      ab.a(ab.this).onMenuOpened(108, paramf);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */