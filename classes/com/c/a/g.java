package com.c.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class g
  extends k
{
  private float g;
  private float h;
  private float i;
  private boolean j = true;
  
  public g(j.a... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public g a()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    j.a[] arrayOfa = new j.a[m];
    int k = 0;
    while (k < m)
    {
      arrayOfa[k] = ((j.a)((j)localArrayList.get(k)).e());
      k += 1;
    }
    return new g(arrayOfa);
  }
  
  public Object a(float paramFloat)
  {
    return Float.valueOf(b(paramFloat));
  }
  
  public float b(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((j.a)this.e.get(0)).f();
        this.h = ((j.a)this.e.get(1)).f();
        this.i = (this.h - this.g);
      }
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null) {
        return this.g + this.i * f1;
      }
      return ((Number)this.f.a(f1, Float.valueOf(this.g), Float.valueOf(this.h))).floatValue();
    }
    j.a locala;
    float f2;
    float f3;
    float f4;
    float f5;
    if (paramFloat <= 0.0F)
    {
      localObject = (j.a)this.e.get(0);
      locala = (j.a)this.e.get(1);
      f2 = ((j.a)localObject).f();
      f3 = locala.f();
      f4 = ((j.a)localObject).c();
      f5 = locala.c();
      localObject = locala.d();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.f == null) {
        return paramFloat * (f3 - f2) + f2;
      }
      return ((Number)this.f.a(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (j.a)this.e.get(this.a - 2);
      locala = (j.a)this.e.get(this.a - 1);
      f2 = ((j.a)localObject).f();
      f3 = locala.f();
      f4 = ((j.a)localObject).c();
      f5 = locala.c();
      localObject = locala.d();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.f == null) {
        return paramFloat * (f3 - f2) + f2;
      }
      return ((Number)this.f.a(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    for (Object localObject = (j.a)this.e.get(0); k < this.a; localObject = locala)
    {
      locala = (j.a)this.e.get(k);
      if (paramFloat < locala.c())
      {
        Interpolator localInterpolator = locala.d();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((j.a)localObject).c()) / (locala.c() - ((j.a)localObject).c());
        f1 = ((j.a)localObject).f();
        f2 = locala.f();
        if (this.f == null) {
          return (f2 - f1) * paramFloat + f1;
        }
        return ((Number)this.f.a(paramFloat, Float.valueOf(f1), Float.valueOf(f2))).floatValue();
      }
      k += 1;
    }
    return ((Number)((j)this.e.get(this.a - 1)).b()).floatValue();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */