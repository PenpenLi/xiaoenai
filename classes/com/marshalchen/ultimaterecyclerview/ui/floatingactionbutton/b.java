package com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.OvershootInterpolator;

class b
  extends AddFloatingActionButton
{
  b(FloatingActionsMenu paramFloatingActionsMenu, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    this.a = FloatingActionsMenu.a(this.j);
    this.b = FloatingActionsMenu.b(this.j);
    this.c = FloatingActionsMenu.c(this.j);
    super.a();
  }
  
  @TargetApi(11)
  protected Drawable getIconDrawable()
  {
    FloatingActionsMenu.b localb = new FloatingActionsMenu.b(super.getIconDrawable());
    FloatingActionsMenu.a(this.j, localb);
    OvershootInterpolator localOvershootInterpolator = new OvershootInterpolator();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localb, "rotation", new float[] { 135.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localb, "rotation", new float[] { 0.0F, 135.0F });
    localObjectAnimator1.setInterpolator(localOvershootInterpolator);
    localObjectAnimator2.setInterpolator(localOvershootInterpolator);
    FloatingActionsMenu.d(this.j).play(localObjectAnimator2);
    FloatingActionsMenu.e(this.j).play(localObjectAnimator1);
    return localb;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\ui\floatingactionbutton\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */