package com.xiaoenai.app.classes.chat.input.faces;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.gif.GifView;

public class p
{
  private PopupWindow a;
  private Context b;
  private GifView c;
  private TextView d;
  private View e;
  private int f;
  private int g;
  private int h = -1;
  
  public p(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void c()
  {
    View localView = LayoutInflater.from(this.b).inflate(2130903098, null);
    this.e = localView.findViewById(2131558781);
    this.c = ((GifView)localView.findViewById(2131558782));
    this.d = ((TextView)localView.findViewById(2131558783));
    this.a = new PopupWindow(localView, -2, -2, true);
    this.a.setOutsideTouchable(true);
    this.a.setBackgroundDrawable(new ColorDrawable(0));
    this.a.setAnimationStyle(2131296599);
    this.e.measure(0, 0);
    this.g = this.e.getMeasuredHeight();
    this.f = this.e.getMeasuredWidth();
  }
  
  public void a()
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing()))
      {
        this.a.dismiss();
        this.c.g();
        this.c.i();
        this.c.setImageBitmap(null);
      }
      this.h = -1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(View paramView, String paramString, int paramInt)
  {
    if (this.a == null) {
      c();
    }
    this.h = paramInt;
    paramInt %= 4;
    if (paramInt == 0) {
      this.e.setBackgroundResource(2130837659);
    }
    for (;;)
    {
      this.a.showAsDropDown(paramView, -(this.f / 2 - paramView.getWidth() / 2), -(this.g + paramView.getHeight()));
      if (paramString.endsWith("gif")) {
        break;
      }
      this.c.g();
      this.c.i();
      b.a(this.c, paramString, Boolean.valueOf(true));
      return;
      if (paramInt == 3) {
        this.e.setBackgroundResource(2130837660);
      } else {
        this.e.setBackgroundResource(2130837661);
      }
    }
    b.a(paramString, new q(this), true, true);
  }
  
  public int b()
  {
    return this.h;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */