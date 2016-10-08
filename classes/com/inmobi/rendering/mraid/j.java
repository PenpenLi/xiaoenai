package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

public class j
{
  private static final String a = j.class.getSimpleName();
  private String b;
  private int c;
  private int d;
  private NetworkRequest e;
  
  public j(String paramString, int paramInt1, int paramInt2)
  {
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a()
  {
    if (this.b == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "MRAID Js Url provided is invalid.");
      return;
    }
    this.e = new NetworkRequest(NetworkRequest.RequestType.GET, this.b, false, null);
    new Thread(new j.1(this)).start();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */