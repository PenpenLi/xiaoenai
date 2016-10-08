package com.b.a.a;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class i
  extends HttpEntityEnclosingRequestBase
{
  public i() {}
  
  public i(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public String getMethod()
  {
    return "GET";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */