package in.srain.cube.views.ptr.header;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

class h
  extends Animation
{
  h(d paramd, d.c paramc) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f3 = (float)Math.toRadians(this.a.c() / (6.283185307179586D * this.a.h()));
    float f4 = this.a.f();
    float f1 = this.a.e();
    float f2 = this.a.i();
    float f5 = d.a().getInterpolation(paramFloat);
    this.a.c((0.8F - f3) * f5 + f4);
    f3 = d.b().getInterpolation(paramFloat);
    this.a.b(f3 * 0.8F + f1);
    this.a.d(0.25F * paramFloat + f2);
    f1 = d.c(this.b) / 5.0F;
    this.b.c(144.0F * paramFloat + 720.0F * f1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */