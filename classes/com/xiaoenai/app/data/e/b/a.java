package com.xiaoenai.app.data.e.b;

import android.content.Context;
import com.xiaoenai.app.data.entity.mapper.MessageEntityDataMapper;
import com.xiaoenai.app.domain.internal.di.PerActivity;
import com.xiaoenai.app.utils.d.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

@PerActivity
public class a
  implements com.xiaoenai.app.domain.e.b
{
  private final Context a;
  private final MessageEntityDataMapper b;
  private final com.xiaoenai.app.domain.e.e c;
  private final com.xiaoenai.app.data.d.a d;
  
  @Inject
  public a(Context paramContext, MessageEntityDataMapper paramMessageEntityDataMapper, com.xiaoenai.app.domain.e.e parame, com.xiaoenai.app.data.d.a parama)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramMessageEntityDataMapper;
    this.c = parame;
    this.d = parama;
  }
  
  public rx.a<List<com.xiaoenai.app.domain.c.b>> a(long paramLong)
  {
    return rx.a.a(c.a(this, paramLong));
  }
  
  public rx.a<com.xiaoenai.app.domain.c.b> a(com.xiaoenai.app.domain.c.b paramb)
  {
    return rx.a.a(e.a(this, paramb));
  }
  
  public rx.a<List<com.xiaoenai.app.domain.c.b>> a(String paramString1, String paramString2)
  {
    return rx.a.a(b.a(this, paramString1, paramString2));
  }
  
  public void a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("首次关联时间", v.a(this.c.a().k()));
    localHashMap.put("name", this.c.a().c());
    localHashMap.put("avatar", this.c.a().d());
    localHashMap.put("ID", String.valueOf(this.c.a().a()));
    localHashMap.put("恩爱号", this.c.a().b());
    localHashMap.put("用户上次登录ip", this.c.a().n());
    localHashMap.put("在线时长", v.a(this.a, this.c.a().e()));
    localHashMap.put("用户注册时间", v.a(this.c.a().l()));
    localHashMap.put("用户的安装渠道", this.d.d());
    localHashMap.put("用户使用的设备", this.d.e());
    localHashMap.put("用户使用的设备系统版本号", this.d.f());
    localHashMap.put("用户使用的小恩爱版本", this.d.c());
    if (this.d.g())
    {
      str = "是";
      localHashMap.put("用户设备是否root或越狱", str);
      if (this.c.a().f() > 0)
      {
        localHashMap.put("另一半ID", String.valueOf(this.c.a().f()));
        localHashMap.put("另一半名称", this.c.a().h());
        localHashMap.put("另一半恩爱号", this.c.a().g());
        localHashMap.put("另一半在线时长", v.a(this.a, this.c.a().i()));
        localHashMap.put("另一半上次登录ip", this.c.a().o());
        localHashMap.put("另一半注册时间", v.a(this.c.a().m()));
        localHashMap.put("另一半的安装渠道", this.c.a().p());
        localHashMap.put("另一半的设备", this.c.a().r());
        localHashMap.put("另一半使用的设备系统版本号", this.c.a().s());
        localHashMap.put("另一半使用的小恩爱版本", this.c.a().t());
        if (!this.c.a().q().equals("0")) {
          break label566;
        }
      }
    }
    label566:
    for (String str = "是";; str = "否")
    {
      localHashMap.put("另一半设备是否root或越狱", str);
      com.xiaoenai.app.h.c.a.a().a(localHashMap);
      return;
      str = "否";
      break;
    }
  }
  
  public com.xiaoenai.app.domain.c.a b()
  {
    return this.b.transformAgent(com.xiaoenai.app.h.c.a.a().b());
  }
  
  public rx.a<List<com.xiaoenai.app.domain.c.b>> b(long paramLong)
  {
    return rx.a.a(d.a(this, paramLong));
  }
  
  public rx.a<com.xiaoenai.app.domain.c.b> b(com.xiaoenai.app.domain.c.b paramb)
  {
    return rx.a.a(f.a(this, paramb));
  }
  
  public rx.a<Integer> c()
  {
    return rx.a.a(g.a(this));
  }
  
  public void c(long paramLong)
  {
    com.xiaoenai.app.h.c.a.a().a(paramLong);
  }
  
  public void d(long paramLong)
  {
    com.xiaoenai.app.h.c.a.a().b(paramLong);
  }
  
  public boolean d()
  {
    return com.xiaoenai.app.h.c.a.a().c();
  }
  
  public String e()
  {
    return com.xiaoenai.app.h.c.a.a().d();
  }
  
  public String f()
  {
    return com.xiaoenai.app.h.c.a.a().e();
  }
  
  public void g()
  {
    com.xiaoenai.app.h.c.a.a().h();
  }
  
  public void h()
  {
    com.xiaoenai.app.h.c.a.a().i();
  }
  
  public void i()
  {
    com.xiaoenai.app.h.c.a.a().g();
  }
  
  public void j()
  {
    com.xiaoenai.app.h.c.a.a().f();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */