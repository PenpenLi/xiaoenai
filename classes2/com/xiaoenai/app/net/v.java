package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.d.ag;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class v
  extends y
{
  v(u paramu, long paramLong) {}
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.a.a(this.a, new w(this));
  }
  
  public void b()
  {
    a.d("发送失败，5秒后继续下个队列", new Object[0]);
    Xiaoenai.j().a(new x(this), 5000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */