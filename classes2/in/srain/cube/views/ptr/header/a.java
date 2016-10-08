package in.srain.cube.views.ptr.header;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class a
  extends Animation
{
  a(MaterialHeader paramMaterialHeader) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    MaterialHeader.a(this.a, 1.0F - paramFloat);
    MaterialHeader.b(this.a).setAlpha((int)(255.0F * MaterialHeader.a(this.a)));
    this.a.invalidate();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */