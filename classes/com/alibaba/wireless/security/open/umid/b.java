package com.alibaba.wireless.security.open.umid;

import com.taobao.dp.client.IInitResultListener;

final class b
  implements IInitResultListener
{
  b(IUMIDInitListenerEx paramIUMIDInitListenerEx) {}
  
  public final void onInitFinished(String paramString, int paramInt)
  {
    if (this.a != null) {
      this.a.onUMIDInitFinishedEx(paramString, paramInt);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\umid\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */