package com.c.c;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.c.a.a.a;
import java.lang.ref.WeakReference;

class e
  extends b
{
  private final WeakReference<ViewPropertyAnimator> a;
  
  e(View paramView)
  {
    this.a = new WeakReference(paramView.animate());
  }
  
  public b a(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.translationX(paramFloat);
    }
    return this;
  }
  
  public b a(long paramLong)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.setDuration(paramLong);
    }
    return this;
  }
  
  public b a(a.a parama)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null)
    {
      if (parama == null) {
        localViewPropertyAnimator.setListener(null);
      }
    }
    else {
      return this;
    }
    localViewPropertyAnimator.setListener(new f(this, parama));
    return this;
  }
  
  public b b(float paramFloat)
  {
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)this.a.get();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.alpha(paramFloat);
    }
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */