package android.support.v7.widget.helper;

import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;

class h
  implements AnimatorUpdateListenerCompat
{
  h(ItemTouchHelper.b paramb, ItemTouchHelper paramItemTouchHelper) {}
  
  public void onAnimationUpdate(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    this.b.a(paramValueAnimatorCompat.getAnimatedFraction());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\helper\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */