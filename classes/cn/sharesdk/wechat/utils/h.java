package cn.sharesdk.wechat.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.a.i;
import java.util.ArrayList;

class h
  extends Thread
{
  h(g paramg, String paramString, AuthorizeListener paramAuthorizeListener) {}
  
  public void run()
  {
    try
    {
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new i("appid", g.d(this.c)));
      ((ArrayList)localObject).add(new i("secret", g.e(this.c)));
      ((ArrayList)localObject).add(new i("code", this.a));
      ((ArrayList)localObject).add(new i("grant_type", "authorization_code"));
      try
      {
        localObject = g.c(this.c).a("https://api.weixin.qq.com/sns/oauth2/access_token", (ArrayList)localObject, "/sns/oauth2/access_token", g.b(this.c));
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.b.onError(new Throwable("Authorize token is empty"));
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        this.b.onError(localThrowable1);
        return;
      }
      if (!localThrowable2.contains("errcode")) {
        break label189;
      }
    }
    catch (Throwable localThrowable2)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable2);
      return;
    }
    if (this.b != null)
    {
      this.b.onError(new Throwable(localThrowable2));
      return;
      label189:
      g.a(this.c, localThrowable2);
      this.b.onComplete(null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\wechat\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */