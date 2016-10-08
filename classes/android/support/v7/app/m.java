package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.j;
import android.support.v7.view.menu.f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class m
  extends AppCompatDelegate
{
  final Context a;
  final Window b;
  final Window.Callback c;
  final Window.Callback d;
  final l e;
  ActionBar f;
  MenuInflater g;
  boolean h;
  boolean i;
  boolean j;
  boolean k;
  boolean l;
  private CharSequence m;
  private boolean n;
  
  m(Context paramContext, Window paramWindow, l paraml)
  {
    this.a = paramContext;
    this.b = paramWindow;
    this.e = paraml;
    this.c = this.b.getCallback();
    if ((this.c instanceof a)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.d = a(this.c);
    this.b.setCallback(this.d);
  }
  
  public ActionBar a()
  {
    k();
    return this.f;
  }
  
  abstract b a(b.a parama);
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  abstract void a(int paramInt, Menu paramMenu);
  
  public final void a(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    b(paramCharSequence);
  }
  
  abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  abstract boolean a(KeyEvent paramKeyEvent);
  
  public MenuInflater b()
  {
    if (this.g == null)
    {
      k();
      if (this.f == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.f.c();; localContext = this.a)
    {
      this.g = new g(localContext);
      return this.g;
    }
  }
  
  abstract void b(CharSequence paramCharSequence);
  
  abstract boolean b(int paramInt, Menu paramMenu);
  
  public void c(Bundle paramBundle) {}
  
  public void f()
  {
    this.n = true;
  }
  
  public boolean h()
  {
    return false;
  }
  
  abstract void k();
  
  final ActionBar l()
  {
    return this.f;
  }
  
  final Context m()
  {
    Context localContext = null;
    Object localObject = a();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).c();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.a;
    }
    return (Context)localObject;
  }
  
  public boolean n()
  {
    return false;
  }
  
  final boolean o()
  {
    return this.n;
  }
  
  final Window.Callback p()
  {
    return this.b.getCallback();
  }
  
  final CharSequence q()
  {
    if ((this.c instanceof Activity)) {
      return ((Activity)this.c).getTitle();
    }
    return this.m;
  }
  
  class a
    extends j
  {
    a(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (m.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (m.this.a(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof f))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      m.this.b(paramInt, paramMenu);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      m.this.a(paramInt, paramMenu);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      f localf;
      boolean bool1;
      if ((paramMenu instanceof f))
      {
        localf = (f)paramMenu;
        if ((paramInt != 0) || (localf != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localf = null;
        break;
        if (localf != null) {
          localf.c(true);
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localf == null);
      localf.c(false);
      return bool2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */