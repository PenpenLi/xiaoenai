package com.xiaoenai.app.classes.home.view.wiget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.xiaoenai.app.R.styleable;

public class RoundRectangleLayout
  extends LinearLayout
{
  private int a = 0;
  private int b;
  
  public RoundRectangleLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public RoundRectangleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public RoundRectangleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public RoundRectangleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null) {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundRectangleLayout);
    }
    try
    {
      this.a = paramContext.getDimensionPixelSize(1, 0);
      this.b = paramContext.getColor(0, -1);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a != 0)
    {
      Paint localPaint = new Paint();
      localPaint.setColor(this.b);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setAntiAlias(true);
      paramCanvas.drawCircle(this.a, this.a, this.a, localPaint);
      paramCanvas.drawCircle(getWidth() - this.a, this.a, this.a, localPaint);
      paramCanvas.drawCircle(this.a, getHeight() - this.a, this.a, localPaint);
      paramCanvas.drawCircle(getWidth() - this.a, getHeight() - this.a, this.a, localPaint);
      paramCanvas.drawRect(0.0F, this.a, getWidth(), getHeight() - this.a, localPaint);
      paramCanvas.drawRect(this.a, 0.0F, getWidth() - this.a, getHeight(), localPaint);
    }
  }
  
  public void setBackgroundColour(int paramInt)
  {
    this.b = paramInt;
    invalidate();
  }
  
  public void setRadius(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\wiget\RoundRectangleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */