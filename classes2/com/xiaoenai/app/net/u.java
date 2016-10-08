package com.xiaoenai.app.net;

import com.xiaoenai.app.d.a.b.b;
import com.xiaoenai.app.d.ag;
import com.xiaoenai.app.net.socket.f;
import com.xiaoenai.app.utils.f.a;

class u
  implements b.b<f>
{
  u(s params, ag paramag) {}
  
  public void a(long paramLong, f paramf)
  {
    if (paramf != null)
    {
      a.d("发送消息：{}", new Object[] { paramf.d() });
      paramf.a(new v(this, paramLong));
      paramf.a();
      return;
    }
    a.d("队列发送完毕", new Object[0]);
    s.a(this.b, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */