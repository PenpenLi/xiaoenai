package com.tonicartos.superslim;

import android.text.TextUtils;
import android.view.View;

public class g
{
  public final int a;
  public final boolean b;
  public final int c;
  public final String d;
  public final int e;
  public final int f;
  public final int g;
  public final int h;
  public final int i;
  final int j;
  final int k;
  LayoutManager.LayoutParams l;
  
  public g(LayoutManager paramLayoutManager, View paramView)
  {
    int m = paramLayoutManager.getPaddingStart();
    int n = paramLayoutManager.getPaddingEnd();
    this.l = ((LayoutManager.LayoutParams)paramView.getLayoutParams());
    if (this.l.a)
    {
      this.f = paramLayoutManager.getDecoratedMeasuredWidth(paramView);
      this.g = paramLayoutManager.getDecoratedMeasuredHeight(paramView);
      if ((!this.l.f()) || (this.l.g()))
      {
        this.c = this.g;
        if (!this.l.e) {
          break label240;
        }
        if ((!this.l.h()) || (this.l.g())) {
          break label232;
        }
        this.j = this.f;
        label120:
        if (!this.l.f) {
          break label262;
        }
        if ((!this.l.e()) || (this.l.g())) {
          break label254;
        }
        this.k = this.f;
      }
    }
    for (;;)
    {
      this.h = (this.k + n);
      this.i = (this.j + m);
      this.b = this.l.a;
      this.a = this.l.d();
      this.d = this.l.g;
      this.e = this.l.h;
      return;
      this.c = 0;
      break;
      label232:
      this.j = 0;
      break label120;
      label240:
      this.j = this.l.d;
      break label120;
      label254:
      this.k = 0;
      continue;
      label262:
      this.k = this.l.c;
      continue;
      this.c = 0;
      this.g = 0;
      this.f = 0;
      this.j = this.l.d;
      this.k = this.l.c;
    }
  }
  
  public int a()
  {
    return this.k + this.j;
  }
  
  public boolean a(LayoutManager.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams.h == this.e) || (TextUtils.equals(paramLayoutParams.g, this.d));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tonicartos\superslim\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */