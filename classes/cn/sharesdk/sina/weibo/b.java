package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.b.g;

class b
  implements AuthorizeListener
{
  b(SinaWeibo paramSinaWeibo, f paramf) {}
  
  public void onCancel()
  {
    if (SinaWeibo.h(this.b) != null) {
      SinaWeibo.i(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uid");
    String str2 = paramBundle.getString("access_token");
    String str3 = paramBundle.getString("expires_in");
    SinaWeibo.a(this.b).put("nickname", paramBundle.getString("userName"));
    SinaWeibo.b(this.b).put("remind_in", paramBundle.getString("remind_in"));
    SinaWeibo.c(this.b).putToken(str2);
    try
    {
      l = g.e(str3);
      SinaWeibo.d(this.b).putExpiresIn(l);
      SinaWeibo.e(this.b).putUserId(str1);
      this.a.b(str2);
      SinaWeibo.a(this.b, 1, null);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (SinaWeibo.f(this.b) != null) {
      SinaWeibo.g(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\sina\weibo\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */