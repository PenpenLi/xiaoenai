package com.xiaoenai.app.ui.component.view.a;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class d
  extends ClickableSpan
{
  private boolean a;
  private a b;
  
  public d(a parama, boolean paramBoolean)
  {
    this.b = parama;
    this.a = paramBoolean;
  }
  
  public a a()
  {
    return this.b;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */