package com.xiaoenai.app.widget.wheel;

class i
  implements f.a
{
  i(WheelView paramWheelView) {}
  
  public void a()
  {
    WheelView.a(this.a, true);
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    WheelView.a(this.a, paramInt);
    paramInt = this.a.getHeight();
    if (WheelView.a(this.a) > paramInt)
    {
      WheelView.b(this.a, paramInt);
      WheelView.b(this.a).a();
    }
    while (WheelView.a(this.a) >= -paramInt) {
      return;
    }
    WheelView.b(this.a, -paramInt);
    WheelView.b(this.a).a();
  }
  
  public void b()
  {
    if (WheelView.c(this.a))
    {
      this.a.b();
      WheelView.a(this.a, false);
    }
    WheelView.b(this.a, 0);
    this.a.invalidate();
  }
  
  public void c()
  {
    if (Math.abs(WheelView.a(this.a)) > 1) {
      WheelView.b(this.a).a(WheelView.a(this.a), 0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */