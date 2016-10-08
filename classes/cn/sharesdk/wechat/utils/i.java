package cn.sharesdk.wechat.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.a.a;
import com.mob.tools.b.e;
import java.util.ArrayList;
import java.util.HashMap;

class i
  extends Thread
{
  i(g paramg, PlatformActionListener paramPlatformActionListener) {}
  
  public void run()
  {
    try
    {
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new com.mob.tools.a.i("access_token", g.a(this.b).getDb().getToken()));
      ((ArrayList)localObject).add(new com.mob.tools.a.i("openid", g.a(this.b).getDb().get("openid")));
      localObject = g.c(this.b).a("https://api.weixin.qq.com/sns/userinfo", (ArrayList)localObject, "/sns/userinfo", g.b(this.b));
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.a == null) {
          return;
        }
        this.a.onError(g.a(this.b), 8, new Throwable());
        return;
      }
      cn.sharesdk.framework.utils.d.a().d("getUserInfo ==>>" + (String)localObject, new Object[0]);
      localObject = new e().a((String)localObject);
      if ((((HashMap)localObject).containsKey("errcode")) && (((Integer)((HashMap)localObject).get("errcode")).intValue() != 0))
      {
        if (this.a == null) {
          return;
        }
        localObject = new e().a((HashMap)localObject);
        this.a.onError(g.a(this.b), 8, new Throwable((String)localObject));
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable1);
      return;
    }
    String str1 = String.valueOf(localThrowable1.get("openid"));
    String str2 = String.valueOf(localThrowable1.get("nickname"));
    try
    {
      i = com.mob.tools.b.g.d(String.valueOf(localThrowable1.get("sex")));
      String str3 = String.valueOf(localThrowable1.get("province"));
      String str4 = String.valueOf(localThrowable1.get("city"));
      String str5 = String.valueOf(localThrowable1.get("country"));
      String str6 = String.valueOf(localThrowable1.get("headimgurl"));
      String str7 = String.valueOf(localThrowable1.get("unionid"));
      g.a(this.b).getDb().put("nickname", str2);
      if (i == 1)
      {
        g.a(this.b).getDb().put("gender", "0");
        g.a(this.b).getDb().putUserId(str1);
        g.a(this.b).getDb().put("icon", str6);
        g.a(this.b).getDb().put("province", str3);
        g.a(this.b).getDb().put("city", str4);
        g.a(this.b).getDb().put("country", str5);
        g.a(this.b).getDb().put("openid", str1);
        g.a(this.b).getDb().put("unionid", str7);
        this.a.onComplete(g.a(this.b), 8, localThrowable1);
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable2);
        int i = 2;
        continue;
        if (i == 2) {
          g.a(this.b).getDb().put("gender", "1");
        } else {
          g.a(this.b).getDb().put("gender", "2");
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\wechat\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */