package com.xiaoenai.tool.log;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class f
{
  private Context a;
  private WindowManager b;
  private View c;
  private WindowManager.LayoutParams d;
  
  public f(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      throw new RuntimeException("view is null");
    }
    this.a = paramContext;
    this.b = ((WindowManager)paramContext.getSystemService("window"));
    this.c = paramView;
    this.d = new WindowManager.LayoutParams();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = this.b.getDefaultDisplay().getWidth() / 2;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = this.b.getDefaultDisplay().getHeight() / 2;
    }
    this.d.width = i;
    this.d.height = paramInt1;
    this.d.gravity = 51;
    this.d.flags = 136;
    this.d.type = 2007;
    this.d.format = -3;
    this.d.setTitle("SuspendWindow");
  }
  
  public void a()
  {
    this.b.updateViewLayout(this.c, this.d);
  }
  
  public void a(float paramFloat)
  {
    a((int)(0.5F + paramFloat));
  }
  
  public void a(int paramInt)
  {
    this.d.x = paramInt;
  }
  
  public void b()
  {
    c();
    this.b.addView(this.c, this.d);
  }
  
  public void b(float paramFloat)
  {
    b((int)(0.5F + paramFloat));
  }
  
  public void b(int paramInt)
  {
    this.d.y = paramInt;
  }
  
  public void c()
  {
    if ((this.c != null) && (this.c.getParent() != null)) {
      this.b.removeView(this.c);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\tool\log\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */