package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.MobUIShell;
import com.mob.tools.a;
import com.mob.tools.b.e;
import com.mob.tools.b.g;
import java.util.HashMap;

public class h
  extends a
{
  private String a;
  private Platform b;
  private PlatformActionListener c;
  
  public void a(Platform paramPlatform, PlatformActionListener paramPlatformActionListener)
  {
    this.b = paramPlatform;
    this.c = paramPlatformActionListener;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void onCreate()
  {
    for (;;)
    {
      try
      {
        Object localObject = this.activity.getIntent();
        String str1 = ((Intent)localObject).getScheme();
        finish();
        if ((str1 == null) || (!str1.startsWith(this.a))) {
          break;
        }
        localObject = g.b(((Intent)localObject).getDataString());
        str1 = String.valueOf(((Bundle)localObject).get("result"));
        String str2 = String.valueOf(((Bundle)localObject).get("action"));
        if (("shareToQQ".equals(str2)) || ("shareToQzone".equals(str2)))
        {
          if (!"complete".equals(str1)) {
            continue;
          }
          if (this.c != null)
          {
            localObject = String.valueOf(((Bundle)localObject).get("response"));
            localObject = new e().a((String)localObject);
            this.c.onComplete(this.b, 9, (HashMap)localObject);
          }
        }
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setClass(this.activity, MobUIShell.class);
        ((Intent)localObject).setFlags(335544320);
        startActivity((Intent)localObject);
        return;
        if ("error".equals(str1))
        {
          if (this.c == null) {
            continue;
          }
          localObject = new Throwable(String.valueOf(((Bundle)localObject).get("response")));
          this.c.onError(this.b, 9, (Throwable)localObject);
          continue;
        }
        if (this.c == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
        return;
      }
      this.c.onCancel(this.b, 9);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\tencent\qq\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */