package com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

class a
  extends Shape
{
  a(AddFloatingActionButton paramAddFloatingActionButton, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    float f5 = this.a;
    float f6 = this.b;
    paramCanvas.drawRect(f1, f2 - f3, f4 - f5, this.c + f6, paramPaint);
    f1 = this.b;
    f2 = this.c;
    f3 = this.a;
    f4 = this.b;
    paramCanvas.drawRect(f1 - f2, f3, this.c + f4, this.d - this.a, paramPaint);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\ui\floatingactionbutton\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */