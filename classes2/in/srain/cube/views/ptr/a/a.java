package in.srain.cube.views.ptr.a;

import android.graphics.PointF;

public class a
{
  protected int a = 0;
  private PointF b = new PointF();
  private float c;
  private float d;
  private int e = 0;
  private int f = 0;
  private int g;
  private int h = 0;
  private float i = 1.2F;
  private float j = 1.7F;
  private boolean k = false;
  private int l = -1;
  private int m = 0;
  
  public void a(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.k = true;
    this.h = this.e;
    this.b.set(paramFloat1, paramFloat2);
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    c(paramFloat3, paramFloat4 / this.j);
  }
  
  public void a(int paramInt)
  {
    this.i = (this.g * 1.0F / paramInt);
    this.a = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(a parama)
  {
    this.e = parama.e;
    this.f = parama.f;
    this.g = parama.g;
  }
  
  public boolean a()
  {
    return this.k;
  }
  
  public float b()
  {
    return this.j;
  }
  
  public void b(float paramFloat)
  {
    this.i = paramFloat;
    this.a = ((int)(this.g * paramFloat));
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, paramFloat1 - this.b.x, paramFloat2 - this.b.y);
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public final void b(int paramInt)
  {
    this.f = this.e;
    this.e = paramInt;
    a(paramInt, this.f);
  }
  
  public void c()
  {
    this.k = false;
  }
  
  protected void c(float paramFloat1, float paramFloat2)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
    l();
  }
  
  public void d()
  {
    this.m = this.e;
  }
  
  public void d(int paramInt)
  {
    this.l = paramInt;
  }
  
  public boolean e()
  {
    return this.e >= this.m;
  }
  
  public boolean e(int paramInt)
  {
    return this.e == paramInt;
  }
  
  public float f()
  {
    return this.i;
  }
  
  public boolean f(int paramInt)
  {
    return paramInt < 0;
  }
  
  public int g()
  {
    return this.a;
  }
  
  public float h()
  {
    return this.c;
  }
  
  public float i()
  {
    return this.d;
  }
  
  public int j()
  {
    return this.f;
  }
  
  public int k()
  {
    return this.e;
  }
  
  protected void l()
  {
    this.a = ((int)(this.i * this.g));
  }
  
  public boolean m()
  {
    return this.e > 0;
  }
  
  public boolean n()
  {
    return (this.f == 0) && (m());
  }
  
  public boolean o()
  {
    return (this.f != 0) && (r());
  }
  
  public boolean p()
  {
    return this.e >= g();
  }
  
  public boolean q()
  {
    return this.e != this.h;
  }
  
  public boolean r()
  {
    return this.e == 0;
  }
  
  public boolean s()
  {
    return (this.f < g()) && (this.e >= g());
  }
  
  public boolean t()
  {
    return (this.f < this.g) && (this.e >= this.g);
  }
  
  public boolean u()
  {
    return this.e > v();
  }
  
  public int v()
  {
    if (this.l >= 0) {
      return this.l;
    }
    return this.g;
  }
  
  public float w()
  {
    if (this.g == 0) {
      return 0.0F;
    }
    return this.e * 1.0F / this.g;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */