package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class p
  extends o
{
  private final UiModeManager r;
  
  p(Context paramContext, Window paramWindow, l paraml)
  {
    super(paramContext, paramWindow, paraml);
    this.r = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  int d(int paramInt)
  {
    if ((paramInt == 0) && (this.r.getNightMode() == 0)) {
      return -1;
    }
    return super.d(paramInt);
  }
  
  class a
    extends o.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (p.this.n()) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return a(paramCallback);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */