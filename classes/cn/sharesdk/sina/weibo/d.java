package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.b.e;
import java.util.HashMap;

class d
  extends Thread
{
  d(c paramc, Platform paramPlatform, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = f.a(this.a);
      try
      {
        localObject1 = ((f)localObject1).a(this.a.getContext(), this.b);
        if (localObject1 == null)
        {
          c.b(this.c).onError(new Throwable("Authorize token is empty"));
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          c.a(this.c).onError(localThrowable1);
          localObject2 = null;
        }
        Object localObject2 = new e().a((String)localObject2);
        Bundle localBundle = new Bundle();
        localBundle.putString("uid", String.valueOf(((HashMap)localObject2).get("uid")));
        localBundle.putString("remind_in", String.valueOf(((HashMap)localObject2).get("remind_in")));
        localBundle.putString("expires_in", String.valueOf(((HashMap)localObject2).get("expires_in")));
        localBundle.putString("access_token", String.valueOf(((HashMap)localObject2).get("access_token")));
        c.c(this.c).onComplete(localBundle);
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\sina\weibo\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */