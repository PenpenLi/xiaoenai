package in.srain.cube.views.ptr.header;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

public class j
  extends Animation
{
  public PointF a;
  public float b;
  private final Paint c;
  private float d;
  private float e;
  private PointF f;
  private PointF g;
  
  public void a(float paramFloat)
  {
    this.c.setAlpha((int)(255.0F * paramFloat));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
    super.start();
  }
  
  public void a(int paramInt)
  {
    this.b = (-new Random().nextInt(paramInt) + paramInt);
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.drawLine(this.f.x, this.f.y, this.g.x, this.g.y, this.c);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.d;
    a(f1 + (this.e - f1) * paramFloat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */