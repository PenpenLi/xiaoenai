package com.inmobi.ads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.ref.WeakReference;

final class m
  extends ap
{
  private static final String b = m.class.getSimpleName();
  @NonNull
  private ViewTreeObserver.OnPreDrawListener c;
  @NonNull
  private final WeakReference<View> d;
  
  public m(@NonNull ap.a parama, @NonNull Activity paramActivity)
  {
    super(parama);
    parama = paramActivity.getWindow().getDecorView();
    this.d = new WeakReference(parama);
    parama = parama.getViewTreeObserver();
    if (!parama.isAlive())
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Visibility Tracker was unable to track views because the root view tree observer was not alive");
      return;
    }
    this.c = new m.1(this);
    parama.addOnPreDrawListener(this.c);
  }
  
  private void i()
  {
    Object localObject = (View)this.d.get();
    if (localObject != null)
    {
      localObject = ((View)localObject).getViewTreeObserver();
      if (!((ViewTreeObserver)localObject).isAlive()) {
        Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Visibility Tracker was unable to track views because the root view tree observer was not alive");
      }
    }
    else
    {
      return;
    }
    ((ViewTreeObserver)localObject).addOnPreDrawListener(this.c);
  }
  
  private void j()
  {
    Object localObject = (View)this.d.get();
    if (localObject != null)
    {
      localObject = ((View)localObject).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).removeOnPreDrawListener(this.c);
      }
    }
  }
  
  protected int a()
  {
    return 100;
  }
  
  protected void b() {}
  
  public void c()
  {
    if (!f())
    {
      j();
      super.c();
    }
  }
  
  public void d()
  {
    if (f())
    {
      i();
      super.d();
    }
  }
  
  protected void e()
  {
    j();
    super.e();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */