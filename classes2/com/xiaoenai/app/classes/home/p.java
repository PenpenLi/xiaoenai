package com.xiaoenai.app.classes.home;

class p
  implements Runnable
{
  p(HomeActivity.b paramb) {}
  
  public void run()
  {
    if ((!this.a.a.isFinishing()) && (HomeActivity.h(this.a.a) != null) && (HomeActivity.h(this.a.a).isAdded())) {
      HomeActivity.h(this.a.a).i();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */