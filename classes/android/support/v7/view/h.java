package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h
{
  private final ArrayList<ViewPropertyAnimatorCompat> a = new ArrayList();
  private long b = -1L;
  private Interpolator c;
  private ViewPropertyAnimatorListener d;
  private boolean e;
  private final ViewPropertyAnimatorListenerAdapter f = new i(this);
  
  private void c()
  {
    this.e = false;
  }
  
  public h a(long paramLong)
  {
    if (!this.e) {
      this.b = paramLong;
    }
    return this;
  }
  
  public h a(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    if (!this.e) {
      this.a.add(paramViewPropertyAnimatorCompat);
    }
    return this;
  }
  
  public h a(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat1, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat2)
  {
    this.a.add(paramViewPropertyAnimatorCompat1);
    paramViewPropertyAnimatorCompat2.setStartDelay(paramViewPropertyAnimatorCompat1.getDuration());
    this.a.add(paramViewPropertyAnimatorCompat2);
    return this;
  }
  
  public h a(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener)
  {
    if (!this.e) {
      this.d = paramViewPropertyAnimatorListener;
    }
    return this;
  }
  
  public h a(Interpolator paramInterpolator)
  {
    if (!this.e) {
      this.c = paramInterpolator;
    }
    return this;
  }
  
  public void a()
  {
    if (this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)localIterator.next();
      if (this.b >= 0L) {
        localViewPropertyAnimatorCompat.setDuration(this.b);
      }
      if (this.c != null) {
        localViewPropertyAnimatorCompat.setInterpolator(this.c);
      }
      if (this.d != null) {
        localViewPropertyAnimatorCompat.setListener(this.f);
      }
      localViewPropertyAnimatorCompat.start();
    }
    this.e = true;
  }
  
  public void b()
  {
    if (!this.e) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ViewPropertyAnimatorCompat)localIterator.next()).cancel();
    }
    this.e = false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\view\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */