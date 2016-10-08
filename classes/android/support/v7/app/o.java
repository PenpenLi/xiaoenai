package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.f.a;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class o
  extends n
{
  private static ae r;
  private int s = -100;
  private boolean t;
  private boolean u = true;
  
  o(Context paramContext, Window paramWindow, l paraml)
  {
    super(paramContext, paramWindow, paraml);
  }
  
  private boolean e(int paramInt)
  {
    Resources localResources = this.a.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2) {}
    for (paramInt = 32; (i & 0x30) != paramInt; paramInt = 16)
    {
      localConfiguration = new Configuration(localConfiguration);
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, null);
      return true;
    }
    return false;
  }
  
  private ae s()
  {
    if (r == null) {
      r = new ae(this.a.getApplicationContext());
    }
    return r;
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if ((paramBundle != null) && (this.s == -100)) {
      this.s = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    if (this.s != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.s);
    }
  }
  
  int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if (s().a()) {
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  public boolean h()
  {
    this.t = true;
    if (this.s == -100) {}
    for (int i = i();; i = this.s)
    {
      i = d(i);
      if (i == -1) {
        break;
      }
      return e(i);
    }
    return false;
  }
  
  public boolean n()
  {
    return this.u;
  }
  
  class a
    extends m.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    final ActionMode a(ActionMode.Callback paramCallback)
    {
      paramCallback = new f.a(o.this.a, paramCallback);
      b localb = o.this.b(paramCallback);
      if (localb != null) {
        return paramCallback.b(localb);
      }
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (o.this.n()) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */