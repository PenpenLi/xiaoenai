package com.xiaoenai.app.classes.forum.a;

import android.os.Handler;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.forum.presenter.o.a;

class d
  implements o.a
{
  d(b paramb) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Xiaoenai.j().k().post(new e(this, paramInt2));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */