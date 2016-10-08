package com.alibaba.sdk.android.webview.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class HandWriter
  extends View
{
  private int bitmapHeight = 0;
  private int bitmapWidth = 0;
  private int canvasHeight = 0;
  private Canvas canvasOfBitmap = null;
  private int canvasWidth = 0;
  private float clickX = 0.0F;
  private float clickY = 0.0F;
  private int color = -65536;
  private boolean isMove = false;
  private LinearLayout linearLayout;
  private Bitmap newBitmap = null;
  private Bitmap originBitmap = null;
  private Paint paint = null;
  private float startX = 0.0F;
  private float startY = 0.0F;
  private float strokeWidth = 3.0F;
  
  public HandWriter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void clear()
  {
    this.newBitmap = Bitmap.createBitmap(this.originBitmap);
    invalidate();
  }
  
  public Bitmap getNewBitmap()
  {
    return this.newBitmap;
  }
  
  public Bitmap handWriting(Bitmap paramBitmap)
  {
    this.canvasOfBitmap.setBitmap(paramBitmap);
    if (this.isMove) {
      this.canvasOfBitmap.drawLine(this.startX, this.startY, this.clickX, this.clickY, this.paint);
    }
    this.startX = this.clickX;
    this.startY = this.clickY;
    return paramBitmap;
  }
  
  public void initBitmap(Bitmap paramBitmap, LinearLayout paramLinearLayout)
  {
    this.linearLayout = paramLinearLayout;
    this.originBitmap = resizeBitmap(paramBitmap);
    this.newBitmap = Bitmap.createBitmap(this.originBitmap);
    this.bitmapWidth = this.originBitmap.getWidth();
    this.bitmapHeight = this.originBitmap.getHeight();
    this.paint = new Paint();
    this.paint.setColor(this.color);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setAntiAlias(true);
    this.canvasOfBitmap = new Canvas();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.canvasHeight == 0) || (this.canvasWidth == 0))
    {
      this.canvasWidth = this.linearLayout.getWidth();
      this.canvasHeight = this.linearLayout.getHeight();
    }
    paramCanvas.drawBitmap(handWriting(this.newBitmap), (this.canvasWidth - this.bitmapWidth) / 2, (this.canvasHeight - this.bitmapHeight) / 2, this.paint);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.clickX = (paramMotionEvent.getX() - (this.canvasWidth - this.bitmapWidth) / 2);
    this.clickY = (paramMotionEvent.getY() - (this.canvasHeight - this.bitmapHeight) / 2);
    if (paramMotionEvent.getAction() == 0)
    {
      this.isMove = false;
      this.startX = this.clickX;
      this.startY = this.clickY;
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.isMove = true;
      invalidate();
      return true;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.isMove = false;
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public Bitmap resizeBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = (WindowManager)getContext().getSystemService("window");
    int i = (int)(((WindowManager)localObject).getDefaultDisplay().getWidth() * 0.96D);
    int j = (int)(((WindowManager)localObject).getDefaultDisplay().getHeight() * 0.8D);
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    float f1 = i / k;
    float f2 = j / m;
    localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, true);
  }
  
  public void setStrokeStyle(float paramFloat)
  {
    this.strokeWidth = paramFloat;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\views\HandWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */