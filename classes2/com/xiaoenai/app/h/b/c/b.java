package com.xiaoenai.app.h.b.c;

import com.alimama.mobile.sdk.config.MmuController.InitAsyncComplete;

final class b
  implements MmuController.InitAsyncComplete
{
  public void onComplete(boolean paramBoolean)
  {
    com.xiaoenai.app.utils.f.a.c("AFP Init complete {}", new Object[] { Boolean.valueOf(paramBoolean) });
    a.a(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */