package in.srain.cube.views.ptr.header;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class f
  extends Animation
{
  f(d paramd, d.c paramc) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = (float)(Math.floor(this.a.i() / 0.8F) + 1.0D);
    float f2 = this.a.e();
    float f3 = this.a.f();
    float f4 = this.a.e();
    this.a.b(f2 + (f3 - f4) * paramFloat);
    f2 = this.a.i();
    f3 = this.a.i();
    this.a.d((f1 - f3) * paramFloat + f2);
    this.a.e(1.0F - paramFloat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */