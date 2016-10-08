package com.taobao.dp.http;

import com.taobao.dp.b.i;

final class b
  implements IResponseReceiver
{
  b(a parama) {}
  
  public final void onResponseReceive(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a.a(this.a, paramInt, paramArrayOfByte);
    a.a(this.a).a(paramArrayOfByte);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\http\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */