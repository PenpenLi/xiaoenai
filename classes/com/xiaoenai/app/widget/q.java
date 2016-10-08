package com.xiaoenai.app.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.xiaoenai.app.utils.ab;

public class q
  extends Drawable
{
  private TextView a;
  private Paint b;
  private int c = 0;
  private int d;
  private int e;
  
  public q(TextView paramTextView)
  {
    this.a = paramTextView;
    this.d = paramTextView.getHeight();
    this.e = paramTextView.getWidth();
    this.b = new Paint();
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(Color.parseColor("#c7c7c7"));
    this.b.setAntiAlias(true);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 0;
    if (this.c <= 0) {}
    for (;;)
    {
      return;
      int k = this.a.getHeight() / this.c;
      int i = 0;
      while (i < k + 1)
      {
        j += this.c;
        int m = j - ab.a(4.0F);
        paramCanvas.drawLine(0.0F, m, this.e, m, this.b);
        i += 1;
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */