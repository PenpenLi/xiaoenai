package com.mob.tools.a;

import java.io.InputStream;
import java.net.HttpURLConnection;

public class f
  implements d
{
  private HttpURLConnection a;
  
  public f(HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramHttpURLConnection;
  }
  
  public int a()
  {
    return this.a.getResponseCode();
  }
  
  public InputStream b()
  {
    return this.a.getInputStream();
  }
  
  public InputStream c()
  {
    return this.a.getErrorStream();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */