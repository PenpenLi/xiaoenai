package com.inmobi.signals;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.uid.d;
import java.util.Map;
import org.json.JSONObject;

public class k
  extends NetworkRequest
{
  private static final String d = k.class.getSimpleName();
  private int e;
  private int f;
  private l g;
  
  public k(String paramString, int paramInt1, int paramInt2, d paramd, l paraml)
  {
    super(NetworkRequest.RequestType.POST, paramString, true, paramd);
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paraml;
    paramString = this.g.a().toString();
    this.c.put("payload", paramString);
    Logger.a(Logger.InternalLogLevel.INTERNAL, d, "Ice payload being sent:" + paramString);
  }
  
  public int b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */