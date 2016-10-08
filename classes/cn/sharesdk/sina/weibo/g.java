package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;

class g
  implements SSOListener
{
  g(f paramf, AuthorizeListener paramAuthorizeListener) {}
  
  public void onCancel()
  {
    this.a.onCancel();
  }
  
  public void onComplete(Bundle paramBundle)
  {
    try
    {
      com.mob.tools.b.g.e(paramBundle.getString("expires_in"));
      this.a.onComplete(paramBundle);
      return;
    }
    catch (Throwable paramBundle)
    {
      onFailed(paramBundle);
    }
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    cn.sharesdk.framework.utils.d.a().w(paramThrowable);
    f.a(this.b, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\sina\weibo\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */