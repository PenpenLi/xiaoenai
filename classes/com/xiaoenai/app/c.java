package com.xiaoenai.app;

import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.stat.h;

class c
  implements Runnable
{
  c(Xiaoenai paramXiaoenai) {}
  
  public void run()
  {
    if ((Xiaoenai.a(this.a) != 0L) && (AppModel.getInstance().isLogined())) {
      com.xiaoenai.app.stat.c.a().a(501, (int)((System.currentTimeMillis() - Xiaoenai.a(this.a)) / 1000L));
    }
    Xiaoenai.a(this.a, 0L);
    h.a().a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */