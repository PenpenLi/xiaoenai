package com.xiaoenai.app.widget.wheel.a;

import android.content.Context;

public class d
  extends b
{
  private int a;
  private int g;
  private String h;
  
  public d(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    super(paramContext);
    this.a = paramInt1;
    this.g = paramInt2;
    this.h = paramString;
  }
  
  public int a()
  {
    return this.g - this.a + 1;
  }
  
  public CharSequence a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < a()))
    {
      paramInt = this.a + paramInt;
      if (this.h != null) {
        return String.format(this.h, new Object[] { Integer.valueOf(paramInt) });
      }
      return Integer.toString(paramInt);
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */