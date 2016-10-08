package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.widget.VectorEnabledTintResources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity
  extends FragmentActivity
  implements TaskStackBuilder.SupportParentable, l
{
  private AppCompatDelegate a;
  private int b = 0;
  private boolean c;
  private Resources d;
  
  @Nullable
  public ActionBar a()
  {
    return d().a();
  }
  
  @Nullable
  public b a(@NonNull b.a parama)
  {
    return null;
  }
  
  public void a(@NonNull TaskStackBuilder paramTaskStackBuilder)
  {
    paramTaskStackBuilder.addParentStack(this);
  }
  
  @CallSuper
  public void a(@NonNull b paramb) {}
  
  public boolean a(@NonNull Intent paramIntent)
  {
    return NavUtils.shouldUpRecreateTask(this, paramIntent);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    d().b(paramView, paramLayoutParams);
  }
  
  public void b(@NonNull Intent paramIntent)
  {
    NavUtils.navigateUpTo(this, paramIntent);
  }
  
  public void b(@NonNull TaskStackBuilder paramTaskStackBuilder) {}
  
  @CallSuper
  public void b(@NonNull b paramb) {}
  
  public boolean b()
  {
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null)
    {
      if (a((Intent)localObject))
      {
        localObject = TaskStackBuilder.create(this);
        a((TaskStackBuilder)localObject);
        b((TaskStackBuilder)localObject);
        ((TaskStackBuilder)localObject).startActivities();
      }
      for (;;)
      {
        try
        {
          ActivityCompat.finishAffinity(this);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        b(localIllegalStateException);
      }
    }
    return false;
  }
  
  @Deprecated
  public void c() {}
  
  @NonNull
  public AppCompatDelegate d()
  {
    if (this.a == null) {
      this.a = AppCompatDelegate.a(this, this);
    }
    return this.a;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((KeyEventCompat.hasModifiers(paramKeyEvent, 4096)) && (paramKeyEvent.getUnicodeChar(paramKeyEvent.getMetaState() & 0x8FFF) == 60))
    {
      int i = paramKeyEvent.getAction();
      if (i == 0)
      {
        ActionBar localActionBar = a();
        if ((localActionBar != null) && (localActionBar.b()) && (localActionBar.g()))
        {
          this.c = true;
          return true;
        }
      }
      else if ((i == 1) && (this.c))
      {
        this.c = false;
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  @Nullable
  public View findViewById(@IdRes int paramInt)
  {
    return d().a(paramInt);
  }
  
  public MenuInflater getMenuInflater()
  {
    return d().b();
  }
  
  public Resources getResources()
  {
    if ((this.d == null) && (VectorEnabledTintResources.shouldBeUsed())) {
      this.d = new VectorEnabledTintResources(this, super.getResources());
    }
    if (this.d == null) {
      return super.getResources();
    }
    return this.d;
  }
  
  @Nullable
  public Intent getSupportParentActivityIntent()
  {
    return NavUtils.getParentActivityIntent(this);
  }
  
  public void invalidateOptionsMenu()
  {
    d().e();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    d().a(paramConfiguration);
    if (this.d != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.d.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }
  
  public void onContentChanged()
  {
    c();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    AppCompatDelegate localAppCompatDelegate = d();
    localAppCompatDelegate.g();
    localAppCompatDelegate.a(paramBundle);
    if ((localAppCompatDelegate.h()) && (this.b != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label55;
      }
      onApplyThemeResource(getTheme(), this.b, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      return;
      label55:
      setTheme(this.b);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d().f();
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = a();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.a() & 0x4) != 0)) {
      return b();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostCreate(@Nullable Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    d().b(paramBundle);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    d().d();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    d().c(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    d().c();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    d().a(paramCharSequence);
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    d().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    d().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    d().a(paramView, paramLayoutParams);
  }
  
  public void setTheme(@StyleRes int paramInt)
  {
    super.setTheme(paramInt);
    this.b = paramInt;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    d().e();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\AppCompatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */