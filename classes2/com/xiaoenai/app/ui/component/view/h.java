package com.xiaoenai.app.ui.component.view;

class h
  implements Runnable
{
  h(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void run()
  {
    SwipeRefreshLayout.a(this.a, true);
    SwipeRefreshLayout.a(this.a, SwipeRefreshLayout.g(this.a) + this.a.getPaddingTop(), SwipeRefreshLayout.h(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */