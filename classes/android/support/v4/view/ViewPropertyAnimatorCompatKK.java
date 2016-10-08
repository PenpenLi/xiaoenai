package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatKK
{
  public static void setUpdateListener(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    ViewPropertyAnimatorCompatKK.1 local1 = null;
    if (paramViewPropertyAnimatorUpdateListener != null) {
      local1 = new ViewPropertyAnimatorCompatKK.1(paramViewPropertyAnimatorUpdateListener, paramView);
    }
    paramView.animate().setUpdateListener(local1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompatKK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */