package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class g
  implements Runnable
{
  g(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void run()
  {
    ActionBarOverlayLayout.access$200(this.a);
    ActionBarOverlayLayout.access$002(this.a, ViewCompat.animate(ActionBarOverlayLayout.access$400(this.a)).translationY(-ActionBarOverlayLayout.access$400(this.a).getHeight()).setListener(ActionBarOverlayLayout.access$300(this.a)));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */