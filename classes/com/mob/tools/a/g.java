package com.mob.tools.a;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class g
  extends HttpEntityEnclosingRequestBase
{
  public g() {}
  
  public g(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public String getMethod()
  {
    return "PATCH";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */