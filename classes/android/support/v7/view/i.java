package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import java.util.ArrayList;

class i
  extends ViewPropertyAnimatorListenerAdapter
{
  private boolean b = false;
  private int c = 0;
  
  i(h paramh) {}
  
  void a()
  {
    this.c = 0;
    this.b = false;
    h.b(this.a);
  }
  
  public void onAnimationEnd(View paramView)
  {
    int i = this.c + 1;
    this.c = i;
    if (i == h.c(this.a).size())
    {
      if (h.a(this.a) != null) {
        h.a(this.a).onAnimationEnd(null);
      }
      a();
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    if (this.b) {}
    do
    {
      return;
      this.b = true;
    } while (h.a(this.a) == null);
    h.a(this.a).onAnimationStart(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\view\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */