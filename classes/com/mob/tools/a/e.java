package com.mob.tools.a;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class e
  implements d
{
  private HttpResponse a;
  
  public e(HttpResponse paramHttpResponse)
  {
    this.a = paramHttpResponse;
  }
  
  public int a()
  {
    return this.a.getStatusLine().getStatusCode();
  }
  
  public InputStream b()
  {
    return this.a.getEntity().getContent();
  }
  
  public InputStream c()
  {
    return this.a.getEntity().getContent();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */