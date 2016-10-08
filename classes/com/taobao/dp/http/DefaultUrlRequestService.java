package com.taobao.dp.http;

import com.taobao.wireless.security.adapter.common.b;
import com.taobao.wireless.security.adapter.common.c;

public class DefaultUrlRequestService
  implements IUrlRequestService
{
  public void sendRequest(String paramString1, String paramString2, IResponseReceiver paramIResponseReceiver)
  {
    paramString1 = c.a(paramString2);
    paramIResponseReceiver.onResponseReceive(paramString1.b(), paramString1.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\http\DefaultUrlRequestService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */