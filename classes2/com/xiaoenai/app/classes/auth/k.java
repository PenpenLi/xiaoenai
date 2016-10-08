package com.xiaoenai.app.classes.auth;

import android.view.View;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;
import java.util.HashMap;

class k
  implements PlatformActionListener
{
  k(SimpleLoginView paramSimpleLoginView, h paramh) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    SimpleLoginView.o(this.b).post(new n(this));
    a.a("onCancel", new Object[0]);
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    SimpleLoginView.o(this.b).post(new l(this, paramPlatform));
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    SimpleLoginView.o(this.b).post(new m(this));
    SimpleLoginView.m(this.b);
    if (paramPlatform != null) {
      paramPlatform.removeAccount();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */