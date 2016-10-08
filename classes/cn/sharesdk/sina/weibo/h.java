package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import java.util.HashMap;

class h
  implements AuthorizeListener
{
  h(f paramf, PlatformActionListener paramPlatformActionListener, Platform.ShareParams paramShareParams) {}
  
  public void onCancel()
  {
    if (this.a != null) {
      this.a.onCancel(f.c(this.c), 9);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    if (this.a != null)
    {
      paramBundle = new HashMap();
      paramBundle.put("ShareParams", this.b);
      this.a.onComplete(f.b(this.c), 9, paramBundle);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.onError(f.a(this.c), 9, paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\sina\weibo\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */