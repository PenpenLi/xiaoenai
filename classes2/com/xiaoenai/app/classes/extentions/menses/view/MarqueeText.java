package com.xiaoenai.app.classes.extentions.menses.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeText
  extends TextView
  implements Runnable
{
  private int a;
  private boolean b = false;
  private int c;
  private boolean d = false;
  
  public MarqueeText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MarqueeText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void getTextWidth()
  {
    this.c = ((int)getPaint().measureText(getText().toString()));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.d)
    {
      getTextWidth();
      this.d = true;
    }
  }
  
  public void run()
  {
    this.a += 1;
    scrollTo(this.a, 0);
    if (this.b) {
      return;
    }
    if (this.a >= this.c) {
      this.a = (-getWidth());
    }
    postDelayed(this, 16L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\view\MarqueeText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */