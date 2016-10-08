package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.uid.d;

public class b
  extends NetworkRequest
{
  private int d;
  private int e;
  
  public b(String paramString, int paramInt1, int paramInt2, d paramd)
  {
    super(NetworkRequest.RequestType.POST, paramString, true, paramd);
    this.d = paramInt1;
    this.e = paramInt2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */