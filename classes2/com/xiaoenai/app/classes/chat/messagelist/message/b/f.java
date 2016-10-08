package com.xiaoenai.app.classes.chat.messagelist.message.b;

import com.xiaoenai.app.classes.a.c;
import com.xiaoenai.app.classes.a.c.a;
import com.xiaoenai.app.classes.chat.messagelist.view.n;
import com.xiaoenai.app.utils.f.a;

final class f
  implements c.a
{
  f(com.xiaoenai.app.classes.chat.messagelist.message.model.d paramd, c paramc, n paramn) {}
  
  public void a() {}
  
  public void a(double paramDouble1, double paramDouble2, float paramFloat)
  {
    double d1 = this.a.s();
    double d2 = this.a.t();
    c localc = this.b;
    d1 = c.a(d1, d2, paramDouble1, paramDouble2);
    this.a.c(d1);
    this.a.b(paramDouble2);
    this.a.a(paramDouble1);
    a.c("sendExamineMsg {}", new Object[] { Long.valueOf(this.a.h()) });
    d.d(this.a, this.c);
  }
  
  public void b()
  {
    this.a.c(false);
    d.a(this.c.getContext());
  }
  
  public void c()
  {
    this.a.c(false);
    d.b(this.c.getContext());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */