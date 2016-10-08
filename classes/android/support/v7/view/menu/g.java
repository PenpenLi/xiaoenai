package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.a.a.h;
import android.support.v7.app.k;
import android.support.v7.app.k.a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;

class g
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, m.a
{
  e a;
  private f b;
  private k c;
  private m.a d;
  
  public g(f paramf)
  {
    this.b = paramf;
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
  }
  
  public void a(IBinder paramIBinder)
  {
    Object localObject = this.b;
    k.a locala = new k.a(((f)localObject).e());
    this.a = new e(locala.a(), a.h.abc_list_menu_item_layout);
    this.a.a(this);
    this.b.a(this.a);
    locala.a(this.a.a(), this);
    View localView = ((f)localObject).o();
    if (localView != null) {
      locala.a(localView);
    }
    for (;;)
    {
      locala.a(this);
      this.c = locala.b();
      this.c.setOnDismissListener(this);
      localObject = this.c.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).type = 1003;
      if (paramIBinder != null) {
        ((WindowManager.LayoutParams)localObject).token = paramIBinder;
      }
      ((WindowManager.LayoutParams)localObject).flags |= 0x20000;
      this.c.show();
      return;
      locala.a(((f)localObject).n()).a(((f)localObject).m());
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.a((h)this.a.a().getItem(paramInt), 0);
  }
  
  public void onCloseMenu(f paramf, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramf == this.b)) {
      a();
    }
    if (this.d != null) {
      this.d.onCloseMenu(paramf, paramBoolean);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(this.b, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.c.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.c.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.b.a(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.b.performShortcut(paramInt, paramKeyEvent, 0);
  }
  
  public boolean onOpenSubMenu(f paramf)
  {
    if (this.d != null) {
      return this.d.onOpenSubMenu(paramf);
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\view\menu\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */