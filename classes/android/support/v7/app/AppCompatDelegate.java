package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class AppCompatDelegate
{
  private static int a = -1;
  private static boolean b = false;
  
  public static AppCompatDelegate a(Activity paramActivity, l paraml)
  {
    return a(paramActivity, paramActivity.getWindow(), paraml);
  }
  
  public static AppCompatDelegate a(Dialog paramDialog, l paraml)
  {
    return a(paramDialog.getContext(), paramDialog.getWindow(), paraml);
  }
  
  private static AppCompatDelegate a(Context paramContext, Window paramWindow, l paraml)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return new p(paramContext, paramWindow, paraml);
    }
    if (i >= 14) {
      return new o(paramContext, paramWindow, paraml);
    }
    if (i >= 11) {
      return new n(paramContext, paramWindow, paraml);
    }
    return new AppCompatDelegateImplV7(paramContext, paramWindow, paraml);
  }
  
  public static int i()
  {
    return a;
  }
  
  public static boolean j()
  {
    return b;
  }
  
  @Nullable
  public abstract ActionBar a();
  
  @Nullable
  public abstract View a(@IdRes int paramInt);
  
  public abstract void a(Configuration paramConfiguration);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void a(@Nullable CharSequence paramCharSequence);
  
  public abstract MenuInflater b();
  
  public abstract void b(@LayoutRes int paramInt);
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void b(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void c();
  
  public abstract void c(Bundle paramBundle);
  
  public abstract boolean c(int paramInt);
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract boolean h();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NightMode {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\AppCompatDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */